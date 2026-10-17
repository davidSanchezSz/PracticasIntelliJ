package SportsManager.controller;

import SportsManager.Model.Model;

public abstract class Controller {
    protected Model model;

    public Model getModel(){
        return model;
    }

    public void setModel(Model model){
        this.model = model;
    }
}
