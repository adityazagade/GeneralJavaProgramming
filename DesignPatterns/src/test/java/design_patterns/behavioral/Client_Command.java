package design_patterns.behavioral;

import design.behavioural.command.eg1.Goblin;
import design.behavioural.command.eg1.Wizard;

public class Client_Command {
    public static void main(String[] args) {
        Wizard wizard = new Wizard();
        Goblin goblin = new Goblin();
        goblin.printStatus();
        wizard.castSpell(goblin::changeSize);
        goblin.printStatus();

        wizard.castSpell(goblin::changeVisibility);
        goblin.printStatus();

        wizard.undoLastSpell();
        goblin.printStatus();

        wizard.undoLastSpell();
        goblin.printStatus();

        wizard.redoLastSpell();
        goblin.printStatus();

        wizard.redoLastSpell();
        goblin.printStatus();
    }

}
