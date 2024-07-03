package data;

import org.testng.annotations.DataProvider;

public class StaticDataProvider {

    @DataProvider(name = "dataIntForDivTest", parallel = true)
    public static Object[][] dataForIntDivTest() {
        return new Object[][]{
                {-6, -2, 3},
                {6, 2, 3},
                {-6, 2, -3}
        };
    }

    @DataProvider(name = "dataForDoubleDivTest", parallel = true)
    public static Object[][] dataForDoubleDivTest() {
        return new Object[][]{
                {-6.2, -3.1, 2.0},
                {6.2, 3.1, 2.0},
                {-6.2, 3.1, -2.0}
        };
    }
}