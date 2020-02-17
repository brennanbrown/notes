            // Abstract //
// Each 'cake' takes in a different input.
// But the 'bake' instructions are always the same.


    // Let's begin!
confirm("Let's find out how long your cake should bake for!")

    // Asking the user for temperature input in celsius
    // assuming they are Canadian.
celsius = prompt("What temperature are you baking the cake at? (C°)")

    // A simple conversion is done.
fahrenheit = (celsius * (9 / 5) + 32)

    // Informing the user of the converted temperature.
console.log ("You're going to be cooking at " + fahrenheit + "F° !");

    // Then asking the user for basic cake ingredients
flour = prompt("How many cups of flour will be needed?")
sugar = prompt("How many cups of sugar will be needed?")
eggs = prompt("How many eggs will be needed?")

    // Converting their input to number format and add them all up,
    // the way you add them all up in a batter.
var ingredients = Number(flour) + Number(sugar) + Number(eggs)

    // Then creating a new variable which adds the ingredients 
    // and temperature together, like putting it in the oven.
var baketime = (ingredients + fahrenheit) / 25

    // Finally giving the user the output of the amount of time
    // needed until they can eat yummy cake!
console.log("Wow! looks like your cake is going to take " + baketime + " minutes to finish!")


// DISCLAIMER:
// I am not a chef.
// Praticial use of baking formula may result in stomachaches or
// the unintended arson of cherished loved ones in the kitchen.