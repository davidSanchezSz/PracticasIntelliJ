package SportsManager.commands.AdminCommands;

import SportsManager.Errors;
import SportsManager.Model.objects.Tournament;
import SportsManager.Model.Model;
import SportsManager.commands.CommandsInterface;
import SportsManager.controller.TournamentController;
import SportsManager.users.Player;

import java.util.Objects;

public class TournamentCreate implements CommandsInterface {

    private TournamentController tournamentController = new TournamentController();

    public Errors approved(String[] arguments){
        if(argumentsNeeded(arguments)){
            for(Tournament tournament : tournamentController.getModel().getTournamentList().getAll()){
                if(Objects.equals(tournament.getName(), arguments[1])){
                    return Errors.EXISTING_TOURNAMENT;
                }
            }
            return Errors.NULL;
        } else return Errors.FORMAT_ERROR;

    }

    public Errors execute(String[] arguments){
        if(approved(arguments).isNull()){
            tournamentController.tournamentCreate(arguments);
            return Errors.NULL;
        } else{
            return approved(arguments);
        }
    }

    public boolean argumentsNeeded(String[] arguments) {
        return arguments.length == 6;
    }
}
