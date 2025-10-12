package service;

import model.SoccerGame;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

public class PesquisaTimeQueMaisVenceu {
    public PesquisaTimeQueMaisVenceu(){
        String path = "repository/campeonato-brasileiro-full.csv";
        List<SoccerGame> LISTSoccerGames = new ArrayList<>();
        List<String> LISTSoccerTeamWin = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            String line = br.readLine();
            while ((line = br.readLine()) != null) {
                String[] lineContent = line.split(",");
                String soccerTeamInHome = lineContent[4];
                int soccerTeamInHomeGols = Integer.parseInt(lineContent[12].replace("\"", "").trim());
                String soccerTeamInVisit = lineContent[5];
                int soccerTeamInVisitGols = Integer.parseInt(lineContent[13].replace("\"", "").trim());
                SoccerGame soccerGame = new SoccerGame(soccerTeamInHome, soccerTeamInHomeGols,
                                                       soccerTeamInVisit, soccerTeamInVisitGols);
                LISTSoccerGames.add(soccerGame);
            }
        }
        catch (IOException e) {
            System.out.println("ERROR: " + e);
        }

        for (SoccerGame game : LISTSoccerGames) {
            if (game.getSoccerTeamInHomeGols() > game.getSoccerTeamInVisitGols()) {
                LISTSoccerTeamWin.add(game.getSoccerTeamInHome());
            }
            else if (game.getSoccerTeamInVisitGols() > game.getSoccerTeamInHomeGols()) {
                LISTSoccerTeamWin.add(game.getSoccerTeamInVisit());
            }
        }

        Map<String, Long> countTeamWinners = LISTSoccerTeamWin.stream()
                .collect(Collectors.groupingBy(e -> e, Collectors.counting()));

        Optional<Map.Entry<String, Long>> teamWithMoreWins = countTeamWinners.entrySet().stream()
                .max(Map.Entry.comparingByValue());

        teamWithMoreWins.ifPresent(entry ->
                System.out.println("Time com mais vitórias: " + entry.getKey() + " (" + entry.getValue() + " vitorias)")
        );
    }
}