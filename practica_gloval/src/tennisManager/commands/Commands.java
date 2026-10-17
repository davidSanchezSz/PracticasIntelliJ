package tennisManager.commands;

import tennisManager.commands.publicCommands.CreateReferee;
import tennisManager.commands.publicCommands.Login;
import tennisManager.commands.publicCommands.Logout;
import tennisManager.commands.refereeCommands.*;

public enum Commands {

    CREATE_REFEREE("CreateReferee", "Public", new CreateReferee()),
    LOGIN("Login", "Public", new Login()),
    LOGOUT("Logout", "Public", new Logout()),
    CREATE_MATCH("CreateMatch", "Referee", new CreateMatch()),
    CREATE_PLAYER("CreatePlayer", "Referee", new CreatePlayer()),
    LACK_SERVICE("LackService", "Referee", new LackService()),
    POINT_REST("PointRest", "Referee", new PointRest()),
    POINT_SERVICE("PointService", "Referee", new PointService()),
    READ_MATCH("ReadMatch", "Referee", new ReadMatch()),
    READ_PLAYER("ReadPlayer", "Referee", new ReadPlayer()),
    READ_PLAYERS("ReadPlayers", "Referee", new ReadPlayers());

    private final String name;
    private final String commandType;
    private final CommandsInterface commandsInterface;


    Commands(String name, String commandType, CommandsInterface commandsInterface){
        this.name = name;
        this.commandType = commandType;
        this.commandsInterface = commandsInterface;
    }

    public String getCommandType(){
        return commandType;
    }

    public CommandsInterface getCommand(){
        return commandsInterface;
    }

    public String getName(){
        return name;
    }
}
