package lesson_6;

import java.io.*;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Lesson_6 {
    //Реализовать сохранение данных в csv файл; Реализовать загрузку данных из csv файла. Файл читается целиком.
    //Структура csv файла:
    //Строка заголовок с набором столбцов
    //Набор строк с целочисленными значениями
    //Разделитель между столбцами - символ точка с запятой (;)
    //(Пример см. на скриншоте)
    //Для хранения данных использовать класс вида:
    //public class AppData {
    //   private String[] header;
    //   private int[][] data;
    //}
    //Если выполняется save(AppData data), то старые данные в файле полностью перезаписываются.
    public static void main(String[] args) throws IOException {
        String[] header = {"Value 1", "Value 2", "Value 3"};
        int[][] data  = {
                {100, 200, 123},
                {300, 400, 500}
        };
        AppData appData = new AppData(header,data);
        save(appData);
        AppData newapp = loadData();
        System.out.println(Arrays.toString(newapp.getHeader())+"\n");
        for (int i = 0; i < newapp.getData().length; i++) {
            System.out.println(Arrays.toString(newapp.getData()[i]));
        }


    }

    public static void save(AppData appData) throws IOException {

        FileWriter fileWriter = new FileWriter("output.csv");
        for (int i = 0; i < appData.getHeader().length; i++) {
            if (i <= appData.getHeader().length - 2) {
                fileWriter.write(appData.getHeader()[i] + ";");
            } else
                fileWriter.write(appData.getHeader()[i] + "\n");
        }
        for (int i = 0; i < appData.getData().length; i++) {
            for (int j = 0; j < appData.getData()[0].length; j++) {
                if (j <= appData.getData()[0].length - 2) {
                    fileWriter.write(appData.getData()[i][j] + ";");
                } else {
                    fileWriter.write(appData.getData()[i][j] + "\n");
                }
            }
        }


        fileWriter.close();

    }
    public static AppData loadData() throws FileNotFoundException {
        //чтение

        Scanner scanner = new Scanner(new File("output.csv"));
        String header= scanner.nextLine();
        String[] header_result = header.split(";");
        ArrayList<String> data= new ArrayList<>();
        while(scanner.hasNextLine()){
            data.add(scanner.nextLine());
        }
        int[][] data_result = new int[data.size()][header_result.length];
        for (int i = 0; i < data_result.length; i++) {
            String[] data_string = data.get(i).split(";");
            for (int j = 0; j < data_string.length; j++) {
                data_result[i][j] = Integer.parseInt(data_string[j]);
            }
            }
        scanner.close();
        return new AppData(header_result,data_result);
    }
}