package at.htl.football;

public class Team {

    private String name;
    private int points;
    private int wins;
    private int draws;
    private int defeats;
    private int goalsShot;
    private int goalsReceived;

    public Team(String name) {
        this.name = name;
    }

    public void addMatch(Match match){
        if(match.getHomeName().equals(name)){
            if(match.getHomeGoals() < match.getGuestGoals()){
                defeats++;
            } else if(match.getHomeGoals() > match.getGuestGoals()){
                wins++;
            } else{
                draws++;
            }
            goalsShot += match.getHomeGoals();
            goalsReceived += match.getGuestGoals();
        } else if(match.getGuestName().equals(name)) {
            if (match.getHomeGoals() > match.getGuestGoals()) {
                defeats++;
            } else if (match.getHomeGoals() < match.getGuestGoals()) {
                wins++;
            } else {
                draws++;
            }
            goalsShot += match.getGuestGoals();
            goalsReceived += match.getHomeGoals();
        }
    }

    public String getName() {
        return name;
    }

    public int getPoints() {
        return points;
    }

    public int getWins() {
        return wins;
    }

    public int getDraws() {
        return draws;
    }

    public int getDefeats() {
        return defeats;
    }

    public int getGoalsShot() {
        return goalsShot;
    }

    public int getGoalsReceived() {
        return goalsReceived;
    }

    public int getGoalDifference() {
        if(goalsReceived == 0){
            return goalsShot;
        } else{
            return goalsShot / goalsReceived;
        }
    }

}
