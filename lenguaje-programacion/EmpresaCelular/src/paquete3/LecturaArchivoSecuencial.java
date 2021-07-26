package paquete3;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import paquete2.PlanCelular;

public class LecturaArchivoSecuencial {

    private ObjectInputStream entrada;
    private ArrayList<PlanCelular> planes;
    private String nombreArchivo;

    public LecturaArchivoSecuencial(String n) {
        nombreArchivo = n;
        File f = new File(obtenerNombreArchivo());
        if (f.exists()) {
            try { //Abre el archivo
                entrada = new ObjectInputStream(
                        new FileInputStream(n));
            } //Fin de try
            catch (IOException ioException) {
                System.err.println("Error al abrir el archivo.");
            } // Fin de catch
        }
    }

    public void establecerNombreArchivo(String n) {
        nombreArchivo = n;
    }

    public void establecerListaPlanes() {
        planes = new ArrayList<>();
        File f = new File(obtenerNombreArchivo());
        while (true) {
            try {
                Object registro = entrada.readObject();
                planes.add((PlanCelular) registro);
            } catch (EOFException endOfFileException) {
                return; //Se llegó al fin del archivo
            } catch (IOException ex) {
                System.err.println("Error al leer el archivo: " + ex);
            } catch (ClassNotFoundException ex) {
                System.err.println("No se pudo crear el objeto: " + ex);
            } catch (Exception ex) {
                //System.err.println("No hay datos en el archivo: " + ex);
                break;
            }
        }
    }

    public ArrayList<PlanCelular> obtenerListaPlanes() {
        return planes;
    }

    public String obtenerNombreArchivo() {
        return nombreArchivo;
    }

    @Override
    public String toString() {

        String cadena = "\t< LISTA DE PLANES CELULAR >\n"
                + "\t---------------------------\n";
        for (int i = 0; i < obtenerListaPlanes().size(); i++) {
            PlanCelular p = obtenerListaPlanes().get(i);
            cadena = String.format("%s%d) (%s)\n%s\n", cadena,
                    i + 1, p.getClass().getSimpleName(), p);
        }
        return cadena;
    }

    //Cierra el archivo y termina la aplicación
    public void cerrarArchivo() {
        try {// cierra el archivo y sale
            if (entrada != null) {
                entrada.close();
            }
            System.exit(0);
        } //Fin de try
        catch (IOException ioException) {
            System.err.println("Error al cerrar el archivo.");
            System.exit(1);
        } // Fin de catch
    } //Fin del método cerrarArchivo
}
