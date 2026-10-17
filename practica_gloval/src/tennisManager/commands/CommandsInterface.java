package tennisManager.commands;

import tennisManager.model.Model;
import tennisManager.view.Errors;

public interface CommandsInterface extends Arguments {
    String execute(String[] arguments);
    Errors approved(String[] arguments);
    Model getModel();
}

