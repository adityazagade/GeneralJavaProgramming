package design.creational.abstractFactory.example1;

public class GoogleStorageImpl implements Storage {
    private String serialCode;
    private int size;

    public GoogleStorageImpl(int size) {
        this.size = size;
        String serialCode = "GOOG" + (int) Math.random() * (10);
    }

    @Override
    public String getId() {
        return serialCode;
    }
}
