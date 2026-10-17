package SportsManager.Model.objects;

import SportsManager.Model.lists.AbstractList;

public abstract class Stats extends AbstractList<Stat> {
    public Stats(){
        addItem(new Stat("markedpoints", 0.0));
        addItem(new Stat("matcheswon", 0.0));
        addItem(new Stat("assistpoints", 0.0));
        addItem(new Stat("tournamentswon", 0.0));
        addItem(new Stat("money", 0.0));
    }

    public double getValue(String statName){
        return this.getItemByName(statName).getValue();
    }

    public void setStat(String statName, double value){
        this.getItemByName(statName).setValue(value);
    }

    public String getStatName(int i){
        return this.getItem(i).getName();
    }
}
