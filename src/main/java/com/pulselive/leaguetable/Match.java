package com.pulselive.leaguetable;

/**
 * Match represents each match with teams scores
 *
 * @author pulselive
 *
 */
public class Match
{
    private String homeTeam;
    private String awayTeam;
    private int homeScore;
    private int awayScore;

    public Match( final String homeTeam, final String awayTeam, final int homeScore, final int awayScore )
    {
        this.homeTeam = homeTeam;
        this.awayTeam = awayTeam;
        this.homeScore = homeScore;
        this.awayScore = awayScore;
    }

    public String getHomeTeam()
    {
        return homeTeam;
    }

    public String getAwayTeam()
    {
        return awayTeam;
    }

    public int getHomeScore()
    {
        return homeScore;
    }

    public int getAwayScore()
    {
        return awayScore;
    }

}
