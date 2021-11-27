package ejercicios.modelado.app.transporte;

public abstract class Persona {
    public int getDni() {
        return dni;
    }

    public String getNombre() {
        return nombre;
    }

    private int dni;
    private String nombre;

    public Persona(int dni, String nombre) {
        this.dni = dni;
        this.nombre = nombre;
    }
}
