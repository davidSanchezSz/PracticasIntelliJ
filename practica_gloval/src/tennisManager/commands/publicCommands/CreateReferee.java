package tennisManager.commands.publicCommands;

import tennisManager.commands.CommandsInterface;
import tennisManager.controller.RefereeController;
import tennisManager.model.Model;
import tennisManager.model.objects.Referee;
import tennisManager.view.Errors;

import java.util.Objects;

public class CreateReferee implements CommandsInterface {

    RefereeController refereeController = new RefereeController();

    public String execute(String[] arguments){
        if(approved(arguments).isNull()){
            refereeController.createReferee(arguments);
            return Errors.NULL.show();
        } else{
            return approved(arguments).show();
        }
    }

    public Errors approved(String[] arguments) {
        if(argumentsNeeded(arguments)){
            for(Referee referee : refereeController.getModel().getRefereeList().getAll()){
                if(Objects.equals(refereeController.getModel().getRefereeList().getItemByName(arguments[1]).getName(), referee.getName())){
                    return Errors.EXISTING_REFEREE;
                }
            }return Errors.NULL;

        }else{
            return Errors.FORMAT_ERROR;
        }
    }


    public Model getModel() {
        return refereeController.getModel();
    }


    public boolean argumentsNeeded(String[] arguments) {
        return arguments.length == 3;
    }
}
