package design.creational.factoryMethod;

public abstract class MessageCreator {
    public Message getMessage() {
        Message msg = createMessage();
        return msg;
    }

    protected abstract Message createMessage();
}
