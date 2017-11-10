//Ejercicio 7 
funcion(){ 
Int x = length(a/2);
 if a[x-1]>a[x]<a[x+1]{
	return x;
 }else if a[x-1]<a[x] {
        return funcion(a,x+1,a.length())
 }
}

//ejercicio 8
funcion(int[] v, int inic, int fin){
Solucion s;
//Solucion tiene int i y int j
//Int x = length(a/2);
if(inic==fin){s.i=s.j=inic;}
else {
Solucion izq,der,centro;
m=(inic+fin)/2;
izq=funcion(v,inic,m-1);
der=funcion(v,m+1,fin);
centro=pasaPorCentro(v,inic,fin,m);
s=maximo(izq,der,centro);
}
return s;
}

Solucion pasaPorCentro(int[] v,int inic, int fin, int m){
Solucion s;
s.i=s.j=m;
while(s.i>inic && v[s.i]>v[s.i-1]){s.i--}
while(s.j<fin && v[s.j]<v[s.j+1]){s.j++}
return s;
}
