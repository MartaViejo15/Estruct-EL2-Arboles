public class ArbolBinarioDeBusquedaEnteros extends ArbolBinarioDeBusqueda<Integer> {
    public ArbolBinarioDeBusquedaEnteros() {
        super();
    }
    public int getSuma(){
        return sumarElem(raiz, 0);
    }
    private int sumarElem(NodoBinarioDeBusqueda<Integer> nodo, int suma){
        if (nodo == null)
            return suma;
        suma += nodo.elemento;
        suma = sumarElem(nodo.Menor, suma);
        suma = sumarElem(nodo.Mayor, suma);
        return suma;
    }
    public ArbolBinarioDeBusquedaEnteros convertir(ArbolBinarioDeBusqueda<Integer> arb) {
        ArbolBinarioDeBusquedaEnteros arbBinario = new ArbolBinarioDeBusquedaEnteros();
        arbBinario.raiz = arb.raiz;
        return arbBinario;
    }
}
