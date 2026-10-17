package tennisManager.model.lists;

import tennisManager.model.objects.Match;

public class MatchList extends ModelList<Match> {

    public Match getItemByName(String name) {
        Match foundItem = null;
        for (Match item : items) {
            if (item.getName().equalsIgnoreCase(name)) {
                foundItem = item;
            }
        }
        return foundItem;
    }
}
