package OODP.CreationalPattern;

/**
 * Created by kushaln on 4/29/2018.
 */
/*
The builder pattern is a good choice when designing classes whose constructors or static factories would have more than a handful of parameters.
prominent example is pizza class
This is called the Telescoping Constructor Pattern. The problem with this pattern is that once constructors are 4 or 5 parameters long it becomes
difficult to remember the required order of the parameters as well as what particular constructor you might want in a given situation.
One alternative you have to the Telescoping Constructor Pattern is the JavaBean Pattern where you call a constructor with the mandatory parameters
and then call any optional setters after:
The problem here is that because the object is created over several calls it may be in an inconsistent state partway through its construction.
This also requires a lot of extra effort to ensure thread safety.


designed to provide a flexible design solution to various object creation problems in object-oriented programming.
The intent of the Builder design pattern is to separate the construction of a complex object from its representation.
The Builder design pattern solves problems like:
How can a class (the same construction process) create different representations of a complex object?
How can a class that includes creating a complex object be simplified?


-Advantages
    Allows you to vary a product’s internal representation.
    Encapsulates code for construction and representation.
    Provides control over steps of construction process.
-Disadvantages
    Requires creating a separate ConcreteBuilder for each different type of product.
    Requires the builder classes to be mutable.
    Data members of class aren't guaranteed to be initialized.
    Dependency injection may be less supported.
 */

public class Builder {
    private CarBuilder builder;
    public Builder(final CarBuilder builder) {
        this.builder = builder;
    }
    public Car construct() {
        return builder.setWheels(4).setColor("Red").build();
    }
    public static void main(final String[] arguments) {
        final CarBuilder builder = new CarBuilderImpl();
        final Builder carBuildDirector = new Builder(builder);
        System.out.println(carBuildDirector.construct());
    }

}


class Car {
    private int wheels;
    private String color;
    public Car() {
    }
    public String getColor() {
        return color;
    }
    public void setColor(final String color) {
        this.color = color;
    }
    public int getWheels() {
        return wheels;
    }
    public void setWheels(final int wheels) {
        this.wheels = wheels;
    }
    @Override
    public String toString() {
        return "Car [wheels = " + wheels + ", color = " + color + "]";
    }
}

/**
 * The builder abstraction.
 */
interface CarBuilder {
    Car build();
    CarBuilder setColor(final String color);
    CarBuilder setWheels(final int wheels);
}

class CarBuilderImpl implements CarBuilder {
    private Car car;
    public CarBuilderImpl() {
        car = new Car();
    }
    @Override
    public Car build() {
        return car;
    }
    @Override
    public CarBuilder setColor(final String color) {
        car.setColor(color);
        return this;
    }
    @Override
    public CarBuilder setWheels(final int wheels) {
        car.setWheels(wheels);
        return this;
    }
}