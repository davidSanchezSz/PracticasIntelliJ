package tennisManager.model.lists;

import tennisManager.HasName;

import java.util.ArrayList;

public abstract class ModelList<T extends HasName>{
    protected ArrayList<T> items = new ArrayList<>();

    public void addItem(T item){
        items.add(item);
    }

    public void deleteItem(T item){
        if(items.contains(item)){
            items.remove(item);
        }
    }

    public T getItem(int n) {
        return items.get(n);

    }

    public ArrayList<T> getAll() {
        return new ArrayList<>(items);
    }

    public int getCapacity(){
        return items.size();
    }
}
