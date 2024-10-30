package org.compass.function;

import org.compass.model.Match;
import org.compass.model.Row;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.compass.TestUtils.dummyContactsWithMatches;
import static org.compass.function.RowComparisonUtils.isPotentiallyMatch;
import static org.compass.function.RowComparisonUtils.scoreAccuracy;
import static org.compass.model.Match.ACCURACY.*;
import static org.junit.jupiter.api.Assertions.*;

public class RowComparisonUtilsTest {

    @Test
    public void isPotentiallyMatch_not_match_same_id_OK() {
        Row row1 = new Row.RowBuilder()
                .id(1L)
                .name("first name")
                .lastName("first name")
                .email("first@first.com")
                .postalZip("first postal")
                .addressZip("first address")
                .build();

        Row row2 = new Row.RowBuilder()
                .id(1L)
                .name("first name")
                .lastName("second last")
                .email("second@second.com")
                .postalZip("second postal")
                .addressZip("second address")
                .build();

        assertFalse(isPotentiallyMatch(row1, row2));
    }

    @Test
    public void isPotentiallyMatch_match_attribute_OK() {
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

        assertTrue(isPotentiallyMatch(row1, row2));
    }

    @Test
    public void isPotentiallyMatch_not_match_null_address_OK() {
        Row row1 = new Row.RowBuilder()
                .id(1L)
                .name("first name")
                .lastName("first name")
                .email("first@first.com")
                .postalZip("first postal")
                .build();

        Row row2 = new Row.RowBuilder()
                .id(2L)
                .name("second name")
                .lastName("second last")
                .email("second@second.com")
                .postalZip("second postal")
                .build();

        assertFalse(isPotentiallyMatch(row1, row2));
    }

    @Test
    public void isPotentiallyMatch_match_not_null_address_OK() {
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
                .addressZip("first address")
                .build();

        assertTrue(isPotentiallyMatch(row1, row2));
    }

    @Test
    public void scoreAccuracy_very_low_OK() {
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

        assertEquals(VERY_LOW, scoreAccuracy(row1, row2));
    }

    @Test
    public void scoreAccuracy_low_OK() {
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
                .name("first name")
                .lastName("first last")
                .email("second@second.com")
                .postalZip("second postal")
                .addressZip("second address")
                .build();

        assertEquals(LOW, scoreAccuracy(row1, row2));
    }

    @Test
    public void scoreAccuracy_high_OK() {
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
                .name("first name")
                .lastName("first last")
                .email("first@first.com")
                .postalZip("second postal")
                .addressZip("second address")
                .build();

        assertEquals(HIGH, scoreAccuracy(row1, row2));
    }

    @Test
    public void scoreAccuracy_very_high_OK() {
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
                .name("first name")
                .lastName("first last")
                .email("first@first.com")
                .postalZip("second postal")
                .addressZip("first address")
                .build();

        assertEquals(VERY_HIGH, scoreAccuracy(row1, row2));
    }
}
