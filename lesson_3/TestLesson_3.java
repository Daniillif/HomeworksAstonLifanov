package lesson_3;

import java.util.Arrays;

import static lesson_3.Lesson_3.*;

public class TestLesson_3 {
    public static void main(String[] args) {
        System.out.println(isSimple(1,2));
        isPositive(2);
        System.out.println(isNegative(-12));
        multipleString("Hello World.", 5);
        System.out.println(isLeapYear(2003));
        System.out.println(Arrays.toString(returnArray(7,7)));
    }
}
