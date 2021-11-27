package ejercicios.modelado.app.tareas;

public interface AccionesLibretaTareas {
    /**
     * Agrega una tarea nueva
     *
     * @param descripcion descripción de la tarea
     */
    void agregar(String descripcion);

    /**
     * Completa una tarea pendiente
     * El indice debe ser menor que la cantidad de tareas agregadas
     *
     * @param i indice de la tarea
     */
    void completar(int i);

    /**
     * Indica si fue completada la tarea.
     * Si el índice está fuera del rango de los índices de las tareas debe devolver falso
     *
     * @param i índice de la tarea
     * @return verdadero si fue completada, falso si está pendiente
     */
    boolean fueCompletada(int i);

    /**
     * Muestra por pantalla la descripción de la tarea y si fue completada o no
     * por ejemplo:
     * Si el índice no es correcto muestra:
     * "No se encontró ninguna tarea con ese indice."
     *
     * @param i índice de la tarea
     */
    void obtenerInfo(int i);
}
