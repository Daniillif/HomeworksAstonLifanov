package lesson_5;

import java.sql.SQLOutput;

public class Circle extends Figure {
    private int radius;

    public Circle(String colorLine, String colorInside, int radius) {
        super(colorLine, colorInside);
        if (radius == 0) {
            throw new IllegalArgumentException("радиус не может быть равен 0");
        } else this.radius = radius;
    }

    @Override
    public double calculatePerimeter() {
        return 2 * Math.PI * radius;
    }

    @Override
    public double calculateSquare() {
        return Math.PI * Math.pow(radius, 2);
    }

    @Override
    public String toString() {
        return "Circle{" +
                "colorLine='" + colorLine + '\'' +
                ", colorInside='" + colorInside + '\'' + "  периметр = " +
                this.calculatePerimeter() + "   площадь = " + this.calculateSquare() +
                '}';
    }
}
