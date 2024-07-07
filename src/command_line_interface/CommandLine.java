package command_line_interface;

import command_line_interface.commands.*;
import command_line_interface.exceptions.NoSuchCommandException;
import state_machine.DeterministicFiniteAutomaton;

import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;

/**
 * A command line interface, used to provide the user the means to interact with the program.
 * This class holds a main method, where it creates an instance of CommandLine and starts it with
 * the run() method.
 */
public class CommandLine {
    /**
     * CONSTANTS
     */
    private static final String PROMPT_SYMBOL   = "$ ";

    public class Status {
        private boolean isRunning = true;

        public boolean isRunning() {
            return isRunning;
        }

        public void stop() {
            isRunning = false;
        }
    }

    /**
     * Field Variables:
     * status       contains information about the program's status.
     * commands     Holds a set of commands that are executable by the user.
     */
    private final Status status = new Status();
    private final HashMap<String, Command> commands = new HashMap<>();

    /**
     * Constructor for the command line interface (CLI).
     */
    public CommandLine() {
        System.out.println("Study of finite state machine");
        System.out.println("Firing up command line interface... type something!");

        char[] alphabet = {'0', '1'};
        DeterministicFiniteAutomaton dfa = new DeterministicFiniteAutomaton(alphabet);
        HashMap<Character, Integer> t = new HashMap<>();
        t.put('0', 0);
        t.put('1', 1);
        // dfa.addState("q0", t);
        // dfa.addState("q1", t);

        commands.put("exit", new Exit(status));
        commands.put("run", new RunDFA(dfa));
        commands.put("state", new AddState(dfa));
        commands.put("transition", new SetTransition(dfa));
    }

    /**
     * Starts the program and the command line interface (CLI).
     */
    // todo: rework how Scanner and nextLine operate
    public void run() {
        while (status.isRunning()) {
            System.out.print(PROMPT_SYMBOL);
            java.util.Scanner sc = new java.util.Scanner(System.in);
            String line = sc.nextLine();

            try {
                executeLine(line);
            } catch (NoSuchCommandException e) {
                System.out.println("Command not found"); // todo: this is magic variable
            }
        }
    }

    private void executeLine(String line) throws NoSuchCommandException {
        String[] lineParts = line.split(" ");
        String commandName = lineParts[0];
        String[] args = Arrays.copyOfRange(lineParts, 1, lineParts.length);

        Command command = commands.get(commandName);
        if (command == null) {
            throw new NoSuchCommandException();
        }

        command.execute(args);
    }

    public static void main(String[] args) {
        CommandLine commandLineInterface = new CommandLine();
        commandLineInterface.run();
    }
}
