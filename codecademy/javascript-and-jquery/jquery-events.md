# jQuery: Events #

<!-- MarkdownTOC -->

- Events
- Events Handlers
- .click\(\)
  - Example
- .keypress\(\)
  - Example
- event
  - Example
- Notes on Example Code
  - Program Skeleton
    - Instructions
  - Show a Description
    - Instructions
    - Hint
  - Hide other descriptions
    - Instructions
  - Mark the current article
    - Instructions
  - Keyboard shortcuts
    - Instructions
  - The "o" shortcut
    - Instructions
    - Hints
  - The "n" shortcut 1
    - Instructions
  - The "n" shortcut 2
    - Instructions

<!-- /MarkdownTOC -->


## Events ##

User interactions with a webpage are called **events**.

For example, when you click the Like button to the right, the browser announces that a **click event** has occured.

## Events Handlers ##

We can write a function that specifies what to do when an event occurs. This function is called an **event handler**.

```javascript
var main = function() {
	$(".like-button").click(function() {
	 $(this).toggleClass("active");
	});
};

$(document).ready(main);
```

When a user clicks the `.like-button` element, the event handler toggles the `"active"` class. This alternates the button between the normal gray view and the selected blue view.

## .click() ##
In the page to the right, click the three share buttons at the top of the page.

One common user even is the **click event**. A click event occurs when a user licks on an HTML element.

The `.click()` method attaches an event handler to an HTML element so that is can respond to a click event.

```javascript
$('.social li').click(function() {
	$(this).toggleClass('active');
});
```

* `$('.social li')` selects each share button at the top of the webpage.

* The `.click()` method attaches an event handler to each button.

* The event handler adds the CSS class `.active`.
	* This then changes the buttons `.background-color` from `white` to `red`.

* We use `$(this)` to refer to the HTML element that was clicked on. We can now operate on this element using `.toggleClass()`

Putting it all together, when you click on a share button at the top of the page, a click even is triggered by browser.

When the click even occurs, the `.click()` method runs the event handler. In this code, the event handler changes the button color to red.

### Example ###

```javascript
var main = function() {
	$(".btn").click(function() {
    
	});
};

$(document).ready(main);
```

Fill in the event handler below to apply the class `"btn-like"` to the `$(".btn")` element. Use `.toggleClass()` to apply the class. Use `this` to operate on the already-selected HTML element.

```javascript
var main = function() {
  $(".btn").click(function() {
  $(this).toggleClass("btn-like")
  });
};

$(document).ready(main);
```
*or*

```javascript
var main = function() {
  $("ELEMENT").click(function() {
  $(this).toggleClass("CLASS")
  });
};

$(document).ready(main);
```

## .keypress() ##

In the code below, click inside the page, and then press and letter or number key.

Another common user event is the **keypress event**. A keypress event occurs when a user types a key on the keyboard.

The `keypress()` method attaches an event handler to an HTML element os that it can respond to a keypress event.

```javascript
$(doucment).keypress(function() {
	$('.dropdown-menu).toggle()';
});
```

* `$(document)` selects the whole webpage.

* The `.keypress()` method attaches an event handler to the `document`.

* When any keyboard key is pressed, the event handler toggles the dropdown menu.

Putting it all together, when you press any keyboard key, a keypress event is triggered by the browser.

When the keypress event occurs, the `.keypress()` ethod runs the event handler.

Here, the event handler toggles the dropdown menu.

### Example ###

```javascript
var main = function() {
  $(document).keypress(function() {


  });
};

$(document).ready(main);
```

Fill in the event handler below to apply the class `"btn-like"` to the `$(".btn")` element when a key is pressed. Use $(".btn") to select the Like button. Use .toggleClass() to apply the class "btn-like".

```javascript
var main = function() {
  $(document).keypress(function() {
  $(".btn").toggleClass("btn-like")


  });
};

$(document).ready(main);
```

## event ##

In the code below, click inside the page, and then press the **m** key.

Triggering a keypress event handler when any key is typed isn't particularly useful. For more control, we can use the `event` object.

The `event` object contains more information about an event, such as which mouse button was click or which key was pressed.

```javascript
$(document).keypress(function(event) {
	if(event.which === 109) {
		$('.dropdown-menu').toggle();
	}
});
```

* `$(document)` selects the whole webpage
* `.keypress()` method attatches an event handler to `document`.
* The event handler takes the `event` as a parameter.
* `event.which` contains which key is pressed. Keyboard keys are identified by [Key Codes](http://help.adobe.com/en_US/AS2LCR/Flash_10.0/help.html?content=00000520.html). The "m" key is identified as `109`
	* Therefore, when the "m" key is pressed, the dropdown menu is toggled.

### Example ###

```javascript
var main = function() {
  $(document).keypress(function(event) {


  });
};

$(document).ready(main);
```

Fill in the event handler below to apply the class `"btn-like"` to the `$(".btn")` when the **g** key is pressed.

Check if the **g** key is clicked with the key code `103`. Use `$(".btn")` to select the Like button. Use `.toggleClass()` to apply the class `("btn-like")`.

```javascript
var main = function() {
  $(document).keypress(function(event) {
  	if(event.which === 103) {
	  $(".btn").toggleClass("btn-like");

  }
};

$(document).ready(main);
```

## Notes on Example Code ##

### Program Skeleton ###

The `index.html` file script has **two** script elements right before closing the `</body>` tag.

* The first **script** loads jQuery.

* The sceond **script** loads **app.js**. The file **app.js** is where we'll write jQuery code for our News Reader.

#### Instructions ####

Set up the basic skeleton for JavaScript programs in app.js.

1. Use the keyword var and create a function called main.

2. Leave the function's code block empty.

3. Use jQuery to run the main function once the web page has fully loaded.

```javascript
var main = function() {
    
}

$(document).ready(main);
```

### Show a Description ###

The newsfeed contains a list of articles. Each article has a source, title, publication date, and description. HTML is used organize this data.

* The article's source, title, and pubdate are stored inside `<div class="item">..</div>.`

* The article's text is stored inside the `<div class="description">..</div>`.

We can interact with each of these categories with jQuery.


#### Instructions ####

1. Try click on an article. Nothing happens. Let's change that.

2. Use jQuery to select the CSS class `'.article'`.

3. Add a `.click()` method with a function inside. This function is called a click event handler.

4. Inside the event handler, display an article's description by using `$(this).children('.description').show();`

5. The code in step 4 is a little complex. More explanation can be found in the hint below.

#### Hint ####


1. In jQuery `$(this)` refers to the current element or object selected.

2. `children()` allows you to search through elements nested directly under the current element.

3. `show()` is jQuery's way of saying list or display these.

```javascript
var main = function() {
    $('.article').click(function() {
    $(this).children('.description').show();
    
    });
};

$(document).ready(main);
```

### Hide other descriptions ###

When an article is clicked, a click event occurs. This runs the event handler, which shows the clicked article's description.

However, when you click on more articles in the newsfeed, all descriptions remain open.

#### Instructions ####

1. Hide the descriptions of all articles except the article we clicked. How?

2. On the first line of the event handler, add a line that selects the `'description'` class and hides it using `.hide()`.

3. The first line of the event handler is under `$('.article').click(function() {`

```javascript
var main = function() {
    $('.article').click(function() {
        $('.description').hide();
        
    $(this).children('.description').show();
    
    });
}

$(document).ready(main);
```

### Mark the current article ###

The description of the current article shows and all other descriptions hide.

To make more clear which article is currently open, let's add the class 'current' to it. This is a CSS class in style.css that will shade it gray to indicate it is open.

#### Instructions ####

Let's add two more lines to the event handler.

1. Select the current article using this. Add the class `'current'` to it using `.addClass()`.

2. Add this line right above:

    `$(this).children('.description').show()`

3. Select all other articles using the `'article'` class and remove the class `'current'` from them using `.removeClass()`. Add this line right above:

    `$('.description').hide();

```javascript
var main = function() {
    $('.article').click(function() {
        $('.article').removeClass('current');
        $('.description').hide();
        
    $(this).addClass('current');    
    $(this).children('.description').show();
    
    });
}

$(document).ready(main);
```

### Keyboard shortcuts ###

Nice! Now when you click an article, it's shaded gray and its description opens up.

Next let's see how to add two keyboard shortcuts. Here's what we want:

* When you press o, it will open the article.
* When you press n, it will move on to the next article.

Step one is to write a keypress event handler.

####Instructions ####

Inside the main() function under your click event handler, create a keypress event handler:

1. Use jQuery to select document

2. Add a `.keypress()` method with a function inside. This function is called a keypress event handler.

3. The event handler should take event as a parameter.

```javascript
var main = function() {
    $('.article').click(function() {
        $('.article').removeClass('current');
        $('.description').hide();
        
    $(this).addClass('current');    
    $(this).children('.description').show();
    
    });
    
    $('document').keypress(function(event); {
        
    };
}

$(document).ready(main);
```

### The "o" shortcut ###

Keyboard keys are identified by key codes. The o key is identified by the key code `111`.

We can use event.which contains which key was pressed. If event.which === 111, then we know the o key has been pressed.

If the o key is pressed, we should toggle the current article's description.

#### Instructions ####

Inside the keypress event handler, write an if statement:

    The if statement should check whether event.which === 111.

    If it does, then toggle the current article's description using:

    $('.current').children('.description').toggle();

    It is important you click on the first article before pressing the o key!

The o key currently works for the first article's description. Let's add add another keyboard shortcut to move on to the next article.

#### Hints ####

    First $('.current') selects the current article.
    The .children('.description') method selects the <div class="description">..</div> inside the current article. We'll cover the .children() method in the next section.
    The .toggle() method alternates showing and hiding the description.


```javascript
var main = function() {
    $('.article').click(function() {
        $('.article').removeClass('current');
        $('.description').hide();
        
    $(this).addClass('current');    
    $(this).children('.description').show(); 
    
    });
    
    $(document).keypress(function(event) {
        if(event.which === 111) {
        $('.current').children('.description').toggle(); 
        }
    });
}

$(document).ready(main);
```

### The "n" shortcut 1 ###

Great job! Now when you click on an article it opens. When you press o, the description alternates opening and closing.

Let's make a keyboard shortcut for the n key which moves to the next article.

The n key is identified by the key code 110. In other words, `if event.which === 110`, then we know the n key has been pressed.

#### Instructions ####

    We're going to do the n shortcut over two exercises.
    Inside the keypress event handler under the existing if statement:

a. Write an else if statement
b. The else if statement should check whether event.which === 110.


```javascript
var main = function() {
    $('.article').click(function() {
        $('.article').removeClass('current');
        $('.description').hide();
        
    $(this).addClass('current');    
    $(this).children('.description').show(); 
    
    });
    
    $(document).keypress(function(event) {
        if(event.which === 111) {
        $('.current').children('.description').toggle();
        }
        else if(event.which === 110) {
        }
    });
}

$(document).ready(main);
```

### The "n" shortcut 2 ###

When the n key is pressed, we want to move to the next article. 

#### Instructions #### 

Inside the else if statement:

    Select the current article using the '.current' selector. Save this in a new variable named currentArticle
    Select the next article using currentArticle.next(). Save this in a new variable named nextArticle
    Remove the 'current' class from currentArticle using .removeClass()
    Add the 'current' class to nextArticle using .addClass()
    Click on any article, and then press the n key to see your new shortcut!