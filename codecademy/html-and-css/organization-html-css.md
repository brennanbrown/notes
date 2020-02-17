# Organization with HTML and CSS #

<!-- MarkdownTOC -->

- Introduction
- Display
- Position
- Float
- Example Code

<!-- /MarkdownTOC -->


## Introduction ##

A web page is a collection of HTML elements. CSS can control the design of an element, like its color, font, and spacing.

CSS can also control where an element sits on a page to create a page layout.

For example, the layout to the right has a top navigation bar, a large feature element, a grid of images, and then three pieces of supporting content.

What CSS properties are available to move elements around and create page layouts? Here are three common CSS properties.

## Display ##

CSS treats HTML elements like boxes. A box can be "block" or "inline".

* Block elements display on a new line (e.g., h1, p, ul, li).

* Inline elements display on the same line as their neighboring elements (e.g., img, a)

It's possible to change whether a box is block or inline by using the `display'
property.

```css
.nav li {
	display: block;
}
```
Wherein:

* Display = Property
* Block = Assigned Value

```css
.nav li {
  display: inline;
}
```
## Position ##

The `position` property is used to move an HTML element to a precise position on the page.

By setting position: `relative`, you can use the CSS properties `top`, `left`, `bottom`, and `right` to shift an element away from where it would have normally appeared on the page.


```css
.jumbotron h1 {
	position: fixed;
	top: 30px;
	right: 5px;
}
```

Wherein:

* Position = Property
* Top = Property
* Right = Property


* Fixed = Assigned Value
* 30px = Assigned Value
* 5px = Assigned Value

```css
.jumbotron h1 {
  position: relative;
  top: 91px;
  left: 55px;
}
```
## Float ##

The `float` property moves an element to the far left or far right of the page.

For example, setting `float: right` pulls an element to the far right side of the page, and the surrounding text wraps around it.

```css
img {
float: right;
}
```

Wherein:

* Float = Property
* Right = Assigned Value

Inside the `img` selector, set `float: right` to pull the image to the far right side of the page. Then inside the `.learn-more`, set `clear: both`. The `clear` property turns off the `float`, so the "Learn More" section returns to its normal flow on the page. 

```css
img {
float: right;
}

.learn-more {
clear: both;
}
```

## Example Code ##

```html
<!DOCTYPE html>
<html>
  <head>
    <link href="http://s3.amazonaws.com/codecademy-content/courses/ltp/css/shift.css" rel="stylesheet">
    <link rel="stylesheet" href="main.css">
  </head>
  
  <body>
    <div class="nav">
      <div class="container">
        <ul>
          <li><a href="#">Airbnb logo</a></li>
          <li><a href="#">Browse</a></li>
        </ul>
        <ul>
          <li><a href="#">Sign Up</a></li>
          <li><a href="#">Log In</a></li>
          <li><a href="#">Help</a></li>
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
	  <div>
		<div>
	      <div>
			<h3>Travel</h3>
			<p>From apartments and rooms to treehouses and boats: stay in unique spaces in 192 countries.</p>
			<p><a href="#">See how to travel on Airbnb</a></p>
		  </div>
		  <div>
			<h3>Host</h3>
			<p>Renting out your unused space could pay your bills or fund your next vacation.</p>
			<p><a href="#">Learn more about hosting</a></p>
	      </div>
		  <div>
			<h3>Trust and Safety</h3>
			<p>From Verified ID to our worldwide customer support team, we've got your back.</p>
			<p><a href="#">Learn about trust at Airbnb</a></p>
		  </div>
	    </div>
	  </div>
	</div>
  </body>
</html>
```
**CSS**
```css
.nav a {
  color: #5a5a5a;
  font-size: 11px;
  font-weight: bold;
  padding: 14px 10px;
  text-transform: uppercase;
}

.jumbotron {
  background-image:url('http://goo.gl/04j7Nn');
  height: 500px;
}

.jumbotron h1 {
  color: #fff;
  font-size: 48px;  
  font-family: 'Shift', sans-serif;
  font-weight: bold;
}

.jumbotron p {
  font-size: 20px;
  color: #fff;
}

.learn-more {
  background-color: #f7f7f7;
}

.learn-more h3 {
  font-family: 'Shift', sans-serif;
  font-size: 18px;
  font-weight: bold;
}

.learn-more a {
  color: #00b0ff;
}

.nav li {
    display: inline;
}

.jumbotron .container {
    position: relative;
    top: 100px;
}
```
