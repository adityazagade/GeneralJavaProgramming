package design.structural.proxy;

import java.lang.reflect.Proxy;

public class ImageFactoryy {
    public static Image getImage(String fileName) {
        return (Image) Proxy.newProxyInstance(ImageFactory.class.getClassLoader(), new Class[]{Image.class}, new ImageInvocationHandler(fileName));
        }
}
