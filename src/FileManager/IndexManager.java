package FileManager;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

public class IndexManager {
    private final static int REG_SIZE=26;
    private File file;
    protected RandomAccessFile randomAccess;

    public long lastIndex()
    {
        return file.length()/REG_SIZE;
    }

    public IndexManager(File file) {
        this.file = file;
        try {
            this.randomAccess = new RandomAccessFile(file, "rw");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public IndexManager(String fileName) {
        this.file= new File(fileName);
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
    public void writeNumber(long num) {
        try {
            randomAccess.writeLong(num);
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
     * @return int num
     */
    public long readLong(long position) {
        int num = 0;
        try {
            randomAccess.seek(position);
            num = randomAccess.readInt();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return num;
    }

    /**
     * Devuelve el indice si el dni esta en el fichero, si no devuelve -1
     * @param dni
     * @return
     */
    public long getPosition(String dni)
    {
        String id;
        long position=-1;
        boolean found=false;
        for(long i=0 ; i<file.length()/REG_SIZE && !found; i++)
        {
            i= readLong(i*REG_SIZE);
            id=readString();
            if(id.equals(dni))
            {
                position=i;
                found=true;
            }
        }
        return position;
    }
}
