package service;

import model.SoccerGame;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

public class PesquisaJogoComMaisGols {
    public PesquisaJogoComMaisGols(){
        String path = "repository/campeonato-brasileiro-full.csv";
        List<SoccerGame> LISTSoccerGames = new ArrayList<>();
        Map<Integer, SoccerGame> MAPCounterGolsInGame = new HashMap<>();

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
            int howManyGolsInGame = game.getSoccerTeamInHomeGols() + game.getSoccerTeamInVisitGols();
            MAPCounterGolsInGame.put(howManyGolsInGame, game);
        }

        Optional<Map.Entry<Integer, SoccerGame>> gameWithMoreGols = MAPCounterGolsInGame.entrySet().stream()
                .max(Map.Entry.comparingByKey());

        gameWithMoreGols.ifPresent(entry ->
                System.out.println("Jogo com mais gols: " + entry.getValue() + " (" + entry.getKey() + " gols)")
        );
    }
}