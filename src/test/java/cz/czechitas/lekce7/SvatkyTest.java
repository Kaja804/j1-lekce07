package cz.czechitas.lekce7;

import org.junit.jupiter.api.Test;

import java.time.Month;
import java.time.MonthDay;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Filip Jirsák
 */
class SvatkyTest {

    /**
     * Testuje metodu {@link Svatky#vratKdyMaSvatek(String)}
     */
    @Test
    void kdyMaSvatek() {
        Svatky svatky = new Svatky();
        assertEquals(MonthDay.of(5, 18), svatky.vratKdyMaSvatek("Nataša"));
        assertNull(svatky.vratKdyMaSvatek("Eva"));
    }

    /**
     * Testuje metodu {@link Svatky#jeVSeznamu(String)}
     */
    @Test
    void jeVSeznamu() {
        Svatky svatky = new Svatky();
        // assertEquals(true, svatky.jeVSeznamu("Valdemar"));
        assertTrue(svatky.jeVSeznamu("Filip"));
        assertFalse(svatky.jeVSeznamu("Eva"));
        //TODO Otestovat, že najde v seznamu existující jméno a nenajde neexistující jméno
    }

    /**
     * Testuje metodu {@link Svatky#getPocetJmen()}
     */
    @Test
    void getPocetJmen() {
        Svatky svatky = new Svatky();
        assertEquals(37, svatky.getPocetJmen());
        //TODO Otestovat, že vrací počet jmen, která máme v seznamu
    }

    /**
     * Testuje metodu {@link Svatky#getSeznamJmen()}
     */
    @Test
    void getSeznamJmen() {
        Svatky svatky = new Svatky();
        int pocet = svatky.getSeznamJmen().size();
        assertEquals(37,pocet);
        //TODO Zkontrolovat, že seznam jmen má správný počet položek.
    }

    /**
     * Testuje metodu {@link Svatky#pridejSvatek(String, int, int)}
     */
    @Test
    void pridatSvatekDenMesicInt() {
        Svatky svatky = new Svatky();
        svatky.pridejSvatek("Eva",24,12);
        assertTrue(svatky.jeVSeznamu("Eva"));
        assertEquals(MonthDay.of(12, 24), svatky.vratKdyMaSvatek("Eva"));
        //TODO Otestuje, že je jméno v seznamu svátků a že má přiřazen správný den
    }

    /**
     * Testuje metodu {@link Svatky#pridejSvatek(String, int, Month)}
     */
    @Test
    void pridatSvatekDenMesicMonth() {
        Svatky svatky = new Svatky();
        svatky.pridejSvatek("Adam",24,Month.DECEMBER);
        assertTrue(svatky.jeVSeznamu("Adam"));
        assertEquals(MonthDay.of(12, 24), svatky.vratKdyMaSvatek("Adam"));
        //TODO Otestuje, že je jméno v seznamu svátků a že má přiřazen správný den
    }

    /**
     * Testuje metodu {@link Svatky#pridejSvatek(String, MonthDay)}
     */
    @Test
    void prridatSvatekMonthDay() {
        Svatky svatky = new Svatky();
        svatky.pridejSvatek("Dalibor",MonthDay.of(6,4));
        svatky.pridejSvatek("Karolína",MonthDay.of(Month.JULY, 14));
        assertTrue(svatky.jeVSeznamu("Dalibor"));
        assertTrue(svatky.jeVSeznamu("Karolína"));
        assertEquals(MonthDay.of(7,14), svatky.vratKdyMaSvatek("Karolína"));
        assertEquals(MonthDay.of(6,4), svatky.vratKdyMaSvatek("Dalibor"));
        //TODO Otestuje, že je jméno v seznamu svátků a že má přiřazen správný den
    }

    /**
     * Testuje metodu {@link Svatky#smazSvatek(String)}
     */
    @Test
    void smazatSvatek() {
        Svatky svatky = new Svatky();
        svatky.smazSvatek("Nataša");
        assertEquals(36, svatky.getPocetJmen());
        //TODO Zkontrolovat, že po smazání bude počet svátků odpovídat novému počtu.
    }
}
