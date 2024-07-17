package command_line_interface.commands;

public class Help implements Command {

    Runnable printHelpMessage;

    public Help(Runnable printHelpMessage) {
        this.printHelpMessage = printHelpMessage;
    }

    @Override
    public void execute(String[] args) {
        this.printHelpMessage.run();
    }
}
