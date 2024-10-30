package org.compass.function;

import org.compass.model.Match;
import org.compass.model.Row;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.compass.TestUtils.dummyContacts;
import static org.compass.TestUtils.dummyContactsWithMatches;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class MatchesTest {

    @Test
    public void scoreMatchesList_OK() {
        final List<Row> contacts = dummyContactsWithMatches();
        List<Match> matches = new Matches().scoreMatchesList(contacts);

        assertNotNull(matches);
        assertEquals(6, matches.size());
    }

    @Test
    public void scoreMatchesList_empty_matches_OK() {
        final List<Row> contacts = dummyContacts();
        List<Match> matches = new Matches().scoreMatchesList(contacts);

        assertNotNull(matches);
        assertEquals(0, matches.size());
    }
}
