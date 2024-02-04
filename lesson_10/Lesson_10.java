package lesson_10;

import java.util.ArrayList;
import java.util.List;

public class Lesson_10 {
    public static void main(String[] args) {
        Box<Orange> box = new Box<>(new ArrayList<>(List.of(new Orange(), new Orange(), new Orange())));
        Box<Orange> orangeBox = new Box<>(new ArrayList<>(List.of(new Orange(), new Orange(), new Orange())));
        Box<Apple> appleBox = new Box<>(new ArrayList<>(List.of(new Apple(), new Apple(), new Apple(), new Apple())));
        Box<Apple> appleBox2 = new Box<>(new ArrayList<>(List.of(new Apple(), new Apple(), new Apple(), new Apple())));
        System.out.println(box.getWeight());
        System.out.println(appleBox.getWeight());
        System.out.println(box.compare(appleBox));
        appleBox.addFruit(new Apple());
        appleBox.addFruit(new Apple());
        box.addFruit(new Orange());
        System.out.println(box.getWeight());
        System.out.println(appleBox.getWeight());
        System.out.println(box.compare(appleBox));
        box.sprinkleToBox(orangeBox);
        appleBox.sprinkleToBox(appleBox2);
        System.out.println(appleBox.getWeight());
        System.out.println(box.getWeight());
       //orangeBox.sprinkleToBox(appleBox2);Дженерик не дает(проверка ,что разного типа фрукты нельзя сыпать)
    }
}
