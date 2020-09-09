package com.pulselive.leaguetable;

import java.util.Objects;

/**
 * League table entry base is used as base class for league table entities with common parameters
 *
 * @author sahak_babayan
 *
 */
public class LeagueTableEntryBase {

    String teamName;
    int won;
    int drawn;
    int lost;
    int goalsFor;
    int goalsAgainst;

    public LeagueTableEntryBase()
    {
    }

    public LeagueTableEntryBase(String teamName, int won, int drawn, int lost, int goalsFor, int goalsAgainst)
    {
        this.teamName = teamName;
        this.won = won;
        this.drawn = drawn;
        this.lost = lost;
        this.goalsFor = goalsFor;
        this.goalsAgainst = goalsAgainst;
    }

    public String getTeamName() {
        return teamName;
    }

    public int getWon() {
        return won;
    }

    public int getDrawn() {
        return drawn;
    }

    public int getLost() {
        return lost;
    }

    public int getGoalsFor() {
        return goalsFor;
    }

    public int getGoalsAgainst() {
        return goalsAgainst;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public void setWon(int won) {
        this.won = won;
    }

    public void setDrawn(int drawn) {
        this.drawn = drawn;
    }

    public void setLost(int lost) {
        this.lost = lost;
    }

    public void setGoalsFor(int goalsFor) {
        this.goalsFor = goalsFor;
    }

    public void setGoalsAgainst(int goalsAgainst) {
        this.goalsAgainst = goalsAgainst;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof LeagueTableEntryBase)) return false;
        LeagueTableEntryBase that = (LeagueTableEntryBase) o;
        return getWon() == that.getWon() &&
                getDrawn() == that.getDrawn() &&
                getLost() == that.getLost() &&
                getGoalsFor() == that.getGoalsFor() &&
                getGoalsAgainst() == that.getGoalsAgainst() &&
                getTeamName().equals(that.getTeamName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getTeamName(), getWon(), getDrawn(), getLost(), getGoalsFor(), getGoalsAgainst());
    }
}
