////////////////////////////////////////////////////////////////////////////////////////////
// ALUMNO:Antonio Gutiérrez Ojeda
// GRUPO:2C
////////////////////////////////////////////////////////////////////////////////////////////

public class OrdenacionRapida extends Ordenacion {

	public static <T extends Comparable<? super T>> void ordenar(T v[]) {
	    ordRapidaRec(v, 0, v.length-1);
	}

	// Debe ordenar ascendentemente los primeros @n elementos del vector @v con
	// una implementacien recursiva del metodo de ordenacien rapida.
	//complejidad de ordenar es n log n
	public static <T extends Comparable<? super T>> void ordRapidaRec(T v[], int izq, int der) {
    if(izq < der){
      T pivote = v[der];
      int s = partir(v,pivote,izq,der);
      ordRapidaRec(v,izq,s-1);
      ordRapidaRec(v,s+1,der);
    }
	}
   public static <T extends Comparable<? super T>> void intercambiar(T v[], int izq, int der){
     T aux = v[izq];
     v[izq]=v[der];
     v[der]=aux;

   }
	 //complejidad del partir es n
   public static <T extends Comparable<? super T>> int partir(T v[], T pivote, int izq, int der) {
		 return primero(v,pivote,izq,der);
		 //return hoare(v,pivote,izq,der);
	 }

   public static <T extends Comparable<? super T>> int hoare(T v[], T pivote, int izq, int der) {
	    int i = izq+1;
      int j = der;
      while((i<=der)&&(v[i].compareTo(pivote)<=0)){
        i++;
      }
      while(v[j].compareTo(pivote)>0){
        j--;
      }
      while(i<j){
        intercambiar(v,i,j);
        while(v[i++].compareTo(pivote)<=0);
        while(v[--j].compareTo(pivote)>0);
      }
      intercambiar(v,izq,j);
      return j;
   }

   public static <T extends Comparable<? super T>> int primero(T v[], T pivote, int izq, int der) {
	    int i = izq-1;
      for(int j = izq; j < der; j++){ // mientras j sea menor que el ultimo
        if(v[j].compareTo(pivote)<=0){ //si el elemento j es menor que pivote, se pone a la izquierda
          i++;
          T aux=v[i];
          v[i]=v[j];
          v[j]=aux;
        }
      }
      T aux = v[i+1]; //se intercambia el pivote por el primer elemento de conjunto superior
      v[i+1]=v[der]; // j ya ha llegado al pivote
      v[der]= aux;
	    return i+1;
   }


	// Peque�os ejemplos para pruebas iniciales.
	public static void main (String args[]) {

		// Un vector de enteros
		Integer vEnt[] = {3,8,6,5,2,9,1,1,4};
		ordenar(vEnt);
		System.out.println(vectorAString(vEnt));

		// Un vector de caracteres
		Character vCar[] = {'d','c','v','b'};
		ordenar(vCar);
		System.out.println(vectorAString(vCar));

	}

}
