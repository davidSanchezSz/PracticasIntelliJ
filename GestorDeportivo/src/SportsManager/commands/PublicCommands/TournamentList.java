package SportsManager.commands.PublicCommands;

import SportsManager.Errors;
import SportsManager.Model.Model;
import SportsManager.Model.objects.Tournament;
import SportsManager.Model.lists.PlayerList;
import SportsManager.Model.lists.TeamList;
import SportsManager.commands.CommandsInterface;
import SportsManager.controller.TournamentController;
import SportsManager.controller.UserController;
import SportsManager.users.User;

import java.util.Iterator;
import java.util.Objects;

public class TournamentList implements CommandsInterface {

    private TournamentController tournamentController = new TournamentController();

    public Errors approved(String[] arguments){
        if(argumentsNeeded(arguments)){
            return Errors.NULL;
        }else{
            return Errors.FORMAT_ERROR;
        }
    }

    public Errors execute(String[] arguments){
        if(approved(arguments).isNull()){
            if(tournamentController.getModel().getCurrentUser() == null){
                tournamentController.showTournamentListAuthenticated();
            }else{
                tournamentController.showTournamentListNonAuthenticated();
            }
            return Errors.NULL;
        } else{
            return approved(arguments);
        }
    }

    public boolean argumentsNeeded(String[] arguments) {
        return arguments.length == 1;
    }

}
//public void execute(String[] arguments, Model model){
//    if(argumentsNeeded(arguments)){
//        if (model.getCurrentUser() == null) {
//            Iterator<Tournament> iterator = model.getTournamentList().getAll().iterator();
//            while (iterator.hasNext()) {
//                Tournament tournament = iterator.next();
//                System.out.println(tournament.getName());
//                if(tournament.getParticipantList() instanceof PlayerList){
//                    PlayerList tournamentParticipantList = (PlayerList) tournament.getParticipantList();
//                    tournamentParticipantList.show(tournament.getCategory());
//                    System.out.println();
//                } else if (tournament.getParticipantList() instanceof TeamList){
//                    TeamList tournamentParticipantList = (TeamList) tournament.getParticipantList();
//                    tournamentParticipantList.show(tournament.getCategory());
//                    System.out.println();
//
//                }
//
//            }
//
//        }else{
//            Iterator<Tournament> iterator = model.getTournamentList().getAll().iterator();
//            while (iterator.hasNext()) {
//                Tournament tournament = iterator.next();
//                System.out.println(tournament.getName());
//                if(tournament.getParticipantList() instanceof PlayerList){
//                    ((PlayerList) tournament.getParticipantList()).rankPlayer(tournament.getCategory());
//                } else if (tournament.getParticipantList() instanceof TeamList) {
//                    ((TeamList) tournament.getParticipantList()).rankTeam(tournament.getCategory());
//                }
//                System.out.println();
//            }
//        }
//    }
//
//}