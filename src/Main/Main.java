package Main;

import Clases.Persona;
import FileManager.BinFileManager;

import java.io.File;

public class Main {
    public static void main(String[] args) {
        BinFileManager clientes=new BinFileManager(new File("Clientes"));

        Persona tu = new Persona("Pepe", "Lopez","38361517R", "lejos", 617829301);
        clientes.writePerson(tu);

        Persona per= clientes.readPerson(0);
        clientes.close();
        System.out.print(per.getNumTelefono());


    }
}
