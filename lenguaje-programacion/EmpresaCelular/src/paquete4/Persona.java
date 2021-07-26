package paquete4;

import java.io.Serializable;

//Clase Persona que implementa Serializable
public class Persona implements Serializable {

    //Atributos de la persona
    private String nombre;
    private String apellidos;
    private String identificacion;

    //Constructor
    public Persona(String nomb, String ape, String ident) {
        nombre = nomb;
        apellidos = ape;
        identificacion = ident;
    }

    //Metodos establecer(set)
    public void establecerNombre(String nomb) {
        nombre = nomb;
    }

    public void establecerApellidos(String ape) {
        apellidos = ape;
    }

    public void establecerIdentificacion(String ident) {
        identificacion = ident;
    }

    //Metodos obtener(get)
    public String obtenerNombre() {
        return nombre;
    }

    public String obtenerApellidos() {
        return apellidos;
    }

    public String obtenerIdentificacion() {
        return identificacion;
    }
}
