package command_line_interface.commands;

import state_machine.DeterministicFiniteAutomaton;

public class RunDFA implements Command{
    private final DeterministicFiniteAutomaton DFA;

    public RunDFA(DeterministicFiniteAutomaton DFA) {
        this.DFA = DFA;
    }
    // todo: add exceptions
    // todo: get rid of magic numbers
    @Override
    public void execute(String[] args) {
        DFA.run(args[1]);
    }
}
