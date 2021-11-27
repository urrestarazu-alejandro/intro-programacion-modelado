package ejercicios.modelado.app.cajero;

enum Saludos {
    HOLA("Hola mundo", 10),
    CHAU("Chau Mundo", 20);

    private String saludo;
    private int numero;

    public String getSaludo() {
        return saludo;
    }

    Saludos(String saludoInicial, int numero) {
        this.saludo = saludoInicial;
        this.numero = numero;
    }
}

public enum Billete {
    CIEN_EVA(100),
    CIEN_ROCA(100),
    QUINIENTOS(500),
    MIL(1000);

    private int valorNumerico;

    Billete(int valor) {
        this.valorNumerico = valor;
    }

    public int getValorNumerico() {
        return valorNumerico;
    }
}
