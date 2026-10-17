package SportsManager.controller;

import SportsManager.Model.Model;
import SportsManager.Model.lists.PlayerList;
import SportsManager.Model.lists.TeamList;
import SportsManager.Model.objects.Tournament;
import SportsManager.TournamentListView;

public class TournamentController extends Controller{

    TournamentListView tournamentListView = new TournamentListView();

    public void randomMatchmakingPlayer(String tournamentName) {
        model.getTournamentList().getItemByName(tournamentName).randomMatchmake((PlayerList) model.getTournamentList().getItemByName(tournamentName).getParticipantList());
    }

    public void randomMatchmakingTeam(String tournamentName) {
        model.getTournamentList().getItemByName(tournamentName).randomMatchmake((TeamList) model.getTournamentList().getItemByName(tournamentName).getParticipantList());
    }

    public void manualMatchmakingPlayer(String[] arguments) {
        model.getTournamentList().getItemByName(arguments[2]).matchmake(model.getPlayerList().getPlayerByEmail(arguments[3]), model.getPlayerList().getPlayerByEmail(arguments[4]));
    }

    public void manualMatchmakingTeam(String[] arguments) {
        model.getTournamentList().getItemByName(arguments[2]).matchmake(model.getTeamList().getItemByName(arguments[3]), model.getTeamList().getItemByName(arguments[4]));
    }

    public void tournamentAddPlayer(String tournamentName){
        model.getTournamentList().addParticipant(tournamentName, model.getPlayerList().getPlayerByEmail(model.getCurrentUser().getEmail()));
    }

    public void tournamentAddTeam(String tournamentName){
        model.getTournamentList().addParticipant(tournamentName, model.getTeamList().getItemByName(model.getPlayerList().getPlayerByEmail(model.getCurrentUser().getEmail()).getTeamName()));
    }

    public void tournamentRemovePlayer(String tournamentName) {
        model.getTournamentList().getItemByName(tournamentName).deletePlayer(model.getPlayerList().getPlayerByEmail(model.getCurrentUser().getEmail()));
    }

    public void tournamentRemoveTeam(String tournamentName) {
        model.getTournamentList().getItemByName(tournamentName).deleteTeam(model.getTeamList().getItemByName(model.getPlayerList().getPlayerByEmail(model.getCurrentUser().getEmail()).getTeamName()));
    }

    public void tournamentCreate(String[] arguments){
        Tournament newTournament = new Tournament(arguments[2], arguments[3], arguments[4], arguments[5]);
        newTournament.configureFor(arguments[1]);
        model.getTournamentList().addTournament(newTournament);
    }

    public void tournamentDelete(String tournamentName){
        model.getTournamentList().deleteItem(model.getTournamentList().getItemByName(tournamentName));
    }

    public void showTournamentListAuthenticated(){
        this.tournamentListView.showTournamentListAuthenticated(model);
    }

    public void showTournamentListNonAuthenticated(){
        this.tournamentListView.showTournamentListNonAuthenticated(model);
    }

    public Model getModel(){
        return model;
    }
}
