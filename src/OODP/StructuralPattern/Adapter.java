package OODP.StructuralPattern;

/**
 * Created by kushaln on 4/29/2018.
 */
/*
The Adapter design pattern solves problems like:
How can a class be reused that does not have an interface that a client requires?
How can classes that have incompatible interfaces work together?
How can an alternative interface be provided for a class?
Often an (already existing) class can't be reused only because its interface doesn't conform to the interface clients require.

Define a separate Adapter class that converts the (incompatible) interface of a class (Adaptee) into another interface (Target) clients require.
Work through an Adapter to work with (reuse) classes that do not have the required interface.

An adapter can be used when the wrapper must respect a particular interface and must support polymorphic behavior.
Alternatively, a decorator makes it possible to add or alter behavior of an interface at run-time,
and a Facade is used when an easier or simpler interface to an underlying object is desired.

Adapter or Wrapper	Converts one interface to another so that it matches what the client is expecting
Decorator	Dynamically adds responsibility to the interface by wrapping the original code
Delegation	Support "composition over inheritance"
Facade	Provides a simplified interface

The Object Adapter implements the Target interface by delegating to an Adaptee object at run-time (adaptee.specificOperation()).
The Class Adapter implements the Target interface by inheriting from an Adaptee class at compile-time (specificOperation())

Convert the interface of a class into another interface clients expect.
An adapter lets classes work together that could not otherwise because of incompatible interfaces.
The enterprise integration pattern equivalent is the translator.

We need this when we have an Ethernet interface on one end and USB on the other.
Since they are incompatible with each other. we use an adapter that converts one to other.

The Adapter pattern is more about getting your existing code to work with a newer system or interface.

If you have a set of company-standard web service APIs that you'd like to offer to another application's existing extensibility interface, you might consider writing a set of adapters to do this. Note that there's a grey area and this is more about how you technically define the pattern, since other patterns like the facade are similar.


 */

public class Adapter {
}
