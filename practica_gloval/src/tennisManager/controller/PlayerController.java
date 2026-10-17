package tennisManager.controller;

import tennisManager.model.objects.Player;

public class PlayerController extends Controller{

    public void createPlayer(String[] arguments){
        model.getPlayerList().addItem(new Player(arguments[1]));
    }

    public void readPlayer(String[] arguments){

    }

    public String readPlayers(){
        StringBuilder show = new StringBuilder();
        for(Player player : model.getPlayerList().getAll()){
            show.append("Name: ").append(player.getName()).append("   Age: ").append(player.getAge()).append("   Id: ").append(player.getId());
            show.append("\n");
        }
       return show.toString();
    }
}
