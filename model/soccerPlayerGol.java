package model;

public class soccerPlayerGol {
    private String soccerPlayerName;
    private String gol;

    public soccerPlayerGol(String soccerPlayerName, String gol) {
        this.soccerPlayerName = soccerPlayerName;
        this.gol = gol;
    }

    public String getSoccerPlayerName() { return soccerPlayerName; }

    public String getGol() { return gol; }

    public String toString() {
        return soccerPlayerName + " " + gol;
    }
}
