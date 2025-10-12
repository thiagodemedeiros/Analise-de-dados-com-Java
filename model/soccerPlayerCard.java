package model;

public class soccerPlayerCard {
    private String soccerPlayerName;
    private String card;

    public soccerPlayerCard(String soccerPlayerName, String card) {
        this.soccerPlayerName = soccerPlayerName;
        this.card = card;
    }

    public String getSoccerPlayerName() { return soccerPlayerName; }

    public String getCard() { return card; }

    public String toString() {
        return soccerPlayerName + " " + card;
    }
}
