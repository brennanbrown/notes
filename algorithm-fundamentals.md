# Algorithm Fundamentals

* Algorithms have *complexity* and *input/output*
    * Space complexity: How much memory does it require?
    * Time complexity: How much time does it take to complete?
    * What can the algorithm accept, and what are its results?
* There are also classifications of algorithms:
    - Eg. serial/parallel, exact/approximate, deterministic/non-deterministic

```java
for (each shape) {
    if (shape is ellipse) {
        ellipses.add(shape);
    }
}
```

* `Search Algorithms` are for finding a specific data in a structure. (Eg. a substring within a string)
* `Sorting Algorithms` are for taking datasets and applying a specific sort order to it.
* `Computation Algorithms` are for figuring out a calculation given a set of data (Eg. is a given number prime?)
* `Collection Algorithms` are for working with collections of data (Eg. counting specific items, navigating among data elements, filter out unwanted data, etc.)

Example: Euclid's Algorithm

> Find the greatest common denominator (GCD) of given two integers.

```python
if a > b
    a / b
    if remainder = 0
        exit()
    else
        gcd = b
else
    a = b
    b = r
    repeat until r = 0

```

```python

def gcd(a, b):
    while (b != 0):
        t = a
        a = b
        b = t % b

    return a


print(gcd(60,96))
print(gcd(20, 8))

```

## Measuring Algorithm Performance

* Measure how an algorithm responds to dataset size
    * `Big-O` notation is classifying performance of an algorithm as the input size increases.
        - "O" indicates the *order of operation*: time scale to perform an operation
    * Many different algorithms and data structures hve more than just one O
        - Dependant on inserting data, searching for data, deleting data, etc.

Big-O Terms and Notations:

* `O(1)` Constant time eg. Looking up a single element in an array.
* `O(logN)` Logarithmic eg. Finding an item in a sorted array with a binary search.
* `O(n)` Linear time eg. Searching an unsorted array for a specific value
* `O(n log n)` Log-linear eg. Complex sorting algorithms like *heap sort* or *merge sort*
* `O(n^2)` Quadratic eg. Simple sorting algorithms, such as bubble sort, selection sort, and insertion sort.

```python

import random

def is_sorted(data) -> bool:
    """Determine whether the data is sorted."""
    for i in range(len(data) - 1):
        if data[i] > data[i + 1]:
            return False
    return True

def bogosort(data) -> List:
    """Shuffle data until sorted."""
    while not is_sorted(data):
        random.shuffle(data)
    return data

```

## Intro to Data Structures

* Data structures are used to organize data so it can be properly processed.
    - Eg. Arrays, Linked Lists, Stacks and Queues, Trees, and Hash Tables
* **Arrays** are a collection of elements identified by index or key.
    - eg. `even_elem = array[2n]`
* Array operations:
    - Calculating an item's index: `O(1)`
    - Inserting or deleting items at the beginning or middle: `O(n)`
    - Inserting or deleting an item at the end: `O(1)`
* **Linked Lists** are a collection of elements, called nodes, and contain reference to the next node in the list. They can hold whatever data the applications needs.
    - Elements can be more easily inserted or removed than in arrays. Underlying memory doesn't need to be reorganized
    - The main drawback, though, is that you can't do constant-time random item access, meaning that looking up an arbitary item is linear in time scale `O(n))` instead of `O(1)` constant time in the array.
    * A linked list operation, such as adding a new element, requires setting the new node's next pointer to be the current head, and then set the head to be the new node.
    * A node can be removed from a list by changing the next field of the node that points to it.
        - To remove the node, simply have the previous node point directly to the node that came after.
    - Just by manipulating the various *pointers*, you can achieve operations with linked lists.

```python

# Linked List Example

class Node(object):
    def __init__(self, val):
        self.val = val
        self.next = None

    def get_data(self):
        return self.val

    def set_data(self, val):
        self.val = val

    def get_next(self):
        return self.next

    def set_next(self, next):
        self.next = next

class LinkedList(object):
    def __init__(self, head=None):
        self.head  = head
        self.count = 0

    def get_count(self):
        return self.count

    def insert(self, data):
        # Insert a new node
        new_node = Node(data)
        new_node.set_next(self.head)
        self.head = new_node
        self.count += 1

    def find(self, val):
        # Find the first item with a given
        item = self.head
        while (item != None):
            if item.get_data() == val:
                return item
            else:
                item = item.get_next()

        return None

    def deleteAt(self, idx):
        # Delete an item at given index
        if idx > self.count-1:
            return
        if idx == 0:
            self.head = self.head.get_next();
        else:
            tempIdx = 0
            node = self.head
            while tempIdx < idx - 1:
                node = node.get_next()
                tempIdx += 1
            node.set_next(node.get_next().get_next())
            self.count -= 1


    def dump_list(self):
        tempnode = self.head
        while (tempnode != None):
            print("Node: ", tempnode.get_data())
            tempnode = tempnode.get_next()

# Create a linked list and insert some items
itemlist = LinkedList()
itemlist.insert(38)
itemlist.insert(82)
itemlist.insert(43)
itemlist.insert(14)
itemlist.dump_list()

# exercise the list
print("Item count: ", itemlist.get_count())
print("Finding item: ", itemlist.find(82))
print("Finding item: ", itemlist.find(14))

# delete an item
itemlist.deleteAt(3)
print("Item count: ", itemlist.get_count())
print("Finding item: ", itemlist.find(38))
itemlist.dump_list()
```

## Stacks and Queues

* A **Stack** is a collection that supports *push* and *pop* operations.
    - The last item pushed is the first one popped. In other words: last-in, first-out.
    - Used to evaluate mathematical expressions.
    - Used for backtracking features, eg. browser back button uses a stack

```python
stack = []

stack.append(1)
stack.append(2)
stack.append(3)
stack.append(4)

print(stack)

# removes the last element in the stack
x = stack.pop()
print(x)
print(stack)
```

* A **Queue** is a collection that supports adding and removing
    - First item added is first item out.
    - Used for chronological order processing and messaging

```python
from collections import deque

queue = deque()
queue.append(1)
queue.append(2)
queue.append(3)
queue.append(4)

print(queue)

# deque or pop left removes the first element in the stack
x = queue.popleft()
print(x)
print(queue)
```

* A **Hash Table** is a collection of that maps keys to their associated values and does this using the `hash` function. They are typically very fast.
    - Ideally, the hash function will assign each key to a unique slot in the table where the values are stored.
    - In reality, sometimes there are collisions in which two separate keys each map to the same slot in the table.
    - In that case, the hash table has to have a way of resolving those collisions so that the correct value is mapped to the right key.
    - `Key-to-value` mappings are unique.
    - For small datasets, arrays are usually more efficient.
    - Hash tables also don't order entires in any predictable way.

```python
items1 = dict({"key1" : "foo", "key2" : "bar", "key3" : "foobar"})

print(items1)

items2 = {}
items2["key1"] = "foo"
items2["key2"] = "bar"
items2["key3"] = "foobar"

for key, value in items2.items():
    print("Key: ", key, " Value: ", value)
```

* **Recursion** is when a function calls itself
    - Eg. `function f() { f() };`
    - Recursion functions need to have a breaking condition, else the will loop indefinitely and hang, and then crash as the program and computer will run out of memory to keep track of each nested function call.
    - Each time the function is called, the old arguments are saved.
        + This is called the "call stack"

```python
def countdown(x):
    if x == 0:
        print("Done!")
        # Returns to the statement after
        # the function call was made.
        return
    else:
        print(x, "...")
        countdown(x-1)
        # Will execute in order after the
        # countdown is complete.
        # This is because the call stack
        # is being 'unwound.'
        print("foo!")

countdown(10)
```

Power and Factorial Functions example:

```python

def power(num, pwr):
    if pwr == 0:
        return 1
    else:
        return num * power(num, pwr - 1)

def factorial(num):
    if num == 0:
        return 1
    else:
        return num * factorial(num - 1)

print("{} to the power of {} is {}.".format(5, 3, power(5, 3)))
print("{} to the power of {} is {}.".format(6, 7, power(6, 7)))

print("{}! equals {}".format(4, factorial(4)))
print("{}! equals {}".format(0, factorial(0)))
```

* Sorting data is an important feature in many applications and programs.
    - Eg. somebody searching for real estate might want to sort the listings posted by price descending.
    - Most modern programming languages have sorting built-in.
* The **bubble sort** first compares the first two elements, and if the first element is larger, they are swapped. The algorithm then advances to the next slot and performs the same comparison.
    - It is very easy to understand and implement.
    - However, it has a performance profile of `O(n^2)`
        + `For` loops inside of other `for` loops are usually quadratically-timed algorithms.

```python
def bubbleSort(dataset):

    # Examines every element in list and then decreases
    # by one each time.
    #
    # The range is going to start at
    # the length of the dataset minus one because that
    # is the zero index array's last item.
    #
    # Stops at the 0th item and then step by minus one
    # each time, doing a countdown from the array's end
    for i in range(len(dataset) - 1, 0, -1)
        # Inner-loop to compare the neighboring elements
        # and swap them, if needed.
        for j in range(i):
            # Perform the comparisons of the elements.
            if dataset[j] > dataset[j+1]
                # Temporary variable to store aside the
                # value of dataset 'j' which will then
                # be switched to get the value of its
                # neighboring element.
                temp = dataset[j]
                dataset[j] = dataset[j+1]

    if item1 =< item2:
        return
    else:
        x - 1
    print("Current state: ", dataset)

def main():
    list1 = [5, 23, 86, 1, 3, 9, 12, 8, 34, 2]
    bubbleSort(list1)
    print("Result: ", list1)

if __name__ == "__main__":
    main()

```

* The **merge sort** is known as the divide-and-conquer algorithm
    - It breaks a dataset into individual pieces and merges them
    - Uses recursion to operate on datasets
    - Performs well on large data sets
    - In general, has a performance of `O(n log(n))` time complexity
    - Break arrays down until you are left with one-elementary arrays, all of which are sorted by definition because they only contain one element. Then begin merging these arrays back up into each other until the array is rebuilt in its sorted form.

```python


items = [4, 23, 64, 7, 124, 3, 75, 2, 9]

def mergesort(dataset):
    if len(dataset) > 1:
        mid   = len(dataset) // 2
        left  = dataset[:mid]
        right = dataset[mid:]

        mergesort(left)
        mergesort(right)

        l = 0
        r = 0
        m = 0

        # Sort while both arrays have content
        while l < len(left) and r < len(right):
            if left[l] < right[r]:
                dataset[m] = left[l]
                l += 1
            else:
                dataset[m] = right[r]
                r += 1
            m += 1

        # If the left array still has values, add them
        while l < len(left):
            dataset[m] = left[l]
            l += 1
            m += 1

        # If the right array still has values, add them
        while r < len(right):
            dataset[m] = right[r]
            r += 1
            m += 1

print(items)
mergesort(items)
print(items)

```

* The **Quicksort** algorithm is, like the mergesort, also divide-and-conquer.
    - Uses recursion to perform sorting as well.
    - Generally performs better than merge sort, `O(n log(n))`
    - Operates in place in data, replacing existing array.
    - Worst case is `O(n*2)` when the data set is mostly sorted already.
*  One of the main features of the Quicksort is the selection of what's called the Pivot Point.
    - There are various ways of picking the pivot position, and there's all kinds of research and dissertations done on this.
    - For simplicity, use the first position. The value at the first position becomes the pivot value. And then start the process of partitioning the list.
* The main purpose of the partitioning process is to move items that are on the wrong side of the pivot value and figure out the point at which to split the array so this can be recursively done again.
    - There are two indexes, the lower index and the upper index. Start by incrementing the lower index, as long as it is less than the upper index, and until a value that's larger than the pivot value is found.
* In the Quicksort, all the work gets done in the partition step, and the data is being sorted in place.

```python

items = [20, 6, 8, 53, 56, 23, 87, 41, 12, 34, 23]

def quickSort(dataset, first, last):
    if first < last:
        # calculate the split point
        pivot = partition(dataset, first, last)

        # sort the two partitions
        quickSort(dataset, first, pivot-1)
        quickSort(dataset, pivot+1, last)

def partition(datavalues, first, last):
    # choose the first item as the pivot value
    pivotValue = datavalues[first]
    # establish the upper and lower indexes
    lower = first + 1
    upper = last

    # start searching for the crossing point
    done = False
    while not done:
        # Advance the lower index
        while lower <= upper and datavalues[lower] <= pivotValue:
            lower += 1
        # Advance the upper index
        while datavalues[upper] >= pivotValue and upper >= lower:
            upper -=1
        # If the two indexes cross, the split point has been found
        if upper < lower:
            done = True
        else:
            temp = datavalues[lower]
            datavalues[lower] = datavalues[upper]
            datavalues[upper] = temp

    # when the split point is found, exchange the pivot value
    temp = datavalues[first]
    datavalues[first] = datavalues[upper]
    datavalues[upper] = temp

    # return the split point index
    return upper

# Testing the merge sort with dataset

print(items)
quickSort(items, 0, len(items)-1)
print(items)
```

## Unordered List Search

```python
# Search for an item in an unordered list
# Sometimes called a linear search

# Declare a list of values to operate on
items = [6, 20, 8, 19, 24, 45, 4, 45, 234, 324]

def find_item(item, itemList):
    for i in range(0, len(items)):
        if item == itemlist[i]:
            return i

        return None

print(find_item(87, items))
print(find_item(20, items))
```

## Searching an Ordered List

```python
# Searching for an item in an ordered list
# This technique uses a binary search

items = [3, 545, 2, 3, 75, 231, 34, 1, 9]

def binarySearch(item, itemList):
    # Get the list size
    listSize = len(itemList) - 1
    # Start at the two ends of the list
    lower = 0
    upper = listSize

    while lower <= upper:
        pass

        # Calculate the middle point
        middle = (lower + upper) // 2
        # If item is found, return the index
        if itemList[middle] == item:
            return middle
        # Otherwise, get the next midpoint
        if item > itemList[middle]:
            lower = middle + 1
        else:
            upper = middle - 1

    if lower > upper:
        return None

print(binarySearch(23, items))
print(binarySearch(75, items))
print(binarySearch(65, items))
```

## Determining if a List is Sorted

```python
items1 = [3, 7, 12, 23, 54, 65, 87, 99]
items2 = [43, 24, 5, 13, 97, 2, 13, 34]

def isSortedBrute(itemList):
    # Brute force method
    for i in range(0, len(itemList)-1):
        if (itemList[i] > itemList[i+1]):
            return False

    return True

def isSortedAll(itemList):
    # Using Python's All function method
    return all(itemList[i] <= itemList[i+1] for i in range(len(itemList) - 1))

print(isSortedBrute(items1))
print(isSortedBrute(items2))

print(isSortedAll(items1))
print(isSortedAll(items2))
```

## Unique Filtering with Hash Table

```python
# Use a hashtable (dictionary) to filter out duplicate items
# Has a linear time complexity O(n)

# Define a set of items that needs to have duplicates reduced

items = ["Apple", "Pear", "Kiwi", "Mango", "Apple", "Orange", "Orange", "Pear", "Kiwi", "Watermelon", "Apple", "Cherry", "Pear", "Orange"]

# Create a hashtable to perform a filter
filter = dict()
# Loop over each time and add to the hashtable
for key in items:
    filter[key] = 0
# Create a set from the resulting keys in the hashtable
result = set(filter.keys())
print(result)
```

## Value Counting with Hash Table

* To create a counter, create a new hash table and then loop over the set of the items to count.
    - Use the name of each item as a key, and if that item already exists in the hash table, then increment the value that the key corresponds to, otherwise, set the value of the key with that item name equal to one.
    - After iterating over all the items, the counter will contain unique keys that represent all the items, along with the number of times that that item was encountered.

```python

# Use a hashtable (dictionary) to count individual items

# Define a set of items that need to be counted
items = ["Apple", "Pear", "Kiwi", "Mango", "Apple", "Orange", "Orange", "Pear", "Kiwi", "Watermelon", "Apple", "Cherry", "Pear", "Orange"]

# Create a hashtable object to hold the items and counts
counter = dict()

# Iterate over each item and increment the counter for each one
for item in items:
    if (item in counter.keys()):
        counter[item] += 1
    else:
        counter[item] = 1

print(counter)
```

## Finding Maximum Value with Recursion

```python

# Use a recursive algorithm to find a maximum value.

# Declare a list of values to operate on
items = [43, 24, 5, 13, 97, 2, 13, 34]

def findMax(items):

    # Breaking condition: last item in list? Return it
    if len(items) == 1:
        return items[0]
    # Otherwise, get the first item and call function
    # again to operate on the rest of the list
    first = items[0]
    # Prints each comparison being run through the list
    print(first)
    second = findMax(items[1:])
    print(second)
    # Perform the comparison when we're down to just town
    if first > second:
        return first
    else:
        return second

print(findMax(items))
```
