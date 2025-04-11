package Sofia;

import java.util.Random;

public class Prueba2 {
    public static void main(String[] args) {
        //1
        ArbolBinarioDeBusquedaEnteros a = new ArbolBinarioDeBusquedaEnteros();
        Random r = new Random();
        Lista<Integer> lista = new Lista<>();
        for (int i = 0; i < 129; i++) {
            lista.add(i);
        }
        while (lista.N_elementos != 0){
            Elemento<Integer> aux = lista.primero;
            int random = r.nextInt(lista.N_elementos);
            for (int i = 0; i < random; i++) {
                aux = aux.siguiente;
            }
            a.add(aux.dato);
            lista.delete(aux.dato);
        }

        //2,3
        System.out.println("La suma es " + a.getSuma_PreOrden() + " en preorden");
        System.out.println("La suma es " + a.getSuma_OrdenCentral() + " en orden central");
        System.out.println("La suma es " + a.getSuma_PostOrden() + " en postorden");

        //4
        ArbolBinarioDeBusquedaEnteros i = new ArbolBinarioDeBusquedaEnteros();
        i = i.convertir(a.getSubArbolIzquierda());
        if(i != null){
            System.out.println("La suma de subarbol izquierdo es " + i.getSuma_PreOrden() + " en preorden");
        }else{
            System.out.println("La suma de subarbol izquierdo es " + 0);
        }
        ArbolBinarioDeBusquedaEnteros d = new ArbolBinarioDeBusquedaEnteros();
        d = d.convertir(a.getSubArbolDerecha());
        if(i != null){
            System.out.println("La suma de subarbol derecho es " + d.getSuma_PreOrden() + " en preorden");
        }else{
            System.out.println("La suma de subarbol derecho es " + 0);
        }

        //5
        System.out.println("La altura del arbol es " + a.getAltura());
        /*La altura del arbol sale cada vez diferente, ya que como hemos metido los dato de forma aleatoria,
        los arboles que obtenemos cada vez al ejecutarlo seran diferentes. */

        //6
        System.out.print("El camino para llegar al valor 110 es ");
        NodoBinarioDeBusqueda<Integer> n = new NodoBinarioDeBusqueda<>(110);
        Lista<Integer> camino = a.getCamino(n);
        int longitud = camino.N_elementos-1;
        while (camino.primero != null) {
            System.out.print(camino.primero.dato + " ");
            camino.primero = camino.primero.siguiente;
        }
        System.out.println(", y su longitud de camino es " + longitud);
    }
}
