package SportsManager.commands.PublicCommands;

import SportsManager.Errors;
import SportsManager.Model.Model;
import SportsManager.commands.CommandsInterface;
import SportsManager.controller.UserController;
import SportsManager.users.User;

import java.util.Objects;


public class Login implements CommandsInterface {

    private UserController userController;

    public Login(Model model){
         this.userController = new UserController(model);
    }

    public Errors approved(String[] arguments){
        if(argumentsNeeded(arguments)){
            if(userController.getModel().getCurrentUser() != null){
                return Errors.ALREADY_LOGGED_IN;
            }
            for (User user : userController.getModel().getUsers()) {
                if (Objects.equals(user.getEmail(), arguments[1])){
                    if(user.checkPassword(arguments[2])){
                        return Errors.NULL;
                    } else{
                        return Errors.WRONG_PASSWORD;
                    }
                }
            }
            return Errors.NON_EXISTING_USER;
        }else{
            return Errors.FORMAT_ERROR;
        }
    }

    public Errors execute(String[] arguments){
        if(approved(arguments).isNull()){
            userController.login(arguments);
            return Errors.NULL;
        } else{
            return approved(arguments);
        }
    }

    public boolean argumentsNeeded(String[] arguments) {
        return arguments.length == 3;
    }

}