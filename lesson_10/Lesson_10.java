package lesson_10;

import java.util.ArrayList;
import java.util.List;

public class Lesson_10 {
    public static void main(String[] args) {
        Box<Orange> box = new Box<>(new ArrayList<>(List.of(new Orange(), new Orange(), new Orange())));
        Box<Apple> appleBox = new Box<>(new ArrayList<>(List.of(new Apple(), new Apple(), new Apple(), new Apple())));
        System.out.println(box.getWeight());
        System.out.println(appleBox.getWeight());
        System.out.println(box.compare(appleBox));
        appleBox.addFruit(new Apple());
        appleBox.addFruit(new Apple());
        box.addFruit(new Orange());
        System.out.println(box.getWeight());
        System.out.println(appleBox.getWeight());
        System.out.println(box.compare(appleBox));

    }
}
