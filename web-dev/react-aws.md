---
layout: default
title: React on Amazon Web Services
parent: Web Development
---

**Table of Contents:**

- [Hosting on AWS](#hosting-on-aws)
- [User Authentication](#user-authentication)
- [DynamoDB API with APISync](#dynamodb-api-with-apisync)
- [AppSync GraphQL Calls with React](#appsync-graphql-calls-with-react)

## Hosting on AWS

- Every project needs a lot of pieces that are just necessary.
  - Hosting, user accounts, database, APIs, and more.
  - AWS can help with those pieces and make it easy and fast.
  - Eg. Adding hosting, user authentication, and a back-end database to a React app.
- AWS S3 Hosting with Amplify:
  - Install the amplify CLI tools: `npm install -g @aws-amplify/cli`
  - Configure your AWS on your local machine: `amplify configure`
  - Initialize the new project on AWS: `amplify init`
  - Host the project online: `amplify hosting add`
  - View the bucket: <https://s3.console.aws.amazon.com/s3/home>
  - Add Amplify module to your React project: `npm add aws-amplify aws-amplify-react --save`
  - View local changes that have been made: `amplify status`
  - `amplify push` will build all your local backend resources and provision it in the cloud
  - `amplify publish` will build all your local backend and frontend resources (if you have hosting category added) and provision it in the cloud

## User Authentication

- User authentication: The ability for users to create accounts and log-in with those accounts.
  - The idea, or the goal, is that the user eventually be able to access AWS Services so they can query the database,
  - Or whatever they need to do based on what the app is going to do.
- The service that's going to be used for that is called **Cognito**.
  - Specifically you're going to need the identity pool to be able to validate the users. That's what gives them access into the services.
  - A Cognito identity pool has two roles, unauthenticated and authenticated.
  - If you want to allow unauthenticated users to have access then you give permissions in **IAM** to the role set up in that identity pool. Same for authenticated users.
- Eg. have an app that just does weather and lets people search based on a zip code.
  - You may not want to make them log in so the unauthenticated role could have certain permissions.
  - But then if they log in they can store that data in the database, then you would need to give other permissions to the authenticated role in the identity pool.
- But how does the user get into the identity pool?
  - The identity pool has what are called identity providers.
  - These can be either Facebook, Amazon Login, Google, Twitter, or your custom ones that use SAML or Open ID Connect.
- To add authentication to the project: `amplify add auth`.

Adding user authetication to React:

```js
import Auth from "aws-amplify";
import awsconfig from "./aws-exports";
import { withAuthenticator } from "aws-amplify-react";
// CSS for AWS modules:
import "@aws-amplify/ui/dist/style.css";

Auth.configure(awsconfig);

// --- Code Here ---

export default withAuthenticator(App, { includeGreetings: true });
```

## DynamoDB API with APISync

- AppSync is great for writing APIs to various data sources.
- Specifically, it generates an API for your project, it's GraphQL API, and then connect them to a DynamoDB table.
  - Eg. This allows you to run mutations in the AppSync Queries area to update data in your tables.
- The API has a schema, and this defines all the different types of queries and what data's needed to pass in.
  - Eg. Get the model type, or list model types.
  - You also can create subscriptions. Subscriptions are very powerful, you can subscribe to data and get pushed from the server updates when any data is created, updated or deleted.
  - You can also add new items, you can update items, you can create and you can delete items, and then you can run _mutations_, which actually performs those things.
  - There's also data sources, such as a DynamoDB table.
  - You can also monitor your API for calls here and also in AWS CloudWatch.
- To add API to the project: `amplify add api`

Example Query:

```php
mutation createMyModelType($createmymodeltypeinput: CreateMyModelTypeInput!) {
  createMyModelType(input: $createmymodeltypeinput) {
    id
    title
  }
}

query listMyModelTypes {
  listMyModelTypes {
    items {
      id
      title
    }
  }
}
```

Query Variables:

```json
{
  "createmymodeltypeinput": {
    "title": "Hello, world!"
  }
}
```

Output:

```json
{
  "data": {
    "createMyModelType": {
      "id": "babb8aae-e17a-4911-94eb-89cdc1289a5a",
      "title": "Hello, world!"
    }
  }
}
```

## AppSync GraphQL Calls with React

Now that you have the API all set up in AppSync to talk to our dynamo DB table, you want to focus on the code.

Configuring API and GraphQL into your React App:

```javascript
import { Auth, API, graphqlOperation } from "aws-amplify";
import * as queries from "./graphql/queries";

API.configure(awsconfig);
```

CRUD Functions Example:

```javascript
function updateTodo(todo, newDescription) {
  todo["description"] = newDescription;
  API.graphql(graphqlOperation(mutations.updateTodo, { input: todo }));
}

function deleteTodo(todo) {
  API.graphql(
    graphqlOperation(mutations.deleteTodo, { input: { id: todo["id"] } })
  );
}
```

CRUD Functionality within `App()` Example:

```javascript
const updateFunction = true;
const deleteFunction = false;
const allTodos = API.graphql(graphqlOperation(queries.listTodos));
console.log(allTodos);

const oneTodo = API.graphql(
  graphqlOperation(queries.getTodo, {
    id: "32fb0768-0cb9-4391-b093-f963babeb5cd",
  })
).then(function (todo) {
  if (updateFunction === true) {
    updateTodo(todo["data"]["getTodo"], "New Description");
  }
  if (deleteFunction === true) {
    deleteTodo(todo["data"]["getTodo"]);
  }
});
console.log(oneTodo);

Auth.currentAuthenticatedUser({
  bypassCache: false,
})
  .then(function (user) {
    console.log("User: " + JSON.stringify(user));
    const todo = { name: user["username"], description: "new todo" };
    const newTodo = API.graphql(
      graphqlOperation(mutations.createTodo, { input: todo })
    );
    console.log(newTodo);
  })
  .catch((err) => console.log(err));
```
