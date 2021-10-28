package Clases;

import java.util.Objects;

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

    public boolean validar(){ return new DniValidator(dni).validar();}
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

    @Override
    public String toString() {
        return "nombre='%s', apellidos='%s', dni='%s', direccion='%s', numTelefono=%d".formatted(nombre, apellidos, dni, direccion, numTelefono);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Persona persona = (Persona) o;
        return numTelefono == persona.numTelefono && Objects.equals(nombre, persona.nombre) && Objects.equals(apellidos, persona.apellidos) && Objects.equals(dni, persona.dni) && Objects.equals(direccion, persona.direccion);
    }

}
class DniValidator {
    private String dni;

    public DniValidator(String dni) {
        this.dni = dni;
    }

    public boolean validar() {
        String letraMayuscula = "";


        if(dni.length() != 9 || !Character.isLetter(this.dni.charAt(8))) {
            return false;
        }

        letraMayuscula = (this.dni.substring(8)).toUpperCase();


        if(soloNumeros() && letraDNI().equals(letraMayuscula)) {
            return true;
        }
        else {
            return false;
        }
    }

    private boolean soloNumeros() {

        int i, j = 0;
        String numero;
        String miDNI = "";
        String[] unoNueve = {"0","1","2","3","4","5","6","7","8","9"};

        for(i = 0; i < this.dni.length() - 1; i++) {
            numero = this.dni.substring(i, i+1);

            for(j = 0; j < unoNueve.length; j++) {
                if(numero.equals(unoNueve[j])) {
                    miDNI += unoNueve[j];
                }
            }
        }

        if(miDNI.length() != 8) {
            return false;
        }
        else {
            return true;
        }
    }

    private String letraDNI() {
        
        int miDNI = Integer.parseInt(this.dni.substring(0,8));
        int resto = 0;
        String miLetra = "";
        String[] asignacionLetra = {"T", "R", "W", "A", "G", "M", "Y", "F", "P", "D", "X", "B", "N", "J", "Z", "S", "Q", "V", "H", "L", "C", "K", "E"};

        resto = miDNI % 23;

        miLetra = asignacionLetra[resto];

        return miLetra;
    }
}
