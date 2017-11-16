/**
 * @author Pepe Gallardo
 * @modifiedby Jose A. Onieva
 * @modifiedby Ricardo Conejo
 * Implementacion de otros metodos de ordenacien para comparar tiempos de ejecucion
 */

public class OrdenacionSeleccion extends Ordenacion {

	// Implementacion de ordenacion por seleccion (para comparar tiempos experimentalmente)
	public static <T extends Comparable<? super T>> void ordenar(T v[]) {
		for(int i=0; i<v.length-1; i++) {
			int posMin = i;
			for (int j=i+1; j<v.length; j++)
				if(v[posMin].compareTo(v[j])>0)
					posMin = j;
			intercambiar(v, i, posMin);
		}
	}
}
