
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

        //2
        System.out.println("La suma es:" + a.getSuma());

        //3
        Lista<Integer> preOrden = a.getListaPreOrden(a.raiz);
        int sumaPreOrden = 0;
        Elemento<Integer> elem1 = preOrden.primero;
        while (elem1 != null){
            sumaPreOrden += elem1.dato;
            elem1 = elem1.siguiente;
        }
        System.out.println("La suma en PreOrden es:" + sumaPreOrden);

        Lista<Integer> ordenCentral = a.getListaOrdenCentral(a.raiz);
        int sumaOrdenCentral = 0;
        Elemento<Integer> elem2 = ordenCentral.primero;
        while (elem2 != null){
            sumaOrdenCentral += elem2.dato;
            elem2 = elem2.siguiente;
        }
        System.out.println("La suma en OrdenCentral es:" + sumaOrdenCentral);

        Lista<Integer> postOrden = a.getListaPostOrden(a.raiz);
        int sumaPostOrden = 0;
        Elemento<Integer> elem3 = postOrden.primero;
        while (elem3 != null){
            sumaPostOrden += elem3.dato;
            elem3 = elem3.siguiente;
        }
        System.out.println("La suma en PostOrden es:" + sumaPostOrden);

        //4
        ArbolBinarioDeBusquedaEnteros i = new ArbolBinarioDeBusquedaEnteros();
        i = i.convertir(a.getSubArbolIzquierda());
        if(i != null){
            System.out.println("La suma de subarbol izquierdo es " + i.getSuma());
        }else{
            System.out.println("La suma de subarbol izquierdo es " + 0);
        }
        ArbolBinarioDeBusquedaEnteros d = new ArbolBinarioDeBusquedaEnteros();
        d = d.convertir(a.getSubArbolDerecha());
        if(i != null){
            System.out.println("La suma de subarbol derecho es " + d.getSuma());
        }else{
            System.out.println("La suma de subarbol derecho es " + 0);
        }
        /*La suma de los subarboles salen cada vez diferente, ya que como hemos metido los dato de forma aleatoria,
        los arboles que obtenemos cada vez al ejecutarlo seran diferentes. */

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
