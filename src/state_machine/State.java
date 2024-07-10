package state_machine;

public class State {
    private static int statesCounter = 0;
    public String name;
    private final int id;

    public State(String name) {
        this.name = name;
        this.id = statesCounter;
        statesCounter = statesCounter + 1;
    }

    public int getId() {
        return id;
    }
}
