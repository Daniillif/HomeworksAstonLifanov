package lesson_5;

public class Animal {
    protected String name;
    protected int canRun;
    protected int canSwim;
    protected static int animal_count = 0;

    public Animal() {
        animal_count++;
    }

    public Animal(String name, int canRun, int canSwim) {
        this.name = name;
        this.canRun = canRun;
        this.canSwim=canSwim;
        animal_count++;
    }

    public int getAnimal_count() {
        return animal_count;
    }

    public void run(int len) {

    }

    public void swim() {

    }


}
