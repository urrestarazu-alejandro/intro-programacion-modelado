package ejercicios.modelado.app.starbucks;

public interface AccionesCafetera {
    /**
     * Metodo que realiza la accion de preparar una taza de cafe
     * @param tostado tipo de tostado para el grano de cafe
     * @param preparacion que metodo de preparación debe tener
     * @return una taza de cafe
     */
    TazaCafe preparar(Tostado tostado, Preparacion preparacion);
}
