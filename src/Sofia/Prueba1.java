package Sofia;

public class Prueba1 {
    public static void main(String[] args) {
        //1
        ArbolBinarioDeBusquedaEnteros a = new ArbolBinarioDeBusquedaEnteros();
        for (int i=0; i<129; i++){
            a.add(i);
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
