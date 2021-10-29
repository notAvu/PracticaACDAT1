package Main;

import Clases.Persona;
import FileManager.BinFileManager;
import FileManager.IndexManager;
import FileManager.PersonaManager;

import java.io.File;

public class Main {
    public static void main(String[] args) {
        PersonaManager clients= new PersonaManager("Clientes");
        IndexManager indice= new IndexManager("Indice_clientes");
        IndexManager config= new IndexManager("config");


    }
}
