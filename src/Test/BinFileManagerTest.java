package Test;

import Clases.Persona;
import FileManager.BinFileManager;
import org.junit.jupiter.api.Test;

import java.io.File;

import static org.junit.jupiter.api.Assertions.*;

class BinFileManagerTest {

    final BinFileManager CLIENTE = new BinFileManager(new File("Clientes"));

    @org.junit.jupiter.api.Test
    void writeString() {

        CLIENTE.writeString("Assert");

        assertEquals(CLIENTE.readFirst(0), "Assert");
    }

    @Test
    void writeNumber() {

        CLIENTE.writeNumber(12);

        assertEquals(CLIENTE.readInt(0), 12);
    }

    @Test
    void writeReadPerson() {

        Persona yo = new Persona("Dario", "Sanchez", "12345678A", "lejos", 617822501);
        Persona tu = new Persona("Pepe", "Sanchez", "12345678A", "lejos", 617822501);

        CLIENTE.writePerson(yo, 0);

        CLIENTE.writePerson(tu, 1);

        assertEquals(CLIENTE.readPerson(1), tu);
    }
}