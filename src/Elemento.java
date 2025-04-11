public class Elemento<v> {
    //atributo
    protected v dato;
    protected Elemento<v> siguiente;

    //constructor
    protected Elemento(v dato) {
        this.dato = dato;
    }

}
