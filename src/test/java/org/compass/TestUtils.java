package org.compass;

import org.compass.model.Match;
import org.compass.model.Row;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class TestUtils {

    public static Path copyResourceToTemp(String resourceFile, String inputFile, Path tempDir) throws URISyntaxException, IOException {
        final Path resourceFilePath = Paths.get(TestUtils.class.getClassLoader().getResource(resourceFile).toURI());
        final Path inputFilePath = tempDir.resolve(inputFile);

        Files.copy(resourceFilePath, inputFilePath);
        return inputFilePath;
    }

    public static List<Row> dummyContacts() {
        Row row1 = new Row.RowBuilder()
                .id(1L)
                .name("first name")
                .lastName("first last")
                .email("first@first.com")
                .postalZip("first postal")
                .addressZip("first address")
                .build();

        Row row2 = new Row.RowBuilder()
                .id(2L)
                .name("second name")
                .lastName("second last")
                .email("second@second.com")
                .postalZip("second postal")
                .addressZip("second address")
                .build();

        Row row3 = new Row.RowBuilder()
                .id(3L)
                .name("third name")
                .lastName("third last")
                .email("third@third.com")
                .postalZip("third postal")
                .addressZip("third address")
                .build();

        return List.of(row1, row2, row3);
    }

    public static List<Row> dummyContactsWithMatches() {
        Row row1 = new Row.RowBuilder()
                .id(1L)
                .name("first name")
                .lastName("first name")
                .email("first@first.com")
                .postalZip("first postal")
                .addressZip("first address")
                .build();

        Row row2 = new Row.RowBuilder()
                .id(2L)
                .name("first name")
                .lastName("second last")
                .email("second@second.com")
                .postalZip("second postal")
                .addressZip("second address")
                .build();

        Row row3 = new Row.RowBuilder()
                .id(3L)
                .name("first name")
                .lastName("first name")
                .email("first@first.com")
                .postalZip("123")
                .addressZip("first address")
                .build();

        return List.of(row1, row2, row3);
    }

    public static List<Match> dummyScoredMatches() {
        Match match1 = new Match.MatchBuilder()
                .leftID(1L)
                .rightID(11L)
                .accuracy(Match.ACCURACY.VERY_LOW)
                .build();

        Match match2 = new Match.MatchBuilder()
                .leftID(2L)
                .rightID(22L)
                .accuracy(Match.ACCURACY.LOW)
                .build();

        Match match3 = new Match.MatchBuilder()
                .leftID(3L)
                .rightID(33L)
                .accuracy(Match.ACCURACY.HIGH)
                .build();

        return List.of(match1, match2, match3);
    }
}
