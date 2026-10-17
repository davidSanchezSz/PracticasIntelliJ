package SportsManager.users;


import SportsManager.Model.HasName;
import SportsManager.Model.Participant;
import SportsManager.Model.objects.Stat;
import SportsManager.Model.objects.Stats;
import SportsManager.Model.objects.Tournament;
import SportsManager.Model.Model;

import java.util.Random;

public class Player extends User implements HasName, Participant {
    private String name, surname;

    private Integer dni;

    private User createdBy;

    private Stats stats;

    private String teamName;

    public Player(String email, String password, String name, String surname){
        super(email, password, false);
        this.name = name;
        this.surname = surname;
        teamName=null;
        this.stats = new Stats(){};
    }

    public String getName(){
        return this.name;
    }

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }


    public Stats getStats(){
        return this.stats;
    }

    public Stat getStat(int i) {
        return this.stats.getItem(i);
    }

    public Stat getStatByName(String nameStat){
        return this.stats.getItemByName(nameStat);
    }

    public boolean isPlaying(Tournament tournament) {
        return tournament.isPlaying();
    }

    public void setCreatedBy(User createdBy) {
        this.createdBy = createdBy;
    }

    public void accept(Tournament tournament) {
        tournament.handlePlayer();
    }

    public void setScore(String statName, double value){
        if(value >= -999999.0) {
            this.stats.setStat(statName, value);
        }
    }

    public void setDni(Model model){
        Random random = new Random();
        do{
            this.dni = 10000000 + random.nextInt(90000000);
        }while(model.getDnis().contains(this.dni));
        model.addDni(this.dni);
    }

}
