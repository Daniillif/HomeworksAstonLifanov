package lesson_5;

public class Lesson_5 {
    public static void main(String[] args) {
        Cat cat1 = new Cat("Musa");
        Cat cat2 = new Cat("KisA");
        Cat cat3 = new Cat("lUSA");
        Cat cat4 = new Cat("Grisha");
        Dog dog1 = new Dog("Boba");
        Dog dog2 = new Dog("Boba");
        Dog dog3 = new Dog("Boba");
        Dog dog4 = new Dog("Boba");
        System.out.println(cat2.getCat_count());
        System.out.println(dog1.getDog_count());
        dog3.run(150);
        dog3.run(1000);
        cat2.run(150);
        cat2.run(201);
        cat2.swim();
        dog3.swim(12);
        dog3.swim(9);
        Cat.Plate plate = new Cat.Plate(10);
        Cat[] cats = {cat1, cat2, cat3, cat4};
        for (Cat cat : cats) {
            System.out.println(plate.getNumInPlate() + " кусочков корма осталось в миске");
            cat.toEat(plate);
            System.out.println(cat.name + "  не голодна " + cat.isNot_hungry());
        }
        System.out.println(plate.getNumInPlate() + " еды осталось в миске");
        System.out.println("\n\n\n\n");
        Triangle triangle = new Triangle("yellow", "blue", 3, 4, 6);
        Rectangle rectangle = new Rectangle("red", "green", 2, 5);
        Circle circle = new Circle("orange", "black ", 6);
        System.out.println(triangle);
        System.out.println(rectangle);
        System.out.println(circle);
    }

}
