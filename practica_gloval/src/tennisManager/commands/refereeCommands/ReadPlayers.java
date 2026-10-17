package tennisManager.commands.refereeCommands;

import tennisManager.commands.CommandsInterface;
import tennisManager.controller.PlayerController;
import tennisManager.model.Model;
import tennisManager.model.objects.Referee;
import tennisManager.view.Errors;

import java.util.Objects;

public class ReadPlayers implements CommandsInterface {

    PlayerController playerController = new PlayerController();

    public String execute(String[] arguments){
        if(approved(arguments).isNull()){
            return playerController.readPlayers();
        } else{
            return approved(arguments).show();
        }
    }

    public Errors approved(String[] arguments) {
        if(argumentsNeeded(arguments)){
            if(playerController.getModel().getPlayerList().getCapacity() == 0){
                return Errors.NON_EXISTING_PLAYERS;
            }
            return Errors.NULL;
        }else{
            return Errors.FORMAT_ERROR;
        }
    }

    public Model getModel() {
        return playerController.getModel();
    }


    public boolean argumentsNeeded(String[] arguments) {
        return arguments.length == 1;
    }
}
