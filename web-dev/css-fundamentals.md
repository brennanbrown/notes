---
layout: default
title: CSS3 Essential Training
parent: Web Development
---

**Table of Contents:**

- [Introduction](#introduction)
- [Images and Pathways](#images-and-pathways)
- [Extended Colour Values](#extended-colour-values)
- [Classes and IDs](#classes-and-ids)
  - [Selectors](#selectors)
  - [Inheritance and Specificity](#inheritance-and-specificity)
  - [Cascade and Importance](#cascade-and-importance)
- [CSS Box Model](#css-box-model)
- [Typography](#typography)
- [Float and Position](#float-and-position)
- [Flexbox and Grid Layout](#flexbox-and-grid-layout)
  - [Flexible Box Layout](#flexible-box-layout)
  - [Grid Layout](#grid-layout)
- [Advanced Selectors](#advanced-selectors)
- [Fluid and Responsive Layouts](#fluid-and-responsive-layouts)
- [Helpful Links](#helpful-links)

## Introduction

- HTML is for the structure of the content, as well as semantic meaning.
  - CSS is for the appearance and styling of that content.
- There are three different ways to reference CSS on a webpage:
  - External CSS (recommended) is where there is a separate `styles.css` document from the `page.html`.
    - It can be added to the HTML file with either a `<link>` tag in the head, eg. `link rel="stylesheet" href="css/styles.css" type="text/css"`.`
    - The `@import` rule can also be used within a CSS document to combine multiple CSS files together, eg. `@import url('/styles/layout.css');`, this method is however slow. But it still popular with CSS preprocessors.
    - External CSS can also be reused by any HTML document.
  - Inline CSS is written directly into the HTML itself, eg. `<p style="color:grey;">Red Text!</p>`. This should be avoided.
  - Internal CSS is where the CSS is written within the head of the HTML document between the `<style>` tag.
- It's good practice to comment your color palette at the beginning of your CSS document to have as reference, as well as use comments to section the stylesheets based off the content in the web document.

## Images and Pathways

- Images can be optimized within CSS

  - It is important to be mindful of retina (high pixel density) displays when displaying images on your website, which refers to the DPI of a screen.
  - A simple way to support retina displays is to ensure your images are twice the size as they would need to be on a traditional screen.

- When linking to files within the same project, use a _relative_ path.

  - When linking from files outside of your own directory, an _absolute_ or _root relative_ path is needed, eg. `<link rel="stylesheet" href="http://localhost:8080/css/styles.css">`
  - eg. `picsblur.com`

- After publishing the third version of CSS, the W3C decided to implement the documentation of CSS into modules for faster iteration and updates.

```css
/* The Declaration Box */
img {
  /* The Selector */
  /* Width is a property, or style characteristic. */
  /* 300px is a value, applied to that specific property */
  width: 300px; /* The Declaration */
}

/* Selects every paragraph element and changes the text
   color of the characters in those elements to lavender. */
p {
  color: lavender;
}

/* Selects every link that's nested in a list item,
   and removed the underline. */
li a {
  text-decoration: none;
}
```

## Extended Colour Values

- Regarding _value units_, a data type such as `<length>` which is used to specify sizing, can use two types of units, _absolute_ and _relative_.
  - Absolute units are a fixed unit and always the same size, whereas relative units are relational settings. Values declared in a parent or ancestor element will have an effect on the relative units used in the child or descendant element.
- There are also keywords and unitless values.
  - These include color keywords, such as basic colors, such as `white` and `black`
  - As well as _extended colors_, such as `oldlace`, `blanchedalmond` aliceblue`,`mediumseagreen`.
  - RGB values presented with hexadecimal can also be used, such as `#ffc0cb`.
  - There is also the `rgb(105, 165, 195)` value, or `rgba(50%, 25%, 25%, 0.5;)` which allows for the forth value of opacity between 1-0.
  - Similarly, there is the `hsl(280, 50%, 80%)` value, which is instead hue, saturation, and lightness. The hue is specified as an angle dependent on the color wheel, with 0 or 360 being red.

```css
/* CSS Function Values */
img {
  /* Rotate an element  */
  transform: rotate(90deg);

  /* Calculate a computed value */
  width: calc(80% - 20px);

  /* Embed an img to the bg of an element. */
  background-image: url("myimage.png");
}
```

## Classes and IDs

- Type selectors are the most basic kind of selector, with simple matching patterns.
  - The universal selector `*` selects every element in the document, it is often used sparingly.
- The Class and ID selectors allow for more specific and unique elements to be selected.
  - Class selectors can be reused, and are written with a period in front in the CSS.
    - Eg. `<p class="fancy">This is a fancy paragraph.</p>` and `.fancy{ ... }`.
    - You can combine classes as well. `.fancy.intro{ ... }`.
  - IDs are not reusable, and only one can be on per page.
    - Eg. `<div id="container"> ... </div>` and `#container{ ... }`
    - They also serve a second function, where they can be utilized for _in-page linking_. Eg. `<a href="#example>...</a>` will take you to the part of the page where the element is located.
  - Use meaningful, descriptive names for classes and IDs that do not contain spaces.
- When there is style with no semantic meaning, it can be placed on the webpage in a `<div>` section.

### Selectors

- When an HTML tag is nested inside another tag, relationships between these elements are created and described by the **Document Object Model**.
  - The first level creates a parent child relationship, and anything nested further is referred to as an ancestor descendant relationship.
  - The relationship between elements nested within he same parent are referred to as sibling elements.
  - Descendant selectors are used to apply styles specifically to elements nested within other elements. Eg. `section p { ... }`.
  - Descendants do not have to be direct children of an element to be selected as a descendant, either.
- You can apply styles to multiple selectors using a comma in the stylesheet, eg. `h1, h2 { ... }`.
  - Each selector in the grouped list are independent of each other. So when using descendant selectors, make sure to declare the full combination. Eg. `section h1, h2 { ... }`
  - You can also combine elements and classes together in the same way, Eg. `p.intro{ ... }`
- _Pseudo-class_ selectors are often dynamic, meaning they require interaction through the person using the webpage. Eg. `a:link a:visited a:hover a:active`.

### Inheritance and Specificity

- One of the strengths of CSS is styles can be inherited from the ancestor to descendant elements.
  - This makes it easier to apply a style to several elements with one-liner codes, rather than defining the style for each element.
  - For example, all page content is contained within the `<body>` tag, so defining some broad styles for the page, such as the base font color can be added using the body selector.
  - It is also important to remember that certain styles are _not_ inheritable.
- Specificity determines how browsers decide which CSS rule takes precedence.
  - The more specific a style rule will take priority and display over the less specific one.
  - The hierarchy is: Universal > Type > Class > ID.
  - The quantity of elements, classes, and IDs that are attributed to content also are a deciding factor in precedence.

### Cascade and Importance

- Stylesheets are read from top to bottom, meaning that the rule that is closer to the end of the document will take precedence over the rule above it.
- The important keyword will always take precedence, however it is considered bad practice to use. Eg. `font-size: 12px!important;`.

## CSS Box Model

- When we'd look at a web page we see text and images, but to the browser, every single element is displayed as a rectangular box.
- The CSS Box Model describes the rectangular boxes that surround content element on a web page.
  - The inner-most rectangle is the content box, which is the element itself.
  - The second rectangle is the `padding` box, which includes space inside the element.
  - The third rectangle is the `border` box, which surrounds the padding area.
  - The forth and outer-most rectangle is the `margin` box.
  - All four of these together determine the total area of each element.
- When thinking about how elements occupy space, first consider `inline` and `block-level`, which can be changed using the `display` property.
- Inline elements take up the same space as their content.
  - Elements are displayed in a line, left to right.
  - Elements will only wrap if the items no longer fit in the viewport.
  - Common inline elements are `<a>`, `<span>`, and `<strong>`
- Block elements are also the same height as the content, however they are the _same width as the container_.
  - This means block elements will always start on a new line.
- The `width` and `height` properties change the size of the content box. Inline elements require the display property.
- The `padding` property adds/removes space inside of the element but around the content box.
- The `margin` property adds/removes space around the element.
- The `border` property displays a border between the margin and padding.
  - Within the border property, there is also `border-width`, `border-color`, and `border-style`, etc.
- The dimensions of all of these properties can contribute to the total amount of space an element occupies.
  - Using the development tools within a web browser is the easiest way to debug the box model on specific elements.
  - Whereas margin can accept negative values to bring elements
    closer to each other, padding does not.
- By default, `block` elements stack on top of each other, based on the order that the HTML was written in.
  - Use negative margin values to move elements outside of the stacking position.
  - However, it is best practice to keep the page elements as close to their natural flow as possible.
- Another important use of `margin` is for center alignment on a page. Eg. `magin:{ 0 auto; }`
  - This only works for vertical alignment, however.
- When creating links, a good accessibility tip is to add padding to make the link easier to click, as it will increase the clickable area.

```css
/* Box Model Shorthand Syntax */

padding: 2px; /* Same on all sides. */
padding: 2px 5px; /* Top & Bottom, Right & Left */
padding: 2px 10px 5px; /* Top, Right & Left, Bottom */
```

- Absolute `<length>` units:
  - px: Pixels
  - mm: Millimeters
  - cm: Centimeters
  - in: Inch
  - pc: Pica (1/72nd of an inch)
  - pt: Point (equal to 12 points)
- Relative `<length>` units include `em` which represents inherited value of the element, and `rem` which represented the value from the root element.

  - There are always `100vw`, `100vh`, `vmin`, and `vmax` and `vmin` which are units based on the width and height of the viewport.

- Adding different colors to different aspects to the box model to
  differantiate the two.

## Typography

- Typography is the practice of arranging type for the sake of readability and to engage and communicate with the reader.
- Typeface, which is often referred to as font or font family, is a set of fonts designed with common characteristics, composed of glyphs.
- The `font-family` property is used in CSS to change or alter the typefaces of text elements within the web document.
  - The first option set within the font-family property is what is intended to be used, with ones coming after it that are separated by a common being alternatives if the first font fails to load. This is referred to as the font stack.
- There are certain web-safe fonts, such as Arial or Times New Roman, which are installed on the majority of computers and devices.
- It is good practice to declare font families with double quotations if they contain more than one word, or a special character.

```css
@font-face {
  font-family: "Noto Sans";
  /* IE Compatability Modes */
  src: url("notoSans.eot");
  /* IE6-IE8 */
  src: url("notoSans.eot?#iefix") format("embedded-opentype");
  /* Super Modern Broswers */
  src: url("notoSans.woff2") format("woff2");
  /* Fairly Modern Web Browsers */
  src: url("notoSans.woff") format("woff");
  /* Safari, Android, iOS */
  src: url("notoSans.tff") format("truetype");
  /* Legacy iOS */
  src: url("notoSans.svg#svgFontName") format("svg");
}
```

- There is also the `font-weight` property which is used to define how thick (bold, regular, thin) a typeface displays. The values go from 100 to 900.
  - `normal` is a keyword that equals 400 font weight.
  - `bold` is a keyword that equals 700 font weight.
- There is also the `font-style` property which modifies the look of the font.
  - There is `normal`, `italic` which usually appear more cursive, and `oblique` which usually is just a sloped version of normal.

```css
.parent {
  font-size: 60px;
}

.child {
  /* Will be 16px due to inherting the root element,
  * which in this case, is just the body default. */
  font-size: 1rem;

  /* Will be 30px, as it is going to be 50% of
  * the parent element's size. 
  * Good for mobile screen sizes. */
  font-size: 0.5em;
}
```

- To expand typeface options, you can use the `@font-face` property to add web fonts.
  - Eg. `@font-face { src: url(.../my-font.woff);`
  - When using a font, even if free, go over the usage rights in the included readme file.
  - Be weary that, when using web fonts, they will cause additional loadtime to the page.

```css
/* Font Shorthand */
.body {
  font: italic small-caps bold 24px/1, 5 Helvetica, sans-serif;
}
/* Font Longhand */
.body {
  font-style: italic;
  font-variant: small-caps;
  font-weight: bold;
  font-size: 24px;
  line-height: 1.5;
  font-family: Helvetica, sans-serif;
}
```

- In order for the property `line-height` to be consistent, use percentages instead of pixels so it is relative to the size of the font.
  - Similarly, the larger a font, the larger the `margin` space it will have.

## Float and Position

- Prior to flexbox and grid, the `float` property was used for the entire web document.
  - The float property is still used in modern practices as a way to display text surrounding an image, for example.
  - The `clear` property used to clear the float from the flow. Eg. `.clear { clear: both; }`
- Parent elements will only wrap around non-floated child elements.
  - If all elements within a parent element are floated, the height of the parent container will collapse to a value of 0.
- Even elements not in the parent container will be affected, as any elements following the floated element will stack underneath. Content will flow around.
- When there are no elements to apply a `clear` to, a _self-clearing_ technique is applied to the parent.
- Using `float`, in order to make sure that all elements fit within a container, it's important to calculate their size in addition to the margin, padding, etc. that separates the elements.

```css
/* Self-clearing Float Technique */
.floated {
  float: left;
}

.parent {
  overflow: hidden;
}

/* Clearfix Hack */
.clearfix:after {
  content: " ";
  display: table;
  clear: both;
}

/* Display Technique (Not currently fully supported) */
.parent {
  display: flow-root;
}
```

- The initial size of content is `box-sizing: content-box`, which will not include padding or border.
  - There is the _Box Model Fix_, which is changing the value to `box-sizing: border-box` will take the entire box into consideration for the size, the content will appear in a smaller box to make up for this, however.

```css
/* Border Box Fix */

html {
  box-sizing: border-box;
}

*,
*:before,
*:after {
  box-sizing: inherit;
}
```

- `Position` is a preoperty that can also change the flow of the document.
  - `static`: Not positioned
  - `relative`: Relative to current positioning, will not alter page flow.
  - `absolute`: Relative to containing/ancestor element
  - `fixed`: Relative to the viewport.
  - `sticky`: Relative to containing element _and_ viewport, still experimental.
- Excluding static, all of these values must have their top, bottom, left, and right values specified.
- Everytime an HTML element is added within the same container, the elements stack in layers on the Z axis. This is called the _stacking context_.
  - This order can be changed with the `z-index` property, however it only works if the element has a position applied to it.

## Flexbox and Grid Layout

Both flexbox and grid modules are new ways to design layouts that are more advanced than traditional techniques.

### Flexible Box Layout

- With `flexbox`, items are aligned on a single axis.

  - It is often described as being one-dimensional.
  - Great for space distrubution of items on a single axis.
  - Allows more ways for alinging and sizing elements, and creating more flexible elements overall.

- `flex-container` refers to the parent element, with 'flex items' being the children elements.
- The default direction of the main axis is horizontal, however this can be changed using the `flex-direction: vertical;` property.
- The cross-axis will always run perpendicular to the direction of the flex items.
  Both axis also have a start and ending point. - `main-start` and `main-end` for the main axis, and `cross-start` and `cross-end` for the cross axis.
- Setting the container to `inline-flex` will flex-container will span the width of its contents, the items, and display inline to other flex-containers.
- The `flex-direction` property determines the direction of the main axis.
  - There are four values: `row`, `row-reverse`, `column`, and `colomn-reverse`. This ordering is only visual.
- By default, `no-wrap` flexbox only aligns items on a single axis, if there is not enough flex items to fit, there will be space left.
  - If there is not enough space, the items will shrink to fit the space.
  - `wrap` will wrap items to the next line, which also has the property `wrap-reverse`.
- There are three properties used together to set the sizing of the flex items.

  - `flex-basis` sets the initial size of flex-items. Ie. If there's enough room, set all items to this value.
  - `flex-grow` determines how items will expand if there is extra space in the container. Defaults to 0, if set to 1, all items will expand the same amount to fill up the entire space.
  - `flex-shrink` determines how items will shrink if there isn't enough space. Defaults to 1, shrinks all items by the same amount to fit in the container, if set to 1, the items will not shrink at all.
  - The W3C recommends using the shorthand property `flex` to avoid resetting any values that have not been specifically defined, eg. `flex: grow shrink basis`.
  - These values must be set to the flex items specifically, not the flexbox container.

- Before flexbox, there was no explict or easy way to center elements on a webpage both horizontally and vertically.
  - `justify-content` aligns items on the main axis. There are also different ways to space elements within a container with this property.
    - `space-between` declaration distributes items evenly with the first item at the start of the axis.
    - `space-around` is similar but also adds space on the right and left sides of the items.
  - `align-tiems` aligns items on the cross axis.
    - `stretch` declaration stretches the flex items along the cross axis.
  - When using these modules, it's important to first clear the default values for certain elements, such as `<ul>` lists.

```css
.flex-container {
 background: grey;
 margin-bottom: 10px;
 display: flex;
 flex-wrap: wrap;
 flex-direction: column;
}

.flex-item {
 box-sizing: border-box;
 border: 1px solid blue;
}

/* Will display first item on first row, followed by
 * the three items after displayed evenly on the second. */
.flex-container {
 display: flex;
 align-items: center;
 justify-content: center;
}

.flex-item-first {
 flex: 0 0 100%;
}

.flex-item {
 flex: 1 1 auto;
}

{
```

```html
<div class="flex-container">
  <div class="flex-item-first">1</div>
  <div class="flex-item">2</div>
  <div class="flex-item">3</div>
  <div class="flex-item">4</div>
</div>
; }
```

### Grid Layout

- With the newer `grid` layouts, items can be moved with both rows and columns.
- Similar to flexbox, the grid module contains `grid-container` as the parent element. and 'grid items' as the child elements within the container.
  - Grids can be displayed either as `grid` or `inline-grid`.
    - `grid` will cause child elements to span the width of its container. It will display as a block-level element.
    - Whereas `inline-grid`, the items will span the width of their content. The entire container will display inline beside other inline containers.
- Grid lines, starting from 1 for both rows and colomns, refer to the numerical index.
- A grid cell is defined by where the grid row and column intersect.
  - The space between two adjacent grid lines is called the grid track. These can optionally be separated by a `gutter`.
- To define an explicit grid, use `grid-template-columns` and `grid-template-rows`.
- The grid layout introduced a new flexibly length unit called `fr` or _fraction unit_.
  - This represents a fraction of the available space in the grid container.
    - If there are three colums set to `1fr` individually, the grid will be split into three equal columns.
    - However, if the second item is set to `2fr`, it will take up twice as much space as the two surrounding columns.
- The gutter `gap` property can also be used in flexbox, but currently only Firefox supports this.
- Any items placed into the grid track that do not have an declared size will become the size of their contents as an implicit grid.

```css
.grid-container {
  /* Explicit Grid */
  display: grid;
  grid-template-columns: 100px 100px 100px; /* 3 Columns */
  grid-template-rows: 100px 100px; /* 2 Rows */

  /* Same result, but flexible and responsive */
  grid-template-columns: repeat(3, 1fr);

  /* Implicit Grid */
  display: grid;
  grid-auto-columns: repeat(3, 1fr);
  grid-auto-rows: repeat(2, 100px);

  /* Gutter between grid tracks (shorthand) */
  gap: 10px; /* Rows & Columns */
  gap: 10px 20px; /* Rows | Columns */
}
```

- Position-based properties must be applied to the grid items to determine their placement within the grid.
  - Eg. `grid-column` which is shorthand for `grid-column-start` and `grid-column-end`.
  - When placing an item: `.grid-item-1 { grid-column: 2 / 4; grid-row: 1 / 3; }`. Will produce an item that takes up two rows and columns.

## Advanced Selectors

- As a general rule, start with the most general selector possible, and get more specific as required.
- Descendant selectors create matching patterns based on the relationship between nested elements.
- Pseudo-class elements `:first-child` and `:last-child` can be used to apply the style to the first or last child element.
  - The parent element does not have to be specified unless you want to apply these styles to elements within a specific container.

```css
/* Descendant Selector */
parent child {
}
ancestor descendant {
}

/* Child Combinator (Direct Descendants) */
parent > child {
}

/* Adjacent Sibling Combinator */
h1 + p {
}

/* General Sibling Combinator */
h1 ~ p {
}
```

## Fluid and Responsive Layouts

- Rather than tailoring disconnected designs to each of an ever-increasing number of web devices, we can treat them as facets of the same experience.
  - We can design for optimal viewing experience, but embed standards-based technologies into our designs to make them not only more flexible, but more adaptive to the media that renders them.
- There are three major components to responsive web design: Fluid layouts, Flexible images, and Media queries.
- An easy way to create a fluid layout is with the `max-width` value, which will shrink the width of content if the viewport is less than what is set.
  - Adding a percentage-based `width` afterwards will also allow space around the content so it doesn't push up against the screen's edge.
- Images that are a part of the content should be added with HTML
  - Eg. `<img src="images/test.png" alt="content thumbnail"`
- Images that are purely presenational should be added with CSS.
  - Eg. `section { background-image: url(path/to/img); }`
  - If the image is smaller than the background area, it will be tiled, this can be changed with `background-repeat: no-repeat;`.
  - It can also be changed in size with `background-size` to `cover` to completely fill the background area.

```css
selector {
  /* Background-size may only be included after position, 
  * separated by the "/" character. */

  /* Image, repeat-style, position, background-size */
  background: url(../image.png) no-repeat center/cover;
}
```

- What makes a webpage's design go from fluid to responsive is the usage of _media queries_.
  - There are four types of `media`:
    - `all` matches to all devices.
    - `print` matches to printers and print-related displays.
    - `speech` matches to screen-reading devices that "read out" a page.
    - `display` matches to all devices that aren't categorized as either print or speech.
  - Eg. `@media screen and (width: 400px) { ... }`
- It's usual practice to either add all media queries to the end of a CSS file, or add each one to the related CSS following it.
- Alternatively you can use the `@import` function to load a stylesheet into the main CSS file.
  - Eg. `@import url("mobile.css") screen and (max-width: 400px);`
  - Eg. `<link rel="stylesheet" media="screen and (max-width: 480px)" href="mobile.css">`
- Separating design by different sizes of viewports is referred to as _breakpoints_
  - However, as the growth of different screen sizes increases, the inability to decisively mark breakpoints has grown.
  - Instead, it's better practice to adjust the minimum and maximum width based on what looks best for the design already implemented.

```css
/* Breakpoints Example */

/* 800px or larger */
@media (min-width: 800) {
  ...;
}

/* 799px or smaller */
@media (max-width: 799) {
  ...;
}
```

## Helpful Links

- Mozilla Developer Network's CSS Guide
- Picsblur.com - Placeholder Images
- Codeguide.co - Code Guidelines
- Colours.neilorangepeel.com - CSS Extended Colors
- Coolors.co - Automatically generated colour palettes.
- Specificity.keegan.st - CSS specificity calculator
- CSSfontstack.com - Collection of websafe fonts.
- Fontsquirrel.com - Generate all needed formats for typefaces.
- Caniuse.com - Check browser support of CSS properties and declarations.
