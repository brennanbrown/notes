# Building Serverless Apps with JAMStack and Eleventy

**Table of Contents: 

- [Building Serverless Apps with JAMStack and Eleventy](#building-serverless-apps-with-jamstack-and-eleventy)
  - [Getting Started](#getting-started)
    - [What IS the JAMStack?](#what-is-the-jamstack)
    - [What is Eleventy?](#what-is-eleventy)
    - [Eleventy Commands](#eleventy-commands)
    - [Building a Project](#building-a-project)
  - [Organizing a Serverless Website](#organizing-a-serverless-website)
    - [Creating Front Matter Data](#creating-front-matter-data)
  - [Using Site Data](#using-site-data)
  - [Working with Content Features](#working-with-content-features)
  - [Managing Collections](#managing-collections)
  - [Using Pagination and Plugins](#using-pagination-and-plugins)
  - [Conclusion](#conclusion)

Topics include:

- Creating your project
- Organizing the site with templates and layouts
- Adding directory data
- Loading data dynamically with APIs
- Building pages from data
- Managing collections
- Adding pagination and navigation


## Getting Started

### What IS the JAMStack?

- Before we get too far, let's make sure we clarify what the JAMStack is and why Eleventy is a good way to go serverless. 
  - The JAM in JAMStack refers to three technologies that are used when working with this process. 
- First, the **J** in JAMStack is for **JavaScript** is used to process files and create the site itself. Now this is managed using Node.js and is the main engine for creating your sites or apps. 
- The **A** in JAMStack is for **APIs**. 
  - This is an acronym for application programmer interface and it provides a way for an application created with the JAMStack to communicate with external tools to create dynamic experiences when needed. 
  - Although most of the site is pre-rendered, APIs allow you to have some dynamic features. 
- The final piece or the **M** in the JAMStack is **markup** which means that your site is generated from a series of templates and documents that will get processed into a site. 
  - You use a combination of markup written in traditional languages like HTML and CSS as well as template languages like Liquid and other languages like Markdown and YAML for the content. 
- The JAMStack belongs to a family of technologies called serverless.
  - Serverless sites are hosted and deployed on servers just like any other site but it's how those servers handle requests that is different. 
  - Serverless sites are, for the most part, pre-rendered which means that instead of querying a database to create a custom experience every time, all of the HTML pages on the site are pre-rendered before it gets sent to a server. 
  - Serverless sites often use CDNs, which are content delivery networks. This means that copies of the site are placed strategically throughout the world to make sure that the content from the sites are cached or stored closer to a user's machine. 
- How is this all an advantage? 
  - First, serverless sites are super fast. Normal sites run databases and you have to query them every time you request a page to build custom content for your user. 
  - A serverless or JAMStack site **pre-renders** the entire website or application, so there's much less overhead when requesting a page and because there is no database and most of the site is pre-rendered, there aren't any database vulnerabilities to worry about. 
  - Because most of the site is pre-rendered and there is no database overhead, the server that hosts the site doesn't require a ton of power or throughput so costs are generally lower than on regular websites. 
- In this specific example project, we'll be using an engine call **Eleventy**. 
  - Eleventy uses Node.js to process templates which means that it's fast and that you can use Node.js modules or JavaScript features in your typical build process. 
  - Node.js has thousands of modules that you can use with your website or application. One of the advantages of Eleventy is that is uses a flexible templating system. 
  - Eleventy will process templates in not just one but more than 10 different languages, including Liquid, POG, EJS, Mustache, and JavaScript Template Literals. It's very flexible in that way. 
  - It's also easy to either generate data from your content or read data from a JSON file through an API to help you generate some content. 
- There are a lot of other options that you can use to generate a serverless or a JAMStack site like Jekyll and others, but I really love Eleventy because it's easier for people who are familiar with Node build projects. 

### What is Eleventy?

- Eleventy was created to be a JavaScript alternative to Jekyll. 
  - It’s zero-config by default but has flexible configuration options. 
  - Eleventy works with your project’s existing directory structure.
- It's apparently basic in terms of functionality at its core. 
- It's designed to simply be an engine that manages the conversion of templates to pages. 
  - It's made like that on purpose, it doesn't assume that you're using a specific build process or even that you'll be using a build process at all. Thus, it's made to be super flexible.

### Eleventy Commands

- One of the advantages of using something like Eleventy over other products is that it lets you use NodeJS and npm to manage your modules and projects. 
- You can *try out* Eleventy by using the `npx eleventy /folder` command, which runs the Eleventy format, without having to install anything on your platform globally. 
- You can also install it *globally* using `npm install -f @11ty/eleventy`, and the commands are going to be a little bit easier to run this way.
- You can also install it as a *project* using `npm i @11ty/eleventy`.
- By default, running the Eleventy command will choose the current folder as the *input* location, but you can change that with a special flag called input, like this `--input=`. 
  - In order to not generate other markdown files in your repository, such as the README or LICENSE, use the `eleventy --input=_site --output` to only procress files in the site folder.
  - This will create a new `/build` subfolder, which will be added to the `.gitignore` file.
- The default *destination* folder is `_site`. If you want to create a folder like a builds or a dist folder, you can use the output flag `--output=_site`. 
- You can watch a specific folder for changes with the `--watch` option or use the `--serve` option to use something called *Browsersync*. 
  - Adding the `--watch` command will auto-update the build of the website anytime a file is modified, deleted, or creatd.
  - This will allow you to monitor changes and also run a live preview server so that you can see changes in your browser after you make them in the files. 
- In whole, using the command **`eleventy --input=_site --output=build --serve`** will run your project in an easily manageable fashion.
- You can also run the `--help` flag, and you'll get a list of all the current commands.
- You can also check out the Eleventy website and look for the docs section, and then go to the command line usage section right here to find out some of the other commands.

### Building a Project

- Working with a web project can get really complicated, so it's usually better to create a project and Node.js is going to make that easier. 
- The easiest way to create a project is by setting up a package.json file, and you can do that the quickest by issuing an `npm init -y command`.
  - This is going to create a `package.json` with the defaults, which will need to be modified.
- A `start` script is also needed, which will automatically run the command to build the site that was discussed in the above commands.
- You can also add a `.eleventy.js` configuration file, which will make it easier to run the project, as well as customize the configuration. 

**`.eleventy.js:`**

```js
module.exports = function(eleventyConfig) {

    // Exposing the eleventyConfig variable to process imgs:
    eleventyConfig.addPassthroughCopy("./site/images");

    return { 
        dir: {
        input: "_site",
        output: "dist",
        }
    }
}
```

- You can save the input and output folders by using the above file for Eleventy, which can be then pushed into the `package.json` file:

**`package.json`:**

```json
{ 
    "name": "jamstack",
    "version": "1.0.0",
    "scripts": {
        "start": "eleventy --serve"
    }
}
```

- Having the above will allow you to simply run the `npm start` command and have the site build automatically.

## Organizing a Serverless Website

### Creating Front Matter Data 

- One of the highlights of Eleventy is that it allows you to create variables that you can use in your markdown documents or in other templates. 
  - Meaning you can add something called front matter data into markdown files. 
- YAML, for instance, using three dashes to separate front matter data from the rest of the file, as seen in the example below.
  - In addition to using anything that you've created and the front matter, you can also get information about the current page, and also any information in your package .JSON file with the two special variables `page` and `pkg`.

```yaml

---
title: Testing YAML
object_examples:
    key: value
    array:
        - null_value:
        - boolean: true
        - integer: 1
paragraph: >
    Blank lines denote

    paragraph breaks like this!
content: |-
    Or you can
    auto-convert line
    breaks to save space!
---

Hello World, this post is called {{ title }}! Lorem ipsum dolor sit amet, consectetur adipiscing elit. Morbi efficitur, mi non scelerisque lobortis, risus eros fermentum eros, et sagittis justo ex hendrerit tortor.

```

- The above unformation is exposed in a templating language, of which there are eleven different ones that you can use with Eleventy.
- **Liquid** is the default in Eleventy, but a lot of times you'll notice that the documentation will be written in **Nunjucks** which is what's used in this project. They are pretty similar.

## Using Site Data

## Working with Content Features

## Managing Collections

## Using Pagination and Plugins

## Conclusion