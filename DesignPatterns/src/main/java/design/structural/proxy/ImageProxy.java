package design.structural.proxy;

import javafx.geometry.Point2D;

public class ImageProxy implements Image {
    BitmapImage bitmapImage;
    String fileName;
    Point2D location;

    public ImageProxy(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public void setLocation(Point2D point2d) {
        if (bitmapImage != null) {
            bitmapImage.setLocation(point2d);
        } else {
            location = point2d;
        }
    }

    @Override
    public Point2D getLocation() {
        if (bitmapImage != null) {
            return bitmapImage.getLocation();
        } else {
            return location;
        }
    }

    @Override
    public void render() {
        if (bitmapImage == null) bitmapImage = new BitmapImage(this.fileName);
        if (location != null) {
            bitmapImage.setLocation(location);
        }
        bitmapImage.render();
    }
}
