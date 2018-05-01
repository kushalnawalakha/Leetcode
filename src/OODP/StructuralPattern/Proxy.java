package OODP.StructuralPattern;

/**
 * Created by kushaln on 4/30/2018.
 */
/*
Provide a surrogate or placeholder for another object to control access to it.

What problems can the Proxy design pattern solve? [2]
The access to an object should be controlled .
Additional functionality should be provided when accessing an object.
In the proxy, extra functionality can be provided, for example caching when operations on the real object are resource intensive, or checking preconditions before operations on the real object are invoked. For the client, usage of a proxy object is similar to using the real object, because both implement the same interface

 */
interface Image {
    public void displayImage();
}

// On System A
class RealImage implements Image {

    private String filename = null;
    /**
     * Constructor
     * @param filename
     */
    public RealImage(final String filename) {
        this.filename = filename;
        loadImageFromDisk();
    }

    /**
     * Loads the image from the disk
     */
    private void loadImageFromDisk() {
        System.out.println("Loading   " + filename);
    }

    /**
     * Displays the image
     */
    public void displayImage() {
        System.out.println("Displaying " + filename);
    }

}

// On System B
class ProxyImage implements Image {

    private RealImage image = null;
    private String filename = null;
    /**
     * Constructor
     * @param filename
     */
    public ProxyImage(final String filename) {
        this.filename = filename;
    }

    /**
     * Displays the image
     */
    public void displayImage() {
        if (image == null) {
            image = new RealImage(filename);
        }
        image.displayImage();
    }

}

public class Proxy {

    /**
     * Test method
     */
    public static void main(final String[] arguments) {
        final Image image1 = new ProxyImage("HiRes_10MB_Photo1");
        final Image image2 = new ProxyImage("HiRes_10MB_Photo2");

        image1.displayImage(); // loading necessary
        image1.displayImage(); // loading unnecessary
        image2.displayImage(); // loading necessary
        image2.displayImage(); // loading unnecessary
        image1.displayImage(); // loading unnecessary
    }
}