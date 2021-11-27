package ejercicios.modelado.app.tareas;

public class Tarea {
    private String decripcion;
    private Estado estado;

    public String getDecripcion() {
        return decripcion;
    }

    public Estado getEstado() {
        return estado;
    }

    public Tarea(String decripcion) {
        this.decripcion = decripcion;
        this.estado = Estado.PENDIENTE; // valor por defecto
    }

    public void completar() {
        this.estado = Estado.COMPLETADA;
    }
}
