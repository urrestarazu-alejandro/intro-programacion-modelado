package ejercicios.modelado.app.excepciones;

public class AritmeticaFallida extends Exception {

    public AritmeticaFallida() {
        super();
        System.out.println("Estoy mal para los numeros.");
    }
}
