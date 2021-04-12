---
layout: default
title: Python Fundamentals 2
parent: Programming
---

**Table of Contents:**

- [Introduction](#introduction)
- [Python Anatomy](#python-anatomy)
  - [Expressions and Statements](#expressions-and-statements)
- [Blocks and Scopes](#blocks-and-scopes)
  - [Loops](#loops)
  - [Bitwise Operators](#bitwise-operators)
  - [Operator Precedence](#operator-precedence)
- [Python Loops](#python-loops)
- [Functions](#functions)

## Introduction

- **Python** is a modern, object-oriented scripting language.
- Python was developed in the late 1980s by Dutch research programmer Guido van Rossum.
  - Guido wrote the first Python interpreter over his Christmas holiday in 1989.
  - He chose the name Python as a reference to Monty Python's Flying Circus.
  - Guido remains Python's principal author to this day, and the Python community affectionately refers to him as BDFL, Benevolent Dictator For Life.
- There's a core philosophy behind the Python language, which includes the following statements:
  - Beautiful is better than ugly.
  - It's always a good idea to make your code elegant and readable. Explicit is better than implicit.
  - Don't make your readers guess what your code does, make it obvious.
  - Simple is better than complex.
  - If you can make it simple, do.
  - Complex is better than complicated.
  - If complexity is necessary, don't complicate it.
  - Readability counts.
  - As a casual reader with a good understanding of the Python language, you should be able to understand the code with a minimal amount of effort.
- The design principles of Python can be found if you type in `import this` into any Python interpreter.
- Python 3 is not backwards compatible with the original Python 2:
  - Everything in Python 3 is an object.
  - `print()` is a function, not a statement, and thus requires parenthesis.
  - There is only a single integer type in Python 3.
  - All text is now Unicode.
  - Python 3 is a decade old, and thus all new code should be written in it, with legacy code of Python 2 being maintained.
  - Division of two integers will result in a float.
- Python does not use braces or semicolons.
  - Instead, line endings and indentations are meaningful.
- The purpose of `Hello World` is to validate your development environment.
  - Whenever you set up a new development environment, it's a good idea to use a simple, minimal, and functional program to confirm that your development cycle functions as you expect, and that's what `Hello World` is for.
- There are no half-measures with whitespace. Either a piece of code is in a block or it isn't.

```python

def main():
    x = 42
    print("Hello, world! {}".format(x))
    # Newer Version:
    print(f"Hello, world! {x}")

if __name__ == "__main__":
    main()

```

## Python Anatomy

`#!/usr/bin/env python3`
`#!/usr/local/bin/python3`

- There is sometimes a **shebang** line at the beginning of Python code.
  - The shebang line is a common pattern for Unix-based systems.
  - It allows scripts to be invoked from the command line.

```python
#!usr/bin/env python3

import platform

def main():
    message()

def message():
    print("This is Python version: {}".format(platform.python_version()))

# By having this conditional statement at the bottom that calls main,
# it actually forces the interpreter to read the entire script before it
# executes any of the code.
# This allows a more procedural style of programming, and it's because
# Python requires that a function is defined before it's called.
if __name__ == "__main__":
    main()

```

### Expressions and Statements

- In general terms, a _statement_ is a unit of execution, and an _expression_ is a unit of evaluation.
- In Python specifically, an expression is any combination of _literals_, _identifiers_, and _operators_.
  - Generally, this means anything that returns a value is an expression.
  - Eg. `x=y`, `x*y`, `(x, y)`, `True`, `f()`

## Blocks and Scopes

```python
#!usr/bin/env python3

x = 42
y = 73

if x < y:
    z = 101
    print('x < y: x is {} and y is {}'.format(x, y))

# Blocks do not define scope in Python.
# Functions, objects, and modules do define scope.
print("z is {}".format(z))
```

### Loops

- Python provides two basic types of loops.
- A **While** loop tests a _conditional expression_ and the body of the loop is executed while the condition remains true.
- A **For** loop iterates over a _sequence_ (elements) and the body of the loop is executed for each element of the sequence and until the sequence is exhausted.

```python

words = ["One", "Two", "Three", "Four", "Five"]

n = 0
while(n < 5):
    print(words[n])
    n += 1

for word in words:
    print(word)

```

```python

# A Simple Fibonacci series
# The sum of two elements defines the next set.

a = 0
b = 1

while a < 1000:
    print(a, end = " ", flush = True)
    print(b, end = " ", flush = True)
    a = a + b
    b = a + b

print("\n")

c = 0
d = 1

while d < 1000:
    print(d, end = " ", flush = True)
    c, d = d, c + d
```

```python
#!/usr/bin/env python3

# Method to create space between
# various testing outputs.
def new():
 print("\n")

def function(n = 2):
 print(n)
 return n * 2

# Will print 42
x = function(42)

# Will print 'None' because there
# is an absence of value.
function(x)

### Primes ###

def isPrime(n):
 if n <= 1:
  return False
 for x in range(2, n):
  if n % x == 0:
   return False
 else:
  return True

n = 5
# print("Hello, world! {}".format(x))
if isPrime(n):
 print("{} is prime!".format(x))
else:
 print("{} is not prime!".format(x))

isPrime(n)

def listPrimes():
 print("\n Here is a list of prime numbers:")
 for n in range(100):
  if isPrime(n):
   # print(n, end=" ", flush=True)
   print(n)


listPrimes()
new()

### Objects ###

class Duck:
 sound = "Quack!"
 walking = "It walks like a duck!"

 # Self is reference to the object when
 # the class is used to create an object.
 def quack(self):
  print(self.sound)

 def walk(self):
  print(self.walking)

def main():
 donald = Duck()
 donald.quack()
 donald.walk()

if __name__ == "__main__":
 main()

### Types ###

# Python uses a form of dynamic typing
# sometimes called "duck typing" where
# the type of a value is determined by
# the value itself.

new()

x = 7
y = 7.0
z = "seven"
a = True
b = None

print("x is {}".format(x))
print(type(x))
print("y is {}".format(y))
print(type(y))
print("z is {}".format(z))
print(type(z))
print("a is {}".format(a))
print(type(a))
print("b is {}".format(b))
print(type(b))

### Strings ###

new()

x = """
Strings can be on multiple lines!
"""

print(x)

y = "Seven".capitalize
z = "Seven {1:9} {0:>9".format(8, 9)

### Numerics ###

# Floating point numbers are precise, but
# their precision comes at the sacrifice
# of being accurate.

from decimal import *

a = Decimal(".10")
b = Decimal(".30")
x = a + a + a - b
# x = 0.1 + 0.1 + 0.1 - 0.3

```

```python

### The Boolean Type ###

x = "x"
print("x is {}.".format{x})
print(type(x))

if x:
    print("True")
else:
    print("False")

### Sequence Types ###

x = [ 1, 2, 3, 4, 5 ]
# You can modify values of elements in lists.
x[1] = 5

# Will start at zero, and end at 5.
range1 = range(5)
# Adding a second argument will change the range
# to go from the first number to the second.
range2 = range(5, 10)
# Adding a third argument will change the 'step'
# count between each number going from the first
# number to the second (eg. 5, 9, 13, 17, 20)
range3 = range(5, 60, 4)

# Tuples however cannot be changed as their
# elements are immutable.
z = ( 1, 2, 3, 4, 5 )
for i in z:
    print("i is {}".format(i))

# A Dictionary is a search-able sequence of key/value pairs.
x = { "one": 1, "two": 2, "three": 3, "four": 4, "five": 5}
# You must specify two arguments in a for loop in order
# to run through both the key and value of each element.
# Either the key or the value can be any type.
for k, v in x.items():
    print("k is {}, v is {}".format(k, v))


### type() and id() ###

# Python has thorough class inspection capabilities.

x = ( "one", 2, 3.0, [4, "four"], True, None )
y = ( "one", 2, 3.0, [4, "four"], True, None )

print("x is {}".format(x))

print(type(x))
print(type(x[1]))

# ID Function returns a unique identifier.
print(id(x))
print(id(y))

# However, these IDs are identical because there
# is only one literal number 2 object.
print(type(x[1]))
print(type(y[1]))

if x[1] is y[1]: print("They are the same!")
if 0 is false: print("False and 0 are the same!")

if isinstance(x, tuple): print("The variable x is a tuple!")


### Conditional Syntax ###

if True:
    print("If True")
elif False:
    print("Elif True")
else:
    print("Neither True")

# The if/elif/else conditional acts as a switch case in Python.

x = 2

if x == 0:
    print("x is zero.")
elif x == 1:
    print("x is one.")
elif x == 2:
    print("x is two.")
else:
    print("x is a different number.")
```

- The conditional operators of Python include:
  - Comparison operators - If an element is greater, equal, unequal, or less than another element.
  - Logical operators - `and`, `or`, or `not`, used to test multiple element's states at once.
  - Identity operators - `is` and `is not`. If a variable is a specific type.
  - Membership operators - If a variable is a part of a specific collection.

```python

# Ternary conditional operator example #

hungry = True
feed = "Feed the bear!" if hungry else "Do not feed the bear, he is not hungry."
print(x)
```

### Bitwise Operators

- Bitwise operators are utilized on bits, not logical operators used for conditional constructs.
  - `&` - And
  - `|` - Or
  - `^` - Xor
  - `>>` - Shift left
  - `<<` - Right right

```python

# These variables are literal hexidemical numbers.
x = 0x0a
y = 0x02

z = x & y

# "And" operation will only set a bit if both of the
# operands have a bit set in that position.
print(f"(hex) x is {x:02x}, y is {y:02x}, z is {z:02x}")
print(f"(bin) x is {x:08b}, y is {y:08b}, z is {z:08b}")

a = 0x0a
b = 0x05
c = a | b

# With the "Or" operator, all the bits in c will be set.
print(f"(hex) a is {a:02x}, b is {b:02x}, c is {c:02x}")
print(f"(bin) a is {a:08b}, b is {b:08b}, c is {c:08b}")
```

### Operator Precedence

Python operator precedence is as follows:

- `**` Exponents
- `+x`, `-x` Positive, Negative Elements
- `*`, `/`, `//`, `%` Multiplication, Division and Remainder
- `+`, `-` Addition and Subtraction
- `<<`, `>>` Bitwise shifts
- `&` Bitwise AND
- `^` Bitwise XOR
- `|` Bitwise OR
- `in`, `not in`, `is`, `is not`, `<`, `<=`, `>`, `>=`, `=!`, `==` Comparisons (including membership tests, and identity tests.)
- `not x` Boolean NOT
- `and` Boolean AND
- `or` Boolean OR

## Python Loops

- Python has two basic forms of loops, `while` loops and fo`r loops.
- A **While** loop uses a conditional expression to control the loop.
  - When the condition is true, the body of the loop is executed. When the body is complete, the condition is tested again.
  - And if the condition is still true, the body is executed again.
  - The loop continues as long as the condition is true, and when the condition is false, the loop ends and execution continues with the lines of code after the loop.
- A **For** loop uses a sequence, like an iterator or a list, tuple, or other collection type to control the loop.
  - The body of the loop is executed for each item in the sequence, and when the sequence is exhausted the loop ends.

```python

# Example of While loop

secret = "swordfish"
pw = " "
auth = False
count = 0
maxAttempt = 5

while pw != secret:
    count = count + 1
    if count > maxAttempt: break
    pw = input(f"{count}: Please enter the secret word:\n")
    # Will skip over the rest of the loop in the fifth iteration
    if count == 5: continue
    if pw == "swordfish":
        auth = True
        print("Correct! You may enter.")
    else:
        print("Incorrect! Try again.")

print("Authorized." if auth else "You have entered the secret word incorrectly too many times.")
```

```python

# Example of For loop

animals = ( "Bear", "Bunny", "Dog", "Cat", "Velociraptor")

for pet in animals:
    if pet == "Velociraptor": continue
    print("Your pet is {}!".format(pet))
else:
    print("That is all of the pets.")
```

## Functions

- Python has no distinction between a function and a procedure.

```python

# Function Definition Example

def main():
    x = kitten()
    print(x)

def kitten():
    return "Meow."


# The special variable name will return the name of the current
# module.
# If this file had been included in another execution
# unit by the import statement, then this would be running as
# a module.
# However, this is not an imported file, so it instead is given
# the special variable name "main", which means it is the main
# unit of execution.
# This also is a substitution for "For Declarations" which Python
# does not support.
if __name__ == "__main__":
    main()

```
