package ru.netology.manager;

import ru.netology.domain.Afisha;
import ru.netology.repository.AfishaRepository;

import java.text.spi.BreakIteratorProvider;

public class AfishaManager {

    private AfishaRepository repository;
    private int defaultAfishaLength = 10;
    private int customAfishaLength;

    public AfishaManager(AfishaRepository repository) {
        this.repository = repository;
    }

    public AfishaManager(AfishaRepository repository, int customAfishaLength) {
        this.customAfishaLength = customAfishaLength;
        this.repository = repository;
    }

    public void addMovie(Afisha item) {
        repository.save(item);
    }

    public Afisha[] getAll() {
        Afisha[] items = repository.findAll();
        int length = items.length;

        if (customAfishaLength <= 0) {
            if (defaultAfishaLength < length) {
                length = defaultAfishaLength;
            }
        } else {
            if (customAfishaLength < length) {
                length = customAfishaLength;
            }
        }

        Afisha[] result = new Afisha[length];
        // перебираем массив в прямом порядке
        // но кладём в результаты в обратном
        for (int i = 0; i < result.length; i++) {
            int index = items.length - i - 1;
            result[i] = items[index];
        }
        return result;
    }

}
