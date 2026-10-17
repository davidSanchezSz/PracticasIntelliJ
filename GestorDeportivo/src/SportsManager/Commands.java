package SportsManager;

import SportsManager.Model.Model;
import SportsManager.commands.AdminCommands.*;
import SportsManager.commands.AdminCommands.MatchmakingCommands.TournamentMatchmaking;
import SportsManager.commands.CommandsInterface;
import SportsManager.commands.PlayerCommands.StatisticsShow;
import SportsManager.commands.PublicCommands.Login;
import SportsManager.commands.PublicCommands.Logout;
import SportsManager.commands.PublicCommands.TournamentList;

public enum Commands {

    LOGIN("Login", "Public",new Login(getModel())),
    LOGOUT("Logout", "Public", new Logout(getModel())),
    LIST_TOURNAMENT("TournamentList", "Public", new TournamentList()),
    CREATE_PLAYER("PlayerCreate", "Admin", new PlayerCreate(getModel())),
    DELETE_PLAYER("PlayerDelete", "Admin", new PlayerDelete(getModel())),
    CREATE_TEAM("TeamCreate", "Admin", new TeamCreate()),
    DELETE_TEAM("TeamDelete", "Admin", new TeamCreate()),
    CREATE_TOURNAMENT("TournamentCreate", "Admin", new TournamentCreate()),
    DELETE_TOURNAMENT("TournamentDelete", "Admin", new TournamentDelete()),
    ADD_TEAM("TeamAdd", "Admin", new TeamAdd()),
    REMOVE_TEAM("TeamRemove", "Admin", new TeamRemove()),
    MATCHMAKING_TOURNAMENT("TournamentMatchmaking", "Admin", new TournamentMatchmaking()),
    ADD_TOURNAMENT("TournamentAdd", "Player", new TournamentCreate()),
    REMOVE_TOURNAMENT("TournamentRemove", "Player", new TournamentDelete()),
    SHOW_STATISTICS("StatisticsShow", "Player", new StatisticsShow());


//    SAVEALL(),
//    RECOVERYALL();

    private final String name;
    private final String commandType;
    private static Model model = new Model();
    private final CommandsInterface commandsInterface;


    Commands(String name, String commandType, CommandsInterface commandsInterface){
        this.name = name;
        this.commandType = commandType;
        this.commandsInterface = commandsInterface;
    }

    public String getCommandType(){
        return commandType;
    }

    public void setModel(Model model){
        this.model = model;
    }

    public static Model getModel(){
        return model;
    }

    public CommandsInterface getCommand(){
        return commandsInterface;
    }

    public String getName(){
        return name;
    }
}
