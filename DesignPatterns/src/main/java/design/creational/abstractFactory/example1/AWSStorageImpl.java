package design.creational.abstractFactory.example1;

public class AWSStorageImpl implements Storage {
    private String serialCode;
    private int size;

    public AWSStorageImpl(int size) {
        this.size = size;
        String serialCode = "AWS" + (int) Math.random() * (100);
    }

    @Override
    public String getId() {
        return serialCode;
    }
}
