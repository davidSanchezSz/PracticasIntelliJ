package SportsManager.Model.lists;

import SportsManager.Model.HasName;

import java.util.ArrayList;

public abstract class AbstractList<T extends HasName> extends Capacity implements ParticipantList<T> {
    protected ArrayList<T> items = new ArrayList<>();

    public void addItem(T item){
        if(!items.contains(item)){
            items.add(item);
            capacity++;
        }
    }

    public void deleteItem(T item){
        if(items.contains(item)){
            items.remove(item);
            capacity--;
        }
    }

    public T getItemByName(String name) {
        T foundItem = null;
        for (T item : items) {
            if (item.getName().equalsIgnoreCase(name)) {
                foundItem = item;
            }
        }
        return foundItem;
    }

    public T getItem(int n) {
        return items.get(n);

    }

    public ArrayList<T> getAll() {
        return new ArrayList<>(items);
    }

    public int getCapacity(){
        return capacity;
    }

}