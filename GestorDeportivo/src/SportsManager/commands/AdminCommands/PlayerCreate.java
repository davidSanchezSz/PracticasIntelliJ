package SportsManager.commands.AdminCommands;

import SportsManager.Errors;
import SportsManager.Model.Model;
import SportsManager.commands.CommandsInterface;
import SportsManager.controller.PlayerController;
import SportsManager.users.Player;

import java.util.Objects;

public class PlayerCreate implements CommandsInterface {

    private PlayerController playerController;

    public PlayerCreate(Model model){
        this.playerController = new PlayerController(model);
    }


    public Errors approved(String[] arguments){
        if(argumentsNeeded(arguments)){
            for(Player player : playerController.getModel().getPlayerList().getAll()){
                if(Objects.equals(player.getEmail(), arguments[1])){
                    return Errors.EXISTING_PLAYER;
                }
            }
            return Errors.NULL;
        } else return Errors.FORMAT_ERROR;

    }

    public Errors execute(String[] arguments){
        if(approved(arguments).isNull()){
            playerController.playerCreate(arguments);
            return Errors.NULL;
        } else{
            return approved(arguments);
        }
    }

    public boolean argumentsNeeded(String[] arguments) {
        return arguments.length == 5;
    }

}




