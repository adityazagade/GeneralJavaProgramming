package design.structural.proxy;

import javafx.geometry.Point2D;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class ImageInvocationHandler implements InvocationHandler {
    String fileName;
    BitmapImage bitmapImage;
    Point2D location;
    private static Method setLocationMethod;
    private static Method getLocationMethod;
    private static Method renderMethod;

    static {
        try {
            setLocationMethod = Image.class.getMethod("setLocation", Point2D.class);
            getLocationMethod = Image.class.getMethod("getLocation", null);
            renderMethod = Image.class.getMethod("render", null);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
    }

    public ImageInvocationHandler(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("Invoking method: " + method.getName());
        if (method.equals(setLocationMethod)) {
            return handleSetLocation((Point2D) args[0]);
        } else if (method.equals(getLocationMethod)) {
            return handleGetLocation();
        } else if (method.equals(renderMethod)) {
            return handleRender();
        } else {
            throw new Exception("Method does not exist");
        }
    }

    private Object handleRender() {
        if (bitmapImage == null) bitmapImage = new BitmapImage(this.fileName);
        if (location != null) {
            bitmapImage.setLocation(location);
        }
        bitmapImage.render();
        return null;
    }

    private Object handleGetLocation() {
        if (bitmapImage != null) {
            return bitmapImage.getLocation();
        } else {
            return location;
        }
    }

    private Object handleSetLocation(Point2D point2d) {
        if (bitmapImage != null) {
            bitmapImage.setLocation(point2d);
        } else {
            location = point2d;
        }
        return null;
    }
}
