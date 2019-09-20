package at.htl.football;

import java.util.List;
import java.util.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.*;
import java.io.*;

import static java.nio.file.Files.readAllLines;

public class Main {

    public static void main(String[] args) {
        League league = new League();
        List<String> lines = readFileInList("bundesliga-1819.csv");
        for (int i = 1; i < lines.size(); i++) {
            String line = lines.get(i);
            String[] parts = line.split(";");
            String date = parts[0];
            String homeName = parts[1];
            String guestName = parts[2];
            int homeGoals = Integer.parseInt(parts[3]);
            int guestGoals = Integer.parseInt(parts[4]);
            league.addMatchResult(new Match(homeName, guestName, homeGoals, guestGoals));
        }


    }

    public static List<String> readFileInList(String fileName)
    {

        List<String> lines = Collections.emptyList();
        try
        {
            lines = readAllLines(Paths.get(fileName), StandardCharsets.UTF_8);
        }

        catch (IOException e)
        {
            e.printStackTrace();
        }
        return lines;
    }

    private void printTable(List<Team> teamList){
        System.out.println("Team        Pts   W   D   L   GF   GA   GD");
        for (int i = 0; i < teams.size(); i++) {
            System.out.print(teams.get(i).getName());
            System.out.print(teams.get(i).getPoints());
            System.out.print(teams.get(i).getWins());
            System.out.print(teams.get(i).getDraws());
            System.out.print(teams.get(i).getDefeats());
            System.out.print(teams.get(i).getGoalsShot());
            System.out.print(teams.get(i).getGoalsReceived());
            System.out.print(teams.get(i).getGoalDifference());
        }
    }
}
