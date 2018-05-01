package OODP.StructuralPattern;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by kushaln on 4/30/2018.
 */
/*
Compose objects into tree structures to represent part-whole hierarchies.
Composite lets clients treat individual objects and compositions of objects uniformly.

What problems can the Composite design pattern solve? [3]

A part-whole hierarchy should be represented so that clients can treat part and whole objects uniformly.
A part-whole hierarchy should be represented as tree structure.
When defining (1) Part objects and (2) Whole objects that act as containers for Part objects, clients must treat them separately, which complicates client code.

What solution does the Composite design pattern describe?

Define a unified Component interface for both part (Leaf) objects and whole (Composite) objects.
Individual Leaf objects implement the Component interface directly, and Composite objects forward requests to their child components.

When dealing with Tree-structured data, programmers often have to discriminate between a leaf-node and a branch.

This makes code more complex, and therefore, more error prone.
The solution is an interface that allows treating complex and primitive objects uniformly.
In object-oriented programming, a composite is an object designed as a composition of one-or-more similar objects, all exhibiting similar functionality.
This is known as a "has-a" relationship between objects.[4]
The key concept is that you can manipulate a single instance of the object just as you would manipulate a group of them.
The operations you can perform on all the composite objects often have a least common denominator relationship.
For example, if defining a system to portray grouped shapes on a screen,
it would be useful to define resizing a group of shapes to have the same effect (in some sense) as resizing a single shape.

Composite should be used when clients ignore the difference between compositions of objects and individual objects.
If programmers find that they are using multiple objects in the same way, and often have nearly identical code to handle each of them,
then composite is a good choice; it is less complex in this situation to treat primitives and composites as homogeneous.

calculator
 */
interface Graphic {

    //Prints the graphic.
    public void print();
}

/** "Composite" */
class CompositeGraphic implements Graphic {

    //Collection of child graphics.
    private List<Graphic> childGraphics = new ArrayList<Graphic>();

    //Prints the graphic.
    public void print() {
        for (Graphic graphic : childGraphics) {
            graphic.print();
        }
    }

    //Adds the graphic to the composition.
    public void add(Graphic graphic) {
        childGraphics.add(graphic);
    }

    //Removes the graphic from the composition.
    public void remove(Graphic graphic) {
        childGraphics.remove(graphic);
    }
}

/** "Leaf" */
class Ellipse implements Graphic {

    //Prints the graphic.
    public void print() {
        System.out.println("Ellipse");
    }
}

/** Client */
public class Composite {
    public static void main(String[] args) {
        //Initialize four ellipses
        Ellipse ellipse1 = new Ellipse();
        Ellipse ellipse2 = new Ellipse();
        Ellipse ellipse3 = new Ellipse();
        Ellipse ellipse4 = new Ellipse();
        //Initialize three composite graphics
        CompositeGraphic graphic = new CompositeGraphic();
        CompositeGraphic graphic1 = new CompositeGraphic();
        CompositeGraphic graphic2 = new CompositeGraphic();
        //Composes the graphics
        graphic1.add(ellipse1);
        graphic1.add(ellipse2);
        graphic1.add(ellipse3);
        graphic2.add(ellipse4);
        graphic.add(graphic1);
        graphic.add(graphic2);
        //Prints the complete graphic (Four times the string "Ellipse").
        graphic.print();
    }
}