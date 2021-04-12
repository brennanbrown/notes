---
layout: default
title: Javascript Game Development
parent: Web Development
---

**Table of Contents:**

- [Introduction](#introduction)
- [Part 1: Button Chaser](#part-1-button-chaser)
- [Animation in JS](#animation-in-js)
  - [Replacement Animation](#replacement-animation)
  - [Point-to-Point Animation](#point-to-point-animation)
  - [JavaScript Coordinate System](#javascript-coordinate-system)
  - [Boundary Collision Detection](#boundary-collision-detection)
- [Part 2: Rebound](#part-2-rebound)
  - [Optimizing `keyListener` Function](#optimizing-keylistener-function)
  - [`setTimeout()` vs. `requestAnimationFrame`](#settimeout-vs-requestanimationframe)

## Introduction

- Nearly every computer program ever written accepts input from the user, processes that input in some way, produces some output, and provides feedback to the user.
  - Game programming is no different.
  - Games forces developers to examine code optimization for the best user experience, something all web developers should consider.
- Usually, game programs create event listeners that listen for user input via touch, the mouse, or keyboard, and a game loop that manages processing.
  - Once launched, the game loop continues until it encounters some end condition.
  - If end conditions aren't met, objects are rendered to the screen and the game continues.
- In this project, the game will be simple, and called **Rebound**.
  - Rebound is a simple paddle and ball game where the player must keep the ball from reaching the bottom of the playing area.
  - The score is reflected at the bottom of the playing area. As the game progresses, difficulty is increased by moving the ball more quickly.
  - Rebound includes some simple collision detection routines to reward the player for using the middle of the paddle. (game buzzes)
  - It also includes some basic sound effects and a background music track, and a settings panel lets players decide if they want to hear the sounds and start a new game.

## Part 1: Button Chaser

View the game [**here!**](https://brennanbrown.github.io/javascript-projects/rebound-game/button-chaser)

- Before implementing all the features of the Rebound game, we need to add some tools to our toolset.
  - You need to crawl before we can walk.
  - Let's start by creating a simple game.
- Button Chaser is a Whac-A-Mole type game where the player needs to tap a button on screen that is randomly placed.
  - The button will move once per second, and the score is increased each time the button is tapped.
  - The game ends after 30 seconds, and the player is informed that the game is over.

```javascript
let score = 0;
let iterations = 0;
let aWidth, aHeight, timer;

// Executes after all of the resources for the page are downloaded.
window.addEventListener("load", setGameAreaBounds);

function setGameAreaBounds() {
  aWidth = innerWidth;
  aHeight = innerHeight;
  // Taking other element sizes into account:
  aWidth -= 22;
  aHeight -= 97;

  document.getElementById("game-area").style.width = aWidth + "px";
  document.getElementById("game-area").style.height = aHeight + "px";
  document.getElementById("dot").addEventListener("click", detectHit);

  // Make sure the dot stays within the
  // right and bottom of the gaming area:
  aWidth -= 74;
  aHeight -= 74;

  moveDot();
}

function detectHit() {
  score += 1;
  document.getElementById("score-label").innerHTML = "Score: " + score;
}

function moveDot() {
  // Allowing the dot to appear randomly
  // within the available area:
  let x = Math.floor(Math.random() * aWidth);
  let y = Math.floor(Math.random() * aHeight);

  // Make sure the dot stays within the
  // left and top of the gaming area:
  if (x < 10) {
    x = 10;
  }
  if (y < 10) {
    y = 10;
  }

  document.getElementById("dot").style.left = x + "px";
  document.getElementById("dot").style.top = y + "px";

  // Note: Not recursive, setTimeout returns
  // immediately and tells the browser to wait
  // the specified delay, and then execute the code.
  if (iterations < 10) {
    timer = setTimeout("moveDot()", 1000);
  } else {
    // Ending the game and disabling functionality:
    document.getElementById("score-label").innerHTML += " Game Over!";
    document.getElementById("dot").removeEventListener("click", detectHit);
    clearTimeout(timer);
  }

  iterations++;
}
```

## Animation in JS

- Animation on the web is very much like those flip books you created as a kid.
  - Eg. You place an individual image on the corner of each page in the book then flip through the book rapidly to see the animation.
  - If you flip rapidly enough, the animation is smooth.
  - If you don't flip rapidly enough, the animation is jerky.
  - Animators call the speed of the flipping, the frame rate.
- Using JavaScript, you can manipulate the properties of an image to simulate motion.
  - You might change the source attribute of the image. Eg. Focusing on the horse and its rider.
  - The animation cycles through a set of images in a series, then repeats.
  - This is how changing the source attribute of an image element, works.
- In JS, this technique is called replacement animation.
  - You might also change the images location on the screen.
  - For other types of animation, you may notice how the image doesn't change but the location of the image onscreen does.
  - Eg. The cactus follows a well-defined path in the animation. We'll explore
- You'll be able to create a path for objects onscreen using mathematical formulas.
  - Eg. How the cactus sits behind the horse and rider when they occupy the same location onscreen.
  - This is how we can simulate depth in an animation.
- You can manipulate an objects Z index to accomplish layering objects.
  - The cool part is that you can often combine these techniques to produce compelling animations.

### Replacement Animation

View the animation [**here!**](https://brennanbrown.github.io/javascript-projects/rebound-game/animation)

- The general process for replacement animation is to create an array of images to cycle through, then swap the images fast enough so that the user perceives motion.
  - Just remember, there really isn't any motion taking place. You are simply controlling which frame the user is currently viewing.
- It's customary to name the individual frames of an image set with the same prefix and then a frame counter for the number. Eg. `ball0.gif`
  - This construct works nicely to create an array to hold the images.
- The good news is, we won't have to declare each individual image object.
  - Rather, because the names of the files are indexed, a simple loop does all the work.

```javascript
let imgArray = new Array();

for (let i = 0; i < 24; i++) {
  // Using an image object forces
  // browser to preload each object,
  // thus removing latency.
  imgArray[i] = new Image();
  imgArray[i].src = "img/ball" + i + ".gif";
}

let counter = 0;

function rotate() {
  if (counter > imageArray.length - 1) {
    // Restarts and loops animation.
    counter = 0;
  }
  document.getElementById("baseball").src = imgArray[counter];
  counter++;
  setTimeout("rotate()", 50);
}
// The load event fires after all of the resources have been downloaded.
// And that's important, because we're using the image array,
// storing image objects, that means all of the frames in the
// animation will be downloaded before anything gets going.
window.addEventListener("load", rotate);
```

### Point-to-Point Animation

- Point-to-point animation is done by calculating and objects coordinates on the screen using a mathematical formula.
  - In essence, the point-to-point animation keeps track of the objects top and left properties and then modifies their values according to the formula.

```javascript
let currentX = 400;
let currentY = 100;

function animate() {
  document.getElementById("orb").style.left = currentX + "px";
  document.getElementById("orb").style.left = currentY + "px";

  currentX += 2;
  currentY += 2;

  if (currentX > 800) {
    return;
  }
  setTimeout("animate()", 10);
}

window.addEventListener("load", animate);
```

### JavaScript Coordinate System

- The browser's viewable area is the canvas of the page, this is the known as the JavaScript Coordinate System.
- The origin of the coordinate system is the top left of the page `0, 0`.
  - This is the only point on the canvas that we can actually be sure exists.
  - Since users always have varying viewports, we cannot assume anything about the bottom or right values the screen.
- When thinking of the coordinates, moving from right to left represents an increment in the x value of the pair.
  - Counter-intuitve to basic geometry, however, moving from top to bottom represents an increment in the y value of the pair.
- These are the things that must be kept in mind when moving objects on the screen.

### Boundary Collision Detection

- Variables are required to hold the distance the ball travels between frames (delta).

```javascript
let currentX = 400;
let currentY = 100;
let deltaX = 5;
let deltaY = 5;

function animate() {
  document.getElementById("orb").style.left = currentX + "px";
  document.getElementById("orb").style.left = currentY + "px";

  currentX += deltaX;
  currentY += deltaY;

  if (currentX > 800 || currentX < 100 || currentY > 600 || currentY < 100) {
    deltaX *= -1;
    deltaY *= -1;
  }
  setTimeout("animate()", 10);
}

window.addEventListener("load", animate);
```

## Part 2: Rebound

### Optimizing `keyListener` Function

```javascript
function keyListener(e) {
  if ((e.keyCode == 37 || e.keyCode == 65) && paddleLeft > 0) {
    paddleLeft -= pdx;
    if (paddleLeft < 0) paddleLeft = 0;
    paddle.style.left = paddleLeft + "px";
  }
  if ((e.keyCode == 39 || e.keyCode == 68) && paddleLeft < pWidth - 64) {
    paddleLeft += pdx;
    if (paddleLeft > pWidth - 64) paddleLeft = pWidth - 64;
    paddle.style.left = paddleLeft + "px";
  }
}
```

```javascript
function keyListener(e) {
  // Adding variable for element used multiple times:
  let key = e.keyCode;
  if ((key == 37 || key == 65) && paddleLeft > 0) {
    paddleLeft -= pdx;
    if (paddleLeft < 0) paddleLeft = 0;
  } else if ((key == 39 || key == 68) && paddleLeft < pWidth - 64) {
    paddleLeft += pdx;
    if (paddleLeft > pWidth - 64) paddleLeft = pWidth - 64;
  }
  // Moving duplicate code outside of loops:
  paddle.style.left = paddleLeft + "px";
}
```

### `setTimeout()` vs. `requestAnimationFrame`

- There are shortcomings with the usage of `setTimeout()` and similarly, `setInterval()`.
  - Although convenient, they begin posing problems on mobile and lower-end devices.
  - They are resource intensive, taking up process cycles even when the animation isn't visible.
- Both functions require a delay in milliseconds that's set by the developer before executing, or a number of frames per second.
  - When the browser can't accommodate this framerate, the animation is choppy and poor.
  - In other words, when the function is fired off, the browser isn't yet ready to redraw the screen, so the frame is skipped.
- `requestAnimationFrame`, on the other hand, is a newer function that's optimized to run at the browser's peak speed.
  - This also allows browsers to suspend inactive or invisible animations.
