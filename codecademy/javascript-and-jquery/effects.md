# Effects #

<!-- MarkdownTOC -->

- Introduction
- .slideDown\(\)
  - Example
- .slideUp\(\)
  - Example
- .fadeIn\(\)
  - Example
- .fadeOut\(\)
  - Example
- Animate
- Example Code for Effects
- Program Skeleton
- Dropdown Menu
  - Instructions
- Next Slide 1
  - Instructions
- Next Slide 2
- Instructions

<!-- /MarkdownTOC -->


## Introduction ##

jQuery comes with several useful methods that can animate HTL elements in a webpage.

For instance, when you click navigation arrows, the nide slide appears with an animated fade in affect, etc.

The next five cards will cover five common ways to HTML elements.

## .slideDown() ##

The `.slideDown()` methd shows the selected HTML element by sliding it down.

```javascript
$('body').click(function() {
	$('.slide').slideDown(600).addClass('active-slide');
});
```

When you click in the page's body, the next image slides down over 600 milliseconds.

### Example ###

```javascript
var main = function() {
  $(".btn").click(function(event) {
    $(".container").hide();
  });
};

$(document).ready(main);
```

Whe the **Slide Down** button is clicked, slide the `$('.container')` down in 800 milliseconds. To make this happen, add `.slideDown(800);` after `$('.container').hide()`

```javascript
var main = function() {
  $(".btn").click(function(event) {
    $(".container").hide().slideDown(800);
  });
};

$(document).ready(main);
```

## .slideUp() ##

The `.slideUp()` method hides the selected HTML element by sliding it up.

```javascript
$('body').click(function() {
	$('.slide').slideUp(600).addClass('active-slide');
});
```

When you click on the page's body, the current image slides up over 600 milliseconds.

### Example ###

```javascript
var main = function() {
  $(".btn").click(function(event) {
    $(".container").show();
  });
};

$(document).ready(main);
```

To make the **Slide Up** button have the efect of the image sliding up, add `.slideUp(1100)` after `$(".container").show()`.

```javascript
var main = function() {
  $(".btn").click(function(event) {
    $(".container").show().slideUp(1100);
  });
};

$(document).ready(main);
```

## .fadeIn() ##

The `.fadeIn()` method shows the selected HTML element by fading it in.

```javascript
$('body').click(function() {
  $('.slide').fadeIn(600).addClass('active-slide');
});
```

When you click the page's body, the next image fades over 600 milliseconds.

### Example ###

```javascript
var main = function() {
  $(".btn").click(function(event) {
    $(".container").hide();
  });
};
```

When the **Fade In** button is clicked, fade the `$("container")` in 700 milliseconds using `.fadeIn()`. Add `$(document).read(main);` to run the `main()` function after the document has loaded.

```javascript
var main = function() {
  $(".btn").click(function(event) {
    $(".container").hide().fadeIn(700);
  });
};

$(document).ready(main);
```
## .fadeOut() ##

The `.fadeOut` method hides the selected HTML element by fading it out.

```javascript
$('.body').click(function() {
	$('.slide').fadeOut(600).addClass('active-slide');
});
```

When you click in the page's body, the current image fades out over 600 milliseconds.

### Example ###

```javascript
var main = function() {
  $(".btn").click(function(event) {
    $(".container").show();
  });
};

```

When the **Fade Out** button is clicked, fade the `$('container')` out in 1000 milliseconds using `.fadeOut()`. Then run the `main()` function after the document has loaded.

```javascript
var main = function() {
  $(".btn").click(function(event) {
    $(".container").show().fadeOut(1000);
  });
};

$(document).ready(main);
```

## Animate ##

The `.animate()` method lets you create your own custom animations. HTML elements can be animated by specifying the CSS properties to change to over a time duration.

```javascript
$('icon-menu').click(function() {
	$('.menu').animate({
		width: "193px"
	},
	300);
});
```

* The `$('.menu')` selects the navigation menu element on the page.

* The `.animate()` takes two parameters:
	* A set of CSS properties.
	* A time duration over which to change them.

* Here, we want to change the `width` of the `.menu` element from its current width to 193px.

* This change will occur over a time duration of 300 milliseconds.

Putting it all together, when the `icon-menu` element is clicked, the `.menu` element will animate from its current width to 193px.

# Example Code for Effects #

## Program Skeleton ##

The index.html file has two script elements right before the closing `</body>` tag:

* The first script loads jQuery.

* The second script loads app.js. The file app.js is where we'll write out code for the Flipboard home page.



```javascript
var main = function() {

};

$(document).ready(main);
```

## Dropdown Menu ##

First, let's get the dropdown menu working. Here's an overview of the HTML:

    The More link can be accessed using the '.dropdown-toggle' class
    The dropdown menu can be accessed using the '.dropdown-menu' class

Currently the dropdown menu is hidden. When a user clicks the More link, the dropdown menu should show.


### Instructions ###

    Use jQuery to select the More link. This involves the 'dropdown-toggle' class.
    Add a .click() with a function inside. This function is called a click event handler.

    Inside the event handler:

    a. Use jQuery to select the 'dropdown-menu' class.
    b. Then make the menu show and disappear using .toggle().

```javascript
var main = function() {
    $('.dropdown-toggle').click(function() {
        $('.dropdown-menu').toggle();
    });
}

$(document).ready(main);

```

## Next Slide 1 ##

Nice! Now our More dropdown menu toggles between showing and hiding.

Next let's build a carousel to cycle through the slides. When a user clicks on the next arrow at the bottom of the page, we want to move to the next slide.

We will do this by fading out the current slide which has a class of ('active-slide'), and fading in the next slide by adding the class of ('active slide').

### Instructions ###

Let’s implement this inside the main function:

    Use jQuery to select the 'arrow-next' class, using the .click() event handler.

    Inside this event handler:

    a. Create two variables for the currentSlide and the nextSlide. The currentSlide should select the active slide, and the nextSlide should store the next slide.
    b. Have your current slide fade out at 600 milliseconds and remove the 'active-slide' class
    c. Have your next slide fade in at 600 milliseconds and add the 'active-slide' class

    In the web page to the right, click the next arrow to see what happens!

```javascript
var main = function() {
    $('.dropdown-toggle').click(function() {
        $('.dropdown-menu').toggle();
    });

    $('.arrow-next').click(function() {
            var currentSlide = $('.active-slide');
            var nextSlide = currentSlide.next();
            
            currentSlide.fadeOut(600).removeClass('active-slide');
            nextSlide.fadeIn(600).addClass('active-slide');
    });
}

$(document).ready(main);
```

The .fadeOut(600) and .fadeIn(600) methods fade out and in a slide over a duration of 600 milliseconds.

## Next Slide 2 ##

Great! When the next arrow is clicked, the click event handler runs, and the next slide appears.

However, when you reach the last slide and click the next arrow, the screen goes blank. Why does this happen?

Let's look at the code we just wrote in app.js. When we're on the last slide, there is no next slide. Therefore, when currentSlide is the last slide, nextSlide is empty, so the screen goes blank.

Instead, when we get to the last slide, we want to go back to the first slide. In other words, when currentSlide is the last slide, nextSlide should be set to the first slide.

## Instructions ##

Let's handle this case using an if statement inside the click event handler for '.arrow-next'.

    When currentSlide is the last slide, nextSlide will be empty. We can check this using the comparison nextSlide.length == 0. Therefore, after creating the variables currentSlide and nextSlide, write an if statement that checks if nextSlide.length == 0
    If nextSlide is empty, we want to go back to the first slide. Therefore, inside the if statement set nextSlide equal to the first slide using $('.slide').first();
    Try it out! In the web page to the right, click the next arrow until you get back to the first slide!

```javascript
var main = function() {
    $('.dropdown-toggle').click(function() {
        $('.dropdown-menu').toggle();
    });

    $('.arrow-next').click(function() {
        var currentSlide = $('.active-slide');
        var nextSlide = currentSlide.next();
            
        if (nextSlide.length == 0) {
            nextSlide = $('.slide').first();
        }
            
        currentSlide.fadeOut(600).removeClass('active-slide');
        nextSlide.fadeIn(600).addClass('active-slide');
    });
}

    

$(document).ready(main);
```
