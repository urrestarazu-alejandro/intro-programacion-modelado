package ejercicios.modelado.app;

import ejercicios.modelado.app.cajero.Billete;
import ejercicios.modelado.app.cajero.Cajero;
import ejercicios.modelado.app.cajero.CajeroException;
import ejercicios.modelado.app.cajero.CajeroSolucionado;
import ejercicios.modelado.app.cajero.TarjetaCajero;
import ejercicios.modelado.app.excepciones.SuperApp;
import ejercicios.modelado.app.starbucks.Preparacion;
import ejercicios.modelado.app.starbucks.Starbucks;
import ejercicios.modelado.app.starbucks.TazaCafe;
import ejercicios.modelado.app.starbucks.Tostado;
import ejercicios.modelado.app.tareas.Libreta;
import ejercicios.modelado.app.transporte.Chofer;
import ejercicios.modelado.app.transporte.Colectivo;
import ejercicios.modelado.app.transporte.ColectivoException;
import ejercicios.modelado.app.transporte.Destino;
import ejercicios.modelado.app.transporte.Pasaje;
import ejercicios.modelado.app.transporte.Pasajero;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        System.out.println("\n----\tInicio de la aplicación\t----\n");

        Cajero bancor = new Cajero();

        HashMap<Billete, Integer> bolsa1 = new HashMap<>();
        bolsa1.put(Billete.CIEN_EVA, 2);
        bolsa1.put(Billete.MIL, 100);

        try {
            bancor.setCerroElcajero(true);
            bancor.cargarDinero(bolsa1);

            int montoARetirar = 1200;
            TarjetaCajero tarjetaCajero = new TarjetaCajero(1234);

            boolean contraseniValida = bancor.validarSeguridad(1111, tarjetaCajero);

            if (!contraseniValida) {
                System.out.println("La contraseña ingresada no es valida.");
            }

            bancor.validarSeguridad(999, tarjetaCajero);
            bancor.validarSeguridad(8888, tarjetaCajero);

            HashMap<Billete, Integer> disponible = bancor.calcularDisponible(montoARetirar);
        } catch (CajeroException cajeroException) {
            System.out.println(cajeroException.getMessage());
        }


        System.out.println(bancor);

        //problemaCajero();
        //modeladoColectivo();
        //modelandoCafetera();
        //claseExcepciones();
        //menuLibretaTareas();

        System.out.println("\n----\tFin de la aplicación\t----");
    }

    private static void problemaCajero() {
        CajeroSolucionado cajeroSolucionado = new CajeroSolucionado();
        HashMap<Billete, Integer> carga = new HashMap<>();
        carga.put(Billete.CIEN_EVA, 1);
        carga.put(Billete.CIEN_ROCA, 1);
        carga.put(Billete.QUINIENTOS, 10);
        carga.put(Billete.MIL, 2);

        cajeroSolucionado.cargarDinero(carga);
        int monto = 200;
        HashMap<Billete, Integer> disponible = cajeroSolucionado.calcularDisponible(monto);
        int disponibleEntrega = cajeroSolucionado.contarBilletes(disponible);

        if (disponibleEntrega == monto) {
            HashMap<Billete, Integer> entrega = cajeroSolucionado.entregar(disponible);

            System.out.println("> Entregando:" + entrega.toString());
        }

        System.out.println("****\n" + cajeroSolucionado.toString());
    }

    private static void claseExcepciones() {
        SuperApp superApp = new SuperApp();
        //int divi = superApp.division(10,2);

        List<String> nombres;

        nombres = new ArrayList<>();
        nombres.add("Juan");
        nombres.add("Ana");
        //nombres = null;

        try {
            superApp.saludar(nombres, 0);

            int division = superApp.division(100, 0);
        } catch (Exception a) {
            System.out.println("Ocurrio un error aritmetico en la APP");
        }
    }

    private static void modelandoCafetera() {
        HashMap<Tostado, Integer> insumos = new HashMap<>();
        insumos.put(Tostado.COLOMBIA, 100);
        insumos.put(Tostado.KENYA, 10);
        insumos.put(Tostado.SUMATRA, 10);
        insumos.put(Tostado.VERONA, 200);

        Starbucks cafetera = new Starbucks(insumos);
        //Starbucks cafetera = new Starbucks(null);

        cafetera.mostrarInsumos();

        TazaCafe taza = cafetera.preparar(Tostado.VERONA, Preparacion.CAFETERA);
        //TazaCafe taza = cafetera.preparar(Tostado.VERONA, Preparacion.ESPRESSO);
        System.out.println("Preparamos: " + taza);
    }

    private static void modeladoColectivo() {
        Chofer chofer = new Chofer(25000000, "", "AB1234567");
        //Chofer chofer = new Chofer(25000000, "Juan Perez", null);
        //Chofer chofer = new Chofer(25000000, "Juan Perez", "AB1234567");
        //Chofer chofera = new Chofer(25000001, "Ana Maria", "AB000001");

        //Colectivo bondi = new Colectivo(1, chofer);
        Colectivo bondi = new Colectivo(30, chofer);

        //Pasaje centro = new Pasaje(0f, null);
        Pasaje centro = new Pasaje(50.99f, Destino.CENTRO);
        //Pasajero pepe = new Pasajero(3000000, "Pepe argento", null);
        Pasajero pepe = new Pasajero(3000000, "Pepe argento", centro);

        bondi.subir(pepe);
        //bondi.subir(null);

        Pasajero ana = new Pasajero(35000123, "Ana Perez", centro);
        bondi.subir(ana);

        boolean arranco = false;

        while (!arranco) {
            try {
                bondi.arrancar();
                arranco = true;
            } catch (ColectivoException exc) {
                System.out.println("Vamos a esperar un poco");
                bondi.subir(new Pasajero(35000123, "Ana Perez", centro));
            }
        }

        bondi.llegarDestino(Destino.CENTRO);
        //bondi.llegarDestino(null);
    }

    private static void menuLibretaTareas() {
        char salir = 's';
        char agregar = 'a';
        char mostrar = 'm';
        char completar = 'c';
        char informacion = 'i';
        char opcion = '-';

        Libreta libretita = new Libreta();

        while (opcion != salir) {
            if (libretita.tieneTareasCargadas() && libretita.todasFueronCompletadas()) {
                break;
            }

            System.out.println("*** Libreta de tareas  *** ----------  Acciones:");
            System.out.println("\t para salir presione 's'");
            System.out.println("\t para AGREGAR una tarea presione la tecla 'a'");
            System.out.println("\t para COMPLETAR una tarea presione la tecla 'c'");
            System.out.println("\t para obtener informacion de una tarea presione 'i'");
            System.out.println("\t para mostrar las tareas presione 'm'");


            System.out.print("> Ingrese una accion: ");
            Scanner scanner = new Scanner(System.in);
            opcion = scanner.next().charAt(0);

            if (opcion == mostrar) {
                //mostrar lista de Tareas
                libretita.mostrar();

            } else if (opcion == agregar) {
                System.out.println("Ingrese una descripcion para la nueva tarea:");

                try {
                    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
                    String desc = reader.readLine();

                    //agregar tarea nueva
                    libretita.agregar(desc);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            } else if (opcion == completar) {
                System.out.print("Ingrese la posicion de la tarea que desea completar: ");
                int posicion = scanner.nextInt();

                //completar tarea
                libretita.completar(posicion);
            } else if (opcion == informacion) {
                System.out.print("Ingrese la posicion de la tarea que desea obtener información: ");
                int posicion = scanner.nextInt();

                // Obtener info de una tarea
                libretita.obtenerInfo(posicion);
            } else {
                System.out.println("Opcion incorrecta.. intente de nuevo");
            }

            System.out.println("\n\n");
        }

        if (libretita.tieneTareasCargadas() && libretita.todasFueronCompletadas()) {
            libretita.mostrar();
            System.out.println("Bien hecho, terminaste todas las tareas!! a descansar.");
        }

        System.out.println("Hasta luego!");
    }
}
