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
- Next Dot 1
    - Instructions
- Next Dot 2
    - Instructions
- Previous Slide 1
    - Instructions
- Previous slide 2
    - Instructions
- Previous Dot 1
    - Instructions
- Previous Dot 2
    - Instructions
- Congratulations
- Example Code
    - app.js
    - style.css
    - index.html

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

Use jQuery to select the `'arrow-next'` class, using the .click() event handler.

    Inside this event handler:

1. Create two variables for the currentSlide and the nextSlide. The currentSlide should select the active slide, and the nextSlide should store the next slide.

2. Have your current slide fade out at 600 milliseconds and remove the 'active-slide' class

3. Have your next slide fade in at 600 milliseconds and add the 'active-slide' class

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

### Instructions ###

Let's handle this case using an if statement inside the click event handler for '.arrow-next'.

1. When currentSlide is the last slide, nextSlide will be empty. We can check this using the comparison nextSlide.length == 0. Therefore, after creating the variables currentSlide and nextSlide, write an if statement that checks if nextSlide.length == 0

2. If nextSlide is empty, we want to go back to the first slide. Therefore, inside the if statement set nextSlide equal to the first slide using $('.slide').first();

3. Try it out! In the web page to the right, click the next arrow until you get back to the first slide!

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

## Next Dot 1 ##



Well done! Next, let's get the dots working. Here's an overview of the HTML:

* The dots can be accessed using the `.dot` class

* The currently visible dot can be accessed using the `.active-dot` class

When a user clicks on the next arrow, we also want to move to the next dot.

### Instructions ###

We can implement this in the same way we created the slides. Let's add a few more lines of code inside the click event handler for '.arrow-next'.

1. Use jQuery to select the 'active-dot' class, and save it in a new variable named currentDot

2. Select the next dot using .next(), and save it in the variable nextDot

3. Remove the 'active-dot' class from currentDot and add it to nextDot

	In the web page to the right, click the next arrow to see what happens to the dots!

```javascript
var main = function() {
    $('.dropdown-toggle').click(function() {
        $('.dropdown-menu').toggle();
    });

    $('.arrow-next').click(function() {
        var currentSlide = $('.active-slide');
        var nextSlide = currentSlide.next();
            
        var currentDot = $('.active-dot');
        var nextDot = currentDot.next();
            
        if (nextSlide.length == 0) {
            nextSlide = $('.slide').first();
        }
            
        currentSlide.fadeOut(600).removeClass('active-slide');
        nextSlide.fadeIn(600).addClass('active-slide');
        
        currentDot.removeClass('active-dot');
        nextDot.addClass('active-dot');
    });
}

    

$(document).ready(main);
```

## Next Dot 2 ##



Great! Now when the next arrow is clicked, the next slide fades in and the next dot is updated.

However, when you reach the last slide and click the next arrow, the dot runs off the edge. Therefore, just as we did with slides, when we get to the last dot, nextDot should be set to the first dot.

### Instructions ###

We can implement this in the same way that we went back to the first slide

In the if statement under the existing code, add a line that sets nextDot equal to $('.dot').first().

```javascript
var main = function() {
    $('.dropdown-toggle').click(function() {
        $('.dropdown-menu').toggle();
    });

    $('.arrow-next').click(function() {
        var currentSlide = $('.active-slide');
        var nextSlide = currentSlide.next();
            
        var currentDot = $('.active-dot');
        var nextDot = currentDot.next();
        
            
        if (nextSlide.length == 0) {
            nextSlide = $('.slide').first();
            nextDot = $('.dot').first();
        }
            
        currentSlide.fadeOut(600).removeClass('active-slide');
        nextSlide.fadeIn(600).addClass('active-slide');
        
        currentDot.removeClass('active-dot');
        nextDot.addClass('active-dot');
    });
}

    

$(document).ready(main);
```

## Previous Slide 1 ##

Excellent! The next arrow works - both the slide and the dots work as expected.

Next let's do the same thing for the previous arrow. The previous arrow can be accessed with the .arrow-prev class.

When a user clicks on the previous arrow, we want to move to the previous slide.

### Instructions ###



Let's implement this inside the main function

    Select the '.arrow-prev' element and use .click() to attach a new event handler

    Inside the event handler,

    a. Use jQuery to select the '.active-slide' element, and save it in a new variable named currentSlide
    b. Select the previous slide using .prev(), and save it in a new variable named prevSlide
    c. Fade out currentSlide in 600 milliseconds and remove the 'active-slide' class from it.
    d. Fade in prevSlide in 600 milliseconds and add the 'active-slide' class to it.

```javascript
var main = function() {
    $('.dropdown-toggle').click(function() {
        $('.dropdown-menu').toggle();
    });

    $('.arrow-next').click(function() {
        var currentSlide = $('.active-slide');
        var nextSlide = currentSlide.next();
            
        var currentDot = $('.active-dot');
        var nextDot = currentDot.next();
        
            
        if (nextSlide.length == 0) {
            nextSlide = $('.slide').first();
            nextDot = $('.dot').first();
        }
            
        currentSlide.fadeOut(600).removeClass('active-slide');
        nextSlide.fadeIn(600).addClass('active-slide');
        
        currentDot.removeClass('active-dot');
        nextDot.addClass('active-dot');
        
    $('.arrow-prev').click(function() {
        var currentSlide = $('.active-slide');
        var prevSlide = currentSlide.prev();

        currentSlide.fadeOut(600).removeClass('active-slide');
        prevSlide.fadeIn(600).addClass('active-slide');
        });
    
    }
}

    

$(document).ready(main);
```

## Previous slide 2 ##

Next let's handle the special case when the current slide is the first slide. When currentSlide is the first slide, prevSlide should be set to the last slide.

### Instructions ###


Instructions

Inside the click event handler for '.arrow-prev', write an if statement to handle this case:

    After creating the variables currentSlide and prevSlide, write an if statement that checks if prevSlide.length == 0.
    If it is, set prevSlide equal to the last slide using $('.slide').last();
    Try it out! In the web page to the right, click the previous arrow and see what happens!

```javascript
var main = function() {
  $('.dropdown-toggle').click(function() {
    $('.dropdown-menu').toggle();
  });

  
  $('.arrow-next').click(function() {
    var currentSlide = $('.active-slide');
    var nextSlide = currentSlide.next();

    var currentDot = $('.active-dot');
    var nextDot = currentDot.next();

    if(nextSlide.length === 0) {
      nextSlide = $('.slide').first();
      nextDot = $('.dot').first();
    }
    
    currentSlide.fadeOut(600).removeClass('active-slide');
    nextSlide.fadeIn(600).addClass('active-slide');

    currentDot.removeClass('active-dot');
    nextDot.addClass('active-dot');
  });


  $('.arrow-prev').click(function() {
    var currentSlide = $('.active-slide');
    var prevSlide = currentSlide.prev();
    
    if(prevSlide.length === 0) {
      prevSlide = $('.slide').last();
    }
    
    currentSlide.fadeOut(600).removeClass('active-slide');
    prevSlide.fadeIn(600).addClass('active-slide');
  });

}

$(document).ready(main);
```

## Previous Dot 1 ##

The previous arrow now works as expected. When we're on the first slide, we wrap back to the last slide.

Next, let's get the dots working. When a user click on the previous arrow, we want to move to the previous dot.


### Instructions ###

Let's add a few more lines of code inside the click event handler for '.arrow-prev'.

    Use jQuery to select the '.active-dot' element, and save it in a new variable named currentDot
    Select the previous dot using .prev() and save it in the variable prevDot
    Remove the '.active-dot' class from currentDot and add it to prevDot

```javascript
var main = function() {
  $('.dropdown-toggle').click(function() {
    $('.dropdown-menu').toggle();
  });

  
  $('.arrow-next').click(function() {
    var currentSlide = $('.active-slide');
    var nextSlide = currentSlide.next();

    var currentDot = $('.active-dot');
    var nextDot = currentDot.next();

    if(nextSlide.length === 0) {
      nextSlide = $('.slide').first();
      nextDot = $('.dot').first();
    }
    
    currentSlide.fadeOut(600).removeClass('active-slide');
    nextSlide.fadeIn(600).addClass('active-slide');

    currentDot.removeClass('active-dot');
    nextDot.addClass('active-dot');
  });


  $('.arrow-prev').click(function() {
    var currentSlide = $('.active-slide');
    var prevSlide = currentSlide.prev();
    
    var currentDot = $('.active-dot');
    var prevDot = currentDot.prev();
    
    if(prevSlide.length === 0) {
      prevSlide = $('.slide').last();
    }
    
    currentSlide.fadeOut(600).removeClass('active-slide');
    prevSlide.fadeIn(600).addClass('active-slide');
    
    currentDot.removeClass('active-dot');
    prevDot.addClass('active-dot');
  });

}

$(document).ready(main);
```

## Previous Dot 2 ##

Finally let's handle the special case when the current dot is the first dot. When currentDot is the first dot, prevDot should be set to the last dot.

### Instructions ###

In the if statement under the existing code, add a line that sets prevDot equal to $('.dot').last().

## Congratulations ##

That does it! The carousel now works as expected in both directions. Try it out - the next arrow and the previous arrow in the web page to the right.

Congratulations! You used jQuery to recreate the Flipboard home page. You built a dropdown menu and a carousel from scratch.

Carousels are popular components used on many other websites, like Apple, Amazon, and Airbnb. Now you know how they work and how to build your own. Great job!

## Example Code ##

### app.js ###

```javascript
var main = function() {
  $('.dropdown-toggle').click(function() {
    $('.dropdown-menu').toggle();
  });

  
  $('.arrow-next').click(function() {
    var currentSlide = $('.active-slide');
    var nextSlide = currentSlide.next();

    var currentDot = $('.active-dot');
    var nextDot = currentDot.next();

    if(nextSlide.length === 0) {
      nextSlide = $('.slide').first();
      nextDot = $('.dot').first();
    }
    
    currentSlide.fadeOut(600).removeClass('active-slide');
    nextSlide.fadeIn(600).addClass('active-slide');

    currentDot.removeClass('active-dot');
    nextDot.addClass('active-dot');
  });


  $('.arrow-prev').click(function() {
    var currentSlide = $('.active-slide');
    var prevSlide = currentSlide.prev();
    
    var currentDot = $('.active-dot');
    var prevDot = currentDot.prev();
    
    if(prevSlide.length === 0) {
      prevSlide = $('.slide').last();
      prevDot = $('.dot').last();
    }
    
    currentSlide.fadeOut(600).removeClass('active-slide');
    prevSlide.fadeIn(600).addClass('active-slide');
    
    currentDot.removeClass('active-dot');
    prevDot.addClass('active-dot');
  });

}

$(document).ready(main);
```

### style.css ###

```css
/* General */

.container {
  width: 960px;
}


/* Header */

.header {
  background-color: rgba(255, 255, 255, 0.95);
  border-bottom: 1px solid #ddd;
  
  font-family: 'Oswald', sans-serif;
  font-weight: 300;
  
  font-size: 17px;
  padding: 15px;
}


/* Menu */ 

.header .menu {
  float: right;
  list-style: none;
  margin-top: 5px;
}

.menu > li {
  display: inline;
  padding-left: 20px;
  padding-right: 20px;
}

.menu a {
  color: #898989;
}

/* Dropdown */

.dropdown-menu {
  font-size: 16px;
  margin-top: 5px;
  min-width: 105px;
}

.dropdown-menu li a {
  color: #898989;
  padding: 6px 20px;
  font-weight: 300;
}


/* Carousel */

.slider {
  position: relative;
  width: 100%;
  height: 470px;
  border-bottom: 1px solid #ddd;
}

.slide {
  background: transparent url('http://s3.amazonaws.com/codecademy-content/courses/ltp2/img/flipboard/feature-gradient-transparent.png') center center no-repeat;
  background-size: cover;
  display: none;
  position: absolute;
  top: 0;
  left: 0;
  width: 100%;
  height: 100%;
}

.active-slide {
    display: block;
}

.slide-copy h1 {
  color: #363636;  
  
  font-family: 'Oswald', sans-serif;
  font-weight: 400;
  
  font-size: 40px;
  margin-top: 105px;
  margin-bottom: 0px;
}

.slide-copy h2 {
  color: #b7b7b7;
  
  font-family: 'Oswald', sans-serif;
  font-weight: 400;
  
  font-size: 40px;
  margin: 5px;
}

.slide-copy p {
  color: #959595;
  font-family: Georgia, "Times New Roman", serif;
  font-size: 1.15em;
  line-height: 1.75em;
  margin-bottom: 15px;
  margin-top: 16px;
}

.slide-img {
  text-align: right;
}

/* Slide feature */

.slide-feature {
  text-align: center;
  background-image: url('http://s3.amazonaws.com/codecademy-content/courses/ltp2/img/flipboard/ac.png');
  height: 470px;
}

.slide-feature img {
  margin-top: 112px;
  margin-bottom: 28px;
}

.slide-feature a {
  display: block;
  color: #6fc5e0;
  
  font-family: "HelveticaNeueMdCn", Helvetica, sans-serif;
  font-family: 'Oswald', sans-serif;
  font-weight: 400;
  
  font-size: 20px;
}

.slider-nav {
  text-align: center;
  margin-top: 20px;
}

.arrow-prev {
  margin-right: 45px;
  display: inline-block;
  vertical-align: top;
  margin-top: 9px;
}

.arrow-next {
  margin-left: 45px;
  display: inline-block;
  vertical-align: top;
  margin-top: 9px;
}

.slider-dots {
  list-style: none;
  display: inline-block;
  padding-left: 0;
  margin-bottom: 0;
}

.slider-dots li {
  color: #bbbcbc;
  display: inline;
  font-size: 30px;
  margin-right: 5px;
}

.slider-dots li.active-dot {
  color: #363636;
}

/* App links */

.get-app {
  list-style: none;
  padding-bottom: 9px;
  padding-left: 0px;
  padding-top: 9px;
}

.get-app li {
  float: left;
  margin-bottom: 5px;
  margin-right: 5px;
}

.get-app img {
  height: 40px;
}
```

### index.html ###

```html
<!doctype html>
<html>
  <head>
    <link href='http://fonts.googleapis.com/css?family=Oswald:400,300' rel='stylesheet'>
    <link href="http://s3.amazonaws.com/codecademy-content/courses/ltp2/css/bootstrap.min.css" rel="stylesheet">
    <link href="style.css" rel="stylesheet">
  </head>
  <body>
    <div class="header">
      <div class="container">
        <a href="#" class="logo-icon">
          <img src="http://s3.amazonaws.com/codecademy-content/courses/ltp2/img/flipboard/logo.png">
        </a>

        <ul class="menu">
          <li><a href="#">Get the App</a></li>
          <li><a href="#">Tutorials</a></li>
          <li><a href="#">Magazines</a></li>
          <li><a href="#">Web Tools</a></li>
          <li><a href="#">Support</a></li>
          <li><a href="#">Careers</a></li>
          <li class="dropdown">
            <a href="#" class="dropdown-toggle">More <b class="caret"></b></a>
            <ul class="dropdown-menu">
              <li><a href="#">Community</a></li>
              <li><a href="#">Our Blog</a></li>
              <li><a href="#">Maps Blog</a></li>
              <li><a href="#">Eng Blog</a></li>
              <li><a href="#">Advertisers</a></li>
              <li><a href="#">Publishers</a></li>
              <li><a href="#">About Us</a></li>
            </ul>
          </li>
        </ul>
      </div>
    </div>

    <div class="slider">

      <div class="slide active-slide">
        <div class="container">
          <div class="row">
            <div class="slide-copy col-xs-5">
              <h1>Flipboard Is Your Personal Magazine</h1>
              <p>It's a single place to discover, collect and share the news you care about.  Add your favorite social networks, publications and blogs to stay connected to the topics and people closest to you.</p>
              
              <ul class="get-app">
                <li><a href="#"><img src="http://s3.amazonaws.com/codecademy-content/courses/ltp2/img/flipboard/ios.png"></a></li>
                <li><a href="#"><img src="http://s3.amazonaws.com/codecademy-content/courses/ltp2/img/flipboard/android.png"></a></li>
                <li><a href="#"><img src="http://s3.amazonaws.com/codecademy-content/courses/ltp2/img/flipboard/windows.png"></a></li>
                <li><a href="#"><img src="http://s3.amazonaws.com/codecademy-content/courses/ltp2/img/flipboard/blackberry.png"></a></li>
              </ul>
            </div>
            <div class="slide-img col-xs-7">
              <img src="http://s3.amazonaws.com/codecademy-content/courses/ltp2/img/flipboard/home.png" width="540px">
            </div>
          </div>
        </div>      
      </div>

      <div class="slide slide-feature">
        <div class="container">
          <div class="row">
            <div class="col-xs-12">
              <a href="#"><img src="http://s3.amazonaws.com/codecademy-content/courses/ltp2/img/flipboard/cnn.png"></a>
              <a href="#">Read Now</a>
            </div>
            
          </div>
        </div>      
      </div> 

      <div class="slide">
        <div class="container">
          <div class="row">
            <div class="slide-copy col-xs-5">
              <h1>Enjoy Flipboard Magazines</h1>
              <h2>on the Web</h2>
              <p>Millions of people use Flipboard to read and collect the news they care about, curating their favorite stories into their own magazines on any topic imaginable. Now magazines created by our readers, from Dali to End Trafficking, can be shared and enjoyed on the Web by anyone, anywhere.</p>
              
            </div>
            <div class="slide-img col-xs-7">
              <img src="http://s3.amazonaws.com/codecademy-content/courses/ltp2/img/flipboard/magazines.png">
            </div>
          </div>
        </div>      
      </div> 


      <div class="slide">
        <div class="container">
          <div class="row">
            <div class="slide-copy col-xs-5">
              <h1>Badges & Widgets</h1>
              <p>Millions of people use Flipboard to read and collect the news they care about, curating their favorite stories into their own magazines. Now you can promote the ones you create or think are awesome.</p>
              
              <ul class="get-app">
                <li><a href="#"><img src="http://s3.amazonaws.com/codecademy-content/courses/ltp2/img/flipboard/ios.png"></a></li>
                <li><a href="#"><img src="http://s3.amazonaws.com/codecademy-content/courses/ltp2/img/flipboard/android.png"></a></li>
                <li><a href="#"><img src="http://s3.amazonaws.com/codecademy-content/courses/ltp2/img/flipboard/windows.png"></a></li>
                <li><a href="#"><img src="http://s3.amazonaws.com/codecademy-content/courses/ltp2/img/flipboard/blackberry.png"></a></li>
              </ul>
            </div>
            <div class="slide-img col-xs-7">
              <img src="http://s3.amazonaws.com/codecademy-content/courses/ltp2/img/flipboard/bw.png" width="540px">
            </div>
          </div>
        </div>      
      </div> 

    </div>

    <div class="slider-nav">
      <a href="#" class="arrow-prev"><img src="http://s3.amazonaws.com/codecademy-content/courses/ltp2/img/flipboard/arrow-prev.png"></a>
      <ul class="slider-dots">
        <li class="dot active-dot">&bull;</li>
        <li class="dot">&bull;</li>
        <li class="dot">&bull;</li>
        <li class="dot">&bull;</li>
      </ul>
      <a href="#" class="arrow-next"><img src="http://s3.amazonaws.com/codecademy-content/courses/ltp2/img/flipboard/arrow-next.png"></a>
    </div> 
    
    <script src="//ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
    <script src="app.js"></script>
  </body>
</html>
```