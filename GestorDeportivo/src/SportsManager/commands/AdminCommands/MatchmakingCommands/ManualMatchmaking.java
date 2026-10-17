package SportsManager.commands.AdminCommands.MatchmakingCommands;

import SportsManager.Errors;
import SportsManager.Model.lists.MatchList;
import SportsManager.Model.objects.Team;
import SportsManager.commands.CommandsInterface;
import SportsManager.Model.Model;
import SportsManager.Model.lists.PlayerList;
import SportsManager.controller.TournamentController;
import SportsManager.users.Player;

import java.util.Objects;

public class ManualMatchmaking implements CommandsInterface, MatchmakingCommandsInterface {
    private String key = "-m";
    private TournamentController tournamentController = new TournamentController();

    public Errors execute(String[] arguments){
        if(approved(arguments).isNull()){
            if(Objects.equals(arguments[1], "-player")){
                tournamentController.manualMatchmakingPlayer(arguments);
            } else if(Objects.equals(arguments[1], "-team")) {
                tournamentController.manualMatchmakingTeam(arguments);
            }
            return Errors.NULL;
        }else {
            return approved(arguments);

        }
    }

    public Errors approved(String[] arguments){
        if(argumentsNeeded(arguments)){
            if(Objects.equals(arguments[1], "-player")){
                if(tournamentController.getModel().getPlayerList().getPlayerByEmail(arguments[3]) == null && tournamentController.getModel().getPlayerList().getPlayerByEmail(arguments[4]) == null){
                   return Errors.NON_EXISTING_PLAYER;
                }
                if(tournamentController.getModel().getTournamentList().getItemByName(arguments[2]) == null){
                    return Errors.NON_EXISTING_TOURNAMENT;
                }
                if(!isPlayerTournament(arguments, tournamentController.getModel())){
                    return Errors.INVALID_DATA;
                }
                if(isPlaying(arguments)){
                    return Errors.TOURNAMENT_NOT_ACTIVE;
                }
                Player firstPlayer = tournamentController.getModel().getPlayerList().getPlayerByEmail(arguments[3]);
                Player secondPlayer = tournamentController.getModel().getPlayerList().getPlayerByEmail(arguments[4]);

                if(!(tournamentController.getModel().getTournamentList().containsParticipant(arguments[2], firstPlayer) && !(tournamentController.getModel().getTournamentList().containsParticipant(arguments[2], secondPlayer)))){
                    return Errors.NOT_IN_TOURNAMENT;
                }
                MatchList<Player> playerMatchList = (MatchList<Player>) tournamentController.getModel().getTournamentList().getItemByName(arguments[1]).getMatchList();
                if(playerMatchList.getMatch(firstPlayer).getFirst() != null && playerMatchList.getMatch(secondPlayer).getFirst() != null){
                    return Errors.INVALID_MATCHMAKING;
                }else{
                    return Errors.NULL;
                }
            }
            else if(Objects.equals(arguments[1], "-team")){
                if(tournamentController.getModel().getTeamList().getItemByName(arguments[3]) == null && tournamentController.getModel().getTeamList().getItemByName(arguments[4]) == null){
                    return Errors.NON_EXISTING_TEAM;
                }
                if(tournamentController.getModel().getTournamentList().getItemByName(arguments[2]) == null){
                    return Errors.NON_EXISTING_TOURNAMENT;
                }
                if(isPlayerTournament(arguments, tournamentController.getModel())){
                    return Errors.INVALID_DATA;
                }
                if(isPlaying(arguments)){
                    return Errors.TOURNAMENT_NOT_ACTIVE;
                }
                Team firstTeam = tournamentController.getModel().getTeamList().getItemByName(arguments[3]);
                Team secondTeam = tournamentController.getModel().getTeamList().getItemByName(arguments[4]);

                if(!(tournamentController.getModel().getTournamentList().containsParticipant(arguments[2], firstTeam) && !(tournamentController.getModel().getTournamentList().containsParticipant(arguments[2], secondTeam)))){
                    return Errors.NOT_IN_TOURNAMENT;
                }
                MatchList<Team> teamMatchList = (MatchList<Team>) tournamentController.getModel().getTournamentList().getItemByName(arguments[1]).getMatchList();
                if(teamMatchList.getMatch(firstTeam).getFirst() != null && teamMatchList.getMatch(secondTeam).getFirst() != null){
                    return Errors.INVALID_MATCHMAKING;
                }else{
                    return Errors.NULL;
                }
            }
            else{
                return Errors.SYNTAX_ERROR;
            }
        }else return Errors.FORMAT_ERROR;
    }

    public boolean isPlaying(String[] arguments){
        return tournamentController.getModel().getTournamentList().getItemByName(arguments[2]).isPlaying();
    }

    public boolean isPlayerTournament(String[] arguments, Model model){
        return model.getTournamentList().getItemByName(arguments[2]).getParticipantList() instanceof PlayerList;
    }

    public boolean argumentsNeeded(String[] arguments) {
        return arguments.length == 5;
    }

    public String getKey() {
        return key;
    }
}