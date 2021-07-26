package paquete2;

import java.io.Serializable;
import paquete4.Persona;

//Clase abastracta PlanCelular que implementa Serializable
public abstract class PlanCelular implements Serializable{
    
    //Atributos
    protected Persona persona;
    protected String ciudad;
    protected String marca;
    protected String modelo;
    protected String numero;
    protected double pagoMensual;
    
    //Constructor
    public PlanCelular(Persona per, String ciud, String marc, String model, 
            String num) {
        persona = per;
        ciudad = ciud;
        marca = marc;
        modelo = model;
        numero = num;
    }
    //Metodos establecer(set)
    public void establecerPersona(Persona per) {
        persona = per;
    }

    public void establecerCiudad(String ciud) {
        ciudad = ciud;
    }

    public void establecerMarca(String marc) {
        marca = marc;
    }

    public void establecerModelo(String model) {
        modelo = model;
    }

    public void establecerNumero(String num) {
        numero = num;
    }
    //Metodo abstracto para calcular la mensualidad (será modificado en clases hijas)
    public abstract void CalcularMensualidad();
    
    //Metodos obtener(get)
    public Persona obtenerPersona() {
        return persona;
    }

    public String obtenerCiudad() {
        return ciudad;
    }

    public String obtenerMarca() {
        return marca;
    }

    public String obtenerModelo() {
        return modelo;
    }

    public String obtenerNumero() {
        return numero;
    }

    public double obtenerPagoMensual() {
        return pagoMensual;
    }
    
    @Override
    public String toString(){
        return String.format("PlanCelular.");
    }
}
