# Unit Testing and Test Driven Development in Python

## Introduction

* Having a buggy code base causes lots of problems. 
  - It can affect your schedule, some portion of your development team has to stop new future development to go back and fix critical bugs. 
  - It can slow down development in general, as developers will be more weary to make changes when they are working in a buggy and brittle code base.
  - And it can erode your customer's confidence. Both because they are experiencing the bugs and because of your slip schedule on new features while you're fixing those bugs. 
* You need to have a multi-layered safety net of tests in place that will catch any bugs that might get introduced. 
    - And the first layer of this safety net should be a sweep of automated unit tests. Units test verify your code at the level of functions and classes.
    - They perform positive and negative tests at the lowest level of your code. Every line of your **production** code should have an associated unit test that verifies it's working as expected. 
* **Test-driven development**, or TDD, is a practice of writing unit tests before you write your production code. 
    - This is backwards to the way most developers write code but it has many benefits. 
    - You know every line of production code is working as soon as it's written, because you're testing it immediately. 
    - If there is a problem it's easy to track down as you've only written a small amount of code since the last test executed.
    - And TDD gives you and your team confidence to change the code as you'll know immediately if anything has gotten broken by any particular code change.

## Overview of Test-Driven Development

### What is a Unit Test?

* Why do we go through the effort of writing and running unit test? Because software bugs can hurt the business. 
    - We don't want any bugs making it out to the field for our customers to see it's that could hurt our reputation and cause customers to look at using other products.
* Software testing attempts to address this problem by catching any bugs in the software before they get to the field. 
    - This is done systematically with a multi-layered approach where each layer of testing provides a safety net for catching bugs before they get to the field. 

There are several levels of testing which provide the layers of safety nets for catching any bugs that might be in the code:

* The lowest level are **unit tests**. Unit tests validate individual functions in the production code. 
    - Unit tests are generally the most comprehensive test which should test all positive and negative test cases for a function. 
* Next comes **component-level testing**, which tests at the library and compiled binary level.
    - And which test the external interfaces for individual components. Components are essentially a collection of the functions.
* Then comes **system-level testing**, which tests the external interfaces at a system level. 
    - Systems can be collections of components or sub-systems. 
* And lastly, comes **performance testing**, which test systems and sub-systems at expected production loads to verify that response times and resource utilization, eg. Memory, CPU and disk usage are acceptable.

Unit Testing Specifics:

* Unit testing test individual functions in the code. 
    - Each test case for the function should have a corresponding unit test. 
    - Groups of unit tests can be combined into test suites which can help with organizing the test. 
    - The unit test should execute in your development environment rather than the production environment. This is important to ensure that you can run them easily and often. 
    - And lastly, the unit test should be implemented in an automated fashion.

```python

# Simple Unit Test Example

import pytest

# Product Code
def string_length( theString ):
    return len(theString)

# A Unit Test
def test_string_length():
    # 1. The Setup
    testString = "1"
    # 2. The Action 
    result = string_length(testString)
    # 3. The Assertion
    assert result == 1
```

### What is Test-driven Development?

* Test-driven Development (TDD) is a process for writing code that helps you take personal responsibility for the quality of your code. 
    - The process drives this by having you write the unit tests **before** the production code. 
    - This can seem pretty strange at first, but after you've used the process for a while, it becomes the norm and you'll find it hard to write code any other way.
* Even though the tests are written before the production code, that doesn't mean that all the tests are written first. 
    - You write *one* unit test for *one* test case and then you write the production code to make it pass. 
* The tests and the production code are written together with small tests being written and then small bits of production code that make those tests pass. 
    - This short cycle of writing a unit test and then writing the production code to make it pass provides immediate feedback on the code. This feedback is one of the essential features of TDD. 
*  What are the benefits of using TDD? 
    - TDD gives you confidence to make changes in your code because you have to test before you begin that verifies the code is working and will tell you if any of your changes have broken anything. 
    - This confidence comes from the immediate feedback the test provide for each small change in the production code. 
    - The test document what the production code is supposed to do and a new developer looking at the code can use the unit test as **a source of documentation** for understanding what the production code is doing. 
    - Writing the unit test first helps drive good object oriented design as making individual classes and functions testable and isolation drives the developer to break the dependencies and add interfaces rather than linking concrete implementations together directly.

History of TDD:

* TDD was created by Kent Beck in the mid 1990s as part of his work for the Chrysler Corporation.
    - He also created Extreme Programming, of which TDD is just a part. He then went on to create one of the first unit testing frameworks for TDD in Smalltalk called SUnit.
* Then he collaborated with Erich Gamma to implement the first Java unit testing framework called JUnit.
    - JUnit has since been the basis for many other xUnit testing frameworks implemented for other languages.
* In 2008, Robert Martin, aka, Uncle Bob created the following laws of TDD in his book, *Clean Code: A Handbook of Agile Software Development.*
    - These laws help ensure you're following the TDD process. 
* The first law: **"You may not write any production code until you have first created a failing unit test."** Falls along with the idea of writing the unit test first. 
    - Seeing your new unit test fail before you've implemented the production code is a sign that the unit test has been implemented properly. 
* The second law: **"You may not write more of a unit test than is sufficient to fail"**, forces you to write only enough of a unit test for the next test case.
    - And the next test case should always be the simplest test case. 
* The last law: **"You may not write more production code than is sufficient to pass the currently failing unit test"**, keeps you from writing production code without any unit test to verify it. 
* These three laws help to keep you in a small, tight loop of writing a little test that fails, then writing a little production code to make it pass.
    - Each iteration of the loop should only be a few minutes long and you're always running the unit test to verify nothing is gotten broken.
    - If something does get broken, you can easily back out the changes that caused the problem because you implemented them in just the last couple of minutes. 

TDD Workflow: 

* The TDD work flow is broken up into three phases referred to as the red phase, green phrase, and refactor phase. 
* The first phase is the **red phase**. In the red phase, you write a failing unit test for the next bit of functionality you want to implement in the production code.
* Next comes the **green phase**, where you write just enough production code to make the failing unit test pass. 
* Last is the **refactor phase**, where you clean up the unit test and the production code to remove any duplication and make sure the code follows your team's coding standards and best practices. 
* You then repeat the process for all the functionality you need to implement and all the positive and negative test cases.

### Test Case: FizzBuzz

*  Implementing a function that is passed in an integer value as an input, and the function will return:
    - The string Fizz if the passed in number is a multiple of three,
    - The string Buzz if the passed in number is a multiple of five, 
    - The string FizzBuzz if the passed in number is a multiple of three and five. 
    - And if the value is not a multiple of three or five then the value itself is returned as a string.
* "Use Cases" are what is to be implemented in testing, usually in increasing order of difficulty or complexity.
* A common occurrence with TDD is to implement some functionality in a very specific way in one test case, and then generalize it in other test cases.

Use Cases:

* Can I call FizzBuzz?
* Get "1" when I pass in 1?
* Get "2" when I pass in 2?
* Get "Fizz" when I pass in 3?
* Get "Buzz" when I pass in 5?
* Get "Fizz" when I pass in 6? (Multiple of 3)
* Get "Buzz" when I pass in 10? (multiple of 5)
* Get "FizzBuzz!" when I pass in 15? (a multiple of 3 and 5)

```python
# fizz_buzz_test.py
import pytest

# FIZZBUZZ #
def fizz_buzz (value):
    if fizz_buzz_multiple(value, 3):
        if fizz_buzz_multiple(value, 5):
            return "FizzBuzz!"
        return "Fizz"
    if fizz_buzz_multiple(value, 5):
        return "Buzz"
    return str(value)

def fizz_buzz_multiple(value, mod):
    return ( value % mod == 0)

# TESTS #
def test_canAssertTrue():
    assert True

# Redundant, as the following test case
# demonstrates that fizz_buzz can be called.
def test_canFizzBuzzBeCalled():
    fizz_buzz(1)

def test_returns1With1PassedIn():
    return_value = fizz_buzz(1)
    assert return_value == "1"

def test_returns2With2PassedIn():
    return_value = fizz_buzz(2)
    assert return_value == "2"

# Above two tests can be refactored as follows:
def check_fizz_buzz(value, expected_return_value):
    return_value = fizz_buzz(value)
    assert return_value = expected_return_value

def test_returns1With1PassedIn():
    check_fizz_buzz(1, "1")

def test_returns2With2PassedIn():
    check_fizz_buzz(2, "2")

def test_returnsFizzWith3PassedIn():
    check_fizz_buzz(3, "Fizz")

def test_returnsBuzzWith5PassedIn():
    check_fizz_buzz(5, "Buzz")

def test_returnsFizzWith6PassedIn():
    check_fizz_buzz(6, "Fizz")

def test_returnsBuzzWith10PassedIn():
    check_fizz_buzz(10, "Buzz")

def test_returnsFizzBuzzWith15PassedIn():
    check_fizz_buzz(15, "FizzBuzz!")

```

## Testing in Development Environments

* what are Python Virtual Environments? 
    - By default all python packages are installed to a single directory on the system.
     - This can become a problem when you have multiple python projects that have different and potentially conflicting dependencies. 
        + For example, Project A needs Version One of a particular library, while Project B needs Version Two of that same library.
    - This is problematic as the python run-time cannot have both versions of a library installed at the same time. 
* Virtual environments solve this problem by creating isolated python environments that can be customized per project. 
    - This is done by creating a new directory for each virtual environment, with links or copies of the python executable library and tools. 
    - Then sub-directories are added to hold the installed packages for that particular virtual environment. 
    - When a virtual environment is activated, the `PATH` environment variable is updated to point first to the virtual environment's bin directory. 
    - This means that the virtual environment's python instance will be found and executed when python is run and subsequently the packages installed in that virtual environment will be used.

### Virtual Environments in Python 2.7

* To use virtual environments with Python 2.7, you need to install the virtualenv package with the command `pip install virtualenv`. 
    - Once virtualenv is installed, you can create a new virtual environment with the command `virtualenv [name]`.
    - Once your virtual environment has been created, you can activate it by sourcing the activate script in the environment's bin directory. 
    - And you can deactivate the virtual environment by simply typing the deactivate command. 
    - And lastly, you can delete the virtual environment by deleting the top level directory that was created when you initially ran the virtualenv command. 

### Virtual Environments in Python 3

* Python 3 comes with a built-in module for creating virtual environments call `venv`.
* The `virtualenv` command that we use with Python 2.7 can be use with Python 3 as well, but using `venv` is the preferred approach, as it's already built-in to Python 3. It also creates smaller virtual environments, and is extendable with the ability to use additional plug-ins. 
* The commands to activate, deactivate, or delete a virtual environment are all the same for `venv` in Python 3 as they were for `virtualenv` with Python 2.7. The only difference is the command to create a virtual environment. 
    - To create a virtual environment with `venv`, you run the command `python3 -m venv [name]`.
    - Eg. `python3 -m venv pytest_3_venv`, followed by `source pytest_3_venv/bin/activate/`, and then `pip3 install pytest`.
    - To deactivate simply just type `deactivate`.
