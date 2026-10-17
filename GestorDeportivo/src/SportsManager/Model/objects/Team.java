package SportsManager.Model.objects;

import SportsManager.Model.HasName;
import SportsManager.Model.Participant;
import SportsManager.Model.lists.PlayerList;
import SportsManager.users.Player;
import SportsManager.users.User;

public class Team implements HasName, Participant {
    private String name;
    private Stats teamStats = new Stats() {};
    private PlayerList playerList;
    private int capacity;
    private User createdBy;

    public Team(String teamName, Player player1, Player player2) {
        this.playerList=new PlayerList();
        this.playerList.addItem(player1);
        this.playerList.addItem(player2);
        player1.setTeamName(teamName);
        player2.setTeamName(teamName);
        this.name = teamName;
        this.teamStats = new Stats() {};
        this.average();
        this.capacity = 2;

    }

    private void average(){
        Stats newStats = new Stats() {};

        for (int i = 0; i < playerList.getCapacity(); i++) {
            for (int j = 0; j < teamStats.getCapacity(); j++) {
                newStats.setStat(teamStats.getStatName(j),  (newStats.getValue(this.teamStats.getStatName(j)) + this.playerList.getItem(i).getStat(j).getValue())/playerList.getCapacity());
            }

        }
        this.teamStats = newStats;
    }

    public void accept(Tournament tournament) {
        tournament.handleTeam();
    }



    public String getName() {
        return name;
    }

    public void addPlayer(Player player) {
        if(player != null){
            player.setTeamName(name);
            this.playerList.addItem(player);
            this.capacity++;
            this.average();
        }

    }

    public void removePlayer(Player player){
        if(player != null){
            player.setTeamName(null);
            this.playerList.deleteItem(player);
            this.capacity--;
            this.average();
        }

    }

    public void show(String stat){
        System.out.println(" " + name + ":");
        System.out.println("   " + this.teamStats.getItemByName(stat).getName() + ": " + this.teamStats.getItemByName(stat).getValue());
    }

    public boolean isPlaying(Tournament tournament) {
        return tournament.isPlaying();
    }

    public void setName(String name) {
        this.name = name;
    }

    public PlayerList getPlayerList() {
        return playerList;
    }

    public void setCreatedBy(User createdBy){
        this.createdBy = createdBy;
    }

    public Stats getStats(){
        return this.teamStats;
    }

    public Stat getStat(int i) {
        return this.teamStats.getItem(i);
    }

    public Stat getStatByName(String nameStat){
        return this.teamStats.getItemByName(nameStat);
    }
}
