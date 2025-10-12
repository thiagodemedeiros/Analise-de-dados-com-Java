package service;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import java.util.stream.*;

public class PesquisaEstadoComMenosJogos {
    public PesquisaEstadoComMenosJogos(){
        String path = "repository/campeonato-brasileiro-full.csv";
        List<String> LISTSoccerPlaces = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            String line = br.readLine();
            while ((line = br.readLine()) != null) {
                String[] lineContent = line.split(",");
                String place = lineContent[14];
                LISTSoccerPlaces.add(place);
            }
        }
        catch (IOException e) {
            System.out.println("ERROR: " + e);
        }

        Map<String, Long> contagemPorEstado = LISTSoccerPlaces.stream()
            .collect(Collectors.groupingBy(e -> e, Collectors.counting()));

        Optional<Map.Entry<String, Long>> estadoMenosFrequente = contagemPorEstado.entrySet().stream()
            .min(Map.Entry.comparingByValue());

        estadoMenosFrequente.ifPresent(entry ->
            System.out.println("Estado menos frequente: " + entry.getKey() + " (" + entry.getValue() + " vezes)")
        );
    }
}