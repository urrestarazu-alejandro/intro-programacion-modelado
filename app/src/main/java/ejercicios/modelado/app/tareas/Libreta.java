package ejercicios.modelado.app.tareas;

import java.util.ArrayList;

public class Libreta implements AccionesLibretaTareas {
    ArrayList<Tarea> tareas;

    public Libreta() {
        this.tareas = new ArrayList<>();
    }

    @Override
    public void agregar(String descripcion) {
        Tarea t = new Tarea(descripcion);

        this.tareas.add(t);
    }

    @Override
    public void completar(int i) {
        if (i >= 0 && i < tareas.size()) {
            Tarea t = tareas.get(i);
            t.completar();
        }
    }

    @Override
    public boolean fueCompletada(int i) {
        return false;
    }

    @Override
    public void obtenerInfo(int i) {
        if (i >= 0 && i < tareas.size()) {
            Tarea t = tareas.get(i);

            if (t.getEstado().equals(Estado.PENDIENTE)) {
                System.out.println("la tarea > " + t.getDecripcion() + " esta pendiente.");
            } else if (t.getEstado().equals(Estado.COMPLETADA)) {
                System.out.println("la tarea > " + t.getDecripcion() + " fue compleatada.");
            }

        } else {
            System.out.println("No se encontró ninguna tarea con ese indice.");
        }
    }

    public void mostrar() {
        for (int i = 0; i < tareas.size(); i++) {
            //String text = String.format("(%s) %s", i,tareas.get(i).getDecripcion());
            System.out.println("( " + i + " ) " + tareas.get(i).getDecripcion() + " [ " + tareas.get(i).getEstado() + " ] ");
        }
    }

    public boolean todasFueronCompletadas() {
        boolean fueronCompletadas = true;
        for (Tarea t : tareas) {
            if (t.getEstado() == Estado.PENDIENTE) {
                fueronCompletadas = false;
            }
        }

        return fueronCompletadas;
    }

    public boolean tieneTareasCargadas() {
        return !tareas.isEmpty();
    }
}
