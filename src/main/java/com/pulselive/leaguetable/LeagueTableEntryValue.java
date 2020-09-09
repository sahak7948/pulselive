package com.pulselive.leaguetable;

import static com.pulselive.leaguetable.Points.*;

/**
 * League table entry value used to send update data for each team after match
 *
 * @author sahak_babayan
 *
 */
public class LeagueTableEntryValue extends LeagueTableEntryBase {

    public LeagueTableEntryValue(String teamName, int won, int drawn, int lost, int goalsFor, int goalsAgainst) {
        super(teamName, won, drawn, lost, goalsFor, goalsAgainst);
    }

    public int getGoalDifference() {
        return goalsFor - goalsAgainst;
    }

    public int getPoints() {
        int goalDifference = getGoalDifference();
        return goalDifference == 0 ? DRAWN.getPoint() : goalDifference > 0 ? WON.getPoint() : LOST.getPoint();
    }

}
