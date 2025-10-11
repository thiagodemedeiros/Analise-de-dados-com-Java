import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

class PesquisaDeCartoes {
    public PesquisaDeCartoes(int changeSearch){
        String path = "campeonato-brasileiro-cartoes.csv";
        Set<String> SETSoccerPlayerNames = new HashSet<>();
        Map<String, Integer> MAPSoccerPlayerCards = new HashMap<>();

        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            String line = br.readLine();
            while ((line = br.readLine()) != null) {
                String[] lineContent = line.split(",");
                String player = lineContent[4];
                SETSoccerPlayerNames.add(player);
            }
        }
        catch (IOException e) {
            System.out.println("ERROR: " + e);
        }

        for (String name : SETSoccerPlayerNames) {
            int counterCards = 0;

            try (BufferedReader br = new BufferedReader(new FileReader(path))) {
                String line = br.readLine();
                while ((line = br.readLine()) != null) {
                    String[] lineContent = line.split(",");
                    String player = lineContent[4];
                    String cardColumn = lineContent[3].replace("\"", "").trim().toLowerCase();

                    if (player.equals(name) && changeSearch == 1 && cardColumn.contains("amarelo")) {
                        counterCards++;
                    }
                    if (player.equals(name) && changeSearch == 2 && cardColumn.contains("vermelho")) {
                        counterCards++;
                    }
                }
            }
            catch (IOException e) {
                System.out.println("ERROR: " + e);
            }

            MAPSoccerPlayerCards.put(name,counterCards);
        }

        String nameSoccerPLayer = "Player";
        int soccerPlayerCards = 0;

        for (Map.Entry<String, Integer> entry : MAPSoccerPlayerCards.entrySet()) {
            String name = entry.getKey();
            int cards = entry.getValue();

            if (cards > soccerPlayerCards) {
                soccerPlayerCards = cards;
                nameSoccerPLayer = name;
            }
        }

        if (changeSearch == 1) {
            System.out.println("Jogador com mais Cartões Amarelos: " + nameSoccerPLayer + " - " + soccerPlayerCards + " Cartões");
        }
        if (changeSearch == 2) {
            System.out.println("Jogador com mais Cartões Vermelhos: " + nameSoccerPLayer + " - " + soccerPlayerCards + " Cartões");
        }
    }
}