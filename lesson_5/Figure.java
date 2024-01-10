package lesson_5;

public abstract class Figure implements Perimeter,Square{
    //Задание 2:
    //Применяя интерфейсы написать программу расчета периметра и площади геометрических фигур: круг, прямоугольник, треугольник.
    //Задать для каждой фигуры цвет заливки и цвет границы.
    //Результат полученных характеристик [ Периметр, площадь, цвет фона, цвет границ ] по каждой фигуре вывести в консоль.
    //Попробуйте реализовать базовые методы, такие как расчет периметра фигур, в качестве дефолтных методов в интерфейсе.
protected String colorLine;
protected String colorInside;
    public Figure(String colorLine, String colorInside) {
        this.colorLine = colorLine;
        this.colorInside = colorInside;
    }
    public String getColorLine() {
        return colorLine;
    }
    public void setColorLine(String colorLine) {
        this.colorLine = colorLine;
    }
    public String getColorInside() {
        return colorInside;
    }
    public void setColorInside(String colorInside) {
        this.colorInside = colorInside;
    }
}
