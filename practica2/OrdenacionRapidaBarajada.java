////////////////////////////////////////////////////////////////////////////////////////////
// ALUMNO:Antonio Gutiérrez Ojeda
// GRUPO:2C
////////////////////////////////////////////////////////////////////////////////////////////
import java.util.Random;
public class OrdenacionRapidaBarajada extends OrdenacionRapida {

	// Implementacion de QuickSort con reordenacion aleatoria inicial (para comparar tiempos experimentalmente)
	public static <T extends Comparable<? super T>> void ordenar(T v[]) {
		T[] a = v;
		barajar(a);
		int n = a.length;
		OrdenacionRapida.ordRapidaRec(a,0,n-1);
	}

	// reordena aleatoriamente los datos de un vector
    private static <T> void barajar(T v[]) {
    	Random rnd = new Random();
			int tam = v.length;
			for(int i = 0; i < tam;i++){
				int n = rnd.nextInt(tam-1);
				T aux = v[n];
				v[n]=v[i];
				v[i]=aux;
			}
    }


}
