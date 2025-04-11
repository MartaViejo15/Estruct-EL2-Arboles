public class Lista<v> {
    //atributos
    protected Elemento<v> primero;
    protected int N_elementos;

    //constructor
    public Lista() {
        primero = null;
        N_elementos = 0;
    }

    //metodo
    public boolean add(v elemento) {
        Elemento<v> temporal = new Elemento<>(elemento);
        if (primero == null) {
            primero = temporal;
        } else {
            Elemento<v> aux = primero;
            while(aux.siguiente != null) {
                aux = aux.siguiente;
            }
            aux.siguiente=temporal;
        }
        N_elementos++;
        return true;
    }

    public boolean delete(v elemento) {
        Elemento<v> aux = primero;
        if (aux == null) {
            return false;
        }
        if (aux.dato == elemento) {
            primero = aux.siguiente;
            N_elementos--;
            return true;
        }
        while(aux.siguiente != null) {
            if (aux.siguiente.dato == elemento) {
                aux.siguiente = aux.siguiente.siguiente;
                this.N_elementos--;
                return true;
            }
            aux = aux.siguiente;
        }
        return false;
    }
}
