package at.htl.football;

import java.util.ArrayList;
import java.util.List;

public class League {

    private ArrayList<Team> teams = new ArrayList<Team>();

    public void addMatchResult(Match match){
        Team team = new Team(match.getHomeName());
        team.addMatch(match);
    }

    private Team findOrCreateTeam(String teamName){
        if(teams.size() == 0){
            teams.add(new Team(teamName));
        } else{
            for (int i = 0; i < teams.size(); i++) {
                if(teams.get(i).getName().equals(teamName)){
                    return teams.get(i);
                }
            }
            teams.add(new Team(teamName));
            return new Team(teamName);
        }
        return null;
    }

    public List<Team> getTable(){


        return null;
    }
}
