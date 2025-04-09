package Sofia;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ArbolBinarioDeBusquedaTest {
    ArbolBinarioDeBusqueda<Integer> a = new ArbolBinarioDeBusqueda<>();

    @Test
    void getAltura() {
        assertEquals(0, a.getAltura());
        a.add(1);
        assertEquals(1, a.getAltura());
    }

    @Test
    void getListaDatosNivel() {
        a.add(0);
        a.add(5);
        a.add(3);
        a.add(8);
        a.add(-3);
        a.add(-5);
        Lista<Integer> lista = a.getListaDatosNivel(3);
        while (lista.primero != null) {
            System.out.println(lista.primero.dato);
            lista.primero = lista.primero.siguiente;
        }
    }

    @Test
    void isArbolHomogeneo() {
        assertFalse(a.isArbolHomogeneo());
        a.add(0);
        assertTrue(a.isArbolHomogeneo());
        a.add(5);
        a.add(8);
        a.add(-3);
        assertFalse(a.isArbolHomogeneo());
        ArbolBinarioDeBusqueda<Integer> b = new ArbolBinarioDeBusqueda<>();
        b.add(0);
        b.add(5);
        b.add(8);
        assertTrue(b.isArbolHomogeneo());
        ArbolBinarioDeBusqueda<Integer> c = new ArbolBinarioDeBusqueda<>();
        c.add(5);
        c.add(2);
        c.add(-3);
        assertTrue(c.isArbolHomogeneo());
    }

    @Test
    void isArbolCompleto() {
        assertFalse(a.isArbolCompleto());
        a.add(0);
        assertTrue(a.isArbolCompleto());
        a.add(5);
        a.add(-3);
        a.add(-2);
        a.add(-1);
        a.add(4);
        a.add(3);
        assertTrue(a.isArbolCompleto());
        a.add(8);
        assertFalse(a.isArbolCompleto());
    }

    @Test
    void isArbolCasiCompleto() {
    }

    @Test
    void getCamino() {
        Lista<Integer> l = a.getCamino(null);
        a.add(0);
        a.add(5);
        a.add(-1);
        a.add(8);
        Lista<Integer> c = a.getCamino(new NodoBinarioDeBusqueda<>(8));
        while(c.primero != null) {
            System.out.println(c.primero.dato);
            c.primero=c.primero.siguiente;
        }
    }

    @Test
    void getListaPreOrden() {
        a.add(0);
        a.add(5);
        a.add(-3);
        a.add(8);
        a.add(-2);
        a.add(1);
        Lista<Integer> l = a.getListaPreOrden();
        while(l.primero != null) {
            System.out.println(l.primero.dato);
            l.primero=l.primero.siguiente;
        }
    }

    @Test
    void getListaPostOrden() {
        a.add(0);
        a.add(5);
        a.add(-3);
        a.add(8);
        a.add(-2);
        a.add(1);
        Lista<Integer> l = a.getListaPostOrden();
        while(l.primero != null) {
            System.out.println(l.primero.dato);
            l.primero=l.primero.siguiente;
        }
    }

    @Test
    void getListaOrdenCentral() {
        a.add(0);
        a.add(5);
        a.add(-3);
        a.add(8);
        a.add(-2);
        a.add(1);
        Lista<Integer> l = a.getListaOrdenCentral();
        while(l.primero != null) {
            System.out.println(l.primero.dato);
            l.primero=l.primero.siguiente;
        }
    }

    @Test
    void add() {
        a.add(0);
        a.add(5);
        a.add(-3);
    }

    @Test
    void getSubArbolIzquierda() {
        ArbolBinarioDeBusqueda<Integer> e = a.getSubArbolIzquierda();
        a.add(0);
        a.add(5);
        a.add(-3);
        ArbolBinarioDeBusqueda<Integer> b = a.getSubArbolIzquierda();
        ArbolBinarioDeBusqueda<Integer> c = b.getSubArbolIzquierda();
        Lista<Integer> l = b.getListaPreOrden();
        while(l.primero != null) {
            System.out.println(l.primero.dato);
            l.primero=l.primero.siguiente;
        }
    }

    @Test
    void getSubArbolDerecha() {
        ArbolBinarioDeBusqueda<Integer> e = a.getSubArbolDerecha();
        a.add(0);
        a.add(5);
        a.add(-3);
        ArbolBinarioDeBusqueda<Integer> b = a.getSubArbolDerecha();
        ArbolBinarioDeBusqueda<Integer> c = b.getSubArbolDerecha();
        Lista<Integer> l = b.getListaPreOrden();
        while(l.primero != null) {
            System.out.println(l.primero.dato);
            l.primero=l.primero.siguiente;
        }
    }
}