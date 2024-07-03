# Finite State Machine
## Why this project?
This project was created as a study of finite state machines (FSMs) when I was studying theory of computation.
## How is this project structured?
There is currently one package in the project (named "command_line_interface") containing a basic command line that is planned to be used to build and simulate FSMs.
There is another planned package that would define the class of FSMs and their work.
## Example
There is a main() method in CLI.java file.
Running it creates an instance of a command line interface where the use can type commands
    $ run 0101001
    $ exit
where the user can type commands that the shell would execute.
## What else is needed to be done?
- Add documentation
- Reconsider if Status class should be an inner class
- Reconsider the way Scanner works, currently its instance is created every time the user enters a line
- consider changing way transition function defined - instead of hash map use matrix/table.
- consider using yield