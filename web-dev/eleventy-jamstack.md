# Building Serverless Apps with JAMStack and Eleventy

> **NOTE:** In order to not have the display break when writing example code, all `{` brackets have been replaced with `[` brackets.

**Table of Contents:**

- [Building Serverless Apps with JAMStack and Eleventy](#building-serverless-apps-with-jamstack-and-eleventy)
  - [Getting Started](#getting-started)
    - [What IS the JAMStack?](#what-is-the-jamstack)
    - [What is Eleventy?](#what-is-eleventy)
    - [Eleventy Commands](#eleventy-commands)
    - [Building a Project](#building-a-project)
  - [Organizing a Serverless Website](#organizing-a-serverless-website)
    - [Creating Front Matter Data](#creating-front-matter-data)
    - [Building a Template Page](#building-a-template-page)
    - [Layout Chaining](#layout-chaining)
  - [Using Site Data](#using-site-data)
    - [Using a Data File](#using-a-data-file)
    - [Adding Directory Data](#adding-directory-data)
    - [Loading Content Dynamically via APIs](#loading-content-dynamically-via-apis)
    - [Using Alternative Data Formats](#using-alternative-data-formats)
    - [Building Pages from Data](#building-pages-from-data)
  - [Working with Content Features](#working-with-content-features)
    - [Short Codes](#short-codes)
    - [Permalinks](#permalinks)
    - [Filters](#filters)
  - [Managing Collections](#managing-collections)
    - [Understanding Collections](#understanding-collections)
    - [Building Collections using Tags](#building-collections-using-tags)
    - [Using Collection Modifiers](#using-collection-modifiers)
  - [Using Pagination and Plugins](#using-pagination-and-plugins)
  - [Conclusion](#conclusion)

<!-- Topics include:

- Creating your project
- Organizing the site with templates and layouts
- Adding directory data
- Loading data dynamically with APIs
- Building pages from data
- Managing collections
- Adding pagination and navigation -->

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

- Eleventy was created to be a JavaScript (node.js) alternative to Jekyll.
  - It’s zero-config by default but has flexible configuration options.
  - Eleventy works with your project’s existing directory structure.
- It's apparently basic in terms of functionality at its core.
- It's designed to simply be an engine that manages the conversion of templates to pages.
  - It's made like that on purpose, it doesn't assume that you're using a specific build process or even that you'll be using a build process at all.
  - Thus, it's made to be super flexible.

### Eleventy Commands

- One of the advantages of using something like Eleventy over other products is that it lets you use NodeJS and npm to manage your modules and projects.
- You can _try out_ Eleventy by using the `npx eleventy /folder` command, which runs the Eleventy format, without having to install anything on your platform globally.
- You can also install it _globally_ using `npm install -f @11ty/eleventy`, and the commands are going to be a little bit easier to run this way.
- You can also install it as a _project_ using `npm i @11ty/eleventy`.
- By default, running the Eleventy command will choose the current folder as the _input_ location, but you can change that with a special flag called input, like this `--input=`.
  - In order to not generate other markdown files in your repository, such as the README or LICENSE, use the `eleventy --input=_site --output` to only procress files in the site folder.
  - This will create a new `/build` subfolder, which will be added to the `.gitignore` file.
- The default _destination_ folder is `_site`. If you want to create a folder like a builds or a dist folder, you can use the output flag `--output=_site`.
- You can watch a specific folder for changes with the `--watch` option or use the `--serve` option to use something called _Browsersync_.
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
const yaml = require("js-yaml");

module.exports = function(eleventyConfig) {

    // Exposing the eleventyConfig variable to process assets:
    eleventyConfig.addPassthroughCopy("./_site/images");
    eleventyConfig.addPassthroughCopy("./_site/css");

    // Creates shortcut aliases for long layout path names:
    eleventyConfig.addLayoutAlias("base", "_pageTemplates/base.njk");
    eleventyConfig.addLayoutAlias("page", "_pageTemplates/page.njk");
    eleventyConfig.addLayoutAlias("page-hero", "_pageTemplates/page-hero.njk);

    // Using the YAML data format instead of JSON:
    eleventyConfig.addDataExtension('yaml' contents => yaml.safeLoad(contents));

    return {
      markdownTemplateEngine: 'njk',
      dir: {
        input: "_site",
        data: "_data",
        includes: "_includes",
        layouts: "_layouts",
        output: "dist"
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
    "start": "eleventy --serve --quiet"
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

```markdown
---
title: Testing YAML
date: 2020-01-03 # Could be "Created" or "Modified"
templateEngineOverride: md, njk
layout: page
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
tags:
  - home
  - welcome
  - info
---

**Date:** [[page.date.toUTCString()]]

**By:** [[pkg.author]]

**Tags:**

<ul>
  [% for item in tags %]
  <li>[[ item ]]</li>
  [% endfor %]
</ul>

Hello World, this post is called [[title]]! Lorem ipsum dolor sit amet, consectetur adipiscing elit. Morbi efficitur, mi non scelerisque lobortis, risus eros fermentum eros, et sagittis justo ex hendrerit tortor.
```

- The above unformation is exposed in a templating language, of which there are eleven different ones that you can use with Eleventy.
- **Liquid** is the default in Eleventy, but a lot of times you'll notice that the documentation will be written in **Nunjucks** which is what's used in this project. They are pretty similar.
- If you want to, you can override the default engine for the entire Website by using a markdown template engine variable in your Eleventy.js configuration file.
  - But you can also override the template for the specific page by using a template engine override variable in your markdown front matter.
  - For that, you would add `templateEngineOverride: md, njk` in the YAML.

### Building a Template Page

- Eleventy allows you to create a type of document called a layout and these are templates that you can wrap around pieces of content.
- The way that this works is by looking for an `_includes` folder by default, and any files that you put in there can be accessed through the front matter in your markdown documents.
  - You can also override the location of these files, so in your `eleventy.js` file you can modify the `dir.includes` object and specify that you want the templates to be somewhere else.
  - By default, is going to assume that all of these live inside whatever is the input folder for your project, which would be the `_site` folder.
- You can also separate _templates_ from _includes_, includes can have additional pieces of information in them, so you can create a separate folder for only templates.
  - This makes things a little bit cleaner and more organized.
- Templates themselves can have their own frontmatter variables.
  - You can use those inside the template itself, or also the content that is being wrapped by the template.
  - In order to use the content that is going to be wrapped by the template, you can use a special content variable `[[ content | safe ]]`.
    - And if you're using Nunjunks, you want to use the save filter like this, so it doesn't double process variables.
  - **Layout:** `path/mylayout.njk`
  - You can alias the template path with the following function: `eleventyConfig.addLayoutAlias("name", "path");`
- This means that you can easily create layouts, create aliases to layouts and create multiple page layouts by putting things inside my layouts folder.

**`_site/_layouts/pageTemplates/base.njk`:**

```html
---
siteTitle: JAMStack with Eleventy
---

<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8" />
    <meta
      name="viewport"
      content="width=device-width, initial-scale=1, shrink-to-fit=no"
    />
    <title>[[siteTitle]] -- [[Title]]</title>
    <script
      defer
      src="https://use.fontawesome.com/releases/v5.7.2/js/all.js"
      integrity="sha384-0pzryjIRos8mFBWMzSSZApWtPl/5++eIfzYmTgBBmXYdhvxPc+XcFEk+zJwDgWbP"
      crossorigin="anonymous"
    ></script>
    <link
      rel="stylesheet"
      href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"
      integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh"
      crossorigin="anonymous"
    />
    <link rel="stylesheet" href="/css/styles.css" />
  </head>
  <body class="bg-dark">
    <div class="container">
      <div class="bg-white">[[ content | safe ]]</div>
      [% include "social.njk" %]
    </div>
  </body>
  <script
    src="https://code.jquery.com/jquery-3.4.1.slim.min.js"
    integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n"
    crossorigin="anonymous"
  ></script>
  <script
    src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"
    integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo"
    crossorigin="anonymous"
  ></script>
  <script
    src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"
    integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6"
    crossorigin="anonymous"
  ></script>
</html>
```

### Layout Chaining

- Eleventy let's use templates in a way that's _recursive_ so that one template can be based on another.
  - This is a pretty powerful way to build templates.
- You have to be aware of something called the **data cascades.**
  - There are some instances when the variables in your template or layout will create a conflict with other variables.
  - How this gets resolved is known as the data cascade.
- Before Eleventy renders your page, the data is going to be merged from your content page,
  - Then, your layouts from the closest layout to the outermost layout.
- The way that this happens is that the layouts that are closest to the content will get processed with more importance than anything that is farther away from the original data.
  - So, your markdown files would have the most specificity in CSS terms.
- One template can be used for one purpose, and that template can be based on another template, and another template can be used for another purpose, etc. and still be based on the same template.
  - So, you generally have a base template with sort of just a basic HTML for every page and then you add different page layout templates for any of your other needs.
- Using the data cascade to your advantage:
  - If you're hard-coding a value that you would rather have different values for different pages, you can use the data cascade and create a variable `[[headerHeight]]` and add it to the tempalte.

**`_site/_layouts/pageTemplates/page-hero.njk`:**

```html
---
layout: base
headerHeight: 50vh
---

<!-- Used for pages that have a "hero" graphic: -->
<header
  class="site-header position-relative"
  style="min-height: [[headerHeight]];"
>
  <section
    class="layout-hero position-absolute d-flex align-items-center"
    style="background-image: linear-gradient(rgba(0, 0, 0, .7) 50px, transparent), 
  url([[hero]]); height: 100%; width: 100%;"
  ></section>
  <div
    class="layout-hero-content position-absolute d-flex align-items-center w-100 h-100"
  >
    <div class="container">
      <div class="row justify-content-center text-center">
        <div class="header-content col-11 col-sm-10 col-md-9 animated fadeInUp">
          <h2 class="page-section-title text-light">[[ title ]]</h2>
          <p class="page-section-text text-light d-none d-md-block">
            [[ summary | safe ]]
          </p>
        </div>
      </div>
    </div>
  </div>
</header>
<main class="container py-4">[[ content | safe ]]</main>
```

**`_site/_layouts/pageTemplates/page.njk`:**

```html
---
layout: base
---

<main class="container py-4">[[ content | safe ]]</main>
```

**`_site/about/index.md`:**

```markdown
---
title: About Me
layout: page-hero
headerHeight: 70vh
hero: https://brennanbrown.ca/img/header.jpg
summary: Content Strategist and Web Developer looking to improve lives with the JAMstack!
permalink: "/about-[[ pkg.author | slug ]]/"
---

# [[title]]

Hey there! My name is Brennan, I'm a 24-year-old Métis web developer and content strategist from Winnipeg, Manitoba and currently reside in Calgary, Alberta. I've recently compeleted a Full Stack Developer Program at [EvolveU](https://www.evolveu.ca/), and I'm looking to help those that need web development work done, or searching for ideas and management for their next content project.

I would also love to volunteer my time to contributing to open-source projects! I love creating and tinkering with small, static websites and projects. I'm a big proponent of putting an emphasis on accessibility and the [A11y project](https://www.a11yproject.com/) in web development.

I'm always looking to work with people that are hopeless idealists like me, as well as who are interested in creating and working on cool, interesting, and meaningful projects! Shoot me [an e-mail](mailto:mail@brennanbrown.ca) if that sounds like your cup of tea.
```

**`_site/css/styles.css`:**

```css
.layout-hero {
  background-position: center center;
  background-repeat: no-repeat;
  background-size: cover;
}
```

## Using Site Data

### Using a Data File

- You can make information available to your site by adding data in a few different ways:
  - You can add data in a couple different formats: You can use the `JSON` format or you can use the `module.exports` object in any JavaScript file.
  - And you can pass along variables which will then be available to your website.
- By default, any global data that you want to store for the entire site can be placed in a `_data` folder or `dir.data`.
  - That can also be overwritten by using the directory object in the `11T.js` document with a data variable.
- The folder structure of where you put that data _does_ matter.
  - For example: If you want to have a variable called `social.site`, you can just place the data in the `_data/social/` folder and then put a file named `site.json` in that folder.
  - If you just wanted to have a `social.json` file, you would just call this `_/data/social.json` and it would automatically add a variable called social to your website.
- The data can be available either to the entire website or you can place it anywhere in the file structure of your website.
  - For example: If you want the information to only be available to your posts, then you would put the data file in the `_site/posts` location.
  - Or you can put it anywhere else, and then anything in that folder will have access to that data.
- Another example: Create some navigation with social media links.

**`_site/_data/social.json`:**

```json
[
  {
    "name": "github",
    "iconClass": "fab fa-github",
    "url": "https://github.com/brennanbrown"
  },
  {
    "name": "linkedin",
    "iconClass": "fab fa-linkedin",
    "url": "https://linkedin.com/in/brennankbrown"
  },
  {
    "name": "twitter",
    "iconClass": "fab fa-twitter",
    "url": "https://twitter.com/brennankbrown"
  },
  {
    "name": "dribble",
    "iconClass": "fab fa-dribbble",
    "url": "https://dribbble.com/brennanbrown"
  },
  {
    "name": "flickr",
    "iconClass": "fab fa-flickr",
    "url": "https://www.flickr.com/photos/brennankbrown/sets/72157602932636630/"
  },
  {
    "name": "youtube",
    "iconClass": "fab fa-youtube",
    "url": "https://www.youtube.com/user/brennankbrown"
  },
  {
    "name": "instagram",
    "iconClass": "fab fa-instagram",
    "url": "https://www.instagram.com/iviewsource"
  }
]
```

- Generally, you create layouts for things like pages and then you use the **`_includes`** folder for simpler or smaller things.
  - These can be considered 'modular' containers of information that might be used on multiple pages, or just be separated to files smaller and more readable.

**`_site/_includes/social.njk`:**

```njk
<nav class="nav-social navbar navbar-expand navbar-dark justify-content-center">
  <div class="navbar-nav">
  [%- for item in social-%]
    <a class="nav-item nav-link" target="_blank" href="[[item.url]]">
      <i class="nav-social-icon [[item.iconClass]] mr-2"></i>
      <span class="align-text-bottom text-white d-none d-lg-inline">[[item.name]]</span>
    </a>
  [%- endfor -%]
  </div>
</nav>
```

### Adding Directory Data

- In addition to creating global data files, you can create files that apply to a specific directory.
  - For example: Let's say that you wanted to modify the layout of each of the files in the `_posts` directory to use the base template.
  - Create a new file in the `_post` directory, and the trick is you have to name it the same thing as the directory name, in this case `posts.JSON`.
  - And then in that JSON, you can add variables that every post will have.
  - That's pretty powerful because it means that we can pass a lot of information that will go into every one of these templates.
- Overall, it is much easier to create variables for your entire directory or actually bring in a file that applies only to information within that directory.

**`_posts/posts.json`:**

```json
{
  "layout": "page"
}
```

### Loading Content Dynamically via APIs

- In addition to creating data from a JSON file, you can use a regular JavaScript document to work with data.
- With JavaScript, the way that you export data is a little bit different.
  - You don't have to have this JSON format. You can get rid of these quotes if you want to.
- But it can be more powerful than that as you remember the, **JAMstack** has three letters, JavaScript, APIs, and Markup.
  - And so we can actually use an API from the web to import some data into our project.
  - It should be noted that you aren't using the regular version of Javascript with 11ty, but rather the node.js version of it.
- `npm install --save-dev node-fetch` will add the node-fetch module to our development enviorment for the project.
  - What this will do is add a item to your `package.JSON` file and you can see that under `devDependencies`, `node-fetch` has been installed.
  - This means you can now use the `fetch` command.

**`clients/clients.11tydata.js`:**

```js
module.exports = {
  clients: [
     {
      "id": "1",
      "name": "Audry Topsy",
      "title": "Owner",
      "company": "Topsy Turvy Cake Designs",
      "profile_photo": "30825.jpg",
      "friends": [
        {
          "id": "2",
          "name": "Dahlia Landon",
          "title": "CEO",
          "company": "Landon Hotel",
          "profile_photo": "15436.jpg"
        },
        {
          "id": "3",
          "name": "Dalania Devitto",
          "title": "Executive Director",
          "company": "OVCAA",
          "profile_photo": "33926.jpg"
        },
        {
          "id": "4",
          "name": "Dr. Elizabeth Chase",
          "title": "Owner",
          "company": "Wisdom Pet Medicine",
          "profile_photo": "15919.jpg"
        }
  ]
}
```

**Using `fetch`:**

```javascript
const fetch = require('node-fetch`);

module.exports = async function() {

  return fetch("http://trainingxyz.com/api/users/all")
    .then( res => res,json())
    .then(json => {
      return {
        clients: json
      }
    })
}
```

- The cool thing about this is that this is making a dynamic API call.
  - This means that if the API changes or if somebody uses some application to modify this API, every time we run this, it's going to keep it up-to-date.
  - Which means that we can also use things like the GitHub actions to actually generate a call for this every now and then so that this website can be automatically updated once a day or once a week or however often you want to do that.

### Using Alternative Data Formats

- Once you get working with Eleventy you'll get used to working with YAML front matter.
  - It's a real convenient way of writing information.
  - You might be wondering if there's a way of creating data in formats other than JSON or JavaScript.
  - Sure enough, you can extend the functionality of Eleventy by installing some modules.
- First, install the js-yaml module, `npm install --savedev js-yaml`.
  - Next, simply add it to the `.eleventy.js` configuration file.

**`_site/_data/courses.yaml`:**

```yaml
- thumbnail: "/images/courses/svelte_tn.jpg"
  url: https://www.linkedin.com/learning/svelte-first-look
  icon: <i class="fas fa-graduation-cap"></i>
  title: "Svelte: First Look"
  date: Dec 9, 2019
  summary:
    JavaScript frameworks and libraries keep growing, sprouting increasingly
    more dependencies along the way. Svelte—a new, lightweight component framework—marches
    into this tangle with a brush cutter, trimming down the weeds to provide a core
    set of key functionalities with zero dependencies.
  tags: frameworks,svelte,javascript

- thumbnail: "/images/courses/gulp_tn.jpg"
  url: https://www.linkedin.com/learning/gulp-js-web-project-workflows
  icon: <i class="fas fa-graduation-cap"></i>
  title: "Gulp.js: Web Project Workflows"
  date: Oct 31, 2019
  summary: "Gulp.js make setting up compression, minification, preprocessing, and other common tasks as easy as writing a setup file. In this course, learn how to use gulp.js to build workflows that make managing the process of building websites a bit easier."
  tags: javascript,web developer,tools,build tools, tooling, nodejs
```

**`_site/courses/index.md`:**

```markdown
---
title: Courses
layout: Page
---

# [[title]]

<div class="container mt-4">
  <div class="row row-cols-1 row-cols-md-2 row-cols-lg-3">
  [% for course in courses %]
  <div class="col mb-4">
    <div class="card h-100" >
      <img src="[[ course.thumbnail | safe ]]" alt="[[ course.title | safe ]] image" class="card-img-top">
      <div class="card-body">
        <h5 class="card-title my-0">[[ course.title | safe ]]</h5>
        <time class="item-date small d-block text-muted mb-2" datetime="[[ course.date | safe ]]">[[ course.date | safe ]]</time>
        <p class="card-text">[[ course.summary | safe ]]</p>
        <a href="[[ course.url | url ]]" class="btn btn-secondary stretched-link" target="_blank">Watch course</a>
      </div>
    </div>
  </div>
  [% endfor %]
  </div>
```

### Building Pages from Data

- With data in Eleventy, you can actually generate pages from data with the platform.
- To do this you're going to have to use another feature, **pagination**, you're going to see how it's really useful.
  - On any page, you can break up some content into different sections called _pages_.
- Add the pagination object to your page in the YAML front matter, and then specify a few things:
  - First of all, you have to specify what data we're using to paginate the elements, in this case, the clients that is coming from this `clients.11tydata.js` file, which is reading this data from an API.
  - Second, in addition to that, we have to add a size. Normally, this particular method will let you take a number of pages and divide them into sub-pages. (For example, if you had five clients you can take this content and divide it, so that every page has three clients.)
  - In this case though, we want each of the records to create an individual page, so set that to one, and then declare a variable for the individual item for each one of the pages:

**`_site/clients/generate.md`:**

```markdown
---
pagination:
  data: clients
  size: 1
  alias: client
permalink: "clients/[[client.name | slug]]/"
layout: page
---

<h1 class="mt-0">[[client.name]]</h1>
<p>[[client.title]], <span class="font-weight-bold text-secondary">[[client.company]]</span></p>

<img src="[[client.profile_photo]]" class="w-50 d-block mb-3" alt="[[client.name]]">

<h2 class="mb-0">Friends</h2>

<p class="mt-1"> 
[% for friend in client.friends %]
<a class="badge badge-secondary mr-2" href="/clients/[[ friend.name | slug ]]">[[friend.name]]</a>
[% endfor %]
</p>

<h2 class="mb-0">Posts</h2>

[% for post in client.posts %]

---

#### [[post.title]]

<time class="item-date small d-block text-muted mb-2"
  datetime="[[ course.date | safe ]]">[[post.date_created | safe]]</time>

<p>[[post.text]]</p>

[% endfor %]
```

## Working with Content Features

### Short Codes

- There's a small feature that you can use to create a series of processed micro templates called short codes.
  - To make one of these you create a `name` for the short code and then pass along one or two `parameters` in your template.
  - Then in the `.eleventy.js` file you use the `eleventyConfig.addShortcode` method to the config variable and then pass along the name of the short code and then a function with the parameters.
  - The nice thing about short codes is that it lets you use all the power of Node.js to make complex transformation to the data from your templates.
- In addition to that you, can create something called paired shortcodes.
  - These are slightly different: You create a start (`pairedName`) and ending tag name (`endPairedName`) in your templates and then you can place some sort of content within the shortcode.
  - Just like with the regular shortcode, you add a method to the config variable, `eleventyConfig.addPairedShortcode`.
  - Now this time you pass along the name of the element and then both the content and a variable as well as any parameters.
  - You can then return the content with the parameters transforming them with the full power of Node.js.

**Shortcode Example:**

```html
<p class="mt-1">[% for friend in client.frends%][% clientTag %][% endfor %]</p>
```

```javascript
/* 
  Here, you can write any JavaScript function you want. 
  And so you can use any sort of node module or any JS
  you want to control how this information is processed:
*/
eleventyConfig.addShortcode("clientTag", function (name) {
  return `<a class="badge badge-secondary mr-2" href="/clients/${name}">${name}</a>`;
});
```

**Paired Shortcode Example:**

```html
<p class="mt-1">
  [% for friend in client.friends%] [% pariedClient friend.name %]
  <i class="fas fa-heard text-danger mr-1"></i>
  [% endPairedClient %] [% endfor %]
</p>
```

```javascript
eleventyConfig.addPairedShortcode("pairedClient", function (data, name) {
  return `${data} <a class="badge badge-secondary" href="/clients/${name}">${name}</a>`;
});
```

### Permalinks

- Permalinks are a way to remount the output of your templates to a different location.
  - In other words, it's a way to modify the location of the documents that Eleventy is going to generate.
- To create a permalink, add the option to your front matter data, you can use either a path or the word false.
  - When you create a path, don't forget the trailing slash `/`, or at least put .html so that the page will render properly.
- Why would you use false?
  - It allows you to create content that doesn't show up but is still part of collections, and therefore the data for the website.
- You can use variables in your permalinks as well as filters, you should place quotes around your permalinks to make sure that some errors in formatting with special characters don't happen.
- It's very flexible and powerful, and you can make the names a lot more meaningful and keyword driven for SEO.

### Filters

- Filters allow you to modify content quickly inside template expressions.
  - We've already been using them quite a bit, but let's talk about what else you can do with them.
- The format for filters is pretty simple.
  - You have, in an expression, a `name` of some sort of variable and then you use a pipe symbol `|` and then the name of the `filter` that you want to use.
- There's a few built-in Eleventy filters. You've seen them before.
  - They are `url`, which converts some text into a URL-friendly format.
  - As well as `slug`, which transforms existing text into a format that is friendly to use in links.
- There are a number of Nunjucks-specific filters, so here are some examples:
  - First the `first` element in an array.
  - Second, `safe` eliminates some characters so they do not show up as links: For example, if you have some HTML in your text, when you use safe, it'll take the HTML tags out.
  - Third, `random` chooses a random element in the array.
  - You can take a look at some of the other filters available on [**this page**](https://mozilla.github.io/nunjucks/templating.html#builtin-filters). There are quite a few.
- You can also add your own filters with the `addFilter()` method in your configuration variable that's in the `.eleventy.js` file.
  - For example: You could write a `simpleDate` filter to made readable dates automatically.
  - You can use `npm install --save-dev luxon` to utilize the Luxon node.js plug-in for the date formatting.

```js
const { DateTime } = require("luxon");

// ...

eleventyConfig.addFilter("simpleDate", (dateObj) => {
  return DateTime.fromJSDate(dateObj, { zone: "utc" }).toFormat("LLL dd, yyyy");
});

eleventyConfig.addFilter("courseDate", (dateObj) => {
  return DateTime.fromFormat(dateObj, "LLL d, yyyy").toFormat("yyyy-LL-dd");
});
```

```markdown
# [[Title]]

**Date:** [[page.date | simpleDate]]
```

## Managing Collections

### Understanding Collections

- Eleventy lets you group some of the content you create by collections, and that makes it easier to refer to certain content by groups.
  - Collections is a pretty deep topic.
- The easiest way to create a collection is by using the keyword `tags: name` in your front matter.
  - When you add the tag keyword and then a name, Eleventy will create a collection with that name.
  - Tags are created in the front matter with YAML, and you can use any valid YAML notation like arrays or multi-line arrays.
    - Instead of writing a single tag, you can use an array notation `tages: [ tag1, tag2, tag3 ]` and then give it different keywords.
    - You can also put in a carriage return, and then add some dashes. (See above.)
- In your templates, you can refer to collections with the `collections.name` keyword.
  - There is a special `collections.all` collection, which will have all of your collections from all Eleventy-generated content.
  - You can exclude a page from a collection by using the keyword `eleventyExcludeFromCollections: true`.
- Once you get to the collection information, you usually do a for-loop to go through each of the items in the collection.
  - That allows you to have access to certain data.
  - The most common pieces of data are the `URL` that will allow you to get to the page of the item in the collection,
  - As well as the `date` of the item and any `data` that is in the front matter or inherited from templates.
- You can sort the data in a collection or a template by using templating filters.
  - In Nunjucks and Liquid, you can use the `| reverse` filter, which will give you the latest items first.
  - Although you can use the `reverse()` method when working in your Eleventy configuration, you don't want to use this in templates because this will mutate or change your array. And it will have ramifications in other places.
  - So, save the reverse method when you want to access a collection in JavaScript inside the `.eleventy.js` file.
- One of the nice things that you can do is to add or create a collection.
  - You give the collection a name and then execute some sort of callback that fills that collection.
  - `addCollection(name, callback)
  - In addition to generating collections with tags, you can manually generate collections with this method.
- Once you have the collection, you can go through all of the items by issuing the `getAll()` command.
  - This is going to get all of the content from a specific collection and then let you do something with it.
  - This is where you may want to use something like reverse if you wanted to reverse the order of the items.
- You can also do `getAllSorted()`, and it's going to execute the default sorted method.
  - And that would be collections by ascending date and then also by file name if the ascending dates happen to be the same.
- If you're using Nunjucks or Liquid, it's easier to reverse directly in the template.
- You can also filter the current content by a specific tag or tags just like you can in the template.
  - `getFilteredByTag()`, `getFilteredByTags()`
  - This gets items that are specifically tagged with a single tag or an array of tags.
- There's also a really useful `getFilteredByGlob` method.
  - This will allow you to look at a folder for files in a certain format and create a collection with any of those files.
- You can read more about working with collections on [**the website**](https://www.11ty.dev/docs/collections/), and there are a lot of examples of the different methods and the different ways of manipulating collections that we've talked about.

### Building Collections using Tags

- It's time to start adding collections using tags.
  - Make modifications to your posts by adding front matter data with some of the information that is in the content of the file:

```yaml
---
title: Horizontally Centered Navigation Menu with CSS
hero: /images/posts/horizontally.png
thumbnail: /images/posts/horizontally_tn.png
summary: "Getting a menu to center horizontally is surprisingly hard, especially when you're using CSS lists. In this tutorial, I'll show you how to change the display element to pretend you're centering a table, which is easy."
tags:
  - tutorials
  - css
  - UX design
---

```

- If you want a specific front-matter collection such as tags applied to every post, you can add it to the `posts.json` file for ease:

```json
{
  "layout": "page",
  "tags": "post
}
```

**`_site/index.md`:**

```html
<div class="row">
  <div class="main-content col-lg-9">
    <header class="mb-4">
      <h4 class="text-secondary mt-2 mb-0">Latest Posts</h4>
      <div class="small">
        &raquo; <a class="text-secondary" href="/posts">more posts</a>
      </div>
    </header>
    <div class="row">
      <div class="col">
        <article class="mb-5 position-relative">
          <div class="row">
            <div class="col-12 col-sm-4">
              <img
                class="w-100 rounded"
                src="{{item.data.thumbnail}}"
                alt="{{item.title}}"
              />
              <time
                class="item-date small d-block text-muted mb-2"
                datetime="{{item.date }}"
                >{{item.date | simpleDate}}</time
              >
            </div>
            <div class="col">
              <h4>{{item.data.title}}</h4>
              <p class="mb-0">{{item.data.summary}}</p>
            </div>
          </div>
          <div class="text-right">
            <a
              href="{{ item.url | url }}"
              class="btn btn-sm btn-outline-secondary stretched-link"
              >read more</a
            >
          </div>
        </article>
      </div>
    </div>
  </div>
</div>
```

### Using Collection Modifiers

## Using Pagination and Plugins

## Conclusion

- There's a lot more to Eleventy, and of course the best place to find out more information is on the [Eleventy website](https://www.11ty.dev/).
  - There's a **[docs section](https://www.11ty.dev/docs/)** with a full list of all the different features.
- And if you want to, you can also take a look at **[Nunjucks](https://mozilla.github.io/nunjucks/)]** as well.
  - Nunjucks does quite a few things that will help you get better at working with Eleventy.
- There's also the template called **[Seven](https://github.com/planetoftheweb/seven)** by Ray Villalobos. You can click on the GitHub repo and fork or download a copy of this project.
  - This is a lot more complicated that what we've done here but it does include things like webpack, SASS, and a lot of other features.
