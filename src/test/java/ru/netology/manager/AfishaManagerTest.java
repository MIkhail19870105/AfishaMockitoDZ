package ru.netology.manager;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Afisha;

import static org.junit.jupiter.api.Assertions.*;

class AfishaManagerTest {
    AfishaManager manager;
    AfishaManager managerCustom;


    private Afisha first = new Afisha(1, "Inception", "fantastic");
    private Afisha second = new Afisha(2, "Titanic", "drama");
    private Afisha third = new Afisha(3, "Leon", "thriller");
    private Afisha fourth = new Afisha(4, "Shindler's List", "biography");
    private Afisha fifth = new Afisha(5, "Godfather", "criminal");
    private Afisha sixth = new Afisha(6, "Pianist", "war");
    private Afisha seventh = new Afisha(7, "Lord of the Rings", "fantasy");
    private Afisha eighth = new Afisha(8, "Shutter Island", "detective");
    private Afisha ninth = new Afisha(9, "Some Like it Hot", "comedy");
    private Afisha tenth = new Afisha(10, "12 monkeys", "fantastic");
    private Afisha eleventh = new Afisha(11, "Interstellar", "fantastic");

    @BeforeEach
    void setUp() {
        manager = new AfishaManager();
        manager.addMovie(first);
        manager.addMovie(second);
        manager.addMovie(third);
        manager.addMovie(fourth);
        manager.addMovie(fifth);
        manager.addMovie(sixth);
        manager.addMovie(seventh);
        manager.addMovie(eighth);
        manager.addMovie(ninth);//


        managerCustom = new AfishaManager(5);
        managerCustom.addMovie(first);
        managerCustom.addMovie(second);
        managerCustom.addMovie(third);
        managerCustom.addMovie(fourth);
        managerCustom.addMovie(fifth);

    }


    @Test
    void getLastTenDefaultManager() {
        manager.addMovie(tenth);
        Afisha[] actual = manager.getAll();
        Afisha[] expected = new Afisha[]{tenth, ninth, eighth, seventh, sixth, fifth, fourth, third, second, first};
        assertArrayEquals(expected, actual);
    }

    @Test
    void getLastTenFromElevenDefaultManager() {
        manager.addMovie(tenth);
        manager.addMovie(eleventh);
        Afisha[] actual = manager.getAll();
        Afisha[] expected = new Afisha[]{eleventh, tenth, ninth, eighth, seventh, sixth, fifth, fourth, third, second};
        assertArrayEquals(expected, actual);
    }

    @Test
    void getAllMoviesDefaultManager() {
        Afisha[] actual = manager.getAll();
        Afisha[] expected = new Afisha[]{ninth, eighth, seventh, sixth, fifth, fourth, third, second, first};
        assertArrayEquals(expected, actual);
    }

    @Test
    void getLastFiveCustomManager() {
        Afisha[] actual = managerCustom.getAll();
        Afisha[] expected = new Afisha[]{fifth, fourth, third, second, first};
        assertArrayEquals(actual, expected);
    }

    @Test
    void getLastFiveCustomManagerIfAddMore() {
        managerCustom.addMovie(sixth);
        managerCustom.addMovie(seventh);
        managerCustom.addMovie(eighth);
        managerCustom.addMovie(ninth);
        managerCustom.addMovie(tenth);
        Afisha[] actual = managerCustom.getAll();
        Afisha[] expected = new Afisha[]{tenth, ninth, eighth, seventh, sixth};
        assertArrayEquals(expected, actual);
    }

    @Test
    void getLastFiveCustomAfishaLengthIfEqualsNull() {
        manager = new AfishaManager(0);
        Afisha[] actual = managerCustom.getAll();
        Afisha[] expected = new Afisha[]{fifth, fourth, third, second, first};
        assertArrayEquals(actual, expected);
    }

    @Test
    void getLastFiveCustomAfishaLengthIfIncorrectUnderMax() {
        manager = new AfishaManager(100);
        Afisha[] actual = managerCustom.getAll();
        Afisha[] expected = new Afisha[]{fifth, fourth, third, second, first};
        assertArrayEquals(actual, expected);
    }

    @Test
    void getLastFiveCustomAfishaLengthIfOverMin() {
        manager = new AfishaManager(-20);
        Afisha[] actual = managerCustom.getAll();
        Afisha[] expected = new Afisha[]{fifth, fourth, third, second, first};
        assertArrayEquals(actual, expected);
    }

    @Test
    void getLastDefaultAfishaLengthIfOnlyOneFilm() {
        manager = new AfishaManager(1);
        manager.addMovie(fifth);
        Afisha[] actual = manager.getAll();
        Afisha[] expected = new Afisha[]{fifth};
        assertArrayEquals(expected, actual);
    }


}