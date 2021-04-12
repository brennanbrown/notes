---
layout: default
title: Python Fundamentals
parent: Programming
---

**Table of Contents:**

- [Variables](#variables)
- [Arguments / Functions](#arguments--functions)
- [Conditional Structures](#conditional-structures)
- [Loops](#loops)
- [Classes](#classes)
- [Date, Time, and Datetime Classes](#date-time-and-datetime-classes)
- [Reading and Writing Files](#reading-and-writing-files)
  - [Working with OS Path Utilities](#working-with-os-path-utilities)
  - [Using File System Shell Methods](#using-file-system-shell-methods)
- [Fetching Internet Data](#fetching-internet-data)
  - [Working with JSON data](#working-with-json-data)
  - [Parsing and Processing HTML](#parsing-and-processing-html)
  - [Manipulating XML](#manipulating-xml)

```python
#             #
# Hello World #
#             #

def main():
    print("Hello, world!")

if __name__ == "__main__":
    main()
```

## Variables

```python
#           #
# VARIABLES #
#           #

f = 0
print(f)

f = "foo"
print(f)

# Different types of variables cannot be combined, eg.
# print("This is a string" + 123)
# Solution:
print("This is a string" + str(123))

# Global vs. Local Variables in Functions
def function():
    global f
    f = "bar"
    print(f)

print(f)

del f

f = 0
print(f)
```

## Arguments / Functions

```python
#           #
# ARGUMENTS #
#           #

def funct():
    print("This is a function!")


# Function is being called directly.
funct()
# Function is also being called inside the print function,
# the output is the same, but then the outer print statement
# executes, since the function doesn't return a value,
# Python evaluates the return value to be the Python constant
# of none, and then prints the string representation of that.
print(funct())
# Since the function itself is not being executed, the print
# is just displaying the value of the function itself.
# This evaluates to the object that the function is.
print(funct)

# A function that takes in arguments
def args(arg1, arg2):
    print(arg1, " ", arg2)

args(10, 20)
print(args(10, 20))

# A function that returns a value
def cube(x):
    return x * x * x

print(cube(4))

# A function with default value for an argument
def power(num, x=1):
    result = 1
    for i in range(x):
        result = result * num
    return result

print(power(2))
print(power(2,3))
print(power(x=3, num=2))

# A function with a variable number of arguments

def multiAdd(*adds):
    result = 0
    for x in adds:
        result = result + x
    return result

print(multiAdd(4, 5, 2, 13))
```

## Conditional Structures

```python
#             #
# CONDITIONAL #
# STRUCTURES  #
#             #

def main():
    x, y = 10, 100

    # Conditional flow uses if, elif, else
    if (x < y):
        a = "x is less than y!"
    elif (x == y):
        a = "x is equal to y!"
    else:
        a = "x is greater than y!"

    print(a)

    # Conditional statements let you use "a if C else b"
    b = "x is less than y!" if (x < y) else "x is greater or the same as y!"
    print(b)

if __name__ == "__main__":
    main()

```

## Loops

```python

#       #
# LOOPS #
#       #

def main():
    x = 0

    # Basic while loop
    while (x < 5):
        print(x)
        x = x+1

    # Basic for loop (iterator)
    # Unlike other languages, Python does not have
    # an iteration counter, eg.
    # for (i=0; i<10; i++)
    for x in range(5, 10):
        print(x)

    days = ["Monday", "Tuesday", "Wednesday", "Thursday", "Friday"]
    for d in days
        print(d)

    # Break and Continue Statements
    for x in range(5, 10):
        if (x==7): break
        if (x % 2 == 0): continue
        print(x)

    # Using the enumerate() function to get the index
    days = ["Monday", "Tuesday", "Wednesday", "Thursday", "Friday"]
    for i,d in enumerate(days):
        print(i, d)
```

## Classes

```python

#         #
# CLASSES #
#         #

class myClass():
    def methodFirst(self):
        print("myClass methodFirst")

    def methodSecond(self, testString):
        print("myClass methodSecond" + testString)

class anotherClass(myClass):
    def methodFirst(self):
        myClass.methodFirst(self)
        print("anotherClass methodFirst")

    def methodSecond(self, testString):
        print("anotherClass methodSecond")

def main():
    c = myClass()
    c.methodFirst()
    c.methodSecond("This is a string!")

    d = anotherClass()
    d.methodFirst()
    d.methodSecond("This is a second string!")

if __name__ == "__main__":
    main()
```

## Date, Time, and Datetime Classes

```python

#             #
# DATE & TIME #
#   CLASSES   #
#             #

from datetime import date
from datetime import time
from datetime import datetime
from datetime import timedelta

def dateTime():
    ## DATE OBJECTS
    # Pull today's date from the simple today() method
    # from the date class.
    today = date.today()
    print("Today's date is ", today)
    # Print out the date's individual components
    print("Date Components: ", today.day, today.month, today.year)
    # Retrieve today's weekday (0= Monday, 6 = Sunday)
    print("Today's weekday # is ", today.weekday())
    days = ["Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday"]
    print("Which is a: ", days[today.weekday()])

    ## DATETIME OBJECTS
    # Get today's date from the datetime class
    today = datetime.now()
    print("The current date and time is ", today)
    # Get the current time.
    time = datetime.time(datetime.now())

def timeControls():
    # Time and dates can be formatted using a set of
    # predefined string control codes.
    now = datetime.now()
    # To format date information, use the strftime function,
    # which is available as a method on the datetime object.
    # Eg. print(now.strftime())

    ## Date Formatting ##

    # %Y - Year, %A - Weekday, %B - Month, %d - Day of the Month
    print(now.strftime("The current date is: %A, %B %d, %Y."))

    # %c - Locale's Date and Time, %x - Locale's Date
    # %X - Locale's Time
    print(now.strftime("Locale Date and Time: %c"))
    print(now.strftime("Locale Date: %x"))
    print(now.strftime("Locale Time: %X"))

    ## Time Formatting

    # %I/%H - 12/24 Hrs, %M - Minutes, %S - Seconds, %p - Locale's AM/PM
    print(now.strftime("Current Time: %I:%M:%S %p"))
    print(now.strftime("Current 24H Time: %H:%M:%S"))

def timeDelta():
    now = datetime.now()

    # Construct a basic timedelta and print it
    print(timedelta(days=26, hours=9, minutes=15))

    # Print today's date
    print("Today is: " + str(now))

    # Print today's date one year from now
    print("One year from now, it will be: " + str(now + timedelta(days=365)))

    # A timedelta that uses more than one argument.
    print("In two days and three weeks it will be" + str(now + timedelta(days=2, weeks=3)))

    # Calculate the date one week ago, formatted as a string.
    past = datetime.now() - timedelta(weeks=1)
    weekAgo = past.strftime("%A, %B %d, %Y.")
    print("One week ago, it was: " + weekAgo)


    ### How many days until the next April Fool's Day? ###
    today = date.today()
    aprilFoolsDay = date(today.year, 4, 1)

    # Use the date comparison to see if April Fool's has
    # already occurred this year. If it has, use the replace()
    # function to get the date for next year.
    if aprilFoolsDay < today:
        print("April Fool's day was already %d days ago!" % ((today-aprilFoolsDay).day))
        aprilFoolsDay = aprilFoolsDay.replace(year = today.year+1)

    # Then calculate the amount of time until April Fool's Day
    nextAprilFoolsDay = (aprilFoolsDay - today)
    print("It's", nextAprilFoolsDay.days, "days until April Fool's Day!")

def calendar():
    import calendar
    # Create a plain-text calendar
    cal = calendar.TextCalendar(calendar.MONDAY)
    textCal = cal.formatmonth(2020, 1, 0, 0)
    print(textCal)


    # Create an HTML-formatted calendar
    cal = calendar.HTMLCalendar(calendar.MONDAY)
    htmlCal = cal.formatmonth(2020, 1, 0)
    print(htmlCal)

    # Loop over the days of a month,
    # zeroes mean the the day of the week is in
    # an overlapping month.
    for i in cal.itermonthdays(2020, 6):
        print(i)

    # The Calendar module provides useful utilities
    # for the given locale, such as the names of days
    # and months in both full and abbreviated forms.
    for name in calendar.month_name:
        print(name)

    for day in calendar.day_name:
        print(day)

    # Calculate days based on a rule, for example,
    # consider a team meeting on the first Friday
    # of every month. To figure out what days would
    # be for each month, we can use this script:
    print("The team meetings this year will be on: ")
    for m in range(1, 13):
        cal = calendar.monthcalendar(2018, m)
        # The first Friday will be in either the first
        # or second week of the month.
        weekOne = cal[0]
        weekTwo = cal[1]

        if weekOne[calendar.FRIDAY] != 0:
            meetDay = weekOne[calendar.FRIDAY]
        else:
            meetDay = weekTwo[calendar.FRIDAY]

        print("%10s %2d" % (calendar.month_name[m], meetDay))



dateTime()
timeControls()
timeDelta()
calendar()
```

## Reading and Writing Files

```python
#     #
# I/O #
#     #

def create():
    # Open a file for writing and create it if it doesn't exist.
    f = open("textfile.txt", "w+")

    # Write some lines of data to the file.
    for i in range(10):
        f.write("This line is #" + str(i) + "\r\n")

    # Close the file when finished operations.
    f.close()

def append():
    # Open the file for appending text to the end of file.
    f = open("textfile.txt", "a")

    # Write some lines of data to the file.
    for i in range(10):
        f.write("This NEW line is #" + str(i + 10), "\r\n")

    # Close the file when finished operations.
    f.close()

def read():
    f = open("textfile.txt", "r")

    # Open the file and read its contents.
    if f.mode == 'r':
        contents = f.read()
        print(contents)
```

### Working with OS Path Utilities

```python

import os
from os import path
import datetime
from datetime import date, time, timedelta
import time

def main():
    # Prints name of the current OS
    print(os.name)

    # Check for item existence and type
    print("Item exists" + str(path.exists("textfile.txt")))
    print("Item is a file: " + str(path.isfile("textfile.txt")))
    print("Item is a directory: " + str(path.isdir("textfile.txt")))

    # Work with file paths
    print("Item path: " + str(path.realpath("textfile.txt")))
    print("Item path and name: " + str(path.split(path.realpath("textfile.txt"))))

    # Get the modification time
    modified = time.ctime(path.getmtime("textfile.txt"))
    print(modified)
    print(datetime.datetime.fromtimestamp(path.getmtime("textfile.txt")))

    # Calculate how long ago the item was modified
    timeDiff = ((datetime.datetime.now()) - (datetime.datetime.fromtimestamp(path.getmtime("textfile.txt"))))
    print("It has been " + str(timeDiff) + " since the file was modified.")
    print("Or, " + str(timeDiff.total_seconds()) +" seconds")

create()

if __name__ == "__main__":
    main()
```

### Using File System Shell Methods

```python

import os
from os import path
# To use shell utilities:
import shutil
from shutil import make_archive
from zipfile import ZipFile

def main():
    # Make a duplicate of an existing file.
    if path.exists("textfile.txt"):
        # Get the path to the file in the current directory.
        source = path.realpath("textfile.txt")

        # Make a backup copy by appending '.bak' to the name.
        destination = source + ".bak"

        # Copy over the permissions, modification time, and
        # other information.
        shutil.copy(source, destination)
        shutil.copystat(source, destination)

        # Rename the original files.
        os.rename("textfile.txt", "newfile.txt")

        # Put files into a .ZIP archive.
        root_dir, tail = path.split(source)
        shutil.make_archive("archive", "zip", root_dir)

        # More fine-grain control over .ZIP archive
        # The 'with' keyword creates a local scope
        # which simplifies working with objects.
        with ZipFile("testZip.zip", "w") as newzip:
            newzip.write("textfile.txt")
            newzipe.write("textfile.txt.bak")

if __name__ == "__main__":
    main()
```

## Fetching Internet Data

```python
#          #
# WEB DATA #
#          #

import urllib.request
import json

def main():
    webURL = urllib.request.urlopen("http:www.google.com")
    print("Result Code:" + str(webURL.getcode()))
    data = webURL.read()
    print(data)
```

### Working with JSON data

```python
import urllib.request
import json

def main():
    # Define a variable to hold the source URL
    # In this case, the data feed from the USHS
    # will be utilized.
    # This feed lists all earthquakes for the last day,
    # that are larger than a magnitude of 2.5
    urlData = "http://earthquake.usgs.gov/earthquakes/feed/v1.0/summary/2.5_day.geojson"

    # Open the URL and read the data.
    # Checks that the webpage's code is 200,
    # which means that it is working properly.
    webURL = urllib.request.urlopen(urlData)
    print("Result Code: " + str(webURL.getcode()))
    if (webURL.getcode() == 200):
        data = webURL.read()
        printResults(data)
    else:
        print("Receieved an error, cannot parse the results.")

def printResults(data):
    # Use the JSON module to load the string data into a dictionary.
    theJSON = json.loads(data)

    # Access the contents of the JSON as a Python object
    if "title" in theJSON["metadata"]:
        print(theJSON["metadata"]["title"])

    # Output the number of events, plus the magnitude
    # and each event name.
    count = theJSON["metadata"]["count"]
    print (str(count) + " events recorded today.")

    # For each event, print the location where it occurred.
    for i in theJSON["features"]:
        print(i["properties"]["place"])
    print("--------------\n")

    # Print the events that only have a magnitude above 4.
    for i in theJSON["features"]:
        if i["properties"]["mag"] >= 4.0:
            print("%2.1f" % i["properties"]["mag"], "magnitude earthquake located", i["properties"]["place"])
    print("--------------\n")

    # Print the events where at least 1 person reported felt.
    print("Events that were felt:")
    for i in theJSON["features"]:
        feltReports = i["properties"]["felt"]
        if feltReports != None:
            if feltReports > 0:
                print("%2.1f" % i["properties"]["mag"], "magnitude earthquake located", i["properties"]["place"], "reported " + str(feltReports) + " times.")
    print("--------------\n")

if __name__ == "__main__":
    main()
```

### Parsing and Processing HTML

```python
from html.parser import HTMLParser

metaCount = 0

class MyHTMLParser(HTMLParser):
    def handle_comment(self, data):
        print("Encountered Comment: ", data)
        pos = self.getpos()
        print("\t At line: ", pos[0], " postion ", pos[1])

    def handle_starttag(self, tag, attrs):
        global metaCount
        if tag == 'meta':
            metaCount += 1
        print("Encountered Tag: ", tag)
        pos = self.getpos()
        print("\t At line: ", pos[0], " postion ", pos[1])

        if attrs.__len__() > 0:
            print("\t Attributes: ")
            for a in attrs:
                print("\t", a[0], "=", a[1])


    def handle_endtag(self, tag):
        return

    def handle_data(self, data):
        # Checks to make sure the data
        # isn't just empty white space.
        if (data.isspace()):
            return
        print("Encountered Data: ", data)
        pos = self.getpos()
        print("\t At line: ", pos[0], " postion ", pos[1])

def main():
    # Instantiate the parser and feed it HTML
    parser = MyHTMLParser()
    f = open("sampleHTML.html")
    if f.mode == 'r':
        contents = f.read()
        parser.feed(contents)

    print("Total metatags found: " + str(metacount))

if __name__ == "__main__":
    main()
```

### Manipulating XML

```python
import xml.dom.minidom

def main():
    # Use the parse() function to load and parse an XML file.
    doc = xml.dom.minidom.parse("sampleXML.xml")

    # Print out the document node and the name of the first child tag.
    print(doc.nodeName)
    print(doc.firstChild.tagName)

    # Get a list of XML tags from the document and print each one.
    skills = doc.getElementsByTagName("skill")
    print("%d skills: " % skills.length)
    for skill in skills:
        print(skill.getAttribute("name"))

    # Create a new XML tag and add it into the document.
    newSkill = doc.createElement("skill")
    newSkill.setAttribute("name", "jQuery")
    doc.firstChild.appendChild(newSkill)

if __name__ == "__main__":
    main()

```
