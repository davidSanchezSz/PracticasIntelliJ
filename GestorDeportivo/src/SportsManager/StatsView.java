package SportsManager;

import SportsManager.Model.Model;

public class StatsView {

    public void showStatsCSV(Model model){
        System.out.println("         scoredPoints  victories  assistPoints  oldVictories  money");
        System.out.print("stats:    ");
        for (int i = 0; i < 5; i++) {
            System.out.print(model.getPlayerList().getPlayerByEmail(model.getCurrentUser().getEmail()).getStat(i).getValue() + "          ");
        }
    }

    public void showStatsJSON(Model model){
        String[] stats = {"scoredPoints", "victories", "assistPoints", "oldVictories", "money"};
        for (int i = 0; i < 5; i++) {
            System.out.println(stats[i] + ": " + model.getPlayerList().getPlayerByEmail(model.getCurrentUser().getEmail()).getStat(i).getValue());
        }
    }
}
