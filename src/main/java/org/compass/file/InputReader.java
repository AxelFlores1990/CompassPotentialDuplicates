package org.compass.file;

import org.compass.model.Row;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.*;

import static java.nio.file.Files.newBufferedReader;

/**
 * Manage the read access to input csv and format the retrieved data in appropriate structure.
 */
public class InputReader {

    private final LineParser lineParser;

    public InputReader() {
        this.lineParser = new LineParser();
    }

    /**
     * Read the input csv using the LineParser to convert each line to contact Row.
     *
     * @param absolutePath - Path to read the input csv.
     *
     * @return A list with the contacts in the csv.
     */
    public List<Row> readContacts(String absolutePath) {
        try (BufferedReader br = newBufferedReader(Paths.get(absolutePath))) {
            return br.lines().skip(1).map(this.lineParser::parse).toList();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}