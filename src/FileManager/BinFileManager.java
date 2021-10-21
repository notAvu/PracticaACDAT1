package FileManager;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.RandomAccessFile;

public class BinFileManager {
    private File file;
    private RandomAccessFile randomAccess;

    public BinFileManager(File file) throws FileNotFoundException {
        this.file = file;
        this.randomAccess = new RandomAccessFile(file,"rws");
    }
    public BinFileManager(String fileName) throws FileNotFoundException {
        this.randomAccess= new RandomAccessFile(new File(fileName),"rws");
    }

    public void escribirObjeto(Object o)
    {
        //randomAccess.write((byte[]) o);
    }
}
