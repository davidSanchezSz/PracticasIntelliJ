package SportsManager.Model;

import SportsManager.Commands;
import SportsManager.Errors;
import SportsManager.Model.objects.Team;
import SportsManager.Model.objects.Tournament;
import SportsManager.Model.lists.PlayerList;
import SportsManager.Model.lists.TeamList;
import SportsManager.Model.lists.TournamentList;
import SportsManager.users.Admin;
import SportsManager.users.Player;
import SportsManager.users.User;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Model {
    protected User currentUser;
    protected TournamentList tournamentList;
    protected TeamList teamList;
    protected PlayerList playerList;
    protected ArrayList<User> users;

    protected List<Integer> dnis;

    public Model() {
        this.currentUser = null;
        this.tournamentList = new TournamentList();
        this.teamList = new TeamList();
        this.playerList = new PlayerList();
        this.users = new ArrayList<>();
        this.dnis = new ArrayList<>();
        initializeControl();
    }

    private void initializeControl() {
        Admin admin = new Admin("david@gmail", "david"){};
        Player pablo = new Player("pablo@gmail", "pablo", "pablo", "sanchez");
        pablo.setScore("markedpoints", 2.3);
        pablo.setScore("matcheswon", 1.0);
        pablo.setScore("assistpoints", 0.0);
        pablo.setScore("tournamentswon", 2.1);
        pablo.setScore("money", 5.2);
        pablo.setDni(this);

        Player diego = new Player("diego@gmail", "diego", "diego", "campelo");
        diego.setScore("markedpoints", 1.3);
        diego.setScore("matcheswon", 2.3);
        diego.setScore("assistpoints", 3.1);
        diego.setScore("tournamentswon", 0.0);
        diego.setScore("money", 6.3);
        diego.setDni(this);

        Player pedro = new Player("pedro@gmail", "pedro", "pedro", "sanchez");
        pedro.setScore("markedpoints", 5.2);
        pedro.setScore("matcheswon", 5.7);
        pedro.setScore("assistpoints", 0.4);
        pedro.setScore("tournamentswon", 7.1);
        pedro.setScore("money", 9.2);
        pedro.setDni(this);

        Player claudia = new Player("claudia@gmail", "claudia", "claudia", "campelo");
        claudia.setScore("markedpoints", 5.3);
        claudia.setScore("matcheswon", 8.0);
        claudia.setScore("assistpoints", 4.1);
        claudia.setScore("tournamentswon", 5.0);
        claudia.setScore("money", 1.3);
        claudia.setDni(this);

        Player lucas = new Player("lucas@gmail", "lucas", "lucas", "nuñez");
        lucas.setScore("markedpoints", 5.8);
        lucas.setScore("matcheswon", 9.9);
        lucas.setScore("assistpoints", 7.3);
        lucas.setScore("tournamentswon", 1.3);
        lucas.setScore("money", 2.3);
        lucas.setDni(this);

        Player hugo = new Player("hugo@gmail", "hugo", "hugo", "pirajno");
        hugo.setScore("markedpoints", 0.3);
        hugo.setScore("matcheswon", 4.3);
        hugo.setScore("assistpoints", 2.3);
        hugo.setScore("tournamentswon", 6.3);
        hugo.setScore("money", 8.3);
        hugo.setDni(this);

        Player laura = new Player("laura@gmail", "laura", "laura", "jaen");
        laura.setScore("markedpoints", 1.3);
        laura.setScore("matcheswon", 0.3);
        laura.setScore("assistpoints", 0.3);
        laura.setScore("tournamentswon", 2.3);
        laura.setScore("money", 0.3);
        laura.setDni(this);

        Player paula = new Player("paula@gmail", "paula", "paula", "vazquez");
        paula.setScore("markedpoints", 4.7);
        paula.setScore("matcheswon", 3.4);
        paula.setScore("assistpoints", 7.2);
        paula.setScore("tournamentswon", 6.1);
        paula.setScore("money", 9.9);
        paula.setDni(this);

        Team team1 = new Team("team1", hugo, laura);
        Team team2 = new Team("team2", lucas, paula);

        this.playerList.addPlayer(pablo);
        this.playerList.addPlayer(diego);
        this.playerList.addPlayer(pedro);
        this.playerList.addPlayer(claudia);
        this.playerList.addPlayer(lucas);
        this.playerList.addPlayer(hugo);
        this.playerList.addPlayer(laura);
        this.playerList.addPlayer(paula);

        this.teamList.addTeam(team1);
        this.teamList.addTeam(team2);

        this.users.add(admin);
        this.users.add(pablo);
        this.users.add(pedro);
        this.users.add(claudia);
        this.users.add(diego);
        this.users.add(lucas);
        this.users.add(hugo);
        this.users.add(laura);
        this.users.add(paula);

        Tournament tournamentPlayer = new Tournament("playerTournament", "si", "no", "money");
        tournamentPlayer.configureFor("player");
        tournamentPlayer.addPlayer(pablo);
        tournamentPlayer.addPlayer(diego);
        tournamentPlayer.addPlayer(pedro);
        tournamentPlayer.addPlayer(claudia);
        this.tournamentList.addTournament(tournamentPlayer);


        Tournament tournamentTeam = new Tournament("teamTournament", "si", "no", "matcheswon");
        tournamentTeam.configureFor("team");
        tournamentTeam.addTeam(team1);
        tournamentTeam.addTeam(team2);
        tournamentList.addTournament(tournamentTeam);

    }

    public void addDni(Integer dni){
        this.dnis.add(dni);
    }

    public List<Integer> getDnis(){
        return this.dnis;
    }

    public User getCurrentUser() {
        return currentUser;
    }

    public TournamentList getTournamentList() {
        return tournamentList;
    }

    public TeamList getTeamList() {
        return teamList;
    }

    public PlayerList getPlayerList() {
        return playerList;
    }

    public void setCurrentUser(User currentUser) {
        this.currentUser = currentUser;
    }

    public ArrayList<User> getUsers() {
        return users;
    }

}
