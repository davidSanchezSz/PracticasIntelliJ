package tennisManager.model.objects;

public class SetsPoints {

    private final int[][] setsPoints;
    private final int[] playersSets;
    private int numSet;

    public SetsPoints(int setsPoints) {
        this.setsPoints = new int[2][setsPoints];
        this.playersSets = new int[2];
        this.numSet = 0;
    }

    public void nextSet(){
        numSet++;
    }

    public void addSetsPoint(int player){
        this.setsPoints[player][numSet]++;
    }

    public int[][] getSetsPoints() {
        return setsPoints;
    }

    public int getPlayerSetsPoints(int player){
        return this.setsPoints[player][numSet];
    }

    public int getSetsLength(){
        return setsPoints[1].length;
    }

    public int getPlayerSets(int player){
        return this.playersSets[player];
    }

    public void addPlayerSets(int player1){
        this.playersSets[player1]++;
    }

}
