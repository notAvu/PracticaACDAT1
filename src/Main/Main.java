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
                    break;
                }
                case "2" -> {
                    break;
                }
                case "3" -> {
                    break;
                }
                case "4" -> {
                    break;
                }
                case "5" -> {
                    break;
                }
                default -> {
                    break;
                }
            }
        }
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
            try
            {
                tlfn=Integer.parseInt(telefono);
            }catch (NumberFormatException e)
            {
                Menu.invalidTelephone();
                telefono="";
            }
            Menu.printInfo(Menu.DIRECCION);
            direccion = scan.next();
        }
        Persona persona = new Persona(nombre, apellido, dni, direccion, tlfn);
        clients.writePerson(persona, 0);
    }
}
