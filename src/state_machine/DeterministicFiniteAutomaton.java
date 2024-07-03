package state_machine;

import java.util.HashMap;
import java.util.HashSet;

public class DeterministicFiniteAutomaton {
    private Integer currentState;
    HashSet<Integer> states = new HashSet<>();
    Pair<Integer, Character> pair = new Pair<>(1, '0');
    // todo: consider using state transition table [matrix] instead
    HashMap<Pair<Integer, Character>, Integer> transitions = new HashMap<>();

    public DeterministicFiniteAutomaton() {
        currentState = 0;
        transitions.put(new Pair<>(0, '0'), 1);
        transitions.put(new Pair<>(0, '1'), 0);
        transitions.put(new Pair<>(1, '0'), 0);
        transitions.put(new Pair<>(1, '1'), 1);
    }

    public void defineTransition(Pair<Integer, Character> from, Integer to) {
        transitions.put(from, to);
    }

    public void transition(Character symbol) {
        currentState = transitions.get(new Pair<Integer, Character>(currentState, symbol));
        System.out.println("transitioned to " + currentState);
    }

    public void run(String word) {
        if (word.isEmpty()) {
            System.out.println("Current state is " + currentState);
            return ;
        }

        char currentChar;

        for (int i = 0; i < word.length(); i++) {
            currentChar = word.charAt(i);
            transition(currentChar);
        }

        System.out.println("Current state is " + currentState);
    }
}
