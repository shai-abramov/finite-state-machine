package command_line_interface.commands;

import java.util.HashSet;

public class PrintStates implements Command {

    private final HashSet<String> states;

    public PrintStates(HashSet<String> states) {
        this.states = states;
    }

    @Override
    public void execute(String[] args) {
        for (String stateName : states) {
            System.out.print(stateName);
            System.out.print(", ");
        }

        System.out.println(); // just to make a new line
    }
}
