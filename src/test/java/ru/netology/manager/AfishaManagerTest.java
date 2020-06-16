package ru.netology.manager;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import ru.netology.domain.Afisha;
import ru.netology.repository.AfishaRepository;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class AfishaManagerTest {
    @Mock

    AfishaRepository repository;

    @InjectMocks

    AfishaManager manager = new AfishaManager(repository);
    AfishaManager managerCustom = new AfishaManager(repository, 5);

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

        manager = new AfishaManager(repository);
        managerCustom = new AfishaManager(repository, 5);

    }

    @Test
    void addMovie() {
        manager.addMovie(first);
        manager.addMovie(second);
        manager.addMovie(third);
        manager.addMovie(fourth);

        Afisha[] returned = new Afisha[]{first, second, third, fourth};
        doReturn(returned).when(repository).findAll();
        Afisha[] actual = manager.getAll();
        Afisha[] expected = new Afisha[]{fourth, third, second, first};
        assertArrayEquals(expected, actual);
        verify(repository, times(1)).findAll();

    }

    @Test
    void getLastTenDefaultManager() {
        Afisha[] returned = new Afisha[]{first, second, third, fourth, fifth, sixth, seventh, eighth, ninth, tenth};
        doReturn(returned).when(repository).findAll();
        Afisha[] actual = manager.getAll();
        Afisha[] expected = new Afisha[]{tenth, ninth, eighth, seventh, sixth, fifth, fourth, third, second, first};
        assertArrayEquals(expected, actual);
        verify(repository, times(1)).findAll();
    }

    @Test
    void getLastTenFromElevenDefaultManager() {
        Afisha[] returned = new Afisha[]{first, second, third, fourth, fifth, sixth, seventh, eighth, ninth, tenth, eleventh};
        doReturn(returned).when(repository).findAll();
        Afisha[] actual = manager.getAll();
        Afisha[] expected = new Afisha[]{eleventh, tenth, ninth, eighth, seventh, sixth, fifth, fourth, third, second};
        assertArrayEquals(expected, actual);
        verify(repository, times(1)).findAll();
    }

    @Test
    void getAllMoviesDefaultManager() {
        Afisha[] returned = new Afisha[]{first, second, third, fourth, fifth, sixth, seventh, eighth, ninth};
        doReturn(returned).when(repository).findAll();
        Afisha[] actual = manager.getAll();
        Afisha[] expected = new Afisha[]{ninth, eighth, seventh, sixth, fifth, fourth, third, second, first};
        assertArrayEquals(expected, actual);
        verify(repository, times(1)).findAll();
    }

    @Test
    void getLastFiveCustomManager() {
        Afisha[] returned = new Afisha[]{first, second, third, fourth, fifth};
        doReturn(returned).when(repository).findAll();
        Afisha[] actual = managerCustom.getAll();
        Afisha[] expected = new Afisha[]{fifth, fourth, third, second, first};
        assertArrayEquals(actual, expected);
        verify(repository, times(1)).findAll();
    }

    @Test
    void getLastFiveCustomManagerIfAddMore() {
        Afisha[] returned = new Afisha[]{first, second, third, fourth, fifth, sixth, seventh, eighth, ninth, tenth};
        doReturn(returned).when(repository).findAll();
        Afisha[] actual = managerCustom.getAll();
        Afisha[] expected = new Afisha[]{tenth, ninth, eighth, seventh, sixth};
        assertArrayEquals(expected, actual);
        verify(repository, times(1)).findAll();
    }

    @Test
    void getLastFiveCustomAfishaLengthIfEqualsNull() {
        manager = new AfishaManager(repository, 0);
        Afisha[] returned = new Afisha[]{first, second, third, fourth, fifth};
        doReturn(returned).when(repository).findAll();
        Afisha[] actual = managerCustom.getAll();
        Afisha[] expected = new Afisha[]{fifth, fourth, third, second, first};
        assertArrayEquals(actual, expected);
        verify(repository, times(1)).findAll();
    }

    @Test
    void getLastFiveCustomAfishaLengthIfIncorrectUnderMax() {
        manager = new AfishaManager(repository, 100);
        Afisha[] returned = new Afisha[]{first, second, third, fourth, fifth};
        doReturn(returned).when(repository).findAll();
        Afisha[] actual = managerCustom.getAll();
        Afisha[] expected = new Afisha[]{fifth, fourth, third, second, first};
        assertArrayEquals(actual, expected);
        verify(repository, times(1)).findAll();
    }

    @Test
    void getLastFiveCustomAfishaLengthIfOverMin() {
        manager = new AfishaManager(repository, -20);
        Afisha[] returned = new Afisha[]{first, second, third, fourth, fifth};
        doReturn(returned).when(repository).findAll();
        Afisha[] actual = managerCustom.getAll();
        Afisha[] expected = new Afisha[]{fifth, fourth, third, second, first};
        assertArrayEquals(actual, expected);
        verify(repository, times(1)).findAll();
    }

    @Test
    void getLastDefaultAfishaLengthIfOnlyOneFilm() {
        manager = new AfishaManager(repository, 1);
        Afisha[] returned = new Afisha[]{fifth};
        doReturn(returned).when(repository).findAll();
        Afisha[] actual = manager.getAll();
        Afisha[] expected = new Afisha[]{fifth};
        assertArrayEquals(expected, actual);
        verify(repository, times(1)).findAll();
    }


}