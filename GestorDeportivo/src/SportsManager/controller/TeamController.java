package SportsManager.controller;

import SportsManager.Model.Model;
import SportsManager.Model.objects.Team;
import SportsManager.users.Player;

public class TeamController extends Controller{

    public void teamAdd(String[] arguments){
        model.getTeamList().addPlayer(arguments[1], model.getPlayerList().getPlayerByEmail(arguments[2]));
    }

    public void teamCreate(String[] arguments){
        Team newTeam = new Team(arguments[1], model.getPlayerList().getPlayerByEmail(arguments[2]), model.getPlayerList().getPlayerByEmail(arguments[3]));
        newTeam.setCreatedBy(model.getCurrentUser());
        model.getTeamList().addTeam(newTeam);
    }

    public void teamDelete(String[] arguments){
        Team team = model.getTeamList().getItemByName(arguments[1]);
        model.getTeamList().deleteItem(team);
        int i = 0;

        while(model.getTournamentList().getCapacity() > i){
            if(model.getTournamentList().getTournament(i).getParticipantList().getItemByName(team.getName())!=null){
                model.getTournamentList().getTournament(i).deleteTeam(team);
            }
            i++;
        }
    }

    public void teamRemove(String[] arguments){
        model.getTeamList().getItemByName(arguments[1]).removePlayer(model.getPlayerList().getPlayerByEmail(arguments[2]));
    }

    public Model getModel(){
        return model;
    }
}
