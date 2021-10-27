package Main;

import Clases.Persona;
import FileManager.BinFileManager;

import java.io.File;

public class Main {
    public static void main(String[] args) {
        BinFileManager config =new BinFileManager(new File("Config"));
        BinFileManager clientes=new BinFileManager(new File("Clientes"));
        BinFileManager listado=new BinFileManager(new File("ClientesList"));

        Persona tu = new Persona("Pepe", "Lopez","38361517R", "lejos", 617829301);
        Persona yo = new Persona("Dario", "Sanchez","12345678A", "lejos", 617822501);
        clientes.writePerson(tu);
        clientes.writePerson(yo);

        Persona per= clientes.readPerson(1);
        clientes.close();
        System.out.print(per.getNombre());


    }
}
