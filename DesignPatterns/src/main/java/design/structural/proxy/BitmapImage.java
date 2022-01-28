package design.structural.proxy;

import javafx.geometry.Point2D;

public class BitmapImage implements Image {
    String fileName;
    Point2D location;

    public BitmapImage(String fileName) {
        this.fileName = fileName;
        System.out.println("Creating a bitmap image");
    }

    @Override
    public void setLocation(Point2D point2d) {
        location = point2d;
    }

    @Override
    public Point2D getLocation() {
        return location;
    }

    @Override
    public void render() {
        System.out.println("Rendered: " + this.fileName);
    }
}
