package Sofia;

public class ArbolBinarioDeBusquedaEnteros extends ArbolBinarioDeBusqueda<Integer>{
    //constructor
    public ArbolBinarioDeBusquedaEnteros() {
        super();
    }

    //metodo
    public int getSuma_OrdenCentral() {
        int suma = 0;
        Lista<Integer> lista = getListaOrdenCentral();
        while(lista.primero != null){
            suma += lista.primero.dato;
            lista.primero = lista.primero.siguiente;
        }
        return suma;
    }

    public int getSuma_PreOrden() {
        int suma = 0;
        Lista<Integer> lista = getListaPreOrden();
        while(lista.primero != null){
            suma += lista.primero.dato;
            lista.primero = lista.primero.siguiente;
        }
        return suma;
    }

    public int getSuma_PostOrden() {
        int suma = 0;
        Lista<Integer> lista = getListaPostOrden();
        while(lista.primero != null){
            suma += lista.primero.dato;
            lista.primero = lista.primero.siguiente;
        }
        return suma;
    }
}
