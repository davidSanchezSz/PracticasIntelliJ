package tennisManager.view;

import tennisManager.commands.CLI;
import java.util.Objects;

public class CLIView {
    private CLI cli;
    private StartView startView;
    private TerminalView terminalView;

    public CLIView() {
        this.cli = new CLI();
        this.terminalView = new TerminalView();
        this.startView = new StartView();
    }

    public void execute() {
        String[] arguments;
        startView.printMenu();
        do{
            arguments = terminalView.getArguments();
            if(arguments == null){
                terminalView.showMessage(Errors.SYNTAX_ERROR.show());
            }else{
                String message = cli.executeCommand(arguments);
                terminalView.showMessage(message);
            }
            System.out.println();

        }while (!Objects.requireNonNull(arguments)[0].equals("exit"));
    }

}
