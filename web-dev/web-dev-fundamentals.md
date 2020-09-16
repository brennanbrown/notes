# Success as a Web Developer

**Table of Contents:**

- [Success as a Web Developer](#success-as-a-web-developer)
  - [Introduction](#introduction)
  - [Overview of the Internet](#overview-of-the-internet)
  - [Elements of Web Development](#elements-of-web-development)
    - [Version Control](#version-control)
    - [Server Technologies](#server-technologies)
  - [Tools and Frameworks](#tools-and-frameworks)
    - [JavaScript Frameworks](#javascript-frameworks)
  - [Application Connections](#application-connections)
  - [Internet Website Process](#internet-website-process)

## Introduction

- Read and write proper documentation for the projects and languages you're working on.
- Examine the code of other developers' and explore new ideas.
- Make mistakes--often. It strengthens your ability to be a developer by challenging you to find, test, and anticipate errors.

## Overview of the Internet

- Information Structure: How to best organize a website for the user.
- HTML and Document Object Model --> Accessing Elements with CSS and JS
- CSS for design/user experience, interactivity
  - Setting rules for the webpage.
  - [CSS Zen Garden](https://csszengarden.com)
  - There are several different ways to organize your CSS, including OOCSS (Object-oriented), SMACSS (Scalable and Modular Architecture), BEM (Block, Element, Modifier.)
- Design has to be responsive (web, mobile, tablet, etc.)
- JavaScript manages interaction within a browser.
  - Interacts the DOM to handle events.
  - A transpilier is often needed to have cross-browser compatibility.
- The protocol HTTP(S) for connection.
  - `GET` : Asks to receive information
  - `POST` : Sends information
  - `DELETE` : Deletes information
  - HTTP/2 has multiplexing.

## Elements of Web Development

- _TCP_/_IP_ (Transmission Control Protocol/ Internet Protocol) is responsible for largely how the Internet functions today.
  - Breaks information down into packets (TCP) and get past into the best available paths at the moment.
  - IP is the address that the packets get sent too.
  - A DNS (Domain Name Server) converts URLs into these IP locations.
  - The URL (Uniform Resource Identifier/Locater) is the entire name of a website that is an easily-readable address that the user types in.
- Orient your projects to be _accessible_. Making something easier for a certain group of users makes things easier for every user.
  - Use ARIA to help write your HTML in accessible ways.
  - Use Google's Lighthouse tool to get an overview of your entire site.
- The methodology called _Mobile-First_ teaches that you should always seek to simplify what is being displayed, especially on smaller devices.
- Beyond the three primary languages of web design (HTML, CSS, and JS), there are a multitude of languages built on top of these that have marked improvements.
  - Eg. _SASS_ is a language that allows logic to be transpiled to CSS
- JavaScript was originally designed to be functional, not object-oriented, but has evolved to be a hybrid of both.
- _MVC_ (Model-View-Controller) is a popular design concept for treating the data or model as a separate entity, then creating a template which is called the view which uses that data, and finally writing code called the controller that combines the model and the view.
- Another way of organizing code is a _component-based architecture_.
  - This means separating functionality into self-contained pieces, so flexible and reusable parts can be shared between applications
- Built tests for your applications to constantly check for problems in all parts of your development process.

### Version Control

- _Agile_ is the philosophy of regrouping regularly to be sure your software can rapidly adjust in order to meet the customer's needs.
- _DevOps_ is the combination of software development and IT operations, with the goal being to shorten the time between writing the code and deployment.
- In addition to continuous delivery, up-to-date and well written _documentation_ is vital to allow others (and you in the future) to understand and build upon your existing work.
- _Git_ allows people to work on their own versions of a project and then merge these different versions later.

### Server Technologies

- Most servers have transitioned from physical devices of hardware to cloud-based virtual machines that are usually run by large companies such as Microsoft Azure, Amazon Web Services, or Google Cloud Platform.
- These cloud-based virtual machines are considered elastic in nature, meaning their specifications can grow based on how much demand your application or website needs from them.
- You can place data closer to your users by using a _CDN_ (Content delivery network) which creates copies of a server's information on physically closer machines.

- _SQL_ (structured query language) is often used as back-end language for storing and organizing data that will be retrieved by the front-end.
- _NoSQL_ are languages that do not implement the traditional and rigid structure that SQL languages have, and can be faster due to the lack of overhead.

## Tools and Frameworks

- _IDE_ (integrated development environment) is a program that helps you write, debug, and document code as well as compile and run it.
- _Webpack_ is an open-source JavaScript module bundler. It is a module bundler primarily for JavaScript, but it can transform front-end assets as well.
- _Babel_ is a free and open-source JavaScript transcompiler that is mainly used to convert ECMAScript 2015+ code into a backwards compatible version of JavaScript that can be run by older JavaScript engines.
- There are many HTML/CSS frameworks, with _Bootstrap_ being the most popular and oldest, with other popular ones including Material Design, Foundation.

### JavaScript Frameworks

- _D3.js_ is a JavaScript library for producing dynamic, interactive data visualizations in web browsers. It makes use of the widely implemented Scalable Vector Graphics, HTML5, and Cascading Style Sheets standards
- _jQuery_ is a JavaScript library designed to simplify HTML DOM tree traversal and manipulation, as well as event handling, CSS animation, and Ajax.
- _Angular_ is a TypeScript-based open-source web application framework led by the Angular Team at Google and by a community of individuals and corporations.
- _React_ is a JavaScript library for building user interfaces. It is maintained by Facebook and a community of individual developers and companies.
- _Vue.js_ is an open-source Model–view–controller JavaScript framework for building user interfaces and single-page applications.

## Application Connections

- A programmer often doesn't build an entire program, but rather a _service_ that is utilized by another program in order to simplify the sharing of data.
- An application programming interface is an interface or communication protocol between different parts of a computer program intended to simplify the implementation and maintenance of software.
  - An _API_ may be for a web-based system, operating system, database system, computer hardware, or software library.
- Representational state transfer is a software architectural style that defines a set of constraints to be used for creating Web services.
  - Web services that conform to the _REST_ architectural style, called _RESTful_ Web services, provide interoperability between computer systems on the Internet.
  - These requests use the HTML language of GET and POST, and are usually returned in the JSON format.
- There are services such as _OAuth_ which validate applications in order to make sure they are secure by acting as an intermediary between the service and the program.

## Internet Website Process

- Type a URL into the address bar, hit return, what happens?
- points at a specific resource somewhere on the web
  - That somewhere is a server that is mapped to that specific IP
  - Browser sends a GET request to the server
  - DNS figures out which domain the domain is pointing at
  - Retrieves all the data and presents it in the browser's viewport.
  - You can then start interacting the data and elements
  - Carefully-structured elements are in containers with a visual structure that's created with CSS. Everything is a box within a box.
  - The browser is JUST an advanced viewer of web documents
- Any time a browser is asked to display an HTML document, it creates a document object model or **DOM**, which is a structural representation of the elements in the document and their relationships.
  - This document object model can be visualized as a DOM tree, where each element is a leaf or node, and the connections are branches. When you add new elements to an HTML document, you are effectively adding a node to this DOM tree.
  - When you target elements using CSS or JavaScript, you ask the browser to follow the branches all the way from the root to the node or nodes in question.
  * This is called either walking or traversing or navigating the DOM.
  - When creating a website, it can be helpful to draw out the DOM tree to understand relationships and inheritances between different elements.
  - This also encourages the reduction of complexity and avoid unnecessary nesting by prioritizing accessibility and logical structure.
- **HTML** was created to allow humans to write highly-structured documents which could be interpreted consistently and universally by any rendering engine supporting the language.
  - HTML is a declarative markup language, meaning it describes the contents of a document.
  - However, HTML does not provide instructions about the control flow or processing or interactions with that content.
  - This allows the reader, commonly known as a _client_, so a web browser or some other application, to decide how to handle the different types of content which makes HTML incredibly versatile and accessible.
  - The DOM tree is the browser representation of every HTML element and their relationships with other elements.
- Web documents is a document with superpowers, by marking up a document in HTML, it can be viewed by anybody and anywhere they want. It is not proprietary or tied to any specific visuals.
  - Accessible. Shareable. Linkable.
  - This superpower is held by anybody with a web browser!
- When writing for the Internet, you are writing for two audience: Humans and Technology.
  - In order for technology (the web browser) to understand our documents, we must be explicit with the nature, properties, purpose, and relationships of the content within the data.
- Every part of the example document below is marked up with a tag describing its function, headings, paragraphs, emphasized and strongly emphasized texts, block quotes and citation, addresses, ordered and unordered lists, links, buttons, the list goes on.
  - For each of these elements, the browser generates a corresponding node and places it on the node tree of the document object model.
  - Once that tree is populated, a user can instruct the client to fetch any of these elements either through direct interaction or through code.

```html
<!-- HTML Content and Structure Example -->

<html lang="en-US">
  <head> </head>

  <body>
    <!-- This section is required for accessibility.
             Will automatically skip to the main content of the document. -->
    <a class="skip-link screen-reader-text" href="#content">Skip to content.</a>

    <header class="masthead clear"></header>

    <div id="showcase" class="promo-area"></div>

    <main id="content" class="main-area">
      <article class="post-content"></article>
    </main>

    <footer class="footer"></footer>
  </body>
</html>
```

- **Web Meta-data** is non-visual data added to a web document to provide further information about purpose and function.
  - This includes schema, micro-format, ARIA and other tools.
- Accessibility is one of the most important aspects of a web page document, and should take precedent over aesthetic and interactivity.
  - Regardless what tool a user uses, content should be accessible.
  - Always start with semantic, compliant HTML.
  - Run accessibility checks as you add more visual elements.
  - Audit and maintain the accessibility of your website over time.
- Test your websites in as many different versions of browsers and different browsers to make sure it works on all of them.
  - In addition to the desktop browser, there is the mobile browser, in-app browser, text-only browsers, text-to-speech browsers, console browsers, smart TV browsers, fridge browsers, et cetera.
- The browser of today will not display the Internet of tomorrow.
  - Accessibility, progressive features, and universal standards allow for the future-proofing of websites.
  - The utility of RESTful APIs allow information to be independent from the viewport which allows it to be easily viewed in a multitude of ways.
- The ability to have our websites work in older browsers should be utilized with CSS and JavaScript as one way to display it.
- At it's core, the web runs on three main programming and markup languages. HTML for content, CSS for style and JavaScript for interactivity.
- **Events** are actions or occurrences that happen in the system you are programming, which the system tells you about so you can respond to them in some way, if desired.
  - _Event Handling_ is detecting and responding to an event using JavaScript.
    - Identify a DOM node to monitor
    - Identify the event you want to respond to
    - Create a function to run when the event is triggered.
- To properly test a website in a browser, you need to run a local live server, and most IDEs have a simple `live-server` plug-in to do this.
  - _BrowserSync_ also allows cross-browser testing as well.
