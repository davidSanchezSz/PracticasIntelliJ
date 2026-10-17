package SportsManager.commands.AdminCommands;

import SportsManager.Errors;
import SportsManager.Model.Model;
import SportsManager.commands.CommandsInterface;
import SportsManager.controller.PlayerController;
import SportsManager.controller.TeamController;
import SportsManager.users.Player;

import java.util.Objects;

public class TeamAdd implements CommandsInterface {

    private TeamController teamController = new TeamController();

    public Errors approved(String[] arguments){
        if(argumentsNeeded(arguments)){
            if(teamController.getModel().getPlayerList().getPlayerByEmail(arguments[2]).getTeamName() != null){
                return Errors.ALREADY_IN_TEAM;
            }
            for(Player player : teamController.getModel().getTeamList().getItemByName(arguments[1]).getPlayerList().getAll()){
                if(Objects.equals(player.getEmail(), arguments[2])){
                    return Errors.EXISTING_PLAYER;
                }
            }
            return Errors.NULL;
        } else return Errors.FORMAT_ERROR;

    }


    public Errors execute(String[] arguments){
        if(approved(arguments).isNull()){
            teamController.teamAdd(arguments);
            return Errors.NULL;
        } else{
            return approved(arguments);
        }
    }

    public boolean argumentsNeeded(String[] arguments) {
        return arguments.length == 3;
    }

}
