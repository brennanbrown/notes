# JavaScript Fundamentals

**Table of Contents:**

- [JavaScript Fundamentals](#javascript-fundamentals)
  - [Three Layers of Web Page Content](#three-layers-of-web-page-content)
  - [JavaScript vs. Java](#javascript-vs-java)
  - [ECMAScript](#ecmascript)
  - [Frameworks and Libraries](#frameworks-and-libraries)
    - [Example Code](#example-code)
  - [Variables](#variables)
  - [Data Types, Logic, Arrays](#data-types-logic-arrays)
    - [Methods and Properties in Arrays](#methods-and-properties-in-arrays)
  - [Functions and Objects](#functions-and-objects)
    - [Named Function Example](#named-function-example)
    - [Anonymous Function Example](#anonymous-function-example)
    - [Immediately Invoked Functional Expression Example](#immediately-invoked-functional-expression-example)
  - [Variable Scope](#variable-scope)
    - [ES2015: let and const](#es2015-let-and-const)
  - [Object-oriented Design](#object-oriented-design)

> What is JavaScript?

- **JavaScript** is a high-dynamic, untyped and interpreted programming language standardized in the ECMAScript language specification.
  - Alongside CSS and HTML, it is one of the three core technologies of world-wide-web content.

## Three Layers of Web Page Content

1. HTML Markup: The content layer
2. CSS Rules: Presentation layer
   - These two allow for the separation of concerns.
   - Presentational enhancement: Taking away CSS will not take away the content of the web page.
3. JavaScript acts as the interactive layer of the web page.
   - Technically, you should be able to access a web page without JavaScript, however with its growing popularity and ubiquity, that often does not occur.
   - Small programs that run in the browser that allow you to modify and change the HTML and CSS of the web page.

## JavaScript vs. Java

- Java and JavaScript are related to each other the way Ham is related to Hamster. Programmers were just obsessed with naming things after coffee in the 90's.
  - Java is a programming language used to write applications for computers and other devices.
  - JavaScript is a scripting language used to interact with content in a web browser (and more recently in other places.)
  - JavaScript was originally named Mocha, however the name changed when Sun Microsystems sought out to purchase the licensing of the language in order to make a scripting language that was complementary to Java.

## ECMAScript

- When it comes to JavaScript, there are many things referred to that's built on top of it.

  - ECMAScript 2015, ES6, TypeScript, CoffeeScript
  - Frameworks such as Angular.js and React
  - Libraries such as jQuery, etc.

- JavaScript conforms to the EXMAScript standard, a specification for interpreting code and languages like JavaScript.

  - ECMAScript itself is not a language but an evolving standard. There are all the weird numbers and names that come as a suffix after it.
  - Browsers use the ECMAScript specification to interpret JavaScript.
  - From the coder's perspective, JavaScript and ECMAScript are two sides of the same coin.
  - As of currently, ECMAScript 5.1 from 2011 is still the standard, but it is severely outdated.
  - ECMAScript 2015, aka ES6, is emerging as the new standard, however, not all browsers currently support all of its features.
  - In order to make scripts cross-browser compatible, developers have to run modern JavaScript through a transpiler like **Babel** that translates it into older JavaScript

- Meanwhile, ECMAScript 2016, or ES7, is in development, so by the time that ES2015 is implemented, people will be using Babel or a similar tool to write ES2016, which is really in the end, just more JavaScript.

## Frameworks and Libraries

- Something like **jQuery** is a **library** for JavaScript functions and commands that allow Javascript to do fancy things with less code.

  - It is an abstraction of the core language.
  - Introduces CSS-like syntax and several visual and UI enhancements.
  - Simplies the use of JavaScript in websites.

- Frameworks like AngularJS, React, and Vue.js are open-source front-end application frameworks that allow developers to build in-browser applications that generate websites with ease and allow for scalability.

  - Facebook, for example, runs on React. So whereas traditional technologies like PHP generate the pages and the server and send them to the browser, these frameworks run in the browser and pull just the data from the server. This makes the websites that run them really fast, but it has some significant drawbacks if the JavaScripts stops working or is disabled.

- JavaScript **Platforms** like Node.js are tools that allow JavaScript to act as a server site programming language, which actually goes against the idea that JavaScript is something that runs in the browser.

- Any time that a browser encounters a JavaScript file reference, it stops the rendering of the page until the script file is downloaded and executed.

- `HTTP/2` changes everything, or rather partially solves the issue by allowing the browser to download multiple assets in parallel.
  - Render blocking will still occur, it will just take less time to load.
  - Nowadays, there are several methods to JavaScript Loading, whether it's right away, asynchronous, or deferred.
  - If loaded right away, the HTML will be parsed until it encounters a reference to JS, and then download and execute it, after which the HTML parsing will continue.
  - By adding the `async` attribute, the JS will be downloaded alongside the HTML parsing, but the execution will still cause the parse to pause and then continue following.
  - If the script is set to `defer`, the JS will be downloaded alongside the HTML, however it will not execute until the rest of the HTML in finished parsing, even if the reference of the JS is in the `<head>`.

### Example Code

```html
<!DOCTYPE html>
<html lang="en-US">
  <head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width-device-width, initial-scale=1" />
    <title>An Example Page!</title>
  </head>

  <body></body>

  <!-- Internal Javascript -->
  <script>
    var date = new.Date();
    document.body.innerHTML("<h1>Today is: " + date + "</h1>");
  </script>

  <!-- External JavaScript -->
  <script src="script.js"></script>
</html>
```

- JavaScript is case-sensitive. Meaning `foobar` and `fooBar` as variables are entirely different. The only exception to this is strings of texts.
  - `Date` with a capital D is a constructor, whereas `date` would either be nothing or be a variable.
- The agreed upon naming convention is camelCase instead of kebab-case.
  - This is used in elements, variables, and many other things.
  - Objects and classes always start with a capital letter.
  - Constants are always completely upper-case.
- JavaScript doesn't care about whitespace, meaning it should be used for the sake of readability to yourself and others. It should also be used consistently--this results in code that's easy to maintain
- End every statement with a semicolon, in spite of the fact that it's not actually required by JavaScript, as it helps with readability as well.
- Use comments liberally. Leave notes to yourself and others regarding your code to make it easier to understand and explain.

## Variables

- Programming can be boiled down to a simple principle: Write something down, make some sort of change to it, then write the result down.
  - The power in programming lies in our ability to perform the same operation on many different objects or change that object itself over and over. So _storage containers_ are created as a way to hole these objects until they are needed, called **variables**.
  - Eg. `var = fooBar;`
- When a variable is first initialized, it is an empty contained that is undefined. You then assign something into it. Whether it's a value, object, or something else, this is done with the `=` sign.

```javascript
// Longhand
var a;
var b;
var sum;
a = 4;
b = 5;
sum = a + b;

// Shorthand
var a = 4;
var b = 5;
var sum = a + b;
```

- To avoid global scope, always **declare** your variables.
  - Eg. `var a = 5;` and not just `a = 5;`.

## Data Types, Logic, Arrays

- The data used and stored within variables in JavaScript falls into six primitive data types.
  - Numeric
  - String
  - Boolean
  - null
  - undefined
  - Symbol (New in ECMAScript 2015)

```javascript
if (some condition) {
    // Do something.
} else {
    // Do something else.
}

a = 5
b = "5"

// Due to lenient nature, will return true.
if ( a == b ) // Equality Statement

// Due to strict nature, will return false.
if ( a === b )

// AND Operator: Both conditions must be met.
if ( a == b && c == d )

// OR Operator: Only one condition must be met.
if ( a == b || c == d)

// XOR Operator: Either condition is met, but NOT both.
if ( (a==b || c==d) && ((a==b) != (c==d)) )

// Ternary Operator
// Ensure you add comments to explain the usage, as it is uncommon.
a == b ? console.log("Match!") : console.log("No Match!");
```

### Methods and Properties in Arrays

The **Array** is one of the cornerstones of JavaScript programming.

```javascript
// Longhand
var pens;
pen = ["red", "blue", "green", "orange"];

// Shorthand
pens = new Array("red", "blue", "green", "orange");

// Modifying and calling elements in the array:
pens[3] = "purple";
var fourthPen = pens[3];

// Arrays can have any data type within them.
mixedBag = new Array("String", 0, null, True, undefined);

console.log(pens);
console.log(mixedBag);
```

**Properties** are a type of meta-information about the object that can be retrieved and used. **Methods** are functions that belong to that object.

```javascript

// .length property of an array.
console.log("Array length: " pens.length);

// .reverse() method
pens.reverse();

// Remove the first value of an array:
pens.shift();

// Add a comma-separated list of values to the front of an array:
pens.unshift("purple", "black");

// Remove the last value of an array:
pens.pop();

// Add a comma-separated list of values to the end of an array:
pens.push("pink", "prussian blue");

// Creates a copy an array:
var newPens = pens.slice();
console.log("New pens: ", newPens);

// Find the specified position (pos) and remove n number
// of elements from an array:
pens.splice(pos, n);
// Eg. Remove the third element only.
pens.splice(3, 1);

// Returns the first element that matches the searched parameters:
var result = pens.indexOf(search, index);
// Eg. Variable result will be defined as "3" if found in
// the array starting at the first element (zero).
pens = new Array("red", "blue", "green", "orange");
var result = pens.indexOf("orange", 0);
console.log("The index position is: ", result);
console.log("The element is:", pens[result]);

// Return the items in an array as a comma-separated list.
var arrayString = pens.join(", ");
console.log("Strings from array: ", arrayString);
```

## Functions and Objects

- Computers are strict logic machines with zero common-sense. This means that they need to be provided with exact step-by-step instructions.
  - This is what a script is. A list of steps to be completed in specific order.
- With simple operations, this is relatively basic, however when a program is running hundreds of complex operations, JavaScript requires a way to make sense of each instruction.
- **Functions** are essentially mini-programs inside the scripts written, as they can be used to sensibly segment sections of different codes.
- Functions either create results immediately, like changing the contents of an element on a webpage.
  - Or provide an answer/output that can be utilized by other functions, called a _return value_.
- In JavaScript, there are three different types of functions:
  - **Named Functions:** Which are executed when called by name.
  - **Anonymous Functions:** Which typically run once they are triggered by a specific event.
  - **Immediate Function Expressions**: Invoked and run by the browser as soon as they are encountered on the page.
- Every function comes with an argument's objects, an array of possible arguments that you can pass to the function when you call it.
  - These arguments are separated by commas `(a, b)` and can be used inside the function itself based on their names in the function declaration.
- Functions can return values to where they were called from using the `return` keyword.
  - Whatever is returned in not executed directly, but instead _captured_ in a variable, or used immediately in another function.

```javascript
// Regular function, called explicitly by name.
function multiply(a, b) {
  var result = a * b;
  console.log(result);
  return result;
}

var product = multiply(3, 4);

// Anonymous function stored in variable.
// Invoked by calling the variable as a function.
var quotient = function () {
  var a;
  var b;
  var result = a / b;
  console.log(a, " divided by ", b, " equals: ", result);
};

quotient();

// Immediately invoked function expression.
// Runs as soon as browser finds it.
(function () {
  var a;
  var b;
  var result = a / b;
  console.log(a, " divided by ", b, " equals: ", result);
})();
```

### Named Function Example

- The purpose of a named function is to define in the code and then call it when needed, by referencing its name and passing some arguments to it.
- Named functions are useful if you need to call a function many times to pass different values to it, or just need to run it several times.
  - It's also useful when functions get really big and clutter up the overall flow of the script.
  - In that case, we create functions and put them above the main script to be called when needed.

```javascript
// Function to display which fraction is larger,
// using the Ternary operator.
function findBiggestFraction(a, b) {
  var result;
  a > b ? (result = ["firstFraction", a]) : (result = ["secondFraction, b"]);
  return result;
}

// Make sure you define your variables
// before calling the method.
var firstFraction = 3 / 4;
var secondFraction = 5 / 7;

var fractionResult = findBiggestFraction(firstFraction, secondFraction);
console.log(fractionResult);

console.log("First fraction result: ", firstFraction);
console.log("Second fraction result: ", secondFraction);
console.log(
  "Fraction " + fractionResult[0] + "With a value of: ",
  fractionResult[1] + " is the biggest!"
);
```

### Anonymous Function Example

- Anonymous functions don't have names, so they need to be tied to something, a variable, or an event, or something similar to run.

```javascript
var theLargest = function (a, b) {
  var result;
  a > b ? (result = ["a", a]) : (result = ["b", b]);
  return result;
};

console.log(theLargest(7 / 3, 30 / 12));
```

### Immediately Invoked Functional Expression Example

- The benefit of this type of function is that it runs immediately where it's located in the code, and produces a direct output.
  - That means, on first run, it is unaffected by code which appears further down in the script, which can be useful.
  - These functions are great for quickly populating a variable or argument in a larger function or a property in an object, and are often hooked to event listeners for an immediate output.
- However, when you use these, you need to be very careful about how you structure your script.
  - They are invoked immediately, they don't wait for you to call the biggest variable, they just run as soon as the browser encounters them.

```javascript

// Variables have to be defined before listing out
// immediately invoked function expressions.
var firstFraction = 3/4;
var secondFraction = 5/7;

var theLargest = (function(a, b) {
    var result;
    a>b ? result = ["a", a] : result = ["b", b];
    return result;
})(firstFraction, secondFraction);

console.log(theLargest;

```

## Variable Scope

- When working with functions, it's important to understand the concept of **variable scope**, where in your code your variable is available for use.
- In JavaScript, the location of your variable declaration decides where it can be used in your code.
- There are two types of variable scopes: **global** and **local**.
  - When you declare a variable in the root of your script, or rather, independent of any function, it becomes a global variable that can be accessed anywhere within the script.
    - This means that you can use it, update its value, or do whatever you want with it in both the root of the script as well as within any function.
  - In contrast, when you define a variable within a function, it becomes a local variable. This variable is only available as long as you're inside the function.
    - If attempting to call or use this variable from outside the function it was defined in, there will be an error.
- Variables are far more useful within a local scope, as then they only exist for as long as the function runs, and then are discarded, which means the name can be used over and over again.
- The one exception to this is if a variable is not declared using `var`, as all variables without this prefix will be global, even within a function. This is very bad practice.

### ES2015: let and const

- With the new updates in ES2015, or ES6, there are two new types of variables in addition to `var`.
  - `const` is for constants, and cannot be changed once defined.
    - Useful when performing math equations.
    - Attempting to change a constant within a script will halt the rest of the script from continuing.
  - `let` is a block-scope variable, which means it has a smaller scope than var does.
    - This is very handy when working with nested functions, loops, and closures,

```javascript
function logScope() {
  var localVar = 2;

  if (localVar) {
    let localVar = "I'm different!";
    console.log("nested localVar: ", localVar);
  }

  console.log("logScope localVar: ", localVar);
}
```

## Object-oriented Design

- **Objects** are data models that allow you to combine properties and methods for a specific data set in a structured way.
  - Although JavaScript is a object-oriented language, it has a looser attitude towards objects than most other OO languages.

```javascript

// Longhand
var course = new Object();
course.title = "JavaScript Essential Training";
course.instructor = "Morten Rand-Hendriksen";
course.level = 1;
course.published = true;
course.views = 0;

// Shorthand
var course = {
    title = "JavaScript Essential Training";
    instructor = "Morten Rand-Hendriksen";
    level = 1;
    published = true;
    views = 0;
    updateViews: function() {
        return ++course.views;
    }
}

console.log(course, instructor);
course.updateViews();
```
