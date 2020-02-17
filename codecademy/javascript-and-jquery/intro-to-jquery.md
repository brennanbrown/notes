# Making an Interactive Website with Javascript + jQuery #

<!-- MarkdownTOC -->

- Introduction
- Your first program
- HTML
  - Example
- app.js
- main\(\)
  - Example
- $\(document\).ready\(\)
  - Example
- Summary
- Notes
  - Program Skeleton
  - Selecting an Element
  - Responding to a Click
  - Open the Menu
  - Review
  - Close the Menu
- Example Code
  - app.js
  - index.html
  - style.css

<!-- /MarkdownTOC -->


## Introduction ##

Web pages made with HTML and CSS display static content. They don't respond to user actions like clicking a mouse or typing a key.

JavaScript and jQuery are used to make web pages interactive.

* JavaScript is a programming language used to create web pages that change in response to user actions.

* jQuery is a collection of prewritten JavaScript code that lets us easily create interactive effects on our site.

## Your first program ##

Click on Flipboard at the top of the web page to the right. The web page has a dropdown menu which shows and hides when you click Flipboard.

This interaction is made with JavaScript and jQuery.

## HTML ##

Here's what the web page's HTML looks like:

* To include CSS files in HTML we used the link element.

* Similarly, to include JavaScript files in HTML, we use the script element.

```html
<!doctype html>
<html>
  <head>
    <link href="style.css" rel="stylesheet">
  </head>
  <body>
    ...

    <script src="jquery.min.js"></script>
    <script src="app.js"></script>
  </body>
</html>
```

* To include CSS files in HTML, we use the link element. 
	* The link element tells the browser where to find a CSS file.

* Similarly, to include JavaScript files in HTML, we use the script element.

* The script element tells the browser where to find a JavaScript file. 
	* It has an attribute inside the opening `<script>` tag named `src`, which has the address of the JavaScript file.

* The first script loads in jQuery.

* The second script loads in app.js. 
	* This is where the code for the dropdown menu program lives.

### Example ###

When you click on Flipboard, a dropdown menu doesn't appear. To fix this, below the first script element, add a second script element with the `src` equal to `http://goo.gl/fxp6xh`. Then click on Flipboard to see the menu.

```html
<!doctype html>
<html>
  <body>
    ...

    <script src="http://goo.gl/1yIJUX"></script>
====<script src="http://goo.gl/fxp6xh"></script>====
    
  </body>
</html>
```

## app.js ##

The code for the dropdown menu lives in the JavaScript file app.js.

First we'll look at how this code is organized. The next cards will look at how this code works.

This code is read from top to bottom, and has two parts.

```javascript
var main = function() {
  $('.dropdown-toggle').click(function() {
    $('.dropdown-menu').toggle();
  });
}

$(document).ready(main);
```

* The code starts with a JavaScript function called `main()`. 
	* A **function** is a set of instructions that tells the computer to do something.

* The code then uses jQuery to run the `main()` function once the web page has fully loaded.

## main() ##

The `main()` function is made up of three parts.

First, the code selects the `<a class="dropdown-toggle">..</a>` element.

jQuery uses **selectors** to target HTML elements. jQuery selectors are based on CSS selectors.

```javascript
$('.dropdown-toggle')
```

Next, the code checks whether this HTML element has been clicked. If it has been clicked, the line of code inside the curly braces will run.

```javascript
.click(function() {
    $('.dropdown-menu').toggle();
  });
```

If clicked, the dropdown menu will alternate between showing and hiding, termed **toggling**.

```javascript
$('.dropdown-menu').toggle();
```

### Example ###

When you click on Flipboard, the dropdown menu shows up but doesn't go away. Change the jQuery method from `$(".dropdown-menu").show();` to `$(".dropdown-menu").toggle();` to toggle the dropdown menu. Then click on Flipboard once to make the menu appear, and again to make it disappear.

```javascript
var main = function() {
  $(".dropdown-toggle").click / hover(function() {
    $(".dropdown-menu").show / toggle();
  });
};

$(document).ready(main);
```

## $(document).ready() ##

The `$(document).ready()` waits for the HTML document to load completely before running the `main()` function.

**NOTE: **This is important because JavaScript should only run after the web page has loaded completely in the browser - otherwise there wouldn't be any HTML elements to add interactivity to.

```javascript
$(document).ready(main);
```

### Example ###

```javascript
var main = function() {
  (".dropdown-toggle").click( {
    (".dropdown-menu").toggle();
  });
};

(document).ready(main);
```

This program should toggle the dropdown menu when Flipboard is clicked. However, the program has four mistakes that prevent it from working. Find and fix these bugs to get the dropdown menu working again.

```javascript
var main = function() {
  $('.dropdown-toggle').click(function() {
    $('.dropdown-menu').toggle();
  });
};

$(document).ready(main);
```

## Summary ##

**JavaScript** is a programming language used to add interactivity to a web page. 

**jQuery** simplifies JavaScript syntax and makes it easier to build interactive web pages that work across multiple browsers.

jQuery enables us to do three main things on a web page:

* **Events**. Respond to user interactions.

* **DOM Manipulation**. Modify HTML elements on the page.

* **Effects**. Add animations.

We'll see how to do each of these things in the next sections.



## Notes ##


* The file **index.html** contains the page structure and content.
* The file **style.css** has the styling for the page.
* The file **app.js** has JavaScript and jQuery code. 
	* This code makes the menu interactive.

### Program Skeleton ###

The **index.html** file has two **script** elements right before the closing `</body>` tag:

* The first script loads jQuery.
* The second script loads app.js. The file app.js is where we'll write out code for the Uber menu.

```javascript
var main = function() {
};

$(document).ready(main);
```

### Selecting an Element ###

What does this skeleton do?

1. The `main` function is where we'll write our program.

2. The `$(document).ready` runs the `main` function as soon as the HTML document has loaded in the browser.

Let's start filling out the main function. Here, we'll select an HTML element in order to operate on it. jQuery lets us select HTML elements using CSS selectors.

**NOTE:** jQuery is all about the dollars! And to select a class, use a period (ie. full stop). 

```javascript
var main = function() {
    $('.icon-menu');
};

$(document).ready(main);
```

### Responding to a Click ###

We have just used jQuery to select the `'icon-menu'` class using `$('.icon-menu')`

Now we want to respond to user action.

Specifically we want to respond to a user clicking on this `'.icon-menu'` HTML element.

```javascript
var main = function() {
    $('.icon-menu').click();
};

$(document).ready(main);
```

**NOTE: **In the previous exercise, we selected the `.icon-menu`. Having done that, we want to be able to respond to the user clicking on this HTML element.

### Open the Menu ###

We now have code that says something will happen when the user clicks on the `icon-menu` HTML element. But what will happen?!

Clicking on the menu icon should open the menu.

1. Add a function inside the `.click()` method.

2. Select the 'menu' class and animate it.

3. Right now, the menu is 285px past the left edge of the screen. That's why it is not visible! Inside the animate method:

    1. move it 0px to the left
    2. make this happen over 200 milliseconds.

4. We now want to push the rest of the page to the left 285px. Use jQuery to select the body HTML element, animate it, and move it left 285px over 200 milliseconds.

**NOTE:** If you leave out step (4), we just push the menu over the top of the body of the page. 

```javascript
var main = function() {
    $('.icon-menu').click();
    $('.menu').animate({
        left: '0px'
    }, 200);
    
    $('body').animate({
        left: '285px'
    }, 200);
};

$(document).ready(main);
```

### Review ###

Great job! What have we accomplished so far?

1. First we selected the HTML element we wanted to operate on by using `$('.icon-menu')`.

2. Next we added `.click()`.

3. Then when the `.icon-menu `element is clicked, we used `.animate()` to push the menu and the body to the side - a **push effect**.

But we can't make the menu disappear yet!

### Close the Menu ###

Once the menu is open, we need a way to close it. Let's adapt the three steps we used to open the menu in order to close the menu.


1. Use jQuery to select the `'.icon-close'` element.

2. Add the `.click()` method.

3. When the `'.icon-close'` element is clicked, use `.animate()` to change the `left` offset of the `menu` to -285px, and the `left` offset of the `body` to 0px. Both are done over 200 milliseconds.

4. Click on the menu icon and the X to see if your code works!

```javascript
var main = function() {
    $('.icon-menu').click(function() {
    $('.menu').animate({
        left: '0px'
    }, 200);
    
    $('body').animate({
        left: '285px'
    }, 200);
});
    
    $('.icon-close').click(function() {
    $('.menu').animate({
        left: '-285px'
    }, 200);
    
    $('body').animate({
        left: '0px'
    }, 200);
  });
};

$(document).ready(main);
```

## Example Code ##

### app.js ###

```javascript
var main = function() {
    $('.icon-menu').click(function() {
    $('.menu').animate({
        left: '0px'
    }, 200);
    
    $('body').animate({
        left: '285px'
    }, 200);
});
    
    $('.icon-close').click(function() {
    $('.menu').animate({
        left: '-285px'
    }, 200);
    
    $('body').animate({
        left: '0px'
    }, 200);
  });
};

$(document).ready(main);
```

### index.html ###

```html
<html>
  <head>
    <link href="//maxcdn.bootstrapcdn.com/font-awesome/4.1.0/css/font-awesome.min.css" rel="stylesheet">
    <link href='http://fonts.googleapis.com/css?family=Open+Sans:400;300' rel='stylesheet' type='text/css'>
    <link href='style.css' rel='stylesheet'>

    
  </head>
  <body>

    <div class="menu">
      
      <!-- Menu icon -->
      <div class="icon-close">
        <img src="http://s3.amazonaws.com/codecademy-content/courses/ltp2/img/uber/close.png">
      </div>

      <!-- Menu -->
      <ul>
        <li><a href="#">About</a></li>
        <li><a href="#">Blog</a></li>
        <li><a href="#">Help</a></li>
        <li><a href="#">Contact</a></li>
      </ul>
    </div>

    <!-- Main body -->
    <div class="jumbotron">

      <div class="icon-menu">
        <i class="fa fa-bars"></i>
        Menu
      </div>
    
    <script src= "//ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
    <script src="app.js"></script>
  </body>
</html>
```

### style.css ###

```css
/* Initial body */
body {
  left: 0;
  margin: 0;
  overflow: hidden;
  position: relative;
}

/* Initial menu */
.menu {
  background: #202024 url('http://s3.amazonaws.com/codecademy-content/courses/ltp2/img/uber/black-thread.png') repeat left top;
  left: -285px;  /* start off behind the scenes */
  height: 100%;
  position: fixed;
  width: 285px;
}

/* Basic styling */

.jumbotron {
  background-image: url('http://s3.amazonaws.com/codecademy-content/courses/ltp2/img/uber/bg.png'); 
  height: 100%;
  -webkit-background-size: cover;
     -moz-background-size: cover;
       -o-background-size: cover;
          background-size: cover;
}

.menu ul {
  border-top: 1px solid #636366;
  list-style: none;
  margin: 0;
  padding: 0;
}

.menu li {
  border-bottom: 1px solid #636366;
  font-family: 'Open Sans', sans-serif;
  line-height: 45px;
  padding-bottom: 3px;
  padding-left: 20px;
  padding-top: 3px;
}

.menu a {
  color: #fff;
  font-size: 15px;
  text-decoration: none;
  text-transform: uppercase;
}

.icon-close {
  cursor: pointer;
  padding-left: 10px;
  padding-top: 10px;
}

.icon-menu {
  color: #fff;
  cursor: pointer;
  font-family: 'Open Sans', sans-serif;
  font-size: 16px;
  padding-bottom: 25px;
  padding-left: 25px;
  padding-top: 25px;
  text-decoration: none;
  text-transform: uppercase;
}

.icon-menu i {
  margin-right: 5px;
}
```