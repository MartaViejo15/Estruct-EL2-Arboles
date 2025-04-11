import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class ListaTest {

    @Test
    void add() {
        Lista<Integer> lista = new Lista<>();
        assertTrue(lista.add(1));
        assertTrue(lista.add(2));
        assertTrue(lista.add(3));
    }

    @Test
    void delete() {
        Lista<String> lista = new Lista<>();
        lista.add("no");
        lista.add("si");
        lista.add("oh");
        lista.add("fla");
        lista.add("mo");
        assertTrue(lista.delete("no"));
        assertTrue(lista.delete("fla"));
        assertTrue(lista.delete("mo"));
        assertTrue(lista.delete("si"));
        assertFalse(lista.delete("no"));
        assertTrue(lista.delete("oh"));
        assertFalse(lista.delete("fla"));
    }
}