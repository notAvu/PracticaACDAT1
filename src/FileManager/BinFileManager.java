package FileManager;

import Clases.Persona;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.charset.StandardCharsets;

public class BinFileManager {
    private static final int PERSONA_SIZE = 214;
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

    /**
     * Metodo para facilitar la escritura de cadenas en el fichero
     *
     * @param string
     */
    public void writeString(String string)
    {
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
    public void writeNumber(int num)
    {
        try {
            randomAccess.writeInt(num);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Metodo para facilitar la lectura de cadenas del fichero
     * @param position
     * @return
     */
    public String readFirst(int position)
    {
        try {
            randomAccess.seek((long) position * PERSONA_SIZE);
        } catch (IOException exception) {
            exception.printStackTrace();
        }
        return readString();
    }

    private String readString() {
        String value="";
        try {
            value= randomAccess.readUTF();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return value;
    }

    /**
     * Metodo para facilitar la lectura de enteros del fichero
     * @param position
     * @return
     */
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

    /**
     * Metodo para escribir todos los atributos de un objeto Persona en el fichero
     * Precondiciones: client debe ser un objeto valido de la clase Persona
     * Poscondiciones: se deben haber registrado los atributos de la persona en el fichero
     * @param client
     */
    public void writePerson(Persona client, long position)
    {
        try {
            this.randomAccess.seek(position *PERSONA_SIZE);

            this.writeString(client.getNombre());
            this.writeString(client.getApellidos());
            this.writeString(client.getDni());
            this.writeString(client.getDireccion());
            this.writeString(client.getNumTelefono());
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    /**
     * Lee completamente un objeto de la clase Persona
     * Precondiciones: el fichero debe contener al menos un registro de la clase Persona
     * Poscondiciones: ninguna
     * @param position
     * @return persona
     */
    public Persona readPerson(int position)
    {
        Persona persona=null;
        persona=new Persona(this.readFirst(position),
               this.readString(),
               this.readString(),
               this.readString(),
               this.readString());
        return persona;
    }
    public void remove(int position)
    {
        //TODO
    }

    /**
     * Pasa todos los datos del fichero a un fichero de texto
     * Precondiciones: el fichero debe contener al menos un elemento de la clase Person
     * Poscondicones: se debe haber creado el fichero de texto y registrado los cambios en este
     */
    public void export()
    {
        int i=0;
        while(i>=0)
        {
            TextFileManager textFileManager=new TextFileManager(StandardCharsets.UTF_8);
            Persona aux=readPerson(i);
            if(aux.validar()) {
                textFileManager.writeClient(aux);
            }
            i++;
        }
    }

    /**
     * Cierra el flujo del RandomAccessFile
     */
    public void close()
    {
        try {
            randomAccess.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
