public class ArbolBinarioDeBusqueda <v extends Comparable<v>> {
    protected NodoBinarioDeBusqueda<v> raiz;

    public ArbolBinarioDeBusqueda() {
        this.raiz = null;
    }
    public int getAltura(){
        Lista<v> ListaElem = getListaPreOrden(raiz);
        Lista<v> aux = new Lista<>();
        while (ListaElem.primero != null) {
            Lista<v> camino = getCamino(new NodoBinarioDeBusqueda<>(ListaElem.primero.dato));
            if (aux.N_elementos < camino.N_elementos) {
                aux = camino;
            }
            ListaElem.primero = ListaElem.primero.siguiente;
        }
        return aux.N_elementos;
    }

    public Lista<v> getCamino(NodoBinarioDeBusqueda<v> destino){
        Lista<v> lista = new Lista<>();
        if(raiz == null){
            return lista;
        }
        buscarNodo(destino.elemento, raiz, lista);
        return lista;
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

    public Boolean isArbolHomogeneo(){
        if(this.raiz == null){
            return false;
        }
        Lista<v> l = new Lista<>();
        homogeneo(raiz.getGrado(), raiz, l);
        return l.N_elementos==0;
    }
    private void homogeneo(int n, NodoBinarioDeBusqueda<v> nodo, Lista<v> l) {
        if(nodo.getGrado()!=0){
            if(nodo.getGrado() != n){
                l.add(nodo.elemento);
            }else{
                if(nodo.Menor != null){
                    homogeneo(n, nodo.Menor, l);
                }if(nodo.Mayor != null){
                    homogeneo(n, nodo.Mayor, l);}
            }
        }
    }

    public boolean isArbolCompleto(){
        if(this.raiz == null){
            return false;
        }
        Lista<v> res = new Lista<>();
        Completo(this,res);
        return res.N_elementos==0;
    }
    private void Completo(ArbolBinarioDeBusqueda<v> arbol, Lista<v> res) {
        if(arbol.raiz.getGrado()!=0){
            if(arbol.raiz.getGrado() == 2 && arbol.getSubArbolDerecha().getAltura()!=arbol.getSubArbolIzquierda().getAltura()){
                res.add(arbol.raiz.elemento);
            }else{
                if(arbol.getSubArbolDerecha() != null) {
                    Completo(arbol.getSubArbolDerecha(), res);
                }if(arbol.getSubArbolIzquierda() != null) {
                    Completo(arbol.getSubArbolIzquierda(), res);
                }
            }
        }
    }

    public boolean isArbolCasiCompleto(){
        if(this.raiz == null){
            return false;
        }
        Lista<v> res = new Lista<>();
        CasiCompleto(raiz ,res);
        return res.N_elementos+1 == getAltura();
    }
    private void CasiCompleto(NodoBinarioDeBusqueda<v> n, Lista<v> l) {
        if(n != null){
            if(n.getGrado() == 0){
                Lista<v> aux = getCamino(n);
                if(l.N_elementos==0){
                    while(aux.primero != null){
                        l.add(aux.primero.dato);
                        aux.primero = aux.primero.siguiente;
                    }
                }if (aux.N_elementos < l.N_elementos){
                    while (l.primero != null){
                        l.delete(l.primero.dato);
                    }while (aux.primero != null){
                        l.add(aux.primero.dato);
                        aux.primero = aux.primero.siguiente;
                    }
                }
            }
            CasiCompleto(n.Menor, l);
            CasiCompleto(n.Mayor, l);
        }
    }

    public void add(v valor){
        raiz = insertar(raiz, valor);
    }
    public NodoBinarioDeBusqueda<v> insertar(NodoBinarioDeBusqueda<v> nodo, v valor){
        if (nodo == null){
            return new NodoBinarioDeBusqueda<>(valor);
        } else if (valor.compareTo(nodo.elemento) < 0){
            nodo.Menor = insertar(nodo.Menor, valor);
        } else {
            nodo.Mayor = insertar(nodo.Mayor, valor);
        }
        return nodo;
    }

    public ArbolBinarioDeBusqueda<v> getSubArbolIzquierda() {
        if(raiz == null || raiz.Menor == null){
            return null;
        }
        ArbolBinarioDeBusqueda<v> iz = new ArbolBinarioDeBusqueda<>();
        iz.raiz = this.raiz.Menor;
        return iz;
    }

    public ArbolBinarioDeBusqueda<v> getSubArbolDerecha() {
        if(raiz == null || raiz.Mayor == null){
            return null;
        }
        ArbolBinarioDeBusqueda<v> der = new ArbolBinarioDeBusqueda<>();
        der.raiz = this.raiz.Mayor;
        return der;
    }
}

