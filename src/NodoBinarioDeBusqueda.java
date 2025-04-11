public class NodoBinarioDeBusqueda<v extends Comparable<v>> {
    //atributo
    protected v elemento;
    protected NodoBinarioDeBusqueda<v> Menor;
    protected NodoBinarioDeBusqueda<v> Mayor;

    //constructor
    public NodoBinarioDeBusqueda(v elemento) {
        this.elemento = elemento;
    }

    //metodos
    public int getGrado(){
        if (Menor == null && Mayor == null){
            return 0;
        }
        if (Menor == null || Mayor == null){
            return 1;
        }
        else{
            return 2;
        }
    }
}
