package lesson_5;

import java.sql.SQLOutput;

public class Rectangle extends Figure {
    private int a;
    private int b;

    public Rectangle(String colorLine, String colorInside, int a, int b) {
        super(colorLine, colorInside);
        if (a == 0 || b == 0) {
            throw new IllegalArgumentException("сторона не может быть равна 0");

        } else {
            this.a = a;
            this.b = b;
        }
    }






    @Override
    public String toString() {
        return "Rectangle{" +
                "colorLine='" + colorLine + '\'' +
                ", colorInside='" + colorInside + '\'' + "  периметр = " +
               calculatePerimeter(a,b) + "   площадь = " + calculateSquare(a,b) +
                '}';
    }
}
