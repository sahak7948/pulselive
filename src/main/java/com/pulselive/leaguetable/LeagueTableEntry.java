package com.pulselive.leaguetable;

import java.util.Objects;

/**
 * League table entry contains fields for league table
 *
 * @author pulselive
 *
 */
public class LeagueTableEntry extends LeagueTableEntryBase
{
    private int points;
    private int played;
    private int goalDifference;

    public LeagueTableEntry( final String teamName, final int played, final int won, final int drawn, final int lost,
        final int goalsFor, final int goalsAgainst, final int goalDifference, final int points )
    {
        super(teamName, won, drawn, lost, goalsFor, goalsAgainst);
        this.played = played;
        this.goalDifference = goalDifference;
        this.points = points;
    }

    /**
     * Is used to create {@code LeagueTableEntry} when team is playing for the first time
     *
     * @param      leagueTableEntryValue is the {@code LeagueTableEntryValue} representing first match results
     *                                   for current team
     *
     */
    public LeagueTableEntry(final LeagueTableEntryValue leagueTableEntryValue)
    {
        this.teamName = leagueTableEntryValue.getTeamName();
        this.played = 1;
        this.won = leagueTableEntryValue.getWon();
        this.drawn = leagueTableEntryValue.getDrawn();
        this.lost = leagueTableEntryValue.getLost();
        this.goalsFor = leagueTableEntryValue.getGoalsFor();
        this.goalsAgainst = leagueTableEntryValue.getGoalsAgainst();
        this.goalDifference = leagueTableEntryValue.getGoalDifference();
        this.points = leagueTableEntryValue.getPoints();
    }

    /**
     * Update team result with adding new results to existing
     *
     * @param      leagueTableEntryValue is the {@code LeagueTableEntryValue} representing match results
     *                                   for current team
     *
     */
    public void updateLeagueTableEntry(LeagueTableEntryValue leagueTableEntryValue)
    {
        this.played += 1;
        this.won += leagueTableEntryValue.getWon();
        this.drawn += leagueTableEntryValue.getDrawn();
        this.lost += leagueTableEntryValue.getLost();
        this.goalsFor += leagueTableEntryValue.getGoalsFor();
        this.goalsAgainst += leagueTableEntryValue.getGoalsAgainst();
        this.goalDifference += leagueTableEntryValue.getGoalDifference();
        this.points += leagueTableEntryValue.getPoints();
    }

    public int getPlayed()
    {
        return played;
    }

    public void setPlayed( int played )
    {
        this.played = played;
    }

    public int getGoalDifference()
    {
        return goalDifference;
    }

    public void setGoalDifference( int goalDifference )
    {
        this.goalDifference = goalDifference;
    }

    public int getPoints()
    {
        return points;
    }

    public void setPoints( int points )
    {
        this.points = points;
    }

    @Override
    public String toString() {
        return "LeagueTableEntry{" +
                "points=" + points +
                ", played=" + played +
                ", goalDifference=" + goalDifference +
                ", teamName='" + teamName + '\'' +
                ", won=" + won +
                ", drawn=" + drawn +
                ", lost=" + lost +
                ", goalsFor=" + goalsFor +
                ", goalsAgainst=" + goalsAgainst +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof LeagueTableEntry)) return false;
        LeagueTableEntry that = (LeagueTableEntry) o;
        return getPoints() == that.getPoints() &&
                getPlayed() == that.getPlayed() &&
                getGoalDifference() == that.getGoalDifference();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getPoints(), getPlayed(), getGoalDifference());
    }
}
