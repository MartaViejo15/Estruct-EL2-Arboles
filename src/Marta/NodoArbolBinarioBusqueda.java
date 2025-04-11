package Marta;

public class NodoArbolBinarioBusqueda<v> {
    protected v valor;
    protected NodoArbolBinarioBusqueda<v> menor;
    protected NodoArbolBinarioBusqueda<v> mayor;

    public NodoArbolBinarioBusqueda(v valor) {
        this.valor = valor;
    }
    public NodoArbolBinarioBusqueda<v> getMenor() {
        return menor;
    }
    public NodoArbolBinarioBusqueda<v> getMayor() {
        return mayor;
    }
    public int getGrado(){
        if (menor != null && mayor != null){
            return 2;
        } else if (menor != null || mayor != null){
            return 1;
        } else {
            return 0;
        }
    }
}
