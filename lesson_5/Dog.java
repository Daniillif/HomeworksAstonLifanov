package lesson_5;

public class Dog extends Animal {
    private static int dog_count = 0;

    public Dog(String name) {
        super(name,500,10);
        dog_count++;
    }

    public int getDog_count() {
        return dog_count;
    }

    @Override
    public void run(int len) {
        if(len<=this.canRun){
        System.out.println(name + " пробежал " + len + " метров.");
        }else
            System.out.println("Не пробежит.");

    }


    public void swim(int len) {
        if(len<0){
            System.out.println("Не бывает такого расстояния.");
        }
        else if(len<=this.canRun) {
            System.out.println(name + " проплыл " + canSwim + " метров.");
        }else
            System.out.println("Не проплывет.");
    }
}
