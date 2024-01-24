package lesson_8;

import java.util.*;

public class TelephoneCollection {
    //Написать простой класс Телефонный Справочник, который хранит
    // в себе список фамилий и телефонных номеров.
    // В этот телефонный справочник с помощью метода add() можно добавлять записи,
    // а с помощью метода get() искать номер телефона по фамилии.
    // Следует учесть, что под одной фамилией может
    // быть несколько телефонов (в случае однофамильцев),
    // тогда при запросе такой фамилии должны выводиться все телефоны.
    private Map<String, ArrayList<String>> telephoneDirectory;

    public TelephoneCollection() {
        Map<String, ArrayList<String>> map = new HashMap<>();
        this.telephoneDirectory = map;
    }

    public TelephoneCollection(HashMap<String, ArrayList<String>> telephoneDirectory) {
        this.telephoneDirectory = telephoneDirectory;
    }

    public void add(String surname, String phone) {

        if (!this.telephoneDirectory.containsKey(surname)) {
            this.telephoneDirectory.put(surname, new ArrayList<>(List.of(phone)));
        } else
            telephoneDirectory.get(surname).add(phone);
    }

    public void get(String surname) {
        System.out.println(Arrays.toString(this.telephoneDirectory.get(surname).toArray()));
    }

    public void deleteLast(String surname) {
        if (this.telephoneDirectory.containsKey(surname)) {
            this.telephoneDirectory.get(surname).remove(this.telephoneDirectory.get(surname).size() - 1);
        }
    }

    public void printAllDirectory() {
        this.telephoneDirectory.forEach((key, value) -> System.out.println("Фамилия :" + key + ", телефон:" + Arrays.toString(value.toArray())));
    }
}
