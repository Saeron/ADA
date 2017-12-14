/**
 *
 * @author ***** Indicar aqui el autor de la practica *******
 *
 */
 import java.util.*;
public class MochilaAV extends Mochila {

	public static int[] ordenarArray(int[] n,int[] m) {
    int aux;

    for (int i = 0; i < n.length - 1; i++) {
        for (int x = i + 1; x < n.length; x++) {
            if (n[x] > n[i]) {
                aux = n[i];
                n[i] = n[x];
                n[x] = aux;
								/*
								aux2 = m[i];
                m[i] = m[x];
                m[x] = aux2;
								*/
            }
        }
    }

    return n;
}

	public SolucionMochila resolver(ProblemaMochila pm) {
		SolucionMochila sm = null;
		int pesoMochila = 0;//peso actual de la mochila
		ArrayList<Integer> sol= new ArrayList<Integer>();
		//Collections.sort(items, cmp);  // ordena usando el comparador anterior
		//Collections.reverse(items);   // reversa el orden de los elementos
		int posicion = 0;
		while (pesoMochila < pm.getPesoMaximo() && posicion < pm.getValores().length) {
				int tmp = pm.getValor(posicion); // candidato
				//nodosExpandidos++;//cuenta los nodos expandidos

/*  si el peso actual de la
mochila sumado al peso del item que se esta probando no supera
el peso maximo de la mochila, entonces
el item se agrega a la lista de solucion */
				if (pesoMochila + pm.getPeso(posicion) <= pm.getPesoMaximo()) {
						sol.add(tmp);
						pesoMochila += pm.getPeso(posicion);
				}else{
					sol.add(0);
				}
				posicion++;
		}

		//System.out.println(peso);
		int[] solu=new int[pm.getValores().length];

		for(int j=0;j<sol.size();j++){
			if(sol.get(j)!=0){
				solu[j]=1;
			}else{
				solu[j]=0;
			}
		}

		int peso = sumaPesos(pm,solu);
		int valor = sumaValores(pm,solu);

		sm=new SolucionMochila(solu,peso,valor);
		return sm;
	}

	public int sumaPesos(ProblemaMochila pm,int[] a){
		int peso=0;
		for(int i = 0; i<a.length;i++){
			if(a[i]!=0){
			peso+=pm.getPeso(i);
		  }
		}
		return peso;
	}

	public int sumaValores(ProblemaMochila pm,int[] a){
		int valor=0;
		for(int i = 0; i<a.length;i++){
			if(a[i]!=0){
			valor+=pm.getValor(i);
		}
		}
		return valor;
	}


}
