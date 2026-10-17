package SportsManager.Model.lists;

import SportsManager.Model.Participant;
import SportsManager.Model.objects.Team;
import SportsManager.Model.objects.Tournament;
import SportsManager.users.Player;

public class TournamentList extends AbstractList<Tournament> {

    public <T extends Participant> void addParticipant(String tournamentName, T participant) {
        if (!containsParticipant(tournamentName, participant)) {
            if(getItemByName(tournamentName).getParticipantList() instanceof PlayerList){
                getItemByName(tournamentName).addPlayer((Player) participant);
            }else{
                getItemByName(tournamentName).addTeam((Team) participant);
            }
        }

    }

    public Tournament getTournament(int tournament){
        if(tournament<this.capacity){
            return this.getItem(tournament);
        }else{
            return null;
        }
    }

    public <T extends Participant> boolean containsParticipant(String name, T participant){
         return getItemByName(name)!=null && getItemByName(name).getParticipantList().getItemByName(participant.getName()) != null;
    }

    public void addTournament(Tournament tournament){
        if(this.getItemByName(tournament.getName())==null){
            this.addItem(tournament);
        }
    }
}
