package Clases;

public class DniValidator {
    private String dni;
    public DniValidator(String dni) {
        this.dni = dni;
    }
    public boolean validar() {
        String letraMayuscula;
        boolean valido=false;
        if (dni.length() == 9 || Character.isLetter(this.dni.charAt(8))) {
            letraMayuscula = (this.dni.substring(8)).toUpperCase();
            if (soloNumeros() && letraDNI().equals(letraMayuscula)) {
                valido = true;
            }
        }
        return valido;
    }
    private boolean soloNumeros() {
        boolean valido=true;
        int i, j = 0;
        String numero;
        StringBuilder miDNI = new StringBuilder();
        String[] unoNueve = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9"};
        for (i = 0; i < this.dni.length() - 1; i++) {
            numero = this.dni.substring(i, i + 1);
            for (j = 0; j < unoNueve.length; j++) {
                if (numero.equals(unoNueve[j])) { miDNI.append(unoNueve[j]); }
            }
        }
        if (miDNI.length() != 8) {
            valido= false;
        }
        return valido;
    }
    private String letraDNI() {
        int miDNI = Integer.parseInt(this.dni.substring(0, 8));
        int resto = 0;
        String miLetra = "";
        String[] asignacionLetra = {"T", "R", "W", "A", "G", "M", "Y", "F", "P", "D", "X", "B", "N", "J", "Z", "S", "Q", "V", "H", "L", "C", "K", "E"};
        resto = miDNI % 23;
        miLetra = asignacionLetra[resto];
        return miLetra;
    }
}
