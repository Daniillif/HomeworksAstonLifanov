package lesson_7;

import java.util.Arrays;

import static lesson_7.Lesson_7.sumArray;

public class Lesson_7 {
    public static void main(String[] args) throws MyArraySizeException {
        String[][] arrayOfStrings = {{"3", "1", "1", "1"}, {"2", "2", "2", "7"}, {"5", "1", "1", "1"}, {"2", "2", "2", "2"}};
        System.out.printf("Сумма передаваемого массива равна %d",sumArray(arrayOfStrings));
    }
    public static int sumArray(String[][] arrOfStrings) throws MyArraySizeException, MyArrayDataException {
        int count = 0;
        for (int i = 0; i < arrOfStrings.length; i++) {
                if (arrOfStrings[i].length == 4) {
                    count++;
                } else
                    throw new MyArraySizeException("Количество элементов в массиве  " + i + "  не равно 4");

        }
        if (count != 4) {
            throw new MyArraySizeException("Размер массива не соответствует заявленным [4][4]");
        }
        int[][] arrInt = new int[4][4];
        int sumElements = 0;
        for (int i = 0; i < arrOfStrings.length; i++) {
            for (int j = 0; j < arrOfStrings[i].length; j++) {
                try {
                    sumElements += Integer.parseInt(arrOfStrings[i][j]);
                } catch (NumberFormatException ex) {
                    System.out.println(ex.getMessage());
                    throw new MyArrayDataException(String.format("Не произошел парсинг в ячейке [%d][%d]",i,j));
                }
            }
        }
        return sumElements;
    }
}
