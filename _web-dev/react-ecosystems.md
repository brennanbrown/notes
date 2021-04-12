# React Ecosystems

**Table of Contents:**

- [React Ecosystems](#react-ecosystems)
  - [Introduction](#introduction)
  - [Electrons](#electrons)
  - [Routing and Navigation](#routing-and-navigation)
  - [Server-side Rendering](#server-side-rendering)
  - [State Management (Redux)](#state-management-redux)
  - [Mobile (React Native)](#mobile-react-native)
  - [Animations (React Motion)](#animations-react-motion)
  - [Testing and Debugging (React Developer Tools and Jest)](#testing-and-debugging-react-developer-tools-and-jest)
  - [Types (Flow)](#types-flow)

## Introduction

- What exactly is React and what does it offer at its core? Simply put, React doesn't try to be too many things.
  - In fact, it has a small library or API to keep things simple. Its power lies in providing you with the proper syntax and infrastructure to build your application with components everywhere.
  - It uses props to pass data to your components and stays to keep track of your current application state.
  - But part of the genius of React is that it allows a community an ecosystem to address other needs you might have with your application.
- React's list of libraries is constantly growing everyday. So where do you go from here?
  - Once you're comfortable with the initial electrons mentioned, and React itself, explore the React communities on Twitter and Facebook to understand the realm of options available.

## Electrons

- Any application needs more than simple syntax, props and states to work. That's where the electrons come into play.
  - As the popularity of React has soared over the years, a developer community has gathered around its core and built hundreds of extensions to provide everything we need to build best in class in Enterprise applications.
  - When you look at the electrons surrounding the React core you can see tons of functional libraries helping us achieve specific goals for applications.
  - For example, service site rendering, state management, mobile, testing and debugging, animation, routing and navigation types, and many others.

## Routing and Navigation

- Let's start with routing and navigation. You use them everyday when you surf the web or navigate through an application's menu.
  - Behind the scenes, routing basically happens as a function of navigating to different pages or sections of a website or app.
  - For example, when you browse a webpage and you click on a navigation link you are _routed_ to a new page.
  - Although it may seem complex initially, routing is really quite simple. Let's say when you click on a link labeled news on the webpage navigation when you do this, the link calls a route named news.

* For example: This route has a component news attached to it. And the component will render that page in the browser.
  - If you click on other links, the same process happens over and over and over.
  - On a mobile or web application it's the same when you tap or click any items that require a render for a new section or page.
* In React, the best way to get started with routing is by using a great library called **React Router**. It has a simple syntax and you can get up and running quickly.
  - More information: https://reacttraining.com/react-router/

## Server-side Rendering

- Let's talk next about server side rendering. Think about what happens when you browse the web you type a URL into your browser and an application or website loads. So where does this app, or website render?
  - On the server, where it is usually hosted, or on your browser, commonly called a client.
  - Well it turns out both are right. Depending on the application ,some are rendered on the server, and some on the client. It means that grabbing all your code and presenting the final HTML can be done on both sides!
- What are the benefits of rendering on the service side? It depends on multiple factors.
  - The short answer is that it can make your application run faster, it's more secure, and SEO friendly.
- How is this done in React?
  - There are multiple ways to do this. But the simplest way to get started is to use `ReactDomServer` APIs provided with React's core library.
  - Eg. You can use the `renderToString()` method in the server code, or if you want the static HTML without the extra attributes you can use `renderToStaticMarkup()`.
  - More information: https://facebook.github.io/react

## State Management (Redux)

- What exactly is state management? Let's start by defining what a state is.
  - When data changes, or when you click on a link, the application will change to reflect these events.
  - Think of a state as the web page you're on before there are any changes or before you click on any links. That is the current state of the site or application at that point in time.
  - When you click on a link, you change the state of the application at another point in time.
  - So, state management is, in its simplest form, managing different points in time, or states, for your application.
- With React, we get an object we can observe and analyze, one that is called, that's right, the state.
  - As these events occur, you see the state changing both visually on the web page or application and internally in the state object.
- **Redux**, one of the leading libraries, provides us with great syntax and structure to manage our state.
  - Redux has actions that call reducers, which are functions that create a new state based on the previous one with the new action added to it.
  - For example: If you click an action, such as "get me the latest news", the reducer will copy the old list of news, add the new ones, and create a new state object with updated news.
  - More information: https://redux.js.org

## Mobile (React Native)

- A couple years ago, React's team decided to remove the web APIs, call the React DOM from the React library.
  - This opened up the possibility of using React in new environments such as mobile devices. Needless to say, mobile devices have becomes a huge part of our lives.
  - React's component approach is the perfect tool to build mobile applications on iOS, Android, and Windows mobile devices with a single library called React Native.
- With **React Native** you can use the approach of building components once, and deploy your application to these environments.
  - Because of the nature of mobile operating systems and the differences between them, the community was driven to build more libraries to support all kinds of scenarios.
  - Some of these include mobile routing, UI elements, starting kits, IDEs, and testing libraries specific to React Native.
  - More information: https://facebook.github.io/react-native.

## Animations (React Motion)

- Using applications can be boring if there isn't animation to enhance the interactions when you click on something. Or, there's no animation when the application updates, or events occur between you and the app.
- In fact, research has shown that subtle and well-placed animations make the difference between an addictive application and one that just "feels meh".
- For React there are a few ways to do animation. For example, there is the _transition group_ that is part of React's library.
  - It's quite simple and doesn't provide too many options. If you want to get started quickly you can always use it.
  - But if you really want to push the animation possibilities or even do a full feature show using some of the 12 principles of animation then you're better off using a library like React Motion.
- **React Motion** offers spring, motion, and transitions and many other ways to get your components on, and off screen, or interact with user events.
  - More information: https://github.com/chenglou/react-motion

## Testing and Debugging (React Developer Tools and Jest)

- As you develop your application, you'll probably spend a lot of time trying to figure out why it isn't working the way you want, finding where you missed something or tracking down a syntax error or typo.
- The point is, application development almost never goes smoothly. This is where the tools for debugging and testing come into play.
  - There are several tools built around React to test and debug your site or application.
- **React Developer Tools** come to the rescue, for example, when you need to inspect my components to figure out what the state of my application is, or when I need to see what my state object looks like, or when I need to see what props are being passed to my component.
  - It's built on top of your browser's developer tools, and it will let you see all this information and more.
- You use **Jest** to test whether a component properly renders with snapshots, which are great for UI tests.
  - When you need to know which files are being tested, Jest provides great coverage reports. You can also use its library when you need to validate that the proper values are returned with matchers.
  - Even though Jest is built by Facebook and is aimed at React applications, you can also use it with many other frameworks, so all the time you invest in learning it is well spent.
  - More information: https://facebook.github.io/jest, and https://github.com/facebook/react-devtools

## Types (Flow)

- In the same vain as Jest, you have _type checking_.
  - In very simple terms, type checking allows us to specify the type of data our variables, objects, or functions are expecting. It adds another tool for application efficiency and bug prevention.
  - For example, your variable `myNum` is expecting a number. If you pass a string instead, you'll get a warning, or if strict enough, a failure to compile.
- In other words, when you pass value that is not of the expected type, you'll be in trouble.
  - The benefit of using type checking is to eliminate a lot of the bugs. Or, understand why your code may not work as expected.
  - Along with the previous tools mentioned you've got everything you need to prevent alarms from going off.
- With React, there are two ways to do type checking. You can use a simple library called `propTypes` to get started. Or, if you want a more robust API to do type checking you can use **Flow**.
  - Both libraries were written by Facebook so you can be assured they have great tools built specifically for React.
  - More information: https:://github.com/reactjs/prop-types and https://flow.org
