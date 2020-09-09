package com.pulselive.leaguetable;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class LeagueTableTest {

    @Test
    void getTableEntries() {
        List<LeagueTableEntry> expectedTableEntries = Arrays.asList(
                new LeagueTableEntry("Team1", 3, 3, 0, 0, 7, 4, 3, 9),
                new LeagueTableEntry("Team5", 3, 2, 0, 1, 9, 7, 2, 6),
                new LeagueTableEntry("Team3", 2, 1, 0, 1, 6, 5, 1, 3),
                new LeagueTableEntry("Team8", 2, 1, 0, 1, 6, 6, 0, 3),
                new LeagueTableEntry("Team4", 2, 0, 1, 1, 2, 4, -2, 1),
                new LeagueTableEntry("Team6", 2, 0, 1, 1, 1, 3, -2, 1),
                new LeagueTableEntry("Team2", 1, 0, 0, 1, 1, 2, -1, 0),
                new LeagueTableEntry("Team7", 1, 0, 0, 1, 1, 2, -1, 0));

        Match match1 = new Match("Team1", "Team2", 2, 1);
        Match match2 = new Match("Team3", "Team4", 4, 2);
        Match match3 = new Match("Team5", "Team6", 3, 1);
        Match match4 = new Match("Team7", "Team8", 1, 2);
        Match match5 = new Match("Team1", "Team3", 3, 2);
        Match match6 = new Match("Team5", "Team8", 5, 4);
        Match match7 = new Match("Team1", "Team5", 2, 1);
        Match match8 = new Match("Team4", "Team6", 0, 0);
        LeagueTable leagueTable = new LeagueTable(List.of(match1, match2, match3, match4, match5, match6, match7, match8));
        List<LeagueTableEntry> tableEntries = leagueTable.getTableEntries();

        assertEquals(expectedTableEntries, tableEntries);
    }
}