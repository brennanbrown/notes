# JavaScript Algorithms

**Table of Contents:**

- [JavaScript Algorithms](#javascript-algorithms)
  - [Performance Testing](#performance-testing)
  - [Using `arr.sort` Function](#using-arrsort-function)
    - [Node List](#node-list)
    - [Filter Null Values](#filter-null-values)
    - [Sorting Nodes](#sorting-nodes)
  - [Bubble Sort](#bubble-sort)
  - [Merge Sort](#merge-sort)
  - [Insertion Sort](#insertion-sort)
  - [Quartile Sort](#quartile-sort)
    - [Values Into Header](#values-into-header)
    - [Quartile, Min, Max, and Mean](#quartile-min-max-and-mean)
    - [Sorter Nodes](#sorter-nodes)
    - [Bucketing into Quartiles](#bucketing-into-quartiles)

“An algorithm is,” Domingos writes, “a sequence of instructions telling a computer what to do.” As Domingos goes on to explain, algorithms are reducible to three logical operations: AND, OR, and NOT. While these operations can chain together in extraordinarily complex ways, at core algorithms are built out of simple rational associations.

In other words, an algorithm is just a function that has repeatable steps.

## Performance Testing

- In order to test the performance and speed of algorithms written in JavaScript, within the broswer, wrap `console.profile("Function Name");` before the function is run, and adding `console.profileEnd("Function Name");` after it.
  - Then, using the developer tools in Google Chrome, and going into "More Tools", select "JavaScript Profiler".
  - This will record the specific times of functions as they run.
- This can be helpful for comparing the amount of time each different sorting algorithm takes, and indetify places in the code that take the longest.
- In the folder `js-tests`, there are snippets that can be compared to one another on the following websites:
  - https://jsbench.me/ or https://jsben.ch/ or https://measurethat.net or https://plnkr.co/edit/pJg5LsiSNqlc6immmGsW?preview
  - You should always check what devices and browsers your audience uses so that you can optimize for your specific site.

## Using `arr.sort` Function

- Note: When using the default `arr.sort` method in JavaScript, the browser is most likely sorting with a merged sort, or a quick sort.
- If you have an unsorted array and use a `.sort` on it, it will, for the most part, do what's expected with these numbers. However, it's not always this simple.
  - The challenge for us is that we're working with JSON which requires a little bit more work.
- `arr.sort()` doesn't always work. If there's anything more complicated than an array with single-digit numbers, it will have to be passed a function.
- We'll be sorting these values. However, we need to check if a value is null because we want to be able to push that down no matter what.
- However, if just sorting the data, the table is going to have to re-render every time a sort occurs. To avoid that, render the already existing nodes

```javascript
function regularSort(arr, index) {
  // a = current row of data.
  // b = next row of data.
  arr.sort((a, b) => {
    // If no data, will push the
    // value down in the sort order.
    const x = a["Area"] === null ? -1 : a["Area"];
    const y = b["Area"] === null ? -1 : b["Area"];
    return x < y ? -1 : x > y ? 1 : 0;
  });
  console.log(arr);
}
```

### Node List

```javascript
function regularSort(arr, index) {
  const items = tableEle.childNodes;
  console.log(items);
}
```

- The output of the above code will look like it's an array, but it's not. It's a node list, and node lists don't have the same methods as array.
  - This can be fixed easily by using the `Array.from()` method. This simply takes what's ever passing to the parameters and turns it into an array.

```javascript
function regularSort(arr, index) {
  const items = Array.from(tableEle.childNodes);
  console.log(items);
}
```

### Filter Null Values

- You'll only sort the values that are not null like what was done in the previous function.
  - But it makes more sense to break that out in to it's own functions since you'll be doing that for all the sorts you build.

```javascript
// Passing in the very first sorter from the sorter well:
// Eg. if you drag an area, you'll get it's index which
// is one, and then you will use it to get the value.
const sorterIndex = headers.indexOf(sorters[0]);
// Filter Null Values
const itemsNotNull = filterNull(sorterIndex);

function filterNull(sorterIndex) {
  const items = Array.from(tableEle.childNodes);
  // Will iterate through each row of data.
  // Filter will create new array with everything returned.
  return items.filter((row) => {
    const rowTD = Array.from(row.childNodes);
    // Here you might want to use innerHTML or innerText,
    // However, textContent is standard, more efficient,
    // and doesn't concern itself with rendering and will
    // return null if the value is empty.
    return rowTD[sorterIndex].textContent;
  });
}
```

### Sorting Nodes

- Now, with the `filterNull` function returning `rowTD` at the `sorterIndex` and the textContent for the values.
  - Instead of passing in data, you're going to pass in the `itemsNotNull` as well as the `sorterIndex`.
  - Down where the function is called, make a const for row A that's going to be equal to `Array.from` and you'll pass in the `a.childNodes`.

```javascript
switch (getSort(data)) {
  case "regular":
    console.profile("regularSort");
    const regularArr = regularSort(itemsNotNull, sorterIndex);
    renderNodes(regularArr);
    console.profileEnd("regularSort");
    break;
}

// ...

function regularSort(arr, sorterIndex) {
  // a = current row of data.
  // b = next row of data.
  arr.sort((a, b) => {
    const rowA = Array.from(a.childNodes);
    const rowB = Array.from(b.childNodes);
    // If no data, will push the
    // value down in the sort order.
    // No hardcoding requried:
    const x = parseFloat(rowA[sorterIndex].textContent);
    const y = parseFloat(rowB[sorterIndex].textContent);
    return x < y ? -1 : x > y ? 1 : 0;
  });
  return arr;
}
```

## Bubble Sort

- A bubble sort looks at each individual value, decides if B is less than A, and if so, swaps it.
- As you can see, this sort algorithm tends to be pretty slow and isn't used much in the real world.
  - However, it's one of the easiest algorithms to understand and a good place to start.

```javascript
function bubbleSort(arr, sorterIndex) {
  let swapped;
  do {
    swapped = false;
    for (let i = 0; i < arr.length; i++) {
      const j = i++;
      if (arr[i] && arr[j]) {
        const rowA = Array.from(arr[i].childNodes);
        const rowB = Array.from(arr[j].childNodes);

        const x = parseFloat(rowA[sorterIndex].textContent);
        const y = parseFloat(rowB[sorterIndex].textContent);

        // Will continue the loop so long as
        // x is less than y, swapping them.
        if (x > y) {
          // Placeholder variable
          var temp = arr[i];
          arr[i] = arr[j];
          arr[j] = temp;

          swapped = true;
        }
      }
    }
  } while (swapped);

  return arr;
}
```

## Merge Sort

- Merge Sort works by dividing the array into pairs, sorting those pairs, and then merging the results.

```javascript
function mergeSort(arr) {
  if (arr.length <= 1) {
    return arr;
  }
  const middle = Math.floor(arr.length / 2),
    left = arr.slice(0, middle),
    right = arr.slice(middle);
  // Recursively run the function:
  return merge(mergeSort(left), mergeSort(right));
}

function merge(left, right) {
  let results = [];
  indexLeft = 0;
  indexRight = 0;
  const sorterIndex = headers.indexOf(sorters[0]);

  while ((indexLeft < left.length) & (indexRight < right.length)) {
    const rowA = Array.from(left[indexLeft].childNodes);
    const rowB = Array.from(right[indexRight].childNodes);

    const x = parseFloat(rowA[sorterIndex].textContent);
    const y = parseFloat(rowB[sorterIndex].textContent);

    if (x < y) {
      results.push(left[indexLeft]);
      indexLeft++;
    } else {
      results.push(right[indexRight]);
      indexRight++;
    }
  }
  return results.concat(left.slice(indexLeft)).concat(right.slice(indexRight));
}
```

## Insertion Sort

- Insertion Sort works by starting at index one in the array. It then checks to see if it's less than the elements behind it. And then swaps position until the current value is in the right place.

```javascript
function insertionSort(arr, sorterIndex) {
  // Starting with second element in the array.
  for (let i = 1; i < arr.length; i++) {
    const rowA = Array.from(arr[i].childNodes);
    const x = parseFloat(rowA[sorterIndex].textContent);
    const currentValue = arr[i];
    let j;
    // Backwards 'for' loop:
    for (j = i - 1; j >= 0; j--) {
      const rowB = Array.from(arr[j].childNodes);
      const y = parseFloat(rowB[sorterIndex].textContent);
      if (y <= x) {
        break;
      } else {
        arr[j + 1] = arr[j];
      }
    }
    arr[j + 1] = currentValue;
  }
  return arr;
}
```

## Quartile Sort

- This algorithm works specifically when selecting multiple headers to sort by.
  - It will bucket the items into quartiles or 25% sections of the data, and then it'll sort the very last column.
  - Eg. Sort by Area, then Population, then Population growth rate: which will display a nation that is in the top quartile for Area, in the top quartile for Population, and of those quartiles, has the highest population growth rate.
- When you scroll through the data table, the quartiles for the very first column will be maintained, and then dividing the second column into quartiles, and finally dividing the third column into quartiles and sorting it respectively. \*
- This algorithm will be using a few object methods. So, when `Object.keys` is given an object, it'll return all the key values in an array.
  - If `Object.values` is given an object, it'll return all the values in an array.
  - And when `Object.entries` is given an object, it'll return a nested array, with arrays of key value pairs.

### Values Into Header

- To start our quartile, we need to get the min, max, and mean of each of the column values.
- Loop through the data, `items.forEach` will get a fat arrow function.
  - And you'll use `item` as your iterated parameter.
- You'll first check to see that our item at the header index is not equal to null. - Inside of that, you'll take ` tempArr``, and push  `item`at the header index. - This will collect all the values for each column, and then assign that collection to`values`.

```javascript
items.forEach((item) => {
  if (item[header] !== null) {
    tempArr.push(item[header]);
  }
  // ...
});
// ...
summary[header] = {
  values: tempArr,
  // ,,,
};
```

### Quartile, Min, Max, and Mean

- Now that you have the array, check to see if it's the very last item.
  - You can do that with `if(i === items.length - 1`,
  - And make sure you pass in `i` as the iterator, `items.forEach((item, i) =>`)
- Now that we know it's the last item in the array, we want to do a few things.
  - The first thing you want to do is sort the array, `tempArr.sort()`, as a function, which receives `a` and `b` as parameters.
  - You'll then check to see if A is less than B. And if so, we'll return a negative one, which pushes it down.
  - Else, let's check to see if A is greater than B, and if so, you'll return a one, else let's return a zero:
  - `tempArr.sort((a, b) => a < b ? -1 : (a > b) ? 1 : 0)
- Next you'll get the `minVal`, and that's going to be equal to `math.min` and you're going to pass in the `tempArr` with a spread operator:
  - `minVal = Math.min(...tempArr);`
- You'll also do the same for the maxVal and that's equal to math.max with a spread operator tempArr.
  - `maxVal = Math.max(...tempArr);`
- Then you're going to get the boundaries for the quartiles.
- The first one is the meanVal. And a mean is simply the middle number of a sorted array. We're going to do something that should look familiar.
- You'll use `tempArr` and you want the index of `Math.floor` and you want `tempArr.length` divided by two:
  - `meanVal = tempArr[Math.floor(tempArr.length/2)];`
- Next to retrieve is the first quartile. It's very similar to `meanVal`, instead of diving by two, you'll divide by four:
  - `firstQuartile = tempArr[Math.floor(tempArr.length/4)];`
- You'll borrow that code again and get the third quartile. And that's going to be the `tempArr.length` divided by four and then multiplied by three:
  - `thirdQuartile = tempArr[Math.floor((tempArr.length/4))*3];`

```javascript
if (item[header] !== null) {
  tempArr.push(item[header]);
  if (i === items.length - 1) {
    tempArr.sort((a, b) => (a < b ? -1 : a > b ? 1 : 0));
    minVal = Math.min(...tempArr);
    maxVal = Math.max(...tempArr);
    meanVal = tempArr[Math.floor(tempArr.length / 2)];
    firstQuartile = tempArr[Math.floor(tempArr.length / 4)];
    thirdQuartile = tempArr[Math.floor(tempArr.length / 4) * 3];
  }
}
```

### Sorter Nodes

Now that you'll be dealing with multiple sorters, you'll need to loop through the sorters and pass the sorter to the quartile sort function:

```javascript
case "quartile":
    console.profile("quartileSort");
    sorters.forEach((sorter) => {
        quartileSort(sorter)
    });
    console.profileEnd("quartileSort");
    break;
```

You'll see it works by grabbing the child nodes of the table element, splitting those into quartiles, and then taking each one of those buckets and splitting them again into quartiles and finally, looping through those buckets and sorting them:

```javascript
function quartileSort(sorter) {
  const nodes = Array.from(tableEle.childNodes);
  nodes.shift();
  const firstBuckets = splitQuartiles(nodes, sorter);
  nodes.length = 0;
  firstBuckets.forEach((bucket) => {
    const secondBuckets = splitQuartiles(bucket, sorter);
    bucket.length = 0;
    secondBuckets.forEach((secbucket) => {
      const sorterIndex = headers.indexOf(sorter);
      if (sorters[0] === sorter) {
        if (sorters.length > 1) {
          secbucket.sort((a, b) => {
            const rowA = Array.from(a.childNodes);
            const rowB = Array.from(b.childNodes);
            const x = parseFloat(rowA[sorterIndex].innerText);
            const y = parseFloat(rowB[sorterIndex].innerText);
            if (!isNaN(x) || !isNaN(y)) {
              return x < y ? 1 : x > y ? -1 : 0;
            } else {
              return -1;
            }
          });
        } else {
          regularSort(secbucket, sorterIndex);
        }
      }
      secbucket.forEach((currentVal) => {
        bucket.push(currentVal);
      });
    });
    if (sorters.length > 1) {
      bucket.reverse();
    }
    bucket.forEach((element) => {
      nodes.push(element);
    });
  });
  renderNodes(nodes);
}
```

Below that, there's the `splitQuartiles()` function that has a nested array with five buckets in it, one for each quartile plus an additional one for null values. We have the sorter index, which we've seen before, and then we're looping through the nodes and finding the value for row A:

```javascript
function splitQuartiles(nodes, sorter) {
  let allBuckets = [[], [], [], [], []];
  const sorterIndex = headers.indexOf(sorter);
  nodes.forEach((currentVal) => {
    const rowA = Array.from(currentVal.childNodes);
    const x = parseFloat(rowA[sorterIndex].textContent);
  });
  return allBuckets;
}
```

### Bucketing into Quartiles

- In the `splitQuartiles()` function, you're going to treat the null values a little bit differently.
  - If this returns a null value and is empty, parse float will return not a number. So the first thing we're going to check is whether or not x is not a number.
  - Your first inclination might be to check whether or not x equals NaN. However, NaN does not work like that. There's a method called `isNaN`, and you pass it the variable:
  - You want to check whether or not it's not not a number, in other words, is it a number? And if it's not, push it to the very first bucket, so `if(!isNaN(X)) { // ... }`, with `allbuckets[0].push(currentVal)` in the `else`.
- Next, check to see if the value is within the quartile boundaries, so if `x` is greater than or equal to `columnSummary`, at the `[sorter]`, and look first at the min, and, the upper boundary will be `x` is less than or equal to column summary at the sorter, and upper boundary, which is the first quartile:
  - `if(x >= columnSummary[sorter].min && x <= columnSummary[sorter].first){ // ... }`
- After that, take all buckets and bucket one, and push the `currentVal`. Look for the next boundary, and start by looking at whether or not `x` is greater than the first quartile, and less than or equal to the mean.
  - If so, push it to bucket two, and look for `x` being greater than the mean, but less than or equal to the third quartile. If so, push to bucket three
  - Finally, look to see if `x` is greater than the third quartile, but less than or equal to the max. If so, push that to bucket four:

```javascript
if (!isNaN(x)) {
  if (x >= columnSummary[sorter].min && x <= columnSummary[sorter].first) {
    allBuckets[1].push(currentVal);
  }
  if (x > columnSummary[sorter].first && x <= columnSummary[sorter].mean) {
    allBuckets[2].push(currentVal);
  }
  if (x > columnSummary[sorter].mean && x <= columnSummary[sorter].third) {
    allBuckets[3].push(currentVal);
  }
  if (x > columnSummary[sorter].third && x <= columnSummary[sorter].max) {
    allBuckets[4].push(currentVal);
  }
} else {
  allBuckets[0].push(currentVal);
}
```
