package SportsManager.view;

import SportsManager.Errors;
import SportsManager.Model.Model;
import SportsManager.commands.CLI;

public class CLIView {
    private static CLI cli;
    private TerminalView terminalView;
    private StartView startView;
    private ErrorView errorView;

    public CLIView() {
        this.cli = new CLI();
        this.terminalView = new TerminalView();
        this.startView = new StartView();
        this.errorView = new ErrorView();
    }

    public void execute() {
        String[] command;
        startView.printMenu();
        do{
            command = terminalView.getCommand();
            if(command == null){
                errorView.printError(Errors.SYNTAX_ERROR);
            }else{
                Errors error = cli.executeCommand(command);
                errorView.printError(error);
            }
            System.out.println();

        }while (!command[0].equals("exit"));
    }


}
