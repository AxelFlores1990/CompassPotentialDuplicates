package org.compass.file;

import org.compass.model.Row;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;
import java.util.List;

import static org.compass.TestUtils.copyResourceToTemp;
import static org.junit.jupiter.api.Assertions.*;

public class InputReaderTest {

    public static final String INPUT_FILE_NAME = "input.csv";
    private final InputReader reader = new InputReader();

    @Test
    void readContacts_file_not_found_KO() {
        RuntimeException thrown =
                assertThrows(RuntimeException.class, () -> this.reader.readContacts("asd/asd.csv"));

        assertEquals(NoSuchFileException.class, thrown.getCause().getClass());
        assertEquals("asd\\asd.csv", thrown.getCause().getMessage());
    }

    @Test
    void readContacts_OK(@TempDir Path tempDir) throws URISyntaxException, IOException {
        final String resourceFile = "file/InputReaderTest/readContacts_OK.csv";
        final Path inputFilePath = copyResourceToTemp(resourceFile, INPUT_FILE_NAME, tempDir);

        List<Row> contacts = this.reader.readContacts(inputFilePath.toString());

        assertEquals(10, contacts.size());

        Row contact = contacts.get(9);

        assertNotNull(contact);
        assertEquals(10, contact.getId());
        assertEquals("Ivana", contact.getName());
        assertEquals("Mullins", contact.getLastname());
        assertEquals("urna.convallis@yahoo.net", contact.getEmail());
        assertEquals("38235", contact.getPostalZip());
        assertEquals("Ap #868-8966 Dolor. Street", contact.getAddressZip());
    }
}
