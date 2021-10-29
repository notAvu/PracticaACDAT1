package FileManager;

import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileNotFoundException;

import static org.junit.jupiter.api.Assertions.*;

class PersonaManagerTest extends IndexManager {

    public PersonaManagerTest(File file) {
        super(file);
    }

    public PersonaManagerTest(String fileName) throws FileNotFoundException {
        super(fileName);
    }


    @Test
    void testWriteString() {

    }

    @Test
    void testWriteNumber() {
    }

    @Test
    void testReadString() {
    }

    @Test
    void testReadInt() {
    }

    @Test
    void writePerson() {
    }

    @Test
    void readFirst() {
    }

    @Test
    void readPerson() {
    }

    @Test
    void remove() {
    }

    @Test
    void export() {
    }
}