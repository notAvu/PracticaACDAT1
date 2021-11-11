package Test.FileManager;

import FileManager.IndexManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class IndexManagerTest {

    IndexManager FIN;

    @BeforeEach
    void setUp() {
        FIN= new IndexManager("testFile");
        FIN.writeNumber(0);
        FIN.writeString("12345678R");
        FIN.writeNumber(1);
        FIN.writeString("32345678R");
        FIN.writeNumber(2);
        FIN.writeString("22345678R");
    }

    @Test
    void testLastIndex() {
        assertEquals (2, FIN.lastIndex());
    }

    @Test
    void testReadLong() {
        assertEquals(0, FIN.readLong(0));
    }

    @Test
    void testGetPosition() {
        assertEquals(1, FIN.getPosition("32345678R"));
    }
}