package com.construct.util;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.*;
import org.testng.annotations.DataProvider;

import java.io.File;
import java.io.IOException;

public class ExcelUtil {
    public static Object[][] dataS() {
        String excelPath = "src/main/resources/TestCaseData/v1.xlsx";
        //准备一个二维数组存放数据
        Object[][] dataS = null;
        //获取文件路径
        File file = new File(excelPath);
        //获取workBook对象
        try {
            Workbook workbook = WorkbookFactory.create(file);
            //获取sheet对象
            Sheet sheet = workbook.getSheet("Sheet1");
            //存放获取到的数据
            dataS = new Object[6][2];
            //获取行
            for (int i = 1; i <= 6; i++) {
                Row row = sheet.getRow(i);
                //获取列
                for (int j = 3; j <= 4; j++) {
                    Cell cell = row.getCell(j, Row.MissingCellPolicy.CREATE_NULL_AS_BLANK);
                    //把值转换成为字符串
                    cell.setCellType(CellType.STRING);
                    String cellValue = cell.getStringCellValue();
                    dataS[i - 1][j - 3] = cellValue;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return dataS;
    }

    public static void main(String[] args) {
        Object[][] dataS = dataS();
        for (Object[] objects : dataS) {
            for (Object object : objects) {
                System.out.print("{" + object + "}");
            }
            System.out.println();
        }
    }

}
