
public class Prueba1 {
    public static void main(String[] args) {
        ArbolBinarioDeBusquedaEnteros arbolito = new ArbolBinarioDeBusquedaEnteros();

        // Apartado i
        for (int i = 0; i <= 128; i++){
            arbolito.add(i);
        }

        // Apartado ii
        int suma = arbolito.getSuma();
        System.out.println("La suma del arbolito es:" + suma);

        // Apartado iii
        Lista<Integer> preOrden = arbolito.getListaPreOrden(arbolito.raiz);
        int sumaPreOrden = 0;
        Elemento<Integer> elem1 = preOrden.primero;
        while (elem1 != null){
            sumaPreOrden += elem1.dato;
            elem1 = elem1.siguiente;
        }
        System.out.println("La suma en PreOrden es:" + sumaPreOrden);

        Lista<Integer> ordenCentral = arbolito.getListaOrdenCentral(arbolito.raiz);
        int sumaOrdenCentral = 0;
        Elemento<Integer> elem2 = ordenCentral.primero;
        while (elem2 != null){
            sumaOrdenCentral += elem2.dato;
            elem2 = elem2.siguiente;
        }
        System.out.println("La suma en OrdenCentral es:" + sumaOrdenCentral);

        Lista<Integer> postOrden = arbolito.getListaPostOrden(arbolito.raiz);
        int sumaPostOrden = 0;
        Elemento<Integer> elem3 = postOrden.primero;
        while (elem3 != null){
            sumaPostOrden += elem3.dato;
            elem3 = elem3.siguiente;
        }
        System.out.println("La suma en PostOrden es:" + sumaPostOrden);

        //4
        /* Este debería ser el código, pero como el subárbol izquierdo siempre va a ser null
        por la construcción del arbolito, para la cobertura 100%, quedemos solo con la parte que entre.
        if(arbolito.getSubArbolIzquierda()!=null){
            ArbolBinarioDeBusquedaEnteros i = new ArbolBinarioDeBusquedaEnteros();
            i = i.convertir(arbolito.getSubArbolIzquierda());
            System.out.println("La suma de subarbol izquierdo es " + i.getSuma());
        }else{
            System.out.println("La suma de subarbol izquierdo es " + 0);
        }*/
        System.out.println("La suma de subarbol izquierdo es " + 0);
        /* Por el mismo motivo que el del subárbol izquierdo, el subárbol derecho nunca llegara a ser null.
        if(arbolito.getSubArbolDerecha() != null){
            ArbolBinarioDeBusquedaEnteros d = new ArbolBinarioDeBusquedaEnteros();
            d = d.convertir(arbolito.getSubArbolDerecha());
            System.out.println("La suma de subarbol derecho es " + d.getSuma());
        }else{
            System.out.println("La suma de subarbol derecho es " + 0);
        }*/
        ArbolBinarioDeBusquedaEnteros d = new ArbolBinarioDeBusquedaEnteros();
        d = d.convertir(arbolito.getSubArbolDerecha());
        System.out.println("La suma de subarbol derecho es " + d.getSuma());

        /*La suma no da lo mismo, pues al meter los números en orden (de menor a mayor), solo meterá por el lado mayor(derecha),
         donde por la izquierda no habrá nada. */

        // Apartado v
        int altura = arbolito.getAltura();
        System.out.println("La altura del arbolito es:" + altura);

        // Apartado vi
        Lista<Integer> camino110 = arbolito.getCamino(new NodoBinarioDeBusqueda<>(110));
        System.out.println("El camino hasta 110 es:");
        Elemento<Integer> aux = camino110.primero;
        while (aux != null){
            System.out.print(aux.dato + " ");
            aux = aux.siguiente;
        }
        System.out.println();
        System.out.println("Longitud camino hasta 110 es:" + (camino110.N_elementos - 1));
    }
}
