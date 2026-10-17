package tennisManager.model.objects;


import tennisManager.HasName;
import java.time.LocalDate;

public class Match implements HasName {

    private int id;
    private static int idCounter = 0;
    private GamePoints gamePoints;
    private SetsPoints setsPoints;
    private Player[] players;
    private boolean[] playerWon;
    private int lackService;
    private LocalDate createdDate;
    private String[] points;

    public Match(int setsPoints, Player[] players){
        this.id = ++idCounter;
        this.gamePoints = new GamePoints();
        this.setsPoints = new SetsPoints(setsPoints);
        this.players = players;
        this.playerWon = new boolean[]{false, false};
        this.lackService = 0;
        this.createdDate  = LocalDate.now();
        this.points = new String[]{"0", "15", "30", "40", "AD"};
    }

    public String getShowMatch(){
        StringBuilder showMatch = new StringBuilder();
        for (int i = 0; i < 2; i++) {
            if(i == gamePoints.getWhoIsPlayerService()){
                if(lackService == 1){
                    showMatch.append("+ ");
                }else{
                    showMatch.append("* ");
                }
            }
            if(gamePoints.isTieBreak()){
                showMatch.append(players[i].getName()).append(":  ").append(gamePoints.getPlayerGamePoints(i)).append(" ");
            }else{
                showMatch.append(players[i].getName()).append(":  ").append(points[gamePoints.getPlayerGamePoints(i)]).append(" ");
            }
            for (int j = 0; j < setsPoints.getSetsLength(); j++) {
                int[][] setsPoints = this.setsPoints.getSetsPoints();
                showMatch.append(" ").append(setsPoints[i][j]);
            }
            showMatch.append("\n");
        }
        return showMatch.toString();
    }

    public void lackService(){
        lackService++;
        if(lackService == 2){
            pointRest();
        }
    }

    public void pointService(){
        int whoIsPlayerService = gamePoints.getWhoIsPlayerService();
        addPoints(whoIsPlayerService, whoIsPlayerService % 2);
    }

    public void pointRest(){
        int whoIsPlayerService = gamePoints.getWhoIsPlayerService();
        addPoints(whoIsPlayerService % 2, whoIsPlayerService);
    }

    private void addPoints(int playerWhoScore, int otherPlayer){
        lackService = 0;
        int gamePoints;
        if(this.gamePoints.isTieBreak()){
            gamePoints=6;
        }else{
            gamePoints=4;
        }

        this.gamePoints.addGamePoint(playerWhoScore);

        changeServiceTieBreak();

        checkNoMoreAD(playerWhoScore, otherPlayer);

        checkAddSetPoint(playerWhoScore, otherPlayer, gamePoints);

        checkNextSet(playerWhoScore, otherPlayer);

        checkIsTieBreak(playerWhoScore, otherPlayer);

        if(setsPoints.getPlayerSets(playerWhoScore) == (setsPoints.getSetsLength() + 1) / 2){
            playerWon[playerWhoScore] = true;
        }
    }

    private void changeServiceTieBreak(){
        if(this.gamePoints.isTieBreak() && (this.gamePoints.getPlayerGamePoints(0) + this.gamePoints.getPlayerGamePoints(1)) % 2 != 0 ){
            changeService();
        }
    }

    public void checkNoMoreAD(int playerWhoScore, int otherPlayer){
        if(!this.gamePoints.isTieBreak() && this.gamePoints.getPlayerGamePoints(playerWhoScore) == 4 && this.gamePoints.getPlayerGamePoints(otherPlayer) == 4){
            this.gamePoints.setGamePoints(new int[]{3,3});
        }
    }

    public void checkAddSetPoint(int playerWhoScore, int otherPlayer, int gamePoints){
        if(this.gamePoints.getPlayerGamePoints(playerWhoScore) - this.gamePoints.getPlayerGamePoints(otherPlayer) >= 2 && this.gamePoints.getPlayerGamePoints(playerWhoScore) >= gamePoints){
            setsPoints.addSetsPoint(playerWhoScore);
            this.gamePoints.setGamePoints(new int[]{0,0});
            changeService();
        }
    }

    public void checkNextSet(int playerWhoScore, int otherPlayer){
        if(setsPoints.getPlayerSetsPoints(playerWhoScore) - setsPoints.getPlayerSetsPoints(otherPlayer) >= 2 && setsPoints.getPlayerSetsPoints(playerWhoScore) == 6 || setsPoints.getPlayerSetsPoints(playerWhoScore) - setsPoints.getPlayerSetsPoints(otherPlayer) <= 2 && setsPoints.getPlayerSetsPoints(playerWhoScore) == 7){
            setsPoints.nextSet();
            setsPoints.addPlayerSets(playerWhoScore);
            this.gamePoints.setTieBreak(false);
        }
    }

    public void checkIsTieBreak(int playerWhoScore, int otherPlayer){
        if(setsPoints.getPlayerSetsPoints(playerWhoScore) == 6 && setsPoints.getPlayerSetsPoints(otherPlayer) == 6){
            this.gamePoints.setTieBreak(true);
        }
    }


    private void changeService(){
        this.gamePoints.setWhoIsPlayerService((this.gamePoints.getWhoIsPlayerService() -1)*-1);
    }

    public LocalDate getCreatedDate() {
        return createdDate;
    }

    public String getName() {
        return "" + id;
    }

    public boolean[] getPlayerWon() {
        return playerWon;
    }
}
