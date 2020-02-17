# Bootstrap #

<!-- MarkdownTOC -->

- Introduction
- Introduction 2
  - Preprocessors
  - One framework, every device
  - Full of features
- The Grid
- Page Layout
- Tabs
- Pills
- Jumbotron
- Summary
- Stylesheet Order
- Example Code

<!-- /MarkdownTOC -->


## Introduction ##

We saw how to use CSS rules to control the style and layout of a page.

Bootstrap is a collection of prewritten CSS rules used to build web pages faster. Bootstrap provides styles out of the box for several common components on a web page, such as grid layouts, navigation, showcases, and much more.

Let's see how to get started using Bootstrap in your web page.

## Introduction 2 ##

### Preprocessors ###

Bootstrap ships with vanilla CSS, but its source code utilizes the two most popular CSS preprocessors, Less and Sass. Quickly get started with precompiled CSS or build on the source.

### One framework, every device ###

Bootstrap easily and efficiently scales your websites and applications with a single code base, from phones to tablets to desktops with CSS media queries.

### Full of features ###

With Bootstrap, you get extensive and beautiful documentation for common HTML elements, dozens of custom HTML and CSS components, and awesome jQuery plugins.


## The Grid ##

A grid is a useful way to create page layouts. Rather than create layouts from scratch, HTML elements can be aligned to a grid in different ways to create custom layouts.

Bootstrap comes with a grid that is made up of 12 equal-sized columns. HTML elements are arranged to span different numbers of columns in order to create custom page layouts.


## Page Layout ##

Bootstrap's grid is made up of 12 equal-sized columns. Each piece of content is aligned to this grid by specifying the number of columns to span.

The code below uses Bootstrap's grid to create a layout with two pieces of content.

```html
<div class="row">

  <div class="col-md-6">
    <h4>Content 1</h4>
  </div>

  <div class="col-md-6">
    <h4>Content 2</h4>
  </div>

</div>
```

* Here, each piece of content spans six columns, so it uses the `.col-md-6` class.
* Both columns are wrapped in a `.row` class to create a horizontal group.

```html
<div class="row">

	<div class="col-md-8">
		<h4>Content 1</h4>
	</div>

	<div class="col-md-4">
		<h4>Content 2</h4>
	</div>

</div>
```
*or*
```html
<div class="row">

	<div class="col-md-2">
		<h4>Content 1</h4>
	</div>

	<div class="col-md-8">
		<h4>Content 2</h4>
	</div>

	<div class="col-md-2">
		<h4>Content 3</h4>
	</div>

</div>
```

## Tabs ##

Tabs are a common navigation technique that give links to different parts of a site. Tabs are seen in sites like Gmail and Codecademy.

Bootstrap makes it easy to create tabbed navigation. Let's see how to do this.

Below is a regular `ul` element. Let's use Bootstrap and turn it into tabs. To do so, make the `class` equal `nav nav-tabs`. 

```html
<ul class="nav nav-tabs">
	<li><a href="#">Primary</a></li>
	<li class="active"><a href="#">Social</a></li>
	<li><a href="#">Promotions</a></li>
	<li><a href="#">Updates</a></li>
</ul>
```
The open tab is specified by the class `active`. Change which tab is open by moving `class="active"` from the second li element to the fourth li element. The effect that you should get is that it opens the fourth tab. 

```
<ul class="nav nav-tabs">
	<li><a href="#">Primary</a></li>
	<li><a href="#">Social</a></li>
	<li><a href="#">Promotions</a></li>
	<li class="active"><a href="">Updates</a></li>
</ul>
```

## Pills ##

Pills are a set of buttons that give links to different parts of a site. Pills are seen in sites like Google's search results page.

Bootstrap makes it easy to create pill navigation. Let's see how to do this.

Below we have used Bootstrap to style the ul element as tabs. To change the tab navigation to pill navigation, replace the class `nav-tabs` with `nav-pills`.

```html
<ul class="nav nav-pills">
	<li><a href="#">Primary</a></li>
	<li class="active"><a href="#">Social</a></li>
	<li><a href="#">Promotions</a></li>
	<li><a href="#">Updates</a></li>
</ul>
```
## Jumbotron ##

Many sites have a large showcase area featuring important content. Showcases are seen on sites like Google Mobile and Apple.

Bootstrap calls this large showcase a jumbotron. A jumbotron is used to call extra attention to important content on the site. Let's see how to use it.

```html
<div class="jumbotron">
	<h1>Find a place to stay.</h1>
	<p>Rent from people in over 34,000 cities and 192 countries.</p>
</div>
```
## Summary ##

By adding Bootstrap classes to your HTML elements, you can make use of Bootstrap's CSS to build your page faster. This lets you quickly set up the basic styles and layout so that you can get to the more interesting aspects of your page's design.

Bootstrap provides CSS for many more web components. Check out this site to see how else you can use Bootstrap to style your HTML elements!

## Stylesheet Order ##

The order of the CSS files matter.

1. The browser first sees shift.css, and makes the Shift font available to use in the page
2. Next the browser sees bootstrap.css, and applies those styles to the page.
3. Then the browser sees main.css, and applies those custom styles to the page. The custom styles override the Bootstrap styles.

The order of the CSS files tell the browser that your styles in main.css are more important than the styles in bootstrap.css, so the final page that loads is the customized web page.

## Example Code ##

```html
<!DOCTYPE html>
<html>

  <head>
    <link href="http://s3.amazonaws.com/codecademy-content/courses/ltp/css/shift.css" rel="stylesheet">
    
    <link rel="stylesheet" href="http://s3.amazonaws.com/codecademy-content/courses/ltp/css/bootstrap.css">
    <link rel="stylesheet" href="main.css">
    
  </head>

  <body>
    <div class="nav">
      <div class="container">
        <ul class="pull-left">
          <li><a href="#">AirBnB</a></li>
          <li><a href="#">View</a></li>
        </ul>
        <ul class="pull-right">
          <li><a href="#">Register</a></li>
          <li><a href="#">Log on</a></li>
          <li><a href="#">Question?</a></li>
        </ul>
      </div>
    </div>

    <div class="jumbotron">
      <div class="container">
        <h1>The greatest hotels on Earth.</h1>
        <p>Rent? No problem. We've got you covered <i>everyhere.</i></p>
      </div>
    </div>
        
    <div class="neighborhood-guides">
     <div class="container">
      <h2>Neighborhood Guides</h2>
      <p>Not sure where to stay? We've created neighborhood guides for cities all around the world.</p>
    
    <div class="row">
     <div class="col-md-4">
      <div class="thumbnail">
       <img src="http://4.bp.blogspot.com/-xdz-BqhoED4/Uhvf7gzSkPI/AAAAAAAASjA/K0IbuPNJz-8/s1600/southern+idaho+interstate+dusk+mountains+pale+sky.jpg">
      </div>
      
      <div class="thumbnail">
       <img src="http://madrilicious.com/wp-content/uploads/2012/08/photo-44.jpg">
      </div>
     </div>
     
     <div class="col-md-4">
      <div class="thumbnail">
       <img src="http://californiaish.files.wordpress.com/2012/12/img_9521.jpg">
      </div>
      
      <div class="thumbnail">
       <img src="http://static.tumblr.com/d4aae43b24bc3302e457a14fa110b022/dqhc39a/Epamfpuem/tumblr_static_big_1e7e5d75ed02926661f6458f3acbffc852a2adfb.jpg">
      </div>
     </div>
     
     <div class="col-md-4">
      <div class="thumbnail">
       <img src="http://dreamofacity.files.wordpress.com/2012/01/6-willsburg-hipster.jpg">
      </div>
     </div>
     
  </div>
 </div>
</div>
     
        <a href="#">Learn More</a>
      </div>
    </div> 

    <div class="learn-more">
	  <div class="container">
		<div class="row">
	      <div class="col-md-4">
			<h3>Don't just travel, <b>Live.</b></h3>
			<p>From apartments and rooms to treehouses and boats: stay in unique spaces in 192 countries.</p>
			<p><a href="#">See how to live with AirBnb.</a></p>
	      </div>
		  <div class="col-md-4">
			<h3>Give people life.</h3>
			<p>Renting out your unused space could pay your bills and cause great happiness within.</p>
			<p><a href="#">Learn more about hosting</a></p>
		  </div>
		  <div class="col-md-4">
			<h3>You're the safest.</h3>
			<p>You are literally the safest human being in the universe.</p>
			<p><a href="#">Seriously.</a></p>
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

.nav li {
  display: inline;
}

.jumbotron {
  background-image:url('http://shanellemariephotography.files.wordpress.com/2012/11/img_9641.jpg');
  height: 500px;
  background-repeat: no-repeat;
  background-size: cover;
}

.jumbotron .container {
  position: relative;
  top:100px;
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

.neighborhood-guides {
    background-color: #efefef;
    border-bottom: 1px solid #dbdbdb;
}

.neighborhood-guides h2 {
    color: #393c3d;
    font-size: 24px;
}

.neighborhood-guides p {
    font-size: 15px;
    margin-bottom: 13px;
}
```
