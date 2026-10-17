package SportsManager.controller;

import SportsManager.Model.Model;
import SportsManager.users.Player;

public class PlayerController extends Controller{

    public PlayerController(Model model) {
        setModel(model);
    }

    public void playerCreate(String[] arguments){
        Player newPlayer = new Player(arguments[1], arguments[2], arguments[3], arguments[4]);
        newPlayer.setDni(model);
        newPlayer.setCreatedBy(model.getCurrentUser());
        model.getPlayerList().addPlayer(newPlayer);
        model.getUsers().add(newPlayer);
    }

    public void playerDelete(String[] arguments){
        Player player = model.getPlayerList().getPlayerByEmail(arguments[1]);
        model.getPlayerList().deleteItem(player);
        model.getUsers().remove(player);

        int i = 0;
        while(model.getTournamentList().getCapacity() > i){
            if(model.getTournamentList().getTournament(i).getParticipantList().getItemByName(player.getName())!=null){
                model.getTournamentList().getTournament(i).deletePlayer(player);
            }
            i++;
        }

    }

    public Model getModel(){
        return model;
    }


}
