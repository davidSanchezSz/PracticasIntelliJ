package tennisManager.model.objects;

public class GamePoints {

    private int[] gamePoints;
    private boolean tieBreak;
    private int whoIsPlayerService;

    public GamePoints() {
        this.gamePoints = new int[2];
        this.tieBreak = false;
        this.whoIsPlayerService = (int) (Math.random() * 2);
    }

    public boolean isTieBreak() {
        return tieBreak;
    }

    public int getWhoIsPlayerService() {
        return whoIsPlayerService;
    }

    public int getPlayerGamePoints(int player){
        return this.gamePoints[player];
    }

    public void addGamePoint(int player){
        this.gamePoints[player]++;
    }

    public void setGamePoints(int[] gamePoints) {
        this.gamePoints = gamePoints;
    }

    public void setTieBreak(boolean tieBreak) {
        this.tieBreak = tieBreak;
    }

    public void setWhoIsPlayerService(int whoIsPlayerService){
        this.whoIsPlayerService = whoIsPlayerService;
    }
}
