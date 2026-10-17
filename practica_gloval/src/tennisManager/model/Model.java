package tennisManager.model;

import tennisManager.model.lists.MatchList;
import tennisManager.model.lists.PlayerList;
import tennisManager.model.lists.RefereeList;
import tennisManager.model.objects.Referee;

public class Model {
    private Referee currentReferee;
    private MatchList matchList;
    private PlayerList playerList;
    private RefereeList refereeList;

    public Model(){
        this.currentReferee = null;
        this.matchList = new MatchList();
        this.playerList = new PlayerList();
        this.refereeList = new RefereeList();
    }

    public void setCurrentReferee(Referee currentReferee) {
        this.currentReferee = currentReferee;
    }

    public Referee getCurrentReferee(){
        return currentReferee;
    }

    public MatchList getMatchList() {
        return matchList;
    }

    public PlayerList getPlayerList() {
        return playerList;
    }

    public RefereeList getRefereeList() {
        return refereeList;
    }
}
