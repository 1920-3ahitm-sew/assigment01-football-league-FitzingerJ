package at.htl.football;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class League {

    private ArrayList<Team> teams = new ArrayList<Team>();

    public void addMatchResult(Match match){
        Team homeTeam = findOrCreateTeam(match.getHomeName());
        Team guestTeam = findOrCreateTeam(match.getGuestName());

        homeTeam.addMatch(match);
        guestTeam.addMatch(match);
    }

    private Team findOrCreateTeam(String teamName){
        for (int i = 0; i < teams.size(); i++) {
            if(teams.get(i).getName().equals(teamName)){
                return teams.get(i);
            }
        }
        teams.add(new Team(teamName));
        return teams.get(teams.size() - 1);
    }

    public List<Team> getTable(){
        Collections.sort(teams);

        return teams;
    }
}
