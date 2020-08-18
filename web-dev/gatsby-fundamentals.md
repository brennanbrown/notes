# Gatsby Fundamentals

**Table of Contents:**
- [Gatsby Fundamentals](#gatsby-fundamentals)
  - [Introduction](#introduction)
  - [Purpose and History](#purpose-and-history)
  - [Setup](#setup)
    - [Prerequisites:](#prerequisites)
    - [Installation](#installation)

## Introduction

* The web constantly evolves and we have to evolve right along with it. 
    - Case in point, as we rely more and more on online services, performance, accessibility and advanced functionality become key concerns for web designers and developers. 
    - The challenge is to find the right tools for the job, the tools making it possible to spin up advanced modern websites built with advanced modern tools in the quickest way possible. 
* Into a Gatsby aka GatsbyJS, a modern framework for building performance accessible static sites using React and GraphQL. 
    - Gatsby serves as that all important intermediary layer between building a pure react application and building a good old fashioned website. 
    - It takes the best of CMS templates, object orientation and web standards, adds on a solid sprinkling of modern tooling and automation and enables you to build blazing fast, accessible and advanced static websites that are maintainable, upgradable and forward-looking. 
    - Gatsby and static site generators are very much the future of the web.

**What you should know:**

* A solid understanding of the basics, HTML, CSS, and modern JavaScript. 
* Some familiarity working with the command line, Node.js and npm. 
* Gatsby is built on top of React, so some basic familiarity with React and GraphQL will be helpful, but it's not required. 
* Having a good handle on modern JavaScript, including JS modules will be a huge help. 

## Purpose and History

* **Gatsby**, also known as GatsbyJS, is a static site framework and static site generator based on React. 
    - You write HTML, CSS, and React, Gatsby takes all that code, pours on a solid helping of well crafted magic, and out comes a reliable, accessible, and lightning fast website, to be hosted anywhere on the Web. 
* To understand what Gatsby is and why it's called a static site generator, we need a bit of Web history and a good comparison. 
    - Back in the early days of the Web, around 20 years ago, companies like Microsoft and Macromedia realized people needed tooling to build websites. 
    - The problem developers came up against was, if they had a site with 10 or 20 or 100 pages and they needed to update the main menu of that site, they had to update *all* 10 or 20 or 100 pages, which was really tedious and error prone. 
* One of the solutions to this problem was to create what became known as **DWTs**, or Dynamic Web Templates. 
    - You create a template containing the common elements, like the main menu and the header and the footer, and then you define editable areas, then you use that template to create new pages, edit only the editable areas, the template takes care of the rest. 
    - And then you run a little process, and out comes the static HTML pages. 
    - Change the template, and all pages made from that template also changes. 
* Jump forward about 10 more years, and the Web had evolved well beyond DWTs to what we now know as **CMSs**, or Content Management Systems. 
    - CMSs, like Drupal and WordPress, took a new and revolutionary approach to the problem of managing 10 or 100 or 1,000 pages on a site. 
    - Rather than using DWTs and auto-generating static pages, they introduced a PHP-based templating system that generated pages on the fly when the user requested them by pulling data from a database and placing that data inside templates. 
    - Jump forward another 10 years to just about today, and CMSs dominate the web. 
    - But there's a problem. When a site is popular, getting thousands or 10s of thousands or 100s of thousand visits a day, constantly generating pages on the fly produces an enormous amount of server overhead.
    - So developers have started caching their pages, effectively storing static versions of the pages off and on CDMs, and then serving them instead of the generated pages and only regenerating the static pages when things change. 
* Gatsby, and other static-site-generating solutions like it, are the culmination of this 20-year journey around the circle. 
    - Gatsby uses templates, this time based on React, and an advanced build process to generate static pages to be served up to the user. 
    - In essence, the same thing that was done 20 years ago, just with modern tools. 
* There's one more significant difference though: Gatsby allows you to pull content from any data source, mix and collate that data in any way you like, and create advanced dynamic templates to generate those static pages, what the Gatsby team calls a **"content mesh"**. 
    - With Gatsby, everything old is new again, and what's new will shape the future of the Web. 

## Setup

### Prerequisites:

* A source-code editor, such as [Visual Studio Code](https://code.visualstudio.com/)
    - The [ESLint](https://eslint.org/) and [Prettier](https://prettier.io/) extensions for clean code and proper formatting.
* [Node.js](https://nodejs.org/en/) JavaScript Runtime
    -[Node Package Manager](https://www.npmjs.com/)
* [Git](https://git-scm.com/) and [GitHub](https://github.com/)
* Finally, the [Gatsby CLI][https://www.gatsbyjs.com/docs/gatsby-cli/]
    - To install: `npm install -g gatsby-cli`

For a full breakdown of how to setup your development environment for Gatsby, check out [the official documentation](https://www.gatsbyjs.com/tutorial/part-zero/) on the Gatsby website which includes detailed instructions for macOS, Windows and various flavors of Linux. 

### Installation

* One of the core ideas of Gatsby is you don't start from scratch, instead you start from what's known as a [**Gatsby Starter**](https://www.gatsbyjs.com/starters/)
    - This is a pre-configured package of a Gatsby setup that has either a very basic site or a fully built-out site that you can configure to fit your needs.
    - You'll find starters for pretty much all content management systems, online e-commerce solutions, and everything else.
* To start off with the smallest amount of code possible, use the [Gatsby Starter Default](https://www.gatsbyjs.com/starters/gatsbyjs/gatsby-starter-default/).
    - To install: `gatsby new gatsby-folder-name https://github.com/gatsbyjs/gatsby-starter-default`
    - The last variable points to a GitHub repository. That means you can pull a starter from anywhere on GitHub, and that means you can also create your own starters and pull them down to get everything installed.
* Once the site has been installed, you can begin developing and running the server:
    - `cd gatsby-folder-name`
    - `gatsby develop`