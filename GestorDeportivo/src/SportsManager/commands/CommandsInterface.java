package SportsManager.commands;

import SportsManager.Errors;
import SportsManager.Model.Model;

public interface CommandsInterface extends Arguments {
    Errors execute(String[] arguments);
    Errors approved(String[] arguments);
}

