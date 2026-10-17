package tennisManager.commands.refereeCommands;

import tennisManager.commands.CommandsInterface;
import tennisManager.controller.MatchController;
import tennisManager.controller.PlayerController;
import tennisManager.model.Model;
import tennisManager.view.Errors;

import java.util.Objects;

public class CreatePlayer implements CommandsInterface {

    PlayerController playerController = new PlayerController();

    public String execute(String[] arguments){
        if(approved(arguments).isNull()){
            playerController.createPlayer(arguments);
        }
        return approved(arguments).show();
    }

    public Errors approved(String[] arguments) {
        if(argumentsNeeded(arguments)){
            return Errors.NULL;
        }else{
            return Errors.FORMAT_ERROR;
        }
    }

    public Model getModel() {
        return playerController.getModel();
    }

    public boolean argumentsNeeded(String[] arguments) {
        return arguments.length == 2;
    }
}
