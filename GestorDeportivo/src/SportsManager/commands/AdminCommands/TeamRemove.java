package SportsManager.commands.AdminCommands;

import SportsManager.Errors;
import SportsManager.Model.Model;
import SportsManager.Model.objects.Team;
import SportsManager.commands.CommandsInterface;
import SportsManager.controller.TeamController;
import SportsManager.users.Player;

import java.util.Objects;

public class TeamRemove implements CommandsInterface {

    private TeamController teamController = new TeamController();

    public Errors approved(String[] arguments){
        if(argumentsNeeded(arguments)){
            if(teamController.getModel().getPlayerList().getPlayerByEmail(arguments[2]) == null){
                return Errors.NOT_IN_TEAM;
            }
            for(Team team : teamController.getModel().getTeamList().getAll()){
                if(Objects.equals(team.getName(), arguments[1])){
                    for(Player player : teamController.getModel().getTeamList().getItemByName(team.getName()).getPlayerList().getAll()){
                        if(Objects.equals(player.getEmail(), arguments[2])){
                            return Errors.NULL;
                        }
                    }
                    return Errors.NON_EXISTING_PLAYER;
                }
            }
            return Errors.NON_EXISTING_TEAM;
        } else return Errors.FORMAT_ERROR;

    }

    public Errors execute(String[] arguments){
        if(approved(arguments).isNull()){
            teamController.teamRemove(arguments);
            return Errors.NULL;
        } else{
            return approved(arguments);
        }
    }

    public boolean argumentsNeeded(String[] arguments) {
        return arguments.length == 3;
    }
}


