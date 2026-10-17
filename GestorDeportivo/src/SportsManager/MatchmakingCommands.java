package SportsManager;

import SportsManager.commands.AdminCommands.MatchmakingCommands.ManualMatchmaking;
import SportsManager.commands.AdminCommands.MatchmakingCommands.MatchmakingCommandsInterface;
import SportsManager.commands.AdminCommands.MatchmakingCommands.RandomMatchmaking;

public enum MatchmakingCommands {

    MANUAL_MATCHMAKING("manual_matchmaking", new ManualMatchmaking()),
    RANDOM_MATCHMAKING("random_matchmaking", new RandomMatchmaking());

    private final String name;
    private final MatchmakingCommandsInterface matchmakingCommandsInterface;


    MatchmakingCommands(String name, MatchmakingCommandsInterface matchmakingCommandsInterface) {
        this.name = name;
        this.matchmakingCommandsInterface = matchmakingCommandsInterface;
    }

    public MatchmakingCommandsInterface getCommand(){
        return matchmakingCommandsInterface;
    }

    public String getName(){
        return name;
    }

}
