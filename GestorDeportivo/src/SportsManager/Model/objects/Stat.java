package SportsManager.Model.objects;

import SportsManager.Model.HasName;

public class Stat implements HasName {
    private String name;
    private double value;

    public Stat(String name, double value){
        this.name=name;
        this.value=value;
    }

    public String getName() {
        return name;
    }

    public double getValue() {
        return value;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setValue(double value) {
        this.value = value;
    }
}
