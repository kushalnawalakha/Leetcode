package OODP.StructuralPattern;

/**
 * Created by kushaln on 4/29/2018.
 */
/*
Adapter or Wrapper	Converts one interface to another so that it matches what the client is expecting
Decorator	Dynamically adds responsibility to the interface by wrapping the original code
Delegation	Support "composition over inheritance"
Facade	Provides a simplified interface

Attach additional responsibilities to an object dynamically keeping the same interface.
Decorators provide a flexible alternative to subclassing for extending functionality.
Adapter provides a different interface to its subject. Proxy provides the same interface. Decorator provides an enhanced interface.

Adapter changes an object's interface, Decorator enhances an object's responsibilities.
Decorator is thus more transparent to the client. As a consequence, Decorator supports recursive composition, which isn't possible with pure Adapters.

Composite and Decorator have similar structure diagrams, reflecting the fact that both rely on recursive composition to organize an open-ended number of objects.

A Decorator can be viewed as a degenerate Composite with only one component. However, a Decorator adds additional responsibilities - it isn't intended for object aggregation.

Decorator and Proxy have different purposes but similar structures. Both describe how to provide a level of indirection to another object, and the implementations keep a reference to the object to which they forward requests.

Decorator lets you change the skin of an object. Strategy lets you change the guts.

 */

public class Decorator {
}
