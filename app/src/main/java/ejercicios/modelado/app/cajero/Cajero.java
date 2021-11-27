package ejercicios.modelado.app.cajero;

import java.util.HashMap;
import java.util.Map;

public class Cajero {
    private Boolean cerroElcajero;
    private HashMap<Billete, Integer> caja;
    private int contadorFallidos = 0;


    public boolean validarSeguridad(int contrasenia, TarjetaCajero tarjetaCajero) throws CajeroException {
        boolean esvalido = false;
        if (contadorFallidos >= 2) {
            tarjetaCajero.setBloqueada(true);
            throw new CajeroException("La tarjeta ha sido bloqueada.");
        }

        if (contrasenia != tarjetaCajero.getCodigoSeguridad()) {
            contadorFallidos = contadorFallidos + 1;
            //throw new CajeroException("Contraseña invalida.");
        }
        if (contrasenia == tarjetaCajero.getCodigoSeguridad()) {
            esvalido = true;
        }

        return esvalido;
    }

    // el cajero debe poder cargarse con dinero
    public void cargarDinero(HashMap<Billete, Integer> bolsa) throws CajeroException {
        if (cerroElcajero) {
            caja = bolsa;
            return;
        }

        throw new CajeroException("No se puede cargar el cajero hasta que se cierre");
    }

    public Boolean getCerroElcajero() {
        return cerroElcajero;
    }

    public void setCerroElcajero(Boolean cerroElcajero) {
        this.cerroElcajero = cerroElcajero;
    }

    public HashMap<Billete, Integer> calcularDisponible(int monto) throws CajeroException {
        if (monto <= 0) {
            throw new CajeroException("Monto invalido. Debe ser mayor o gual que cero. Ingreso: " + monto);
        }

        HashMap<Billete, Integer> disponible = new HashMap<>();

        int contarDinero = 0;

        for (Map.Entry<Billete, Integer> billete : caja.entrySet()) {
            int billeteDisponibles = billete.getValue();
            if (billeteDisponibles > 0) {
                int billetesNecesarios = 0;
                while (contarDinero + billete.getKey().getValorNumerico() <= monto) {
                    if (billetesNecesarios < billeteDisponibles) {
                        billetesNecesarios++;
                        contarDinero = contarDinero + billete.getKey().getValorNumerico();
                    } else {
                        break;
                    }
                }

                if (billetesNecesarios > 0) {
                    disponible.put(billete.getKey(), billetesNecesarios);
                }
            }
        }

        int conteo = contarBilletes(disponible);

        if (conteo != monto) {
            throw new CajeroException("No hay dinero disponible para entregar " + monto);
        }

        return disponible;
    }

    public int contarBilletes(HashMap<Billete, Integer> fajo) {
        int conteo = 0;

        for (Map.Entry<Billete, Integer> billete : fajo.entrySet()) {
            int cuantoDineroHay = billete.getKey().getValorNumerico() * billete.getValue();
            conteo = conteo + cuantoDineroHay;
        }

        return conteo;
    }

    public HashMap<Billete, Integer> entregar(HashMap<Billete, Integer> disponible) {

        for (Map.Entry<Billete, Integer> billete : disponible.entrySet()) {
            int cantidadActual = caja.get(billete.getKey());
            //resto la cantidad de billetes que voy a extraer
            caja.put(billete.getKey(), cantidadActual - billete.getValue());
        }

        return disponible;
    }


    @Override
    public String toString() {
        return "Cajero {" +
                "caja= " + caja +
                '}';
    }
}
