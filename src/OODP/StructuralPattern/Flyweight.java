package OODP.StructuralPattern;

/**
 * Created by kushaln on 4/30/2018.
 */
/*
Use sharing to support large numbers of similar objects efficiently.
In computer programming, flyweight is a software design pattern.
 A flyweight is an object that minimizes memory usage by sharing as much data as possible with other similar objects;
 it is a way to use objects in large numbers when a simple repeated representation would use an unacceptable amount of memory.
  Often some parts of the object state can be shared, and it is common practice to hold them in external data structures and pass them to the objects
   temporarily when they are used.

A classic example usage of the flyweight pattern is the data structures for graphical representation of characters in a word processor.
 It might be desirable to have, for each character in a document, a glyph object containing its font outline, font metrics, and other formatting data,
 but this would amount to hundreds or thousands of bytes for each character.
 Instead, for every character there might be a reference to a flyweight glyph object shared by every instance of the same character in the document;
  only the position of each character (in the document and/or the page) would need to be stored internally.



 */
import java.util.HashMap;
import java.util.Map;

interface BMWCarCustomisation {
    // customize Tire size
    int getTireSize();
    String getLaserSignature();
    // a lot of customisation attribute can be in their for a BMW Car
    void printCustomisations();
}

interface BMWCar {
    double calculatePrice(BMWCarCustomisation custom);
    void printFullCharacteristics(BMWCarCustomisation custom);
}

interface BMWCarFactory {
    BMWCar createCar();
}

interface BMWCarFlyWeightFactory {
    enum Model {Serie1, Serie2, Serie3};
    BMWCar getBWMModel(Model m);
}

class BMWSerie1 implements BMWCar {
    private final static double BASE_PRICE = 25000;

    @Override
    public double calculatePrice(BMWCarCustomisation custom) {
        return BASE_PRICE + getSpecificSerie1PriceBasedOnCustom(custom) + getExportationTaxe(custom);
    }

    @Override
    public void printFullCharacteristics(BMWCarCustomisation custom) {
        // print all BMWSerie 1 specific characteristics
        // (codes in there)
        custom.printCustomisations(); // print details based on these customisations
    }

    private double getSpecificSerie1PriceBasedOnCustom(BMWCarCustomisation custom) {
        // (calculation based on custom specific to serie1 in there, for eg)
        double sum = 0;
        if (custom.getTireSize() == 19) {
            sum += 1200;
        } else {
            sum += 2100;
        }
        return sum;
    }

    private double getExportationTaxe(BMWCarCustomisation custom) {
        // (calculation based on custom exportation taxes only for this model)
        double sum = 0;
        if (!custom.getLaserSignature().isEmpty()) {
            sum += 987;
        }
        return sum;
    }
}

class BMWSerie2 implements BMWCar {
    private final static double BASE_PRICE = 28000;

    @Override
    public double calculatePrice(BMWCarCustomisation custom) {
        return BASE_PRICE + getSpecificSerie2PriceBasedOnCustom(custom);
    }

    @Override
    public void printFullCharacteristics(BMWCarCustomisation custom) {
        // print all BMWSerie 2 specific characteristics
        // (codes in there)
        custom.printCustomisations(); // print details based on these customisations
    }

    private double getSpecificSerie2PriceBasedOnCustom(BMWCarCustomisation custom) {
        // (calculation based on custom specific to serie1 in there, for eg)
        double sum = 0;
        if (custom.getTireSize() == 19) {
            sum += 2000;
        } else {
            sum += 3000;
        }
        if (!custom.getLaserSignature().isEmpty()) {
            if (custom.getLaserSignature().length() > 10) {
                sum += 1200;
            } else {
                sum += 400;
            }
        }
        return sum;
    }
}

class BMWSerie2Factory implements BMWCarFactory {
    @Override
    public BMWCar createCar() {
        return new BMWSerie2();
    }
}

class BMWSerie1Factory implements BMWCarFactory {
    @Override
    public BMWCar createCar() {
        return new BMWSerie1();
    }
}

class BMWSerieFlyWeightFactory implements BMWCarFlyWeightFactory {
    private Map<Model, BMWCar> cache = new HashMap<>();

    public synchronized BMWCar getBWMModel(Model m) {
        if (!cache.containsKey(m)) {
            BMWCarFactory concreteFactory;
            switch (m) {
                case Serie2:
                    concreteFactory = new BMWSerie2Factory();
                    break;
			/*
			 * Just code to have a hint ! case Serie3: concreteFactory=new
			 * BMWSerie3Factory(); break;
			 */
                default:
                    concreteFactory = new BMWSerie1Factory();
                    break;
            }
            cache.put(m, concreteFactory.createCar());
        }
        return cache.get(m);
    }
}

class BMWSerieCarCustomisation implements BMWCarCustomisation {

    private int tireSize;
    private String laserSignature;

    public BMWSerieCarCustomisation(int tireSize, String laserSignature) {
        this.tireSize = tireSize;
        this.laserSignature = laserSignature;
    }

    public int getTireSize() {
        return tireSize;
    }

    public String getLaserSignature() {
        return laserSignature;
    }

    @Override
    public void printCustomisations() {
        System.out.println("Tire Size:" + getTireSize());
        System.out.println("LaserSignature:" + getLaserSignature());
        System.out.println("LaserSignature Size:" + getLaserSignature().length());
    }

}

public class Flyweight {

    public static void main(String[] args) {
        BMWCarFlyWeightFactory factory = new BMWSerieFlyWeightFactory();
        BMWCar serie1Car = factory.getBWMModel(BMWCarFlyWeightFactory.Model.Serie1);
        BMWCar serie1Car2 = factory.getBWMModel(BMWCarFlyWeightFactory.Model.Serie1);
        System.out.println("check for Object for Serie1:" + (serie1Car == serie1Car2));
        BMWCar serie2Car = factory.getBWMModel(BMWCarFlyWeightFactory.Model.Serie2);
        BMWCar serie2Car2 = factory.getBWMModel(BMWCarFlyWeightFactory.Model.Serie2);
        System.out.println("check for Object for Serie2:" + (serie2Car == serie2Car2));
        BMWCarCustomisation custom1 = new BMWSerieCarCustomisation(19, "Oh yeah");
        BMWCarCustomisation custom2 = new BMWSerieCarCustomisation(21, "For bob");
        BMWCarCustomisation custom3 = new BMWSerieCarCustomisation(26, "give it a ride !!");
        // BMW Serie 1
        System.out.println("BMW Serie1 + Custom1 Price:\nFull Price:" + serie1Car.calculatePrice(custom1));
        serie1Car.printFullCharacteristics(custom1);
        System.out.println("BMW Serie1 + Custom2 Price:\nFull Price:" + serie1Car.calculatePrice(custom2));
        serie1Car.printFullCharacteristics(custom2);
        System.out.println("BMW Serie1 + Custom3 Price:\nFull Price:" + serie1Car.calculatePrice(custom3));
        serie1Car.printFullCharacteristics(custom3);
        /// It's the samed BMW Serie1 Fly Weight instance the variant part is provided
        /// by
        /// the operation
        // and customs
        // BMW Serie 2
        System.out.println("BMW Serie2 + Custom1 Price:\nFull Price:" + serie2Car.calculatePrice(custom1));
        serie2Car.printFullCharacteristics(custom1);
        System.out.println("BMW Serie2 + Custom2 Price:\nFull Price:" + serie2Car.calculatePrice(custom2));
        serie2Car.printFullCharacteristics(custom2);
        System.out.println("BMW Serie2 + Custom3 Price:\nFull Price:" + serie2Car.calculatePrice(custom3));
        serie2Car.printFullCharacteristics(custom3);
        /// It's the samed BMW Serie2 Fly Weight instance the variant part is provided
        /// by
        /// the operation
        // and customs
    }

}
