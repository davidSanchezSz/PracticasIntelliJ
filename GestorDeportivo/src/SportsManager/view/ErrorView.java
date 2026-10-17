package SportsManager.view;

import SportsManager.Errors;

public class ErrorView {

    public final String[] message = {

            "Permisos insuficientes",
            "Comando no encontrado",
            "No existe el usuario",
            "Contraseña incorrecta",
            "Error de sintaxis",
            "Error de formato",
            "Ya existe el jugador",
            "No existe el jugador",
            "Ya existe el equipo",
            "No existe el equipo",
            "Ya existe el torneo",
            "No existe el torneo",
            "Ya se encuentra en un equipo",
            "No se encuentra en un equipo",
            "Ya se encuentra en el torneo",
            "No se encuentra en el torneo",
            "Emparejamiento invalido",
            "El torneo se encuentra en curso",
            "El torneo no se encuentra en curso",
            "Ya hay alguien autenticado",
            "No hay nadie autenticado",
            "Datos no encontrados",
            "Error",
            "Hecho"
    };

    public void printError(Errors error){
        System.out.println(message[error.ordinal()]);
    }
}
