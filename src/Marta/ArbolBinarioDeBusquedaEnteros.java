package Marta;

public class ArbolBinarioDeBusquedaEnteros extends ArbolBinarioBusqueda<Integer> {
    public ArbolBinarioDeBusquedaEnteros() {
        super();
    }
    public int getSuma(){
        return sumarElem(raiz, 0);
    }
    public int sumarElem(NodoArbolBinarioBusqueda<Integer> nodo, int suma){
        if (nodo == null || nodo.valor == null)
            return suma;
        suma += nodo.valor;
        suma = sumarElem(nodo.getMenor(), suma);
        suma = sumarElem(nodo.getMayor(), suma);
        return suma;
    }

}
