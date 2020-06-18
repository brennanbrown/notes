# React Fundamentals

**Table of Contents:**

- [What is React?](#what-is-react-)
- [Introduction to React Elements](#introduction-to-react-elements)
  * [Creating React Elements](#creating-react-elements)
  * [Refactor Elements using JavaScript as XML (JSX)](#refactor-elements-using-javascript-as-xml--jsx-)
- [React Components](#react-components)
  * [React Properties (Props)](#react-properties--props-)
  * [Further Example w/ Destructuring](#further-example-w--destructuring)
  * [Create Function Components (Refactoring Example)](#create-function-components--refactoring-example-)
- [Props and State](#props-and-state)
  * [Compose Components](#compose-components)
  * [Displaying Child Components](#displaying-child-components)
  * [Introduction of State](#introduction-of-state)
  * [Using setState (Refactoring Example)](#using-setstate--refactoring-example-)
  * [Passing State as Props](#passing-state-as-props)
  * [Conditional Rendering](#conditional-rendering)
- [Additional Library Features](#additional-library-features)
  * [Component Life Cycle](#component-life-cycle)
  * [Fetching Data](#fetching-data)
  * [Accessibility](#accessibility)
  * [Forms](#forms)
  * [Default Props](#default-props)
  * [PropTypes](#proptypes)
  * [Modularizing Code](#modularizing-code)
  * [Building Applications and Deployment](#building-applications-and-deployment)

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

### Passing State as Props

* When working with a React application, it's a good rule of thumb to keep state in the root of the tree. 
    - In other words, your root component should hold all of the state variables and pass down that information to the children. 
    - You can read more about the idea of lifting state up or having state at the root in the React documentation: https://reactjs.org/docs/lifting-state-up.html
* The reason for this is if you have local state in all of your components, it's really easy to lose track of that state, and for some of these variables to be incorrect.
* Sometimes the state at the root is called the *source of truth*, and you want that source of truth to always be in the same place where you know where to find it.
* In the example below, whatever is the state value for `freeBookmark`, make that available in the child.
    - But the way that you access that in the child is going to via props. 
    - So, you're passing down state as props to the child component.
* Again, you're passing down state from the parent component. 
    - You're keeping this as the source of truth in our application, and then, the child component, the `freeBookmark`, is going to display that data from props.

```jsx
import React, { Component}  from "react"
import ReactDOM, { Render } from "react-dom"

// Mock Database
let bookList = [
    {"title": "The Sun Alsos Rises", "author": "Ernest Hemingway", "pages": 260},
    {"title": "White Teeth", "author": "Zadie Smith", "pages": 480},
    {"title": "Cat's Cradle", "author": "Kurt Vonnegut", "pages": 304},
]

const Book = ({title, author, pages, freeBookmark}) => {
    return (
        <section>
            <h2>{title}</h2>
            <p>By: {author}</p>
            <p>Pages: {pages}</p>
            <p>Free Bookmark Today: {freeBookmark ? "yes!" : "no!"}</p>
        </section>
    )
}

class Library extends Component {
    // Shorthand for adding a constructor for state
    state = { 
        open: true,
        // New state: 
        freeBookmark: true
    }

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
                        freeBookmark = {this.state.freeBookmark}
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

### Conditional Rendering

* There's already use of conditional rendering in the example app.
    - You use a ternary if statement to see if `this.state.open` is true. 
    - If so, it will display open. If it's false, it'll display closed. 
* This same pattern of conditional rendering can also be used with components. You might want to display different components given different conditions
* Just a quick note about the syntax for these function components: With the `Book` component, you're using the arrow function and wrapping all of these JSX elements with a return statement. 
    - You can always create our function components like that, but sometimes you'll see components created like this: `const Hiring = () => <div>Hiring!</div>` 
    - In other words, instead of adding the extra curly braces in the return, you can return these directly.
* This is a very common pattern in React. You can use conditional rendering to decide based on a certain condition what component should render and what should not.

```jsx

import React, { Component}  from "react"
import ReactDOM, { Render } from "react-dom"

// Mock Database
let bookList = [
    {"title": "The Sun Alsos Rises", "author": "Ernest Hemingway", "pages": 260},
    {"title": "White Teeth", "author": "Zadie Smith", "pages": 480},
    {"title": "Cat's Cradle", "author": "Kurt Vonnegut", "pages": 304},
]

const Book = ({title, author, pages, freeBookmark}) => {
    return (
        <section>
            <h2>{title}</h2>
            <p>By: {author}</p>
            <p>Pages: {pages}</p>
            <p>Free Bookmark Today: {freeBookmark ? "yes!" : "no!"}</p>
        </section>
    )
}

// New Conditionals for Rendering
const Hiring = () => 
    <div>
        <p>The library is hiring. Go to www.library.com/jobs for more information.</p>
    </div>

const NotHiring = () =>
    <div>
        <p>The library is not hiring. Check back later for more information.</p>
    </div>

class Library extends Component {
    // Shorthand for adding a constructor for state
    state = { 
        open: true,
        freeBookmark: true,
        hiring: false
    }

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
                {this.state.hiring ? <Hiring /> : <NotHiring />}
                <h1>The Library is: {this.state.open ? "open" : "closed"}.</h1>
                <button onClick={this.toggleOpenClosed}>Change State</button>
                {books.map(
                    (book, i) => 
                    <Book 
                        key = {i}
                        title = {book.title} 
                        author = {book.author} 
                        pages = {book.pages} 
                        freeBookmark = {this.state.freeBookmark}
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

## Additional Library Features

### Component Life Cycle

* The React component lifecycle provides functions that are invoked at specific times during the rendering lifecycle
    - See here: https://projects.wojtekmaj.pl/react-lifecycle-methods-diagram/
    - For example, terms like mounting and unmounting just means whenever it's added to the dom, and whenever it's taken away.
    - Component lifecycle methods are only available when using class syntax, so you can't use them with function components.
*  The only required method of the component lifecycle is render.
    - Whenever the props or state of the app changes, render will be called. 
    - The next method is the constructor. The constructor is called before the component is mounted, and it's a great place to initialize local state.
        + You can also bind event handler methods to this component class, using the constructor.
* Something else useful is `componentDidMount`, which, if you add a console.log for instance, will render as soon as the component is mounted. 
    - `componentDidMount() { console.log("This component has now mounted!") }`
* You can similarly utilize `componentDidUpdate`, which will only render if you update something (Eg. interaction), not when it's mounted.
    - `componentDidUpdate() { console.log("This component has now updated!") }`
* There are a bunch of other less common lifecycle methods, that you may want to explore given certain circumstances. But these inital ones will take you pretty far:
    - The `constructor` allows us to initialize state, before the component is mounted. 
    - `Render` is called every time there is any sort of change. 
    - `ComponentDidMount` is going to be called right after the component is added to the dom.
    - `ComponentDidUpdate`, when anything changes. 
    - And then you can similarly use `ComponentWillUnmount`, to do any sort of cleanup. Eg. You want to invalidate a timer, or if you want to do any cleanup of any nodes, you can do that here.

### Fetching Data

* `ComponentDidMount` is a really excellent place to fetch some data.

```jsx
import React, { Component}  from "react"
import ReactDOM, { Render } from "react-dom"

// Mock Database
let bookList = [
    {"title": "The Sun Alsos Rises", "author": "Ernest Hemingway", "pages": 260},
    {"title": "White Teeth", "author": "Zadie Smith", "pages": 480},
    {"title": "Cat's Cradle", "author": "Kurt Vonnegut", "pages": 304},
]

const Book = ({title, author, pages, freeBookmark}) => {
    return (
        <section>
            <h2>{title}</h2>
            <p>By: {author}</p>
            <p>Pages: {pages}</p>
            <p>Free Bookmark Today: {freeBookmark ? "yes!" : "no!"}</p>
        </section>
    )
}

// New Conditionals for Rendering
const Hiring = () => 
    <div>
        <p>The library is hiring. Go to www.library.com/jobs for more information.</p>
    </div>

const NotHiring = () =>
    <div>
        <p>The library is not hiring. Check back later for more information.</p>
    </div>

class Library extends Component {
    // Shorthand for adding a constructor for state
    state = { 
        open: true,
        freeBookmark: true,
        hiring: false
        // Fetching Data Example:
        data: [],
        loading: false
    }

    componentDidMount() {
        this.setState({loading: true)}
        // Fetching data from a REST API
        fetch("https://hplussport.com/api/products/order/price/sort/asc/qty1")
            .then(data => data.json())
            .then(data => this.setState({data, loading: false}))
        console.log("This component has now mounted!")
    }

    componentDidUpdate() { 
        console.log("This component has now updated!") 
    }

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
            // Using component lifecycle to fetch some remote data and display it:
            <div class="Advertisement">
                {this.state.hiring ? <Hiring /> : <NotHiring />}
                {this.state.loading
                    ? "Loading..."
                    : <div>
                        {this.state.data.map(product => {
                            return (
                                <div>
                                    <h3>Library Product of the Week!</h3>
                                    <h4>{product.name}</h4>
                                    <img src={product.image} height={100}/>
                                </div>
                        })}
                    </div>
                <h1>The Library is: {this.state.open ? "open" : "closed"}.</h1>
                <button onClick={this.toggleOpenClosed}>Change State</button>
                {books.map(
                    (book, i) => 
                    <Book 
                        key = {i}
                        title = {book.title} 
                        author = {book.author} 
                        pages = {book.pages} 
                        freeBookmark = {this.state.freeBookmark}
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

### Accessibility

* Web accessibility is a hugely important task of any developer. We want to make our websites as accessible as possible.
* `Create-react-app` has been configured with a linting tool call `jsx-a11y`. So if you're ever working in a project that's using it, there are several accessibility features baked in.
    - Eg. Image elements must have an alt prop, either with meaningful text or with an empty string for decorative images.
* Set the alt text to product.name. This means that if a screen reader is reading through our images and through our content, then this product name will be read versus just having nothing read.
    - `<img alt={product.name src={product.image} height={100}/>
* In addition, each child in an array or iterator should have a unique key prompt.
    - Eg. Add to the parent div: `<div key={product.id}>
    - More information: https://reactjs.org/docs/accessibility.html

### Forms

* A pretty common question that comes up when dealing with React is how do we handle forms? Let's create a simple form to demonstrate.
* When you're dealing with a React component, and trying to handle a form, you're going to use state to help parse values that are coming from the DOM.
* There's a lot of other cool things you can do with React forms, but these are kind of the basics. 
    - You can use state to setup an initial state for this value, and as new values come in from a form, parse them, and do with them what you want.

```jsx
import React, { Component}  from "react"
import ReactDOM, { Render } from "react-dom"

class FavouriteColourForm extends Component {
    state = { value: "" }

    newColour = e =>
        this.setState({ value: e.target.value })

    submit = e => {
        console.log(`New Colour: ${this.state.value}`)
        // Prevents the behavior of the form in the browser.
        e.preventDefault()
    }

    render () {
        return (
            <form onSubmit = {this.submit}>
                <label>Favourite Colour:
                    <input 
                        type = "colour"
                        onChange = {this.newColour}
                     />
                </label>
                <button> Submit! </button>
            </form>
            
            <p>Your favourite colour in hexidecimal is: {this.state.value}</p>
        )
    }
}

render(
    <FavouriteColourForm />,
    document.getElementById("root")
)

```

### Default Props

* At the top of the Library component, right above our state, add a static property called `defaultProps`. 
* Now what's the point of this? Well, you're adding this so that in the event that there's no value available for books, we're going to use this default value instead. 
* It's always a good idea to supply these values in case they're not provided for whatever reason. This will allow your UI to still render as expected.

```jsx
import React, { Component}  from "react"
import ReactDOM, { Render } from "react-dom"

// Mock Database
let bookList = [
    {"title": "The Sun Alsos Rises", "author": "Ernest Hemingway", "pages": 260},
    {"title": "White Teeth", "author": "Zadie Smith", "pages": 480},
    {"title": "Cat's Cradle", "author": "Kurt Vonnegut", "pages": 304},
]

// Using default argument syntax,
// in the event that an object is missing properties.
const Book = ({title = "No Title Provided", author = "No Author Provided", pages = 0, freeBookmark}) => {
    return (
        <section>
            <h2>{title}</h2>
            <p>By: {author}</p>
            <p>Pages: {pages}</p>
            <p>Free Bookmark Today: {freeBookmark ? "yes!" : "no!"}</p>
        </section>
    )
}

// New Conditionals for Rendering
const Hiring = () => 
    <div>
        <p>The library is hiring. Go to www.library.com/jobs for more information.</p>
    </div>

const NotHiring = () =>
    <div>
        <p>The library is not hiring. Check back later for more information.</p>
    </div>

class Library extends Component {
    // Default Props
    static defaultProps = {
        books: [
            {"title": "Tahoe Tales", "author": "Chet Whitley", "pages": 100}
        ]
    }

    state = { 
        open: true,
        freeBookmark: true,
        hiring: false
        // Fetching Data Example:
        data: [],
        loading: false
    }

    componentDidMount() {
        this.setState({loading: true)}
        // Fetching data from a REST API
        fetch("https://hplussport.com/api/products/order/price/sort/asc/qty1")
            .then(data => data.json())
            .then(data => this.setState({data, loading: false}))
        console.log("This component has now mounted!")
    }

    componentDidUpdate() { 
        console.log("This component has now updated!") 
    }

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
            // Using component lifecycle to fetch some remote data and display it:
            <div class="Advertisement">
                {this.state.hiring ? <Hiring /> : <NotHiring />}
                {this.state.loading
                    ? "Loading..."
                    : <div>
                        {this.state.data.map(product => {
                            return (
                                <div>
                                    <h3>Library Product of the Week!</h3>
                                    <h4>{product.name}</h4>
                                    <img src={product.image} height={100}/>
                                </div>
                        })}
                    </div>
                <h1>The Library is: {this.state.open ? "open" : "closed"}.</h1>
                <button onClick={this.toggleOpenClosed}>Change State</button>
                {books.map(
                    (book, i) => 
                    <Book 
                        key = {i}
                        title = {book.title} 
                        author = {book.author} 
                        pages = {book.pages} 
                        freeBookmark = {this.state.freeBookmark}
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

### PropTypes

* You looked at how `defaultProps` can be used to supply values when other values are not provided. Another nice property checking feature that we can include, is `propTypes`.
    - When set, an error will be thrown if a variable does not match the data type that is set for it.
    - This is really useful in debugging because it'll help you track down where the problem is.


```jsx
import React, { Component}  from "react"
import ReactDOM, { Render } from "react-dom"
// Will have to run `npm install prop-types --save` to install this new package.
import PropTypes from "prop-types"

// Mock Database
let bookList = [
    {"title": "The Sun Alsos Rises", "author": "Ernest Hemingway", "pages": 260},
    {"title": "White Teeth", "author": "Zadie Smith", "pages": 480},
    {"title": "Cat's Cradle", "author": "Kurt Vonnegut", "pages": 304},
]

// Using default argument syntax,
// in the event that an object is missing properties.
const Book = ({title = "No Title Provided", author = "No Author Provided", pages = 0, freeBookmark}) => {
    return (
        <section>
            <h2>{title}</h2>
            <p>By: {author}</p>
            <p>Pages: {pages}</p>
            <p>Free Bookmark Today: {freeBookmark ? "yes!" : "no!"}</p>
        </section>
    )
}

// New Conditionals for Rendering
const Hiring = () => 
    <div>
        <p>The library is hiring. Go to www.library.com/jobs for more information.</p>
    </div>

const NotHiring = () =>
    <div>
        <p>The library is not hiring. Check back later for more information.</p>
    </div>

class Library extends Component {
    // Default Props
    static defaultProps = {
        books: [
            {"title": "Tahoe Tales", "author": "Chet Whitley", "pages": 100}
        ]
    }

    state = { 
        open: true,
        freeBookmark: true,
        hiring: false
        // Fetching Data Example:
        data: [],
        loading: false
    }

    componentDidMount() {
        this.setState({loading: true)}
        // Fetching data from a REST API
        fetch("https://hplussport.com/api/products/order/price/sort/asc/qty1")
            .then(data => data.json())
            .then(data => this.setState({data, loading: false}))
        console.log("This component has now mounted!")
    }

    componentDidUpdate() { 
        console.log("This component has now updated!") 
    }

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
            // Using component lifecycle to fetch some remote data and display it:
            <div class="Advertisement">
                {this.state.hiring ? <Hiring /> : <NotHiring />}
                {this.state.loading
                    ? "Loading..."
                    : <div>
                        {this.state.data.map(product => {
                            return (
                                <div>
                                    <h3>Library Product of the Week!</h3>
                                    <h4>{product.name}</h4>
                                    <img src={product.image} height={100}/>
                                </div>
                        })}
                    </div>
                <h1>The Library is: {this.state.open ? "open" : "closed"}.</h1>
                <button onClick={this.toggleOpenClosed}>Change State</button>
                {books.map(
                    (book, i) => 
                    <Book 
                        key = {i}
                        title = {book.title} 
                        author = {book.author} 
                        pages = {book.pages} 
                        freeBookmark = {this.state.freeBookmark}
                    />
                )}
            </div>
        )
    }
}

Library.propTypes = {
    // If any other value is not supplied, then we should throw an error.
    books: PropTypes.array
}

Book.propTypes = {
    title: PropTypes.string,
    author: PropTypes.string,
    pages: PropTypes.number,
    freeBookmark: PropTypes.bool
}

render (
    <Library books={bookList}/>,
    document.getElementById("root")
)
```

### Modularizing Code

* As you progress and files become larger, you'll want to break up code and modularize it. 
    - You'll want to break it down into a list of different components, each in their own files. 
* For the above example, it might be smart to add `Book.js`, `Hiring.js`, and `Library.js`
* Note: Anytime you're using JSX, anytime that JSX is in scope, even if you're using just a regular function component, you're going to want to import `react`.
* As your files get larger, you don't need to modularize too quickly orfiles too quickly.
    - But anytime you find that maybe you want other people to work on certain files or anytime your files are getting a little bit too long to manage, you can always break them down into component files in order to track everything and make sure you're keeping everything straight.

**Book.js**

```jsx
import React, { Component } from "react"

export const Book = ({title = "No Title Provided", author = "No Author Provided", pages = 0, freeBookmark}) => {
    return (
        <section>
            <h2>{title}</h2>
            <p>By: {author}</p>
            <p>Pages: {pages}</p>
            <p>Free Bookmark Today: {freeBookmark ? "yes!" : "no!"}</p>
        </section>
    )
}
```


**Hiring.js**

```jsx
import React, { Component } from "react"

export const Hiring = () => 
    <div>
        <p>The library is hiring. Go to www.library.com/jobs for more information.</p>
    </div>

export const NotHiring = () =>
    <div>
        <p>The library is not hiring. Check back later for more information.</p>
    </div>
```
**Library.js**

```jsx
import React, { Component } from "react"
import PropTypes from "prop-types"
import { Book } from "./Book"
import { Hiring } from "./Hiring"
import { NotHiring } from "./Hiring"

class Library extends Component {
    // Default Props
    static defaultProps = {
        books: [
            {"title": "Tahoe Tales", "author": "Chet Whitley", "pages": 100}
        ]
    }

    state = { 
        open: true,
        freeBookmark: true,
        hiring: false
        // Fetching Data Example:
        data: [],
        loading: false
    }

    componentDidMount() {
        this.setState({loading: true)}
        // Fetching data from a REST API
        fetch("https://hplussport.com/api/products/order/price/sort/asc/qty1")
            .then(data => data.json())
            .then(data => this.setState({data, loading: false}))
        console.log("This component has now mounted!")
    }

    componentDidUpdate() { 
        console.log("This component has now updated!") 
    }

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
            // Using component lifecycle to fetch some remote data and display it:
            <div class="Advertisement">
                {this.state.hiring ? <Hiring /> : <NotHiring />}
                {this.state.loading
                    ? "Loading..."
                    : <div>
                        {this.state.data.map(product => {
                            return (
                                <div>
                                    <h3>Library Product of the Week!</h3>
                                    <h4>{product.name}</h4>
                                    <img src={product.image} height={100}/>
                                </div>
                        })}
                    </div>
                <h1>The Library is: {this.state.open ? "open" : "closed"}.</h1>
                <button onClick={this.toggleOpenClosed}>Change State</button>
                {books.map(
                    (book, i) => 
                    <Book 
                        key = {i}
                        title = {book.title} 
                        author = {book.author} 
                        pages = {book.pages} 
                        freeBookmark = {this.state.freeBookmark}
                    />
                )}
            </div>
        )
    }
}

Library.propTypes = {
    // If any other value is not supplied, then we should throw an error.
    books: PropTypes.array
}

Book.propTypes = {
    title: PropTypes.string,
    author: PropTypes.string,
    pages: PropTypes.number,
    freeBookmark: PropTypes.bool
}

export default Library
```

**Index.js**

```jsx
import React, { Component}  from "react"
import ReactDOM, { Render } from "react-dom"
import Library from "./Library"

let bookList = [
    {"title": "The Sun Alsos Rises", "author": "Ernest Hemingway", "pages": 260},
    {"title": "White Teeth", "author": "Zadie Smith", "pages": 480},
    {"title": "Cat's Cradle", "author": "Kurt Vonnegut", "pages": 304},
]

render (
    <Library books={bookList}/>,
    document.getElementById("root")
)
```

### Building Applications and Deployment

* When you're done putting together your project, you can post it online and you may want to create a production build to do that. 
    - Now you'll notice that when you run `create-react-app`, it says to create a production build use `npm run build.` 
    - This is basically going to create an optimized build that's ready to post on something like Netlify or Zite or some other sort of hosting provider.
    - When this optimizes, it's going to minify everything, it's going to optimize in order to make this as fast as possible!
* Now, the next step you'll see here is that the build folder is ready to be deployed and you may serve it with a static server. You should see in the new folder created that there are all of these static assets. All these JavaScript files that are in one line
*  The next thing that we can do though is we can serve it locally with a static server using an npm package called serve. 
    - Let's make sure that this is installed so we can run `sudo npm install serve -g`. 
    - Then, type `serve -s build` so we're going to serve the build folder and this is going to run this on `localhost:5000`.
