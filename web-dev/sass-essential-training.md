---
layout: default
title: SASS Essential Training
parent: Web Development
---

- Sass is an extension that adds functionality to the cascading style sheets language, or CSS, that's used to design the look of modern websites.
  - Browsers do not understand and can't really read Sass, so it's what we call a pre-processed language.
  - Sass commands have to be translated into CSS so that it can be understood by a browser.
- Sass itself is very extensible and has been expanded through the use of plug-ins like Compass, Bourbon, and Susie.
- Sass is written in Ruby, which is a popular language for the web.
  - Depending on how you choose to work with Sass, you may need to install Ruby on your machine.
  - Sass has a lot of features which have made it hugely popular.

## Features

**Variables:**

```sass
$main_color: #9e2932;

.navbar {
  background: $main_color;
}

h1,
h2,
h3 {
  background: darken($main_color, 20);
}
```

**Nesting:**

```sass
.pixgrid {
  ul {
    margin: 0;
    padding: 0;
    list-style: none;
    li {
      float: left;
      width: 96px;
      height: 96px;
      padding: 0 5px 5px 0;
    }
  }
}
```

**Partials:**

```sass
// Core Partial
@import "variables";
@import "mixins";
@import "base";
@import "layout";

// Import Modules
@import "modules/intro";
@import "modules/nav";
@import "modules/welcome";
@import "modules/events";
```

**Extend:**

```sass
.btn {
  padding: 6px 12px;
  line-height: 140%;
  text-align: center;
  verticle-align: middle;
  border: 1px solid transparent;
  background: #c61;
  color: #fc0;
}

.btn-reverse {
  @extend .btn;
  background: #fc0;
  color: #c61;
}
```

**Operators:**

```sass
$border_thickness: 1px;
$thicker: $border_thickness * 5;

.sidebar {
  @if ($border_thickness <= 1) {
    background-color: red;
  } @else {
    background-color: yellow;
  }
}
```

**Mixins:**

```sass

```
