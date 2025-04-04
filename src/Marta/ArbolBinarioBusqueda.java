package Marta;

public class ArbolBinarioBusqueda <v extends Comparable<v>> {
    private NodoArbolBinarioBusqueda<v> raiz;

    public ArbolBinarioBusqueda() {
        this.raiz = new NodoArbolBinarioBusqueda<v>(null);
    }

}
