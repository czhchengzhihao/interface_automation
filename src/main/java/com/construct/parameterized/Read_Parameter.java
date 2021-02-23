package com.construct.parameterized;

import com.construct.util.ExcelUtil;
import org.testng.annotations.DataProvider;

public class Read_Parameter {

    @DataProvider(name = "login")
    public static Object[][] login() {
        return ExcelUtil.continuousDataS("src/main/resources/TestCaseData/v1.xlsx", "sheet1", 2,
                7, 5, 7);
    }
    @DataProvider(name = "login_1")
    public static Object[][] login_1() {
        int[] rows = {2, 3, 4, 5, 6, 7};
        int[] cells = {6, 7};
        Object[][] dataS = ExcelUtil.DiscreteDataS("src/main/resources/TestCaseData/v1.xlsx", "sheet1", rows, cells);
        return dataS;
    }
}
