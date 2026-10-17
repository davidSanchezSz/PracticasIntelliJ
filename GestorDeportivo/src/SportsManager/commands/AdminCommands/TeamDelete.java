package SportsManager.commands.AdminCommands;

import SportsManager.Errors;
import SportsManager.Model.objects.Team;
import SportsManager.Model.Model;
import SportsManager.commands.CommandsInterface;
import SportsManager.controller.TeamController;

import java.util.Objects;

public class TeamDelete implements CommandsInterface {

    private TeamController teamController = new TeamController();

    public Errors approved(String[] arguments){
        if(argumentsNeeded(arguments)){
            for(Team team : teamController.getModel().getTeamList().getAll()){
                if(Objects.equals(team.getName(), arguments[1])){
                    if(!isPlaying(teamController.getModel(), team)){
                        return Errors.NULL;
                    }else{
                        return Errors.TOURNAMENT_ACTIVE;
                    }
                }
            }
            return Errors.NON_EXISTING_TEAM;
        } else return Errors.FORMAT_ERROR;

    }

    public Errors execute(String[] arguments){
        if(approved(arguments).isNull()){
            teamController.teamDelete(arguments);
            return Errors.NULL;
        } else{
            return approved(arguments);
        }
    }

    public boolean isPlaying(Model model, Team team) {
        int  i =0;
        boolean isPlaying;

        while(model.getTournamentList().getTournament(i) != null && !(team.isPlaying(model.getTournamentList().getItem(i)))){
            i++;
        }
        if(model.getTournamentList().getTournament(i) != null && !(team.isPlaying(model.getTournamentList().getItem(i)))){
            isPlaying = true;

        }else{
            isPlaying = false;
        }
        return isPlaying;
    }

    public boolean argumentsNeeded(String[] arguments) {
        return arguments.length == 2;
    }
}
