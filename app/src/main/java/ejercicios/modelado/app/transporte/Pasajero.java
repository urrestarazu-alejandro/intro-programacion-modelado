package ejercicios.modelado.app.transporte;

public class Pasajero extends Persona {
    private Pasaje pasaje;

    public Pasajero(int dni, String nombre, Pasaje pasaje) {
        super(dni, nombre);
        this.pasaje = pasaje;
    }

    public Pasaje getPasaje() {
        return this.pasaje;
    }
}
