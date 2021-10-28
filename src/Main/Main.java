package Main;

import Clases.Persona;
import FileManager.BinFileManager;

import java.io.File;

public class Main {
    public static void main(String[] args) {
        BinFileManager clientes=new BinFileManager(new File("Clientes"));

        Persona tu = new Persona("Pepe", "Lopez","38361517R", "lejos", 617829301);
        clientes.writePerson(tu);

        Persona per= clientes.readPerson(2);
        clientes.close();
        System.out.println(per.getNombre());
        System.out.println(per.getApellidos());
        System.out.println(per.getDni());
        System.out.println(per.getDireccion());
        System.out.print(per.getNumTelefono());
    }
}
