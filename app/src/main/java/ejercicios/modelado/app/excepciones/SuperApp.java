package ejercicios.modelado.app.excepciones;

import java.util.List;

public class SuperApp {

    public int division(int a, int b) throws AritmeticaFallida {
        // falla conocida
        if (b == 0 && a != 0) {
            throw new AritmeticaFallida();
        }

        try {
            return a / b;

        } catch (Exception e) {
            throw new AritmeticaFallida();
        }
    }

    public void saludar(List<String> nombres, int indice) throws SuperAppException {
        try {
            System.out.println("Hola " + nombres.get(indice));

        } catch (Exception exc) {
            throw new SuperAppException("No pude saludar.", exc);
        }
    }







    /*public void saludar(List<String> nombres, int indice) throws SuperAppException {
        try {
            System.out.println("Hola " + nombres.get(indice));
        } catch (IndexOutOfBoundsException exc) {
            throw new SuperAppException("error");
        }
    }*/
}
