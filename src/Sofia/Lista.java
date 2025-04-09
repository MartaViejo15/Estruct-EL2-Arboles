package Sofia;

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
}
