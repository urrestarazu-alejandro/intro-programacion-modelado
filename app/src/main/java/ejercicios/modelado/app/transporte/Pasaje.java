package ejercicios.modelado.app.transporte;

public class Pasaje {
    private float costo;
    private Destino destino;

    public Pasaje(float costo, Destino destino) {
        this.costo = costo;
        this.destino = destino;
    }

    public float getCosto() {
        return costo;
    }

    public Destino getDestino() {
        return destino;
    }
}
