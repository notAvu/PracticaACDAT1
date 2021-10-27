package Test;

import Clases.Persona;
import FileManager.BinFileManager;

import java.io.File;

import static org.junit.jupiter.api.Assertions.*;

class BinFileManagerTest {


    @org.junit.jupiter.api.Test
    void writeString() {
        BinFileManager clientes = new BinFileManager(new File("Clientes"));

        clientes.writeString("Assert");

        assertEquals(clientes.readString(0), "Assert");
    }

    @org.junit.jupiter.api.Test
    void writeNumber() {
        BinFileManager clientes = new BinFileManager(new File("Clientes"));

        clientes.writeNumber(12);

        assertEquals(clientes.readInt(0), 12);
    }

    @org.junit.jupiter.api.Test
    void writeReadPerson() {
        BinFileManager clientes = new BinFileManager(new File("Clientes"));

        Persona yo = new Persona("Dario", "Sanchez", "12345678A", "lejos", 617822501);

        clientes.writePerson(yo);

        assertEquals(clientes.readPerson(0), yo);
    }
}