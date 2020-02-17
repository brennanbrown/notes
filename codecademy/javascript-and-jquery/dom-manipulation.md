# Document Object Model Manipulation #

<!-- MarkdownTOC -->

- Introduction
- $\(\)
    - Practice
- .text\(\)
- .appendTo\(\)
- .remove\(\)
    - Practice
- Six jQuery Methods
    - Examples
        - Example 1
        - Example 2
        - Example 3
    - Practice
- Document Object Model
- DOM Traversal
- .next\(\)
- .prev\(\)
- .children\(\)
        - Practice

<!-- /MarkdownTOC -->
## Introduction ##

To respond to user events, we wrote event handlers to modify HTML elements on the page.

jQuerry comes with several useful methods to modify HTML elements. The next cards will cover a few common jQuery methods.

## $() ##

In jQuery, we often see `$()`. It has two main uses:

* To select existing HTML elements on the page.
	* `$('p')` selects all **p** elements on the page

* To create new HTML elements to add to the page.
	* `$('<h1>')` creates a new **h1** element. The `<>` indicates that we want to create a new HTML element.

**Wherein:**

* `$()` creates a new `<h1>` element.

### Practice ###

**Q1**: Use `$()` to select all **P** elements on the page.
A: `$('p');`

**Q2**: Use `$()` to select only the `<li class="pubdate">..</li>` element.
A: `$('.pubdate')`

**Q3**: Create a new `li` element.
A: `$('<li>');`

**Q4**: Create a new **p** element.
A: `$('<p>');`

**Q5**: Select the **h2** element nested inside the `<div class="article">..</div>` element.
A: `$('.article h2');`

## .text() ##

The `.text()` method adds text to an HTML element.

**Wherein:**

* ` $('<p>').text('List') `

The `$()` creates a new `<p>` element and `.text()` sets its text to `'List'`

* `$('li').text('Old Item')`

The `$()` selects the `'li'` elements and `.text()` replaces its text with `'Old Item'`

* `$('h1').text()`

The `$()` selects the `'h1'` elements and `.text()` gets the text it contains.

## .appendTo() ##

Click the **New** button in the webpage to the right.

The `.appendTo()` method adds the HTML elements to the end of the selected element.

```javascript
$('.btn').click(function() {
	$('<li>').text('New item').appendTo('.items');
});
```

* The `$()` function creates a new **li** element.

* Text is added to the new **li** element.

* The **li** element is added as the first item inside `<ul class="items">..</ul>` on the page.

## .remove() ##

Click the **Delete** button in the webpage to the right.

The `.remove()` method removes the selected HTML element from the webpage.

```javascript
$('.btn').click(function() {
	$('.selected').remove();
});
```

When the **Delete** button is clicked, the `.selected` element is removed from the page.

### Practice ###

**Q1**: Create a new **p** element.
A: `$('<p>');`

**Q2** Select the `<li class='source'>..</li>` element and change the text to 'AP'.
A: `$('.source').text('AP');`

**Q3**: Create a new **li** element and append it to the **ul** element.
A: `$('<li>').appendTo('ul');`

**Q4**: Select all **p** elements and remove then.
A: `$('p').remove()`

**Q5**: Create a new **h1** element with the text 'Breaking news', and prepend it to the `<div class='article'>..</div>` element.
A: `$('<h1>').text('Breaking news').prependTo('.article');`

## Six jQuery Methods ##

These six jQuery mthods let you control more aspects of HTML elements:

**.hide()** hides the selected HTML element.

**.show()** displays an element.

**.toggle()** alternates hiding and showing an element.

**.addClass()** adds a CSS class to an element.

**.removeClass()** removes a class from an element.

**.toggleClass()** alternates adding and removing a class from an element.

```javascript
$('.social li').click(function() {
	$(this).toggleClass('active');
});
```

Notice where `.toggleClass()` is located. You can replace `.toggleClass()` with any of the fie other methods. While each method creates different effects, their usage is similar.

### Examples ###

#### Example 1 ####

```javascript
var main = function() {
  $("li").click(function() {
    $(this)
  });
};


$(document).ready(main);
```

In the event handler below, add `.addClass('read');` to `$(this)`. This will add the CSS class `'read'` to the clicked item. Then click on the list items to see what this code does.

```javascript
var main = function() {
  $("li").click(function() {
    $(this).addClass('read')
  });
};


$(document).ready(main);
```

#### Example 2 ####

```javascript
var main = function () {
  $(".btn").click(function () {
    $(".read")
  });
};

  $('li').click(function() {
  $(this).addClass('read');
})


$(document).ready(main);
```

In the event handler below, add `.hide();` to `$('.read')`. The Hide button will remove selected items from the list.

```javascript
var main = function () {
  $(".btn").click(function () {
    $(".read").hide();
  });
};

  $('li').click(function() {
  $(this).addClass('read');
})


$(document).ready(main);
```

#### Example 3 ####

```javascript
var main = function () {
  $(".btn").click(function () {
    $(".description")
  });
};


$(document).ready(main);
```

In the event handler below, add `.toggle()` to `$('.description')`. This will alternate showing and hiding each item's description. Then click on the **Toggle description** button to see what this code does.

```javascript
var main = function () {
  $(".btn").click(function () {
    $(".description").toggle();
  });
};


$(document).ready(main);
```

### Practice ###

**Q1**: Select the **ul** element and add the class "attribution".
A: `$('ul').addClass('attribution');`

**Q2**: Select all **p** elements on the page and hide them.
A: `$('p').hide();`

**Q3**: Select `<p class="description">..</p>` and remove the class "description".
A: `$('.description').removeClass('description');`

**Q4**: Create a new *li* element with the class "author", and append it to the **ul** element.
A: `$('<li>').addClass('author').appendTo('ul');`

**Q5**: Select the **a** element and change the text to "Read more".
A: `$('.read').text('Read more');`

## Document Object Model ##

jQuery also comes with methods that let us select HTML elements in relation to other elements.

In the webpage below, HTML elements are nested inside other elements, forming a hierarchy. This hierarchy can be visualized as a tree.

This representation of HTML is called **Document Object Model (DOM)**

```html
<!doctype html>
<html>
	<body>
		<div class="article">
			<h2 class="title">Flying the Gulfstream G650</h2>
			<ul class="attribution">
				<li class="source">AW</li>
				<li class="pubdate">Mar 22</li>
			</ul>
			<p class="description">Gulfstream's turning up the heat.</p>
		</div>
	</body>
</html>
```
**html > body > div.article > h2.title = p.description = ul.attribution > li.source = li.pubdate**

## DOM Traversal ##

The DOM is useful to represent relationships between elements, similar to a family tree.

For example, look at the **ul** element:

* The two **li** elements nested inside are its **child elements**.

* The `.article` element is its **parent element**.

* The `h2` and `p` elements are its **sibling elements**.

Here are three common jQuery methods that use these relationships to access and modify elements on the page.

|    Element   | Relation |
|--------------|----------|
|ul.attribution|  selected|
|h2.title      |   sibling|
|p.description |   sibling|
|li.source     |     child|
|li.pubdate    |     child|
|div.article   |    parent|

## .next() ##

The `.next()` element gets the next sibling of the selected element.

Wherein:

* The `$()` selected `'h2.title'`, then `.next()` selected its sibling, which is `'ul.attribution'`.

	* ul.attribution = selected
	* h2.title = next

`$('.title').next()`

## .prev() ##

The `.prev()` method gets the previous sibling of the selected element.

Wherein:

* The `$() selects 'ul.attribution' then .prev() gets its previous sibling which is 'h2.title'

	* h2.tile = selected
	* ul.attribution = prev

```javascript
$('.attribution').prev()
```

## .children() ##

The `.children()` method gets the children of the selected element.

If provided a selector, the `.children()` method can get a specific child.

Wherein:

* The `$()` selects `'div.article'` then `.children()` selects its children, which are `'h2.title'`, `'ul.attribution'` and `'p.description'`.

	* div.article = selected
	* h2.title = child
	* ul.attribution = child
	* p.description = child

#### Practice ####

**Q**1: Select all children of the **ul** element.
A: `$('ul').children();`

**Q2**: Select all the children of the `<div class="article">..</div>` element.
A: `$('.article').children();`

**Q3**: Select the next sbiling of the `<p class="description">..</p>` element.
A: `$('.description').next();`

**Q4**: Select the `<li class="pubdate">..</li>` child of the **ul** element.
A: `$('ul').children('.pubdate')`

**Q5:** Select the previous sibling of the **ul** element and change its text to "Breaking news".
A: `$('ul').prev().text('Breaking news');`