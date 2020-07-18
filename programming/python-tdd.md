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
	- [Test Doubles](#test-doubles)
		- [Types of Test Doubles](#types-of-test-doubles)
		- [Unittest.mock](#unittestmock)
		- [Mock Verification](#mock-verification)
		- [MagicMock and MonkeyPatch](#magicmock-and-monkeypatch)
	- [Best Practices of TDD](#best-practices-of-tdd)
	- [Further Reading](#further-reading)

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

## Test Doubles

### Types of Test Doubles

* What are test doubles? Almost all code that gets implemented will depend on another piece of code in the system. 
    * Those other pieces of code are often times trying to do things or communicate with things that are not available in the unit testing environment, or are so slow they would make our unit tests extremely slow. 
    * Eg. If your code queries a third-party rest API on the internet, and that server is down for any reason, you can't run your test.
    * Test doubles are the answer to that problem. They are objects that are created in the test to replace the real production system collaborators. 
* There are many types of test doubles. **Dummy objects** are the simplest. 
    * They are simply placeholders that are intended to be passed around but not actually called or used in any real way. 
    * They'll often generate exceptions if they're called. 
* **Fake objects** have a different and usually simplified implementation from the production collaborator that make them usable in the test code, but not suitable for production.
* **Stubs** provide implementations that do expect to be called, but respond with basic canned responses. 
* **Spies** provide implementations that record the values that are passed into them. 
    * The tests can then use those recorded values for validating the code under test. 
* **Mock objects** are the most sophisticated of all the test doubles. 
    * They have pre-programmed expectations about the ordering of calls, the number of times functions will be called, and the values that will be passed in. 
    * Mock objects will generate their own exceptions when these pre-programmed expectations are not met.
* **Mock frameworks** are libraries that provide easy-to-use API's for automatically creating any of these types of test doubles *at runtime*. 
    * They provide easy API's for specifying the Mocking expectations in your unit test. 
    * They can be much more efficient than implementing your own custom Mock objects, because creating your own custom Mock objects can be time consuming, tedious, and error prone.


### Unittest.mock

* `Unittest.mock` is a Mocking framework for Python. It's build into the standard unit test for Python, in version 3.3 and newer, and for older versions of Python, a back-ported version of the library is available on pip, called Mock, and can be installed with the command `pip install mock`.
	* `Unittest.mock` provides the Mock class, which is an extremely powerful class that can be used to create test objects that can be used as fakes, stubs, spies, or true Mocks for other classes or functions. 
	* The Mock class has many initialization parameters for specifying how the object should behave, such as what in interface it should Mock, if it should call another function when it's called, or what value it should return. 
	* Once a Mock object has been used, it has many built-in functions for verifying how it was used, such as how many times it was called, and with what parameters.

```python
# Example of unittest.mock

def test_Foo():
	bar = Mock()
	bar_func(bar)
	bar.assert_called_once()

def test_Foo2():
	# Specifies the interface that the Mock object is implementing. 
	bar = Mock(spec = spec_class)
	# Specifies a function that should be called when the Mock is called. 
	bar2 = Mock(side_effect = bar_func)
	# Specifies the value that should be returned when the Mock object is called. 
	bar3 = Mock(return_value = 1)
```

* Mock provides many initialization parameters which can be used to control the Mock objects behavior. 
    * The `spec` parameter specifies the interface that the Mock object is implementing. 
        * If any attributes of the Mock object are called which are not in that interface, then the Mock will automatically generate an attribute exception. 
    * The `side_effect` parameters specifies a function that should be called when the Mock is called. 
        * This can be useful for more complicated test logic that returns different values depending on input parameters or generates exceptions.
	* The `return_value` parameter specifies the value that should be returned when the Mock object is called. 
    	* If the `side_effect` parameter is set, it's return value is used instead. 

### Mock Verification

* Mock provides many built-in functions for verifying how the Mock was called, including the following assert functions: 
    * The `assert_called` function will pass if the Mock was ever called with any parameters. 
    * The `assert_called_once` function will pass if the Mock was called exactly one time.
    * The `assert_called_with` function will pass if the Mock was last called with the specified parameters. 
    * The `assert_called_once_with` function will pass if the Mock was called exactly once with the specified parameters. 
    * The `assert_any_call` function will pass if the Mock was ever called with the specified parameters. 
    * the `assert_not_called` function will pass if the Mock was never called.
* Mock provides these additional built-in attributes for verifying how it was called: 
    * The `assert_has_calls` function passes if the Mock was called with parameters specified in each of the passed in list of Mock call objects, and optionally in the order that those call objects are put into the list.
    * The `called` attribute is a boolean which is true if the Mock was ever called. 
    * The `call_count` attribute is an integer value specifying the number of times the Mock object was called. 
    * The `call_args` attribute contains the parameters that the Mock was last called with. 
    * The `call_args_list` attribute is a list with each entry containing the parameters that were used in call to the Mock object. 

### MagicMock and MonkeyPatch

* Unittest.mock also provides the MagicMock class. MagicMock is derived from Mock and provides a default implementation of the Python magic methods.
    * These are the methods with double underscores at the beginning and end of the name, like string: `__str__`, and integer: `__int__`. 
* The following magic names are not supported by MagicMock, due to being used by Mock for other things, or because mocking them could cause other issues: 
    * `__getattr__`, `__setattr__`, `__init__`, `__new__`, `__prepare__`, `__instancecheck__`, `__subclasscheck__`, and `_~del__`.
    * In other words: Get attribute, set attribute, init, new, prepare, instance check, subclass check, and delete respectively. 
* When using MagicMock, you just need to keep in mind the fact that the magic methods are already created and take note of the default values that are returned from those functions to ensure they match the needs of the test that's being implemented. 
* PyTest provides the **Monkeypatch** Test Fixture to allow a test to dynamically change modules and class attributes, dictionary entries, and environment variables. 
* `Unittest.mock` provides a patch decorator which provides similar operations, but this can sometimes conflict with the PyTest Text Fixture decorators.

```python
# MonkeyPatch Example
def call_it():
	print("Hello, world!")

def test_patch(monkeypatch):
	monkeypatch(call_it, Mock())
	call_it()
	call_it.assert_called_once()
```

* Below is an example of using TDD to implement a function called `read_from_file`, which will read and return the first line from a file. 
* The filename and path to this pile would be passed in as an argument to the function, and the function will open that file, read in the first line, and return it.

```python

# line_reader.py

import os

# Function: Will read and return the first line from a file. 
# The filename and path to this pile will be passed in as 
# an argument to the function, and the function will open 
# that file, read in the first line, and return it.
def read_from_file(filename):
	if not os.path.exists(filename):
		raise Exception("Error: File Not Found.")
	infile = open(filename, "r")
	line = infile.readline()
	return line
```

```python

# line_reader_test.py

            # TEST CASES: #
# - Can call read_from_file
# - read_from_file returns correct string
# - read_from_file throws exception when file doesn't exist

import pytest
from pytest import raises
from unittest.mock import MagicMock
from line_reader import read_from_file

# Note: Not utilized, as no real file is being read.
# def test_canCallReadFromFile():
# 	read_from_file("mock_file.txt")
# 	assert True

@pytest.fixture()
def mock_open(monkeypatch):
	mock_file = MagicMock()
	mock_file.readline = MagicMock(return_value = "Mock Title")
	mock_open = MagicMock(return_value = mock_file)
	monkeypatch.setattr("builtins.open", mock_open)
	return mock_open

# Note: You don't actually want to have to open a file for this test, 
# as that puts an external dependency on the test, 
# and potentially slows the test down. Hence using mocks.
def test_returnsCorrectString(mock_open, monkeypatch):
	# Update the test case to mock out the os.path.exist, 
	# and have it return true for that particular test case:
	mock_exists = MagicMock(return_value = True)
	monkeypatch.setattr("os.path.exists", mock_exists)
	result = read_from_file("mock_file.txt")
	mock_open.assert_called_once_with("mock_file.txt", "r")
	assert result == "Mock Title"

# Note: Mocking the os.path.exist functions to allow control when 
# it returns true or false depending on the test case, 
# without actually having to make modifications in the file system.
def test_throwsExceptionWithBadFile(mock_open, monkeypatch):
	mock_exists = MagicMock(return_value = False)
	monkeypatch.setattr("os.path.exists", mock_exists)
	with raises(Exception):
		result = read_from_file("mock_file.txt")

```

## Best Practices of TDD

There are a lot of things you can do to help with your practice of implementing unit tests using test-driven development. In this lecture I'll go over some best practices that I have found that are essential to making TDD productive. 

1. First, you should always do the next simplest test case. This allows you to gradually increase the complexity of the code, refactoring as you go. 
    * This helps keep your code clean and understandable. 
    * If you jump to the complex cases too quickly, you can find yourself stuck writing a lot of code for one test case which breaks the short feedback cycle we look for with TDD.
    * Beyond just slowing you down, this can also lead to bad design as you can miss some simple implementations that come from the incremental approach. 
2. Second, always try to use descriptive test names. 
    * The code is read thousands of times more than it's written as the years go by. 
    * Making the code clear and understandable should be the top priority. Unit tests are the best documentation for the developers that come after you for how you intended the code to work, if they can't understand what the unit test is testing, that documentation value is lost.
    * Test suites should name the class or function that is under test and the test names should describe the functionality that is being tested. 
3. Third, keep your unit test building and running fast.
    * One of the biggest benefits of TDD is the fast feedback on how your changes have affected things.
    * You lose this if the build and/or execution of your unit test is taking a long time. 
    * Eg. More than just a few seconds. To help your test stay fast, try to keep the console output to a minimum or eliminated altogether. This output just slows down the test and clutters up the test results. 
    * And also mock out any slow collaborators that are being used with test doubles that are fast. 
4. Forth, use code coverage analysis tools. 
   * Once you've implemented all your test cases, go back and run your unit test through a code coverage tool. 
   * It can be surprising. Some of the areas of your code you'll miss, especially negative test cases. 
   * You should have a goal of 100% code coverage on functions with real logic. Don't waste your time on one-line getter or setter functions.
5. Fifth, run your unit tests multiple times and in a random order. 
   * Running your tests many times will help ensure that you don't have any flaky tests that are failing intermittently. 
   * Running your tests in random order ensures that your tests don't have dependencies between each other. 
   * You can use the `pytest-random-order` plugin to randomize the execution of the tests and the `pytest-repeat` plugin for repeating all or a subset of the unit tests as needed.
6. Sixth, use a static code analysis tool regularly on your code base to ensure code quality. 
   * Pylint is an excellent open source static analysis tool for Python that can be used for detecting bugs in your code. 
   * It can also verify the code is formatted to the team standard, and it can even generate UML diagrams based on its analysis of the code.

## Further Reading

* Kent Beck's book *Test Driven Development: By Example* is great book from the creator of test driven development, with a detailed case study on using TDD. 
* Robert Martin's *Clean Code: A Handbook of Agile Software Craftsmanship* provides the three laws of TDD as well as a lot of other expert guidance on writing clean and maintainable code.
* Michael Feathers' *Working Effectively with Legacy Code* is a fantastic book for providing effective techniques for adding unit tests to existing code.