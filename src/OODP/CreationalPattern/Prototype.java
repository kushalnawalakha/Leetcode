package OODP.CreationalPattern;

/**
 * Created by kushaln on 4/29/2018.
 */
/*
 It is used when the type of objects to create is determined by a prototypical instance,
  which is cloned to produce new objects. This pattern is used to:
avoid subclasses of an object creator in the client application, like the factory method pattern does.
avoid the inherent cost of creating a new object in the standard way (e.g., using the 'new' keyword)
when it is prohibitively expensive for a given application.

To implement the pattern, declare an abstract base class that specifies a pure virtual clone() method.
Any class that needs a "polymorphic constructor" capability derives itself from the abstract base class, and implements the clone() operation.
The client, instead of writing code that invokes the "new" operator on a hard-coded class name, calls the clone() method on the prototype,
calls a factory method with a parameter designating the particular concrete derived class desired, or invokes the clone()
method through some mechanism provided by another design pattern.

The mitotic division of a cell — resulting in two identical cells — is an example of a prototype
that plays an active role in copying itself and thus, demonstrates the Prototype pattern. When a cell splits,
two cells of identical genotype result. In other words, the cell clones itself

The Prototype design pattern solves problems like:
How can objects be created so that which objects to create can be specified at run-time?
How can dynamically loaded classes be instantiated?

Factory Method: creation through inheritance. Prototype: creation through delegation.
Prototype doesn't require subclassing, but it does require an "initialize" operation. Factory Method requires subclassing, but doesn't require Initialize.
Designs that make heavy use of the Composite and Decorator patterns often can benefit from Prototype as well.
Prototypes are useful when object initialization is expensive, and you anticipate few variations on the initialization parameters. In this context, Prototype can avoid expensive "creation from scratch", and support cheap cloning of a pre-initialized prototype.
Prototype is unique among the other creational patterns in that it doesn't require a class – only an object. Object-oriented languages like Self and Omega that do away with classes completely rely on prototypes for creating new objects.


 */


// Prototype pattern
abstract class Prototype implements Cloneable {
    public Prototype clone() throws CloneNotSupportedException{
        return (Prototype) super.clone();
    }

}

class ConcretePrototype1 extends Prototype {
    @Override
    public Prototype clone() throws CloneNotSupportedException {
        return (ConcretePrototype1)super.clone();
    }
}

class ConcretePrototype2 extends Prototype {
    @Override
    public Prototype clone() throws CloneNotSupportedException {
        return (ConcretePrototype2)super.clone();
    }
}