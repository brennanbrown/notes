# Success as a Web Developer

* Read and write proper documentation for the projects and languages you're working on.
* Examine the code of other developers' and explore new ideas.
* Make mistakes--often. It strengthens your ability to be a developer by challenging you to find, test, and anticipate errors.

## Overview of the Internet

* Information Structure: How to best organize a website for the user.
* HTML and Document Object Model --> Accessing Elements with CSS and JS
* CSS for design/user experience, interactivity
    - Setting rules for the webpage.
    - [CSS Zen Garden](https://csszengarden.com)
    - There are several different ways to organize your CSS, including OOCSS (Object-oriented), SMACSS (Scalable and Modular Architecture), BEM (Block, Element, Modifier.)
* Design has to be responsive (web, mobile, tablet, etc.)
* JavaScript manages interaction within a browser.
    - Interacts the DOM to handle events.
    - A transpilier is often needed to have cross-browser compatibility.
* The protocol HTTP(S) for connection.
    - `GET` : Asks to receive information
    - `POST` : Sends information
    - `DELETE` : Deletes information
    - HTTP/2 has multiplexing.

## Elements of Web Development

* *TCP*/*IP* (Transmission Control Protocol/ Internet Protocol) is responsible for largely how the Internet functions today.
    - Breaks information down into packets (TCP) and get past into the best available paths at the moment.
    - IP is the address that the packets get sent too.
    - A DNS (Domain Name Server) converts URLs into these IP locations.
    - The URL (Uniform Resource Identifier/Locater) is the entire name of a website that is an easily-readable address that the user types in.
* Orient your projects to be *accessible*. Making something easier for a certain group of users makes things easier for every user. 
    - Use ARIA to help write your HTML in accessible ways.
    - Use Google's Lighthouse tool to get an overview of your entire site.
* The methodology called *Mobile-First* teaches that you should always seek to simplify what is being displayed, especially on smaller devices. 
* Beyond the three primary languages of web design (HTML, CSS, and JS), there are a multitude of languages built on top of these that have marked improvements.
    - Eg. *SASS* is a language that allows logic to be transpiled to CSS 
* JavaScript was originally designed to be functional, not object-oriented, but has evolved to be a hybrid of both.
* *MVC* (Model-View-Controller) is a popular design concept for treating the data or model as a separate entity, then creating a template which is called the view which uses that data, and finally writing code called the controller that combines the model and the view.
* Another way of organizing code is a *component-based architecture*.
    - This means separating functionality into self-contained pieces, so flexible and reusable parts can be shared between applications 
* Built tests for your applications to constantly check for problems in all parts of your development process.

### Version Control

* *Agile* is the philosophy of regrouping regularly to be sure your software can rapidly adjust in order to meet the customer's needs.
* *DevOps* is the combination of software development and IT operations, with the goal being to shorten the time between writing the code and deployment.
* In addition to continuous delivery, up-to-date and well written *documentation* is vital to allow others (and you in the future) to understand and build upon your existing work.
* *Git* allows people to work on their own versions of a project and then merge these different versions later.

### Server Technologies

* Most servers have transitioned from physical devices of hardware to cloud-based virtual machines that are usually run by large companies such as Microsoft Azure, Amazon Web Services, or Google Cloud Platform.
* These cloud-based virtual machines are considered elastic in nature, meaning their specifications can grow based on how much demand your application or website needs from them.
* You can place data closer to your users by using a *CDN* (Content delivery network) which creates copies of a server's information on physically closer machines.

* *SQL* (structured query language) is often used as back-end language for storing and organizing data that will be retrieved by the front-end.
* *NoSQL* are languages that do not implement the traditional and rigid structure that SQL languages have, and can be faster due to the lack of overhead.

## Tools and Frameworks

* *IDE* (integrated development environment) is a program that helps you write, debug, and document code as well as compile and run it. 
* *Webpack*  is an open-source JavaScript module bundler. It is a module bundler primarily for JavaScript, but it can transform front-end assets as well.
* *Babel* is a free and open-source JavaScript transcompiler that is mainly used to convert ECMAScript 2015+ code into a backwards compatible version of JavaScript that can be run by older JavaScript engines. 
* There are many HTML/CSS frameworks, with *Bootstrap* being the most popular and oldest, with other popular ones including Material Design, Foundation.


### JavaScript Frameworks

* *D3.js* is a JavaScript library for producing dynamic, interactive data visualizations in web browsers. It makes use of the widely implemented Scalable Vector Graphics, HTML5, and Cascading Style Sheets standards
* *jQuery* is a JavaScript library designed to simplify HTML DOM tree traversal and manipulation, as well as event handling, CSS animation, and Ajax.
* *Angular* is a TypeScript-based open-source web application framework led by the Angular Team at Google and by a community of individuals and corporations. 
* *React* is a JavaScript library for building user interfaces. It is maintained by Facebook and a community of individual developers and companies.
* *Vue.js* is an open-source Model–view–controller JavaScript framework for building user interfaces and single-page applications.

## Application Connections

* A programmer often doesn't build an entire program, but rather a *service* that is utilized by another program in order to simplify the sharing of data.
* An application programming interface is an interface or communication protocol between different parts of a computer program intended to simplify the implementation and maintenance of software. 
    - An *API* may be for a web-based system, operating system, database system, computer hardware, or software library.
* Representational state transfer is a software architectural style that defines a set of constraints to be used for creating Web services. 
    - Web services that conform to the *REST* architectural style, called *RESTful* Web services, provide interoperability between computer systems on the Internet.
    - These requests use the HTML language of GET and POST, and are usually returned in the JSON format.
* There are services such as *OAuth* which validate applications in order to make sure they are secure by acting as an intermediary between the service and the program.
