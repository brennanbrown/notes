---
layout: default
title: Bootstrap 4 Fundamentals
parent: Web Development
---

**Table of Contents:**

- [Getting Started](#getting-started)
- [Using Basic Styles](#using-basic-styles)

## Getting Started

- When installing Bootstrap, you can choose one of the following methods: use a CDN, or the preprocessed Bootstrap CSS and JavaScript files.
  - CDN has the advantage of speed. Once a user has visited a website that uses a CDN, the Bootstrap code gets saved to a place in memory called a cache. That means that the next website using the same CDN won't have to download the code.
  - The advantage of using a preprocessed file is the ability to work offline. A CDN requires that you work online and, for development purposes, might not always be possible.
  - If you're going to be developing offline, stick with preprocessed files.
  - There are many other ways of running Bootstrap. For example, you can use SASS to customize your installation and perform installs using package managers like Bower, Composer, Meteor, or NPM.
- There are several different versions of Bootstrap when you download it.
  - Some people like to use only the grid features of Bootstrap for a layout so you can get just that if you want to.
  - There's also a Bootstrap reboot file. The reboot files are the special Bootstrap code that resets the CSS and browsers so that they work more consistently in different platforms.
  - And then finally, the regular version of Bootstrap. That contains the grid, the reset, and everything else in Bootstrap.
- It's important to note that if you're downloading Bootstrap, jQuery and popper.js will also be required.

Basic Bootstrap Template:

```html
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta
      name="viewport"
      content="width=device-width, initial-scale=1, shrink-to-fit=no"
    />
    <meta http-equiv="x-ua-compatible" content="ie=edge" />
    <link rel="stylesheet" href="css/bootstrap.min.css" />
    <title>Bootstrap</title>
  </head>
  <body>
    <!--  A container is a Bootstrap class that allows 
        everything to fit to the default grid in Bootstrap. -->
    <div class="container"></div>
    <!-- container -->

    <script src="js/jquery.slim.min.js"></script>
    <script src="js/popper.min.js"></script>
    <script src="js/bootstrap.min.js"></script>
  </body>
</html>
```

## Using Basic Styles

- When you go to a webpage, a lot of things influence how the page looks.
  - The browser has some default styles that it uses to display elements like headlines, paragraphs, et cetera.
  - These are called browser styles, and in addition to that you usually write your own CSS to make your sites look better.
  - The Bootstrap CSS styles are going to go between browser styles and your own styles to provide changes that make things look better
- One interesting thing about these styles is that they use a set of reset commands called **Reboot**.
  - Reboot makes styles consistent across different platforms and browsers.
  - The main difference between reboot and most other normalized code is that it uses `rems` instead of `pixels` for sizing fonts.
    - `rem` is a font measurement system that makes it easier to control both the size of fonts across the entire platform, and within individual components.
  - That makes it easier to build and customize Bootstrap, as well as your own components.
  - Reboot also keeps style declarations to a minimum because it uses CSS's ability to inherit styles whenever possible.
  - What this means for us is that styles are easier to override than in previous version of the framework.
- The CSS code that comes with Bootstrap overrides default browser behavior. Besides making things look great, it's also designed to be easy to override with your own CSS.
- In CSS, vertical margins can't collapse, and that makes it confusing to calculate the proper spacing in between a something like a paragraph and a headline, and to avoid this Bootstrap adds margin only at the **bottom** of elements.
  - This means it avoids using the `margin-top` property as much as possible.
- Bootstrap also uses the inherit property whenever possible.
  - This is important when you write your own CSS, in addition to the Bootstrap CSS because you won't have to work as hard to override styles.
- Another default that is set in this version of Bootstrap is box sizing, which makes it easier to calculate the width of elements.
  - By default it's turned to `border-box`, which means that when you specify the width of an element, say a `div` being 200 pixels wide, it takes into account the built-in padding.
  - So if you specify that an element like a div is 200 pixels wide, and then you specify 10 pixel padding, the box is still going to be 200 pixels wide.
  - In other words, it's not going to add the extra padding, which is what normal browsers would do.
- Bootstrap also uses native font stacks.
  - That means that the default font in Bootstrap is not set to something like Helvetica.
  - It tries to use whatever the current platform defines as the default sans-serif font.
  - Eg. On current Macs, that would be San Francisco.
  - Which will, in turn, yield a smaller CSS file.
- Finally, Bootstrap has a lot of elements that do things like match headlines, and allow you to create lead paragraphs, and take care of common page patterns.
- Bootstrap allows the use of classes to be used as tags, in other words, `<div class="h3">` would look identical to `<h3>`.
  - Another example would be `<p class="lead">` which you could utilize for a larger introductory paragraph.
- `text-justify` can be used to make sure that on a big paragraph, both of the sides are aligned to the edges of the text.
  - `text-xx-position` is a way to align text based off of screen size, wherein the middle value can be `sm`, `md`, `lg`, or `xl`, and position can be `left`, `right`, or `center`.
