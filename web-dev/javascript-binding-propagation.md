---
layout: default
title: Javascript Binding and Propagation
parent: Web Development
---

**Table of Contents:**

- [Prototype in JavaScript](#prototype-in-javascript)
  - [Planning the Application](#planning-the-application)
  - [Pseduocode](#pseduocode)
  - [Immediately invoked function expression](#immediately-invoked-function-expression)
- [Dynamic Elements](#dynamic-elements)
- [Animation and `this` in JavaScript](#animation-and-this-in-javascript)
  - [Meaning and Definition of `this`](#meaning-and-definition-of-this)
  - [`bind`, `call`, and `apply`](#bind-call-and-apply)
- [Fisher-Yates Shuffle](#fisher-yates-shuffle)
  - [Stacking](#stacking)
- [Propagation](#propagation)
  - [Discard Pile](#discard-pile)
  - [Drag-and-Drop](#drag-and-drop)

## Prototype in JavaScript

### Planning the Application

- Think about a card game for a minute. What are it's objects?
  - First of all, there is a game and a game has a deck and a discard pile, which would be attributes, specifically objects.
    - You can play the game, which would be a function like `play()`.
  - The discardPile object/attribute itself probably has a Rules array, and maybe even a maximum card number.
    - There's also a function for card drag over, `cardDragOver()`.
  - There's a deck and decks have a list of suits and values.
    - For a deck, you would want to shuffle and stack it, `shuffle()` and `stack()`.
  - Decks have cards and there are single suits and values.
    - And for the card itself, we're going to want to flip, drag and drop it, `cardFlip()`, `cardDrag()`, and `cardDrop()`.
  - Specific instances of different card games might have modified attributes or functions.
    - FlashCards, for example would have no rules. And a game like Hearts would also require score.
    - Additionally, games like Solitaire and Hearts would require a standard deck with suits and numbers, whereas FlashCards wouldn't.
- You could imagine if we were building these objects with code, we may want to reuse them. And that's where prototypes come in.
  - Prototype is something available to all objects.
  - And just like any prototype, it's a way of making a plan for an object so that we can reproduce it.
  - Once created, you can use a protoype as many times as you want to create something as needed.

Prototypes Examples:

```javascript
// Object Instance w/o Prototype:
var person = {
  firstName: "John",
  lastName: "Doe",
  age: 50,
  eyeColor: "blue",
};

// Object Instance w/ Prototype:
let person = new Object();
person.firstName = "John";
person.lastName = "Doe";
person.age = 50;
person.eyeColor = "blue";

// Constuctor Function:
function Person(first, last, age, eye) {
  this.firstName = first;
  this.lastName = last;
  this.age = age;
  this.eyeColor = eye;
}

// Multiple Instances:
var John = new Person("John", "Doe", "33", "blue");
var Jane = new Person("Jane", "Doe", "43", "green");
```

### Pseduocode

- Sketching out and pseudo coding your application is a great way to get organized before you start.
- If your original plan changes and you have to update your pseudo code, it's a good indicator that you've pivoted on your idea or that something may take more time than you originally thought.
- You can then save it as comments to reference it as we build your objects.

```javascript
/*
Game
    Info Section
    Deck
    Discard Pile
    Rules

Deck
    Cards
    -----
    shuffle()
    stack()

Cards
    val
    suit
    ----
    flip()

Discard Pile
    Holders
    -------
    AcceptOrReject()
*/
```

### Immediately invoked function expression

- An IIFE function, or an immediately invoked function expression can be defined as wrapping code in a function and immediately running it, the internal variables are unavailable to the outside keeping our variables safe.
  - This avoids pollutiing the global namespace.
- Note: Start the code with a `;` just in case this is is ever minimized and the proceeding code doesn't end with a `;`.
- Starting off with the `Game` function, two parameters will be passed through, `el` and `option`.
  - The element is going to be the element you're going to drop the game into, and options is going to tell us what game you want to play.
- You're going to want to make our game element available on the window.
  - In the immediately invoked function, pass in the window as a parameter. In both the initial function and the anonymous function on the inside.
  - This means that when you attach that to the window object, say `window.Game = Game;` the game object is available.
- Within `index.html`, directly call an anonymous function to start the game, `var myGame = new Game("game_div", {game: "flashcard", data: flashcard_QA});`
  - The parameters being `"game_div"`, which is the `<div>` where the game will be displayed on the page, followed by the game data.

```javascript
(function (window) {
  // Game
  var Game = function (el, option) {};
  window.Game = Game;
})(window);
```

## Dynamic Elements

- Dynamic elements are ordinary HTML elements built and added by JavaScript, rather than being directly written within the HTML file.
- When do you assign something to a variable and when should you attach it to your object?
  - Eg. `div.className = "x"` being inside `var Object = {}` or outside of it.
  - Typically the idea is not to expose something until you really need to.

```javascript
// Dynamically creating new HTML on the page:
this.info_div = document.createElement("div");
this.info_div.id = "info_div";
this.deck_div = document.createElement("div");
this.deck_div.id = "deck_div";

// Append these new dics to the main element:
this.el.appendChild(this.info_div);
this.el.appendChild(this.deck_div);
```

- With a standard deck there are 52 cards, and rather than appending each to the page, we'll be using a document fragment.
  - Eg. `s`
  - Document fragments allow us to build out divs off dom and then append them to the body once they're all collected.
  - Each time you modify the DOM, it forces a redraw. And this might not matter with one or two divs, but with 52 cards, that would be a lot.
- Each card has several divs.
  - The first one is the card container, and that's essentially going to just keep things in place.
  - Inside of that is a flip div, and that's going to be in charge of rotating both the front and the back of the card.
  - Inside _that_ there's a card back and a card front, and each of those contains divs for values, and the card front also has a div for the category value.

## Animation and `this` in JavaScript

- There are many different types of animations and events, luckily they all act in a rather similar way.
  - There are two ways to add an event. You can use the `onclick` attribute of an element, or `addEventListener`.
  - `onclick` is declarative, can be overwritten, and has no control over event phase.
  - `addEventListener` can contain multiple event listeners and choose event phase. Should be grouped together for ease.
  - Which one you choose often depends on coding style.

```javascript
this.cardContainer.onclick = fuction(e) {
    // Demonstrates the difference between
    // target vs. currentTarget:
    console.log(e.target, e.currentTarget);
    // Demonstrates the difference between
    // className vs. classList:
    console.log(e.currentTarget.className,
      e.currentTarget.classList);
    // Demonstrates 'this' in the context
    // of an onclick event:
    // In this case, it is identical to currentTarget,
    console.log(this);
}
```

- The difference between the `target` and the `currentTarget`, the `target` is what you actually clicked on, the `currentTarget` is what actually has the event listener on it.
- With `classList`, if there are multiple classes on what you click, they will be displayed in array.
- Using `e.currentTarget.classList.toggle("flip_card");`, would cause the class to be added and removed with each click.

### Meaning and Definition of `this`

- The keyword this can be a little bit confusing in JavaScript, and that's because, like in real life, the meaning of this has context and that can change.
  - Eg. When presented with multiple objects, how do you determine which one "_this_ one" is?
  - When it doubt, `console.log(this)` it out. It's the easiest way to figure out what this means at the time.
- There are three other places this can change unexpectedly, and there are two things you need to remember.
- `this` is called a the time of invocation, and Global `this` is undefined in "use strict" mode of JavaScript.

```javascript
// 'this' with a simple function:
function myFunction() {
  console.log(this);
}
// Output:
// Will contain entire "Window" object.
// Will be "undefined" if use strict is enabled.
myFunction();

// 'this' with a constuctor function:
// will reference the object.
var Person = function () {
  this.name = "John";
  this.salary = 100;
  console.log(this);
};
// Output:
// Person {name: "John, salary: 10}
new Person();

// 'this' with an object:
// When calling function as a method,
// will just return the object.
var VIP_emp = {
  bonus: function () {
    console.log(this);
  },
};
// Output:
// {bonus: ƒ}
VIP_emp.bonus();
```

### `bind`, `call`, and `apply`

- There are three ways we can force the meaning of this: bind, call, or apply.
  - Bind: "Call me later!"
  - Apply: Execute me right now; accepts this + array.
  - Call: Execute me right now; this + individual parameters.
- Call and apply are essentially the same thing except for you're using an array with apply and call just takes parameters.
  - With bind, you can attach the meaning of `this` and call it later.

```javascript
var Person = function () {
  this.name = "John";
  this.salary = 100;
  console.log(this);
};
new Person();

var Janice = new Person();
Janice.name = "Janice";

var VIP_emp = {
  bonus: function () {
    console.log(this);
  },
  // Janice will now always be the
  // meaning of 'this' for the VIP.
  title: myfunction.bind(Janice);
};
VIP_emp.bonus();
VIP_emp.title();
```

## Fisher-Yates Shuffle

- When creating a shuffle function for cards, it's good to use an algorithm for suitable randomness.
  - The Fisher–Yates shuffle is an algorithm for generating a random permutation of a finite sequence—in plain terms, the algorithm shuffles the sequence. Read more [**here**](https://bost.ocks.org/mike/shuffle) by Mike Bostock.
- A simple but effective way of doing this is to pull a random card from the deck repeatedly and set it aside, incrementally building a new stack.
  - As long as you pick each remaining card from the deck with equal probability, you’ll have a perfectly-unbiased random stack when you’re done:

```javascript
Deck.prototype.shuffle = function () {
  const cardsToShuffle = this.gameDeck.deckData;
  let remainingCards = cardsToShuffle.length,
    temp,
    i;
  // While there remain elements to shuffle…
  while (remainingCards) {
    // Pick a remaining element…
    i = Math.floor(Math.random() * remainingCards--);
    // And swap it with the current element.
    temp = cardsToShuffle[remainingCards];
    cardsToShuffle[remainingCards] = cardsToShuffle[i];
    cardsToShuffle[i] = temp;
  }
};
```

### Stacking

- As a general rule of thumb, you shouldn't manipulate your styles in JavaScript unless you have a good reason to.
  - Only manipulate style in JavaScript when it needs **iterative manipulation**, otherwise use a class.

```javascript
Deck.prototype.stack = function (deck_div) {
  let cards = deck_div.children;
  for (let i = cards.length - 1; i >= 0; i--) {
    cards[i].style.top = i + "px";
    cards[i].style.left = i + "px";
    cards[i].classList.add("stacked_card");
  }
};
```

- After this, the cards in the browser will stack nicely. But when you flip them over, they slide underneath the first card instead of on top. The `zIndex` is off, here's a fix for that:

```javascript
var counter = 0;
function cardClick(e) {
  e.currentTarget.classList.toggle("flip_card");
  e.currentTarget.classList.toggle("slide_over");

  e.currentTarget.style.zIndex = counter;
  counter++;
}
```

- But what if another function decided to change the value of the counter, and what if the counter was tracking our score rather than our `zIndex`?
  - Going back to event listeners, take note that the `onclick` value can be overwritten.
- If you change this just a little bit using a pattern called _closure_, you can protect the variable `counter`.
  - First, use the IIFE pattern seen earlier, that has an anonymous function run inside of it.
  - Move the counter variable inside our IIFE function, and by enclosing the counter variable in this function, it becomes local and uneditable by other code.
  - Remember scope flows down and can only inherited variables from their parents.

```javascript
const cardClick = (function (e) {
  let counter = 0;
  return function (e) {
    e.currentTarget.classList.toggle("flip_card");
    e.currentTarget.classList.toggle("slide_over");
    e.currentTarget.style.zIndex = counter;
    counter++;
  };
})();
```

## Propagation

- A problem with HTML buttons is that they don't float in space.
  - Instead the DOM is more like an aquarium. You can't move through it without touching other elements.
- Another problem is that _any_ of those things can have a click listener.
  - And on your way "down" to the button you could be clicking through containing divs, and other elements.
- Why do we even need propagation? Surely this is a design flaw, right? Why would I need everything in the DOM to receive my clicks?
  - It is intentional, and it actually can help us.
- For example: If you click on a card where we add the event listener everything is fine. But what happens when you click on the middle of the card?
  - You're actually clicking on the child of the card container so you need that child to bubble up, and let the card container know there was a click.
  - To add to the complexity, the event click has two phases: There's a capture phase, and a bubble phase. By default, the bubble phase is listening, and the capture is off. You can change this with event listeners, but only if you have a good reason to do so.
- But what if one of our children elements is also clickable? Let's say it's a link to learn more on a topic. Let's add one:

```javascript
let learnMore = document.createElement("a");
learnMore.text = "Learn More!";
learnMore.href = this.data.link;
learnMore.target = "_blank";
learnMore.addEventListener("click", function (e) {
  // Stop the card from flipping over when
  // you open a link in the child container:
  e.stopPropagation();
});
backValDiv.appendChild(learnMore);
```

- Why not just stop propagation to all the events?
  - Any time you're writing code that's a generic fix to the way a language works should be a red flag.
  - One example of where this would be a problem is let's say your UI department decides that they want to add event listeners to trigger analytics, or use tracking.
- By preventing propagation you may interfere with that code. So the general rule of thumb is only stop propagation when you have a really good reason to.

### Discard Pile

- The discard pile will have two divs. And, similar to our card, we'll need to use absolute positioning.
  - As a quick review of absolute positioning, remember, unless it has a parent that is set to relative, the containing div will float out to the next nearest relative item, which might be the top left of the screen and you don't want that.
- You're going to first add some rules to the game that will tell us how many discard piles we need.
  - In a flashcard game, we're really only going to need just the one. But in a game like solitaire, you'll need two rows: One of four and one of seven.

```javascript
this.rules = {
  discardRow: [
    {
      name: " Got it!",
      droppable: true,
      maxCards: this.deck_div.children.length,
      piles: 1,
    },
  ],
  gameComplete: function () {
    cardAmount = e.currentTarget.childNodes.length;
    discardAmount = this.discardRow[0].maxCards;
    if (cardAmount === discardAmount) {
      console.log("You win!");
    }
  },
};
```

```javascript
this.buildDiscard = function () {
  for (let i = this.rules.length - 1; i >= 0; i--) {
    let zone = document.createElement("div");
    zone.className = "zone-row";
    let discardRule = this.rules.discardRow[i];
    let x = 0;
    while (x < discardRule.piles) {
      let discardObj = new DiscardPile();
      discardObj.name = discardRule.name;
      discardObj.droppable = discardRule.droppable;
      discardObj.id = "pile-" + x;
      let buildObj = discardObj.init();
      zone.appendChild(buildObj);
      x++;
    }
    this.el.appendChild(zone);
  }
};
```

### Drag-and-Drop

- To work on the drag and drop, there are a couple of concepts that need to be understood first.
- You have two items: the item dragging and the destination.
  - The first step will be to set the draggable to true on the dragging item and then we're going to use the `onDragStart` event.
  - You're doing this because `onDragStart` will allow you to use `dataTransfer`.
- Use `dataTransfer` to pass the ID from the item that you're dragging to the destination, as `onDrag` doesn't allow this.
  - On the destination target we're going to use an `onDrop` event and a `dragOver` event.

```javascript
this.cardContainer.draggable = true;
this.cardContainer.ondragstart = cardDrag;
// ...
function cardDrag(e) {
  e.dataTransfer.setData("text/plain", e.currentTarget.id);
}
```

- You wouldn't normally add 'e.preveentDefault()` unless you had a good reason.
- But in this case, most areas of a webpage are not valid places to drop data.

```javascript
holderTarget.ondragover = function (e) {
  e.preventDefault();
};
holderTarget.ondrop = this.cardDrop;
```

```javascript
DiscardPile.prototype.cardDrop = function (e) {
  // Will get the string for the ID passed in:
  let cardID = e.dataTransfer.getData("text/plain");
  let cardDragging = document.getElementById(cardID);
  cardDragging.style.top = "0px";
  cardDragging.style.left = "0px";
  e.currentTarget.appendChild(cardDragging);
};
```
