package com.construct.parameterized;

import com.construct.util.ExcelUtil;
import org.testng.annotations.DataProvider;

public class Read_Parameter {

    @DataProvider(name = "login")
    public static Object[][] dataS() {
        return ExcelUtil.dataS("src/main/resources/TestCaseData/v1.xlsx", "sheet1", 2,
                7, 6, 7);
    }
}
