package vista;

public class Menu {
    public static final String MAIN_MENU= """
            Gestor de Ficheros:
            1.Registrar Cliente
            2.Consultar Cliente
            3.Borrar Cliente
            4.Cambiar configuracion
            5.Exportar
            0.Salir
            """;
    public static final String NOMBRE= "Nombre del cliente:";
    public static final String APELLIDO="Apellido del cliente";
    public static final String DNI="DNI del cliente";
    public static final String DIRECCION="Direccion del cliente:";
    public static final String TELEFONO="Numero de telefono del cliente";

    public static void printMenu()
    {
        System.out.println(MAIN_MENU);
    }
    public static void askInfo(String info){
        System.out.println(NOMBRE);
    }
}
