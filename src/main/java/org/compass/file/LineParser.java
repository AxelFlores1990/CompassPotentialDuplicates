package org.compass.file;

import org.compass.model.Row;

/**
 * Parse each line of the input csv.
 */
public class LineParser {

    private static final Integer idCol = 0;
    private static final Integer nameCol = 1;
    private static final Integer lastnameCol = 2;
    private static final Integer emailCol = 3;
    private static final Integer postalZipCol = 4;
    private static final Integer addressZipCol = 5;

    private static final String separator = ",";

    /**
     * Parse each line of the csv file.
     *
     * @param line - Line content of the csv.
     * @return Row - Returns te line parsed to contact Row.
     */
    public Row parse(String line) {
        String[] cols = line.split(separator);

        Row.RowBuilder rowBuilder = new Row.RowBuilder()
                .id(Long.valueOf(cols[idCol]))
                .name(cols[nameCol])
                .lastName(cols[lastnameCol])
                .email(cols[emailCol])
                .postalZip(cols[postalZipCol]);

        if (!line.endsWith(separator)) {
            rowBuilder.addressZip(cols[addressZipCol]);
        }

        return rowBuilder.build();
    }
}
