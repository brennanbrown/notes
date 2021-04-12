---
layout: default
title: Gatsby Fundamentals
parent: Web Development
---

**Table of Contents:**

- [Introduction](#introduction)
- [Purpose and History](#purpose-and-history)
- [Setup](#setup)
  - [Prerequisites](#prerequisites)
  - [Installation](#installation)
- [Breaking down a Gatsby Site](#breaking-down-a-gatsby-site)
  - [Exploring Default Files](#exploring-default-files)
- [Architecture in Gatsby](#architecture-in-gatsby)
- [Pages, Components, and Styles](#pages-components-and-styles)
  - [Static Pages](#static-pages)
  - [Static Assets](#static-assets)
  - [Components](#components)
  - [Layout Component](#layout-component)
  - [CSS in Gatsby](#css-in-gatsby)
- [Plugins and Transformations](#plugins-and-transformations)
  - [Plugin Options](#plugin-options)
  - [Transformation Plugins](#transformation-plugins)
- [Data and GraphQL](#data-and-graphql)
  - [Queries in GraphQL](#queries-in-graphql)
- [Appendix](#appendix)
  - [Navigation Component](#navigation-component)
  - [Adding Multiple Images](#adding-multiple-images)

## Introduction

- The web constantly evolves and we have to evolve right along with it.
  - Case in point, as we rely more and more on online services, performance, accessibility and advanced functionality become key concerns for web designers and developers.
  - The challenge is to find the right tools for the job, the tools making it possible to spin up advanced modern websites built with advanced modern tools in the quickest way possible.
- Enter Gatsby aka GatsbyJS, a modern framework for building performance accessible static sites using React and GraphQL.
  - Gatsby serves as that all important intermediary layer between building a pure react application and building a good old fashioned website.
  - It takes the best of CMS templates, object orientation and web standards, adds on a solid sprinkling of modern tooling and automation and enables you to build blazing fast, accessible and advanced static websites that are maintainable, upgradable and forward-looking.
  - Gatsby and static site generators are very much the future of the web.

**What you should know:**

- A solid understanding of the basics, HTML, CSS, and modern JavaScript.
- Some familiarity working with the command line, Node.js and npm.
- Gatsby is built on top of React, so some basic familiarity with React and GraphQL will be helpful, but it's not required.
- Having a good handle on modern JavaScript, including JS modules will be a huge help.

## Purpose and History

- **Gatsby**, also known as GatsbyJS, is a static site framework and static site generator based on React.
  - You write HTML, CSS, and React, Gatsby takes all that code, pours on a solid helping of well crafted magic, and out comes a reliable, accessible, and lightning fast website, to be hosted anywhere on the Web.
- To understand what Gatsby is and why it's called a static site generator, we need a bit of Web history and a good comparison.
  - Back in the early days of the Web, around 20 years ago, companies like Microsoft and Macromedia realized people needed tooling to build websites.
  - The problem developers came up against was, if they had a site with 10 or 20 or 100 pages and they needed to update the main menu of that site, they had to update _all_ 10 or 20 or 100 pages, which was really tedious and error prone.
- One of the solutions to this problem was to create what became known as **DWTs**, or Dynamic Web Templates.
  - You create a template containing the common elements, like the main menu and the header and the footer, and then you define editable areas, then you use that template to create new pages, edit only the editable areas, the template takes care of the rest.
  - And then you run a little process, and out comes the static HTML pages.
  - Change the template, and all pages made from that template also changes.
- Jump forward about 10 more years, and the Web had evolved well beyond DWTs to what we now know as **CMSs**, or Content Management Systems.
  - CMSs, like Drupal and WordPress, took a new and revolutionary approach to the problem of managing 10 or 100 or 1,000 pages on a site.
  - Rather than using DWTs and auto-generating static pages, they introduced a PHP-based templating system that generated pages on the fly when the user requested them by pulling data from a database and placing that data inside templates.
  - Jump forward another 10 years to just about today, and CMSs dominate the web.
  - But there's a problem. When a site is popular, getting thousands or 10s of thousands or 100s of thousand visits a day, constantly generating pages on the fly produces an enormous amount of server overhead.
  - So developers have started caching their pages, effectively storing static versions of the pages off and on CDMs, and then serving them instead of the generated pages and only regenerating the static pages when things change.
- Gatsby, and other static-site-generating solutions like it, are the culmination of this 20-year journey around the circle.
  - Gatsby uses templates, this time based on React, and an advanced build process to generate static pages to be served up to the user.
  - In essence, the same thing that was done 20 years ago, just with modern tools.
- There's one more significant difference though: Gatsby allows you to pull content from any data source, mix and collate that data in any way you like, and create advanced dynamic templates to generate those static pages, what the Gatsby team calls a **"content mesh"**.
  - With Gatsby, everything old is new again, and what's new will shape the future of the Web.

## Setup

### Prerequisites

- A source-code editor, such as [Visual Studio Code](https://code.visualstudio.com/)
  - The [ESLint](https://eslint.org/) and [Prettier](https://prettier.io/) extensions for clean code and proper formatting.
- [Node.js](https://nodejs.org/en/) JavaScript Runtime
  - The [Node Package Manager](https://www.npmjs.com/)
- [Git](https://git-scm.com/) and [GitHub](https://github.com/)
- Finally, the [Gatsby CLI](https://www.gatsbyjs.com/docs/gatsby-cli/)
  - To install: `npm install -g gatsby-cli`

For a full breakdown of how to setup your development environment for Gatsby, check out [the official documentation](https://www.gatsbyjs.com/tutorial/part-zero/) on the Gatsby website which includes detailed instructions for macOS, Windows and various flavors of Linux.

### Installation

- One of the core ideas of Gatsby is you don't start from scratch, instead you start from what's known as a [**Gatsby Starter**](https://www.gatsbyjs.com/starters/)
  - This is a pre-configured package of a Gatsby setup that has either a very basic site or a fully built-out site that you can configure to fit your needs.
  - You'll find starters for pretty much all content management systems, online e-commerce solutions, and everything else.
- To start off with the smallest amount of code possible, use the [Gatsby Starter Default](https://www.gatsbyjs.com/starters/gatsbyjs/gatsby-starter-default/).
  - **To install**: `gatsby new gatsby-folder-name https://github.com/gatsbyjs/gatsby-starter-default`
  - The last variable points to a GitHub repository. That means you can pull a starter from anywhere on GitHub, and that means you can also create your own starters and pull them down to get everything installed.
- Once the site has been installed, you can begin developing and running the server:
  - `cd gatsby-folder-name`
  - `gatsby develop`
- To explain further, all these files you got when you install the Gatsby starter are actually not the files that are served to the browser.
  - Instead, these files configure the build process and provide the templates and components that will eventually make up the static site we serve to the browser.
  - That means for us to see the Gatsby site in action, we need to run a build process and then also spin up a development server and connect it to the build process, so that we can see the output of Gatsby.
  - All of this is done using a command called `gatsby develop`.
  - To run that command, you need to navigate into the current folder: `cd gatsby-folder-name`.
- `gatsby develop` is one of several scripts available inside the Gatsby CLI and Gatsby Developed does two things.
  - It runs the build process to generate the static site then puts that static site in a new folder called public and then, it spins up a local Dev server and connects you to that public folder.
  - That local Dev server is found at `localhost:8000/` and if you control or command click on this, it will open in your default browser.
  - If you run the command `gatsby develop -H 0.0.0.0`, what will happen is in addition to the local host being available on your computer, it will also make itself available on your local network and it will provide you an IP address to that local host.
    - This can be useful for testing your website on multiple operating systems, browsers, and screen sizes.
  - `gatsby clean` just cleans out anything that was generated by the build process. It deletes cache and public, but nothing else.
    - So that means, if you just want to clean up what was generated and start over without making any changes to the actual project or the build process, you run Gatsby clean and you're back to square one.

## Breaking down a Gatsby Site

- Note: When using a repostiory for Gatsby's install that has multiple branches, there are a few more commands that are needed.
  - `git remote add upstream repo_url` will add the git files associated with the repository and sets it as an upstream source.
  - `git pull -all` which will then fetch everything (including branches) from the upstream.
  - To switch to different branches, use the command `git checkout branch_name`.

### Exploring Default Files

- Let's take a closer look at the pieces that make up a gatsby starter, and how everything is wired together.
- **`package.json`** is the core file for the entire build process.
  - This is where the project itself is defined, with a name, a description, an author name, a license, and so on.
  - And this is also where you see all the dependencies that are added to the project.
  - As you move forward, and add more features to the project, you'll add more dependencies, and these dependencies will end up in this dependencies list over here.
- Scrolling further down, this is also where you find the scripts you'll be using:

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

- For the most part, you don't touch package.json.
  - If you're setting up your own gatsby starter, or you want to set up this project to be fully personalized, you can go and change the name, and version number and author, and stuff like that by yourself.
  - All of the dependencies are automatically handled by the build process itself.
- Next, is **`gatsby-config.js`** This is a file you'll be working with quite a lot.
  - This is a configuration for how gatsby operates. Right now, out of the box, the only thing that's here is the site meta, this is just an object full of information that you can use inside the site.
    - Eg. The site title, the site title template, the author, the description of the site, the URL to the site, a logo, etc.
  - This information gets packaged in different areas of the site, so that the site displays properly in different conditions.
- There are several other files in the root folder, including"
  - **`gatsby-node.js`** which handles node.js APIs, where you can instruct node to perform actions outside of what Gatsby normally does.
    - This is where you would define functionality that grabs Markdown files and turns them into other types of files and does other really complex handling of files and data and mashes everything together before it gets to Gatsby itself.
  - **`gatsby-browser.js`** which handles browser APIs, and **`gatsby-ssr.js`** which handles server-side rendering APIs.
  - For each of these, you can find documentation on what they do, by following the links in the comments at the top of the file itself.
- The majority of the work you do in gatsby, will be done in **`/src`**, or the source folder.
  - This is where you define your pages, your components, your templates, and anything else that will tie together to build out the pages and different content to see on the front end.
  - The `/pages` subdirectory will contain React `.js` files that contain all of the pages and front-end of the website.
  - There's also a second folder called `/components`. And this is where all the components sit.
    - This can include things such as layouts, partials, scripts, etc.

## Architecture in Gatsby

```
/
|-- /.cache
|-- /plugins
|-- /public
|-- /src
    |-- /pages
    |-- /templates
    |-- html.js
|-- /static
|-- /content
|-- gatsby-config.js
|-- gatsby-node.js
|-- gatsby-ssr.js
|-- gatsby-browser.js
```

- Gatsby projects have a more or less standard architecture. Some of this is defined by the application, some of it is defined by convention.
- The majority of your work will be done in three places.
- The first one is the **`/src`** folder.
  - This is where you define all the components, all the pages and all the templates that will go together to build the actual pages on the front end.
  - It works like this: any file that goes in the pages folder under source becomes an actual page on the front end.
  - So if you add a new file here called `about.js`, you get a new page on the front end called `about.js`.
  - All the components you create to pull into pages or templates or use anywhere else, go under the components folder.
- Now, inside the React community, there's a lot of debate about what is the best way of structuring components:
  - _Should they go in separate folders and then have a file called `index.js`under that folder? Or should they just sit as individual files under the folder?_
  - All of that depends on how advanced your build is and what you're trying to do and how you yourself feel that there should be structured.
  - But, components, that means small pieces that we'll put together with other pieces to make up larger pieces, should always go in the components folder just for structural integrity and to make things easy to find.
  - It's also a good idea to name your components very clearly so it's easy to understand which components do what when you're going and looking for specific functionality.
- **`/src/templates`** is another important folder where template pages will go, which are built specifically with Gatsby's functionality.
- There's a separate folder here that sits outside the source folder is called **`/static`**.
  - Anything that sits in the static folder becomes available as a static asset on the front end.
  - If you put an image file there, you can call that image file directly from the front end by just going to the domain name and the name of that file and it's directly available to us.
- There's also a convention where if you create a external content, so let's say Markdown files that will turn into pages through a template, you place them in a **`/content`** folder that also sits on the root.
  - It does not sit inside the source folder, it sits separately because it's not part of the source code, it is a data source.

## Pages, Components, and Styles

### Static Pages

- Pages serve as the core elements of any Gatsby site.
  - Pretty much everything you see in a Gatsby site live on the web is a page inside that site.
- There are two types of pages. There are the pages that you generate yourself.
  - They are called static pages, you go in and put in all the content, you want to appear on the pages.
  - And then there are dynamic pages that Gatsby auto generates based on different sources of data and templates.
- These pages can be found under the `/src` folder and the `/src/pages` folder.
  - Any file that goes under the Pages folder is automatically interpreted by Gatsby as being a static page and the name of that page is the name of the file.
  - Eg. `index.js` is the Index page for the site, `404.js` becomes the 404 page for the site and so on.

Example `index.js` page:

```javascript
import React from "react";

import Layout from "../components/layout";
import SEO from "../components/seo";

const IndexPage = () => {
  return (
    <Layout>
      <SEO
        title="The Homepage"
        description="You can customize the SEO text here."
        image="/logo.png"
        pathname="/"
      />
      <section>
        <h1>Hello, world!</h1>
        <div>
          <p>This file, index.js, functions as the homepage for the site.</p>
          <p>
            It can be populated with pure HTML like this, and extended using all
            available Gatsby and React components.
          </p>
        </div>
      </section>
    </Layout>
  );
};

export default IndexPage;
```

- This `const IndexPage` is then output to Gatsby by exporting it as the default.
  - And this is how Gatsby recognizes this index.js file is supposed to be a page and within it, there's some content that need to display outside and that's what's being exported down here.
  - So whatever is returned from Index page is what will display on the front end. In this case, that's the layout, the SEO component and this section of content.

### Static Assets

- When you have static assets you want to serve directly to the browser, (that could be images, or style sheets, or documents, or anything else you don't want to go through the Gatsby process), and you want to be available outside of React, you place that content in the `/static` folder.
  - Anything placed in the static folder becomes immediately available and directly available from the browser at the route of the site.
- All static assets are not been touched by Gatsby at all. They are not been optimized, or formatted, or run through React.
  - It's just the asset you uploaded mysyouelf, and, in some cases, that's really useful.
  - Just as the items in the static folder are available to the browser, they are also directly available to us in any of our components, so you can add these assets to a page if you wanted to.
- **Caveat:** What you're doing here is basically bypassing the entire point of using Gatsby.
  - You are serving up static assets directly to the browser and taking advantage of none of what Gatsby has to offer.
  - In Gatsby, the entire point is to place everything into the process to allow Gatsby, and React, and all the build process, and everything to optimize your assets to be delivered as effectively as possible.
  - Doing this bypasses the entire process.
- However, it's important to know that the static folder exists because there are times when you need to serve up static assets for whatever reason.
  - Eg. if you have a site logo, and you know that that site logo will be used in several different locations for several different purposes, it makes total sense to put that site logo in the static assets.
  - The same goes for the favicon or a global style sheet you want to apply as a style sheet rather than inline styles or other things.
  - Just be really careful that what you put in the static folder are actual static assets you need to be served up as static assets.

### Components

- Gatsby is built on top of react and react uses components extensively.
  - These components like the layout components, the SEO component, etc. are effectively custom elements that are defined inside React, where we control exactly what the output is going to be.
  - You can create very advanced logic for these components and also create easy to understand documents with portable components that can be transitioned from site to site and so on.

Example `image.js` component:

```javascript
import React from "react";

const ImageHelper = ({ src, alt }) => {
  return (
    <figure>
      <img src={src} width="500" height="auto" alt={alt} />
    </figure>
  );
};

export default ImageHelper;
```

Using the example component:

```javascript
import React from "react";

import Layout from "../components/layout";
import ImageHelper from "../components/image";

const ImagePage = () => {
  return (
    <Layout>
      <section>
        <ImageHelper
          src={"/images/test-photo1.png"}
          alt={"The first test photograph."}
        />
        <ImageHelper
          src={"/images/test-photo2.png"}
          alt={"The second test photograph."}
        />
      </section>
    </Layout>
  );
};

export default IndexPage;
```

- In essence, you create a new component, then define inside the component, what you want to output from the component that could be HTML, or it could be other components or combinations of things or logic, etc.
  - Each component can capture its own properties. And those properties can be used inside the component and any way you want, then you export the component out, import it, where you want to use it and simply fill in the component where you want to use it.

### Layout Component

- The layout component, `/components/layout.js` is one of the core conventions of Gatsby.
  - The idea of the layout component that you can see in all the pages that we have already built and all the pages that we are going to build is the layout component contains all the elements that are going to be repeated across multiple views.
  - The layout component is a box and inside that box you place all the things that you want to be repeated, like a header or a sidebar or a footer or some other element.
  - This allows you to have consistency between different pages and have different layouts between different pages, but that doesn't mean you have to have one layout component to apply to everything.
- On pages, you import the layout component with the `<Layout>` tag.
  - This means if you have different layouts for different pages or views, you could theoretically make different layout components for those different views. You would just create new files.
  - Naming it `archivelayout.js`/`<ArchiveLayout>` or `singlelayout.js`/`<SingleLayout>` or `bloglayout.js`/`<BlogLayout>` etc. and then import layout components to apply to whatever view you're currently looking at.
- How does the layout component know that there's a bunch of content inside it? If you go and look at the layout component, you can see exactly how that works:
  - In `layout.js`, down here in `const Layout`, so what envelopes the actual component? `const Layout = {{ children }} =>`
  - You see we're capturing a new property called children.
  - Children is whatever exists between the beginning and end tag of the component element, so any time you create a component, either ImageHelper or layout or anything else, and you place content between the beginning and end tags, that is captured in this item, children.
  - Further down, you can see `{children}` is called between the `<main>` tags.
- Note: You'll also notice one other thing at the beginning of the return: `<>`.
  - There's a rule in React that inside the return, you must have a beginning and end tag that envelopes everything.
  - That doesn't mean that tag actually has to be a real tag. If you don't want a real tag, you can simply start it with this empty tag at the top and then an empty end tag at the bottom.
  - These will be eliminated in the HTML, but they allow React to understand that everything that goes inside is one singular unit.

```javascript
import React from "react";
import { useStaticQuery, graphql } from "gatsby";
import Header from "./header";
import Footer from "./footer";

const Layout = ({ children }) => {
  const data = useStaticQuery(graphql`
    query SiteTitleQuery {
      site {
        siteMetadata {
          title
          description
        }
      }
    }
  `);

  return (
    <>
      <a className="skip-link screen-reader-text" href="#primary">
        Skip to the content
      </a>
      <Header
        siteTitle={data.site.siteMetadata.title}
        siteDescription={data.site.siteMetadata.description}
      />
      <main id="primary">{children}</main>
      <Footer siteTitle={data.site.siteMetadata.title} />
    </>
  );
};

export default Layout;
```

- The layout component is significant enough that it has its [own page in the Gatsby documentation](https://www.gatsbyjs.com/docs/layout-components/) and it's worth reading this page because it talks both about how Gatsby approaches layouts, how the layout component's supposed to work, and different approaches to using the layout component for different purposes.
- As you start expanding your experimentation with Gatsby and React, you may also notice that the layout component, because of how it works, will unmount every time you reload a page.
  - This means everything that goes inside the layout component has to be regenerated every time you do something, which kind of runs against the idea of single page components.
  - [This is addressed in the documentation](https://www.gatsbyjs.com/docs/layout-components/#how-to-prevent-layout-components-from-unmounting), where it explains how to prevent layout components from unmounting, so if you want to explore this further and figure out how to use the layout component and at the same time, only reload the content that's changing, not the entire page, there are tools for this.
- There's even a plugin for Gatsby specifically called [Gatsby Plugin Layout](https://www.gatsbyjs.com/plugins/gatsby-plugin-layout/) that allows you to handle this unmounting properly.
  - For now, go read the documentation for the layout component and go play with the layout component in the template.
  - You can change the component itself to change what it outputs, or you can change how the layout component is used inside one of the page templates.

### CSS in Gatsby

- Because Gatsby is built on top of React, styling and CSS in Gatsby is handled the same way styling and CSS is handled in React.
  - This is to say, there is no one set standard on how to handle styles and CSS.
  - Instead, you have multiple approaches and you can mix and match to fit with whatever coding methodology you prefer and requirement you need to meet.
- There are three main approaches to styles and CSS in Gatsby that are worth knowing about: Plain CSS, CSS Modules, and CSS-in-JS.
- First up, standard, good, old-fashioned style sheets.
  - You can create regular old CSS files and then import them into the browser using `gatsby-browser.js`, just by adding the line `import "./src/styles/main.css"`.
  - What happens now is for every single page, `main.css` will be loaded first, meaning, it'll be applied globally on everything you're working with. There's no scoping, it's just a global style sheet applied everywhere.
  - If that's what you want, this is a good approach, but it is rather heavy-handed, especially if you have a lot of components that may change behavior over time.
- Next up, CSS modules. This is the CSS version of JavaScript and React components and they work alongside JavaScript and React components.
  - Eg. `layout.module.css` would be imported directly into `layout.js` with `import style from "./layout.module.css"`.
  - This is then used within the React JavaScript: `<main className={style.main_content}>`.
  - When this is processed, Gatsby takes this`style.main_content` and creates a new class that applies only to this component and then ties the style to only that class.
  - That means, all styles in the CSS modules become locally scoped to just this component, and you never have to worry about a CSS conflict anywhere else within the project.
  - It also means, for each component, you need to create a CSS module. It allows you to write CSS the old way, but it means you're adding a ton of new files, one for each component you want to style.
- The last option is CSS-in-JS. This is CSS actually written inside the component with specialized JavaScript syntax. This is typically done on component level, but it can be done anywhere within any file.
  - You begin with `import styled from "styled-components" at the top of the page, then defining new styled components:
  - Eg. `const Container = styled.section' display: grid;'`
  - Then, the component `<Container>` will be automatically styled with those properties.
  - CSS-in-JS has gathered a lot of momentum in recent years because it allows JavaScript developers to write JavaScript even when they write CSS, and it also directly connects the style to the element being styled, making it easy to figure out what's going on.
- A good workflow example would be a setup using CSS modules alongside [postCSS](https://postcss.org/).
  - This allows you to use CSS custom properties and other advanced CSS features, with proper fallbacks to unify styles across the entire site.
  - This also allows you to have a file such as `global.module.css` with properties that will be applied everywhere throughout all of your modular style sheets.

## Plugins and Transformations

- Plugins allow you to extend Gatsby functionality beyond the basics.
  - The term plugin has different meanings for different applications.
  - In Gatsby, a plugin is a node package, often a customized version of a react module or component or package that implements Gatsby API's you can then use to perform advanced functionality.
- There are a myriad of plugins available for Gatsby and more are added every day.
  - You can find all available plugins for Gatsby by going to [gatsby.org/plugins](gatsby.org/plugins) and making a search for the feature you're looking for.
  - In almost every case, what you need has already been built into a plugin and that plugin will be available right from this page.
  - That said, you can also create your own plugins if you want to, to add specific features to your site. You can find documentation and step by step instructions in the official Gatsby documentation under [creating plugins](https://www.gatsbyjs.com/docs/creating-plugins/).
- Installing Gatsby plugins: `npm install --save gatsby-plugin-react-helmet react-helmet`, then adding `` plugins: [`gatsby-plugin-react-helmet`] `` into the file `gatsby-config.js`.
- If you already had Gatsby developer running, and then went into Gatsby config and added the plugin, it won't work.
  - Every time you add a new plugin or make any changes to Gatsby config, it's a good idea to turn Gatsby develop off and booted back up again after you've saved Gatsby config.
  - That initializes all the new functionality and gets things up and running.

### Plugin Options

- Some plugins can be used as is out of the box. Other plugins need some level of configuration, and that's done by adding options to the plugin configuration inside Gatsby config.
- An example of this is the [gatsby-source-filesystem](https://www.gatsbyjs.com/plugins/gatsby-source-filesystem/). As stated in its description, this plugin is for sourcing data into your gatsby application from your local file system.

```javascript
// In gatsby-config.js:
module.exports = {
  plugins: [
    {
      // Calling and appending the plugin:
      resolve: `gatsby-source-filesystem`,
      options: {
        name: `images`,
        path: `${__dirname}/content/images/`,
      },
    },
  ],
};
```

- When you save this and run `gatsby develop`, everything that's inside `/content/images` now becomes available to Gatsby, and Gatsby can then process that information. However, more needs to be done in the next section.

### Transformation Plugins

- Once you've added a new data source with gatsby-source-filesystem, you can use what's known as a transformer plugin to make the raw content at that data source available for Gatsby and React to transform.
- An example of this is [gatsby-transformer-sharp](https://www.gatsbyjs.com/plugins/gatsby-transformer-sharp/).
  - Earlier images were added to the static folder and then pull them into the about page using a regular image element. This works fine, but it bypasses the whole purpose of using Gatsby in the first place. By pulling the images in as replaced elements, we bypass any optimization Gatsby or react could have provided.
  - Using a transformer plugin like this will instead optimize images on your website using the Sharp image processing library, as well as provide fields in GraphQL typers for processing images in a variety of ways.
- In addition to `gatsby-plugin-sharp settings` in `gatsby-config.js`, there are additional query options that apply to fluid, fixed, and resized images:
  - `grayscale` (bool, default: false)
  - `duotone` (bool|obj, default: false), etc.

```javascript
export const query = graphql`
  {
    headerImage: file(relativePath: { eq: "test-image-1024x2048.jpg" }) {
      childImageSharp {
        fluid(maxWidth: 1184) {
          ...GatsbyImageSharpFluid
        }
      }
    }
  }
`;
```

- The above code is telling React to grab the image and transform it into a responsive image and the output from this will be a responsive image providing us with different break points for different screen sizes, all automatically.
  - You don't have to write any of that fancy responsive images code.
  - Requires `import Img from "gatsby-image"`
  - Then pull in the data from that query at the bottom of the document. That data automatically becomes available to us as data up here in the properties: `const AboutPage = ({data}) => { //... }`.

```javascript
<Img fluid={data.headerImage.childImageSharp.fluid} alt="Test Image" />
```

- If you go look at the image, you'll see here in the mark-up that we're not just looking at a regular imported image.
  - This is in fact a fully responsive image. You can see it's wrapped in a picture element that has fallbacks and it has multiple different sizes, depending on the size of the view port and everything.
- These transformer plugins are important because they allow react and Gatsby to do a ton of the heavy lifting that you would otherwise have to do.

## Data and GraphQL

- GraphQL is the query language we use inside react to pull data into pages from other sources.
- Going back to the previous example, GraphQL will return to us a JSON object that can be parsed.
  - The JSON object is called `data`, and you parse through the data, just stepping through the object, from `data` to `.headerImage` to `.childImageSharp` to `.fluid` or `.fixed`, depending on which image you want to display.
- There's a tool provided by Gatsby that makes GraphQL much easier to understand and work with.
  - When you run Gatsby develop, you may have noticed, you actually get two URLs to the local server once the process is complete.
  - The first URL just goes to the live site. The second URL that you see down here goes to GraphiQL, an in-browser IDE, to explore your site's data and schema: **localhost:8000/\_\_graphql**.
- From this graphical interface, you can explore your entire GraphQL setup on your local server.
  - From here, we can see all available information in the explorer, we can craft custom requests, and we see the result of those those requests over on the right-hand side right away, so this is effectively where you build your requests before you put them into code.
- GraphiQL is essential to working with data in GraphQL, and as you move forward, you'll start building new GraphQL queries.
  - Any time you do that, it's a good idea to go into GraphiQL and play around with that query to figure out exactly what it's doing and what else you can do with it by exploring it in the explorer.

### Queries in GraphQL

- In Gatsby, there are two different types of GraphQL queries, which are used in two different circumstances.
- For pages, like `events.js`, you use a page query. A page query sits separately from the main export components.
  - It's it own component and the key benefit of a page query is it can accept variables. So you can make the query it's self dynamic by passing variables to it.
  - But, as the name suggests, it only works for pages. You can not use a page query inside a component.

## Appendix

### Navigation Component

Example of a navigation component `mainnav.js`:

Note: The Gatsby `<link>` component is a special component for Gatsby that allows you to create dynamic links to anything that's within the Gatsby site and it will resolve all the links for you. Read more about it in [the docs](https://www.gatsbyjs.com/docs/gatsby-link/).

```javascript
import React from "react";
import { Link } from "gatsby";

import style from "./mainnave.module.css";

const MainNav = () => {
  return (
    <nav className={style.navigation}>
      <ul>
        <li>
          {" "}
          <Link to="/">Home</Link>{" "}
        </li>
        <li>
          {" "}
          <Link to="/events">Events</Link>{" "}
        </li>
        <li>
          {" "}
          <Link to="/">Home</Link>{" "}
        </li>
      </ul>
    </nav>
  );
};

export default MainNav;
```

### Adding Multiple Images

```javascript
import React from "react";
import Img from "gatsby-image";

import Layout from "../components/layout";
import style from "./events.module.css";

const IndexPage = ({ data }) => {
  return (
    <Layout>
      <section className={style.wrapper}>
        <Img fluid={data.headerImage.childImageSharp.fluid} alt="Robots" />
        <div>
          <Img
            className={style.image}
            fixed={data.bodyImage.childImageSharp.fixed}
            alt="Robots"
          />
        </div>
      </section>
    </Layout>
  );
};

export default IndexPage;

export const query = graphql`
  {
    headerImage: file(
      relativePath: { eq: "getting-creative-with-3-d-printers-1184x360.jpg" }
    ) {
      childImageSharp {
        fluid(maxWidth: 1184) {
          ...GatsbyImageSharpFluid
        }
      }
    }
    bodyImage: file(relativePath: { eq: "bubbles-disc.png" }) {
      childImageSharp {
        fixed(width: 288, grayscale: true) {
          ...GatsbyImageSharpFixed
        }
      }
    }
  }
`;
```
