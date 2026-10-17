package SportsManager.Model.lists;

import SportsManager.Model.HasName;

public interface ParticipantList<T extends HasName> {
    void addItem(T item);
    void deleteItem(T item);
    T getItemByName(String name);
}
