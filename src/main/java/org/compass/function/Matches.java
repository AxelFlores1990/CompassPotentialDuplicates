package org.compass.function;

import org.compass.model.Match;
import org.compass.model.Row;

import java.util.ArrayList;
import java.util.List;

import static org.compass.function.RowComparisonUtils.isPotentiallyMatch;
import static org.compass.function.RowComparisonUtils.scoreAccuracy;

/**
 * Manage the match criteria for contact information.
 */
public class Matches {

    /**
     *
     * Find and scores each match that be present in the contacts list.
     *
     * @param contacts - list with the contacts.
     * @return List<Match> - list with the matches and their score.
     */
    public List<Match> scoreMatchesList(List<Row> contacts) {
        List<Match> scoredMatches = new ArrayList<>();

        contacts.forEach(lRow -> {
            List<Match> scoredMatchesByRow = contacts.stream()
                    .filter(rRow -> isPotentiallyMatch(lRow, rRow))
                    .map(rRow ->
                        new Match.MatchBuilder()
                                .leftID(lRow.getId())
                                .rightID(rRow.getId())
                                .accuracy(scoreAccuracy(lRow, rRow))
                                .build())
                    .toList();

            scoredMatches.addAll(scoredMatchesByRow);
        });

        return scoredMatches;
    }
}
