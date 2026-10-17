package SportsManager.view;

public class StartView {

    public void printMenu(){
        System.out.println("Comandos publicos: ");
        System.out.println("   Login (email) (password)   Logout   TournamentList");
        System.out.println();
        System.out.println("Comandos del jugador: ");
        System.out.println("   StatisticsShow    TournamentAdd -(jugador/equipo) (torneo)    TournamentRemove -(jugador/equipo) (torneo)");
        System.out.println();
        System.out.println("Comandos de admin: ");
        System.out.println("   TournamentMatchmaking -(tipo) (torneo) (emailjugador/equipo) (emailjugador/equipo)    PlayerCreate (email) (contraseña) (nombre) (apellido) ");
        System.out.println("   PlayerDelete (emailjugador)    TeamAdd (equipo) (emailjugador)    TeamCreate (equipo) (emailjugador) (emailjugador)    TeamDelete (equipo) ");
        System.out.println("   TeamRemove (equipo) (emailjugador)   TournamentCreate (nombre) (liga) (deporte) (categoria)   TournamentDelete (torneo)");
        System.out.println();
        System.out.println("Introduce el email y contraseña para acceder");
        System.out.println();
    }

}
