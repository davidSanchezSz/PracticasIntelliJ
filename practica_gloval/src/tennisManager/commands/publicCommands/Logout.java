package tennisManager.commands.publicCommands;

import tennisManager.commands.CommandsInterface;
import tennisManager.controller.RefereeController;
import tennisManager.model.Model;
import tennisManager.view.Errors;

public class Logout implements CommandsInterface {

    RefereeController refereeController = new RefereeController();

    public Errors approved(String[] arguments){
        if(argumentsNeeded(arguments)){
            if(refereeController.getModel().getCurrentReferee() == null){
                return Errors.NOBODY_LOGGED_IN;
            }
            return Errors.NULL;
        }else{
            return Errors.FORMAT_ERROR;
        }
    }

    public String execute(String[] arguments){
        if(approved(arguments).isNull()){
            refereeController.logout();
            return Errors.NULL.show();
        } else{
            return approved(arguments).show();
        }
    }

    public Model getModel(){
        return refereeController.getModel();
    }
    public boolean argumentsNeeded(String[] arguments) {
        return arguments.length == 1;
    }
}
