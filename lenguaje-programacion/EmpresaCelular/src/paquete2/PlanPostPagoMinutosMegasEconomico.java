package paquete2;

import paquete4.Persona;

//Clase PlanPostPagoMinutosMegasEconomicos que se deriva de PlanCelular
public class PlanPostPagoMinutosMegasEconomico extends PlanCelular {

    //Atributos de su clase
    private double minutos;
    private double costo_minutos;
    private double gigas;
    private double costo_gigas;
    private double porc_descuento;
    private double descuento;

    //Constructor con parametros propios y los de la clase padre
    public PlanPostPagoMinutosMegasEconomico(Persona per, String ciud,
            String marc, String model, String num, double min, double costo_min,
            double gb, double costo_gb, double porc_desc) {
        super(per, ciud, marc, model, num);//Atributos de la clase padre
        //Asignacion de valores a los atributos de esta clase
        minutos = min;
        costo_minutos = costo_min;
        gigas = gb;
        costo_gigas = costo_gb;
        porc_descuento = porc_desc;
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

    public void establecerPorc_descuento(double porc_desc) {
        porc_descuento = porc_desc;
    }

    //Metodo descuento para obtener el valor a descontar
    public void establecerDescuento() {
        descuento = pagoMensual * (porc_descuento / 100);
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

    public double obtenerPorc_descuento() {
        return porc_descuento;
    }

    public double obtenerDescuento() {
        return descuento;
    }

    //Metodo para calcular el valor de la mensualidad
    @Override
    public void CalcularMensualidad() {
        pagoMensual = (minutos * costo_minutos) + (gigas * costo_gigas)
                - descuento;
    }

    //Metodo toString para presentar en pantalla todos los atributos de esta clase
    @Override
    public String toString() {
        String cadena = String.format(""
                + "Nombre: %s\n"
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
                + "Descuento: (%.1f%s) $ %.2f\n"
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
                obtenerPorc_descuento(), "%",
                obtenerDescuento(),
                obtenerPagoMensual() - obtenerDescuento());
        return cadena;
    }
}
