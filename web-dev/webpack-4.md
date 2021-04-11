# Webpack 4

**Table of Contents:**

- [Webpack 4](#webpack-4)
  - [What is Webpack?](#what-is-webpack)
  - [Commands](#commands)
  - [Files](#files)

## What is Webpack?

- Webpack is a build tool that allows us to take all of our assets and turn them into a production ready bundle.
- All of our files are considered modules and we tell Webpack to load those modules when we configure our project.
- So why would we use something like Webpack?
  - The answer to that starts by looking back at how loading assets used to work in web projects.
  - Consider this HTML file. We're adding tons of script tags in the head, three of them, and when we used to add script tags like this, it could get pretty messy.
  - Errors could occur from the hierarchy of these scripts.
  - Global variables might be over written, and there might be unintended consequences of functions being called before others.
- Order was extremely important and really difficult to manage.
  - And all of these HTTP requests are really taxing on browsers.
- Some of the benefits of working with something like Webpack, is that it provides an alternative to some of these complications, with a concept of a dependency graph.
  - We're going to require assets like images, CSS files, and Java script files and their loaded when they're needed for the page.
- We can also split our app into different files and just load the code that the page requires.
  - Then when the user goes to a new page, they don't download the already downloaded code again.
  - It also minimizes the initial loading time for the app.
  - This process is called code splitting. Webpack also helps us deal with transformations.
- If we're using Sass or Less we can build that code we can build that code to CSS prior to production.
  - If we're using React of ES6 we can transform that into vanilla Java script.
- All of this can be configured and then automated so that these transforms don't have to occur manually.

## Commands

```bash
# installation
npm init
npm install webpack@4.28.4 --save-dev
npm install webpack-cli@3.2.1 --save-dev

# installing webpack loaders
npm install babel-loader @babel/core @babel/preset-env --save-dev

# installing react
npm install react react-dom @babel/preset-react --save

# installing webserver
npm install webpack-dev-server --save-dev

# installing plugins
npm install html-webpack-plugin --save-dev
npm install uglifyjs-webpack-plugin --save-dev

# running webpack
npm i
./node_modules/.bin/webpack # Will run webpack locally.
npx webpack
```

## Files

**`webpack.config.js`:**

```js
const path = require("path");
const HtmlWebpackPlugin = require("html-webpack-plugin");
const UglyifyJsPlugin = require("uglifyjs-webpack-plugin);

module.exports = {
  entry: {
      about: "./src/about.js",
      contact: ".src/contact.js"
  },
  output: {
    filename: "[name].bundle.js",
    path: path.resolve(__dirname, "dist"),
  },
  optimization: {
    minimizer: [new UglifyJsPlugin()]
    splitChunks: {
        chunks: "all"
    }
  },
  plugins: [new HtmlWebpackPlugin],
  devServer: {
      contentBase: path.join(__dirname, "dist"),
      port: 9000
  }
  module: {
    rules: [
      {
        test: /\.js$/,
        exclude: /(node_modules)/,
        use: {
          loader: "babel-loader",
          options: {
            presets: ["@babel/preset-env", ["@babel/preset-react"]],
          },
        },
      },
      {
        test: /\.css$/,
        use: [{ loader: "style-loader" }, { loader: "css-loader" }],
      },
      {
        test: /\.(png|jpg)$/,
        use: [{ loader: "url-loader" }],
      },
    ],
  },
};
```

**`package.json`:**

```js
{
  "name": "webpack-basics",
  "version": "1.0.0",
  "description": "Learning all about webpack 4!",
  "main": "index.js",
  "scripts": {
    "build": "./node_modules/.bin/webpack -w"
    "start:dev": "./node_modules/.bin/webpack-dev-server"
  }
}
```

**`.babelrc`:**

```json
{
  "presets": ["@babel/preset-react", "@babel/preset-env"]
}
```
