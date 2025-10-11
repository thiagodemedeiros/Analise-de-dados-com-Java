import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

class PesquisaDeGols {
    public PesquisaDeGols(int changeSearch){
        String path = "campeonato-brasileiro-gols.csv";
        Set<String> SETSoccerPlayerNames = new HashSet<>();
        Map<String, Integer> MAPSoccerPlayerGoals = new HashMap<>();

        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            String line = br.readLine();
            while ((line = br.readLine()) != null) {
                String[] lineContent = line.split(",");
                String player = lineContent[3];
                SETSoccerPlayerNames.add(player);
            }
        }
        catch (IOException e) {
            System.out.println("ERROR: " + e);
        }

        for (String name : SETSoccerPlayerNames) {
            int counterGols = 0;

            try (BufferedReader br = new BufferedReader(new FileReader(path))) {
                String line = br.readLine();

                while ((line = br.readLine()) != null) {
                    String[] lineContent = line.split(",");
                    String player = lineContent[3];
                    String golColumn = lineContent[5].replace("\"", "").trim().toLowerCase();

                    if (player.equals(name) && changeSearch == 0) {
                        counterGols++;
                    }
                    if (player.equals(name) && changeSearch == 1 && golColumn.contains("contra")) {
                        counterGols++;
                    }
                    if (player.equals(name) && changeSearch == 2 && golColumn.contains("penal")) {
                        counterGols++;
                    }
                }
            }
            catch (IOException e) {
                System.out.println("ERROR: " + e);
            }

            MAPSoccerPlayerGoals.put(name,counterGols);
        }

        String nameSoccerPLayer = "Player";
        int soccerPlayerGols = 0;

        for (Map.Entry<String, Integer> entry : MAPSoccerPlayerGoals.entrySet()) {
            String name = entry.getKey();
            int gols = entry.getValue();

            if (gols > soccerPlayerGols) {
                soccerPlayerGols = gols;
                nameSoccerPLayer = name;
            }
        }

        if (changeSearch == 0) {
            System.out.println("Jogador com mais gols: " + nameSoccerPLayer + " - " + soccerPlayerGols + " gols");
        }
        if (changeSearch == 1) {
            System.out.println("Jogador com mais gols contra: " + nameSoccerPLayer + " - " + soccerPlayerGols + " gols");
        }
        if (changeSearch == 2) {
            System.out.println("Jogador com mais gols de penalty: " + nameSoccerPLayer + " - " + soccerPlayerGols + " gols");
        }
    }
}