# Python Technical Interview

**Table of Contents:**

- [Python Technical Interview](#python-technical-interview)
- [Soft Skills](#soft-skills)
  - [Personal Skills](#personal-skills)
  - [Non-technical Skills](#non-technical-skills)
  - [Interview Process](#interview-process)
- [Technical Skills](#technical-skills)
  - [Collections](#collections)
  - [Time Complexity](#time-complexity)

# Soft Skills

## Personal Skills

* In addition to your technical skills, there are some personal qualities your interviewers are going to be looking for to try to figure out if you're going to be a good addition to the team. 
* The qualities that are arguably most important to demonstrate to your interviewers are: emotional intelligence, intellectual maturity, curiosity, perseverance, and confidence.
* Emotional intelligence is your ability to respond appropriately to questions, engage in meaningful conversations, feel empathy and show kindness. 
    - A very small example would be welcoming someone back to the office after they had been out sick for a week and asking how they're doing. 
    - Emotional intelligence is very important in a well-functioning team. 
* Intellectual maturity appears when you ask meaningful questions, when you seek to understand problems or perspectives, and when you can adequately articulate your thought process to your colleagues. 
    - Intellectual maturity is really important especially for software engineers who spend a lot of their time asking questions to better understand problems. 
* Curiosity is a desire and passion to know more, maybe a desire to understand how something works or the desire to explore something new. 
    - Curiosity is a valued trait among engineers because it's the precursor to innovation. And because software engineers are almost always working on products that really push society forward, curiosity is hugely important. 
* Perseverance is the ability to stick with something even when it's difficult and to see it through to completion. 
    - You've probably experienced how important this is for software engineers. Without it, we'd walk away from bugs in our code all the time and just leave them sitting there. 
* Lastly, confidence is the feeling that you can rely on yourself. People want to work with other people who know what they're doing or who have the self-belief to know that they could figure things out. 
    - When you interview from a place of strength and capability, it shines through as confidence and it's awesome. 
* Remember: Your interpersonal skills are just as important as your technical skills and all of your interviewers are going to be looking for these too. 

## Non-technical Skills

* The nontechnical skills that are arguably most important to demonstrate to your interviewers are: Problem-solving ability, asking good questions, understanding your own assumptions about a problem, understanding constraints, and your ability to collaborate.
* Problem-solving ability is an umbrella term you hear a lot in the tech industry. Given that software engineers need to figure out how to do things with code for a living, being able to solve problems is really important. 
    - Generally, what people mean when they say they want to hire someone who is a good problem solver, is that they want to hire someone who can use what they already know, whether they obtain that through school, reading, or experience, to accomplish something specific in the workplace that may not be well-defined. 
    - One way to demonstrate your problem-solving ability or to try to get better at solving problems is to start by asking good questions about the problem itself. 
* This brings us to our second point, which is asking good questions. Good questions have a number of qualities. 
    - They should be specific, they should let the person you're asking know what you already know so that the other person can build on top of that, and good questions should also be asked of the right person. 
    - This means the person who can answer my question the best, who is also the least busy. Sometimes the process of asking questions to try to better understand a problem uncovers some unconscious assumptions you are making about the problem itself. 
* Understanding your assumptions is a really important skill, because if you're unaware that you're bringing biases or expectations into a solution, the solution may wind up not solving the problem or doing the task effectively. 
    - Similarly to understanding your assumptions, the skill of identifying and understanding constraints of a problem is also something engineering managers are looking for in their team mates. 
    - A team whose engineers know what their boundaries and limitations are, won't spend time trying to come up with solutions that aren't feasible or that are ineffective. In the end, this saves everyone time and time is money. 
* Finally, there's collaboration. This is another word I see used a lot in job ads and I hear engineers say all the time that they love collaborating with their team. 
    - Collaboration may be something you're innately good at, or not, but it is a skill you can develop. 
    - If you're a good collaborator, it means you're skilled at both listening to others' ideas and questions and sharing your own ideas and questions. 
    - It means you work with a partner or a group effectively toward a shared goal and that you do so with respect, even if you disagree.

## Interview Process

* If you're preparing to interview for your first software engineering role or if you haven't interviewed in a while you may not be familiar with the steps in the technical interview process. 
    -  There are a variety of ways and opportunities to show your skills throughout this whole process. 
    -  Interviewing is a skill and you can get better at it if you practice just like any other skill. 
* The interview sequence almost always starts with a 30 minute call with a recruiter. 
    - You'll be asked the usual phone screen questions such as why you're looking for a new job, what languages and frameworks you know, what you've been working on lately, and so forth. 
* If that goes well you'll be asked to schedule a 30 to 60 minute technical phone screen with an engineer. 
    - This usually involves sharing your screen or using a web-based code editor and doing some live coding with the interviewer. 
    - Live coding is the process of using a web-based text editor or a command-line tool so you can demonstrate your problem-solving and coding abilities to your interviewer. 
* If the technical phone screen goes well, you'll probably receive some kind of programming assignment or assessment to complete at home and submit within a week or so. 
    - A take-home assessment is a self-contained project that's designed to take you several hours or several days depending on the employer to complete. 
    - The purpose of a take-home assessment is to give you time and space to demonstrate your best work. 
* If the hiring manager likes what you submitted, you'll be asked to come in for an onsite interview. 
    - These usually last at least a few hours and you'll likely meet with several different people. 
    - During an onsite interview is when you'll do whiteboarding or paired programming. 
    - Some people get really nervous about whiteboading, but whiteboarding is simply the process of using the whiteboard or a piece of paper to address a coding challenge. 
    - This allows you to demonstrate your problem-solving abilities and your coding abilities at the same time. 
    - Pair programming is very similar to whiteboarding but you're collaboratively solving a problem with another person using code on your laptop whether in person or remotely. 

# Technical Skills

## Collections

* Collections are a fundamental way to store and organize your data. 
* Since collections form the basis of so many coding challenges, you should be able to compare and contrast them readily and it would be really helpful if you had several built-in methods memorized for each data type. 
    - If you can understand the runtimes of those built-in methods, even better.
* For **Tuples**, the syntax for tuples looks like this: `(2, 3, 'muffins', 'plates')
    -  Tuples are immutable, meaning you can't change the data inside them once you create them. 
    - They're ordered and also iterable. So you can loop over them and index into them in linear time. 
    - Because of these characteristics, tuples are a great data type to use when you want to store data that you don't want to be changed later. 
    - Be sure you know how to index into a tuple and find the length of a tuple. `
    - A couple other handy built-in methods are count and index. 
* **Lists** are very similar to tuples in that they store an ordered collection of items with syntax like this. 
    - They are mutable, meaning you can change the data inside them and they're also ordered. 
    - You can iterate over a list in linear time just like you can with a tuple. 
    - The mutability of lists makes them a good choice when you want to store data that may need to change later. 
    - In addition to indexing into a list, and finding its length, some built-in methods you'll want to have in your mind are append and insert which help you get items into a list. 
    - Pop and remove, which help you get items out of a list and the reverse and sort methods are also really handy during coding challenges. 
* **Dictionaries** store data in key value pairs with syntax, unlike tuples and lists, which store data in a linear sequence,  like this: 
    - Dictionaries are mutable just like lists and you can iterate over a dictionary's keys, values or key value pairs. 
    - This makes them a great data type choice in coding challenges that require you to keep track of several pieces of related information at once, like the example here where we have some quantity, in this case five, related to some thing, in this case cupcakes. 
    - Up until Python 3.7, dictionaries did not preserve order. However, as of Python 3.7, dictionaries do store their key value pairs in the order in which new keys were added to the dictionary. 
    - This is another really powerful new feature about dictionaries. 
    - You'll definitely need to know how to access values in a dictionary by specifying their keys like this: 
    - You'll also want to know the keys, values and items method that allow you to access keys, values, and key value pairs respectively. 
    - If you need to remove a key value pair from a dictionary, you can do that with the pop method or with the `del` key word which stands for delete. 
* Last is **Sets**. Sets are really cool, they are super fast and mutable like dictionaries but they only hold unique values, not key value pairs. 
    - You can think of them kind of like a combination between lists and dictionaries. 
    - Sets are mutable so you can change the data that's in them once you've created them but they're unordered, meaning you can't index into them. 
    - You can iterate over sets in constant time too, but they aren't ordered. 
    - All of these characteristics make sets a good choice of data type to use if you're working on a problem that involves unique data and large data sets. 
    - Some useful built-in methods for sets are things like add and update and remove which all of these allow you to alter what's in the set. 
    - And since sets in Python are also representative of mathematical sets, you can call methods like intersection and difference to compare and contrast two sets. 
* Knowing these collections well will save you time in interviews because you won't have to create the built-in methods from scratch or stand there wondering how to work with the info you've been given in a coding challenge. 

## Time Complexity

* Time complexity describes the amount of time it takes to run an algorithm in the worst-case scenario compared to the length of the input. 
    - It can be affected by hardware and the operating system, but we always ignore that when we talk about time complexity. 

You've probably seen a graph something like this. And this graph is showing you a comparison of the various kinds of time complexity: 

<a href="https://ibb.co/sjLGQrH"><img src="https://i.ibb.co/2qXQPBN/time-complex.png" alt="time-complex" border="0"></a>

* The closer the line is to the x-axis, the better the runtime. This is important because we always want our programs to run as fast as possible. 
    - In this graph, which has a logarithmic scale, you can see that the red line, which represents Olog(n), is just about right on the x-axis. 
    - The green line, which is linear time, is right above that. And then O(n)log(n) and O(1). 
* Time matters, especially at scale, and your interviewers are going to be checking to see if you really understand this. 
