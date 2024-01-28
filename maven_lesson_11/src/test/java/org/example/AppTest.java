package org.example;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.Arrays;

@Test()
public class AppTest extends Assert{

    @DataProvider
    public Integer[][] data() {
        return new Integer[][]{{1,1},{5,120},{10,3628800}};
        }


    @Test(dataProvider = "data")
    public void test(int actual, int expected) {
        Assert.assertEquals(App.getFactorial(actual), expected);
    }
}