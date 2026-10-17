package tennisManager.controller;

import tennisManager.model.Model;

public abstract class Controller {
    protected static Model model = new Model();

    public Model getModel() {
        return model;
    }
}
