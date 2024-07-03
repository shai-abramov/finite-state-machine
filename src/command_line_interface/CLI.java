package command_line_interface;

import command_line_interface.commands.Command;
import command_line_interface.commands.Exit;
import command_line_interface.commands.RunDFA;
import state_machine.DeterministicFiniteAutomaton;

import java.util.HashMap;

public class CLI {

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

    private final Status status = new Status();
    private HashMap<String, Command> commands = new HashMap<String, Command>();

    public CLI() {
        System.out.println("Study of finite state machine");
        System.out.println("Firing up command line interface... type something!");

        DeterministicFiniteAutomaton dfa = new DeterministicFiniteAutomaton();

        commands.put("exit", new Exit(status));
        commands.put("run", new RunDFA(dfa));
    }

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
        CLI commandLineInterface = new CLI();
        commandLineInterface.run();
    }
}
