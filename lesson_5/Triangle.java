package lesson_5;

public class Triangle extends Figure {
    private int a, b, c;
    //проверить условие на то, что сумма 2 сторон больше 3 стороны.
    public Triangle(String colorLine, String colorInside, int a, int b, int c) {
        super(colorLine, colorInside);
        if (a == 0 || b == 0 || c == 0) {
            throw new IllegalArgumentException("сторона не может быть равна 0");
        } else if (a + b < c || a + c < b || b + c < a) {
            throw new IllegalArgumentException("1 сторона не может превышать сумму 2 других сторон");
        } else {
            this.a = a;
            this.b = b;
            this.c = c;
        }
    }
    @Override
    public String toString() {
        return "Triangle{" +
                "colorLine='" + colorLine + '\'' +
                ", colorInside='" + colorInside + '\'' + "   периметр = " +
                calculatePerimeter(a,b,c) + "   площадь = " + calculateSquare(a,b,c) +
                '}';
    }
}
