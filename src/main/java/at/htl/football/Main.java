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
        readFileInList("bundesliga-1819.csv", league);
        printTable(league.getTable());
    }

    public static void readFileInList(String fileName, League league)
    {

        List<String> lines = Collections.emptyList();
        try
        {
            lines = readAllLines(Paths.get(fileName), StandardCharsets.UTF_8);
            for (int i = 1; i < lines.size(); i++) {
                String line = lines.get(i);
                String[] parts = line.split(";");
                String homeName = parts[1];
                String guestName = parts[2];
                int homeGoals = Integer.parseInt(parts[3]);
                int guestGoals = Integer.parseInt(parts[4]);
                league.addMatchResult(new Match(homeName, guestName, homeGoals, guestGoals));
            }

        }

        catch (IOException e)
        {
            e.printStackTrace();
        }
    }

    private static void printTable(List<Team> teams){
        System.out.println("Team        Pts   W   D   L   GF   GA   GD");
        for (int i = 0; i < teams.size(); i++) {
            System.out.print(teams.get(i).getName());
            System.out.print(" ");
            System.out.printf("%2d  %2d  %2d  %2d  %2d  %2d  %2d\n", teams.get(i).getPoints(), teams.get(i).getWins(), teams.get(i).getDraws(), teams.get(i).getDefeats(), teams.get(i).getGoalsShot(), teams.get(i).getGoalsReceived(), teams.get(i).getGoalDifference());
        }
    }
}