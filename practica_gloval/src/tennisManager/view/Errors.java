package tennisManager.view;

import tennisManager.Show;

public enum Errors implements Show {

    UNAUTHORIZED_COMMAND("Permisos insuficientes"),
    COMMAND_NOT_FOUND("Comando no encontrado"),
    NON_EXISTING_REFEREE("No existe el arbitro"),
    WRONG_PASSWORD("Contraseña incorrecta"),
    SYNTAX_ERROR("Error de sintaxis"),
    FORMAT_ERROR("Error de formato"),
    EXISTING_REFEREE("Ya existe el arbitro"),
    NON_EXISTING_PLAYERS("No existen jugadores"),
    NON_EXISTING_PLAYER("No existe el jugador"),
    EXISTING_TEAM("Ya existe el equipo"),
    NON_EXISTING_TEAM("No existe el equipo"),
    EXISTING_TOURNAMENT("Ya existe el torneo"),
    NON_EXISTING_TOURNAMENT("No existe el torneo"),
    ALREADY_IN_TEAM("Ya se encuentra en un equipo"),
    NOT_IN_TEAM("No se encuentra en un equipo"),
    ALREADY_IN_TOURNAMENT("Ya se encuentra en el torneo"),
    NOT_IN_TOURNAMENT("No se encuentra en el torneo"),
    INVALID_MATCHMAKING("Emparejamiento invalido"),
    NON_EXISTING_MATCH("No existe el partido"),
    TOURNAMENT_ACTIVE("El torneo se encuentra en curso"),
    TOURNAMENT_NOT_ACTIVE("El torneo no se encuentra en curso"),
    ALREADY_LOGGED_IN("Ya hay alguien autenticado"),
    NOBODY_LOGGED_IN("No hay nadie autenticado"),
    INVALID_SETS("Sets invalidos"),
    MATCH_FINISHED("El partido ya ha acabado"),
    EXISTING_SESSION("La sesion ya existe"),
    NON_EXISTING_SESSION("La sesion no existe"),
    ERROR("Error"),
    NULL("Hecho");


    private final String message;

    Errors(String message){
        this.message = message;
    }

    public boolean isNull(){
        return this == Errors.NULL;
    }

    public String show() {
        return message;
    }
}
