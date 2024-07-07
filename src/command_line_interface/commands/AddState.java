package command_line_interface.commands;

import state_machine.DeterministicFiniteAutomaton;

public class AddState implements Command {

    DeterministicFiniteAutomaton automaton;

    public AddState(DeterministicFiniteAutomaton automaton) {
        this.automaton = automaton;
    }

    @Override
    public void execute(String[] args) {
    }
}
