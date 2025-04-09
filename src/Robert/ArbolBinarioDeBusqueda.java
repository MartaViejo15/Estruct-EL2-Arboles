package Robert;

public class ArbolBinarioDeBusqueda<k extends Comparable<k>, v> {
    protected NodoArbol<k,v> raiz;

    public ArbolBinarioDeBusqueda() {
        raiz = null;
    }

    private boolean buscarNodoAInsertar(NodoArbol<k,v> nuevo,NodoArbol<k, v> nodo){
        NodoArbol<k,v> aux = nodo;
        if(nodo.getClave().compareTo(nuevo.getClave()) == 0){
            System.out.println("El nodo se encuentra en el arbol");
            return false;
        }
        if(nodo.getClave().compareTo(nuevo.getClave()) < 0){
            if(nodo.getMenor() == null){
                nodo.setMenor(nuevo);
                return true;
            }else{
                buscarNodoAInsertar(nuevo,aux.getMenor());
            }
        }
        if(nodo.getClave().compareTo(nuevo.getClave()) > 0){
            if(nodo.getMayor() == null){
                nodo.setMayor(nuevo);
                return true;
            }else{
                buscarNodoAInsertar(nuevo,aux.getMayor());
            }
        }
        return false;
    }

    private boolean añadirNodoRaiz(NodoArbol<k,v> nuevo){
        this.raiz = nuevo;
        return true;
    }

    public boolean añadirNodoArboles(NodoArbol<k,v> nuevo){
        NodoArbol<k,v> aux = this.raiz;
        if(this.raiz == null){
            this.añadirNodoRaiz(nuevo);
            return true;
        }else{
            buscarNodoAInsertar(nuevo,aux);
        }
        return false;
    }

    public ListaSE<k> getCamino(NodoArbol<k,v> nodoFinal){
        ListaSE<k> camino = new ListaSE<>();
        buscarNodoCamino(this.raiz, nodoFinal,camino);
        return camino;
    }
    private boolean buscarNodoCamino(NodoArbol<k,v> actual, NodoArbol<k,v> buscado, ListaSE<k> lista){
        NodoArbol<k,v> aux = actual;
        if(aux == null){
            return false;
        }else{
            lista.add(aux.getClave());
            if(aux.getClave().compareTo(buscado.getClave()) == 0){
                return true;
            }
            if(aux.getClave().compareTo(buscado.getClave()) < 0){
                return buscarNodoCamino(aux.getMenor(),buscado,lista);
            }else if(aux.getClave().compareTo(buscado.getClave()) > 0){
                return buscarNodoCamino(aux.getMayor(),buscado,lista);
            }
        }
        return false;
    }


    public int getAltura() {
        return calcularAltura(this.raiz);
    }
    private int calcularAltura(NodoArbol<k,v> nodo){
        if(nodo == null){
            return 0;
        }else{
            NodoArbol<k,v> aux = nodo;
            int alturaIzq = calcularAltura(aux.getMenor());
            int alturaDer = calcularAltura(aux.getMayor());
            if(alturaIzq > alturaDer){
                return 1 + alturaIzq;
            } else if (alturaIzq < alturaDer) {
                return 1 + alturaDer;
            } else {
                return 1 + alturaIzq;
            }
        }
    }


    public lista getListaDatosNivel(nivel){

    }

    public boolean isArbolHomogeneo(){
        return esHomogeneo(this.raiz);
    }
    private boolean esHomogeneo(NodoArbol<k,v> nodo){
        NodoArbol<k,v> aux = nodo;
        if(nodo == null){
            return false;
        }else{
            if(aux.getGrado() == 0){
                return true;
            }
            if(aux.getGrado() != 0){
                int grado = aux.getGrado();
                if
            }
        }
    }

    public ArbolBinarioDeBusqueda<k,v> getSubArbolIzquierda(){
        ArbolBinarioDeBusqueda<k,v> subArbolIzq = new ArbolBinarioDeBusqueda<>();
        subArbolIzq.raiz = this.raiz.getMenor();
        return subArbolIzq;
    }

    public ArbolBinarioDeBusqueda<k,v> getSubArbolDerecha(){
        ArbolBinarioDeBusqueda<k,v> subArbolDer = new ArbolBinarioDeBusqueda<>();
        subArbolDer.raiz = this.raiz.getMayor();
        return subArbolDer;
    }

    public ListaSE<k> getListaPreOrden(){
        ListaSE<k> lista = new ListaSE<>();
        preOrden(this.raiz,lista);
        return lista;
    }
    private void preOrden(NodoArbol<k,v> nodo, ListaSE<k> lista){
        if(nodo != null){
            lista.add(nodo.getClave());
            preOrden(nodo.getMenor(),lista);
            preOrden(nodo.getMayor(),lista);
        }
    }

    public ListaSE<k> getListaPostOrden(){
        ListaSE<k> lista = new ListaSE<>();
        postOrden(this.raiz,lista);
        return lista;
    }
    private void postOrden(NodoArbol<k,v> nodo, ListaSE<k> lista){
        if(nodo != null){
            postOrden(nodo.getMenor(),lista);
            postOrden(nodo.getMayor(),lista);
            System.out.println(nodo.getMayor());
        }
    }

    public ListaSE<k> getListaOrdenCentral(){
        ListaSE<k> lista = new ListaSE<>();
        ordenCentral(this.raiz,lista);
        return lista;
    }
    private void ordenCentral(NodoArbol<k,v> nodo, ListaSE<k> lista){
        ordenCentral(nodo.getMenor(),lista);
        lista.add(nodo.getClave());
        ordenCentral(nodo.getMayor(),lista);
    }
}

