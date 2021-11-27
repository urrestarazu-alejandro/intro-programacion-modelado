package ejercicios.modelado.app.starbucks;

import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Starbucks implements AccionesCafetera {

    HashMap<Tostado, Integer> insumos;

    public Starbucks(HashMap<Tostado, Integer> insumos) {
        this.insumos = insumos;
    }

    public void mostrarInsumos() {
        System.out.println("Insumos: ");
        for (Map.Entry<Tostado, Integer> insumo : insumos.entrySet()) {
            Tostado key = insumo.getKey();
            Integer value = insumo.getValue();

            System.out.println("\t * " + key + ": " +
                    value + " cucharadas.");
        }
        System.out.println("----");
    }

    public TazaCafe preparar(Tostado tostado, Preparacion preparacion) {

        int medicionCucharadas = medir(preparacion);
        moler(tostado, medicionCucharadas);
        añadirAguaCaliente();

        if (Preparacion.PRENSA == preparacion) {
            prensar(tostado);
        }

        return verter(tostado, preparacion);
    }

    public int medir(Preparacion preparacion) {
        int cucharadasPreparacion = 0;

        if (Preparacion.CAFETERA == preparacion) {
            cucharadasPreparacion = 2;
        } else if (Preparacion.PRENSA == preparacion) {
            cucharadasPreparacion = 3;
        }

        System.out.println("Para preparar " + preparacion + " necesito " + cucharadasPreparacion + " cucharadas");

        return cucharadasPreparacion;
    }

    public void moler(Tostado tostadoAMoler, int cucharadasNecesarias) {

        if (insumos.containsKey(tostadoAMoler) &&
                insumos.get(tostadoAMoler) >= cucharadasNecesarias) {
            int cantidadTengo = insumos.get(tostadoAMoler);
            insumos.put(tostadoAMoler, cantidadTengo - cucharadasNecesarias);
            System.out.println("--> Para moler utilice " + cucharadasNecesarias + " cucharadas");
            System.out.println("--> Me quedan " + insumos.get(tostadoAMoler) + " cucharadas de " + tostadoAMoler);

        } else {
            System.out.println("--> No tengo suficiente cafe de: " + tostadoAMoler);
        }
    }

    public void añadirAguaCaliente() {
        System.out.println("--> Añadiendo agua caliente..");
    }

    public void prensar(Tostado tostado) {
        System.out.println("--> Estoy prensando el cafe de: " + tostado);
    }

    public TazaCafe verter(Tostado tostado, Preparacion preparacion) {
        TazaCafe resultado = new TazaCafe(tostado, preparacion);

        System.out.println("Está listo su cafe!!");
        return resultado;
    }
}
