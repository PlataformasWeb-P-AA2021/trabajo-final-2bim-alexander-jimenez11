package paquete2;

import paquete4.Persona;

//Clase PlanPostPagoMinutosMegas que se deriva de PlanCelular
public class PlanPostPagoMinutosMegas extends PlanCelular {

    //Atributos de su clase
    private double minutos;
    private double costo_minutos;
    private double gigas;
    private double costo_gigas;

    //Constructor con los atributos que hereda de la clase padre
    public PlanPostPagoMinutosMegas(Persona per, String ciud, String marc,
            String model, String num, double min, double costo_min, double gb,
            double costo_gb) {
        super(per, ciud, marc, model, num);//Atributos de la clase padre
        //Asignacion de valores a los atributos de esta clase
        minutos = min;
        costo_minutos = costo_min;
        gigas = gb;
        costo_gigas = costo_gb;
    }

    //Metodos establecer(set)
    public void establecerMinutos(double min) {
        minutos = min;
    }

    public void establecerCosto_minutos(double costo_min) {
        costo_minutos = costo_min;
    }

    public void establecerGigas(double gb) {
        gigas = gb;
    }

    public void establecerCosto_gigas(double costo_gb) {
        costo_gigas = costo_gb;
    }

    //Metodos obtener(get)
    public double obtenerMinutos() {
        return minutos;
    }

    public double obtenerCosto_minutos() {
        return costo_minutos;
    }

    public double obtenerGigas() {
        return gigas;
    }

    public double obtenerCosto_gigas() {
        return costo_gigas;
    }

    //Metodo para calcular el valor de la mensualidad
    @Override
    public void CalcularMensualidad() {
        pagoMensual = (minutos * costo_minutos) + (gigas * costo_gigas);
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
                + "Minutos: %.1f\n"
                + "Costo por minuto: $ %.2f\n"
                + "Gigas: %.1f\n"
                + "Costo por giga: $ %.2f\n"
                + "Pago mensual: $ %.2f\n",
                obtenerPersona().obtenerNombre(),
                obtenerPersona().obtenerApellidos(),
                obtenerPersona().obtenerIdentificacion(),
                obtenerCiudad(),
                obtenerMarca(),
                obtenerModelo(),
                obtenerNumero(),
                obtenerMinutos(),
                obtenerCosto_minutos(),
                obtenerGigas(),
                obtenerCosto_gigas(),
                obtenerPagoMensual());
        return cadena;
    }
}
