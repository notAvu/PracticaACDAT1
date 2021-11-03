package FileManager;

import Clases.Persona;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.charset.Charset;

public class PersonaManager extends IndexManager{
    private static final int REG_SIZE=214;
    public PersonaManager(File file) {
        super(file);
    }

    public PersonaManager(String fileName){

        super(fileName);
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
            this.randomAccess.seek(position *REG_SIZE);

            this.writeString(client.getNombre());
            this.writeString(client.getApellidos());
            this.writeString(client.getDni());
            this.writeString(client.getDireccion());
            this.writeNumber(client.getNumTelefono());
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
            randomAccess.seek((long) position * REG_SIZE);
        } catch (IOException exception) {
            exception.printStackTrace();
        }
        return readString();
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
        try {
            persona=new Persona(this.readFirst(position),
                    this.readString(),
                    this.readString(),
                    this.readString(),
                    this.readInt(this.randomAccess.getFilePointer()));
        } catch (IOException e) {
            e.printStackTrace();
        }
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
    public void export(Charset charset)
    {
        int i=0;
        while(i>=0)
        {
            TextFileManager textFileManager=new TextFileManager(charset);
            Persona aux=readPerson(i);
            if(aux.validar()) {
                textFileManager.escribirCliente(aux);
            }
            i++;
        }
    }
}
