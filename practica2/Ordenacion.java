/**
 * @author Pepe Gallardo
 * @modifiedby Jose A. Onieva
 * @modifiedby Ricardo Conejo
 * Implementacion de otros motodos de ordenacion para comparar tiempos de ejecucion
 */

import java.util.Random;


public abstract class Ordenacion {

	// Generador de numeros aleatorios
	protected static Random aleat = new Random();

	// este metodo se redefine en las subclases
	public static <T extends Comparable<? super T>> void ordenar(T v[]) {
	}

	// Itercambia los datos en v[i] y v[j]
    protected static <T> void intercambiar(T v[], int i, int j) {
        T tmp = v[i];
        v[i] = v[j];
        v[j] = tmp;
    }

	// Convierte un vector a una cadena de caracteres.
	public static <T> String vectorAString(T v[]) {
				String res = "[";
				for(int i=0; i<v.length; i++)
					res += v[i].toString()+(i==v.length-1 ? ']' : ',');
				return res;
	}

}
