package Marta;

public class ArbolBinarioBusqueda <v extends Comparable<v>> {
    protected NodoArbolBinarioBusqueda<v> raiz;

    public ArbolBinarioBusqueda() {
        this.raiz = new NodoArbolBinarioBusqueda<v>(null);
    }
    public int getAltura(){
        Lista<v> ListaElem = getListaPreOrden(raiz);
        Lista<v> aux = new Lista<>();
        while (ListaElem.cabeza != null) {
            Lista<v> camino = getCamino(ListaElem.cabeza.getDato());
            if (aux.numElementos < camino.numElementos) {
                aux = camino;
            }
            ListaElem.cabeza = ListaElem.cabeza.getSiguiente();
        }
        return aux.numElementos;
    }
    public Lista<v> getCamino(v destino){
        Lista<v> L = new Lista<>();
        buscarNodo(destino, raiz, L);
        return L;
    }
    private NodoArbolBinarioBusqueda<v> buscarNodo(v destino, NodoArbolBinarioBusqueda<v> nodo, Lista<v> lista){
        if (destino.compareTo(nodo.valor) == 0){
            lista.add(nodo.valor);
            return null;
        } else if (destino.compareTo(nodo.valor) < 0){
            if (nodo.getMenor() != null){
                lista.add(nodo.valor);
                return buscarNodo(destino, nodo.getMenor(), lista);
            } else {
                lista = null;
                return nodo;
            }
        } else {
            if (nodo.getMayor() != null){
                lista.add(nodo.valor);
                return buscarNodo(destino, nodo.getMayor(), lista);
            } else {
                lista = null;
                return nodo;
            }
        }
    }
    public Lista<v> getListaPreOrden(NodoArbolBinarioBusqueda<v> nodo){
        Lista<v> LPreOrden = new Lista<>();
        PreOrden(nodo, LPreOrden);
        return LPreOrden;
    }
    private void PreOrden(NodoArbolBinarioBusqueda<v> nodo, Lista<v> lista){
        if (nodo != null){
            lista.add(nodo.valor);
            PreOrden(nodo.getMenor(), lista);
            PreOrden(nodo.getMayor(), lista);
        }
    }
    public Lista<v> getListaOrdenCentral(NodoArbolBinarioBusqueda<v> nodo){
        Lista<v> LCentral = new Lista<>();
        Central(nodo, LCentral);
        return LCentral;
    }
    private void Central(NodoArbolBinarioBusqueda<v> nodo, Lista<v> lista){
        if (nodo != null){
            Central(nodo.getMenor(), lista);
            lista.add(nodo.valor);
            Central(nodo.getMayor(), lista);
        }
    }
    public Lista<v> getListaPostOrden(NodoArbolBinarioBusqueda<v> nodo){
        Lista<v> LPostOrden = new Lista<>();
        PostOrden(nodo, LPostOrden);
        return LPostOrden;
    }
    private void PostOrden(NodoArbolBinarioBusqueda<v> nodo, Lista<v> lista){
        if (nodo != null){
            PostOrden(nodo.getMenor(), lista);
            PostOrden(nodo.getMayor(), lista);
            lista.add(nodo.valor);
        }
    }
    public Lista<v> getListaDatosNivel(int numDatos){
        Lista<v> ListaDatos = new Lista<>();
        getDatosNivel(raiz, 0, numDatos, ListaDatos);
        return ListaDatos;
    }
    private void getDatosNivel(NodoArbolBinarioBusqueda<v> nodo, int actual, int destino, Lista<v> lista){
        if (nodo == null){
            return;
        } else if (actual == destino){
            lista.add(nodo.valor);
        } else {
            getDatosNivel(nodo.getMenor(), actual + 1, destino, lista);
            getDatosNivel(nodo.getMayor(), actual + 1, destino, lista);
        }
    }

    /*
    public boolean isArbolCompleto(){
        return esCompleto(raiz, 0, ContarNodos(raiz));
    }
    private boolean esCompleto(NodoArbolBinarioBusqueda<v> nodo, int i, int total){
        if (nodo == null || nodo.valor == null){
            return true;
        } else if (i >= total){
            return false;
        }
        return esCompleto(nodo.getMenor(), 2);
    }
    private int ContarNodos(NodoArbolBinarioBusqueda<v> nodo){
        int contadorNodos = 0;

    }

    public boolean isArbolCasiCompleto(){

    }
     */


    public void add(v valor){
        raiz = insertar(raiz, valor);
    }
    public NodoArbolBinarioBusqueda<v> insertar(NodoArbolBinarioBusqueda<v> nodo, v valor){
        if (nodo == null || nodo.valor == null){
            return new NodoArbolBinarioBusqueda<>(valor);
        } else if (valor.compareTo(nodo.valor) < 0){
            nodo.menor = insertar(nodo.getMenor(), valor);
        } else {
            nodo.mayor = insertar(nodo.getMayor(), valor);
        }
        return nodo;
    }

    public ArbolBinarioBusqueda<v> getSubArbolIzquierda(){
        ArbolBinarioBusqueda<v> subarbol = new ArbolBinarioBusqueda<>();
        subarbol.raiz = raiz.getMenor();
        return subarbol;
    }
    public ArbolBinarioBusqueda<v> getSubArbolDerecha(){
        ArbolBinarioBusqueda<v> subarbol = new ArbolBinarioBusqueda<>();
        subarbol.raiz = raiz.getMayor();
        return subarbol;
    }



    /*
    Para ver si el arbol es completo, miro las alturas de los hijos de la raiz, si no tiene hijos es completo pq es solo la raiz
    y si tiene hijos miro si su altua es igual para saber si son completos, porque eso va a significar que tienen la misma cantidad de hijos
     */
}
