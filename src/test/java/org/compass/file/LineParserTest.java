package org.compass.file;

import org.compass.model.Row;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class LineParserTest {

    public static final String PARSE_COMPLETE = "1,Ciara,French,mollis.lectus.pede@outlook.net,39746,449-6990 Tellus. Rd.";
    public static final String PARSE_WITHOUT_ADDRESS = "1,Ciara,French,mollis.lectus.pede@outlook.net,39746,";

    private final LineParser parser = new LineParser();

    @Test
    void parse_OK() {
        Row contact = this.parser.parse(PARSE_COMPLETE);
        assertNotNull(contact);
        assertEquals(1, contact.getId());
        assertEquals("Ciara", contact.getName());
        assertEquals("French", contact.getLastname());
        assertEquals("mollis.lectus.pede@outlook.net", contact.getEmail());
        assertEquals("39746", contact.getPostalZip());
        assertEquals("449-6990 Tellus. Rd.", contact.getAddressZip());
    }

    @Test
    void parse_without_address_OK() {
        Row contact = this.parser.parse(PARSE_WITHOUT_ADDRESS);
        assertNotNull(contact);
        assertEquals(1, contact.getId());
        assertEquals("Ciara", contact.getName());
        assertEquals("French", contact.getLastname());
        assertEquals("mollis.lectus.pede@outlook.net", contact.getEmail());
        assertEquals("39746", contact.getPostalZip());
        assertNull(contact.getAddressZip());
    }
}
