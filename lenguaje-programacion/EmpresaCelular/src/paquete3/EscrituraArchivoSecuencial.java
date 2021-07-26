package paquete3;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import paquete2.PlanCelular;

public class EscrituraArchivoSecuencial {

    private String nombreArchivo;
    private ObjectOutputStream salida; //Envía los datos a un archivo
    private PlanCelular registro;
    private ArrayList<PlanCelular> lista;

    public EscrituraArchivoSecuencial(String nombreArc) {
        nombreArchivo = nombreArc;
        establecerLista(); //Obtener los valores (objetos)que tiene el archivo.
        // System.out.println(obtenerListaProfesores().size());
        try { //Abre el archivo
            salida = new ObjectOutputStream(
                    new FileOutputStream(nombreArchivo));
            //Proceso para ingresar nuevamente los valores del archivo
            if (obtenerLista().size() > 0) {
                for (int i = 0; i < obtenerLista().size(); i++) {
                    establecerRegistro(obtenerLista().get(i));
                    establecerSalida();
                }
            }
        } //Fin de try
        catch (IOException ioException) {
            System.err.println("Error al abrir el archivo." + ioException);
        } //Fin de catch
    }

    public void establecerNombreArchivo(String n) {
        nombreArchivo = n;
    }

    //Agrega registros al archivo
    public void establecerRegistro(PlanCelular p) {
        registro = p;
    }

    public void establecerSalida() {
        try {
            salida.writeObject(registro); //Envía el registro como salida
        } catch (IOException ex) {
            System.err.println("Error al escribir en el archivo.");
            System.err.println(ex);
        }
    }

    // En el atributo listaPlanes obtenemos los registros del archivo
    public void establecerLista() {
        LecturaArchivoSecuencial l
                = new LecturaArchivoSecuencial(obtenerNombreArchivo());
        l.establecerListaPlanes();
        lista = l.obtenerListaPlanes();
    }

    public String obtenerNombreArchivo() {
        return nombreArchivo;
    }

    public ArrayList<PlanCelular> obtenerLista() {
        return lista;
    }

    public ObjectOutputStream obtenerSalida() {
        return salida;
    }

    //Obtener registros al archivo
    public PlanCelular obtenerRegistro() {
        // System.out.println(p);
        return registro;
    }

    public void cerrarArchivo() {
        try { //Cierra el archivo
            if (salida != null) {
                salida.close();
            }
        } //Fin de try
        catch (IOException ioException) {
            System.err.println("Error al cerrar el archivo.");
        } //Fin de catch
    }
}
