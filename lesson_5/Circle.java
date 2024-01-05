package lesson_5;
public class Circle extends Figure {
    private int radius;
    public Circle(String colorLine, String colorInside, int radius) {
        super(colorLine, colorInside);
        if (radius == 0) {
            throw new IllegalArgumentException("радиус не может быть равен 0");
        } else this.radius = radius;
    }
    @Override
    public String toString() {
        return "Circle{" +
                "colorLine='" + colorLine + '\'' +
                ", colorInside='" + colorInside + '\'' + "  периметр = " +
                calculatePerimeter(radius) + "   площадь = " + calculateSquare(radius) +
                '}';
    }
}
