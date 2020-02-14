# Programming Foundations: Design Patterns


## Table of Contents
<!-- MarkdownTOC -->

- Design Patterns Overview
- The Strategy Pattern \(Behavioral\)
    - Limitations of Inheritance
    - Limitations of Interfaces
    - Programming to an Interface
    - Applying the Principles
    - Has-A vs. Is-A
    - Example Code
- Factory Method \(Creational\)
    - Example Code
- Adapter Pattern \(Structural\)
    - Example Code
- Decorator Pattern \(Structural\)
    - Example Code
- Observer Pattern \(Structural\)
    - Example Code
- Iterator Pattern
    - Responsibility
    - Example Code

<!-- /MarkdownTOC -->


* Don't reinvent the wheel -- There are already patterns that are flexible, extensive, maintainable, easier to communicate with teammates.
	- Developers have already come up with a solution to your problem.
	- These solutions are also resilient to change by preparing for future editions.


## Design Patterns Overview

* Object-oriented principles:
	- Inheritance
	- Polymorphism
	- Abstraction
	- Encapsulation 
* Design patterns provide a path to solutions to object-oriented design conundrums that go outside of the basic object-oriented principles.
	- The originate from the book **Design Patterms: Elements of Resuable Object-Oriented Software Design**, which consisted of 23 different patterns separated into the groups of *creational*, *structurual*, and *behavioral*.
* Design patterns are about **design experience**. They are not algorithms and they are not code.
	- A patter is usually expressed by a definition, a class diagram, and collected into a catalouge of patterns.
	- In these catalouges, you'll find example scenarios when the pattern would be applicable, its consequences, and sample code.
* Design patterns are agnostic in nature, meaning they can be applied to any situation that requires them, regardless of language or use case.
* **Design Principles** go beyond basic object-oriented principles, with ideas such as *single-responsibility*, *open-closed*, *loose coupling*, *interface programming*, *compositional priority*, *variance encapsulation*.
	- While they do share a common goal, principles are general guidelines and designs are specific solutions.
	- Strive for particular qualities.

## The Strategy Pattern (Behavioral)

The Strategy Patterns defines a family of algorithms, encapsulates each one, and makes them interchangeable. This lets the algorithm vary independently from clients that utilize them.

### Limitations of Inheritance

* **Inheritance** allows for the ability to express `class` relationships that allow you to reuse and extend the behavior and properties of other classes.
	- Eg. they share a `is-a` relationship.
* At the same time, it's easy to overuse inheritance and apply superclasses to every class.
	- To be able to plan for the possibilities of edge cases and feature requests, subclasses will have to override the methods from the superclass that aren't applicable, causing bloat (duplication) and rigidity in code.
	- Runtime behavior changes are difficult because behavior is assigned at compile time.
	- The superclass also provides little explanation about what each concrete subclass actually does. 

### Limitations of Interfaces

* An **interface** defines the methods an object must have in order to be considered a particular type.
	- This means interfaces allow similar classes to share similarities. Not all classes need the same behavior, however. 
	- They are an abstract type that specifies a behavior that classes must implement.
- Unfortunately, using interfaces to solve inheritance problems causes the inability of code reuse by having each subclass implement its own methods.
	- This also doesn't allow for runtime changes in behavior. 

### Programming to an Interface

* Recall the principle, *encapsulate what varies*, which is to identify the aspects of your application that vary and separate them from what stays the same.
	- If some aspect of your code is changing, that's a sign you should pullhese it out and separate it. 
	- By separating out the parts of the code that change, you can extend or alter them without affecting the rest of the code.
	- This priciple is fundamental to many design patterns.
* *Program to an interface (supertype), not an implementation*.
	- Clients remain unaware of the specific types of ojects they use, as long as the objects adhere to the interface that clients expect.

### Applying the Principles

* In order to separate what varies, move the implementations of flexible methods out of the superclass, and transfer them to an interface for each one, as `MethodBehavior` being the name of the new **(algorithm)** interface.
	- Eg. the `QuackBehavior` interface would have a `Quack`, `Squeak`, and `Mute` subclass as concrete implementations.
	- You then re-add the behaviors as a reference in the original superclass, eg. `FlyBehavior flyBehavior` which will hold references to concrete instances of methods. 
	- This would be followed by adding `setFlyBehavior()` and `performFly()`.`
* There's an inheritance hierarchy that defines the type of the objects that need a behavior, and a `has-a` relationship between objects and their behaviors.
	- These behaviors can be anything--any algorithm that an object might need to perform.
	- By moving these algorithms out from the main inheritance hierarchy, there is the new benefit of being able to choose which algorithm each object gets.
	- These algorithms can be changed at run time, and if multiple objects use the same algorithm there is the benefit of code reuse as well.

### Has-A vs. Is-A

* A `has-a` relationship is being used for each duck that has a `FlyBehavior` and a `QuackBehavior`
* Whereas a `is-a` relationship in one of inheritance, a `has-a` relationship is one of composition.
	- Eg. A Mallard *is a* Duck vs. A duck *has a* fly behavior.
* When putting two classes together with composition, instead of inheriting behavior, an object can then instead delegate that behavior to the composed object, resulting in more flexible design. 
* Classes should achieve code reuse using composition rather than inheritance from a superclass.
* With inheritance, in the old design, there was a lock into compile-time decisions about behavior.
	- Eg. A duck only had one way to fly.
	- With composition, each duck has a fly behavior, rather than limiting to one specific *implementation* of that behavior. 


### Example Code

```java

// Example of the Strategy Pattern

// The Duck Superclass //
public abstract class Duck {
	// Using the interface types so any flying/quacking
	// behavior can be stored and used.
	FlyBehavior flyBehavior;
	QuackBehavior quackBehavior;
	abstract void display();
	public Duck() { }
	public void performFly() {
		flyBehavior.fly();
	}
	public void performQuack() {
		quackBehavior.quack();
	}
	// All ducks are capable of swimming.
	public void swim() {
		System.out.println("All ducks can float, even decoys.")
	}
}

// The Mallard Subclass //
public class MallardDuck extends Duck {

	public MallardDuck() {
		flyBehavior = new Fly();
		quackBehavior = new Quack();
	}

	public void display() {
		System.out.println("I'm a Mallard duck!")
	}
}

// The Concrete Fuck
public class MiniDuckSimulator {
	public static void main(String[] args) {
		Duck mallard = new MallardDuck();
		mallard.perform()Fly;
		mallard.performQuack();
	}
}

// Fly Behavior implementation (regular flying)
public class FlyWithWings implements FlyBehavior {
	public void fly() {
		System.out.println("I'm flying!");
	}
}

// Fly Behavior implementation (unable to fly)
public class FlyNoWay implements FlyBehavior {
	public void fly() {
		System.out.println("I can't fly!");
	}
}

// Quack Behavior implementation (regular quacking)
public class Quack implements QuackBehavior {
	public void quack() {
		System.out.println("Quack!");
	}
}

// Quack Behavior implementation (unable to quack)
public class Squeak implements QuackBehavior {
	public void quack() {
		System.out.println("Squeak!");
	}
}

```

## Factory Method (Creational)

* A factory method is intended for the sole intention of creating an object, allowing for the decoupling of the process of creating objects from the clients that use those objects.
* The Factory Method Pattern defines an interface for creating an object, but lets subclasses decide which class to instantiate. Factory Method lets a class defer instantiation to subclasses.

### Example Code

```java
/*
// FACTORY METHOD //
*/

// Non-encapsulated, Non-factory Example
Pizza orderPizza(String type) {
    Pizza pizza;

    // Inflexible code, not allowing
    // for changes at runtime.
    if (type.equals("cheese")) {
        pizza = new CheesePizza();
    } else if (type.equals("greek")) {
        pizza = new GreekPizza();
    } else if (type.equals("pepperoni")) {
        pizze = new PepperoniPizza();
    }

    pizza.prepare();
    pizza.cook();

    return pizza;

}

// Factory Method
public class SimplePizzaFactory {
    public Pizza createPizza(String type) {
        Pizza pizza = null;
        if (type.equals("cheese")) {
            pizza = new CheesePizza();
        } else if (type.equals("greek")) {
            pizza = new GreekPizza();
        } else if (type.equals("pepperoni")) {
            pizza = new PepperoniPizza();
        }

        return pizza;
    }
}

// Encapsulated, Factory Example
Pizza orderPizza(String type) {
    Pizza pizza = factory.createPizza(type);

    pizza.prepare();
    pizza.cook();

    return pizza;

}
```

## Adapter Pattern (Structural)

The adapter pattern converts the interface of a class into another interface that clients expect. It allows classes to work together that couldn't otherwise because of incompatible interfaces.

* If you decide to switch your vendor class, the interface will no longer work properly with your system.
	- A solution to this is the *adapter class*, which implements the existing interface, and then communicates to the vendor's class to carry out requests, which requires zero code change from either the vendor or your system.
* The client will make a `request()` to the adapter, by calling the request method, which is part of the target interface.
	- Next the adapter translates that call into the equivalent call on the adaptee using the `translatedRequest()` function.
	- After the adaptee call is complete, the adapter then returns the results (if any) to the client.
	- The client receives the results of the call, without being aware that the adapter's translates the calls on to the adaptee's interface at its request.
* Similar to the strategy pattern, adapters use the `has-a` composition relationship.
	- The client is composed with the class that has the target interface.
	- The adapter is composed with the adaptee.
	- The adapter delegates calls to the adaptee, and returns any needed values.
* The advantage to the adapter pattern is that the client and the adaptee don't know there's an adapter in-between, meaning no modifications are needed.
* The duck simulator tests ducks using the `Duck` interface, whereas turkeys have a different interface altogether.
	- Thus `turkey.quack()` will not compile.

### Example Code

```java

public class DuckSimulator {
    public static void main(String[] args) {
        // Tests Duck
        Duck duck = new Mallard();
        testDuck(duck);
        // Tests an adapted Turkey
        Turkey turkey = new WildTurkey();
        Duck turkeyAdapter = new TurkeyAdapter(turkey);
        testDuck(turkeyAdapter)
        // Tests an adapted Drone
        Drone drone = new SuperDrone();
        Duck droneAdapter = new DroneAdapter(drone);
        testDuck(droneAdapter);
    }

    static void main testDuck(Duck, duck) {
        duck.quack();
        duck.fly();
    }
}

public interface Duck {
    public void quack();
    public void fly();
}

public class MallardDuck implements Duck {
    // Implements a Mallard Duck.
}

// Turkey
public interface Turkey {
    public void gobble();
    public void fly();
}
public class WildTurkey implements Turkey {
    // Impements a Wild Turkey.
}


// Turkey Adapter
public class TurkeyAdapter implements Duck {
    Turkey turkey; 
    public TurkeyAdapter(Turkey turkey) {
        this.turkey = turkey;
    }
    // Duck's quack method delegates 
    // to the turkey's gobble method.
    public void quack() {
        turkey.gobble();
    }
    public void fly() {
        for(int i=0; i<5; i++) {
            turkey.fly();
        }
    }
}

// Drone
public interface Drone {
    public void beep();
    public void spin_rotors();
    public void take_off();
}
public class SuperDrone implements Drone {
    public void beep() {
        System.out.ln("Beep beep beep!");
    }
    public void spin_rotos() {
        System.out.println("Rotors are now spinning.");
    }
    public void take_off(); {
        System.out.println("Taking off now.");
    }
}


// Drone Adapter
public class DroneAdapter implements Duck {
    Drone drone;
    public DroneAdapter(Drone drone) {
        this.drone = drone;
    }
    // Duck's quack method delegates 
    // to the drone's beeping method.
    public void quack() {
        drone.beep();
    }
    public void fly() {
        drone.spin_rotors();
        drone.take_off();
    }
}

```

## Decorator Pattern (Structural)

The Decorator Pattern attaches additional responsibilities to an object dynamically. Decorators provide a flexible alternative to sub-classing for extending functionality. 

* Imagine a coffee shop that serves and takes payments for beverages.
	- The shop has four main types of drinks, each with a description and cost.
	- And to each beverage, you can add a number of condiments, each has a small cost with needs to be added to the drink. 
* In this scenario, a possibility is that each drink would be a subclass of the beverage superclass, and each variety and combination of condiments on each drink would be a subclass of each drink, resulting in far too many classes.
	- Alternatively, add the properties within the superclass to track condiments in order with boolean methods. However, any prices changes would affect every single class, resulting in code fragility. 
* The Open-Closed Principle dictates that classes should be open for extension of behavior, but closed for modification. 
	- In other words, new code could be added, but existing code shouldn't have to be changed.
	- The goal being the ability to easily augment what already exists without modifying anything.
* Despite its power, inheritance leads to inflexible design--all classes inherit the same behavior. 
	- Composition can still 'inherit' behavior, but also allow for dynamic runtime behaviors, and adding new behaviors without altering existing code.
* Decorators mirror the type of the object they're decorating (being composed with), as well as their methods.
	- In this case, each decorator would add the their own cost in their own version of the `cost()` method.
* There are two important aspects to the decorator pattern, there are the *components*, which are the beverages in this example and the *decorators*, which are the condiments in this example.
    - There is a `Component` class, that's implemented by `ConcreteComponent` subclasses, and the `Decorator` abstract classes also implement the `Component`. 
        + This allows the ability to treat each class in the identical manner. In other words, any decorator will be able to wrap around any component.
    - The `ConcreteDecorator` classes will then implement the `Decorator` class.
    - This allows for condiments to be wrapped around already decorated coffees.

### Example Code 

```java
/*
// DECORATOR PATTERN //
*/


// Abstract Component
public abstract class Beverage {
    String description = "Current Unknown Beverage";

    public String getDescription() {
        return description;
    }

    public abstract double cost();
}


// Concrete Component
public class DarkRoast extends Beverage {
    public DarkRoast() {
        description = "Dark Roast Coffee";
    }

    public double cost() {
        return 1.99;
    }
}

// Abstract Decorator
public abstract class CondimentDecorator extends Beverage {
    public abstract String getDescription();
}

// Concrete Decorator
public class Whip extends CondimentDecorator {
    Beverage beverage;

    public Whip(Beverage beverage) {
        this.beverage = beverage;
    }

    public String getDescription() {
        return beverage.getDescription() + ", and Whip";
    }

    public double cost() {
        return beverage.cost() + .25;
    }
}

// Concrete Decorator
public class Mocha extends CondimentDecorator {
    Beverage beverage;

    public Mocha(Beverage beverage) {
        this.beverage = beverage;
    }

    public String getDescription() {
        return beverage.getDescription() + ", and Mocha";
    }

    public double cost() {
        return beverage.cost() + .35;
    }
}

// Implemented Class
public class StarbuzzCoffee {

    public static void main(String args[]) {
        // Creates the dark roast coffee instance.
        // Store the beverage in variable type beverage.
        Beverage beverage = new DarkRoast();
        // Pass beverage to the mocha constructor
        // in order to create a mocha decorator.
        // This is also stored in the variable type beverage,
        // so the program can continue to decorate the type.
        beverage = new Mocha(beverage);
        // Repeat the above process in order to
        // create a double-Mocha decorator.
        beverage = new Mocha(beverage);
        beverage = new Whip(beverage);
        // Each decorator delegates to the beverage
        // that it's wrapping to get the description
        // as well as cost.
        System.out.println(beverage.getDescription()
            + " $" + beverage.cost());
    }
}
```

## Observer Pattern (Structural)

The Observer Pattern defines a one-to-many dependency between objects so that when one object changes state, all of its dependents are notified and updated automatically. 

* The Observer Pattern exemplifies the design principle of loose coupling, which is defined as striving for loosely coupled designed between objects that interact. 
	- Loosely-coupled objects are defined as objects that interact with one another, but don't know a lot about each other.
	- Objects don't become too dependent on each other, making the design of the program more flexible.
* Eg. A publisher (Subject) creates a newspaper (Dependent/Observer) and begins publishing it, you (and/or others) then subscribe to the newspaper, and as long as you stay subscribed you receive each issue. 
	- Any object can send a request to the `publisher` object, when the request is received, the requesting object immediately becomes a subscriber, and can likewise send a request to unsubscribe anytime.
	- The publisher typically holds some data of interest, like stocks, weather, or any type of data structure. When the data changes, all the subscribers are notified. 
* It can be said that the subjects and observers are loosely-coupled, because while they interact, they have little knowledge of each other.
	- The subject only knows that the observer implements a specific interface.
	- However, the subject doesn't need to know the concerete class of observers.
	- All the subject knows is that it has a list of objects that implement the observer interface.
	- Observers are free to add or remove themselves at any time.
	- The subject doesn't care about the observers, and keeps doing its job regardless.
	- Because changes to either the subject or the observer code doesn't affect one another, it can be defined as true loose coupling.

### Example Code

```java
/*
// OBSERVER PATTERN //
*/

// Subject Class
public interface Subject{ 
    public void registerObserver(Observer o);
    public void removeObserver( Observer o);
    public void notifyObserver();
}


// Concrete Subject Class
public class SimpleSubject implements Subject {
    private ArrayList<Observer> observers;
    private int value = 0;
    public SimpleSubject() {
        observers = new ArrayList<Observer>();
    }

    public void registerObserver(Observer o) {
        // ... Add Observer to the list.
    }

    public void removeObserver(Observer o) {
        // ... Remove Oberserver from the list.
    }

    public void notifyObservers() {
        for (Observer observer : observers) {
            observer.update(value);
        }
    }

    public void setValue(int value) {
        this.value = value;
        notifyObservers();
    }
}


// Observer Class
public interface Observer {
    public void update(int value);
}


// Concrete Observer Class
public class SimpleObserver implements Observer {
    private int value;
    private Subject SimpleSubject;

    public SimpleObserver(Subject simpleSubject) {
        this.simpleSubject = simpleSubject;
        simpleSubject.registerObserver(this);
    }

    public void update(int value) {
        this.value = value;
        display();
    }

    public void display() {
        System.out.println("Value: " + value);
    }
}

// Weather Station Example //

// Subject Class
public interface Subject{ 
    public void registerObserver(Observer o);
    public void removeObserver( Observer o);
    public void notifyObserver();
}


// Concrete Weather Station Class
public class WeatherStation implements Subject {
    private ArrayList<Observer> observers;
    private int value = 0;
    public SimpleSubject() {
        observers = new ArrayList<Observer>();
    }

    public void registerObserver(Observer o) {
        // ... Add Observer to the list.
    }

    public void removeObserver(Observer o) {
        // ... Remove Oberserver from the list.
    }

    public void notifyObservers() {
        for (Observer observer : observers) {
            observer.update(temperature);
            observer.update(windSpeed);
            observer.update(pressure);
        }
    }

    public void setValue(int temperature, int windSpeed, int pressure) {
        this.temperature = temperature;
        this.windSpeed = windSpeed;
        this.pressure = pressure;
        notifyObservers();
    }
}


// Observer Class
public interface Observer {
    public void update(int temperature);
    public void update(int windSpeed);
    public void update(int pressure);
}


// Concrete UserInterface Class
public class UserInterface implements Observer {
    private int value;
    private Subject UserInterface;

    public UserInterface(Subject UserInterface) {
        this.UserInterface = UserInterface;
        UserInterface.registerObserver(this);
    }

    public void update(int temperature, int windSpeed, int pressure) {
        this.temperature = temperature;
        this.windSpeed = windSpeed;
        this.pressure = pressure;
        display();
    }

    public void display() {
        System.out.println("Current Temperature: " + temperature);
        System.out.println("Current Wind Speed: " + windSpeed + "MpH");
        System.out.println("Current Temperature: " + pressure + "KPa");
    }
}
```

## Iterator Pattern

* The Iterator Pattern proves a way to access the elements of an *aggregate object* sequentially without exposing its underlying representation. 
* What is an aggregate object? It essentially is just an object that is a collection of objects, like an `Array`, or the Java Collection class `ArrayList`, there's also lists, sets, maps, dictionaries, etc.
    - But the program needs to be able to access its elements without having to know exactly *how* the aggregate is implemented.
    - To accomplish this, the aggregate object provides an iterator object.
    - The iterator object knows how to iterate over the aggregate.
    - But the client that's using the aggregator doesn't need to know the details, it just has to know how to ask for, and how to use the iterator. 

**To Iterate Over an Aggregrate Object:**

1. Ask the Object for its iterator.
2. Use the iterator to iterate through the items in the aggregate.
3. Iteration code now works with any kid of aggregate object.

* There are many ways to store collections of objects in data structures.
    - Eg. Most modern programming provide arrays.
* In Java, you could store menu items for a menu in an array like so:

```java
// Example of Iteration Responsibilities 

String[] menuItems = new String[MAX_ITEMS];
menuItems[0] = "Regular Pancake Breakfast";
menuItems[1] = "Blueberry Pancakes";

public void print(items) {
    for (int i; i < items.length; i++) {
        Strimg item = items[i];
        // ... Print the items
    }
}

ArrayList<String> menuItems = new ArrayList<String>();
menuItems.add("Regular Pancake Breakfast");
menuItems.add("Blueberry Pancakes");

// The code for the method has to be rewritten
// if the type of the list changes.
public void print(items) {
    for (int i; i < items.size; i++) {
        String item = items.get(i);
        // ... Print the items.
    }
}
```

* These are two different implementations of a menu, one using an `Array` and the other using an `ArrayList`.
    - That means that the class responsible for printing the menus, the `Cafe`, needs two different methods of iterating through each one.
    - The two menus are exposing the details of they're implemented to the cafe, which means the cafe is dependent on those implementations.
* Each menu will implement a menu interface that specifies a create iterator method.
* Java's collections classes all come with built-in iterator interfaces, `java.util.iterator`, which can be used instead of building one from scratch.
    - Use the `iterator()` method to get the iterator for any collection class, including `ArrayList`.
* However, Java arrays *don't* have built-in iterators the same way.

```java
// Enhanced-For Statement
for (Animal a : animals) {
    a.describe();
    a.makeSound();
}
```

### Responsibility

* The **Single-Responsibility** principle states that each class should only have one reason to change.
* For every responsibility a class has, the higher the chance of change in the future.
* By giving a class multiple responsibilities, it will have multiple areas of potential change--and change is to be minimized as much as possible.
* If you were to allow a class to handle both the responsibilities of managing a collection, and managing the iteration, then there are two areas of potential change.
    - This is why you separate the iteration responsibility into its own class. 
* It is important to be mindful that we naturally want to combine things and find commonality, rather than differences.
    - Examine your designs diligently for multiple responsibilities--and separate into new classes if possible. 

### Example Code

```java
/*
// DECORATOR PATTERN //
*/

// This method creates an iterator for the menu and returns it.
public class DinerMenu implements Menu {
    // ...

    public Iterator<MenuItem> createIterator() {
        return new DinerMenuIterator(menuItems);
    }
}

public class DinerMenuIterator implements Iterator<MenuItem> {
    MenuItem[] list;
    int position = 0;
    
    public DinerMenuIterator(MenuItems[] list) {
        this.list = list;
    }

    public MenuItem next() {
        // Increment the position.
        // Return the next item.
    }

    public boolean hasNext() {
        // Checks if there are items left in the array.
    }

}

public class Cafe {
    Menu pancakeHouseMenu;
    Menu dinerMenu;

    public Cafe(Menu pancakeHouseMenu, Menu dinerMenu) {
        this.pancakeHouseMenu = pancakeHouseMenu;
        this.dinerMenu = dinerMenu;
    }

    public void printMenu(Iterator<MenuItem> iterator) {
        while (iterator.hasNext()) {
            MenuItem menuItem = iterator.next();
            // Print the menu.
        }
    }

    // ,,,
}
```
