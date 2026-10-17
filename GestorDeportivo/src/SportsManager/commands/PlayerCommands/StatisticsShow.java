package SportsManager.commands.PlayerCommands;

import SportsManager.Errors;
import SportsManager.Model.Model;
import SportsManager.commands.CommandsInterface;
import SportsManager.controller.StatsController;
import SportsManager.users.Player;

import java.util.Objects;

public class StatisticsShow implements CommandsInterface {

    private StatsController statsController = new StatsController();

    public Errors approved(String[] arguments){
        if(argumentsNeeded(arguments)){
            if(!Objects.equals(arguments[1], "-csv") && !Objects.equals(arguments[1], "-json")){
                return Errors.SYNTAX_ERROR;
            }
            return Errors.NULL;
        }else{
            return Errors.FORMAT_ERROR;
        }
    }

    public Errors execute(String[] arguments){
        if(Objects.equals(arguments[1], "-csv")){
            statsController.showStatsCSV();
            return Errors.NULL;
        }else if(Objects.equals(arguments[1], "-json")){
            statsController.showStatsJSON();
            return Errors.NULL;
        } else {
            return approved(arguments);
        }
    }

    public boolean argumentsNeeded(String[] arguments) {
        return arguments.length == 2;
    }

}
