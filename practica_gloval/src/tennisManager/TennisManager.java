package tennisManager;

import tennisManager.view.CLIView;

public class TennisManager {
    public static void main(String[] args) {
        CLIView cliView = new CLIView();
        cliView.execute();
    }
}