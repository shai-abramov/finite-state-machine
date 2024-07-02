package command_line_interface;

public class CLI {
    private static final String PROMPT_SYMBOL   = "$ ";

    public CLI() {
        System.out.println("Study of finite state machine");
        System.out.println("Firing up command line interface... type something!");
    }

    public void run() {
        while (true) {
            System.out.print(PROMPT_SYMBOL);
            java.util.Scanner sc = new java.util.Scanner(System.in);
            sc.nextLine();
        }
    }

    public static void main(String[] args) {
        CLI commandLineInterface = new CLI();
        commandLineInterface.run();
    }
}
