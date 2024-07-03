package command_line_interface.commands;

import command_line_interface.CommandLine;

public class Exit implements Command{
    CommandLine.Status status;

    public Exit(CommandLine.Status status) {
        this.status = status;
    }

    @Override
    public void execute(String[] args) {
        status.stop();
    }
}
