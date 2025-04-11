public class ArbolBinarioDeBusqueda <v extends Comparable<v>> {
    protected NodoBinarioDeBusqueda<v> raiz;

    public ArbolBinarioDeBusqueda() {
        this.raiz = new NodoBinarioDeBusqueda<>(null);
    }
    public int getAltura(){
        Lista<v> ListaElem = getListaPreOrden(raiz);
        Lista<v> aux = new Lista<>();
        while (ListaElem.primero != null) {
            Lista<v> camino = getCamino(ListaElem.primero.dato);
            if (aux.N_elementos < camino.N_elementos) {
                aux = camino;
            }
            ListaElem.primero = ListaElem.primero.siguiente;
        }
        return aux.N_elementos;
    }

    public Lista<v> getListaPreOrden(NodoBinarioDeBusqueda<v> nodo){
        Lista<v> LPreOrden = new Lista<>();
        PreOrden(nodo, LPreOrden);
        return LPreOrden;
    }
    private void PreOrden(NodoBinarioDeBusqueda<v> nodo, Lista<v> lista){
        if (nodo != null){
            lista.add(nodo.elemento);
            PreOrden(nodo.Menor, lista);
            PreOrden(nodo.Mayor, lista);
        }
    }
    public Lista<v> getListaOrdenCentral(NodoBinarioDeBusqueda<v> nodo){
        Lista<v> LCentral = new Lista<>();
        Central(nodo, LCentral);
        return LCentral;
    }
    private void Central(NodoBinarioDeBusqueda<v> nodo, Lista<v> lista){
        if (nodo != null){
            Central(nodo.Menor, lista);
            lista.add(nodo.elemento);
            Central(nodo.Mayor, lista);
        }
    }
    public Lista<v> getListaPostOrden(NodoBinarioDeBusqueda<v> nodo){
        Lista<v> LPostOrden = new Lista<>();
        PostOrden(nodo, LPostOrden);
        return LPostOrden;
    }
    private void PostOrden(NodoBinarioDeBusqueda<v> nodo, Lista<v> lista){
        if (nodo != null){
            PostOrden(nodo.Menor, lista);
            PostOrden(nodo.Mayor, lista);
            lista.add(nodo.elemento);
        }
    }
    public Lista<v> getListaDatosNivel(int numDatos){
        Lista<v> ListaDatos = new Lista<>();
        getDatosNivel(raiz, 0, numDatos, ListaDatos);
        return ListaDatos;
    }
    private void getDatosNivel(NodoBinarioDeBusqueda<v> nodo, int actual, int destino, Lista<v> lista){
        if (nodo == null){
            return;
        } else if (actual == destino){
            lista.add(nodo.elemento);
        } else {
            getDatosNivel(nodo.Menor, actual + 1, destino, lista);
            getDatosNivel(nodo.Mayor, actual + 1, destino, lista);
        }
    }
    public void add(v valor){
        raiz = insertar(raiz, valor);
    }
    public NodoBinarioDeBusqueda<v> insertar(NodoBinarioDeBusqueda<v> nodo, v valor){
        if (nodo == null || nodo.elemento == null){
            return new NodoBinarioDeBusqueda<>(valor);
        } else if (valor.compareTo(nodo.elemento) < 0){
            nodo.Menor = insertar(nodo.Menor, valor);
        } else {
            nodo.Mayor = insertar(nodo.Mayor, valor);
        }
        return nodo;
    }
}

