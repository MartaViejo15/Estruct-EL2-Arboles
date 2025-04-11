import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ArbolBinarioDeBusquedaTest {


    @Test
    void getAltura() {
        ArbolBinarioDeBusqueda<Integer> arbol = new ArbolBinarioDeBusqueda<>();
        arbol.add(1);
        assertEquals(1, arbol.getAltura());
    }

    @Test
    void getCamino() {
        ArbolBinarioDeBusqueda<Integer> arbol = new ArbolBinarioDeBusqueda<>();
        arbol.getCamino(null);
        arbol.add(0);
        arbol.getCamino(new NodoBinarioDeBusqueda<>(8));
        arbol.add(3);
        arbol.add(2);
        arbol.getCamino(new NodoBinarioDeBusqueda<>(1));
        arbol.add(5);
        arbol.add(-1);
        arbol.add(8);
        Lista<Integer> c = arbol.getCamino(new NodoBinarioDeBusqueda<>(8));
        while(c.primero != null) {
            System.out.println(c.primero.dato);
            c.primero=c.primero.siguiente;
        }
        Lista<Integer> c2 = arbol.getCamino(new NodoBinarioDeBusqueda<>(2));
        while(c2.primero != null) {
            System.out.println(c2.primero.dato);
            c2.primero=c2.primero.siguiente;


        }
    }



    @Test
    void getListaPreOrden() {
        ArbolBinarioDeBusqueda<Integer> arbol = new ArbolBinarioDeBusqueda<>();
        arbol.add(0);
        arbol.add(5);
        arbol.add(-3);
        arbol.add(8);
        arbol.add(-2);
        arbol.add(1);
        Lista<Integer> l = arbol.getListaPreOrden(arbol.raiz);
        while(l.primero != null) {
            System.out.println(l.primero.dato);
            l.primero=l.primero.siguiente;
        }

    }

    @Test
    void getListaOrdenCentral() {
        ArbolBinarioDeBusqueda<Integer> arbol = new ArbolBinarioDeBusqueda<>();
        arbol.add(0);
        arbol.add(5);
        arbol.add(-3);
        arbol.add(8);
        arbol.add(-2);
        arbol.add(1);
        Lista<Integer> l = arbol.getListaOrdenCentral(arbol.raiz);
        while(l.primero != null) {
            System.out.println(l.primero.dato);
            l.primero=l.primero.siguiente;
        }
    }

    @Test
    void getListaPostOrden() {
        ArbolBinarioDeBusqueda<Integer> arbol = new ArbolBinarioDeBusqueda<>();
        arbol.add(0);
        arbol.add(5);
        arbol.add(-3);
        arbol.add(8);
        arbol.add(-2);
        arbol.add(1);
        Lista<Integer> l = arbol.getListaPostOrden(arbol.raiz);
        while(l.primero != null) {
            System.out.println(l.primero.dato);
            l.primero=l.primero.siguiente;
        }
    }

    @Test
    void getListaDatosNivel() {
        ArbolBinarioDeBusqueda<Integer> arbol = new ArbolBinarioDeBusqueda<>();
        arbol.add(0);
        arbol.add(5);
        arbol.add(3);
        arbol.add(8);
        arbol.add(-3);
        arbol.add(-5);
        arbol.getListaDatosNivel(0);
        Lista<Integer> lista = arbol.getListaDatosNivel(3);
        while (lista.primero != null) {
            System.out.println(lista.primero.dato);
            lista.primero = lista.primero.siguiente;
        }
    }

    @Test
    void isArbolHomogeneo() {
        ArbolBinarioDeBusqueda<Integer> arbol = new ArbolBinarioDeBusqueda<>();
        assertFalse(arbol.isArbolHomogeneo());
        arbol.add(0);
        assertTrue(arbol.isArbolHomogeneo());
        arbol.add(5);
        arbol.add(8);
        arbol.add(-3);
        assertFalse(arbol.isArbolHomogeneo());
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
        ArbolBinarioDeBusqueda<Integer> arbol = new ArbolBinarioDeBusqueda<>();
        assertFalse(arbol.isArbolCompleto());
        arbol.add(0);
        assertTrue(arbol.isArbolCompleto());
        arbol.add(5);
        arbol.add(-3);
        arbol.add(-2);
        arbol.add(-1);
        arbol.add(4);
        arbol.add(3);
        assertTrue(arbol.isArbolCompleto());
        arbol.add(8);
        assertFalse(arbol.isArbolCompleto());
    }

    @Test
    void isArbolCasiCompleto() {
        ArbolBinarioDeBusqueda<Integer> arbol = new ArbolBinarioDeBusqueda<>();
        assertFalse(arbol.isArbolCasiCompleto());
        arbol.add(10);
        arbol.add(5);
        arbol.add(15);
        arbol.add(2);
        arbol.add(7);
        arbol.add(1);
        assertFalse(arbol.isArbolCasiCompleto());
        arbol.add(12);
        assertTrue(arbol.isArbolCasiCompleto());
    }

    @Test
    void add() {
        ArbolBinarioDeBusqueda<Integer> arbol = new ArbolBinarioDeBusqueda<>();
        arbol.add(0);
        arbol.add(5);
        arbol.add(-3);
    }

    @Test
    void insertar() {
        ArbolBinarioDeBusqueda<Integer> arbol = new ArbolBinarioDeBusqueda<>();
        arbol.insertar(arbol.raiz, 10);
        arbol.insertar(arbol.raiz, 5);
        arbol.insertar(arbol.raiz, 2);
        arbol.insertar(arbol.raiz, 15);

    }

    @Test
    void getSubArbolIzquierda() {
        ArbolBinarioDeBusqueda<Integer> arbol = new ArbolBinarioDeBusqueda<>();
        ArbolBinarioDeBusqueda<Integer> e = arbol.getSubArbolIzquierda();
        arbol.getSubArbolIzquierda();
        arbol.add(0);
        arbol.add(5);
        arbol.add(-3);
        ArbolBinarioDeBusqueda<Integer> b = arbol.getSubArbolIzquierda();
        ArbolBinarioDeBusqueda<Integer> c = b.getSubArbolIzquierda();
        Lista<Integer> l = b.getListaPreOrden(arbol.raiz);
        while(l.primero != null) {
            System.out.println(l.primero.dato);
            l.primero=l.primero.siguiente;
        }
    }

    @Test
    void getSubArbolDerecha() {
        ArbolBinarioDeBusqueda<Integer> arbol = new ArbolBinarioDeBusqueda<>();
        arbol.getSubArbolDerecha();
        arbol.add(0);
        arbol.add(5);
        arbol.add(-3);
        ArbolBinarioDeBusqueda<Integer> b = arbol.getSubArbolDerecha();
        ArbolBinarioDeBusqueda<Integer> c = b.getSubArbolDerecha();
        Lista<Integer> l = b.getListaPreOrden(arbol.raiz);
        while(l.primero != null) {
            System.out.println(l.primero.dato);
            l.primero=l.primero.siguiente;
        }
    }
}

