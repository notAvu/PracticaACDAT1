package Main;

import Clases.DniValidator;
import Clases.Persona;
import FileManager.IndexManager;
import FileManager.PersonaManager;
import vista.Menu;

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
                    addPersona(clients, scan, indice);
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

    private static void addToIndex(IndexManager manager,String dni, int position)
    {
        manager.writeNumber(position);
        manager.writeString(dni);
    }

    private static void addPersona(PersonaManager clientManager, Scanner scan, IndexManager indexManager) {
        String nombre="";
        String apellido="";
        String dni="";
        String telefono="";
        String direccion="";
        while (!nombre.equals("") || !apellido.equals("") || !dni.equals("") || !telefono.equals("")|| !direccion.equals("")) {
            nombre = askNombre(scan);
            apellido = askApellido(scan);
            dni = askDni(scan);
            telefono = askTelefono(scan);
            direccion = askDireccion(scan);
        }
        Persona persona = new Persona(nombre, apellido, dni, direccion, telefono);
        clientManager.writePerson(persona, 0);
        addToIndex(indexManager, dni, 0);
    }

    private static String askDireccion(Scanner scan) {
        String direccion;
        Menu.printInfo(Menu.DIRECCION);
        direccion = scan.next();
        return direccion;
    }

    private static String askTelefono(Scanner scan) {
        String telefono;
        Menu.printInfo(Menu.TELEFONO);
        telefono = scan.next();
        return telefono;
    }

    private static String askApellido(Scanner scan) {
        String apellido;
        Menu.printInfo(Menu.APELLIDO);
        apellido = scan.next();
        return apellido;
    }

    private static String askNombre(Scanner scan) {
        String nombre;
        Menu.printInfo(Menu.NOMBRE);
        nombre = scan.next();
        return nombre;
    }

    private static String askDni(Scanner scan) {
        String dni;
        Menu.printInfo(Menu.DNI);
        dni = scan.next();
        DniValidator validator=new DniValidator(dni);
        if(!validator.validar())
        {
            Menu.printInvalidDni();
            dni="";
        }
        return dni;
    }
}
