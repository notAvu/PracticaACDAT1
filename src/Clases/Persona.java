package Clases;

/**
 * @Author Alvaro Fernandez
 *
 * Esta clase contiene los datos necesarios sobre los clientes
 */
public class Persona {
    private String nombre;
    private String apellidos;
    private String dni;
    private String direccion;
    private int numTelefono;

    public Persona(String nombre, String apellidos, String dni, String direccion, int numTelefono) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.dni = dni;
        this.direccion = direccion;
        this.numTelefono = numTelefono;
    }

    //Validaciones
    private boolean isSizeValid()
    {
        return dni.length()==9;
    }
    private boolean isFormatValid()
    {
        //TODO valdiar que caracteres 0-8 sean numeros y el ultimo sea letra
        return false;
    }
    private boolean isDniLetterValid()
    {
        char letra=dni.charAt(9);
        long numDni= Long.parseLong(this.dni.substring(0,8));
        int resto= (int) (numDni%23);
        String[] dniChars="T,R,W,A,G,M,Y,F,P,D,X,B,N,J,Z,S,Q,V,H,L,C,K,E".split(",");
        return (letra == dniChars[resto].charAt(0));

    }
    //finValidaciones

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public int getNumTelefono() {
        return numTelefono;
    }

    public void setNumTelefono(int numTelefono) {
        this.numTelefono = numTelefono;
    }


}
