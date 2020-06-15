# React Fundamentals

**Table of Contents:**

- [React Fundamentals](#react-fundamentals)
  * [What is React?](#what-is-react-)
  * [Introduction to React Elements](#introduction-to-react-elements)
    + [Creating React Elements](#creating-react-elements)
    + [Refactor Elements using JavaScript as XML (JSX)](#refactor-elements-using-javascript-as-xml--jsx-)
  * [React Components](#react-components)
    + [React Properties (Props)](#react-properties--props-)
    + [Further Example w/ Destructuring](#further-example-w--destructuring)
    + [Create Function Components (Refactoring Example)](#create-function-components--refactoring-example-)
  * [Props and State](#props-and-state)
    + [Compose Components](#compose-components)
    + [Displaying Child Components](#displaying-child-components)
    + [Introduction of State](#introduction-of-state)
    + [Using setState (Refactoring Example)](#using-setstate--refactoring-example-)

## What is React?

* Among all other JavaScript libraries, React.js stands out. 
    - It relies on reusable components, not templates, for UI development, allowing developers to render views where data changes over time. 
    - React applications are more scalable and more maintainable, making developers more efficient and users more satisfied. 
* React was created at Facebook and was released initially in March, 2013, and since then React has expanded beyond the web with *React Native*, a tool that allows you to create native mobile applications using React. 
    - Another reason to like React is that they have very useful documentation. If you head over to [reactjs.org](https://reactjs.org/docs), you'll see a bunch of resources for getting started as well as an official tutorial that the React team has created.
    - React is an increasingly-popular library with tens of thousands of stars on GitHub and used in production by huge companies like Uber, Netflix, and Twitter. etc.
* Before getting started, install the `React Developer Tools`. 
    - The React Developer Tools are a browser extension that you can install to explore sites, your own or other people's, that use React.

## Introduction to React Elements

*  `create-react-app` is a tool that will allow you to set up a React project without any build configuration. 
    - In other words, you don't have to set up Babel in order to use the latest JavaScript syntax. 
    - That's built-in to `create-react-app`. You also don't have to set up Web Pack or any other tools. 
    - To install locally, just use npm, eg. `sudo npm install -g create-react-app`
    - To then use, you just type `create-react-app [name]`
* After creating a project, going into the `package.json` file will reveal three dependencies:
    - `react` is what will allow you to create components and use the React library. 
    - `react-dom` will be everything needed to take those components and place them in the dom, so to actually render them to the page.
    - `react-scripts` is where some of the magic happens. This is what's handling all of the transpiling of new syntax into browser compatible syntax.

### Creating React Elements

```jsx
import React from "react"
import ReactDOM from "react-dom"

var style = {
    backgroundColor: "orange",
    color: "white",
    fontFamily: "Arial",
    textAlign: "center"
}

// React Element Example
const title = React.createElement(
    "h1",
    {id: "title", className: "header", style: style},
    "Hello world!"
)

ReactDOM.render(
    title,
    document.getElementById("root")
)

```

### Refactor Elements using JavaScript as XML (JSX)

*  React provides us with is a different syntax called JSX, or JavaScript as XML, which is a tag-based syntax that you can use to create React elements.
* It's a tag-based syntax that you can use to skip out on all of those create element calls and instead use this much cleaner syntax.

Non-JSX Example:

```jsx

import React from "react"
import ReactDOM from "react-dom"

var style = {
    backgroundColor: "orange",
    color: "white",
    fontFamily: "Arial",
    textAlign: "center"
}

// React Element Example
const title = React.createElement(
    "ul",
    {id: "title", className: "header", style: style},
    React.createElement(
        "li",
        {},
        "Item On List"
    )
)

ReactDOM.render(
    title,
    document.getElementById("root")
)

```

JSX Example:

```jsx


import React from "react"
import ReactDOM from "react-dom"

var style = {
    backgroundColor: "orange",
    color: "white",
    fontFamily: "Arial",
    textAlign: "center"
}

ReactDOM.render(
    <div style={style}>
        <h1 id="heading element">Hello World!</h1>
        <p>Creating HTML within JavaScript</p>
    </div>
    document.getElementById("root")
)
```

## React Components

* The reason that React has become so popular is due to its component based structure. 
    - You create a user interface simply by creating and nesting a collection of components.
* The most critical thing to understand about React components is all of them have a render method. 
    - The render method describes what we want to render to the DOM. 
* One thing to note is all React components should be capitalized in the newer versions.

```jsx
import React from "react"
import ReactDOM from "react-dom"

class Message extends React.Component {
    render() {
        // Adding a return here helps deal with bugs later!
        return (
            <div>
                <h1>Hello World!</h1>
            </div>
        )
    } 
}

ReactDOM.render(
    <Message />,
    document.getElementById("root")
)
```

### React Properties (Props)

* Currently, you're just rendering the `message` component to the `root` div, but what if you wanted to make this message dynamic? 
    - To do this, you'd use React Props. The first step in working with Props is to pass data to the `message` component.
    - You access props with `{this.props.key}`, wherein the `key` is whatever the prop name is.
    - The Props object can contain as many properties as you'd like.
* To inspect the props of your current React app, simply utilize `console.log(this.props)`
* Data types such as numbers and booleans need to be wrapped within the JSX expression, eg. `{}`

```jsx
import React from "react"
import ReactDOM from "react-dom"

class Message extends React.Component {
    render() {
        console.log(this.props)
        // Adding a return here helps deal with bugs later!
        return (
            <div>
                // Using props as CSS style:
                <h1 style{{color: this.props.color}}>
                    {this.props.header}
                </h1>
                <p>I'll check back in {this.props.minutes} minutes.</p>
            </div>
        )
    } 
}

ReactDOM.render(
    <Message color="blue" header="Hello World!" minutes={5}/>,
    document.getElementById("root")
)
```

### Further Example w/ Destructuring

* In addition to properties, you can add methods that are local to these components.

```jsx
// Building a page that will count the amount of sunny days for the year.

// ES6 Destructure Component from react
import React, { Component}  from "react"
// Destructure Render from react-dom
import ReactDOM, { Render } from "react-dom"

let weatherData = {
    total: 365,
    sunny: 280,
    cloudy: 20,
    rainy: 30,
    snowy: 35
}

// No longer requires React.Component
class SunnyDayCounter extends Component {
    // Custom Methods Example 
    getPercent = decimal => {
        return decimal * 100 + "%"
    }

    calcWeatherAmount = (total, sunny) => {
        return this.getPercent(total / sunny)
    }

    render() {
        // Another destructure so props no longer require this.props as prefix.
        const {total, sunny, cloudy, rainy, snowy} = this.props
        return (
            <section>
                <h1>Yearly Weather in Calgary</h1>
                <div>
                    <p>Sunny Days Percentage: {this.calcWeatherAmount(total, sunny)} </p>
                </div>
                <div>
                    <p>Total Days: {total}</p>
                </div>
                <div>
                    <p>Sunny Days: {sunny}</p>
                </div>
                <div>
                    <p>Cloudy Days: {cloudy}</p>
                </div>
                <div>
                    <p>Rainy Days: {rainy}</p>
                </div>
                <div>
                    <p>Snowy Days: {snowy}</p>
                </div>
            </section>
        )
}


// No longer requires React.render
render(
    <SunnyDayCounter 
        total = {weatherData.total}
        sunny = {weatherData.sunny}
        cloudy = {weatherData.cloudy}
        rainy = {weatherData.rainy}
        snowy = {weatherData.snowy}
        />,
    document.getElementById("root")
)
```

### Create Function Components (Refactoring Example)

* Using the JavaScript syntax we know and love, we can create a JavaScript function that returns JSX elements to be rendered

```jsx
import React, { Component}  from "react"
import ReactDOM, { Render } from "react-dom"

let weatherData = {
    total: 365,
    sunny: 280,
    cloudy: 20,
    rainy: 30,
    snowy: 35
}

const getPercent = decimal => {
    return decimal * 100 + "%"
}

const calcWeatherAmount = (total, sunny) => {
    return getPercent(total / sunny)
}

// Function Component:
// Passing the props object to be consumed by the component
const SunnyDayCounter = ({total, sunny, cloudy, rainy, snowy}) => {
    return (
        <section>
            <h1>Yearly Weather in Calgary</h1>
            <div>
                <p>Sunny Days Percentage: {calcWeatherAmount(total, sunny)} </p>
            </div>
            <div>
                <p>Total Days: {total}</p>
            </div>
            <div>
                <p>Sunny Days: {sunny}</p>
            </div>
            <div>
                <p>Cloudy Days: {cloudy}</p>
            </div>
            <div>
                <p>Rainy Days: {rainy}</p>
            </div>
            <div>
                <p>Snowy Days: {snowy}</p>
            </div>
        </section>
    )
}

render(
    <SunnyDayCounter 
        total = {weatherData.total}
        sunny = {weatherData.sunny}
        cloudy = {weatherData.cloudy}
        rainy = {weatherData.rainy}
        snowy = {weatherData.snowy}
        />,
    document.getElementById("root")
)
```

## Props and State

### Compose Components

* So far, you've created a component and created some custom methods to live on that component.
    - However, the power of React comes from composing multiple different components.
* As far as composing components go, that when we talk about composing components, it might be tempting to render multiple different library components to the DOM.
* In other words, composing a component is building parent-child relationships, that are rendered within one another.
    - In the example below, the library is the parent component that displays one or more child components, like the book.

```jsx
import React, { Component}  from "react"
import ReactDOM, { Render } from "react-dom"

const Book = ({title, author, pages}) => {
    return (
        <section>
            <h2>{title}</h2>
            <p>By: {author}</p>
            <p>Pages: {pages}</p>
        </section>
    )
}

const Library = () => {
    return (
        <div>
            <Book 
                title="The Sun Alsos Rises" 
                author="Ernest Hemingway"
                pages={260}
            />

            <Book 
                title="White Teeth" 
                author="Zadie Smith"
                pages={480}
            />

            <Book 
                title="Cat's Cradle" 
                author="Kurt Vonnegut"
                pages={304}
            />
        </div>
    )
}

render (
    <Library />,
    document.getElementById("root")
)
```

### Displaying Child Components

* Let's make the previous example a little bit more of a real world use case, by creating an array of data and then displaying books based on that data.
* Each of these are being driven from props, which come from the booklist itself. 
    - Since this data is dynamic, if you add additional records to your database, (or whatever the data source is) it's going to reflect this. 
    - Eg. You could add another book, and not have to change anything about the `library` component.
* However, currently as is, there's going to see a warning here, that says that each child in an array should have a unique key property. 
    - You need to add a key to each dynamically rendered child.
    - This serves as a unique identifier, which will help track which of these components are updating, and rendering with React.
    - This can be done by changing `book` to `(book, i)`, wherein `i` is the key.
* Now, all of the books have a unique key, which will help with rendering, and now our React UI's are a reflection of our data. 
    - As you add books to our library, to our database, we'll dynamically display nested components within the parent component, the library.

```jsx
import React, { Component}  from "react"
import ReactDOM, { Render } from "react-dom"

// Mock Database
let bookList = [
    {"title": "The Sun Alsos Rises", "author": "Ernest Hemingway", "pages": 260},
    {"title": "White Teeth", "author": "Zadie Smith", "pages": 480},
    {"title": "Cat's Cradle", "author": "Kurt Vonnegut", "pages": 304},
]

const Book = ({title, author, pages}) => {
    return (
        <section>
            <h2>{title}</h2>
            <p>By: {author}</p>
            <p>Pages: {pages}</p>
        </section>
    )
}

const Library = ({books}) => {
    return (
        <div>
            {books.map(
                (book, i) => 
                <Book 
                    key = {i}
                    title = {book.title} 
                    author = {book.author} 
                    pages = {book.pages} 
                />
            )}
        </div>
    )
}

render (
    // Makes data accessible within the component tree.
    <Library books={bookList}/>,
    document.getElementById("root")
)
```

### Introduction of State

* One of the most important concepts in React is state. 
    - Components can have a local state but in order to use this, we need to use in the ES6 class component.
    - to demonstrate this, let's update the library component to be an ES6 class instead of a function component. So this is always fairly easy to refactor.
* One way to add local state to this component is to use the constructor method.
    - Put simply, state is just going to be an object with several different keys on it, similar to props.
    - State is just an object and it has as many keys as you set up and then you can use these values within the context of your component. And you can also change them.

```jsx
import React, { Component}  from "react"
import ReactDOM, { Render } from "react-dom"

// Mock Database
let bookList = [
    {"title": "The Sun Alsos Rises", "author": "Ernest Hemingway", "pages": 260},
    {"title": "White Teeth", "author": "Zadie Smith", "pages": 480},
    {"title": "Cat's Cradle", "author": "Kurt Vonnegut", "pages": 304},
]

const Book = ({title, author, pages}) => {
    return (
        <section>
            <h2>{title}</h2>
            <p>By: {author}</p>
            <p>Pages: {pages}</p>
        </section>
    )
}

class Library extends Component {
    constructor(props) {
        super(props)
        this.state = {
            open: true
        }
    }
    render() {
        console.log(this.state)
        const { books } = this.props
        return (
            <div>
                // Conditional Rendering Example:
                // Inline / Ternary Statement
                <h1>The Library is: {this.state.open ? "open" : "closed"}.</h1>
                {books.map(
                    (book, i) => 
                    <Book 
                        key = {i}
                        title = {book.title} 
                        author = {book.author} 
                        pages = {book.pages} 
                    />
                )}
            </div>
        )
    }
}

render (
    <Library books={bookList}/>,
    document.getElementById("root")
)
```

### Using setState (Refactoring Example)

* You know how to add state variables to a React application, but how do we change state? By use of a function called `setState`, which is going to change the state variable within the component.
    - Put simply, `setState` is going to take in an object, which resets the state.
* `setState` is asynchronous. So if you are relying on the previous state to set a new value, you can use a callback function inside of `setState`.
    - Because of this, you're going to want to refactor, since you're going to see a lot of callback functions instead of objects here in the `setState` function.

```jsx
import React, { Component}  from "react"
import ReactDOM, { Render } from "react-dom"

// Mock Database
let bookList = [
    {"title": "The Sun Alsos Rises", "author": "Ernest Hemingway", "pages": 260},
    {"title": "White Teeth", "author": "Zadie Smith", "pages": 480},
    {"title": "Cat's Cradle", "author": "Kurt Vonnegut", "pages": 304},
]

const Book = ({title, author, pages}) => {
    return (
        <section>
            <h2>{title}</h2>
            <p>By: {author}</p>
            <p>Pages: {pages}</p>
        </section>
    )
}

class Library extends Component {
    // Shorthand for adding a constructor for state
    state = { open: false }

    toggleOpenClosed = () => {
        // Adding prevState will make sure that this.setState, 
        // no matter how long it takes, will work as expected.
        this.setState(prevState => ({
            open: !prevState.open
        }))
    }

    render() {
        console.log(this.state)
        const { books } = this.props
        return (
            <div>
                // Conditional Rendering Example:
                // Inline / Ternary Statement
                <h1>The Library is: {this.state.open ? "open" : "closed"}.</h1>
                <button onClick={this.toggleOpenClosed}>Change State</button>
                {books.map(
                    (book, i) => 
                    <Book 
                        key = {i}
                        title = {book.title} 
                        author = {book.author} 
                        pages = {book.pages} 
                    />
                )}
            </div>
        )
    }
}

render (
    <Library books={bookList}/>,
    document.getElementById("root")
)
```
