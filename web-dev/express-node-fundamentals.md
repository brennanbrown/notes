# Node.js and Express Fundamentals

## Introduction 

* **node.js** is one of the major platforms for the web. 
    - Enterprises like Uber, Netflix, Autodesk, Intuit and even the NASA are using it for important parts of their business. 
* **express** is the most commonly used web framework to use with Node.js.
    - Due to its minimalistic approach and ease of use, creating websites with it is easy and enjoyable.
* Different than other platforms, Node.js has an HTTP module built into its core.
    - Express utilizes the HTTP server in this core module, and at least during development, you don't need to set up a separate dedicated rep server to Express applications. 

**Why use Express instead of just deploying a static website?**

* If information changes within the website, it will most likely need to be changed in multiple places.
    - This can be done automatically with the use of Express.

### Good Packages to Have

*  **ESLint** is a so-called linter. It uses a rule set to enforce some coding style rules and also points out common coding mistakes.
    - To install: `npm install -D eslint`
    - To use: `npx eslint --init`
        - This also requires the `npx` package if you don't have it installed already.
    - Follow through the dialog options accordingly.
* **Prettier** is a tool that can format your code. In contrast to ESLint, which is more about code style and code mistakes. This is about keeping code formatting consistent.
    - To install and work with eslint: `npm install -D prettier eslint-config-prettier eslint-plugin-prettier`
* It's also important to note that these require you to download these as extensions in VSCode to function as well.

## Template Engines within Express

* When building a dynamic website, there's always some static HTML that should contain some dynamic data.
* Imagine you have some array that contains a list of persons and you want to output this on an HTML page. 
    - Maybe you already got the HTML from your designer. So, how can we combine our data with the provided HTML? 
    - This is where template engines come into play. They always provide some special syntax to work with dynamic data.
* Finally, we need something that does the actual work of pausing the template file, combining it with the provided dynamic data, and then rendering it to HTML. 
    - This is what the template engine does. 
* There are parts that appear throughout the sites like the hero section, the navigation, or the gallery. 
    - Using templates, we can split our layout into reusable parts and store them in separate template files and just include them into our page. 
    - By doing so, there is no redundancy. And, if we want to change the navigation, we do it at exactly one place.
* Express is agnostic when it comes to template engines. Any engine that provides a specific interface can be plucked into the framework. 
* **Embedded JavaScript templating** (https://ejs.co/) is a good engine to use, as it lets you use regular JavaScript as template language as you see here. 

> Full list of Template Engines that work with Express: https://expressjs.com/en/resources/template-engines.html

## Express Routes and Middleware

* Middlewares are key concepts of Express. Basically everything is built around them.
* Middlewares are defined on the application object and, in general, they use `app.use(callback). 
    - The callback will be executed for this given middleware, and the callback gets a request and a responsive check.
* Middlewares can also have paths, eg. `app.use(path, callback)`, this means the middleware will then be only executed if the URL matches a specific path.
* There are also **routing middlewares**, these will use some sort of *http* verbage, eg. `app.[GET / POST / PUT / DELETE](path, callback);`
*  HTTP is stateless, this means that it doesn't recognize a user between requests. 
    - To persist data for a user from request to request, we need sessions.
* Cookie sessions store the data we want to persist for a user encrypted on the client.
    - This needs to be encrypted, because we don't want the user to be able to see and manipulate what we store in that session. The encryption hides it from them.

What can Express middlewares do? 

* They run with your request, and they can *execute any code& in there. 
* They get the request and response object as arguments, and of course they can operate on them,
    - So this means they can, for instance, *change* the request object to parse maybe some information that is in there and stored in another variable. 
* They can also end the request-response cycle. 
    - This is mostly true for routing middlewares because in the end, a routing middleware will send something back to the browser and will so end the execution flow and the request. 
* Finally, they can also call the next middleware in the stack, this means if more middlewares are defined, a middleware can pass on the control flow to the next middleware.
* It's good practice is to group all route definitions into a file or directory structure of its own. 
    - Express Router lets you create SAP applications that listen on specific routes.

### Example Middleware

* Regular middlewares are defined on the application object with `.use`.
    - They support the callback that should be executed for each request, and this callback takes a request and a response argument and also a next argument. 
* Request and response are rich objects with several messages defined on them. 
* Most importantly, response gives us methods to finalize the request and send data back to the server.

```javascript

// General Middleware Example
app.use(req, res, next) =>
    // Do something!
    // Note: If next is not called, the request will hang,
    // resulting in the page not loading.
    return next();
});
```

### Example Routing Middleware

* In this case we have some call to /feedback of our page. 
    - A route is a specific middleware that contains an http verb.
    - Eg. When you simply open an URL in the browser, it's a `GET` request.
*  Next, we have the path (/feedback) the route should match against. So this route will only be executed when this given path matches
* Then there's the handler function that gets this request and response object, and this next object.

```javascript
// Or .post, .put, .delete, etc.
app.get('/feedback', (req, res, next) => {
    // Do something!
    return res.send('Hello!');
});
```

### Parameter Routes

* Express routes can contain parameters. 
    - This means that parts of the URL can be dynamic, and this dynamic parameters can then be used by the application.
- Using a column it identifies a parameter and the route will then match any string after speakers and store it in a variable called speaker name, and we can then use it, of course, inside of our handler function.

```javascript
app.get(,/speakers/:speakername', handler);

// You can also prepend with a question mark. 
// This will make the parameter optional. 
// Eg. It will then match /speakers, but also /speakers/alice
app.get(,/speakers/:speakername?', handler);
```

### Business Logic

*  Ideally, you want a central place where all the information and all data is stored. 
    - We need a way to retrieve this information to render into our template. 
    - In any dynamic website, you will find some kind of *business logic.*
* As a rule of thumb, a `data` or `database` folder will contain the information that will be stored by the server and have information pulled to the client's view. 
    - A `services` folder will contain the logic of extracting that data for the front-end accordingly. 
## Professional Templating

### Creating a Site-wide Layout

* Every section within a website is inside a CSS container is specific to a given page. 
    - The parts around it are the so-called layout. And the content of an individual page should ideally be loaded into this layout. 
    - Some template engines come with some layered concept out of the box, EJS doesn't. But it's easy to build something similar. 
* Create a new folder within the `views` directory called `layout`, to specifically contain only the sections that are universal and appear on every page.
    - This will reduce a lot of redundant html code.
* When working with external files, Eg. `/js/main.js`, make it absolute.
    - Remove the dot (previouisly `./js/main.js`) 
    - This is because the absolute path points to the root of a project when it's delivered via Express and it will work even when we are on a sub-page where the relative path would not point to the right location anymore. 
* With EJS, to add sections, use for example `<%- include(\`../pages/${template}\`) %>`
    - Use `<%-` to include the template unescaped.
    - If you would escape it, the raw html would be visible on the page, and not the parsed html.
* In the `index.js`, you would change it to `response.render('layout', { pageTitle: 'Example Text', template: 'index' });`
* Similarly, you can add any JavaScript to `scripts.ejs` as a parital as well.

### Using Paritals with EJS

* As developers, we know that it often helps to move recurring or just large sections of code into large functional units of their own. 
    - This removes redundancies and increases readability and reusability. 
* When creating templates, such functional units are often referred to as partials.
    - Eg. to change the navigation section, you have to scroll around to eventually find and edit it, making
* Start by creating a new folder in the `layout` directory calledc `partials` called `navigation.ejs`, for example.
* An important note that, when within a parital, a html file such as `./contact.html`, you would change it to just `/contact`.
* Similarly, to add the parital to a page, you would add `<%- include('./partials/navigation') %>`

### Template Variables in More Detail

* Template variables are the way to make any dynamic data available to templates and Express knows three different types depending on their *scope*:
    - First, you can set the variable directly These variables are only available to the particular template for this particular request. 
    - Second, Express also knows variables that are globally available to any template for a given request. So they are request global template variables, and they are set on the response object. Typically you would set that via middleware. 
    -  Lastly, there are also variables that are set during start up of the application, and then available for the whole lifecycle. This is done on the application object.
    - Eg. in `server.js` you would add `app.locals.siteName = 'Business Website';` and then `<%= siteName %>` to the `index.ejs`
        
```javascript

// Creating a dynamic template
app.use(async (request, response, next) => {
    try {
        const names = await.speakersService.getNames();
        response.locals.speakerNames = names;
        console.log(response.locals);
        return next();
    } catch (err) {
        return next(err);
    }
});
```

### Looping Through Lists in Templates

- Things get easier once the layout has been split into logical parts.
* First add the template tag `<%`, without an equal sign or a minus, because there is no direct output.
* For control structure, use bracket percent `{%<`, and add the appropiate elements.
* Like in Javascript, call a `forEach` on it.
    - And as it is with a `forEach` function, this takes a callback that gets, for each iteration, the current array item. 
    - And then I continue as if this would be regular Javascript, by adding curly brackets.
* The loop will run over the variable, which will, for each iteration, contain another element.
* Patterns within list and detail pages is very common. 
* There needs to be a way to let Express know which element it should show on the list/detail page, and this is where parameter routes come into place.

Example of using looping in `/views`:

```javascript
<% speakerNames.forEach(function (speaker) {%>
    <a class="dropdown-item" href="/speakers/<%=speaker.shortname%>"><%=speaker.name%></a>
<%})%>
```

Example of looping in `server.js`:

```html
nodule.exports = params => {
    const { speakersService = params;

    router.get('/', async (request, response) => {
        const topSpeakers = await speakersService.getList();
        console.log(topSpeakers);
        response.render('layout', { pageTitle: 'Welcome', template: 'index', topSpeakers });
});
}
```

* Make sure to add `<%- include(./partials/topSpeakers` to the top of the `index.ejs` in the `/pages` directory.

Associated file, `topSpeakers.ejs`:

```html
<div class="row">
  <% topSpeakers.forEach(function(speaker) {%>
  <div class="col-md text-center">
    <h4 class="speakerslist-title"><%=speaker.title%></h4>
    <div class="speakerslist-name">
      with
      <a href="/speakers/<%=speaker.shortname%>"><%=speaker.name%></a>
    </div>
    <p class="speakerslist-info mt-2">
      <a href="/speakers/<%=speaker.shortname%>">
        <img
          class="speakerslist-img rounded-circle"
          src="/images/speakers/<%=speaker.shortname%>_tn.jpg"
          alt="Photo of <%=speaker.name%>"
        />
      </a>
    </p>
  </div>
  <%})%>
</div>
```

## Error Handling

* Mistakes happen. Be it some syntax problem or a field database call. 
    - Your application will run into errors and if they aren't handled gracefully, the question isn't if but when some error will take down your website and you get an angry call from a client. 
    - There're a few patterns and good practices to gracefully deal with errors in Express. 
* Each middleware function can either send a response which ends the request cycle or call the next middleware in the chain using next. But what happens when an error occurs inside the middleware or route?
* When something goes wrong, just `throw` an error and Express will show some error message. This is true as long as you aren't in an asynchronous invocation.
    - An easy way to simulate asynchronicity in Node.js is to use the `setTimeout` function here.
* Because of this, a general rule is to never throw from your Express routes and middlewares because it can take down your whole application.

Error Handle Example:

```javascript
app.get('/throw', (request, response, next) => {
    setTimeout (() => {
        return next(throw new Error("Something went wrong!"));
    }, 500)
});
```

Proper Error Handle Example:

```javascript
app.use(async (request, response, next) => {
    try {
        const names = await speakersService.getNames();
        response.locals.speakerNames = names;
        return next();
    } catch (err) {
        return next(err);
    }
});

app.use((request, response, next) => {
    return next(createError(404, "File not found"));
});
  
app.use((err, request, response, next) => {
    response.locals.message = err.message;
    const status = err.status || 500;
    response.locals.status = status;
    response.status(status);
    response.render("error");
});
```

* By default, the error page looks pretty broken, there are no links back to safer grounds and the user that ends up there will likely leave.
    - To create your own error page, you must create a middleware that captures the 404 error.
* In order to make this page dynamic, make sure you add both `<%=status%>` and the respective `<%=message%>` to the page.

## Handling Form Data

* When looping through an item, you can utilize the corresponding JSON attributes and EJS will automatically parse them into the page.

Form Template Example:

```html
        <div class="feedback-items">
          <% feedback.forEach(function (item) {%>
          <div class="feedback-item item-list media-list">
            <div class="feedback-item media">
              <div class="feedback-info media-body">
                <div class="feedback-head">
                  <div class="feedback-title"><%=item.title%></div>
                  <small>by <%=item.name%></small>
                </div>
                <div class="feedback-message"><%=item.message%></div>
              </div>
            </div>
          </div>
          <%})%>
        </div>
```

### Handling POST Requests

* So far, this has demonstrated how to create a dynamic website that could display content that comes from some JSON file, but may be also stored in the database.
     - One reason to even create a dynamic website in the first place, though, is that the need to handle user data in the one or the other way.
* When dealing with forms, `method="POST"` must be an added attribute to make a request.
    - As well as `action="/feedback"`, which will be the URL the form data needs to be sent to.
    - If the `<input>` does not have a `name` attribute, that also needs to be added there, for each corresponding JSON attribute.
* How do we get this form data inside our POST route? 
    - Express is very modular and, out of the box, quite bare metal. 
    - To make it pass post bodies, we need another module that provides us with the request middleware called *Body Parser*.
* Using the developer tools within the browser, you should now be able to see the POST request and form data within the Network tab when at the assoicated URL.

### Validating and Sanitizing User Input

* We can now receive the form date of when a form is posted. 
    - How can we make sure that this date is complete and also doesn't contain malicious data, like JavaScript malware? 
    - Regardless of which measures you take in the browser to validate a form, a malicious user can always circumvent that. 
    - In short, you cannot trust data from the client. 
* This means that we need to add measures to the service site to make sure that the data the user sent to us is valid. 
    - And for that we will use the module, *express-validator*.
* This can be used within the route like so: `cost {check, validationResult } = require("express-validator");`
    -  This is a routing malware. This means it accepts the same request response and next signature like any other handler function.
* You have to store the errors on the session object, because to display the feedback page again.
    - This can be done like so: `return response.redirect("/feedback");
    - That's, in general, a good practice because every time you send a form, you want to avoid that a user can just hit the reload button to send it again. 
* All that is left for a working feedback page is calling the respective function to write the user-provided feedback to a file, which can also be done within the `route` file.

## Creating APIs

### Introduction to RESTful APIs

* REST stands for Representational State Transfer, and it defines a way for creating web services. 
    - Today, such RESTful services are the most commonly used pattern for APIs. 
    - You find courses dedicated to REST with Node.js in the library, yet in times of single-page apps, it's a common use case for Express.
* For example, you can use client-side JavaScript and the REST API to send feedback directly to a REST endpoint and also to update the webpage without reloading it.
* To take a step back and review HTTP verbs, `GET` is used when you simply request a page. 
    - `POST` is most commonly used for forums because it allows to send large amounts of data in the payload.
    - 'PUT` is nothing the browser uses, but it's part of the HTTP standard.
    - `DELETE` is also defined in the HTTP standard and not really used by browsers
    - There are a few more verbs, but these are the most common used ones in REST services.
*  What REST does is give those HTTP verbs a meaning, or in other words, a semantic. 
    -  `GET` requests a resource, `POST` creates a resource, `PUT` is usually used for updating a resource, and `DELETE` deletes a resource. 
    - The main difference between the regular route and the REST route is that the regular route will return you HTML in most cases, but REST returns data, and in most cases, this is formatted as JSON.
* REST is very commonly used when creating single-page applications. 
* Simply put, the initial request returns an initial document, this document usually contains a lot of JavaScript which is then used to actually render the HTML or the content into the page. 
    - All subsequent interactions with the web sets and the data behind it is done by a so-called XHR, sometimes referred to as AJAX, an API built into JavaScript on the browser to do HTTP requests. 
    - After that initial request, the page isn't reloaded anymore, but sends data to the back end when needed and is updated via JavaScript using the data received from the back end.

### CRUD

* When working with data, three operations are so common that they got their own acronym, it's create, update, and delete, in short, **CRUD**.
    - eg. If you would want to request all users, you would use something like `HTTP GET http://mysite.com/users`, which would give a JSON containing all users.
    - If you would want to create a new user, you would use something like `HTTP POST http://mysite.com/users`, which is a post request to this endpoint containing the payload for this user to create it. 
    - If you want to pull a specific user, you would use something like `HTTP GET http://mysite.com/users/42`, which is a GET request to a parameter route which contains maybe something like the user ID.
    - If you then wanted to update that user, you would use something like `HTTP PUT http://mysite.com/users/42`, the PUT request is very similar to the POST request, it also contains the payload, but the path now being used contains the user ID, so this will now manipulate the user object in the database, for instance.
    - Finally, if you wanted to delete a specific user, would you similarly use something like `HTTP DELETE http://mysite.com/users/42`, which would delete the user with that ID.

### Creating and Testing an API Endpoint

* Technically, a rest endpoint is no different from any other route in Express. The only difference is that is won't return an HTML page, but most likely, JSON.
* To begin, for example, you would add `router.post('/api');` to the end of your `/route` file to allow it to listen to that folder.
    - The same validation used beforehand can be used here as well, these validations can be moved outside to their own variable to reduce identical code.
* This will also require `appu.use(bodyParser.json());` within the `server.js` to properly parse the incoming JSON object.

API Example:

```javascript
// Requires a service like Postman for testing.
// eg. POST http://localhost:300/feedback/api

router.post('/api', validations, async (request, response, next) => {
    try {
        const errors = validationResult(request);
        // Additional error-handling since this is not within the browser.
        if (!errors.isEmpty()) {
            return response.json({errors: errors.array() });
        }
        const { name, email, title, message } = request.body;
        await feedbackService.addEntry(name, email, title, message);
        // Returns the updated list of feedback entries.
        const feedback = await feedbackService.getList();
        return response.json({feedback});
    } catch(err) {
        return next(err);
    }
});
```

### Add Client-side JavaScript

* It is important to now leverage those API endpoints that were created to send the form to the server using CHR, and to update the feedback shown on the page.
* Technically, we will first load the completely random page containing the JavaScript needed for those interactions.
    - From then, all subsequent requests will use the REST API. 
    - This combination of initial server-side rendering and client-side updates is very common in so-called Single-Page apps.
* Perhaps the easiest way to do this without using a framework such as React or Vue would be to use jQuery, a simple, but powerful, library that lets you do XHR requests and also easily lets us update the page via JavaScript.

