package ejercicios.modelado.app.cajero;

import java.util.HashMap;
import java.util.Map;

public class Cajero {
    HashMap<Billete, Integer> caja;

    // el cajero debe poder cargarse con dinero
    public void cargarDinero(HashMap<Billete, Integer> bolsa) {
        caja = bolsa;
    }

    public HashMap<Billete, Integer> calcularDisponible(int monto) {
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
