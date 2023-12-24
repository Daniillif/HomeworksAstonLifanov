package lesson_4;

public class Park {
    //Создать класс Park с внутренним классом, с помощью
    // объектов которого можно хранить информацию
    // об аттракционах, времени их работы и стоимости.
    private String name = "Strukovskiy";
    public class Attraction{
        private String nameOfAttraction;
        private String timeOfWork;
        private double cost;
    }
}
