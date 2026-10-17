package SportsManager.Model.objects;

import SportsManager.Model.HasName;

public class Match <T extends HasName>{
    private T first = null;
    private T second = null;

    public T getFirst() {
        return first;
    }

    public T getSecond() {
        return second;
    }

    public void set(T first, T second){
        this.first = first;
        this.second = second;
    }
    public void setFirst(T first) {
        set(first, this.second);
    }

    public void setSecond(T second) {
        set(this.first, second);
    }
}
