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
    }

    public PesquisaTimeQueMaisVenceu(){
        String path = "campeonato-brasileiro-full.csv";
        List<SoccerGame> LISTSoccerGames = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            String line = br.readLine();
            while ((line = br.readLine()) != null) {
                String[] lineContent = line.split(",");
                String soccerTeamInHome = lineContent[4];
                String soccerTeamInHomeGols = lineContent[12];
                String soccerTeamInVisit = lineContent[5];
                String soccerTeamInVisitGols = lineContent[3];
                SETSoccerPlayerNames.add(player);
            }
        }
        catch (IOException e) {
            System.out.println("ERROR: " + e);
        }
    }
}