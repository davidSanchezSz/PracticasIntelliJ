package SportsManager.commands.AdminCommands;

import SportsManager.Errors;
import SportsManager.Model.objects.Team;
import SportsManager.Model.Model;
import SportsManager.commands.CommandsInterface;
import SportsManager.controller.TeamController;
import SportsManager.users.Player;

import java.util.Objects;

public class TeamCreate implements CommandsInterface {

    private TeamController teamController = new TeamController();

    public Errors approved(String[] arguments){
        if(argumentsNeeded(arguments)){
            for(Team team : teamController.getModel().getTeamList().getAll()){
                if(Objects.equals(team.getName(), arguments[1])){
                    return Errors.EXISTING_TEAM;
                }
            }
            return Errors.NULL;
        } else return Errors.FORMAT_ERROR;

    }

    public Errors execute(String[] arguments){
        if(approved(arguments).isNull()){
            teamController.teamCreate(arguments);
            return Errors.NULL;
        } else{
            return approved(arguments);
        }
    }

    public boolean argumentsNeeded(String[] arguments) {
        return arguments.length == 4;
    }
}
