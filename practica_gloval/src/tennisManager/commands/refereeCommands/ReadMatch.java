package tennisManager.commands.refereeCommands;

import tennisManager.commands.CommandsInterface;
import tennisManager.model.Model;
import tennisManager.view.Errors;

public class ReadMatch implements CommandsInterface {

    public String execute(String[] arguments) {
        return "";
    }


    public Errors approved(String[] arguments) {
        return null;
    }


    public Model getModel() {
        return null;
    }


    public boolean argumentsNeeded(String[] arguments) {
        return false;
    }
}
