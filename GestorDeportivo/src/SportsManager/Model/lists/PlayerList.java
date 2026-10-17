package SportsManager.Model.lists;

import SportsManager.users.Player;

public class PlayerList extends AbstractList<Player> {

    public void show(String stat){
        for (Player player : items) {
            System.out.println("   " + player.getName());
            System.out.print("       " + player.getStatByName(stat).getName() + ": " + player.getStatByName(stat).getValue());
            System.out.println();
        }
    }

    public void addPlayer(Player player){
        if(this.getPlayerByEmail(player.getEmail())==null){
            this.addItem(player);
        }
    }

    public void addScore(String name, String statName, double value) {
        if (value >= -999999.0) {
            if (getPlayerByEmail(name) != null) {
                getPlayerByEmail(name).setScore(statName, value);
            }
        }
    }

    public void rankPlayer(String stat){
        PlayerList rankedList = new PlayerList();
        for (int i = 0; i < items.size(); i++) {
            rankedList.addPlayer(items.get(i));
        }
        for (int i = 0; i < capacity; i++) {
            for (int j = 0; j < capacity - i-1 ; j++) {
                for (int k = 0; k < rankedList.getItem(j).getStats().getCapacity(); k++) {
                    if(rankedList.getItem(j).getStat(k).getValue()< rankedList.getItem(j+1).getStat(k).getValue()){
                        Player swap = rankedList.getItem(j);

                        this.setPlayer(j, rankedList.getItem(j+1), rankedList);
                        this.setPlayer(j+1, swap, rankedList);
                    }
                }

            }
        }
        for (int i = 0; i < capacity; i++) {
            System.out.println("  " + rankedList.getItem(i).getName());
            System.out.print("    " + rankedList.getItem(i).getStatByName(stat).getName() + ": " + rankedList.getItem(i).getStatByName(stat).getValue());
            System.out.println();
        }
    }

    private void setPlayer(int position, Player player, PlayerList playerList) {
        if (position >= 0 && position < capacity) {
            playerList.items.set(position, player);
        }
    }

    public Player getPlayerByEmail(String email){
        Player foundPlayer = null;
        for (Player player : items) {
            if (player.getEmail().equalsIgnoreCase(email)) {
                foundPlayer = player;
            }
        }
        return foundPlayer;
    }
}
//    public void rank(){
//        for (int i = 0; i < capacity; i++) {
//            for (int j = 0; j < capacity - i-1 ; j++) {
//                if(list[j].getScore()<list[j+1].getScore()){
//                    Controll.Commands.Player swap = list[j];
//                    list[j] = list[j+1];
//                    list[j+1] = swap;
//                }
//            }
//        }
//        for (int i = 0; i < capacity; i++) {
//            System.out.println(list[i].getGmail() + ", " + list[i].getScore());
//        }
//    }