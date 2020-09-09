package com.pulselive.leaguetable;

import java.util.*;

import static java.util.Collections.reverseOrder;

/**
 * League table for football.
 * Each team plays a number of matches and the results of each match build the table.
 * {@code LeagueTable} can take a list of completed matches and produce a sorted
 * {@code List} of {@code LeagueTableEntry} objects.
 *
 * @author sahak_babayan
 *
 */
public class LeagueTable
{

    private List<LeagueTableEntry> tableEntries;

    public LeagueTable( final List<Match> matches )
    {
        sortLeagueTableEntries(processLeagueTable(matches));
    }

    /**
     * Returns {@code Collection} of {@code LeagueTableEntry} which processed from {@code List} of {@code Match}
     *
     * @param      matches the {@code Match} {@code List} for league
     *
     * @return     {@code Collection} of {@code LeagueTableEntry}
     */
    private Collection<LeagueTableEntry> processLeagueTable( final List<Match> matches )
    {
        Map<String, LeagueTableEntry> tableEntryMap = new HashMap<>();
        matches.forEach(match -> processLeagueTableEntry(tableEntryMap, match));
        return tableEntryMap.values();
    }

    /**
     * Storing each team result in tableEntryMap for later processing
     *
     * @param      tableEntryMap the {@code Map} where {@code LeagueTableEntry} are stored according teamName property
     *
     * @param      match the {@code Match} representing two teams and there scores
     */
    private void processLeagueTableEntry( final Map<String, LeagueTableEntry> tableEntryMap, final Match match )
    {
        String homeTeam = match.getHomeTeam();
        String awayTeam = match.getAwayTeam();
        int homeScore = match.getHomeScore();
        int awayScore = match.getAwayScore();
        int homeWon = 0;
        int homeLost = 0;
        int awayWon = 0;
        int awayLost = 0;
        int drawn = 0;
        if (homeScore == awayScore) {
            drawn = 1;
        } else if (homeScore > awayScore) {
            homeWon = 1;
            awayLost = 1;
        } else {
            awayWon = 1;
            homeLost = 1;
        }
        // update results for home team
        updateLeagueTableMap(tableEntryMap,
                new LeagueTableEntryValue(homeTeam, homeWon, drawn, homeLost, homeScore, awayScore));
        // update results for away team
        updateLeagueTableMap(tableEntryMap,
                new LeagueTableEntryValue(awayTeam, awayWon, drawn, awayLost, awayScore, homeScore));
    }

    /**
     * If team is playing for the first time then store it in tableEntryMap for later update, if team played before
     * then update results regarding current {@code Match} result
     *
     * @param      tableEntryMap the {@code Map} where {@code LeagueTableEntry} are stored according teamName property
     *
     * @param      leagueTableEntryValue represents {@code LeagueTableEntryValue} which contains fields that need
     *                                  to be updated in {@code LeagueTableEntry}
     */
    private void updateLeagueTableMap( final Map<String, LeagueTableEntry> tableEntryMap,
                                      final LeagueTableEntryValue leagueTableEntryValue )
    {
        String teamName = leagueTableEntryValue.getTeamName();
        if (!tableEntryMap.containsKey(teamName)) {
            tableEntryMap.put(teamName, new LeagueTableEntry(leagueTableEntryValue));
        } else {
            LeagueTableEntry leagueTableEntry = tableEntryMap.get(teamName);
            leagueTableEntry.updateLeagueTableEntry(leagueTableEntryValue);
        }
    }

    /**
     * Sort the List<LeagueTableEntry> by points, goalDifference, goalsFor and tamName
     *
     * @param      tableEntryCollection is the {@code Collection<LeagueTableEntry>} which will be converted
     *                                  to {@code List} and be sorted after
     */
    private void sortLeagueTableEntries( final Collection<LeagueTableEntry> tableEntryCollection )
    {
        tableEntries = new ArrayList<>(tableEntryCollection);
        tableEntries.sort(Comparator.comparing(LeagueTableEntry::getPoints, reverseOrder())
                .thenComparing(LeagueTableEntry::getGoalDifference, reverseOrder())
                .thenComparing(LeagueTableEntry::getGoalsFor, reverseOrder())
                .thenComparing(LeagueTableEntry::getTeamName));
    }

    /**
     * Get the ordered list of league table entries for this league table.
     *
     * @return      {@code List<LeagueTableEntry>} which contains already sorted result
     */
    public List<LeagueTableEntry> getTableEntries()
    {
        return tableEntries;
    }
}
