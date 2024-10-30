package org.compass.function;

import org.compass.model.Match;
import org.compass.model.Row;

import static java.util.Objects.isNull;
import static java.util.Objects.nonNull;

/**
 * Uitls for rows comparison operations.
 */
public class RowComparisonUtils {

    /**
     * Contains the criteria for users potentially matching.
     *
     * @param lRow - contact to compare.
     * @param rRow - contact to compare.
     *
     * @return boolean - true if the contact match almost one of the criteria.
     */
    public static boolean isPotentiallyMatch(Row lRow, Row rRow) {
        if (lRow.getId().equals(rRow.getId())) {
            return false;
        }

        return lRow.getName().equals(rRow.getName())
                || lRow.getLastname().equals(rRow.getLastname())
                || lRow.getEmail().equals(rRow.getEmail())
                || (nonNull(lRow.getAddressZip()) && (nonNull(rRow.getAddressZip())
                && lRow.getAddressZip().equals(rRow.getAddressZip())));
    }

    /**
     * Score the accuracy of the contacts.
     *
     *
     * @param lRow - contact to compare.
     * @param rRow - contact to compare.
     *
     * @return Match.ACCURACY - Accuracy for the user comparation.
     */
    public static Match.ACCURACY scoreAccuracy(Row lRow, Row rRow) {
        int matches = -1;

        if (lRow.getName().equals(rRow.getName())) {
            matches++;
        }

        if (lRow.getLastname().equals(rRow.getLastname())) {
            matches++;
        }

        if (lRow.getEmail().equals(rRow.getEmail())) {
            matches++;
        }

        if (((isNull(lRow.getAddressZip()) && isNull(rRow.getAddressZip()))
                || (nonNull(lRow.getAddressZip()) && (nonNull(rRow.getAddressZip())
                && lRow.getAddressZip().equals(rRow.getAddressZip()))))) {
            matches++;
        }

        return Match.ACCURACY.values()[matches];
    }
}
