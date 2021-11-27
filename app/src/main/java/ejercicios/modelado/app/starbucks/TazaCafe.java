package ejercicios.modelado.app.starbucks;

public class TazaCafe {
    public Tostado getTostado() {
        return tostado;
    }

    public Preparacion getPreparacion() {
        return preparacion;
    }

    private Tostado tostado;
    private Preparacion preparacion;

    public TazaCafe(Tostado tostado, Preparacion preparacion) {
        this.tostado = tostado;
        this.preparacion = preparacion;
    }

    @Override
    public String toString() {
        return "Taza de Cafe con tostado " + tostado +
                ", preparada en " + preparacion + ".";
    }
}
