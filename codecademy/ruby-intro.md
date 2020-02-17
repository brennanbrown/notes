
# Ruby Introduction

<!-- MarkdownTOC -->

- Overview
    - Data Types: Numbers, Strings, Booleans
        - Instructions
        - Example
    - Variables
        - Instructions
        - Example
    - Math
        - Instructions
        - Example
    - 'puts' and 'print'
        - Instructions
        - Example
    - Everything in Ruby is an Object
    - The '.length' Method
        - Instructions
        - Example
    - The .reverse method
        - Instructions
        - Example
    - '.upcase' & '.downcase'
        - Instructions
        - Example

<!-- /MarkdownTOC -->


# Overview

Ruby is a powerful, flexible programming language you can use in web/Internet development, to process text, to create games, and as part of the popular Ruby on Rails web framework. Ruby is:

**High-level**, meaning reading and writing Ruby is really easy—it looks a lot like regular English!

**Interpreted**, meaning you don't need a compiler to write and run Ruby. You can write it here at Codecademy or even on your own computer (many are shipped with the Ruby interpreter built in—we'll get to the interpreter later in this lesson).

**Object-oriented**, meaning it allows users to manipulate data structures called objects in order to build and execute programs. We'll learn more about objects later, but for now, all you need to know is everything in Ruby is an object.

Easy to use. Ruby was designed by *Yukihiro Matsumoto* (often just called "Matz") in 1995. Matz set out to design a language that emphasized human needs over those of the computer, which is why Ruby is so easy to pick up.

This course assumes no previous knowledge of Ruby in particular or programming/computer science in general.

## Data Types: Numbers, Strings, Booleans

In Ruby, your information (or data) can come in different types. There are three data types in Ruby that we're interested in right now: 

1. Numbers
2. Booleans (which can be true or false)
3. Strings (words or phrases like "I'm learning Ruby!").

Computer programs exist to quickly analyze and manipulate data. For that reason, it's important for us to understand the different data types that we can use in our programs.

**Remember:** never use quotation marks (' or ") with booleans, or Ruby will think you're talking about a string (a word or phrase) instead of a value that can be true or false. 

It's also important to remember that Ruby is case-sensitive (it cares about capitalization).

### Instructions

Set the following variables to the corresponding values:

`my_num` to the value `25`
`my_boolean` to the value `true`
`my_string` to the value `"Ruby"` (note the capitalization!)

### Example

```ruby
my_num =  25   # Add your code here!

my_boolean = true  # And here!

my_string = "Ruby"    # Also here.
```

## Variables

One of the most basic concepts in computer programming is the variable. You can think of a variable as a word or name that grasps a single value. For example, let's say you needed the number 25 from our last example, but you're not going to use it right away. You can set a variable, say `my_num`, to grasp the value 25 and hang onto it for later use, like this:

`my_num = 25`

Declaring variables in Ruby is easy: you just write out a name like `my_num`, use `=` to assign it a value, and you're done! If you need to change a variable, no sweat: just type it again and hit `=` to assign it a new value.

### Instructions

Set the variable `my_num` to the value `100`, then click the Run button to run your code.

### Example

```ruby
my_num = 100
```

## Math

Ruby isn't limited to simple expressions of assignment like my_num = 100; it can also do all the math you learned about in school.

There are six arithmetic operators we're going to focus on:

* Addition (+)
* Subtraction (-)
* Multiplication (*)
* Division (/)
* Exponentiation (**)
* Modulo (%)

The only ones that probably look weird to you are exponentiation and modulo. 

Exponentiation raises one number (the base) to the power of the other (the exponent). For example, 2**3 is 8, since 2**3 means "give me 2 * 2 * 2" (2 multiplied together 3 times). 3**2 is 9 (3 * 3), and so on.

Modulo returns the remainder of division. For example, 25 % 7 would be 4, since 7 goes into 25 3 times with 4 left over.

### Instructions

Do a little math practice in the editor. When you're ready, click Save & Submit Code to move on to the next exercise.

### Example

```ruby
my_num = 55 / 56 * 72
```

## 'puts' and 'print'

The print command just takes whatever you give it and prints it to the screen. puts (for "put string") is slightly different: it adds a new (blank) line after the thing you want it to print. You use them like this:

```
puts "What's up?"
print "Oxnard Montalvo"
```

No parentheses or semicolons needed!

### Instructions

In the editor, use at least one `print` statement and at least one `puts` statement. You can print out any strings you like! (Make sure to put your strings between quotes, like this: `"Hello!"`.)

### Example

```ruby
puts "Matz was here"
print "Matsumoto was here, actually."
```

## Everything in Ruby is an Object

Because everything in Ruby is an object (more on this later), everything in Ruby has certain built-in abilities called methods. You can think of **methods** as "skills" that certain objects have. For instance, strings (words or phrases) have built-in methods that can tell you the length of the string, reverse the string, and more.

We also promised to tell you more about the interpreter. The **interpreter** is the program that takes the code you write and runs it. You type code in the **editor**, the interpreter reads your code, and it shows you the result of running your code in the **console** (the bottom window on the right).

## The '.length' Method

Methods are summoned using a `.`. If you have a string, `"I love espresso"`, and take the `.length` of it, Ruby will return the length of the string (that is, the number of characters—letters, numbers, spaces, and symbols). Check it out:

```ruby
"I love espresso".length
# ==> 15
```

(That little line starting with the `#` isn't part of what you need to write—it just shows you the output Ruby will provide. More on this in the next section!)

Taking the length of input can be useful if, for example, you want to make a website that takes credit card payments. Ruby can check to make sure the credit card number appears to be valid.

### Instructions

Call the `.length` method on your name (remember to use quotes around your name).

### Example

```ruby
"This is a test".length

# ==> 14

```

## The .reverse method

The `.reverse` method is called the same way `.length` is, but instead of asking Ruby to tell you how long a string is, it spits out a backwards version of the string you gave it. For instance,

`"Eric".reverse`

will result in

`"cirE"`

Reversing input can be useful if you want to sort a list of values from highest to lowest instead of lowest to highest. (We'll get to sorting in later lessons.)

### Instructions

Call the `.reverse` method on your name. Don't forget those quotation marks around your name to make it a string!

### Example

```ruby
"Brennan Brown".reverse
```

## '.upcase' & '.downcase'

Let's try one more method (er, two methods). As you might have guessed, the `.upcase` and `.downcase` methods convert a string to ALL UPPER CASE or all lower case, respectively.

### Instructions

Call .upcase on your name to make your name ALL CAPS and use puts to print it to the screen, like this:

```ruby
puts "eric".upcase
# ==> ERIC
```

On the next line, call .downcase to make your name all lower case. Make sure to use puts so you can see it printed out!

### Example

```ruby
puts "Brennan Brown".upcase

puts "Brennan Brown".downcase
```
