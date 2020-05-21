# Introduction to node.js and express

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
* There are also **routing middlewares**, these will use some sort of *http* verbage, eg. `app.[GET / POST / PUT / DELETE](path, callback);

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
