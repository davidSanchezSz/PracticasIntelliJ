package SportsManager.Model.lists;

import SportsManager.Model.objects.Team;
import SportsManager.users.Player;

import java.util.Iterator;
import java.util.Objects;

public class TeamList extends AbstractList<Team> {

    public void addPlayer(String name, Player player){
        Iterator<Team> iterator = items.iterator();
        Team aux = iterator.next();
        while(iterator.hasNext() && !Objects.equals(aux.getName(), name)){
            aux = iterator.next();
        }
        if(Objects.equals(aux.getName(), name)){
            aux.addPlayer(player);
        }
    }

    public void addTeam(Team team){
        if(this.getItemByName(team.getName())==null){
            this.addItem(team);
        }
    }

    public void removePlayer(Player player){
        Iterator<Team> iterator = items.iterator();
        Team aux = iterator.next();
        while(iterator.hasNext() && !Objects.equals(aux.getName(), player.getTeamName())){
            aux = iterator.next();
        }
        if(Objects.equals(aux.getName(), player.getTeamName())){
            aux.removePlayer(player);
        }
    }

    public void show(String stat) {
        for (Team team : items) {
            team.show(stat);
        }
    }

    public void rankTeam(String stat){
        TeamList rankedList  = new TeamList();
        for (int i = 0; i < items.size(); i++) {
            rankedList.addTeam(items.get(i));
        }
        for (int i = 0; i < capacity; i++) {
            for (int j = 0; j < capacity - i-1 ; j++) {
                for (int k = 0; k < rankedList.getItem(j).getStats().getCapacity(); k++) {
                    if(rankedList.getItem(j).getStat(k).getValue()< rankedList.getItem(j+1).getStat(k).getValue()){
                        Team swap = rankedList.getItem(j);

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

    private void setPlayer(int position, Team player, TeamList teamList) {
        if (position >= 0 && position < capacity) {
            teamList.items.set(position, player);
        }
    }
}
//    public void teamCreate(Controll.Commands.Team team) {
//        if (this.getPosition(team.getTeamName())!=this.capacity && this.capacity!=0) {
//            System.out.println("El jugador " + team.getTeamName() + " ya existe");
//        } else {
//            NodeTeam n = new NodeTeam(team);
//
//            if(this.beginning.getNext()==null){
//                this.beginning.setNext(n);
//                this.end.setNext(n);
//                this.capacity++;
//            }else{
//                this.end.getNext().setNext(n);
//                this.end.setNext(n);
//                this.capacity++;
//            }
//
//        }
//    }
//    public void teamDelete(Controll.Commands.Team team){
//        int position = this.getPosition(team.getTeamName());
//        if (position == this.capacity || this.capacity == 0){
//            System.out.println("No se ha encontrado el jugador " + team.getTeamName());
//        }else{
//            NodeTeam aux = this.beginning.getNext();
//            NodeTeam previous = this.beginning;
//            this.capacity--;
//            while(aux.getTeam()!=null && !Objects.equals(aux.getTeam().getTeamName(), team.getTeamName())) {
//                previous = aux;
//                aux = aux.getNext();
//            }
//            if(aux.getTeam()!=null){
//                previous.setNext(aux.getNext());
//            }
//        }
//    }