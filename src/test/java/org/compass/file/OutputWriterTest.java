package org.compass.file;

import org.compass.TestUtils;
import org.compass.model.Match;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.LinkedHashMap;
import java.util.List;

import static org.compass.TestUtils.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class OutputWriterTest {

    public static final String OUTPUT_FILE_NAME = "outputFile.csv";
    private final OutputWriter writer = new OutputWriter();

    @Test
    void writeReport_file_not_found_KO() {
        RuntimeException thrown =
                assertThrows(RuntimeException.class, () -> this.writer.writeReport("asd/asd.csv", dummyScoredMatches()));

        assertEquals(NoSuchFileException.class, thrown.getCause().getClass());
        assertEquals("asd\\asd.csv", thrown.getCause().getMessage());
    }

    @Test
    void writeReport_OK(@TempDir Path tempDir) throws IOException, URISyntaxException {
        final Path outputFilePath = tempDir.resolve(OUTPUT_FILE_NAME);
        final  List<Match> matches = dummyScoredMatches();

        this.writer.writeReport(outputFilePath.toString(), matches);

        final String expectedFile = "file/OutputWriterTest/writeReport_OK.csv";
        final Path expectedFilePath = Paths.get(TestUtils.class.getClassLoader().getResource(expectedFile).toURI());

        List<String> expectedLines = Files.readAllLines(expectedFilePath);
        List<String> outputLines = Files.readAllLines(outputFilePath);

        assertEquals(expectedLines.size(), outputLines.size());

        for (int i = 0; i < expectedLines.size(); i++) {
            assertEquals(expectedLines.get(i), outputLines.get(i));
        }
    }
}
