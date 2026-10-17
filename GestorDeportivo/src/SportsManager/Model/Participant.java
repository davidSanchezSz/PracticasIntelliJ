package SportsManager.Model;

import SportsManager.Model.objects.Tournament;

public interface Participant extends HasName {
    void accept(Tournament tournament);
}
