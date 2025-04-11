import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ArbolBinarioDeBusquedaEnterosTest {

    @Test
    void getSuma() {
        ArbolBinarioDeBusquedaEnteros arbol = new ArbolBinarioDeBusquedaEnteros();
        arbol.add(50);
        arbol.add(20);
        arbol.add(5);
        arbol.add(17);
        arbol.getSuma();
    }

    @Test
    void convertir() {
        ArbolBinarioDeBusqueda<Integer> arbol = new ArbolBinarioDeBusqueda();
        ArbolBinarioDeBusquedaEnteros arbol2 = new ArbolBinarioDeBusquedaEnteros();
        arbol.add(10);
        arbol.add(20);
        arbol.add(5);
        arbol2.convertir(arbol);
    }
}