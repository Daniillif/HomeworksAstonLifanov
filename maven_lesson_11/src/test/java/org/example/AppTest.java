package org.example;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

public class AppTest
{

    @ParameterizedTest
    @CsvSource({"1,1", "5,120", "3,6", "10,3628800"})
    void getFactorial(int a, int b) {
        Assertions.assertEquals(b, App.getFactorial(a));
    }
    @Test
    void assertGroup(){
        int [] numbers = {1,5,3,10};
        Assertions.assertAll("numbers",()->Assertions.assertEquals(1,App.getFactorial(numbers[0])),
                ()->Assertions.assertEquals(120,App.getFactorial(numbers[1])),
                ()->Assertions.assertEquals(6,App.getFactorial(numbers[2])),
                ()->Assertions.assertEquals(3628800,App.getFactorial(numbers[3])));
    }
}
