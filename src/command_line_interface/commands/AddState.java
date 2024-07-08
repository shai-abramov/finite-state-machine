package command_line_interface.commands;

import state_machine.DeterministicFiniteAutomaton;

import java.util.Collections;
import java.util.HashSet;

public class AddState implements Command {

    private final HashSet<String> states;

    public AddState(HashSet<String> states) {
        this.states = states;
    }

    @Override
    public void execute(String[] args) {
        Collections.addAll(states, args);
    }
}
