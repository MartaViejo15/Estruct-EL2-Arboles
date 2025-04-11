package Robert;

import javax.swing.table.TableRowSorter;

public class NodoArbol<k extends Comparable<k>,v> {
    protected k clave;
    protected v valor;
    protected NodoArbol<k,v> menor;
    protected NodoArbol<k,v> mayor;

    public NodoArbol(k clave, v valor) {
        this.clave = clave;
        this.valor = valor;

    }

    public k getClave() {
        return clave;
    }
    public void setClave(k clave) {
        this.clave = clave;
    }

    public v getValor() {
        return valor;
    }
    public void setValor(v valor) {
        this.valor = valor;
    }

    public NodoArbol<k,v> getMenor() {
        return menor;
    }
    public void setMenor(NodoArbol<k,v> menor) {
        this.menor = menor;
    }

    public NodoArbol<k,v> getMayor() {
        return mayor;
    }
    public void setMayor(NodoArbol<k,v> mayor) {
        this.mayor = mayor;
    }

    public int getGrado(){
        if(menor != null && mayor != null){
            return 2;
        }else if(this.menor != null || mayor != null){
            return 1;
        }else
            return 0;
    }
}


