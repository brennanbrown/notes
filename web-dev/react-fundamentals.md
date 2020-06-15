# React Fundamentals

## Introduction: What is React?

* Among all other JavaScript libraries, React.js stands out. 
    - It relies on reusable components, not templates, for UI development, allowing developers to render views where data changes over time. 
    - React applications are more scalable and more maintainable, making developers more efficient and users more satisfied. 
* React was created at Facebook and was released initially in March, 2013, and since then React has expanded beyond the web with *React Native*, a tool that allows you to create native mobile applications using React. 
    - Another reason to like React is that they have very useful documentation. If you head over to [reactjs.org](https://reactjs.org/docs), you'll see a bunch of resources for getting started as well as an official tutorial that the React team has created.
    - React is an increasingly-popular library with tens of thousands of stars on GitHub and used in production by huge companies like Uber, Netflix, and Twitter. etc.
* Before getting started, install the `React Developer Tools`. 
    - The React Developer Tools are a browser extension that you can install to explore sites, your own or other people's, that use React.

# Introduction to React Elements

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

```jsx
// Non-JSX Example

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

```jsx
// JSX

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
                    <p>Snowy Days: {this.props.Snowy}</p>
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
