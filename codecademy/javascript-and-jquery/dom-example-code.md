# Dom Manipulation Example Code #

[TOC]

## Preview ##

Let's use jQuery to build a status update box similar to update boxes used in Facebook and Twitter.

* The file **index.html** contains the page structure and content.

* The file **style.css** has the styling for the page.

### Instructions ###

1. Type a message into the status update box. As you type, the number of characters left shows up next to the post button.

2. Click the **Post** button to update your status. The post gets added under the status box.

3. Click **Save & Submit Code** to get started.

## Program Skeleton ##

The **index.html** file has two **script** elements right before closing the `</body>` tag:

* The first **script** loads jQuery.

* The second **script** loads **app.js**. The file **app.js** is where we'll write out code for the status update tool.

```javascript
var main = function() {
    
};

$(document).ready(main);
```

## Create a new post ##

Here's an overview of the HTML:

    The status update box can be accessed using 'status-box' class
    The Post button can be accessed using the 'btn' class
    New status updates can be added to the <ul class="posts">..</ul> element

When a user types a message and clicks the Post button, the message should show up in the list of posts.

### Instructions ###

    Access the Post button by selecting the 'btn' class.
    Add a .click() method with a function inside. This function is called a click event handler.

    Inside the event handler:

    a. Create a variable named post. We want to store what is typed in the status-box in this variable. How? Select the class status-box. Use .val() after status-box is selected. This .val() is like .text() but for form inputs.
    b. Then use $( ) to create a new li element.
    c. The li element doesn't have any text. Use .text(post) to add text to the element.
    d. But this li element does not show up anywhere. Use .prependTo('.posts') to prepend it to the <ul class="posts">..</ul> element.

```javascript
var main = function() {
    $('.btn').click(function() {
        var post = $('.status-box').val();
        $('<li>').text(post).perpendTo('.posts');
    });
}

$(document).ready(main);
```

## Clear out the status box ##

When you type a message and click Post, the message displays below.

However, the status box still contains the old message. We'll need to clear out the status box after we've posted a message.

### Instructions ###

    Recall that $('.status-box').val() contained the content that was typed in the status box.
    Under all code where you prepended the list element to '.posts', we need a line of code to clear out the status box.
    To clear out the status box, use jQuery to select the 'status-box' class. Then set its value to empty by using .val('');.

```javascript
var main = function() {
    $('.btn').click(function() {
        var post = $('.status-box').val();
        $('<li>').text(post).perpendTo('.posts');
        $('.status-box').val('');

    });
}

$(document).ready(main);
```

## Count Characters Left ##

Next let's figure out how to display a count of the number of characters left:

    As the user types, we want to count the number of characters in their message.
    Then we want to subtract this string length from 140 to find the number of characters left in the message.
    Finally we want to update the '.counter' with this number to show how many characters are left

### Instructions ###

    Outside the click event handler, select the 'status-box' class
    Add a .keyup() method with a function inside. The .keyup() is similar to .keypress(). Therefore, this function is called a keyup event handler.

    Inside the event handler:

    a. Create a variable named postLength . In this variable, we want to store the length of the message typed in the status box. Use $(this), .val(), and .length
    b. Create a variable named charactersLeft and set it equal to 140 minus postLength
    c. Update the '.counter' to show how many characters are left. Select the 'counter' class and use .text() to update its text with charactersLeft

```javascript
var main = function() {
    $('.btn').click(function() {
        var post = $('.status-box').val();
        $('<li>').text(post).perpendTo('.posts');
        $('.status-box').val('');
        
    });
    $('.status-box').keyup(function() {
        var postLength = $(this).val().length;
        var charactersLeft = 140 - postLength;
        $('.counter').text(charactersLeft);
    });
}

$(document).ready(main);
```

## Reset the Counter ##

Now as you type a message, the number of characters left displays below.

However, when you click Post, the counter still contains the old number of characters left.

### Instructions ###


Instructions

We want to reset the counter text to "140" after the Post button is clicked.

To do this, add a line at the end of your click event handler where you:

    Use jQuery to select the CSS class 'counter'
    Replace its text with "140" using .text()

```javascript
var main = function() {
    $('.btn').click(function() {
        var post = $('.status-box').val();
        $('<li>').text(post).perpendTo('.posts');
        $('.status-box').val('');
        $('.counter').text('140');
        
    });
  $('.status-box').keyup(function() {
    var postLength = $(this).val().length;
    var charactersLeft = 140 - postLength;
    $('.counter').text(charactersLeft);
  });
}

$(document).ready(main);
```

## Disable the button 1 ##

The Post button should only work for messages that are 140 characters or less.

The button should be disabled to prevent longer messages or empty messages.

We want logic to handle three situations.

    If there are 0 or fewer characters remaining, the message is too long.
    Else if there are 140 characters remaining, the message is empty,
    Else we should enable the button

### Instructions ###

At the end of keyup event handler, add an if...else statement.

    Write an if statement that checks whether charactersLeft is less than 0. If it is, select the CSS class 'btn' and add the class 'disabled' using .addClass()
    Write an else if statement that checks whether charactersLeft is equal to 140. If it is, select the 'btn' class and add the class 'disabled' using .addClass()
    Write an else statement that selects the 'btn' class and removes the class 'disabled' using .removeClass()
    Lastly, let's disable the Post button so that empty messages can't be posted when the page loads. Outside the keyup event handler, add $('.btn').addClass('disabled');

```javascript
var main = function() {
    $('.btn').click(function() {
        var post = $('.status-box').val();
        $('<li>').text(post).perpendTo('.posts');
        $('.status-box').val('');
        $('.counter').text('140');
        if (charactersLeft > 0) {
            $('.btn').addClass('disabled');
        }
        
        
    });
  $('.status-box').keyup(function() {
    var postLength = $(this).val().length;
    var charactersLeft = 140 - postLength;
    $('.counter').text(charactersLeft);
    
        if(charactersLeft < 0) {
            $('.btn').addClass('disabled');
        }
        else if(charactersLeft === 140) {
            $('.btn').addClass('disabled');
        }
        else{
            $('.btn').removeClass('disabled');
        }
  });

            $('.btn').addClass('disabled');

$(document).ready(main);
```

## Disable the button 2 ##

The Post button is only enabled when at least one character is typed in the update box.

When you click Post, the update box is emptied. However, the button stays enabled. This needs to change!

### Instructions ###

To do this, add a line at the end of your click event handler where you:

    Select the 'btn' class
    Add the class 'disabled' using .addClass()
    Press Save and submit. This will take you to the full preview page. The exercise will only pass if you post a message!

```javascript
var main = function() {
    $('.btn').click(function() {
        var post = $('.status-box').val();
        $('<li>').text(post).perpendTo('.posts');
        $('.status-box').val('');
        $('.counter').text('140');
        $('.btn').addClass('disabled');
    });
}
    
  $('.status-box').keyup(function() {
    var postLength = $(this).val().length;
    var charactersLeft = 140 - postLength;
    $('.counter').text(charactersLeft);
    
        if(charactersLeft < 0) {
            $('.btn').addClass('disabled');
        }
        else if(charactersLeft === 140) {
            $('.btn').addClass('disabled');
        }
        else{
            $('.btn').removeClass('disabled');
        }
  });

            $('.btn').addClass('disabled');

$(document).ready(main);
```

## Congratulations ##

Congratulations! You used jQuery events to build a status update tool.

    You can type messages and post status updates
    A counter keeps track of the number of characters left
    The Post button is only enabled when there is a message that is 140 characters or less

Great work! Next let's learn more about how to use jQuery to create animated transitions.

## Example Code ##

### app.js ###

```javascript
var main = function() {
    $('.btn').click(function() {
        var post = $('.status-box').val();
        $('<li>').text(post).perpendTo('.posts');
        $('.status-box').val('');
        $('.counter').text('140');
        $('.btn').addClass('disabled');
    });
}
    
  $('.status-box').keyup(function() {
    var postLength = $(this).val().length;
    var charactersLeft = 140 - postLength;
    $('.counter').text(charactersLeft);
    
        if(charactersLeft < 0) {
            $('.btn').addClass('disabled');
        }
        else if(charactersLeft === 140) {
            $('.btn').addClass('disabled');
        }
        else{
            $('.btn').removeClass('disabled');
        }
  });

            $('.btn').addClass('disabled');

$(document).ready(main);
```

### style.css ###

```css
html,
body {
  font-family: 'Roboto', sans-serif;
  color: #404040;
  background-color: #eee;
}

.container {
  width: 520px;
  margin-top: 20px;
}

.button-group {
  margin-bottom: 20px;
}

.counter {
  display: inline;
  margin-top: 0;
  margin-bottom: 0;
  margin-right: 10px;
}

.posts {
  clear: both;
  list-style: none;
  padding-left: 0;
  width: 100%;
}

.posts li {
  background-color: #fff;
  border: 1px solid #d8d8d8;
  padding-top: 10px;
  padding-left: 20px;
  padding-right: 20px;
  padding-bottom: 10px;
  margin-bottom: 10px;
  word-wrap: break-word;
  min-height: 42px;
}
```

### index.html ###

```html
<!doctype html>
<html>
  <head>
    <link href="http://s3.amazonaws.com/codecademy-content/courses/ltp2/css/bootstrap.min.css" rel="stylesheet">
    <link href='http://fonts.googleapis.com/css?family=Roboto' rel='stylesheet' type='text/css'>
    <link href="style.css" rel="stylesheet">
  </head>
  <body>
    <div class="container">
      <form>
        <div class="form-group">
          <textarea class="form-control status-box" rows="2" placeholder="What's on your mind?"></textarea>
        </div>
      </form>
      <div class="button-group pull-right">
        <p class="counter">140</p>
        <a href="#" class="btn btn-primary">Post</a>
      </div>
    
      <ul class="posts">
      </ul>
    </div>

    <script src="//ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
    <script src="app.js"></script>
    
  </body>
</html>
```


