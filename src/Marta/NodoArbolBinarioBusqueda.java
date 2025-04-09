package Marta;

public class NodoArbolBinarioBusqueda<v> {
    protected v valor;
    private NodoArbolBinarioBusqueda<v> menor;
    private NodoArbolBinarioBusqueda<v> mayor;

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
    /*
    public int getAltura(){
        int contador = 0;
        if (menor == null && mayor == null){   // Solo está la raíz
            contador = 1;
        } else if (menor != null && mayor != null){   // Tiene hijos mayor y menor
            contador += 1;
        } else if (menor != null && mayor == null){   // Tiene hijo menor
            contador += 1;
        } else if (menor == null && mayor != null){   // Tiene hijo mayor
            contador += 1;
        }
        return contador;
    }
     */
}
