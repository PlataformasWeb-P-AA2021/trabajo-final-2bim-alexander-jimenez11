package paquete1;

import paquete2.*;
import paquete3.*;
import java.util.ArrayList;
import java.util.Scanner;
import paquete4.Persona;

public class Ejecutor {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int opc = 0;
        double minutos = 0, costo_min = 0, gigas = 0, costo_giga = 0, tarifa = 0,
                porcentaje = 0;
        String nomb, ape, ced, ciudad, marca, modelo, num, resp;
        ArrayList<PlanCelular> planes = new ArrayList<>(); //Lista de la clase PlanCelular
        String nombreArchivo = "planes.data"; //Nombre que tendrá el archivo data
        System.out.println("\t<< EMPRESA DE TELEFONIA CELULAR >>");
        System.out.println("\t=================================");
        while (opc != 5) { //Ciclo while que permite repetir el menu hasta que se decida salir 
            double minutos_inter = 0, costo_min_inter = 0;
            System.out.println("\n  *** MENÚ PLAN CELULAR ***");
            System.out.println("------------------------------");
            System.out.println("1. PLAN POST PAGO MINUTOS");
            System.out.println("2. PLAN POST PAGO MEGAS");
            System.out.println("3. PLAN POST PAGO MINUTOS MEGAS");
            System.out.println("4. PLAN POST PAGO MINUTOS MEGAS ECONÓMICO");
            System.out.println("5. SALIR");
            System.out.print("\nSELECCIONE UNA OPCIÓN: ");
            opc = sc.nextInt();
            sc.nextLine();
            switch (opc) { //En cada caso se piden los datos aparte de los que son de la clase padre, de acuerdo al plan seleccionado
                case 1:
                    //El plan post pago minutos pide minutos nacionales y su costo, minutos internacionales y su costo
                    System.out.println("\nPLAN POST PAGO MINUTOS");
                    System.out.println("¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯");
                    System.out.print("Nombres: ");
                    nomb = sc.nextLine();
                    System.out.print("Apellidos: ");
                    ape = sc.nextLine();
                    System.out.print("Cédula: ");
                    ced = sc.nextLine();
                    System.out.print("Ciudad: ");
                    ciudad = sc.nextLine();
                    System.out.print("Marca de celular: ");
                    marca = sc.nextLine();
                    System.out.print("Modelo de celular: ");
                    modelo = sc.nextLine();
                    System.out.print("Número de celular: ");
                    num = sc.nextLine();
                    System.out.print("Minutos nacionales: ");
                    minutos = sc.nextDouble();
                    while (minutos <= 0) {
                        System.out.println("MINUTOS NACIONALES INCORRECTOS!!");
                        System.out.print("Minutos nacionales: ");
                        minutos = sc.nextDouble();
                    }
                    System.out.print("Costo por minuto nacional: $ ");
                    costo_min = sc.nextDouble();
                    while (costo_min <= 0) {
                        System.out.println("COSTO MINUTO NACIONAL INCORRECTO!!");
                        System.out.print("Costo por minuto nacional: $ ");
                        costo_min = sc.nextDouble();
                    }
                    sc.nextLine();
                    System.out.print("DESEA MINUTOS INTERNACIONALES? S/N: ");
                    resp = sc.nextLine().toUpperCase();
                    while (!resp.equals("S") && !resp.equals("N")) {
                        System.out.print("DESEA MINUTOS INTERNACIONALES? S/N: ");
                        resp = sc.nextLine().toUpperCase();
                    }
                    if (resp.equals("S")) {
                        System.out.print("Minutos internacionales: ");
                        minutos_inter = sc.nextDouble();
                        while (minutos_inter <= 0) {
                            System.out.println("MINUTOS INTERNACIONALES INCORRECTOS!!");
                            System.out.print("Minutos internacionales: ");
                            minutos_inter = sc.nextDouble();
                        }
                        System.out.print("Costo por minuto internacional: $ ");
                        costo_min_inter = sc.nextDouble();
                        while (costo_min_inter <= 0) {
                            System.out.println("COSTO MINUTOS INTERNACIONALES INCORRECTOS!!");
                            System.out.print("Costo por minuto internacional: $ ");
                            costo_min_inter = sc.nextDouble();
                        }
                    }
                    //Se crea un objeto de persona se le pasa los parametros respectivos
                    Persona p1 = new Persona(nomb, ape, ced);
                    //Se crea un objeto de la clase PlanPagoMinutos
                    PlanPostPagoMinutos plan1 = new PlanPostPagoMinutos(p1,
                            ciudad, marca, modelo, num, minutos, costo_min,
                            minutos_inter, costo_min_inter);
                    plan1.CalcularMensualidad();//Se invoca el metodo calcular
                    planes.add(plan1);//Se añade el plan a la lista de planes
                    break;
                case 2:
                    //El plan post pago megas pide megas y su costo, y tarifa base
                    System.out.println("\nPLAN POST PAGO MEGAS");
                    System.out.println("¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯");
                    System.out.print("Nombres: ");
                    nomb = sc.nextLine();
                    System.out.print("Apellidos: ");
                    ape = sc.nextLine();
                    System.out.print("Cédula: ");
                    ced = sc.nextLine();
                    System.out.print("Ciudad: ");
                    ciudad = sc.nextLine();
                    System.out.print("Marca de celular: ");
                    marca = sc.nextLine();
                    System.out.print("Modelo de celular: ");
                    modelo = sc.nextLine();
                    System.out.print("Número de celular: ");
                    num = sc.nextLine();
                    System.out.print("Gigas: ");
                    gigas = sc.nextDouble();
                    while (gigas <= 0) {
                        System.out.println("GIGAS INCORRECTAS!!");
                        System.out.print("Gigas: ");
                        gigas = sc.nextDouble();
                    }
                    System.out.print("Costo por cada giga: $ ");
                    costo_giga = sc.nextDouble();
                    while (costo_giga <= 0) {
                        System.out.println("COSTO DE GIGAS INCORRECTOS!!");
                        System.out.print("Costo por cada giga: $ ");
                        costo_giga = sc.nextDouble();
                    }
                    System.out.print("Tarifa base: $ ");
                    tarifa = sc.nextDouble();
                    while (tarifa <= 0) {
                        System.out.println("TARIFA BASE INCORRECTA!!");
                        System.out.print("Tarifa base: $ ");
                        tarifa = sc.nextDouble();
                    }
                    //Se crea un objeto de persona se le pasa los parametros respectivos
                    Persona p2 = new Persona(nomb, ape, ced);
                    PlanPostPagoMegas plan2 = new PlanPostPagoMegas(p2, ciudad,
                            marca, modelo, num, gigas, costo_giga, tarifa);
                    plan2.CalcularMensualidad(); //Se calcula la mensualidad
                    planes.add(plan2); //Se añade el plan a la lista de planes
                    break;
                case 3:
                    //El plan post pago minutos megas pide minutos y su costo, megas y su costo
                    System.out.println("\nPLAN POST PAGO MINUTOS MEGAS");
                    System.out.println("¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯");
                    System.out.print("Nombres: ");
                    nomb = sc.nextLine();
                    System.out.print("Apellidos: ");
                    ape = sc.nextLine();
                    System.out.print("Cédula: ");
                    ced = sc.nextLine();
                    System.out.print("Ciudad: ");
                    ciudad = sc.nextLine();
                    System.out.print("Marca de celular: ");
                    marca = sc.nextLine();
                    System.out.print("Modelo de celular: ");
                    modelo = sc.nextLine();
                    System.out.print("Número de celular: ");
                    num = sc.nextLine();
                    System.out.print("Minutos: ");
                    minutos = sc.nextDouble();
                    while (minutos <= 0) {
                        System.out.println("MINUTOS INCORRECTOS!!");
                        System.out.print("Minutos: ");
                        minutos = sc.nextDouble();
                    }
                    System.out.print("Costo por minuto: $ ");
                    costo_min = sc.nextDouble();
                    while (costo_min <= 0) {
                        System.out.println("COSTO DE MINUTOS INCORRECTOS!!");
                        System.out.print("Costo por minuto: $ ");
                        costo_min = sc.nextDouble();
                    }
                    System.out.print("Gigas: ");
                    gigas = sc.nextDouble();
                    while (gigas <= 0) {
                        System.out.println("GIGAS INCORRECTAS!!");
                        System.out.print("Gigas: ");
                        gigas = sc.nextDouble();
                    }
                    System.out.print("Costo por cada giga: $ ");
                    costo_giga = sc.nextDouble();
                    while (costo_giga <= 0) {
                        System.out.println("COSTO DE GIGAS INCORRECTO!!");
                        System.out.print("Costo por cada giga: $ ");
                        costo_giga = sc.nextDouble();
                    }
                    //Se crea un objeto de la clase persona
                    Persona p3 = new Persona(nomb, ape, ced);
                    //Se crea un objeto de la clase PlanesPostPagoMinutosMegas
                    PlanPostPagoMinutosMegas plan3
                            = new PlanPostPagoMinutosMegas(p3, ciudad, marca,
                                    modelo, num, minutos, costo_min,
                                    gigas, costo_giga);
                    plan3.CalcularMensualidad(); //Se calcula la mensualidad
                    planes.add(plan3); //Se añade el plan a la lista de planes
                    break;
                case 4:
                    //El plan post pago minutos megas economicos pide minutos y su costo, megas y su costo y un porcentaje de descuento
                    System.out.println("\nPLAN POST PAGO MINUTOS MEGAS ECONÓMICO");
                    System.out.println("¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯");
                    System.out.print("Nombres: ");
                    nomb = sc.nextLine();
                    System.out.print("Apellidos: ");
                    ape = sc.nextLine();
                    System.out.print("Cédula: ");
                    ced = sc.nextLine();
                    System.out.print("Ciudad: ");
                    ciudad = sc.nextLine();
                    System.out.print("Marca de celular: ");
                    marca = sc.nextLine();
                    System.out.print("Modelo de celular: ");
                    modelo = sc.nextLine();
                    System.out.print("Número de celular: ");
                    num = sc.nextLine();
                    System.out.print("Minutos: ");
                    minutos = sc.nextDouble();
                    while (minutos <= 0) {
                        System.out.println("MINUTOS INCORRECTOS!!");
                        System.out.print("Minutos: ");
                        minutos = sc.nextDouble();
                    }
                    System.out.print("Costo por minuto: $ ");
                    costo_min = sc.nextDouble();
                    while (costo_min <= 0) {
                        System.out.println("COSTO MINUTOS INCORRECTO!!");
                        System.out.print("Costo por minuto: $ ");
                        costo_min = sc.nextDouble();
                    }
                    System.out.print("Gigas: ");
                    gigas = sc.nextDouble();
                    while (gigas <= 0) {
                        System.out.println("GIGAS INCORRECTAS!!");
                        System.out.print("Gigas: ");
                        gigas = sc.nextDouble();
                    }
                    System.out.print("Costo por cada giga: $ ");
                    costo_giga = sc.nextDouble();
                    while (costo_giga <= 0) {
                        System.out.println("COSTO DE GIGAS INCORRECTAS!!");
                        System.out.print("Costo por cada giga: $ ");
                        costo_giga = sc.nextDouble();
                    }
                    System.out.print("Porcentaje de descuento: ");
                    porcentaje = sc.nextDouble();
                    while (porcentaje <= 0) {
                        System.out.println("PORCENTAJE INCORRECTO!!");
                        System.out.print("Porcentaje de descuento: ");
                        porcentaje = sc.nextDouble();
                    }
                    //Se crea un objeto de la clase persona
                    Persona p4 = new Persona(nomb, ape, ced);
                    //Se crea un objeto de la clase PlanPostPagoMinutosMegasEconomico
                    PlanPostPagoMinutosMegasEconomico plan4
                            = new PlanPostPagoMinutosMegasEconomico(p4, ciudad, 
                                    marca, modelo, num, minutos,costo_min, 
                                    gigas, costo_giga, porcentaje);
                    plan4.CalcularMensualidad(); //Se calcula la mensualidad
                    plan4.establecerDescuento(); //se calcula el valor del descuento
                    planes.add(plan4); //se añade el plna a la lista de planes
                    break;
                case 5: //cuando se selecciona salir, se crear el archivo secuencial y se lo lee
                    if (planes.size() == 0) {
                        System.out.println("NO HAY PLANES REGISTRADOS!!");
                    } else {
                        EscrituraArchivoSecuencial archivo
                                = new EscrituraArchivoSecuencial(nombreArchivo);
                        for (int i = 0; i < planes.size(); i++) {
                            //Establecer el valor del atributo registro
                            archivo.establecerRegistro(planes.get(i));
                            //Establecer en el archivo el atributo del registro
                            archivo.establecerSalida();
                        }
                        archivo.cerrarArchivo();
                        LecturaArchivoSecuencial lectura
                                = new LecturaArchivoSecuencial(nombreArchivo);
                        lectura.establecerListaPlanes();
                        System.out.println(lectura);
                        lectura.cerrarArchivo();
                    }
                    break;
                default://si la opcion no es una de las del menu muestra este mensaje
                    System.out.println("OPCIÓN SELECCIONADA ES INCORRECTA!!");
                    break;
            }
        }
    }
}
