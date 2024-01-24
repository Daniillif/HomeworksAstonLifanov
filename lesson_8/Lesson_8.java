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
        TreeSet<String> set = new TreeSet<>(Arrays.asList(words));
        set.stream().forEach(x-> System.out.println(x + " встречается в уникальной коллекции 1 раз"));
    }
}

