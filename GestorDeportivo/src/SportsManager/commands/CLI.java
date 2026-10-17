package SportsManager.commands;

import SportsManager.Commands;
import SportsManager.Errors;
import SportsManager.commands.PlayerCommands.PlayerCCommandsInterface;
import SportsManager.commands.PublicCommands.*;
import SportsManager.Model.Model;

import java.util.Objects;

public class CLI {
    private static Model model = new Model();

    public Errors executeCommand(String[] command){
        if(command != null){
            for(Commands commands : Commands.values()){
                if(Objects.equals(command[0], commands.getName())){
                    if(isAdmin(commands)){
                        commands.setModel(this.model);
                        return commands.getCommand().execute(command);
                    }else{
                        return Errors.UNAUTHORIZED_COMMAND;
                    }
                }
            }return Errors.COMMAND_NOT_FOUND;
        }
        return Errors.ERROR;
    }

    public boolean isAdmin(Commands commands){
        if(Objects.equals(commands.getCommandType(), "Public")) {
            return true;
        }else if(model.getCurrentUser()!=null && Objects.equals(commands.getCommandType(), "Player") && !model.getCurrentUser().isAdmin()){
            return true;
        }else if(model.getCurrentUser()!=null && Objects.equals(commands.getCommandType(), "Admin") && model.getCurrentUser().isAdmin()){
            return true;
        }else{
            return false;
        }
    }


}


