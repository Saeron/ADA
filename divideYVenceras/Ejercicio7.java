public class Ejercicio7 {

  private static int[] A;
  private static int MAX=5;

  public static int pico(int[] a,int inic,int fin){
    int x = a.length/2;
    if (a[x-1]>a[x] && a[x]<a[x+1]){
  	   return a[x];
     }else if (a[x-1]<a[x]) {
            return pico(a,x+1,a.length);
    }else{
      //por completar, esto esta solo para que no de fallos
      return 0;
    }
  }

  public static void main (String[] args){
    pico(A,0,MAX);
  }
}
