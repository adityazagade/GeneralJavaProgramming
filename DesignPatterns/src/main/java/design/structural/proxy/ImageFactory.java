package design.structural.proxy;

public class ImageFactory {
    public static Image getImage(String file) {
        return new ImageProxy(file);
    }
}
