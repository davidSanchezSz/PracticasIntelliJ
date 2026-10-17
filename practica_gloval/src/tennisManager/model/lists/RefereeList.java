package tennisManager.model.lists;

import tennisManager.model.objects.Referee;

public class RefereeList extends ModelList<Referee> {

    public Referee getItemByName(String name) {
        Referee foundItem = null;
        for (Referee item : items) {
            if (item.getName().equalsIgnoreCase(name)) {
                foundItem = item;
            }
        }
        return foundItem;
    }
}
