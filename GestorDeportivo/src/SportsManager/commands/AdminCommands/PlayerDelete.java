package SportsManager.commands.AdminCommands;

import SportsManager.Errors;
import SportsManager.Model.Model;
import SportsManager.commands.CommandsInterface;
import SportsManager.controller.PlayerController;
import SportsManager.users.Player;

import java.util.Objects;

public class PlayerDelete implements CommandsInterface {

    private PlayerController playerController;

    public PlayerDelete(Model model){
        this.playerController = new PlayerController(model);
    }

    public Errors approved(String[] arguments){
        if(argumentsNeeded(arguments)){
            for(Player player : playerController.getModel().getPlayerList().getAll()){
                if(Objects.equals(player.getEmail(), arguments[1])){
                    if(!isPlaying(playerController.getModel(), player)){
                        return Errors.NULL;
                    } else {
                        return Errors.TOURNAMENT_ACTIVE;
                    }
                }
            }
            return Errors.NON_EXISTING_PLAYER;
        } else return Errors.FORMAT_ERROR;
    }


    public Errors execute(String[] arguments){
        if(approved(arguments).isNull()){
            playerController.playerDelete(arguments);
            return Errors.NULL;
        } else{
            return approved(arguments);
        }
    }

    public boolean isPlaying(Model model, Player player) {
        int  i =0;
        boolean isPlaying;

            while(model.getTournamentList().getTournament(i) != null && !(player.isPlaying(model.getTournamentList().getItem(i)))){
                i++;
            }

            if(model.getTournamentList().getTournament(i) != null && !(player.isPlaying(model.getTournamentList().getTournament(i)))){
                isPlaying = true;
            }else{
                isPlaying = false;
            }

        return isPlaying;
    }

    public boolean argumentsNeeded(String[] arguments) {
        return arguments.length == 2;
    }
}
