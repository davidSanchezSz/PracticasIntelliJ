package tennisManager.commands.refereeCommands;

import tennisManager.commands.CommandsInterface;
import tennisManager.controller.MatchController;
import tennisManager.model.Model;
import tennisManager.view.Errors;

public class PointRest implements CommandsInterface {

    MatchController matchController = new MatchController();

    public String execute(String[] arguments){
        if(approved(arguments).isNull()){
            return matchController.pointRest(arguments);
        } else{
            return approved(arguments).show();
        }
    }

    public Errors approved(String[] arguments) {
        if(argumentsNeeded(arguments)){
            if(matchController.getModel().getMatchList().getItemByName(arguments[1]) != null){
                if(matchController.getModel().getMatchList().getItemByName(arguments[1]).getPlayerWon()[1] || matchController.getModel().getMatchList().getItemByName(arguments[1]).getPlayerWon()[2]){
                    return Errors.MATCH_FINISHED;
                }
                return Errors.NULL;
            }else{
                return Errors.NON_EXISTING_MATCH;
            }
        }else{
            return Errors.FORMAT_ERROR;
        }
    }


    public Model getModel() {
        return matchController.getModel();
    }

    public boolean argumentsNeeded(String[] arguments) {
        return arguments.length == 2;
    }
}
