# HTML Basics #

<!-- MarkdownTOC -->

- Why learn HTML?
  - Instructions
  - Example Code
- HTML & CSS
  - Introduction: Elements
- ** HTML Elements **
- ** Heading Elements **
- **  **
- **  **
- **  **
- **  and  **
- ** and **
- Example Homepage

<!-- /MarkdownTOC -->


## Why learn HTML? ##

Every webpage you look at is written in a language called *HTML*. You can think of HTML as the skeleton that gives every webpage structure. In this course, we'll use HTML to add paragraphs, headings, images and links to a webpage.

In the header to the right, there's a tab called `test.html`. This is the file where we'll type our HTML into. See the code with the `<>`s? That's HTML! Like any language, it has it's own special **syntax**. (Rules for communicating.) 

When we press *Save & Submit Code*, the results tab will act like an internet **browser**. (Eg. Firefox, Google Chrome, Internet Explorer). A browser's job is to transform the code in `test.html` into a recognizable webpage! It knows how to layout the page by following the HTML syntax.

### Instructions ###

1. To the right, we have a test.html file.

2. Change the text on line 2 (the bit between `<strong>` and `</strong>`) to anything you like!

3. Hit Save & Submit Code, and you'll see how the test.html file would look in a browser. Did you see that? The `<strong></strong>` tags made our text bold!

### Example Code ###

```html
<!DOCTYPE html>
  <strong>Hello, God? Are you there?</strong>
```

## HTML & CSS ##

HTML stands for **HyperText Markup Language**. Hypertext means "text with links in it." Any time you click on a word that brings you to a new webpage, you've clicked on hypertext!

A **markup language** is a programming language used to make text do more than just sit on a page: it can turn text into images, links, tables, lists, and much more. HTML is the markup language we'll be learning.

What makes webpages pretty? That's CSS—**Cascading Style Sheets**. Think of it like skin and makeup that covers the bones of HTML. We'll learn HTML first, then worry about CSS in later courses.

The first thing we should do is set up the skeleton of the page:

1. Always put `<!DOCTYPE html>` on the first line. This tells the browser what language it's reading (in this case, HTML).

2. Always put `<html>` on the next line. This starts the HTML document.

3. Always put `</html>` on the last line. This ends the HTML document.



### Introduction: Elements ###
HTML is used to establish a page's structure. It also lets us add text, links and image

** HTML Elements **
----

HTML elements are the building blocks of web pages.

The web page to the right is made up of a collection of HTML elements. Each element is outlined in blue and labeled with its name.

HTML elements describe each piece of content on a web page so that the web browser knows how to display it.

The next few cards will cover five common HTML elements.


** Heading Elements **
-----

Headings are described by heading elements. There are six levels of heading elements: h1 to h6.

The h1 element is used to describe the main heading of the page.

*Example:*
```html
<h1>This is the main heading</h1>
```

** < p > **
----

Similar to a news article or a word document, headings in a web page are usually followed by paragraphs.

In HTML, paragraphs are described by paragraph elements, or p elements.

*Example:*
```
<h1>Find a place to stay.</h1>

<p>Rent from people in over 34,000 cities and 192 countries.</p>
```


** < a > **
----

The defining feature of the Web is the presence of links. Clicking on links leads to other web pages. The a element is used to create links.

The a element is similar to the h1 or p elements, but it has two key differences:

* First, it has an `href` attribute which equals the website you want to link to.

* Second, you get to choose the link text that users see on the page.

Example:*
```html
<a href="https://www.airbnb.com/locations">Learn More</a>
```

** < img > **
----

In adition to headings and paragraphs, a web page can have images. The img element is used to add images to a page.

The img element has an attribute inside the opening `<img>` tag named `src`. The `src` attribute has the address of the image.

Example:*
```html
<img src="http://goo.gl/mbnqBl">
```


** < ul > and < li > **
----
In addition to paragraphs and images, content can be presented as lists.

In HTML, a bulleted list is described using a ul element. Each item in the list is placed inside an li element.

*Example:*
```html
<ul>
  <li>Home</li>
  <li>About</li>
</ul>
```


**< html > and < body >**
----


Here's an example of a real web page:

* Everything inside a web page is nested inside the html element

* The body element contains the actual content of the web page - everything nested inside `<body>` and `</body>` shows up in the web browser

The doctype at the start of the HTML file tells the browser which version of HTML you are using. The doctype is not an HTML element, so it doesn't have a closing tag. The doctype ensures that your web page displays consistently when its visited from different browsers.

`<div>`

To stay organized, let's wrap the ul elements with two divs, like this:

```html
<div class="nav">
  <div class="container">
    <ul>
      <li>Your Name</li>
      ...
    </ul>

    <ul>
      <li>Sign Up</li>
      ...
    </ul>
  </div>
</div>
```

A div element groups other elements together into sections of the web page, such as a navigation bar, the main body, and the footer.

The outer `<div class="nav">..</div>` groups the elements into the navigation bar section of the web page. The inner `<div class="container">`..`</div>` wraps the contents in a container. We'll use both classes in the next section to style the navigation bar.

## Example Homepage ##

```html
<!DOCTYPE html>
<html>
  <body>
  <div class="nav">
   <div class="container">
	<ul>
	  <li>Brennan</li>
	</ul>
	
	<ul>
	  <li>Browse</li>
	</ul>
   </div>
  </div>
  
 <div class="jumbotron">
  <div class="container">
    <h1>Find a place to stay.</h1>
     <p>Rent from people in over 34,000 cities and 192 countries.</p>
  </div>
 </div>
 
 <div class="learn-more">
  <div class="container">
     <div>
    <h3>Travel</h3>
    <p>From apartments and rooms to treehouses and boats: stay in unique spaces and 192 countries.</p>
    <p>
        <a href="#">See how to travel on Airbnb</a>
    <p>
    </div>
 
    <div>
    <h3>Trust and Safety</h3>
    <p>From Verified ID to our worldwide customer support team, we've got your back.</p>
    <p>
        <a href="#">Learn about trust at Airbnb</a>
    <p>
    </div>
 </div>
</div>
 
	<ul>
	  <li>Sign Up</li>
	  <li>Log In</li>
	  <li>Help</li>
	</ul>
	
  </body>
</html>
```