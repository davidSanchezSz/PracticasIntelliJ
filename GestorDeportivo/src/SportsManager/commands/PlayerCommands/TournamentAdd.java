package SportsManager.commands.PlayerCommands;

import SportsManager.Errors;
import SportsManager.Model.Model;
import SportsManager.commands.CommandsInterface;
import SportsManager.controller.PlayerController;
import SportsManager.controller.TournamentController;
import SportsManager.users.Player;

import java.util.Objects;

public class TournamentAdd implements CommandsInterface {

    private TournamentController tournamentController = new TournamentController();

    public Errors approved(String[] arguments){
        Model model = tournamentController.getModel();
        if(argumentsNeeded(arguments)){
            if(!Objects.equals(arguments[1], "-player") && !Objects.equals(arguments[1], "-team")){
                return Errors.SYNTAX_ERROR;
            }
            if(model.getTournamentList().getItemByName(arguments[2]) == null){
                return Errors.NON_EXISTING_TOURNAMENT;
            }
            if(isPlaying(model, model.getPlayerList().getPlayerByEmail(model.getCurrentUser().getEmail()))){
                return Errors.TOURNAMENT_ACTIVE;
            }
            if(isInTournament(arguments, model)){
                return Errors.ALREADY_IN_TOURNAMENT;
            }
            return Errors.NULL;
        }else{
            return Errors.FORMAT_ERROR;
        }
    }

    public Errors execute(String[] arguments){
        if(Objects.equals(arguments[1], "-player")){
            tournamentController.tournamentAddPlayer(arguments[2]);
            return Errors.NULL;
        }else if(Objects.equals(arguments[1], "-team")){
            tournamentController.tournamentAddTeam(arguments[2]);
            return Errors.NULL;
        } else {
            return approved(arguments);
        }
    }

    public boolean isPlaying(Model model, Player player) {
        int  i =0;
        while(model.getTournamentList().getTournament(i) != null && !(player.isPlaying(model.getTournamentList().getItem(i)))){
            i++;
        }
        if(model.getTournamentList().getTournament(i) != null && !(player.isPlaying(model.getTournamentList().getItem(i)))){
            return true;
        }else{
            return false;
        }
    }

    private boolean isInTournament(String[] arguments, Model model){
        return model.getTournamentList().getItemByName(arguments[2]).getParticipantList().getItemByName(model.getPlayerList().getPlayerByEmail(model.getCurrentUser().getEmail()).getName()) != null || model.getTournamentList().getItemByName(arguments[2]).getParticipantList().getItemByName(model.getPlayerList().getPlayerByEmail(model.getCurrentUser().getEmail()).getTeamName()) != null;
    }
    public boolean argumentsNeeded(String[] arguments) {
        return arguments.length == 3;
    }
}
