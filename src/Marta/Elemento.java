package Marta;

public class Elemento<v> {
    private v dato;
    private Elemento<v> siguiente;

    public Elemento(v elemento){
        this.dato = elemento;
    }
    public v getDato(){
        return dato;
    }
    public void setDato(v elemento){
        this.dato = elemento;
    }
    public Elemento<v> getSiguiente(){
        return siguiente;
    }
    public void setSiguiente(Elemento<v> siguiente){
        this.siguiente = siguiente;
    }
}
