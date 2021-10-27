package FileManager;

import Clases.Persona;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

public class BinFileManager {
    private static final int REG_SIZE = 214;
    private File file;
    private RandomAccessFile randomAccess;

    public BinFileManager(File file) {
        this.file = file;
        try {
            this.randomAccess = new RandomAccessFile(file,"rw");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
    public BinFileManager(String fileName) throws FileNotFoundException {
        this.randomAccess= new RandomAccessFile(new File(fileName),"rw");
    }

    public void writeString(String string)
    {
        try {
            randomAccess.writeUTF(string);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void writeNumber(int num)
    {
        try {
            randomAccess.writeInt(num);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public String readString(int position)
    {
        try {
            randomAccess.seek((long) position *REG_SIZE);
        } catch (IOException exception) {
            exception.printStackTrace();
        }
        return read();
    }

    private String read() {
        String value="";
        try {
            value= randomAccess.readUTF();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return value;
    }

    public int readInt(long position)
    {
        int i =0;
        try {
            randomAccess.seek(position);
            i=randomAccess.readInt();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return i;
    }

    public void writePerson(Persona client)
    {
        this.writeString(client.getNombre());
        this.writeString(client.getApellidos());
        this.writeString(client.getDni());
        this.writeString(client.getDireccion());
        this.writeNumber(client.getNumTelefono());

    }
    public Persona readPerson(int position)
    {
        Persona re=null;
        try {
             re=new Persona(this.readString(position),
                    this.read(),
                    this.read(),
                    this.read(),
                    this.readInt(randomAccess.getFilePointer()));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return re;
    }

    public void close()
    {
        try {
            randomAccess.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
