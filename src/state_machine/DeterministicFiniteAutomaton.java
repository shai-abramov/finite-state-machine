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
    private final HashSet<State> states = new HashSet<>();
    private State[][] transitions = new State[0][0];

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

    public void assignDfa(Collection<String> states,
                          Collection<Character> alphabet,
                          Collection<String> transitionDescriptions) {
        int stateID = 0;
        for (String state : states) {
            this.states.add(new State(state));
            stateID++;
        }

        int characterID = 0;
        for (Character letter : alphabet) {
            this.alphabet.put(letter, characterID);
            characterID++;
        }

        for (String transitionDescription : transitionDescriptions) {
            String[] parts = transitionDescription.split(":");

            // fill table of transitions here
        }

        State[][] transitions = new State[states.size()][alphabet.size()];
        for (int i = 0; i < states.size(); i++) {
            for (int j = 0; j < alphabet.size(); j++) {
                System.out.println(transitions[i][j]);
            }
        }
    }

    /**
     * checks if the dfa is able to run on any input set over its defined alphabet.
     * i. e - it's transition table is well-defined.
     * @return true of false
     */
    public boolean isComplete() {
        return false;
    }


    public int getNumberOfStates() { return states.size(); }

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

//    public void setTransition(String from, char symbol, String to) {
//        t.assignTransition(from, symbol, to);
////        int indexOfSymbol = alphabet.get(from.getS());
////        transitionTable[from.getT()][indexOfSymbol] = to;
//    }

    public void addState() {
        addState("");
    }

    public void addState(String stateName) {
        states.add(new State(stateName));

        int previousNumberOfStates = getNumberOfStates() - 1;
        int newNumberOfStates = getNumberOfStates();
        int numberOfSymbols = getNumberOfSymbols();

        State[][] newTransitionTable = new State[newNumberOfStates][numberOfSymbols];
        for (int state = 0; state < previousNumberOfStates; state++) {
            for (int symbol = 0; symbol < numberOfSymbols; symbol++) {
                newTransitionTable[state][symbol] = transitions[state][symbol];
            }
        }

        for (State s : states) {
            if (s.name.equals(stateName)) {
                for (Character key: alphabet.keySet()) {
                    int symbolIndexOnTable = alphabet.get(key);
                    newTransitionTable[newNumberOfStates - 1][symbolIndexOnTable] = s;
                }
            }
        }

        this.transitions = newTransitionTable;
    }

    public void addSymbol(char symbolChar) {
        alphabet.put(symbolChar, alphabet.size() - 1);

        int previousNumberOfSymbols = getNumberOfSymbols() - 1;
        int newNumberOfSymbols = getNumberOfSymbols();
        int numberOfStates = getNumberOfStates();

        State[][] newTransitionTable = new State[numberOfStates][newNumberOfSymbols];
        for (int state = 0; state < numberOfStates; state++) {
            for (int symbol = 0; symbol < previousNumberOfSymbols; symbol++) {
                newTransitionTable[state][symbol] = transitions[state][symbol];
            }
        }

        for (int i = 0; i < numberOfStates; i++) {
            for (State s : states) {
                if (s.getId() == i) {
                    newTransitionTable[i][newNumberOfSymbols - 1] = s;
                }
            }
        }

        this.transitions = newTransitionTable;
    }

    // todo: so far this is under construction
    public void addTransition(String from, String to) {
        State fromState, toState;
        for (State state : states) {
            if (state.name.equals(from)) {
                fromState = state;
            }

            if (state.name.equals(to)) {
                toState = state;
            }
        }
    }

    public void setTransition(String from, char symbol, String to) {
        State fromState, toState;
        for (State state : states) {
            if (state.name.equals(from)) {
                fromState = state;
            }

            if (state.name.equals(to)) {
                toState = state;
            }
        }

        int symbolIndex = alphabet.get(symbol);
        if (symbolIndex == -1) {
            symbolIndex = alphabet.size();
            alphabet.put(symbol, symbolIndex);
        }
    }


    public void transition(Character symbol) {
        //int symbolIndex = alphabet.get(symbol);
        // currentState = transitionTable[currentState][symbolIndex];
        State actualCurrentState = null;
        for (State s : states) {
            if (s.name.equals(currentState)) {
                actualCurrentState = s;
            }
        }
        currentState = transitions[actualCurrentState.getId()][alphabet.get(symbol)].name;
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
