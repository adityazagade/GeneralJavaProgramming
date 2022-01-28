package design.behavioural.command.eg1;

import java.util.Deque;
import java.util.LinkedList;

public class Wizard {
    Deque<Command> undoStack = new LinkedList<>();
    Deque<Command> redoStack = new LinkedList<>();

    public void castSpell(Command spell) {
        spell.run();
        undoStack.offerLast(spell);
    }

    public void undoLastSpell() {
        if (!undoStack.isEmpty()) {
            Command previousSpell = undoStack.pollLast();
            redoStack.offerLast(previousSpell);
            previousSpell.run();
        }
    }

    public void redoLastSpell() {
        if (!redoStack.isEmpty()) {
            Command previousSpell = redoStack.pollLast();
            undoStack.offerLast(previousSpell);
            previousSpell.run();
        }
    }

    @Override
    public String toString() {
        return "Wizard";
    }

}
