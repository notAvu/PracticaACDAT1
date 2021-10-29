package FileManager;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

public class IndexManager {
    private File file;
    protected RandomAccessFile randomAccess;

    public IndexManager(File file) {
        this.file = file;
        try {
            this.randomAccess = new RandomAccessFile(file, "rw");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public IndexManager(String fileName) {
        try {
            this.randomAccess = new RandomAccessFile(new File(fileName), "rw");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    /**
     * Metodo para facilitar la escritura de cadenas en el fichero
     *
     * @param string
     */
    public void writeString(String string) {
        try {
            randomAccess.writeUTF(string);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Metodo para facilitar la escritura de enteros en el fichero
     *
     * @param num
     */
    public void writeNumber(int num) {
        try {
            randomAccess.writeInt(num);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    protected String readString() {
        String value = "";
        try {
            value = randomAccess.readUTF();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return value;
    }

    /**
     * Metodo para facilitar la lectura de enteros del fichero
     *
     * @param position
     * @return
     */
    public int readInt(long position) {
        int i = 0;
        try {
            randomAccess.seek(position);
            i = randomAccess.readInt();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return i;
    }
}
