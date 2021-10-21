package RAF;

import java.io.Closeable;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.logging.Level;
import java.util.logging.Logger;

    /**
     *
     * @author antonio
     */
    class AccesoAleatorio implements Closeable {

        private static final String NOMBRE_FICHERO = "registros.txt";

        private static final int LONGITUD_REGISTRO = 25;
        private static final int NUMERO_RESGISTROS = 4;
        private static final String REGISTRO_ESTANDAR = "Un registro estándar";

        private static final int POSICION_A_MODIFICAR = 2;
        private static final String REGISTRO_ALTERNATIVO = "***Registro alternativo";

        private static final boolean ALINEAR_REGISTROS_IZQUIERDA = true;

        private final RandomAccessFile ficheroAccesoAleatorio;

        public static void main(String[] args) {
            try (AccesoAleatorio accesoAleatorio = new AccesoAleatorio();) {
                accesoAleatorio.escribirRegistrosEstandar();
                accesoAleatorio.sustituirRegistroEstandarPorAlternativo();
            } catch (IOException ex) {
                Logger.getLogger(AccesoAleatorio.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        public AccesoAleatorio() throws FileNotFoundException {
            eliminarFicheroAleatorioSiExiste();
            ficheroAccesoAleatorio = new RandomAccessFile(new File(NOMBRE_FICHERO), "rws");
        }

        private void eliminarFicheroAleatorioSiExiste() {
            File fichero = new File(NOMBRE_FICHERO);
            if (fichero.exists()) {
                fichero.delete();
            }
        }

        @Override
        public void close() throws IOException {
            if (ficheroAccesoAleatorio != null) {
                ficheroAccesoAleatorio.close();
            }
        }

        public void escribirRegistrosEstandar() throws IOException {
            for (int i = 0; i < NUMERO_RESGISTROS; i++) {
                escribir(REGISTRO_ESTANDAR);
            }
        }

        public void sustituirRegistroEstandarPorAlternativo() throws IOException {
            ficheroAccesoAleatorio.seek(POSICION_A_MODIFICAR * LONGITUD_REGISTRO);
            escribir(REGISTRO_ALTERNATIVO);
        }

        private void escribir(String cadena) throws IOException {
            ficheroAccesoAleatorio.write(formatearCadena(cadena).getBytes(),
                    0, LONGITUD_REGISTRO);
        }

        private String formatearCadena(String cadena) {
            return String.format(obtenerFormatoPredefinido(), cadena);
        }

        private String obtenerFormatoPredefinido() {
            StringBuilder formato = new StringBuilder("%");
            if (ALINEAR_REGISTROS_IZQUIERDA) {
                formato.append('-');
            }
            formato.append(LONGITUD_REGISTRO);
            formato.append('s');
            return formato.toString();
        }
    }
