package command_line_interface;

import command_line_interface.commands.Command;
import command_line_interface.commands.Exit;
import command_line_interface.commands.RunDFA;
import state_machine.DeterministicFiniteAutomaton;

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
        dfa.addState("q0", t);
        dfa.addState("q1", t);

        commands.put("exit", new Exit(status));
        commands.put("run", new RunDFA(dfa));
    }

    /**
     * Starts the program and the command line interface (CLI).
     */
    public void run() {
        while (status.isRunning()) {
            System.out.print(PROMPT_SYMBOL);
            java.util.Scanner sc = new java.util.Scanner(System.in);
            String line = sc.nextLine();

            String[] args = line.split(" ");

            Command todo_change_name = commands.get(args[0]);
            if (todo_change_name == null) {
                continue;
            }
            todo_change_name.execute(args);
        }
    }

    public static void main(String[] args) {
        CommandLine commandLineInterface = new CommandLine();
        commandLineInterface.run();
    }
}
