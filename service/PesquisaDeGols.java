package service;

import model.soccerPlayerCard;
import model.soccerPlayerGol;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

public class PesquisaDeGols {
    public PesquisaDeGols(String changeSearch){
        String path = "repository/campeonato-brasileiro-gols.csv";
        List<soccerPlayerGol> LISTSoccerPlayerNames = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            String line = br.readLine();
            while ((line = br.readLine()) != null) {
                String[] lineContent = line.split(",");
                String player = lineContent[3];
                String golColumn = lineContent[5].replace("\"", "").trim().toLowerCase();
                if (golColumn.equals("")) {golColumn = "gol";}
                soccerPlayerGol soccerPlayerGol = new soccerPlayerGol(player, golColumn);
                LISTSoccerPlayerNames.add(soccerPlayerGol);
            }
        }
        catch (IOException e) {
            System.out.println("ERROR: " + e);
        }

        if (changeSearch.equals("Gol")) {
            Map<String, Long> normalGolCount = LISTSoccerPlayerNames.stream()
                    .filter(c -> c.getGol().equals("gol"))
                    .collect(Collectors.groupingBy(soccerPlayerGol::getSoccerPlayerName, Collectors.counting()));

            Optional<Map.Entry<String, Long>> maxNormalGolCount = normalGolCount.entrySet().stream()
                    .max(Map.Entry.comparingByValue());

            maxNormalGolCount.ifPresent(entry ->
                    System.out.println("Jogador com mais gols: " + entry.getKey() + " - " + entry.getValue() + " gols"));
        }

        if (changeSearch.equals("Penalti")) {
            Map<String, Long> normalGolCount = LISTSoccerPlayerNames.stream()
                    .filter(c -> c.getGol().equals("penalty"))
                    .collect(Collectors.groupingBy(soccerPlayerGol::getSoccerPlayerName, Collectors.counting()));

            Optional<Map.Entry<String, Long>> maxNormalGolCount = normalGolCount.entrySet().stream()
                    .max(Map.Entry.comparingByValue());

            maxNormalGolCount.ifPresent(entry ->
                    System.out.println("Jogador com mais gols de Penalti: " + entry.getKey() + " - " + entry.getValue() + " gols"));
        }

        if (changeSearch.equals("Gol Contra")) {
            Map<String, Long> normalGolCount = LISTSoccerPlayerNames.stream()
                    .filter(c -> c.getGol().equals("gol contra"))
                    .collect(Collectors.groupingBy(soccerPlayerGol::getSoccerPlayerName, Collectors.counting()));

            Optional<Map.Entry<String, Long>> maxNormalGolCount = normalGolCount.entrySet().stream()
                    .max(Map.Entry.comparingByValue());

            maxNormalGolCount.ifPresent(entry ->
                    System.out.println("Jogador com mais gols contra: " + entry.getKey() + " - " + entry.getValue() + " gols"));
        }
    }
}