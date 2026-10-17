package SportsManager.commands.AdminCommands;

import SportsManager.Errors;
import SportsManager.Model.Model;
import SportsManager.Model.objects.Tournament;
import SportsManager.commands.CommandsInterface;
import SportsManager.controller.TournamentController;

import java.util.Objects;

public class TournamentDelete implements CommandsInterface {

    private TournamentController tournamentController = new TournamentController();

    public Errors approved(String[] arguments){
        if(argumentsNeeded(arguments)){
            for(Tournament tournament : tournamentController.getModel().getTournamentList().getAll()){
                if(Objects.equals(tournament.getName(), arguments[1])){
                    return Errors.NULL;
                }
            }
            return Errors.NON_EXISTING_TOURNAMENT;
        } else return Errors.FORMAT_ERROR;

    }

    public Errors execute(String[] arguments){
        if(approved(arguments).isNull()){
            tournamentController.tournamentDelete(arguments[1]);
            return Errors.NULL;
        } else{
            return approved(arguments);
        }
    }

    public boolean argumentsNeeded(String[] arguments) {
        return arguments.length == 2;
    }
}
