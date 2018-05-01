package OODP.StructuralPattern;

/**
 * Created by kushaln on 4/30/2018.
 */
/*
Decouple an abstraction from its implementation allowing the two to vary independently.

Use the Bridge pattern when:
you want run-time binding of the implementation,
you have a proliferation of classes resulting from a coupled interface and numerous implementations,
you want to share an implementation among multiple objects,
you need to map orthogonal class hierarchies.

Consequences include:
decoupling the object's interface,
improved extensibility (you can extend (i.e. subclass) the abstraction and implementation hierarchies independently),
hiding details from clients.

Adapter makes things work after they're designed; Bridge makes them work before they are.
The Bridge pattern is going to allow you to possibly have alternative implementations of an algorithm or system.

Though not a classic Bridge pattern example, imagine if you had a few implementations of a data store: one is efficient in space, the other is efficient in raw performance... and you have a business case for offering both in your app or framework.

The intent : Adapter allows two unrelated interfaces to work together. Bridge allows Abstraction and implementation to vary independently.


 */

interface DrawingAPI {
    public void drawCircle(final double x, final double y, final double radius);
}

/** "ConcreteImplementor"  1/2 */
class DrawingAPI1 implements DrawingAPI {
    public void drawCircle(final double x, final double y, final double radius) {
        System.out.printf("API1.circle at %f:%f radius %f\n", x, y, radius);
    }
}

/** "ConcreteImplementor" 2/2 */
class DrawingAPI2 implements DrawingAPI {
    public void drawCircle(final double x, final double y, final double radius) {
        System.out.printf("API2.circle at %f:%f radius %f\n", x, y, radius);
    }
}

/** "Abstraction" */
abstract class Shape {
    protected DrawingAPI drawingAPI;

    protected Shape(final DrawingAPI drawingAPI){
        this.drawingAPI = drawingAPI;
    }

    public abstract void draw();                                 // low-level
    public abstract void resizeByPercentage(final double pct);   // high-level
}

/** "Refined Abstraction" */
class CircleShape extends Shape {
    private double x, y, radius;
    public CircleShape(final double x, final double y, final double radius, final DrawingAPI drawingAPI) {
        super(drawingAPI);
        this.x = x;  this.y = y;  this.radius = radius;
    }

    // low-level i.e. Implementation specific
    public void draw() {
        drawingAPI.drawCircle(x, y, radius);
    }
    // high-level i.e. Abstraction specific
    public void resizeByPercentage(final double pct) {
        radius *= (1.0 + pct/100.0);
    }
}

/** "Client" */
class Bridge {
    public static void main(final String[] args) {
        Shape[] shapes = new Shape[] {
                new CircleShape(1, 2, 3, new DrawingAPI1()),
                new CircleShape(5, 7, 11, new DrawingAPI2())
        };

        for (Shape shape : shapes) {
            shape.resizeByPercentage(2.5);
            shape.draw();
        }
    }
}

