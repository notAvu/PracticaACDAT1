package FileManager;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
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

    public void writeString(String string)
    {
        try {
            randomAccess.writeChars(string);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void writeNumber(int num)
    {
        try {
            randomAccess.write(num);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void readString(long position)
    {
        try {
            randomAccess.seek(position);
            randomAccess.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void readIntlong(long position)
    {
        try {
            randomAccess.seek(position);
            randomAccess.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
