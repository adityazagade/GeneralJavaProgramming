package design.structural.proxy;

public class TowerProxy implements Tower {
    private Tower tower;
    private final int MAX_ALLOWED = 3;
    private int numWizards;

    public TowerProxy(Tower t) {
        tower = t;
    }

    @Override
    public void enter(Wizard wizard) {
        if (numWizards < 3) {
            tower.enter(wizard);
            numWizards++;
        } else {
            System.out.println("Wizard " + wizard.getName() + " cannot enter tower.");
        }
    }
}
