# Unit Testing and Test Driven Development in Python

**Table of Contents:**

- [Unit Testing and Test Driven Development in Python](#unit-testing-and-test-driven-development-in-python)
	- [Introduction](#introduction)
	- [Overview of Test-Driven Development](#overview-of-test-driven-development)
		- [What is a Unit Test?](#what-is-a-unit-test)
		- [What is Test-driven Development?](#what-is-test-driven-development)
	- [Pytest Overview](#pytest-overview)
		- [Test Discovery](#test-discovery)
		- [Xunit-Style Setup and Teardown](#xunit-style-setup-and-teardown)
		- [Test Fixtures](#test-fixtures)
		- [Assert Statements and Exceptions](#assert-statements-and-exceptions)
		- [Pytest Command Line Arguments](#pytest-command-line-arguments)

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

**Unit Testing Specifics:*8

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

**History of TDD:**

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

**TDD Workflow: **

* The TDD work flow is broken up into three phases referred to as the red phase, green phrase, and refactor phase. 
* The first phase is the **red phase**. In the red phase, you write a failing unit test for the next bit of functionality you want to implement in the production code.
* Next comes the **green phase**, where you write just enough production code to make the failing unit test pass. 
* Last is the **refactor phase**, where you clean up the unit test and the production code to remove any duplication and make sure the code follows your team's coding standards and best practices. 
* You then repeat the process for all the functionality you need to implement and all the positive and negative test cases.

## Pytest Overview

- What is PyTest? 
	- **PyTest** is a Python unit testing framework. It provides the ability to create tests, test modules, test classes, and test fixtures. 
	- It uses the built-in Python `assert` statement which makes implementing unit tests much simpler than other Python unit testing frameworks. 
	- It also adds many useful command line arguments to help specify what tests should be run and in what order.
*  In PyTest, individual tests are Python functions with `test_` at the beginning of the function name. 
	- The unit tests then execute production code and use the standard Python assert statement to perform verifications on results. 
	- Similar tests can be grouped together by including them in the same module or class.
* Eg. run `pytest -v` from the command line. The -v tells PyTest to run in verbose mode, and it will tell me which unit test it's running and if they pass or not.

### Test Discovery

* PyTest will automatically find your tests when you run it from the command line using several naming rules for the test files, test classes, and test functions. 
	- Test function names should begin with `test`. Eg. `def test_it2():`
	- Classes with tests in them should have the word `Test` with a capital **T** at the beginning of the class name. These classes should also have no init method. The file names for test modules should start with test underscore or end with underscore test.
	- The file names for test modules should start with test underscore or end with underscore test. Eg. `test_example.py` or `example_test.py`

```python
# File name: test_file.py


class TestClass:
	def test_me(self):
		assert True

	def testme2(self):
		assert True

# Will not run with Pytest, as it
# does not follow naming convention.
class MyTestClass():
	def test_it(self):
		assert True

	def test_it2(self):
		assert True

```

### Xunit-Style Setup and Teardown

* One key feature of all unit test frameworks is providing the ability to execute setup code before and after the test. 
	- Pytest provides this capability with both xUnit-style setup and teardown functions and with pytest fixtures. 
	- The xUnit-style setup and teardown functions allow you to execute code before and after: test modules, test functions, test classes, and test methods in test classes.
	- Eg. `def setup_module():`, `def teardown_module():`, `def setup_function():`, `def teardown_function():`, `def setup_class():`, `def teardown_class():`, `def setup_method():`, and `def teardown_method():`.
* Using these setup and teardown functions can help reduce code duplication by letting you specify the setup and teardown code once at each of the different levels as necessary rather than repeating the code in each individual unit test. 
	- This can help keep your code clean and manageable.

```python 
# run: pytest -v -s


# Class Example #

# Note: The setup class and teardown class methods
# have the @classmethod decorator applied, as they
# are passed in the uninstantiated class object
# rather than a unique instance of the class.

class TestClass:
	@classmethod
	def setup_class(cls):
		print("Setup TestClass!")

	@classmethod
	def teardown_class(cls):
		print("Teardown TestClass!")

	def setup_method(self, method):
		if method == self.test1:
			print("\nSetting up test1!")
		elif method == self.test2:
			print("\nSetting up test2!")
		else:
			print("\nSetting up unknown test!")

	def teardown_method(self, method):
		if method == self.test1:
			print("\nTearing down test1!")
		elif method == self.test2:
			print("\nTearing down test2!")
		else:
			print("\nTearing down unknown test!")

	def test1(self):
		print("Executing test1!")
		assert True

	def test2(self):
		print("Executing test2!")
		assert True


# Module Example #

def setup_module(module):
	print("Setup Module!")
	return module

def teardown_module(module):
	print("Teardown Module!")
	return module

def setup_function(function):
	if function == test1:
		print("\nSetting up test1!")
	elif function == test2:
		print("\nSetting up test2!")
	else:
		print("\nSetting up unknown test!")

def teardown_function(function):
	if function == test1:
		print("\nTearing down test1!")
	elif function == test2:
		print("\nTearing down test2!")
	else:
		print("\nTearing down unknown test!")

def test1():
	print("Executing test1!")
	assert True

def test2():
	print("Executing test2!")
	assert True
```

### Test Fixtures

* Like the xUnit style of setup and teardown functions, Test Fixtures allow for re-use of code across tests by specifying functions that should be executed before the unit test runs. 
	- Specifying that a function is a Test Fixture is done by applying the `pytest.fixture` decorator to the function.
* Individual unit tests can specify they wanna use that function by specifying it in their parameter list, or by using the `pytest.mark.usefixture` decorator. 
	- The fixture can also set its autouse parameter to true, which will cause all tests in the fixture scope to automatically execute the fixture before the test executes. 
*  It can be very useful for each individual test to be able to specify which test fixtures it needs executed before the test is run. 
	- But this can also be cumbersome for those cases where all the tests need to run the same test fixture. 
	- In this case, the `autouse` parameter of the test fixture can be set to true, and then the fixture will automatically be executed before each test that is in the fixture scope. 

```python
import pytest

@pytest.fixture()
def setup():
	print("\nSetup!")

# Argument Example
def test1(setup):
	print("Executing test1!")
	assert True

# Decorator Example
@pytest.mark.usefixtures("setup")
def test2():
	print("Executing test2!")
	assert True

###

# autouse Example
@pytest.fixture(autouse=True)
def setup():
	print("\nSetup!")

def test1():
	print("Executing test1!")
	assert True

def test2():
	print("Executing test2!")
	assert True
```

*  Often, there is some type of teardown or cleanup that a test, class or module needs to perform after testing has been completed. 
	- Each Test Fixture can specify their own teardown code that should be executed. There are two methods of specifying a teardown code for a Test Fixture: `yield` and `addfinalizer`.
* The `yield` keyword is the simpler of the two options for teardown code. The code after the yield statement is executed after the fixture goes out of scope.
	- The `yield` keyword is a replacement for return, and any return values should be passed to it. 
* The `addfinalizer` method of adding teardown code is a little more complicated, but also a little more capable than the yield statement. 
	- With the `addfinalizer` method, one or more finalizer functions are added via the request-context's addfinalizer method. 
	- One of the big differences between this method and the `yield` keyword is that this method allows for multiple finalization functions to be specified. 

```python
import pytest

# Yield Example
@pytest.fixture()
def setup3():
	print("\nSetup 3!")
	yield
	print("\nTeardown 3!")

# Addfinalizer Example
@pytest.fixture()
def setup4(request):
	print("\nSetup 4!")

	def teardown_a():
		print("\nTeardown A!")

	def teardown_b():
		print("\nTeardown B!")

	request.addfinalizer(teardown_a)
	request.addfinalizer(teardown_b)

def test3(setup3):
	print("Executing test3!")
	assert True

def test4(setup4)
	print("Execute test4!")
	assert True
```

* Which test a fixture applies to, and how often it is run, depends on the fixture scope.
* Test Fixtures have four different scopes that are possible: 
	- By default, the scope is set to Function. And this specifies that the fixture should be called for all tests in the module. 
	- Class scope specifies that the Test Fixture should be executed once per test class. 
	- Module scope specifies that the fixture should be executed once per module. 
	- And Session scope specifies that the fixture should be executed once when pytest starts.

```python
import pytest

# Scope Example #
@pytest.fixture(scope="session", autouse=True)
def setupSession():
	print("\nSetup Session!")

@pytest.fixture(scope="module", autouse=True)
def setupModule():
	print("\nSetup Module!")

@pytest.fixture(scope="function", autouse=True)
def setupFunction():
	print("\nSetup Function!")

class TestClass:
	def test5(self):
		print("Executing test5!")
		assert True

	def test6(self)
		print("Execute test6!")
		assert True
```
### Assert Statements and Exceptions

* Pytests allows the use of the built in Python assert statement for performing verifications in a unit test. 
    * The normal comparison operators can be used on all Python data types. 
    * Eg. `<` Less than, `>` greater than, `<=` less than or equal, `>=` greater than or equal, `=` equal, or `!=` non equal. 
    * Pytests expands on the messages that are reported for assert failures to provide more context in the test results.

```python
def test_IntAssert():
	assert 1 == 1

def test_StrAssert():
	assert "str" == "str"

def test_floatAssert():
	assert 1.0 == 1.0

def test_arrayAssert():
	assert [1,2,3] == [1,2,3]

def test_dictAssert():
	assert {"1":1} == {"1":1}
```

* Validating floating point values can sometimes be difficult, as internally the value is stored as a series of binary fractions. (Eg. 1/3 internally is 0.33333...)
    * Because of this, some comparisons that we'd expect to pass, will fail. 
    * Pytests provides the approx function, which will validate the two floating point values, or approximately the same value, as each other, to then a default tolerance of `1xe^-6`. 

```python
from pytest import approx

# Failing Floating Point Test
def test_BadFloatCompare():
	assert (0.1 + 0.2) == 0.3

# Passing Floating Point Test
def test_GoodFloatCompare():
	val = 0.1 + 0.2
	assert val == approx(0.3)
```

* In some test cases, we need to verify that a function raises an exception under certain conditions.
    * Pytest provides the `raises` helper to perform this verification, using the `with` keyword. 
    * When the raises helper is used, the unit test will fail if the specified exception is not thrown in the code block, after the raises line.

```python
from pytest import raises

def raisesValueException():
	raise ValueError
	# Will cause test failure:
	# pass
	

def test_Exception():
	with raises(ValueError)
		raisesValueException()
```

### Pytest Command Line Arguments

* By default, PyTest runs all tests that it finds in the current working directory and sub-directory using the naming conventions for automatic test discovery. 
    * There are several PyTest command line arguments that can be specified to try and be more selective about which tests will be executed. 
    * You can simply pass in the module name to execute only the unit tests in that one particular module. 
    * You can also simply pass in a directory path to have PyTest run only the tests in that directory.
* The `-k` option to specify an evaluation string based on keywords such as the module name, the class name, and the function name. 
* The `-m` option to specify that any tests that have a pytest.mark decorator that matches the specified expression string will be executed. 
* The `-v` option specifies that verbose output from PyTest should be enabled.
* The `-q` option specifies the opposite. It specifies that the test should be run quietly, or with minimal output. 
    * This can be helpful from a performance perspective when you're running hundreds or thousands of tests. 
* The `-s` option specifies that PyTest should not capture the console output, allowing you to see the printouts from the print, from the tests. 
* The `--ignore` option allows you to specify a path that should be ignored during test discovery. 
* The `--maxfail` option specifies that PyTest should stop after n number of test failures. 