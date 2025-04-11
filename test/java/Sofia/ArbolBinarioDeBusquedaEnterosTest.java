package Sofia;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ArbolBinarioDeBusquedaEnterosTest {
    ArbolBinarioDeBusquedaEnteros a = new ArbolBinarioDeBusquedaEnteros();

    @Test
    void getSuma_OrdenCentral() {
        a.add(1);
        a.add(2);
        a.add(3);
        assertEquals(6,a.getSuma_OrdenCentral());
    }

    @Test
    void getSuma_PreOrden() {
        a.add(1);
        a.add(2);
        a.add(3);
        assertEquals(6,a.getSuma_PreOrden());
    }

    @Test
    void getSuma_PostOrden() {
        a.add(1);
        a.add(2);
        a.add(3);
        assertEquals(6,a.getSuma_PostOrden());
    }

    @Test
    void convertir() {
        ArbolBinarioDeBusqueda<Integer> b = new ArbolBinarioDeBusqueda<>();
        a.convertir(b);
    }
}