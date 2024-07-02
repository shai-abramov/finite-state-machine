package state_machine;

import java.util.HashMap;
import java.util.HashSet;

public class DeterministicFiniteAutomaton {
    HashSet<Integer> states = new HashSet<>();
    Pair<Integer, Character> pair = new Pair<>(1, '0');
    HashMap<Pair<Integer, Character>, Integer> transitions = new HashMap<>();
}
