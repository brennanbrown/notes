# Javascript Basics #

<!-- MarkdownTOC -->

- Introduction
- Variables
- Variables 2
- Practice with Variables
- Strings
- Strings Length
- Comparisions
- Practice with Comparisions
- if
- else
- else if
- Functions
- Functions 2

<!-- /MarkdownTOC -->


## Introduction ##

In order to make interactive web pages with jQuery, it's useful to know a few things about **JavaScript**.

JavaScript is a programming language that jQuery is written in, and knowing JavaScript will be helpful for understanding and writing your code.

The next cards will cover a few fundamental JavaScript concepts.

```javascript
var myName = "Jordan";
var status = "";

if( myName.length >=7) {
	status = "You should have a long name!";
}
else {
	status = "You should have a short name!"
}
```

## Variables ##

Variables store data so that they can be used later on in the program.

```javascript
var counter = 140;
```

* The keyword `var` creatres a new variable named `counter`.

* The value 140 is stored in `counter`.

* The statement ends with a semicolon `;` to tell the computer that the statment has ended.

## Variables 2 ##

It's possible to change a variable's value ising basic math.

```javascript
var score1 = 23;
var score2 = 25;
var score3 = 21;

var sum = score1 + score2 + score3;
var average = sum / 3;

var range = score2 - score3;

var fraction = 23 / 30;
var percentage = fraction * 100;
```

* We created three new variables.

* These variables have *operators*.
	* The `+` operator is used to add up the scores.
	* The `/` operator is used to divide scores.
	* The `-` operator is used to subtract scores.
	* The `*` operator is used to multiple values.

## Practice with Variables ##

**Q1:** Create a variable named jordan and set it equal to 23.
```javascript
var jordan = 23;
```

**Q2:** Create a variable named counter.
```javascript
var counter;
```

**Q3:** Set sum equal to the sum of 23 and 45.
```javascript
var sum = 23 + 45;
```

**Q4:** Change the value of score3 by diving it by 3.
```javascript
score3 = score3 / 3;
```

**Q5:** Change the value of score1 by multiplying it by 5.
```javascript
score1 = score1 * 5;
```

## Strings ##

Variables can also store pieces of text, called **strings**. A string is written by surrounding text with quotes.

Single quotes (`''`) or double quotes (`""`) can be used to write a string.

```javascript
var tweet = "Hiking trip on Saturday";
```

* The keyword `var` creates a new variable named `tweet`.

* The variable stores the string "Hiking trip on Saturday"

* A semicolon `;` ends the statement.

## Strings Length ##

We can find out how long strings are using the `.length` method.

```javascript
var tweet = "Hiking trip on Saturday";
var tweetLength = tweet.length;
```

* We create a new variable named `tweetLength`.
* The `.length` method counts all characters in a string, including spaces.
	* Therefore, the `tweetLength` variable now stores the number `23`.

## Comparisions ##

It's possible to compare variables using comparisions.

* `>` -- Greater than
* `<` -- Less than
* `>=` -- Greater than or equal to
* `<=` -- Less than or equal to
* `===` -- Equal to
* `!==` -- Not equal to

```javascript
var score1 = 23;
var score2 = 6;
var counter = 140;
var tweet = "Hiking trip on Saturday";

score1 > score2;
tweet.length <= counter;
score1 === score 2;
```

* `score1` is **greater than** `score2`, so this statement is `true`.

* `tweet.length` is **less than or equal to `counter`**, so this statement is `true`.

* `score1` is **not equal to `score2`**, so this statement is `false`.

## Practice with Comparisions ##

**Q1:** Create a variable named topic and set it equal to "JavaScript and jQuery".
```javascript
var topic = "JavaScript and jQuery";
```

**Q2:** Find the length of the string "Hiking trip on Saturday".
```javascript
tweet.length;
```

**Q3:** Determine whether the length of the string "Hiking trip on Saturday" is greater than 12.
```javascript
tweet.length > 12;
```

**Q4:** Determind whether the length of the string "Hiking trip on Saturday" is equal to 21.
```javascript
tweet.length === 21;
```

**Q5:** Determine whether the length of the string "Hiking trip on Saturday" is not equal to 23.
```javascript
tweet.length !== 23;
```
## if ##

We can use comparisions to write programs that ask 'yes or no' questions.

Say we want to write a program that asks whther your name is longer than 7 letters. If the answer is yes, we can respond with "You have a long name!"

We can do this with an **if statement**.

```javascript
var myName = 'Jordan';
var status = '';

if( myName.length >= 7 ) {
	status = "You have a long name!";
}
```

* An if statment starts with the `if` keyword.

* We check if the number of characters of `myName` is greater than or equal to 7.
	* The code withing the parentheses is called the **condition**. 

* If the answer to the condition is yes, the code inside the curly braces will run.

## else ##

We can use an **if statement** to do something if the answer to a condition is yes, or `true`.

We can use an **if...else statement** to do something if the answer is no, or `false`.

For example, if your name is shorter than 7 letters, we can respond with "You have a short name!". We can do this using an **if...else** statement.

```javascript
var myName = "Jordan";
var status = "";

if( myName.length >= 7 ) {
	status = "You have a long name!";
}

else {
	status = "You have a short name!";
}
```

* If the condition is `true`, then only the code inside the first pair of curly braces will run.

* Otherwise, the condition is `false`, so only the code inside the second curly braces will run.

* Here `myName.length >= 7` evaluates to `false`, so only this code block runs, and the `status` variable is set to the strong `"You have a short name!"`

## else if ##

We can extend the **if...else statement** to ask more yes or no questions by using **else if**.

```javascript
var myName = "Michaelangelo";
var status;

if( myName.length >= 15 ) {
	status = You have a very long name!
}

else if( myName.length >= 7 ) {
	status = "You have a long name!";
}

else {
	status = "You have a short name!";
}
```

* If the first condition is `true`, then the code inside the first pair of curly braces will run.

* Else if the second condition `true`, then the code inside the second pair of curly braces will run.

* Else all conditions evalueate to `false`, so only the code inside the last curly braces will run.

## Functions ##

Functions contain code that can be used over and over again in a program. A function is made up of three parts:

1. Function name
2. Parameters
3. Body

```javascript
var percentage = function(num, denom) {
	var result = (num / denom) * 100;
	return result;
}
```

* The name of this **function** is **`percentage`**.
	* The function takes two **parameters** as inputs, `num` and `denom`.
	* Parameters are variables that store the data provided to the function.

* The function **body** contains the reusable block of code.

## Functions 2 ##

A function is run by calling its name and giving it input values.

```javascript
var percentage = function(num, denom) {
	var result = (num / denom) * 100;
	return result;
}

var p1 = percentage(23, 30)
```

* The computer runs the `percentage` function with `23` and `30` substituted in for `num` and `denom`.

* The result is stored in the variable `p1`.
