package ru.netology.manager;

import ru.netology.domain.Afisha;

public class AfishaManager {

    private Afisha[] items = new Afisha[0];
    private int defaultAfishaLength = 10;
    private int customAfishaLength;

    public AfishaManager() {
    }

    public AfishaManager(int customAfishaLength) {
        this.customAfishaLength = customAfishaLength;
    }

    public void addMovie(Afisha item) {
        // создаём новый массив размером на единицу больше
        int length = items.length + 1;
        Afisha[] tmp = new Afisha[length];
        // itar + tab
        // копируем поэлементно
        // for (int i = 0; i < items.length; i++) {
        //   tmp[i] = items[i];
        // }
        System.arraycopy(items, 0, tmp, 0, items.length);
        // кладём последним наш элемент
        int lastIndex = tmp.length - 1;
        tmp[lastIndex] = item;
        items = tmp;
    }

    public Afisha[] getAll() {
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
