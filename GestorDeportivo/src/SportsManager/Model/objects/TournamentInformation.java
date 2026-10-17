package SportsManager.Model.objects;

import SportsManager.Model.HasName;

import java.time.LocalDateTime;

public abstract class TournamentInformation implements HasName {
    protected String name;
    protected LocalDateTime beginning;
    protected LocalDateTime end;
    protected String league;
    protected String sport;
    protected String category;

    public TournamentInformation(String name, String league, String sport, String category){
        this.name = name;
        this.beginning = LocalDateTime.now().plusMinutes(1);
        this.end = LocalDateTime.now().plusMinutes(2);;
        this.league = league;
        this.sport = sport;
        this.category = category;
    }

    public String getName() {
        return name;
    }

    public LocalDateTime getBeginning() {
        return beginning;
    }

    public LocalDateTime getEnd() {
        return end;
    }

    public String getLeague() {
        return league;
    }

    public String getSport() {
        return sport;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setBeginning(LocalDateTime beginning) {
        this.beginning = beginning;
    }

    public void setEnd(LocalDateTime end) {
        this.end = end;
    }

    public void setLeague(String league) {
        this.league = league;
    }

    public void setSport(String sport) {
        this.sport = sport;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getCategory() {
        return category;
    }
}
