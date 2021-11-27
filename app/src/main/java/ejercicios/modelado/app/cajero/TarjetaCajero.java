package ejercicios.modelado.app.cajero;

public class TarjetaCajero {
    public TarjetaCajero(int codigoSeguridad) {
        this.codigoSeguridad = codigoSeguridad;
        this.bloqueada = false;
    }

    public int getCodigoSeguridad() {
        return codigoSeguridad;
    }

    public void setCodigoSeguridad(int codigoSeguridad) {
        this.codigoSeguridad = codigoSeguridad;
    }

    public boolean isBloqueada() {
        return bloqueada;
    }

    public void setBloqueada(boolean bloqueada) {
        this.bloqueada = bloqueada;
    }

    private int codigoSeguridad;
    private boolean bloqueada = false;
}
