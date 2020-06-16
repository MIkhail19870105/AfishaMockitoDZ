package ru.netology.repository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Afisha;

import static org.junit.jupiter.api.Assertions.*;

class AfishaRepositoryTest {

    private AfishaRepository repository = new AfishaRepository();
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
    public void setUp(){
        repository.save(first);
        repository.save(second);
        repository.save(third);
        repository.save(fourth);
        repository.save(fifth);
        repository.save(sixth);
        repository.save(seventh);
        repository.save(eighth);
        repository.save(ninth);
    }


    @Test
    void shouldSave(){
        repository.save(tenth);
        Afisha[]actual = repository.findAll();
        Afisha[]expected = new Afisha[]{tenth};
        assertArrayEquals(expected,actual);
    }

    @Test
    void shouldFindByIdInRepo(){
        int idToFind = 6;
        repository.findById(idToFind);
        Afisha[] actual = repository.findAll();
        Afisha[] expected = new  Afisha[]{seventh};
        assertArrayEquals(expected,actual);
    }

    @Test
    void shouldRemoveByIdIfCorrectId(){
        int idToRemove = 2;
        repository.removeById(idToRemove);
        Afisha[] actual = repository.findAll();
        Afisha[] expected = new  Afisha[]{seventh};
        assertArrayEquals(expected,actual);
    }

    @Test
    void shouldNotRemoveIfIncorrectId(){
        int idToRemove = 25;
        repository.removeById(idToRemove);
        Afisha[]actual = repository.findAll();
        Afisha[]expected = new Afisha[]{first,second,third,fourth,fifth,sixth,seventh,eighth,ninth};
        assertArrayEquals(expected,actual);
    }

    @Test
    void shouldRemoveAllFromRepository(){
        Afisha[]actual = repository.findAll();
        Afisha[]expected = new Afisha[]{};
        assertArrayEquals(expected,actual);
    }

}