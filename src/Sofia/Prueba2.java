package Sofia;

import java.util.Random;

public class Prueba2 {
    public static void main(String[] args) {
        //1
        ArbolBinarioDeBusquedaEnteros a = new ArbolBinarioDeBusquedaEnteros();
        Random r = new Random();
        boolean hecho = false;
        while (!hecho) {
            a.add(r.nextInt(128));
            Lista<Integer> lista = a.getListaOrdenCentral();
            if (lista.N_elementos == 129) {
                hecho = true;
            }
        }

        //2,3
        System.out.println("La suma es" + a.getSuma_PreOrden() + "en preorden");
        System.out.println("La suma es" + a.getSuma_OrdenCentral() + "en orden central");
        System.out.println("La suma es" + a.getSuma_PostOrden() + "en postorden");

        //4
        ArbolBinarioDeBusqueda<Integer> iz = a.getSubArbolIzquierda();
        ArbolBinarioDeBusquedaEnteros i = (ArbolBinarioDeBusquedaEnteros)iz;
        System.out.println("La suma de subarbol izquierdo es" + i.getSuma_PreOrden() + "en preorden");
        ArbolBinarioDeBusqueda<Integer> der = a.getSubArbolDerecha();
        ArbolBinarioDeBusquedaEnteros d = (ArbolBinarioDeBusquedaEnteros)der;
        System.out.println("La suma de subarbol izquierdo es" + d.getSuma_PreOrden() + "en preorden");

        //5
        System.out.println("La altura del arbol es" + a.getAltura());
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
