package Marta;

public class NodoArbolBinarioBusqueda<v> {
    private v valor;
    private NodoArbolBinarioBusqueda<v> menor;
    private NodoArbolBinarioBusqueda<v> mayor;

    public NodoArbolBinarioBusqueda(v valor) {
        this.valor = valor;
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
    public int getAltura(){

    }
}
