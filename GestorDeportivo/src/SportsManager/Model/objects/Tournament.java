package SportsManager.Model.objects;

import SportsManager.Model.HasName;
import SportsManager.Model.Participant;
import SportsManager.Model.lists.*;
import SportsManager.users.Player;

import java.time.LocalDateTime;
import java.util.Objects;

public class Tournament extends TournamentInformation {
    protected MatchList<? extends Participant> matchList = new MatchList<>();
    protected ParticipantList<? extends Participant> participantList = new ParticipantList<>() {
        @Override
        public void addItem(Participant item) {}
        @Override
        public void deleteItem(Participant item) {}
        @Override
        public Participant getItemByName(String name) {
            return null;
        }
    };

    private int capacity=0;

    public Tournament(String name, String league, String sport, String category) {
        super(name, league, sport, category);
    }

    public void handlePlayer() {
        this.matchList = new MatchList<Player>();
        this.participantList = new PlayerList();
    }

    public void handleTeam() {
        this.matchList = new MatchList<Team>();
        this.participantList = new TeamList();
    }

    public void configureFor(String type) {
        if(Objects.equals(type, "player")){
           new Player("", "", "", "").accept(this);
        }else if(Objects.equals(type, "team")){
            new Team("", new Player("","","",""), new Player("","","","")).accept(this);
        }
    }

    public void addPlayer(Player player) {
        if ((participantList instanceof PlayerList)) {
            PlayerList playerList = (PlayerList) participantList;
            playerList.addPlayer(player);
            this.capacity++;
        }
    }

    public void addTeam(Team team){
        if (participantList instanceof TeamList) {
            TeamList teamList = (TeamList) participantList;
            teamList.addTeam(team);
            this.capacity++;
        }
    }

    public void deletePlayer(Player player) {
        if (participantList instanceof PlayerList) {
            PlayerList playerList = (PlayerList) participantList;
            MatchList<Player> playerMatchList = (MatchList<Player>) this.matchList;
            playerList.deleteItem(player);
            playerMatchList.getMatchList().remove(playerMatchList.getMatch(player));
            this.capacity--;
        }
    }

    public void deleteTeam(Team team){
        if (participantList instanceof TeamList) {
            TeamList teamList = (TeamList) participantList;
            MatchList<Team> teamMatchList = (MatchList<Team>) this.matchList;
            teamList.deleteItem(team);
            teamMatchList.getMatchList().remove(teamMatchList.getMatch(team));
            this.capacity--;
        }
    }

    public <T extends HasName> void matchmake(T first, T second) {
        if (first instanceof Player && second instanceof Player) {
            MatchList<Player> playerMatchList = (MatchList<Player>) this.matchList;
            playerMatchList.matchmake((Player) first, (Player) second);
            this.capacity++;
        } else if (first instanceof Team && second instanceof Team) {
            MatchList<Team> teamMatchList = (MatchList<Team>) this.matchList;
            teamMatchList.matchmake((Team) first, (Team) second);
        }
    }

    public <T extends HasName> void randomMatchmake(AbstractList<T> participantList) {
        if (participantList.getCapacity() % 2 != 0) {
            if (participantList.getItem(0) instanceof Player) {
                MatchList<Player> playerMatchList = (MatchList<Player>) this.matchList;
                playerMatchList.randomMatchmake((PlayerList) participantList);
            } else if (participantList.getItem(0) instanceof Team) {
                MatchList<Team> teamMatchList = (MatchList<Team>) this.matchList;
                teamMatchList.randomMatchmake((TeamList) participantList);
            }
        }
    }

    public boolean isPlaying() {
        return beginning.isBefore(LocalDateTime.now());
    }

    public boolean isFinish(){
        return end.isAfter(LocalDateTime.now());
    }

    public ParticipantList<? extends Participant> getParticipantList() {
        return participantList;
    }

    public int getCapacity() {
        return capacity;
    }

    public MatchList<? extends Participant> getMatchList() {
        return matchList;
    }
}

//    public void setPlayerListNull(){
//        this.playerList = null;
//    }
//
//    public void setTeanListNull(){
//        this.teamList = null;
//    }
