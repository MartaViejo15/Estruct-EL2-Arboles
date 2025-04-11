package Marta;

public class Prueba {
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
        Elemento<Integer> elem1 = preOrden.cabeza;
        while (elem1 != null){
            sumaPreOrden += elem1.getDato();
            elem1 = elem1.getSiguiente();
        }
        System.out.println("La suma en PreOrden es:" + sumaPreOrden);

        Lista<Integer> ordenCentral = arbolito.getListaOrdenCentral(arbolito.raiz);
        int sumaOrdenCentral = 0;
        Elemento<Integer> elem2 = ordenCentral.cabeza;
        while (elem2 != null){
            sumaOrdenCentral += elem2.getDato();
            elem2 = elem2.getSiguiente();
        }
        System.out.println("La suma en OrdenCentral es:" + sumaOrdenCentral);

        Lista<Integer> postOrden = arbolito.getListaPostOrden(arbolito.raiz);
        int sumaPostOrden = 0;
        Elemento<Integer> elem3 = postOrden.cabeza;
        while (elem3 != null){
            sumaPostOrden += elem3.getDato();
            elem3 = elem3.getSiguiente();
        }
        System.out.println("La suma en PostOrden es:" + sumaPostOrden);

        //Apartado iv
        ArbolBinarioBusqueda<Integer> izda = arbolito.getSubArbolIzquierda();
        ArbolBinarioDeBusquedaEnteros iz = (ArbolBinarioDeBusquedaEnteros) izda;
        if (arbolito.getSubArbolIzquierda() != null ){
            System.out.println("La suma de subArbolIzquierda es: " + iz.getSuma());
        } else {
            System.out.println("La suma de subArbolIzquierda es: " + 0);
        }
        ArbolBinarioBusqueda<Integer> dcha = arbolito.getSubArbolDerecha();
        ArbolBinarioDeBusquedaEnteros dch = (ArbolBinarioDeBusquedaEnteros) dcha;
        if (arbolito.getSubArbolDerecha() != null ){
            System.out.println("La suma de subArbolDerecha es: " + dch.getSuma());
        } else {
            System.out.println("La suma de subArbolDerecha es: " + 0);
        }

        // Apartado v
        int altura = arbolito.getAltura();
        System.out.println("La altura del arbolito es:" + altura);

        // Apartado vi
        Lista<Integer> camino110 = arbolito.getCamino(110);
        System.out.println("El camino hasta 110 es:");
        Elemento<Integer> aux = camino110.cabeza;
        while (aux != null){
            System.out.print(aux.getDato() + " ");
            aux = aux.getSiguiente();
        }
        System.out.println();
        System.out.println("Longitud camino hasta 110 es:" + (camino110.numElementos - 1));
    }
}
