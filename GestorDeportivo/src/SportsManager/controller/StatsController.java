package SportsManager.controller;

import SportsManager.Model.Model;
import SportsManager.StatsView;

import java.util.Objects;

public class StatsController extends Controller{

    StatsView statsView;

    public void showStatsCSV(){
        statsView.showStatsCSV(model);
    }

    public void showStatsJSON(){
        statsView.showStatsJSON(model);
    }


    public Model getModel(){
        return model;
    }

}
