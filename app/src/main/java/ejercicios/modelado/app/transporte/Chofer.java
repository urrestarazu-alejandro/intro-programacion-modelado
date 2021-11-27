package ejercicios.modelado.app.transporte;

import java.security.InvalidParameterException;

public class Chofer extends Persona {
    private String licencia;

    public Chofer(int dni, String nombre, String licencia) {
        super(dni, nombre);

        if (nombre == null || nombre == "") {
            throw new IllegalArgumentException("No se debe crear un chofer sin nombre");
        }

        if (licencia == null || licencia == "") {
            throw new IllegalArgumentException("No se pude crear un chofer sin licencia de conducir");
        }

        this.licencia = licencia;

    }
}
