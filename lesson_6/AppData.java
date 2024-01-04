package lesson_6;

import java.io.*;
import java.util.Scanner;

public class AppData implements Serializable {
    private String[] header ;
    private int[][] data ;
    public AppData() {
    }

    public AppData(String[] header, int[][] data) {
        this.header = header;
        this.data = data;
    }



    public String[] getHeader() {
        return header;
    }

    public int[][] getData() {
        return data;
    }
}
