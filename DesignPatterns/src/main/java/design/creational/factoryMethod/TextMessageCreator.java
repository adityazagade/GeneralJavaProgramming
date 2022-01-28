package design.creational.factoryMethod;

public class TextMessageCreator extends MessageCreator {

    protected Message createMessage() {
        return new TextMessage();
    }
}
