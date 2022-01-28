package design.creational.factoryMethod;

public class JSONMessageCreator extends MessageCreator {
    @Override
    protected Message createMessage() {
        return new JSONMessage();
    }
}
