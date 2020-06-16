package ru.netology.repository;

import ru.netology.domain.Afisha;

public class AfishaRepository {

    private Afisha[] items = new Afisha[0];

    public Afisha[] findAll() {
        return items;
    }

    public void save(Afisha item) {
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

    public void findById(int id) {
        Afisha[] tmp = new Afisha[1];
        int index = 0;
        for (Afisha item : items) {
            if (item.getId() == id) {
                tmp[index] = item;
                index++;
            }
        }
        items = tmp;
    }

    // наивная реализация
    public void removeById(int id) {
        int length = items.length - 1;
        Afisha[] tmp = new Afisha[length];
        int index = 0;
        for (Afisha item : items) {
            if (item.getId() != id) {
                tmp[index] = item;
                index++;
            }
        }
        // меняем наши элементы
        items = tmp;
    }

    public void removeAll() {
        items = new Afisha[0];
    }

}
