package tennisManager.model.lists;

import tennisManager.model.objects.Player;

public class PlayerList extends ModelList<Player> {

    public Player getItemById(int id) {
        Player foundItem = null;
        for (Player item : items) {
            if (item.getId() == id) {
                foundItem = item;
            }
        }
        return foundItem;
    }
}
