package Marta;

public class Lista<v> {
    protected Elemento<v> cabeza;
    protected int numElementos;

    public Lista() {
        cabeza = null;
        numElementos = 0;
    }

    public boolean add(v elemento) {
        Elemento<v> temporal = new Elemento<>(elemento);
        if(this.cabeza == null){
            this.cabeza = temporal;
        }else{
            Elemento<v> aux = this.cabeza;
            while(aux.getSiguiente() != null){
                aux = aux.getSiguiente();
            }
            aux.setSiguiente(temporal);
            numElementos++;
        }
        return true;
    }
}
