package state_machine;

import java.util.*;

/**
 * DFAs (deterministic finite automatons) are 5-tuples (Q, Sigma, delta, q0, F) consisting of:
 * @ Q          Finite set of states
 * @ Sigma      Finite set of input symbols, called alphabet
 * @ delta      Transition function from the domain of the cartesian-product (Q x Sigma) to
 *              codomain Q
 * @ q0         The initial state
 * @ F          Set of accept states (subset of Sigma)
 */
public class DeterministicFiniteAutomaton {

    /**
     * Field Variables:
     * currentState         The current state of the automaton
     * transitionTable      Table of transitions from QxSigma to Q
     * alphabet             Finite set of symbols
     */
    // todo: define a class for 'state'. States should be able to be referred to
    //  and named, like enums.
    private String currentState;
    private final HashMap<Character, Integer> alphabet = new HashMap<>();
    TransitionTable t = new TransitionTable();

    /**
     * Constructor for a DFA (deterministic finite automaton)
     * @param alphabet array of chars containing the alphabet of the created DFA.
     *                 Once constructed the DFA's alphabet doesn't change throughout
     *                 the end.
     */
    public DeterministicFiniteAutomaton(char[] alphabet) {
        currentState = "q0";
//        transitionTable = new int[0][alphabet.length];
//        for (int i = 0; i < alphabet.length; i++) {
//            this.alphabet.put(alphabet[i], i);
//        }
    }

//    public int getNumberOfStates() { return transitionTable.length; }

    public int getNumberOfSymbols() { return alphabet.size(); }

//    public void addState(String name, HashMap<Character, Integer> symbolTransitions) {
//        int numberOfStates = getNumberOfStates();
//        int newNumberOfStates = numberOfStates + 1;
//        int numberOfSymbols = getNumberOfSymbols();
//
//        int[][] newTransitionTable = new int[newNumberOfStates][numberOfSymbols];
//        for (int state = 0; state < numberOfStates; state++) {
//            for (int symbol = 0; symbol < numberOfSymbols; symbol++) {
//                newTransitionTable[state][symbol] = transitionTable[state][symbol];
//            }
//        }
//
//        for (Character key: symbolTransitions.keySet()) {
//            int symbolIndexOnTable = alphabet.get(key);
//            newTransitionTable[currentState][symbolIndexOnTable] = symbolTransitions.get(key);
//        }
//
//        this.transitionTable = newTransitionTable;
//    }

    public void setTransition(String from, char symbol, String to) {
        t.assignTransition(from, symbol, to);
//        int indexOfSymbol = alphabet.get(from.getS());
//        transitionTable[from.getT()][indexOfSymbol] = to;
    }

    public void addState(String stateName) {
        t.addState(stateName);
    }

    public void transition(Character symbol) {
        //int symbolIndex = alphabet.get(symbol);
        // currentState = transitionTable[currentState][symbolIndex];
        currentState = t.nextState(currentState, symbol);
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
        currentState = "q0"; // todo: restarts the state
    }
}
