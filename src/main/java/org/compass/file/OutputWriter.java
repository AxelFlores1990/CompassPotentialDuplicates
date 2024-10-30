package org.compass.file;

import org.compass.model.Match;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.List;

import static java.nio.file.Files.newBufferedWriter;

/**
 * Manage the write access to output csv.
 */
public class OutputWriter {

    private static final String CSV_HEADER = "leftID,rightID,accuracy";

    private static final String CSV_SEPARATOR = ",";

    /**
     * Writes the csv report.
     *
     * @param outputPath - File to write the report.
     * @param scoredMatches - Information used for the report.
     */
    public void writeReport(String outputPath, List<Match> scoredMatches) {
        try (BufferedWriter writer = newBufferedWriter(Paths.get(outputPath))) {
            writer.write(CSV_HEADER);
            writer.newLine();

            for (Match match : scoredMatches) {
                writer.write(match.toCSVRow(CSV_SEPARATOR));
                writer.newLine();
            }

        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
    }
}