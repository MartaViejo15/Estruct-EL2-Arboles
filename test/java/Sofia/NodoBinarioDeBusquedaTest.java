package Sofia;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NodoBinarioDeBusquedaTest {

    @Test
    void getGrado() {
        ArbolBinarioDeBusqueda<Integer> arbol = new ArbolBinarioDeBusqueda<>();
        arbol.add(1);
        assertEquals(0,arbol.raiz.getGrado());
        arbol.add(2);
        assertEquals(1,arbol.raiz.getGrado());
        arbol.add(0);
        assertEquals(2,arbol.raiz.getGrado());
        arbol.add(-1);
        assertEquals(1,arbol.raiz.Menor.getGrado());
    }
}