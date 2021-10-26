package Main;

import Clases.Persona;
import FileManager.BinFileManager;

import java.io.File;

public class Main {
    public static void main(String[] args) {
        BinFileManager config =new BinFileManager(new File("Config"));
        BinFileManager clientes=new BinFileManager(new File("Clientes"));
        BinFileManager listado=new BinFileManager(new File("ClientesList"));

        Persona yo = new Persona("Pepe", "Pepez","38361517R", "lejos", 617829301);
        Persona tu = new Persona("Dario", "Dariez","12345678A", "lejos", 617822501);
        clientes.writePerson(tu);
        clientes.writePerson(yo);

        clientes.readPerson(0);


    }
}
