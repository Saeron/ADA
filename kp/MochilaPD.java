/**
 *
 * @author ***** Indicar aqui el autor de la practica *******
 *
 */
 import java.util.*;
public class MochilaPD extends Mochila {


	static int max2(int a, int b) { return (a>b)?a:b; }

  public void imprimir(int[][] V){
		for (int[] rows : V) {
            for (int col : rows) {
                System.out.format("%5d", col);
            }
            System.out.println();
        }
			}
 public static void recrear(int[] solucion, ProblemaMochila pm, int fila, int columna, int[][] mat,int pes){
    		if(fila>0 && columna>0){
    			if(mat[fila-1][columna]<mat[fila][columna]){
    			solucion[fila-1]=1;
    			recrear(solucion, pm, fila-1, columna-pm.getPeso(fila-1), mat,pes+pm.getPeso(fila-1));
    			}else{
    			solucion[fila-1]=0;
    			recrear(solucion, pm, fila-1, columna, mat,pes);
    			}
    		}
  }
/*
  public SolucionMochila recrear(int[][] V,int[] pesos,int H,int W){
		SolucionMochila mochila;
		int[] selected = new int[H];
		int pes=0;
        for (int n = H, w = W; n > 0; n--)
        {
					//System.out.println("Entra");
					//System.out.println(n+" ");
            if (V[n][w] != 0)
            {
							  System.out.println(V[n][w]+" ");
                selected[n-1] = 1;
								//System.out.println(n);
                w = w - pesos[n-1];
								pes+=pesos[n-1];

            }
            else
                selected[n-1] = 0;
        }
    mochila =new SolucionMochila(selected,pes,V[H][W]);

		return mochila;
	}
  */
	public SolucionMochila resolver(ProblemaMochila pm) {
		SolucionMochila sm = null;

		int[] pesos = pm.getPesos();
		int[] valores = pm.getValores();
		int capacidad = pm.getPesoMaximo();
		int n = pesos.length; // num. elementos
		int [ ][ ] V = new int [n+1][capacidad+1];
		for (int c=0; c<=capacidad; c++) V[0][c] = 0; // Si tengo 0 de espacio, la respuesta es 0
		for (int elem=1; elem<=n; elem++) {
			for (int c=0; c<=capacidad; c++) {
				if (c<pesos[elem-1]) V[elem][c] = V[elem-1][c];
				else V[elem][c] = max2(V[elem-1][c], V[elem-1][c-pesos[elem-1]] +valores[elem-1]);
			}
		}
   	//imprimir(V);
    int[] sol = new int[n];
    int pes = 0;
		recrear(sol,pm,n,capacidad,V,pes);
    sm=new SolucionMochila(sol,8,V[n][capacidad]);
		return sm;
	}
}
