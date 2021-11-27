package ejercicios.modelado.app.excepciones;

public class SuperAppException extends Exception {

    public SuperAppException(String message) {
        super(message);

        System.out.println("[+] Ocurrio un error en la Superapp");
        // guardo los errores
        System.out.println("[+] Guardamos el error: " + message);
    }

    public SuperAppException(String message, Exception cause) {
        super(message, cause);
        System.out.println("[>] Ocurrio un error en la Superapp: " + cause.getMessage());
    }
}
