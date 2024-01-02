package lesson_5;

public class Cat extends Animal {
    private static int cat_count = 0;
    private boolean not_hungry;
    private int need_to_eat=10;


    public Cat(String name) {
        super(name,200,0);
        cat_count++;
    }

    public int getCat_count() {
        return cat_count;
    }

    @Override
    public void run(int len) {
        if(len<0){
            System.out.println("Не бывает такого расстояния.");
        }
        else if(len<=this.canRun){
        System.out.println(name + " пробежал " + len + " метров.");
        }else
            System.out.println("Не пробежит.");
    }

    @Override
    public void swim() {
        System.out.println(name + " не умеет плавать.");
    }
    //Расширить задачу, добавив для котов возможность кушать из миски, выполнив следующие пункты:
    //Сделать так, чтобы в миске с едой не могло получиться отрицательного количества еды (например, в миске 10 еды, а кот пытается покушать 15-20).
    //Каждому коту нужно добавить поле сытость (когда создаем котов, они голодны). Если коту удалось покушать (хватило еды), сытость = true.
    //Считаем, что если коту мало еды в миске, то он её просто не трогает, то есть не может быть наполовину сыт (это сделано для упрощения логики программы).
    //Создать массив котов и миску с едой, попросить всех котов покушать из этой миски и потом вывести информацию о сытости котов в консоль.
    //Добавить метод, с помощью которого можно было бы добавлять еду в миску.

    public static class Plate {
        private int numInPlate;

        public Plate(int numInPlate) {
            this.numInPlate = numInPlate;
        }

        public int getNumInPlate() {
            return numInPlate;
        }

        public void setNumInPlate(int numInPlate) {
            this.numInPlate = numInPlate;
        }
    }
public void toEat(Plate plate){
        if(plate.getNumInPlate()<getNeed_to_eat()){
            System.out.println("Котику " + name + " не хватило покушать.");
            setNot_hungry(false);
            addMeal(plate);
        }else {
            System.out.println(name + " покушала и осталась довольна.");
            plate.setNumInPlate(plate.getNumInPlate() - getNeed_to_eat());
            setNot_hungry(true);
}
    }

    public boolean isNot_hungry() {
        return not_hungry;
    }

    public void setNot_hungry(boolean not_hungry) {
        this.not_hungry = not_hungry;
    }

    public int getNeed_to_eat() {
        return need_to_eat;
    }

    public void setNeed_to_eat(int need_to_eat) {
        this.need_to_eat = need_to_eat;
    }
    public void addMeal(Plate plate){
        plate.setNumInPlate(plate.getNumInPlate() + 30);
    }
}


