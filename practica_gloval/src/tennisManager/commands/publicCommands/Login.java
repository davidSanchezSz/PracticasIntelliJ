package tennisManager.commands.publicCommands;

import tennisManager.commands.CommandsInterface;
import tennisManager.controller.RefereeController;
import tennisManager.model.Model;
import tennisManager.model.objects.Referee;
import tennisManager.view.Errors;

import java.util.Objects;

public class Login implements CommandsInterface {

    RefereeController refereeController = new RefereeController();

    public String execute(String[] arguments){
        if(approved(arguments).isNull()){
            refereeController.login(arguments);
            return Errors.NULL.show();
        } else{
            return approved(arguments).show();
        }
    }

    public Errors approved(String[] arguments){
        if(argumentsNeeded(arguments)){
            if(refereeController.getModel().getCurrentReferee() != null){
                return Errors.ALREADY_LOGGED_IN;
            }
            for (Referee referee : refereeController.getModel().getRefereeList().getAll()) {
                if (Objects.equals(referee.getName(), arguments[1])){
                    if(referee.checkPassword(arguments[2])){
                        return Errors.NULL;
                    } else{
                        return Errors.WRONG_PASSWORD;
                    }
                }
            }
            return Errors.NON_EXISTING_REFEREE;
        }else{
            return Errors.FORMAT_ERROR;
        }
    }



    public Model getModel(){
        return refereeController.getModel();
    }

    public boolean argumentsNeeded(String[] arguments) {
        return arguments.length == 3;
    }

}
