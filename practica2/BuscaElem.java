////////////////////////////////////////////////////////////////////////////////////////////
// ALUMNO:Antonio Gutiérrez Ojeda
// GRUPO:2C
////////////////////////////////////////////////////////////////////////////////////////////

import java.util.Scanner;

public final class BuscaElem{

	public static <T extends Comparable<? super T>> T kesimo(T v[], int k) {
		return kesimoRec(v,0,v.length-1,k);
	}
	public static <T extends Comparable<? super T>> void imprime(T v[]){
		for(int i = 0; i<v.length;i++){
			System.out.print(v[i]+" ");
		}
		System.out.println();
	}

	public static <T extends Comparable<? super T>> T kesimoRec(T v[], int izq, int der, int k) {
		int aux = OrdenacionRapida.partir(v,v[der],izq,der);
		if(aux==k){
			return v[aux];
		}else{
			if (aux>k){
				kesimoRec(v,izq,aux-1,k); //si aux es mayor entonces busco por la izquierda
			}else{
      	kesimoRec(v,aux+1,der,k); // si aux es menor, entonces busco por la derecha
			}
		}
		return v[k];
    }


	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int maxvector;
		int i,k;

		Scanner sc = new Scanner(System.in);
		System.out.print("Introduce el numero de posiciones del vector: ");
		maxvector=sc.nextInt();
		Integer v[]=new Integer[maxvector];

		System.out.print("Introduce "+maxvector+" enteros separados por espacios: ");
		for (i=0;i<maxvector;i++) v[i]=sc.nextInt();
		System.out.print("Introduce la posicion k deseada (de 1-"+maxvector+"): ");k=sc.nextInt();
		Integer elem=kesimo(v,k-1);
		System.out.print("El elemento "+k+"-esimo es: "+elem);
		sc.close();
	}

}
