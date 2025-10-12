package service;

import model.soccerPlayerCard;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

public class PesquisaDeCartoes {
    public PesquisaDeCartoes(String changeSearch){
        String path = "repository/campeonato-brasileiro-cartoes.csv";
        List<soccerPlayerCard> LISTSoccerPlayerNames = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            String line = br.readLine();
            while ((line = br.readLine()) != null) {
                String[] lineContent = line.split(",");
                String player = lineContent[4];
                String cardColumn = lineContent[3].replace("\"", "").trim().toLowerCase();
                soccerPlayerCard soccerPlayerCard = new soccerPlayerCard(player, cardColumn);
                LISTSoccerPlayerNames.add(soccerPlayerCard);
            }
        }
        catch (IOException e) {
            System.out.println("ERROR: " + e);
        }

        if (changeSearch.equals("Cartão Amarelo")) {
            Map<String, Long> yellowCardCount = LISTSoccerPlayerNames.stream()
                    .filter(c -> c.getCard().equals("amarelo"))
                    .collect(Collectors.groupingBy(soccerPlayerCard::getSoccerPlayerName, Collectors.counting()));

            Optional<Map.Entry<String, Long>> maxYellow = yellowCardCount.entrySet().stream()
                    .max(Map.Entry.comparingByValue());

            maxYellow.ifPresent(entry ->
                    System.out.println("Jogador com mais cartões amarelos: " + entry.getKey() + " - " + entry.getValue() + " cartões"));
        }

        if (changeSearch.equals("Cartão Vermelho")) {
            Map<String, Long> redCardCount = LISTSoccerPlayerNames.stream()
                    .filter(c -> c.getCard().equals("vermelho"))
                    .collect(Collectors.groupingBy(soccerPlayerCard::getSoccerPlayerName, Collectors.counting()));

            Optional<Map.Entry<String, Long>> maxRed = redCardCount.entrySet().stream()
                    .max(Map.Entry.comparingByValue());

            maxRed.ifPresent(entry ->
                    System.out.println("Jogador com mais cartões vermelhos: " + entry.getKey() + " - " + entry.getValue() + " cartões"));
        }

    }
}