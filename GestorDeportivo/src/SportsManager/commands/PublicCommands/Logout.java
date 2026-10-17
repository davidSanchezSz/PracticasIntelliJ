package SportsManager.commands.PublicCommands;
import SportsManager.Errors;
import SportsManager.Model.Model;
import SportsManager.commands.CommandsInterface;
import SportsManager.controller.UserController;

public class Logout implements CommandsInterface {

    private UserController userController;

    public Logout(Model model){
        this.userController = new UserController(model);
    }
    public Errors approved(String[] arguments){
        if(argumentsNeeded(arguments)){
            if(userController.getModel().getCurrentUser() == null){
                return Errors.NOBODY_LOGGED_IN;
            }
            return Errors.NULL;
        }else{
            return Errors.FORMAT_ERROR;
        }
    }

    public Errors execute(String[] arguments){
        if(approved(arguments).isNull()){
            userController.logout();
            return Errors.NULL;
        } else{
            return approved(arguments);
        }
    }
    public void execute(String[] arguments, Model model){
        if(argumentsNeeded(arguments)){
            if(model.getCurrentUser()!=null) {
                model.setCurrentUser(null);
            }
        }

    }

    public boolean argumentsNeeded(String[] arguments) {
        return arguments.length == 1;
    }
}
