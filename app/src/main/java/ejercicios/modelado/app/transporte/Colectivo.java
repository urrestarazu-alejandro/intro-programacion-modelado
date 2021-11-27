package ejercicios.modelado.app.transporte;

import java.security.InvalidParameterException;
import java.util.ArrayList;

public class Colectivo {
    private int cantMaxPasajeros;
    private Chofer chofer;
    private ArrayList<Pasajero> pasajeros;
    private TipoColectivo tipo;

    public Colectivo(int cantMaxPasajeros, Chofer c) {
        if (c == null) {
            throw new IllegalArgumentException("El chofer del colectivo no puede ser nulo");
            //throw new InvalidParameterException("");
        }

        if (c.getNombre() == null || c.getNombre() == "") {
            throw new IllegalArgumentException("El chofer del colectivo debe tener un nombre");
        }

        if (cantMaxPasajeros <= 0) {
            throw new IllegalArgumentException("La cantidad maxima de pasajeros no debe ser ni cero  ni negativa");
        }

        this.cantMaxPasajeros = cantMaxPasajeros;
        this.chofer = c;
        this.pasajeros = new ArrayList<>(); // sin pasajeros
        this.tipo = TipoColectivo.TRADICIONAL;
    }

    public Colectivo(int cantMaxPasajeros) {
        this.cantMaxPasajeros = cantMaxPasajeros;
        this.chofer = chofer;
        this.pasajeros = new ArrayList<>(); // sin pasajeros
        this.tipo = TipoColectivo.AUTONOMO;
    }

    public void subir(Pasajero p) {
        if (pasajeros.size() < cantMaxPasajeros) {
            pasajeros.add(p);
        }
    }

    public void arrancar() throws ColectivoException {
        if (pasajeros.size() < cantMaxPasajeros) {
            throw new ColectivoException("No podemos salir hasta que tengamos 5 o más pasajeros");
        }

        System.out.println("Arrancamos...");
    }

    /*
        public void subir(ArrayList<Pasajero> fila) {
            if (pasajeros.size() + fila.size() < cantMaxPasajeros) {
                pasajeros.addAll(fila);
            }
        }
    */
    public void llegarDestino(Destino descender) {
        pasajeros.removeIf(pasajero -> pasajero.getPasaje().getDestino().equals(descender));
    }
}
