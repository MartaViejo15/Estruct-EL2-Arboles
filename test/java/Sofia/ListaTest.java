package Sofia;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ListaTest {

    @Test
    void add() {
        Lista<Integer> lista = new Lista<>();
        assertTrue(lista.add(1));
        assertTrue(lista.add(2));
        assertTrue(lista.add(3));
    }
}