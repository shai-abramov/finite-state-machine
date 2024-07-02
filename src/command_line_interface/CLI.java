package command_line_interface;

import command_line_interface.commands.Command;
import command_line_interface.commands.Exit;

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

        commands.put("exit", new Exit(status));
    }

    public void run() {
        while (status.isRunning()) {
            System.out.print(PROMPT_SYMBOL);
            java.util.Scanner sc = new java.util.Scanner(System.in);
            String line = sc.nextLine();

            if (commands.get(line) == null) {
                continue;
            }
            commands.get(line).execute(null);
        }
    }

    public static void main(String[] args) {
        CLI commandLineInterface = new CLI();
        commandLineInterface.run();
    }
}
