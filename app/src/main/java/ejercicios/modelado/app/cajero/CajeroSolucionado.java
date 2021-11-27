package ejercicios.modelado.app.cajero;

import java.util.HashMap;
import java.util.Map;

public class CajeroSolucionado {
    HashMap<Billete, Integer> caja;

    public HashMap<Billete, Integer> calcularDisponible(int monto) {
        HashMap<Billete, Integer> disponible = new HashMap<>();

        int conteoDinero = 0;
        for (Map.Entry<Billete, Integer> billete : caja.entrySet()) {
            int billetesDisponibles = billete.getValue();

            // hay billetes?
            if (billetesDisponibles > 0) {
                int billetesNecesarios = 0;

                //Si le agrego un billete me paso del monto?
                while (conteoDinero + billete.getKey().getValorNumerico() <= monto) {

                    if (billetesNecesarios < billetesDisponibles) {
                        billetesNecesarios++;
                        conteoDinero = conteoDinero + billete.getKey().getValorNumerico();
                    } else {
                        break;
                    }
                }

                //Necesito de esos billetes?
                if (billetesNecesarios > 0) {
                    //Agrego los billetes al fajo de disponibles
                    disponible.put(billete.getKey(), billetesNecesarios);
                }
            }
        }

        return disponible;
    }

    public void cargarDinero(HashMap<Billete, Integer> caja) {
        // TODO: al cargar dinero bloquear el cajero
        // TODO: al cargar dinero no se saca el dinero anterior, se debe agregar.
        this.caja = caja;
    }

    public int contarBilletes(HashMap<Billete, Integer> fajo) {
        int conteo = 0;
        for (Map.Entry<Billete, Integer> billete : fajo.entrySet()) {
            conteo = conteo + (billete.getKey().getValorNumerico() * billete.getValue());
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
        return "Cajero { " +
                "caja= " + caja +
                '}';
    }
}
