package org.compass;

import org.compass.function.Matches;
import org.compass.model.Match;
import org.compass.model.Row;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.compass.file.InputReader;
import org.compass.file.OutputWriter;

import java.util.List;
import java.util.Map;

import static org.compass.TestUtils.*;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ReportGeneratorTest {

    @Mock
    InputReader reader;

    @Mock
    OutputWriter writer;

    @Mock
    Matches matches;

    @Test
    public void execute_OK() {
        final ReportGenerator reportGenerator = new ReportGenerator(this.reader, this.writer, this.matches);

        final List<Row> contacts = dummyContacts();
        final List<Match> scoredMatches = dummyScoredMatches();

        final String dummyInputPath = "input/dummy/path.txt";
        final String dummyOutputPath = "output/dummy/path.txt";

        when(this.reader.readContacts(eq(dummyInputPath))).thenReturn(contacts);
        when(this.matches.scoreMatchesList(eq(contacts))).thenReturn(scoredMatches);
        doNothing().when(this.writer).writeReport(eq(dummyOutputPath), eq(scoredMatches));

        reportGenerator.generateFrom(dummyInputPath, dummyOutputPath);
    }
}
