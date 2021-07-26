package paquete2;

import paquete4.Persona;

//Clase PlanPostPagoMegas que se deriva de PlanCelular
public class PlanPostPagoMegas extends PlanCelular {

    //Atributos de su clase
    private double gigas;
    private double costo_gigas;
    private double tarifa_base;

    //Constructor con parametros propios y los de la clase padre
    public PlanPostPagoMegas(Persona per, String ciud, String marc,
            String model, String num, double gb, double costogb, double tarifa) {
        super(per, ciud, marc, model, num);//Atributos de la clase padre
        //Asignacion de valores a los atributos de esta clase
        gigas = gb;
        costo_gigas = costogb;
        tarifa_base = tarifa;
    }

    //Metodos establecer(set)
    public void establecerGigas(double gb) {
        gigas = gb;
    }

    public void establecerCosto_gigas(double costogb) {
        costo_gigas = costogb;
    }

    public void establecerTarifa_base(double tarifa) {
        tarifa_base = tarifa;
    }

    //Metodos obtener(get)
    public double obtenerGigas() {
        return gigas;
    }

    public double obtenerCosto_gigas() {
        return costo_gigas;
    }

    public double obtenerTarifa_base() {
        return tarifa_base;
    }

    //Metodo para calcular el valor de la mensualidad
    @Override
    public void CalcularMensualidad() {
        pagoMensual = (gigas * costo_gigas) + tarifa_base;
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
                + "Gigas: %.1f\n"
                + "Costo por giga: $ %.2f\n"
                + "Tarifa base: $ %.2f\n"
                + "Pago mensual: $ %.2f\n",
                obtenerPersona().obtenerNombre(),
                obtenerPersona().obtenerApellidos(),
                obtenerPersona().obtenerIdentificacion(),
                obtenerCiudad(),
                obtenerMarca(),
                obtenerModelo(),
                obtenerNumero(),
                obtenerGigas(),
                obtenerCosto_gigas(),
                obtenerTarifa_base(),
                obtenerPagoMensual());
        return cadena;
    }
}
