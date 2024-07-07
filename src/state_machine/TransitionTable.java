package state_machine;

import java.util.HashMap;

public class TransitionTable {

    private final HashMap<String, Integer> stateIndices = new HashMap<>();
    private final HashMap<Character, Integer> symbolIndices = new HashMap<>();
    private String[][] transitionTable;

    public TransitionTable() {
        transitionTable = new String[2][2];
        transitionTable[0][0] = "q0";
        transitionTable[0][1] = "q1";
        transitionTable[1][0] = "q0";
        transitionTable[1][1] = "q1";

        stateIndices.put("q0", 0);
        stateIndices.put("q1", 1);
        symbolIndices.put('0', 0);
        symbolIndices.put('1', 1);
    }

    public String nextState(String currentState, char symbol) {
        int i = stateIndices.get(currentState);
        int j = symbolIndices.get(symbol);
        String newState = transitionTable[i][j];
        return newState;
    }

    public void addState(String newStateName) {
        int newStateIndex = stateIndices.size();
        stateIndices.put(newStateName, newStateIndex);

        // extend the table size by 1 and copy the old cells into the new one
        int oldTableRows = transitionTable.length;
        int oldTableCols = transitionTable[0].length;
        String[][] newTable = new String[oldTableRows + 1][oldTableCols];

        for (int i = 0; i < oldTableRows; i++) {
            for (int j = 0; j < oldTableCols; j++) {
                newTable[i][j] = transitionTable[i][j];
            }
        }

        transitionTable = newTable;
    }

    public void assignTransition(String from, char symbol, String to) {
        int fromIndex = stateIndices.get(from);
        int symbolIndex = symbolIndices.get(symbol);

        transitionTable[fromIndex][symbolIndex] = to;
    }
}
