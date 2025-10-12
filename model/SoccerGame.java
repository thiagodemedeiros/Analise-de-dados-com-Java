package model;

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
