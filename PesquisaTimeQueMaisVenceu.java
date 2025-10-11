import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

class PesquisaTimeQueMaisVenceu {
    public class SoccerGame {
        private String soccerTeamInHome;
        private int soccerTeamInHomeGols;
        private String soccerTeamInVisit;
        private int soccerTeamInVisitGols;

        public SoccerGame(String soccerTeamInHome, int soccerTeamInHomeGols,
                          String soccerTeamInVisit, int soccerTeamInVisitGols)
        {
            this.soccerTeamInHome = soccerTeamInHome;
            this.soccerTeamInHomeGols = soccerTeamInHomeGols;
            this.soccerTeamInVisit = soccerTeamInVisit;
            this.soccerTeamInVisitGols = soccerTeamInVisitGols;
        }

        public String getSoccerTeamInHome() {
            return soccerTeamInHome;
        }

        public String getSoccerTeamInVisit() {
            return soccerTeamInVisit;
        }

        public int getSoccerTeamInHomeGols() {
            return soccerTeamInHomeGols;
        }

        public int getSoccerTeamInVisitGols() {
            return soccerTeamInVisitGols;
        }

        public String toString() {
            return soccerTeamInHome + " " + soccerTeamInHomeGols + " x " +
                   soccerTeamInVisitGols + " " + soccerTeamInVisit;
        }
    }

    public PesquisaTimeQueMaisVenceu(){
        String path = "campeonato-brasileiro-full.csv";
        List<SoccerGame> LISTSoccerGames = new ArrayList<>();

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

        System.out.println(LISTSoccerGames.get(0));
    }
}