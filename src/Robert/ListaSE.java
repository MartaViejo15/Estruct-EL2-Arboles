package Robert;

public class ListaSE<T> {
    protected ElementoSE<T> cabeza;
    protected int numElementos;

    public ListaSE() {
        cabeza = null;
        numElementos = 0;
    }

    public boolean add(T elemento) {
        ElementoSE<T> temporal = new ElementoSE<>(elemento);
        if(this.cabeza == null){
            this.cabeza = temporal;
        }else{
            ElementoSE<T> aux = this.cabeza;
            while(aux.getSiguiente() != null){
                aux = aux.getSiguiente();
            }
            aux.setSiguiente(temporal);
            numElementos++;
        }
        return true;
    }


    public String toString(){
        String temporal = " ";
        ElementoSE<T> aux = this.cabeza;
        if(cabeza == null){
            return "Lista vacia";
        }else{
            temporal = aux.toString();
            while(aux.getSiguiente() != null) {
                aux = aux.getSiguiente();
                temporal += ", " + aux.toString();
            }
        }
    return temporal;
    }
}
