package org.compass;

import org.compass.file.InputReader;
import org.compass.file.OutputWriter;
import org.compass.function.Matches;
import org.compass.model.Match;
import org.compass.model.Row;

import java.time.Duration;
import java.time.Instant;
import java.util.List;

/**
 * It is responsible for carrying out the integration between all the components necessary for the generation
 * of the csv report.
 */
public class ReportGenerator {

    /**
     * Default input csv to execute the report. This is override in case that the user use args for the paths.
     */
    private static final String defaultInputPath = System.getProperty("user.home").concat("/Code Assessment - Find Duplicates Input - SampleCodecsv (1) (1).csv");

    /**
     * Default output csv to write the report. This is override in case that the user use args for the paths.
     */
    private static final String defaultOutputPath = System.getProperty("user.home").concat("/PotentiallyMatches.csv");

    private final InputReader reader;

    private final OutputWriter writer;

    private final Matches duplicates;

    public ReportGenerator() {
        this.reader = new InputReader();
        this.writer = new OutputWriter();
        this.duplicates = new Matches();
    }

    public ReportGenerator(InputReader reader, OutputWriter writer, Matches duplicates) {
        this.reader = reader;
        this.writer = writer;
        this.duplicates = duplicates;
    }

    /**
     * Generates the report based on the input csv
     *
     * @param inputAbsolutePath  - input csv to process the report.
     * @param outputAbsolutePath  - output csv to write the report.
     */
    public void generateFrom(String inputAbsolutePath, String outputAbsolutePath) {
        final List<Row> contacts = this.reader.readContacts(inputAbsolutePath);
        final List<Match> scoredMatches = this.duplicates.scoreMatchesList(contacts);
        this.writer.writeReport(outputAbsolutePath, scoredMatches);
    }

    /**
     * Entry point to execute the report. Only takes the input and output args and use then to execute the report.
     * In case that the args were not present it use the default path values.
     *
     * @param args - Input and Output file paths.
     */
    public static void main(String[] args) {
        Instant start = Instant.now();

        final ReportGenerator reportGenerator = new ReportGenerator();

        if (args.length == 2) {
            System.out.println("Writing report from: "+ args[0] + " to: " + args[1]);
            reportGenerator.generateFrom(args[0], args[1]);
        } else {
            System.out.println("Writing report from: "+ defaultInputPath + " to: " + defaultOutputPath);

            reportGenerator.generateFrom(defaultInputPath, defaultOutputPath);
        }

        Instant end = Instant.now();
        System.out.println("Takes: " + Duration.between(start, end).toMillis() + " ms");
    }
}
