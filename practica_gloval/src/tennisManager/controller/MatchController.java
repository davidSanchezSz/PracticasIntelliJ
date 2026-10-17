package tennisManager.controller;

import tennisManager.model.objects.Match;
import tennisManager.model.objects.Player;

public class MatchController extends Controller{

    public String createMatch(String[] arguments){
        Player[] playersId = new Player[]{model.getPlayerList().getItemById(Integer.parseInt(arguments[2])), model.getPlayerList().getItemById(Integer.parseInt(arguments[3]))};
        Match newMatch = new Match(Integer.parseInt(arguments[1]), playersId);
        model.getMatchList().addItem(newMatch);
        return "id: " + newMatch.getName() + "\n" + "date: " + newMatch.getCreatedDate() + "\n" + newMatch.getShowMatch();
    }

    public String lackService(String[] arguments){
        model.getMatchList().getItemByName(arguments[1]).lackService();
        return getShowMatch(arguments);
    }

    public String pointRest(String[] arguments){
        model.getMatchList().getItemByName(arguments[1]).pointRest();
        return getShowMatch(arguments);
    }

    public String pointService(String[] arguments){
        model.getMatchList().getItemByName(arguments[1]).pointService();
        return getShowMatch(arguments);
    }

    public void readMatch(String[] arguments){

    }

    private String getShowMatch(String[] arguments){
        return model.getMatchList().getItemByName(arguments[1]).getShowMatch();
    }

}
