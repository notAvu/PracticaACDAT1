package Main;

import Clases.Persona;
import FileManager.BinFileManager;

import java.io.File;

public class Main {
    public static void main(String[] args) {
        BinFileManager config =new BinFileManager(new File("Config"));
        BinFileManager clientes=new BinFileManager(new File("Clientes"));
        BinFileManager listado=new BinFileManager(new File("ClientesList"));

        Persona yo = new Persona("Pepe", "Viyuela","38361517R", "lejos", 617829301);
        clientes.writePerson(yo);


    }
}
