package tennisManager.commands;

import tennisManager.model.Model;
import tennisManager.view.Errors;

import java.util.Objects;

public class CLI {
    private Model model = new Model();

    public String executeCommand(String[] arguments){
        if(arguments != null){
            for(Commands commands : Commands.values()){
                if(Objects.equals(arguments[0], commands.getName())){
                    model = commands.getCommand().getModel();
                    if(authorized(commands)){
                        return commands.getCommand().execute(arguments);
                    }else{
                        return Errors.UNAUTHORIZED_COMMAND.show();
                    }
                }
            }return Errors.COMMAND_NOT_FOUND.show();
        }
        return Errors.ERROR.show();
    }

    public boolean authorized(Commands commands){
        if(Objects.equals(commands.getCommandType(), "Public")) {
            return true;
        }else if(model.getCurrentReferee()!=null && Objects.equals(commands.getCommandType(), "Referee")){
            return true;
        }else{
            return false;
        }
    }

}
