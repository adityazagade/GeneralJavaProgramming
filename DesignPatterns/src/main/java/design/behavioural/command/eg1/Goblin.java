package design.behavioural.command.eg1;

public class Goblin extends Target {

    public Goblin() {
        setSize(Size.NORMAL);
        setVisibility(Visibility.VISIBLE);
    }

    @Override
    public String toString() {
        return "Goblin";
    }

    public void changeSize() {
        Size oldSize = getSize() == Size.NORMAL ? Size.SMALL : Size.NORMAL;
        setSize(oldSize);
    }

    public void changeVisibility() {
        Visibility visible = getVisibility() == Visibility.INVISIBLE
                ? Visibility.VISIBLE : Visibility.INVISIBLE;
        setVisibility(visible);
    }
}