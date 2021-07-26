package paquete2;

import paquete4.Persona;

//Clase PlanPostPagoMinutos que se deriva de PlanCelular
public class PlanPostPagoMinutos extends PlanCelular {

    //Atributos de su clase
    private double minutos_nac;
    private double costo_min_nac;
    private double minutos_internac;
    private double costo_min_internac;

    //Constructor con parametros propios y los de la clase padre
    public PlanPostPagoMinutos(Persona per,String ciud, String marc, 
            String model, String num, double min_nac, double cost_min_nac,
            double min_internac, double cost_min_inter) {
        super(per, ciud, marc, model, num);//Atributos de la clase padre
        //Asignacion de valores a los atributos de esta clase
        minutos_nac = min_nac;
        costo_min_nac = cost_min_nac;
        minutos_internac = min_internac;
        costo_min_internac = cost_min_inter;
    }

    //Metodos establecer(set)
    public void establecerMinutos_nac(double min_nac) {
        minutos_nac = min_nac;
    }

    public void establecerCosto_min_nac(double cost_min_nac) {
        costo_min_nac = cost_min_nac;
    }

    public void establecerMinutos_internac(double min_inter) {
        minutos_internac = min_inter;
    }

    public void establecerCosto_min_internac(double cost_min_inter) {
        costo_min_internac = cost_min_inter;
    }

    //Metodos obtener (get)
    public double obtenerMinutos_nac() {
        return minutos_nac;
    }

    public double obtenerCosto_min_nac() {
        return costo_min_nac;
    }

    public double obtenerMinutos_internac() {
        return minutos_internac;
    }

    public double obtenerCosto_min_internac() {
        return costo_min_internac;
    }

    //Metodo para calcular el valor de la mensualidad
    @Override
    public void CalcularMensualidad() {
        pagoMensual = (minutos_nac * costo_min_nac)
                + (minutos_internac * costo_min_internac);
    }

    //Metodo toString para presentar en pantalla todos los atributos de esta clase
    @Override
    public String toString() {
        String cadena = String.format(""
                + "Nombres: %s\n"
                + "Apellidos: %s\n"
                + "Cedula: %s\n"
                + "Ciudad: %s\n"
                + "Marca: %s\n"
                + "Modelo: %s\n"
                + "Numero: %s\n"
                + "Minutos nacionales: %.1f\n"
                + "Costo por minuto nacional: $ %.2f\n"
                + "Minutos internacionales: %.1f\n"
                + "Costo por minuto internacional: $ %.2f\n"
                + "Pago mensual: $ %.2f\n",
                obtenerPersona().obtenerNombre(),
                obtenerPersona().obtenerApellidos(),
                obtenerPersona().obtenerIdentificacion(),
                obtenerCiudad(),
                obtenerMarca(),
                obtenerModelo(),
                obtenerNumero(),
                obtenerMinutos_nac(),
                obtenerCosto_min_nac(),
                obtenerMinutos_internac(),
                obtenerCosto_min_internac(),
                obtenerPagoMensual());
        return cadena;
    }
}
