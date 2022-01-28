package design.creational.abstractFactory.example2;

public class App {
    Example.Castle castle;
    Example.Army army;
    Example.King king;

    public void createKingdom(Example.KindomFactory factory) {
        this.army = factory.createArmy();
        this.king = factory.createKing();
        this.castle = factory.createCastle();
    }

    public Example.Castle getCastle() {
        return castle;
    }

    public Example.Army getArmy() {
        return army;
    }

    public Example.King getKing() {
        return king;
    }
}
