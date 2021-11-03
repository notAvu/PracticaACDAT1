package Main;

import Clases.DniValidator;
import Clases.Persona;
import FileManager.BinFileManager;
import FileManager.IndexManager;
import FileManager.PersonaManager;
import vista.Menu;

import java.io.File;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        PersonaManager clients= new PersonaManager("Clientes");
        IndexManager indice= new IndexManager("Indice_clientes");
        IndexManager config= new IndexManager("config");
        String ans="";
        Scanner scan= new Scanner(System.in);
        while(ans!="1"||ans!="2"||ans!="3")
        {
            Menu.printMenu();
            ans=scan.next();
            switch (ans) {
                case "1" -> {
                    addPersona(clients, scan);
                }
                case "2" -> {
                    Menu.printInfo(Menu.DNI);
//                    String dni = scan.next();
//                    Persona p= clients.readPerson(indice.);

                }
                case "3" -> {
                    Menu.printInfo(Menu.DNI);
                    String dni=scan.next();
                }
                case "4" -> {

                }
                case "5" -> {

                }
                default -> {

                }
            }
        }
    }

    private static void addToIndex(String dni, int position)
    {

    }

    private static void addPersona(PersonaManager clients, Scanner scan) {
        String nombre="";
        String apellido="";
        String dni="";
        int tlfn = 0;
        String telefono="";
        String direccion="";
        while (!nombre.equals("") || !apellido.equals("") || !dni.equals("") || !telefono.equals("")|| !direccion.equals("")) {
            Menu.printInfo(Menu.NOMBRE);
            nombre = scan.next();
            Menu.printInfo(Menu.APELLIDO);
            apellido = scan.next();
            Menu.printInfo(Menu.DNI);
            dni = scan.next();
            DniValidator validator=new DniValidator(dni);
            if(!validator.validar())
            {
                Menu.printInvalidDni();
                dni="";
            }
            Menu.printInfo(Menu.TELEFONO);
            telefono = scan.next();
            Menu.printInfo(Menu.DIRECCION);
            direccion = scan.next();
        }
        Persona persona = new Persona(nombre, apellido, dni, direccion, telefono);
        clients.writePerson(persona, 0);
    }
}
