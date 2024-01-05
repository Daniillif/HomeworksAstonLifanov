package lesson_4;

import java.util.Arrays;

public class Park {
    //Создать класс Park с внутренним классом, с помощью
    // объектов которого можно хранить информацию
    // об аттракционах, времени их работы и стоимости.
    private String name = "Strukovskiy";
    private Attraction[] attractions;

    public Park(String name, Attraction[] attractions) {
        this.name = name;
        this.attractions = attractions;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Attraction[] getAttractions() {
        return attractions;
    }

    public void setAttractions(Attraction[] attractions) {
        this.attractions = attractions;
    }

    @Override
    public String toString() {
        return "Park{" +
                "name='" + name + '\'' +
                ", attractions=" + Arrays.toString(attractions) +
                '}';
    }

    public static class Attraction{
        private String nameOfAttraction;
        private String timeOfWork;
        private double cost;

        public Attraction(String nameOfAttraction, String timeOfWork, double cost) {
            this.nameOfAttraction = nameOfAttraction;
            this.timeOfWork = timeOfWork;
            this.cost = cost;
        }

        @Override
        public String toString() {
            return "Attraction{" +
                    "nameOfAttraction='" + nameOfAttraction + '\'' +
                    ", timeOfWork='" + timeOfWork + '\'' +
                    ", cost=" + cost +
                    '}';
        }

    }

}
