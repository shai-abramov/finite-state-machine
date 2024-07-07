package command_line_interface.commands;

import state_machine.DeterministicFiniteAutomaton;

public class SetTransition implements Command {

    DeterministicFiniteAutomaton automaton;

    public SetTransition(DeterministicFiniteAutomaton automaton) {
        this.automaton = automaton;
    }

    @Override
    public void execute(String[] args) {
        automaton.setTransition(args[0], args[1].charAt(0), args[2]);
    }
}
