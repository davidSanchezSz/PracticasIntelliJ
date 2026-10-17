package SportsManager.commands.PlayerCommands;

import SportsManager.Errors;
import SportsManager.Model.Model;
import SportsManager.commands.CommandsInterface;
import SportsManager.controller.TournamentController;

import java.util.Objects;

public class TournamentRemove implements CommandsInterface {

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
            return Errors.NULL;
        }else{
            return Errors.FORMAT_ERROR;
        }
    }

    public Errors execute(String[] arguments){
        if(Objects.equals(arguments[1], "-player")){
            tournamentController.tournamentRemovePlayer(arguments[2]);
            return Errors.NULL;
        }else if(Objects.equals(arguments[1], "-team")){
            tournamentController.tournamentRemoveTeam(arguments[2]);
            return Errors.NULL;
        } else {
            return approved(arguments);
        }
    }

    public boolean argumentsNeeded(String[] arguments) {
        return arguments.length == 3;
    }
}


