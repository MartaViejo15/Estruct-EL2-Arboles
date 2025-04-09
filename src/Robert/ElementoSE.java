package Robert;

public class ElementoSE<T> {
    private T dato;
    private ElementoSE<T> siguiente;

    public ElementoSE(T elemento){
        this.dato = elemento;
    }

    public T getDato(){
        return dato;
    }
    public void setDato(T elemento){
        this.dato = elemento;
    }

    public ElementoSE<T> getSiguiente(){
        return siguiente;
    }
    public void setSiguiente(ElementoSE<T> siguiente){
        this.siguiente = siguiente;
    }

    public String toString(){
        return dato.toString();
    }
}
