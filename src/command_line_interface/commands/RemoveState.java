package command_line_interface.commands;

import java.util.HashSet;

public class RemoveState implements Command {

    private final HashSet<String> states;

    public RemoveState(HashSet<String> states) {
        this.states = states;
    }

    @Override
    public void execute(String[] args) {
        for (String arg : args) {
            states.remove(arg);
        }
    }
}
