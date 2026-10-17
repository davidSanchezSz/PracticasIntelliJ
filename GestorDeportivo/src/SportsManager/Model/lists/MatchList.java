package SportsManager.Model.lists;

import SportsManager.Model.HasName;
import SportsManager.Model.objects.Match;

import java.util.*;

public class MatchList<T extends HasName>{
    protected ArrayList<Match<T>> matchList = new ArrayList<>();

    public void matchmake(T first, T second) {
        Iterator<Match<T>> iterator = this.matchList.iterator();
        boolean existingMatch = false;

        while (iterator.hasNext() && !existingMatch) {
            Match<T> aux = iterator.next();
            if (aux.getFirst() == first && aux.getSecond() == second) {
                existingMatch = true;
            }
        }
        Match<T> match = null;
        if (!existingMatch) {
            match = new Match<>() {};
            match.set(first, second);
        }
        ;
        this.matchList.add(match);
    }

    public void showMatchmake(){
        if(this.matchList.isEmpty()){
            System.out.println("No hay emparejamientos");
        }else{
            Iterator<Match<T>> iterator = this.matchList.iterator();

            while(iterator.hasNext()){
                Match<T> match = iterator.next();
                System.out.println(match.getFirst().getName() + "  vs  " + match.getSecond().getName());

            }
        }
    }

    public void randomMatchmake(AbstractList<T> participantList) {
        this.clearMatch();
        Collections.shuffle(participantList.getAll());

        T first = participantList.getItem(0);
        T second = participantList.getItem(1);

        Match<T> match = new Match<>();
        match.set(first, second);

        this.matchList.add(match);
    }

    public void clearMatch(){
        this.matchList.clear();
    }

    public Match<T> getMatch(T item){
        Match<T> matchFound = new Match<>();
        for(Match<T> match: matchList){
            if(match.getFirst()==item || match.getSecond()==item){
                matchFound = match;
            }
        }
        return matchFound;
    }

    public ArrayList<Match<T>> getMatchList() {
        return matchList;
    }
}
