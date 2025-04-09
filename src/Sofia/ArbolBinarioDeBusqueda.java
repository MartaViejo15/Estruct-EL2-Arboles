package Sofia;

public class ArbolBinarioDeBusqueda<v extends Comparable<v>> {
    //atributo
    private NodoBinarioDeBusqueda<v> raiz;

    //constructor
    public ArbolBinarioDeBusqueda() {
        this.raiz = new NodoBinarioDeBusqueda<>(null);
    }

    //metodos
    public int getAltura() {
        int altura = 1;
        if (this.raiz == null) {
            return 0;
        }
        while(getListaDatosNivel(altura).N_elementos != 0){
            altura += 1;
        }
        return altura-1;
    }

    public Lista<v> getListaDatosNivel(int nivel){
        Lista<v> res = new Lista<>();
        Lista<v> datos = getListaPostOrden();
        while (datos.primero != null) {
            Lista<v> camino = getCamino(new NodoBinarioDeBusqueda<>(datos.primero.dato));
            if (camino.N_elementos == nivel) {
                res.add(datos.primero.dato);
            }
            datos.primero = datos.primero.siguiente;
        }
        return res;
    }

    public Boolean isArbolHomogeneo(){
        boolean res = true;
        homogeneo(raiz.getGrado(), raiz, res);
        return res;
    }

    private void homogeneo(int n, NodoBinarioDeBusqueda<v> nodo, Boolean res){
        if(nodo.getGrado()!=0){
            if(nodo.getGrado() != n){
                res = false;
            }else{
                homogeneo(n, nodo.Menor, res);
                homogeneo(n, nodo.Mayor, res);
            }
        }
    }

    public boolean isArbolCompleto(){
        boolean res = true;
        Completo(this,res);
        return res;
    }

    public Boolean isArbolCasiCompleto(){
        boolean res = true;
        CasiCompleto(this,res);
        return res;
    }

    private void Completo(ArbolBinarioDeBusqueda<v> arbol, boolean c){
        if(arbol.raiz.getGrado()!=0){
            if(arbol.getSubArbolDerecha().getAltura()!=arbol.getSubArbolIzquierda().getAltura()){
                c = false;
            }else{
                Completo(arbol.getSubArbolDerecha(),c);
                Completo(arbol.getSubArbolIzquierda(),c);
            }
        }
    }
    private void CasiCompleto(ArbolBinarioDeBusqueda<v> arbol, boolean cc){
        if(arbol.raiz.getGrado()!=0){
            if(arbol.getSubArbolDerecha().getAltura()-1 != arbol.getSubArbolIzquierda().getAltura() ||
                    arbol.getSubArbolDerecha().getAltura() != arbol.getSubArbolIzquierda().getAltura()-1){
                cc = false;
            }else {
                CasiCompleto(arbol.getSubArbolDerecha(),cc);
                CasiCompleto(arbol.getSubArbolIzquierda(),cc);
            }
        }
    }

    public Lista<v> getCamino(NodoBinarioDeBusqueda<v> destino){
        Lista<v> lista = new Lista<>();
        if(raiz == null){
            return lista;
        }
        buscarNodo(destino.elemento, raiz, lista);
        return lista;
    }

    public Lista<v> getListaPreOrden() {
        Lista<v> lista = new Lista<>();
        PreOrden(raiz, lista);
        return lista;
    }

    public Lista<v> getListaPostOrden() {
        Lista<v> lista = new Lista<>();
        PostOrden(raiz, lista);
        return lista;
    }

    public Lista<v> getListaOrdenCentral() {
        Lista<v> lista = new Lista<>();
        OrdenCentral(raiz, lista);
        return lista;
    }

    private void OrdenCentral(NodoBinarioDeBusqueda<v> nodo, Lista<v> lista) {
        if (nodo != null) {
            OrdenCentral(nodo.Menor, lista);
            lista.add(nodo.elemento);
            OrdenCentral(nodo.Mayor, lista);
        }
    }
    private void PostOrden(NodoBinarioDeBusqueda<v> nodo, Lista<v> lista) {
        if (nodo != null) {
            PostOrden(nodo.Menor, lista);
            PostOrden(nodo.Mayor, lista);
            lista.add(nodo.elemento);
        }
    }
    private void PreOrden(NodoBinarioDeBusqueda<v> nodo, Lista<v> lista) {
        if (nodo != null) {
            lista.add(nodo.elemento);
            PreOrden(nodo.Menor, lista);
            PreOrden(nodo.Mayor, lista);
        }
    }

    public void add(v elemento) {
        if (raiz == null) {
            raiz = new NodoBinarioDeBusqueda<>(elemento);
        }
        NodoBinarioDeBusqueda<v> aux = buscarNodo(elemento, raiz, new Lista<>());
        if (aux == null) {
            return;
        }
        if(elemento.compareTo(aux.elemento) < 0){
            aux.Menor = new NodoBinarioDeBusqueda<>(elemento);
        }else {
            aux.Mayor = new NodoBinarioDeBusqueda<>(elemento);
        }

    }

    public ArbolBinarioDeBusqueda<v> getSubArbolIzquierda() {
        ArbolBinarioDeBusqueda<v> iz = new ArbolBinarioDeBusqueda<>();
        iz.raiz = this.raiz.Menor;
        return iz;
    }

    public ArbolBinarioDeBusqueda<v> getSubArbolDerecha() {
        ArbolBinarioDeBusqueda<v> der = new ArbolBinarioDeBusqueda<>();
        der.raiz = this.raiz.Mayor;
        return der;
    }

    private NodoBinarioDeBusqueda<v> buscarNodo(v elemBuscado, NodoBinarioDeBusqueda<v> nodo, Lista<v> lista) {
        if(elemBuscado.compareTo(nodo.elemento) == 0) {
            lista.add(elemBuscado);
            return null;
        }
        if(elemBuscado.compareTo(nodo.elemento) < 0) {
            if(nodo.Menor != null){
                lista.add(nodo.elemento);
                return buscarNodo(elemBuscado, nodo.Menor, lista);
            }else{
                lista = null;
                return nodo;
            }
        }else {
            if(nodo.Mayor != null){
                lista.add(nodo.elemento);
                return buscarNodo(elemBuscado, nodo.Mayor, lista);
            }else{
                lista = null;
                return nodo;
            }
        }
    }
}
