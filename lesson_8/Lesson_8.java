package lesson_8;

import java.util.*;

public class Lesson_8 {
    public static void main(String[] args) {


        String[] words = {"Apple", "Orange", "Melon", "Strawberry", "Lemon", "Greypfruit", "Mango", "Apple", "Lemon", "Dragon fruit", "Melon"};
        //вывод уникальных значений
        uniqueWords(words);
        //подсчет колва повторов
        countOfFruits(words);

        TelephoneCollection telephoneCollection = new TelephoneCollection();
        telephoneCollection.add("Lifanov", "89993593345");
        telephoneCollection.get("Lifanov");
        telephoneCollection.add("Lifanov", "89993593345");
        telephoneCollection.get("Lifanov");
        telephoneCollection.printAllDirectory();
        telephoneCollection.deleteLast("Lifanov");
        telephoneCollection.get("Lifanov");
        telephoneCollection.add("Pushkin", "89999999999");
        telephoneCollection.add("Pushkin", "89997777777");
        telephoneCollection.add("Dostoevskiy", "89997777777");
        telephoneCollection.add("Krylov", "89997777777");
        telephoneCollection.printAllDirectory();

    }

    public static void uniqueWords(String[] words) {
        TreeSet<String> set = new TreeSet<>(Arrays.asList(words));
        System.out.println(set);
    }

    public static void countOfFruits(String[] words) {
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < words.length; i++) {
            if (!map.containsKey(words[i])) {
                map.put(words[i], 1);
            } else {
                map.put(words[i], map.get(words[i]) + 1);
            }
        }
        map.forEach((key, value) -> System.out.printf("Такого фрукта - %s в списке слов :%d шт  \n", key, value));
    }
}

