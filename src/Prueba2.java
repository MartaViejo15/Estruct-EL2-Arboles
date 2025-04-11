
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
        /* Estos errores no se pueden dejar al 100% de cobertura porque se puede dar el caso de error */

        /*La suma de los subárboles salen cada vez diferente, ya que como hemos metido los dato de forma aleatoria,
        los árboles que obtenemos cada vez al ejecutarlo serán diferentes. */

        //5
        System.out.println("La altura del arbol es " + a.getAltura());
        /*La altura del árbol sale cada vez diferente, ya que como hemos metido los dato de forma aleatoria,
        los árboles que obtenemos cada vez al ejecutarlo serán diferentes. */

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

        /*
        Explique las diferencias (si las ha habido) de los resultados obtenidos entre los dos programas de prueba.

        La suma en ambos casos es la misma, puesto que tenemos los mismos datos (los números de 0 a 128).
        La suma de los subárboles de izquierda y derecha va a ser la misma únicamente en el caso en el que en la prueba2, los
        datos que se generan aleatoriamente se generen justo en orden, del 0 al 128.
        En cuanto a la altura va a pasar lo mismo que con la suma de los subárboles, ya que la altura va a ser la misma si el
        árbol está en orden de 0 a 128, pero en este caso también se daría la misma altura en caso de que el árbol se haya
        generado con los números aleatorios desde el 128 al 0.
        El camino va a ser siempre distinto, puesto que al generar los números de forma aleatoria siempre va a ser distinto,
        pero nos encontramos en un caso igual a los dos anteriores, si se ha generado de forma aleatoria y coincide que están
        ordenados, el camino hasta llegar al 110 continuará siendo el mismo. La longitud será, al igual, distinta.

        ¿Qué sucede con los resultados si ejecuta los programas de prueba varias veces?

        La primera siempre será igual, mientras que las demás irán cambiando dependiendo del orden aleatorio en el que se metan
        los números.
         */

    }
}
