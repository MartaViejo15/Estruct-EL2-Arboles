package Sofia;

public class ArbolBinarioDeBusqueda<v extends Comparable<v>> {
    //atributo
    private NodoBinarioDeBusqueda<v> raiz;

    //constructor
    public ArbolBinarioDeBusqueda() {
        this.raiz = new NodoBinarioDeBusqueda<>(null);
    }

    //metodos
    public void add(v elemento) {
        if (raiz == null) {
            raiz = new NodoBinarioDeBusqueda<>(elemento);
        }
        if(elemento.compareTo(raiz.elemento)!=0) {
            NodoBinarioDeBusqueda<v> flotante = this.raiz;
            while (flotante != null) {
                if (elemento.compareTo(flotante.elemento) < 0) {
                    flotante=flotante.Menor;
                } else {
                    flotante = flotante.Mayor;
                }
            }
        }
    }
}
