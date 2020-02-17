// Choose Your Own Adventure! //
//   A Dark, Stormy Night.    //


	// Check if the user is ready to play
confirm("Are you ready to play?")


	// Verifying the age of the user
age = prompt("What's your age?")
 
if (age <= 13)
    confirm("You're allowed to play, but I take no responsiblity.")
else
    confirm("Play on!")


    // The adventure begins
confirm("You are walking down a dark alley alone.")
confirm("It's cloudy. There are no stars out.")
confirm("You're beginning to rush home, a bit frightened.")
confirm("Suddenly, a man stops you in your tracks.")


	// Conflict!
confirm("He asks you if you want to go on an adventure.")
userAnswer = prompt("Do you want to go on an adventure?")
    
	//Obtain user input to branch story paths
	//To-Do: Find a way to use RegExp to allow wildcard expression
if (userAnswer === "yes") {
    confirm("He grins and takes you by the hand to an unknown red door.")
} else {
    confirm("He frowns and shakes his head. You go home.")
}

	//To-Do: Write more
confirm("...To be continued!")


	//Feedback prompt
feedback = prompt("Rate my game out of 10 please.")
 
if (feedback >= 8) {
    confirm("Thank you! We should travel through more red doors!")
} else {
    confirm("Sorry! I'll keep practicing coding and writing.")
}