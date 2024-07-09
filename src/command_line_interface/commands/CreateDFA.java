package command_line_interface.commands;

import state_machine.DeterministicFiniteAutomaton;
import state_machine.TransitionTable;

import java.util.HashSet;

public class CreateDFA implements Command {

    final HashSet<String> states;
    final HashSet<Character> symbols;
    final TransitionTable t;
    final String initial_state;
    final HashSet<String> accepting_states;
    final DeterministicFiniteAutomaton dfa;

    public CreateDFA(HashSet<String> states,
                     HashSet<Character> symbols,
                     TransitionTable t,
                     String initial_state,
                     HashSet<String> accepting_states,
                     DeterministicFiniteAutomaton dfa) {
        this.states = states;
        this.symbols = symbols;
        this.t = t;
        this.initial_state = initial_state;
        this.accepting_states = accepting_states;
        this.dfa = dfa;
    }

    @Override
    public void execute(String[] args) {
        this.dfa = new DeterministicFiniteAutomaton();
    }
}
