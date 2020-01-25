# Programming Foundations: Fundamentals

* Programming is like a recipe
    - Ingredients and instructions -- specific
    - Literal arguments -> Exact
    - Bug: Unexpected happened
    - Crash: Something freezes
- Order of steps is important, programming is *sequential*
- Finding errors and preventing crashes are just as important as creating instructions

## Programming Language

* Syntax is rules, semantics is meaning.
* Each languages have their own strengths and weaknesses.
* *Machine language* is what computers read and understand, which is what *high-level languages* are converted to.


```cpp
# include

int main()
{
    std::cout << "Hello, world!";
    return 0;
}
```

```javascript
document.write('Hello, world!');
```

```python
print "Hello, world!"
```

## Running Code

* Python is an *interpretive language*, which means that it needs to be converted into machine language before it's able to run.
    - You convert interpretive language into machine language with *compile* or *interpret* or a combination of both.
- Languages such as `C, C++, and Objective-C` are compiled languages
- Languages such as `PHP and JavaScript` are interpreted languages.
- `Java, C# and Python `are a combination of both.

## Integrated Development Environments

* XCode: Used to develop Apple programming for iOS and MacOS development.
* Visual Studio Code: Used to develop in a multitude of languages.
    - Has an auto-complete functionality

## Why Python?

* The most popular programming languages are currently: `Java, Python, JavaScript, C++ and C#`.
* Python and JS have concise syntax.
    - JS is a web development language.
    - Python is a general usage language which can create web apps, internal company tools, scientific analysis, and games.

Python Example:

```python
name = input("Hi, what's your name? ")
age = int(input("How old are you? "))

if (age < 13):
    print("You're too young to register", name)
else:
    print("Feel free to join," name)
```

* *Statements* are the building blocks of any program.
    - They are made up of *keywords*, *expressions* and *operators*
    - **Operators** are symbols that tell the computer to perform an action with some input.
        + Eg. `+`, `-`, `*`, `/`
        + The digits would be the *operands* or *input*
    - **Expressions** are
    - **Keywords** are

> There are two ways to write error-free programs; only the third one works. --Alan Perlis

Error Categories:

* Syntax: Language rules broken
* Runtime: Unable to execute the program
* Semantic: Unexpected output

Variables and Data-types:

* A variable is a **container** for a value
    * Use the assignment operator `=` to assign a value to a variable.
* Datatype are categories for different kinds of variables.
    - Eg. a *string* or *integer*

```java
// In Java, the data type is needed for variables.
String = cookie = "Sugar";
System.out.println(cookie);
```

* Variable names should only contain letters, numbers, and underscores.
    - No spaces, and do not start names with a number.
    - Case-sensitive and no keywords allowed

## Numbers

* `**` is used for exponents
* `//` is a floor division (no remainder)
* `%`  is used for modulation (only remainder)
* `float` is a number that contains a decimal

## Strings

* Representing by beginning and ending quotes (single or double)

## Whitespace

* Add blank lines and spaces for the sake of readability

```python
# Greet the User
print("Hi!")
name = input("What's your name? ") # Asks user their name

print("It's nice to meet you, " name, "!")
answer = input("Are you enjoying the course so far? ")

if answer == "Yes":
    print("That's really good to hear!")
else:
    exit()
```

## Challenge 1

```python
# A message for the user
message = "This is going to be very tricky! >;)"
Message = "Very tricky!"
print(message)

result = 2**3
print("2**3 = " result)
result = 5 - 3
#print("5 - 3 =", result)

print("Challenge complete!")
```

* Any expression that breaks down to either *true* or *false* is considered a `conditional` or `boolean`
* Relational operators:
    - `operand1 (operator) operand2 => True/False`
* Equality operator `==` and `!=` is an inequation operator.

## Conditional Code

if {condition}:
    execute this code <- block of code
    four spaces (tab) are needed for code blocks
else:
    execute this code

```python
plant = "Cacti"

if plant == "Cacti":
    print(plant, "don't need a lot of water!")
else:
    print(plant, "love water!")

print("Thanks!")
```

```java
if (5 > 6) {
    System.out.println("nope!");
}
else {
    System.out.println("yes!");
}
```

```ruby
if 5 > 6
    puts "nope!"
else
    puts "yes!"
end
```

```python
answer = "Pizza"
# Greet the User
print("Hi!")
# Asks user to guess my favorite food.
food = input("What's my favorite food? ")

if answer == food:
    print("Yep! So amazing!")
else:
    print("Yuck! That's not it!")

print("Thanks for playing!")
```

## Functions

* Functions are blocks of code packaged together with a name
    - eg. `print()` or `input()`

```python

print("This is The Shimmy!")

def shimmy():
    print("Take one step to the right and stomp!")
    print("Take on step to the left and stomp!")
    print("Shake those hips!")

shimmy()

```

Creating a function:

```python

def say_hello():
    print("Hello, friends!") # body of function

say_hello()
```

## Parameters and Arguments

My Solution:

```python

gold_paid = "Gold"
bronze_paid = "Bronze"

amount_paid = input("Would you like the bronze or gold car wash? ")

def goldWash():
    print("Scrub, scrub, scrub! Ultra clean!")

def bronzeWash():
    print("Scrub, scrub! Pretty clean!")

if amount_paid == gold_paid:
    goldWash()
elif amount_paid == bronze_paid:
    bronzeWash()
```

Lynda Solution:

```python

# Parameter in ()
def wash_car(amount_paid):
    if (amount_paid == 12):
        print("Scrub, scrub, scrub! Ultra clean!")

    if (amount_paid == 6):
        print("Scrub, scrub! Pretty clean!")

# Argument in ()
wash_car(6)
```

## Returning Values from Functions

```python

def withdraw_money(current_balance, amount):
    if (current_balance >+ amount):
        current_balance = current_balance - amount
        return current_balance

balance = withdraw_money(100, 80)

if (balance <= 50):
    print("A deposit is needed!")
else:
    print("Nothing to see here!")
```

```java

void hello() {
    System.out.println("Hi friends!");
}

```

```java
// Kotlin programming language
fun checkGrade(grade: String) {
    if (grade == "A")
        println("You aced the class!")
}
```

```ruby
puts "Paycheck Calculator"

def calculate_check(hourly_rate)
    hourly_rate * 40
end

puts "You made #{calculate_check(32)} this week!"
```

## Challenge: Favorite Cities

```python

def favorite_city(name):
    if name = "Winnipeg"
        print("Winnipeg, MB")
    if name = "Calgary"
        print("Calgary, AB")
    if name = "Victoria"
        print("Victoria, BC")

print("One of my favorite cities is ")

favorite_city("Winnipeg")

```

Other Solution:

```python

def favorite_city(name):
    print("One of my favorite cities is, " name)

favorite_city("Calgary")
favorite_city("Winnipeg")
favorite_city("Victoria")
```

* A `library` is a grouping of variables and functions that someone else has written and verified
