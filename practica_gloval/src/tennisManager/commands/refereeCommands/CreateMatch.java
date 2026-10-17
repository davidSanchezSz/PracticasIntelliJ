package tennisManager.commands.refereeCommands;

import tennisManager.commands.CommandsInterface;
import tennisManager.controller.MatchController;
import tennisManager.controller.RefereeController;
import tennisManager.model.Model;
import tennisManager.model.objects.Player;
import tennisManager.model.objects.Referee;
import tennisManager.view.Errors;

import java.util.Objects;

public class CreateMatch implements CommandsInterface {

    MatchController matchController = new MatchController();

    public String execute(String[] arguments){
        if(approved(arguments).isNull()){
            return matchController.createMatch(arguments);
        } else{
            return approved(arguments).show();
        }
    }

    public Errors approved(String[] arguments) {
        if(argumentsNeeded(arguments)){
            if(Objects.equals(arguments[1], "3") || Objects.equals(arguments[1], "5")){
                if(matchController.getModel().getPlayerList().getItemById(Integer.parseInt(arguments[2])) == null || matchController.getModel().getPlayerList().getItemById(Integer.parseInt(arguments[2])) == null){
                    return Errors.NON_EXISTING_PLAYER;
                }
                return Errors.NULL;
            }else{
                return Errors.INVALID_SETS;
            }
        }else{
            return Errors.FORMAT_ERROR;
        }
    }

    public Model getModel() {
        return matchController.getModel();
    }


    public boolean argumentsNeeded(String[] arguments) {
        return arguments.length == 4;
    }
}
