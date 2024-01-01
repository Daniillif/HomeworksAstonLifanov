package lesson_3;

import java.util.Arrays;

public class Lesson_3 {
    public static boolean isSimple(int a, int b) {
        if (a + b >= 10 && a + b <= 20) {
            return true;
        } else
            return false;
    }

    public static void isPositive(int a) {
        if (a >= 0) {
            System.out.println("Положительное число");
        } else
            System.out.println("Отрицательное число");
    }

    public static boolean isNegative(int a) {
        if (a < 0) {
            return true;
        } else
            return false;
    }

    public static void multipleString(String str, int x) {
        for (int i = 0; i < x; i++) {
            if (i != (x - 1)) {
                System.out.print(str + " ");
            } else
                System.out.println(str);
        }

    }

    public static boolean isLeapYear(int year) {
        if ((year % 4 == 0 && year % 100 != 0) || year % 400 == 0) {
            return true;
        } else
            return false;
    }

    public static void main(String[] args) {
        //task6Задать целочисленный массив, состоящий из элементов 0 и 1.
        // Например: [ 1, 1, 0, 0, 1, 0, 1, 1, 0, 0 ]. С помощью цикла и условия заменить 0 на 1,
        // 1 на 0;
        int[] num = {1, 0, 0, 0, 1, 0, 0, 0, 1, 1, 1};
        for (int i = 0; i < num.length; i++) {
            if (num[i] == 1) {
                num[i] = 0;
            } else
                num[i] = 1;
        }
        System.out.println(Arrays.toString(num));


        //task7 Задать пустой целочисленный массив длиной 100.
        // С помощью цикла заполнить его значениями 1 2 3 4 5 6 7 8 ... 100;
        int[] empty = new int[100];
        System.out.println(Arrays.toString(empty));
        System.out.println();
        for (int i = 0; i < 100; i++) {
            empty[i] = i + 1;
        }
        System.out.println(Arrays.toString(empty));

        //task8. Задать массив [ 1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1 ] пройти по нему циклом,
        // и числа меньшие 6 умножить на 2;
        int[] x = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        for (int i = 0; i < x.length; i++) {
            if (x[i] < 6) {
                x[i] = x[i] * 2;
            }
        }
        System.out.println(Arrays.toString(x));
        System.out.println();
        //task9 Создать квадратный двумерный целочисленный массив
        //и с помощью цикла(-ов) заполнить его диагональные элементы единицами
        int n = 5;
        int[][] square = new int[n][n];
        for (int i = 0; i < n; i++) {

            for (int j = 0; j < n; j++) {
                square[i][j] = 0;
            }
            System.out.println(Arrays.toString(square[i]));
        }
        System.out.println();
        int count=1;
        //заполнение единицами
        for (int i = 0; i < n; i++) {

            for (int j = 0; j < n; j++) {
                if (j == i) {
                    square[i][j] = 1;
                    square[i][square[i].length-count]=1;
                    count++;
                }
            }
            System.out.println(Arrays.toString(square[i]));
        }
        System.out.println();


    }
    //task10
    //Написать метод, принимающий на вход два аргумента: len и initialValue,
    // и возвращающий одномерный массив типа int длиной len,
    // каждая ячейка которого равна initialValue.
    public static int[] returnArray(int len, int initialValue){
        int[] num = new int[len];
        for (int i = 0; i < len; i++) {
            num[i]=initialValue;
        }return num;
    }


}
