package SportsManager.commands.AdminCommands.MatchmakingCommands;

import SportsManager.Errors;
import SportsManager.Model.lists.MatchList;
import SportsManager.Model.objects.Team;
import SportsManager.commands.CommandsInterface;
import SportsManager.Model.Model;
import SportsManager.Model.lists.PlayerList;
import SportsManager.Model.lists.TeamList;
import SportsManager.controller.TournamentController;
import SportsManager.users.Player;

import java.util.Objects;

public class RandomMatchmaking implements CommandsInterface, MatchmakingCommandsInterface {
    private String key = "-r";
    private TournamentController tournamentController = new TournamentController();

    public Errors execute(String[] arguments){
        if(approved(arguments).isNull()){
            if(Objects.equals(arguments[1], "-player")){
                tournamentController.randomMatchmakingPlayer(arguments[2]);
            } else if(Objects.equals(arguments[1], "-team")) {
                tournamentController.randomMatchmakingTeam(arguments[2]);
            }
            return Errors.NULL;
        }else {
            return approved(arguments);

        }
    }

    public Errors approved(String[] arguments){
        if(argumentsNeeded(arguments)){
            if(Objects.equals(arguments[1], "-player")){
                if(tournamentController.getModel().getTournamentList().getItemByName(arguments[2]) == null){
                    return Errors.NON_EXISTING_TOURNAMENT;
                }
                if(!isPlayerTournament(arguments, tournamentController.getModel())){
                    return Errors.INVALID_DATA;
                }
                if(isPlaying(arguments)){
                    return Errors.TOURNAMENT_ACTIVE;
                }
                return Errors.NULL;
            }
            else if(Objects.equals(arguments[1], "-team")){
                if(tournamentController.getModel().getTournamentList().getItemByName(arguments[2]) == null){
                    return Errors.NON_EXISTING_TOURNAMENT;
                }
                if(isPlayerTournament(arguments, tournamentController.getModel())){
                    return Errors.INVALID_DATA;
                }
                if(isPlaying(arguments)){
                    return Errors.TOURNAMENT_ACTIVE;
                }
                return Errors.NULL;
            }
            else{
                return Errors.SYNTAX_ERROR;
            }
        }else return Errors.FORMAT_ERROR;
    }

    public String getKey() {
        return key;
    }

    public boolean isPlayerTournament(String[] arguments, Model model){
        return model.getTournamentList().getItemByName(arguments[2]).getParticipantList() instanceof PlayerList;
    }

    public boolean isPlaying(String[] arguments){
        return tournamentController.getModel().getTournamentList().getItemByName(arguments[2]).isPlaying();
    }
    public boolean argumentsNeeded(String[] arguments) {
        return arguments.length == 3;
    }
}
