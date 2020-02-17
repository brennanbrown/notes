# CSS Coding Basics #

<!-- MarkdownTOC -->

- Introduction
- CSS
- CSS Rules
- Class Attribute
- Class Selector
- Combining Selectors
- Color
- Font Family
- Font Size
- Review of Text
- Background Color
- Background Image
- Border
- Padding
- Padding 2
- Margin
- Margin 2
- Margin 3
- and
- Tutorial Notes
  - Navigation
- Full Example

<!-- /MarkdownTOC -->


Web pages are created using HTML and CSS.

* HTML is used to write a web page's content.

* CSS is used to define the design and layout of the page.

## Introduction ##

The HTML never changes. The same HTML file is styled different ways by using different CSS files. All the visual differences in color, font, and where elements are arranged on the page are a result of CSS.

A web page is a collection of HTML elements. CSS is used to control the appearance of an HTML element.

## CSS ##

The code below specifies that h1 elements be colored red. This code is called a CSS rule.

*Example:*
```css
h1 {
  color: red;
}
```

Wherein:

* h1 { = Selector
* color: = Property
* red; = Value

## CSS Rules ##

CSS uses rules to style HTML elements. Here's how CSS rules work:

* A CSS rule starts with a selector. A selector specifies which HTML elements to style. Here the `h1` CSS selector selects all h1 HTML elements on the page.

* Inside the braces `{ }`, a property and its value define what aspect of the h1 elements to style. Setting the `color` property to `red` changes the color of the h1 element to red.

Together, a selector and its property-value pairs are called a **CSS rule.**

## Class Attribute ##

HTML elements can be CSS selectors, but they're not the only selectors available. Another available selector is the class selector.

To see how it works, let's first look at the HTML below HTML elements can carry a `class` attribute.

```css
<div class="header">
  <h2>Heading</h2>
  <p>Subtitle</p>
</div>

<p> Hello world</p>
```

## Class Selector ##

The `class` can be targeted from CSS by using a dot (`.`), as seen in the CSS below.

```css
.header {
  color: blue;
}
```

The .header selector applies a blue text color only to the elements nested inside `<div class="header">..</div>`.

In this way, classes are useful to specifically target groups of HTML elements.

The text inside `<div class="header">..</div>` is blue. Since the text `Hello world` is outside the div, it remains unstyled.

*Example:*
```css
.header {
  color: blue;
}
```

## Combining Selectors ##

It's possible to be even more specific by combining classes and element names.

```css
.header p{
  color: blue;
}
```

This CSS selector selects any p element nested inside an HTML element with the class named `header`, and colors it blue.

In this way, a CSS rule targets specific HTML elements on the page and applies a style to them.

The next few cards will cover three common CSS properties available to style HTML elements.

## Color ##

The `color` property sets the color of an HTML element's text.

We can use color names to change the text's color. But this only works for 140 colors.

Instead, we can use RGB values or hexadecimal numbers. They can represent millions of colors. RGB values and hex numbers express colors as different amounts of red, green and blue.

* RGB values range from `0` to `255`, with 255 being the brightest.

* Hex numbers vary from `00` to `ff`, with ff being the brightest.

```css
.jumbotron h1 {
  color: #9933CC;
}
```

## Font Family ##

The `font-family` property sets the font of an HTML element's text.

Three fonts commonly used with `font-family` are:

* `font-family: Arial, Helvetica, sans-serif;`
* `font-family: "Times New Roman", Times, serif;`
* `font-family: "Courier New", Courier, monospace;`

Google Fonts is a free collection of over 600 more web fonts that you can use on your page.

```css
.jumbotron h1 {
  color: red;
  font-family: 'Open Sans', sans-serif;
}
```

## Font Size ##

The `font-size` property sets the size of an HTML element's text.

Text size can be measured in pixels, ems, or rems. We will use pixels here.

```css
.jumbotron h1 {
  color: red;
  font-family: 'Shift', sans-serif;
  font-size: 60px;
}
```

## Review of Text ##

CSS uses rules to define the design of an HTML element.

Here's an HTML element labeled with the CSS properties that control different aspects of its appearance. When you want to style an HTML element, imagine there is a box around it and apply these properties to style it.

We've already looked at three properties to control the appearance of an HTML element's text. The next few cards will cover five more properties that affect the space surrounding the text.

## Background Color ##

The `background-color` property sets the color for the background of an HTML element.

```css
.jumbotron {
  background-color: #0099cc;
}
```

## Background Image ##

Instead of a solid color, the `background-image` property sets an image as the background of an HTML element.

```css
.jumbotron {
  background-image: url('http://goo.gl/ODpi3y');
}
```

## Border ##

The `border` property sets the width, style, and color of an element's border

```css
.jumbotron h1 {
  border: 3px solid #cc0000;
}
```

## Padding ##

The `padding` property creates space between the content and border of an element. This whitespace is useful in order to improve readability and organization of the page.

```css
.jumbotron h1 {
  padding: 23px;
  border: 3px solid #ffffff;
}
```

## Padding 2 ##

The `padding` property sets the the padding on all sides. It's possible to set the padding on each side.

The properties `padding-top`, `padding-bottom`, `padding-left`, and `padding-right` are available to set the padding on each side of an HTML element.

```css
.jumbotron h1 {
  padding-top: 10px;
  padding-bottom: 23px;
  border: 3px solid #ffffff;
}
```

## Margin ##

The `margin` property creates space for multiple HTML elements. The margin is a transparent area outside the border of an element.

```css
.jumbotron h1 {
  margin: 14px;
  border: 3px solid #ffffff;
}
```


## Margin 2 ##

The `margin` property sets the margin on all sides. It's possible to set the margin on each side.

The properties `margin-top`, `margin-bottom`, `margin-left`, and `margin-right` are available to set the margin on each side of an HTML element.

```css
.jumbotron h1 {
  margin-top: 10px;
  margin-left: 23px;
  border: 3px solid #ffffff;
}
```
## Margin 3 

The properties `margin-left`, and `margin-right` are available to set the `margin` on either side of an HTML element. If one of these properties is set to `auto`, then it will take as much as possible.

To move the HTML element to the far left of the screen, use `margin-right: auto`. This will maximize the amount of space there is on the right side margin, pushing the element to the far left.

To center an element, set `margin-right: auto` and `margin-left: auto` The margin to the left and right will be equal and the element will be centered.

```css
.jumbotron h1 {
  margin-right: auto;
  margin-left: auto;
  border: 3px solid #ffffff;
}
```

## < head > and < link >

Here's an example of using CSS in a web page:

* The **head** element contains information that the web browser needs to display the page.
* The **link** element tells the browser where to find the CSS file used to style the page. 
	* The `rel` attribute tells the browser that the file being linked is a CSS file to style the page. 
	* The `href` attribute gives the browser the path to the CSS file.
* The **body** element contains the content of the page that shows up in the web browser.

```html
<1DOCTYPE html>
<html>
 <head>
  <link href="main.css" rel="stylesheet" />
 </head>
 <body>
  <h1>Web Development</h1>
  <p>We're learning HTML</p>
 </body>
</html>
```

## Tutorial Notes ##

### Navigation ###

Let's start by styling the navigation bar.

In index.html, the `<div class="nav">..</div>` groups elements that are part of the navigation bar section of the web page. Inside `<div class="nav">..</div>` are the a elements we want to style.

Therefore, we can select all a elements inside `<div class="nav">..</div>` in CSS like this

## Full Example ##



```css
.nav a {
    color: #5a5a5a;
    font-size: 11px;
    font-weight: bold;
    padding-top: 14px;
    padding-bottom: 14px;
    padding-left: 10px;
    padding-right: 10px;
    text-transform: uppercase;
}

.jumbotron {
    height: 500px;
    background-image: url('http://goo.gl/04j7Nn');
}

.jumbotron h1 {
    color: #fff;
    font-size: 48px;
    font-weight: bold;
    font-family: 'Shift', sans-serif;
}

.jumbotron p {
    color: #fff;
    font-size: 20px;
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
    color: #00b0ff
}
```