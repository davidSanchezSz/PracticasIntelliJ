package SportsManager.controller;

import SportsManager.Model.Model;
import SportsManager.users.User;

import java.util.Objects;

public class UserController extends Controller{

    public UserController(Model model) {
        setModel(model);
    }

    public void login(String[] arguments){
        for (User user : model.getUsers()) {
            if (Objects.equals(user.getEmail(), arguments[1]) && user.checkPassword(arguments[2])) {
                model.setCurrentUser(user);
                return;
            }
        }
    }

    public void logout(){
        model.setCurrentUser(null);
    }

    public Model getModel(){
        return model;
    }

}
