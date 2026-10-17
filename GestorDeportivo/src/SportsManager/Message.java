//package SportsManager;
//
//public enum Message {
//
//    PLAYER_CREATED("Jugador creado", Commands.CREATE_PLAYER),
//    PLAYER_DELETED("Jugador eliminado", Commands.DELETE_PLAYER),
//    TEAM_CREATED("Equipo creado", Commands.CREATE_TEAM),
//    TEAM_DELETED("Equipo eliminado", Commands.DELETE_TEAM),
//    TOURNAMENT_CREATED("Torneo creado", Commands.CREATE_TOURNAMENT),
//    TOURNAMENT_DELETED("Torneo eliminado", Commands.DELETE_TOURNAMENT),
//    PLAYER_ADDED("Jugador añadido al torneo", Commands.ADD_TOURNAMENT),
//    PLAYER_ADDED_TEAM("Jugador añadido al equipo", Commands.ADD_TEAM),
//    PLAYER_REMOVED("Jugador eliminado del equipo", Commands.REMOVE_TEAM),
//    LOGGED_IN("Has iniciado sesion", Commands.LOGIN),
//    LOGGED_OUT("Has cerrado sesion", Commands.LOGOUT);
//
//    private final String message;
//    private final Commands command;
//
//    Message(String message, Commands commands){
//        this.message = message;
//        this.command = commands;
//    }
//
//    public Commands getCommand(){
//        return command;
//    }
//
//    public void writeMessage(Message message){
//        System.out.println(message.toString());
//    }
//
//    public String toString(){
//        return message;
//    }
//}
