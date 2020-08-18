# Gatsby Fundamentals

**Table of Contents:**
- [Gatsby Fundamentals](#gatsby-fundamentals)
  - [Introduction](#introduction)
  - [Purpose and History](#purpose-and-history)
  - [Setup](#setup)
    - [Prerequisites:](#prerequisites)
    - [Installation](#installation)
  - [Breaking down a Gatsby Site](#breaking-down-a-gatsby-site)
    - [Exploring Default Files](#exploring-default-files)
  - [Core Gatsby Principles](#core-gatsby-principles)

## Introduction

* The web constantly evolves and we have to evolve right along with it. 
    - Case in point, as we rely more and more on online services, performance, accessibility and advanced functionality become key concerns for web designers and developers. 
    - The challenge is to find the right tools for the job, the tools making it possible to spin up advanced modern websites built with advanced modern tools in the quickest way possible. 
* Enter Gatsby aka GatsbyJS, a modern framework for building performance accessible static sites using React and GraphQL. 
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
    - The [Node Package Manager](https://www.npmjs.com/)
* [Git](https://git-scm.com/) and [GitHub](https://github.com/)
* Finally, the (Gatsby CLI)[https://www.gatsbyjs.com/docs/gatsby-cli/]
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
* To explain further, all these files you got when you install the Gatsby starter are actually not the files that are served to the browser. 
    - Instead, these files configure the build process and provide the templates and components that will eventually make up the static site we serve to the browser. 
    - That means for us to see the Gatsby site in action, we need to run a build process and then also spin up a development server and connect it to the build process, so that we can see the output of Gatsby. 
    - All of this is done using a command called `gatsby develop`.
    - To run that command, you need to navigate into the current folder: `cd gatsby-folder-name`.
* `gatsby develop` is one of several scripts available inside the Gatsby CLI and Gatsby Developed does two things. 
    - It runs the build process to generate the static site then puts that static site in a new folder called public and then, it spins up a local Dev server and connects you to that public folder. 
    - That local Dev server is found at `localhost:8000/` and if you control or command click on this, it will open in your default browser.
    - If you run the command `gatsby develop -H 0.0.0.0`, what will happen is in addition to the local host being available on your computer, it will also make itself available on your local network and it will provide you an IP address to that local host.
        - This can be useful for testing your website on multiple operating systems, browsers, and screen sizes.
    - `gatsby clean` just cleans out anything that was generated by the build process. It deletes cache and public, but nothing else. 
        - So that means, if you just want to clean up what was generated and start over without making any changes to the actual project or the build process, you run Gatsby clean and you're back to square one.

## Breaking down a Gatsby Site

* Note: When using a repostiory for Gatsby's install that has multiple branches, there are a few more commands that are needed.
    - `git remote add upstream repo_url` will add the git files associated with the repository and sets it as an upstream source.
    - `git pull -all` which will then fetch everything (including branches) from the upstream.
    - To switch to different branches, use the command `git checkout branch_name`.

### Exploring Default Files

* Let's take a closer look at the pieces that make up a gatsby starter, and how everything is wired together.
* **`package.json`** is the core file for the entire build process. 
    - This is where the project itself is defined, with a name, a description, an author name, a license, and so on. 
    - And this is also where you see all the dependencies that are added to the project. 
    - As you move forward, and add more features to the project, you'll add more dependencies, and these dependencies will end up in this dependencies list over here. 
* Scrolling further down, this is also where you find the scripts you'll be using:

```json
"scripts": {
"build": "gatsby build",
"develop": "gatsby develop",
"format": "prettier --write \"**/*.{js,jsx,json,md}\"",
"start": "npm run develop",
"serve": "gatsby serve",
"clean": "gatsby clean",
"test": "echo \"Write tests! -> https://gatsby.dev/unit-testing\" && exit 1"
}
```

* For the most part, you don't touch package.json.
    - If you're setting up your own gatsby starter, or you want to set up this project to be fully personalized, you can go and change the name, and version number and author, and stuff like that by yourself.
    - All of the dependencies are automatically handled by the build process itself.
* Next, is **`gatsby-config.js`** This is a file you'll be working with quite a lot. 
    - This is a configuration for how gatsby operates. Right now, out of the box, the only thing that's here is the site meta, this is just an object full of information that you can use inside the site.
        - Eg. The site title, the site title template, the author, the description of the site, the URL to the site, a logo, etc.
    - This information gets packaged in different areas of the site, so that the site displays properly in different conditions.
* There are several other files in the root folder, including"
    -  **`gatsby-node.js`** which handles node.js APIs and will be discussed later.
    -  **`gatsby-browser.js`** which handles browser APIs, and **`gatsby-ssr.js`** which handles server-side rendering APIs.
    -  For each of these, you can find documentation on what they do, by following the links in the comments at the top of the file itself. 
* The majority of the work you do in gatsby, will be done in **`/src`**, or the source folder. 
    - This is where you define your pages, your components, your templates, and anything else that will tie together to build out the pages and different content to see on the front end.
    - The `/pages` subdirectory will contain React `.js` files that contain all of the pages and front-end of the website.
    - There's also a second folder called `/components`. And this is where all the components sit.
        - This can include things such as layouts, partials, scripts, etc.

## Core Gatsby Principles

* Gatsby projects have a more or less standard architecture. Some of this is defined by the application, some of it is defined by convention.
* The majority of your work will be done in three places. 
* The first one is the **`/src`** folder. 
    - This is where you define all the components, all the pages and all the templates that will go together to build the actual pages on the front end. 
    - It works like this: any file that goes in the pages folder under source becomes an actual page on the front end. 
    - So if you add a new file here called `about.js`, you get a new page on the front end called `about.js`. 
    - All the components you create to pull into pages or templates or use anywhere else, go under the components folder. 
* Now, inside the React community, there's a lot of debate about what is the best way of structuring components:
    - *Should they go in separate folders and then have a file called `index.js`under that folder? Or should they just sit as individual files under the folder?* 
    - All of that depends on how advanced your build is and what you're trying to do and how you yourself feel that there should be structured. 
    - But, components, that means small pieces that we'll put together with other pieces to make up larger pieces, should always go in the components folder just for structural integrity and to make things easy to find.
    - It's also a good idea to name your components very clearly so it's easy to understand which components do what when you're going and looking for specific functionality.
* **`/src/templates`** is another important folder where template pages will go, which are built specifically with Gatsby's functionality.
* There's a separate folder here that sits outside the source folder is called **`/static`**. 
    - Anything that sits in the static folder becomes available as a static asset on the front end. 
    - If you put an image file there, you can call that image file directly from the front end by just going to the domain name and the name of that file and it's directly available to us. 
* There's also a convention where if you create a external content, so let's say Markdown files that will turn into pages through a template, you place them in a **`/content`** folder that also sits on the root. 
    - It does not sit inside the source folder, it sits separately because it's not part of the source code, it is a data source. 