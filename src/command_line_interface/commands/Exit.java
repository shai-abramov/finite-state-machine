package command_line_interface.commands;

import command_line_interface.CLI;

public class Exit implements Command{
    CLI.Status status;

    public Exit(CLI.Status status) {
        this.status = status;
    }

    @Override
    public void execute(String[] args) {
        status.stop();
    }
}
