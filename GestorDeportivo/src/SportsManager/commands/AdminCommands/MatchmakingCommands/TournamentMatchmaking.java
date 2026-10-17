package SportsManager.commands.AdminCommands.MatchmakingCommands;

import SportsManager.Errors;
import SportsManager.MatchmakingCommands;
import SportsManager.commands.CommandsInterface;
import java.util.*;

public class TournamentMatchmaking implements CommandsInterface {

    private ArrayList<MatchmakingCommandsInterface> commands;

    public TournamentMatchmaking() {
        this.commands = new ArrayList<>();
    }

    public void inicializeCommands(){
        commands.add(new ManualMatchmaking());
        commands.add(new RandomMatchmaking());
    }

    public Errors approved(String[] arguments) {
        if(!argumentsNeeded(arguments)){
            return Errors.FORMAT_ERROR;
        }
        return Errors.NULL;
    }

    public Errors execute(String[] arguments) {
        inicializeCommands();

        if(approved(arguments).isNull()){
            for (MatchmakingCommands command : MatchmakingCommands.values()) {
                if(Objects.equals(command.getCommand().getKey(), arguments[1]) && argumentsNeeded(arguments)) {
                    return command.getCommand().execute(arguments);
                }
            }
            return Errors.SYNTAX_ERROR;
        }
        return approved(arguments);
    }

    public boolean argumentsNeeded(String[] arguments) {
        return arguments.length == 5 || arguments.length == 3;
    }

}
