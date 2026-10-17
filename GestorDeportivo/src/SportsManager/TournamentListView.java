package SportsManager;

import SportsManager.Model.Model;
import SportsManager.Model.lists.PlayerList;
import SportsManager.Model.lists.TeamList;
import SportsManager.Model.objects.Tournament;

import java.util.Iterator;

public class TournamentListView {

    public void showTournamentListAuthenticated(Model model) {
        Iterator<Tournament> iterator = model.getTournamentList().getAll().iterator();
        while (iterator.hasNext()) {
            Tournament tournament = iterator.next();
            System.out.println(tournament.getName());
            if (tournament.getParticipantList() instanceof PlayerList) {
                PlayerList tournamentParticipantList = (PlayerList) tournament.getParticipantList();
                tournamentParticipantList.show(tournament.getCategory());
                System.out.println();
            } else if (tournament.getParticipantList() instanceof TeamList) {
                TeamList tournamentParticipantList = (TeamList) tournament.getParticipantList();
                tournamentParticipantList.show(tournament.getCategory());
                System.out.println();

            }
        }
    }

    public void showTournamentListNonAuthenticated(Model model){
            Iterator<Tournament> iterator = model.getTournamentList().getAll().iterator();
            while (iterator.hasNext()) {
                Tournament tournament = iterator.next();
                System.out.println(tournament.getName());
                if(tournament.getParticipantList() instanceof PlayerList){
                    ((PlayerList) tournament.getParticipantList()).rankPlayer(tournament.getCategory());
                } else if (tournament.getParticipantList() instanceof TeamList) {
                    ((TeamList) tournament.getParticipantList()).rankTeam(tournament.getCategory());
                }
                System.out.println();
            }
    }
}
