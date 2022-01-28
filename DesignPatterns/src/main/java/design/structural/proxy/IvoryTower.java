package design.structural.proxy;

public class IvoryTower implements Tower {
    @Override
    public void enter(Wizard wizard) {
        System.out.println("Wizard " + wizard.getName() + " has entered the Tower");
    }
}
