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
* And lastly, comes **performance testing**, which test systems and sub-systems at expected production loads to verify that response times and resource utilization, i-memory, CPU and disk usage are acceptable.
