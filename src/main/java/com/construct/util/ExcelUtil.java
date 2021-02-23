package com.construct.util;

import org.apache.poi.ss.usermodel.*;

import java.io.File;

/**
 * 封装读取excel工具类
 */
public class ExcelUtil {
    /**
     * 支持传入连续的行连续的列
     *
     * @param excelPath 文件地址
     * @param sheetName sheet名称
     * @param startRow  开始行(行号非下标索引)
     * @param endRow    结束行(行号非下标索引)
     * @param startCell 开始列(列号非下标索引)
     * @param endCell   结束列(列号非下标索引)
     * @return
     */
    public static Object[][] dataS(String excelPath, String sheetName, int startRow, int endRow, int startCell, int endCell) {
        //String excelPath = "src/main/resources/TestCaseData/v1.xlsx";
        //准备一个二维数组存放数据
        Object[][] dataS = null;
        //获取文件路径
        File file = new File(excelPath);
        //获取workBook对象
        try {
            //存放获取到的数据Object[row][cell]读取到的是几行几列的数据
            dataS = new Object[endRow - startRow + 1][endCell - startCell + 1];
            //创建工作簿
            Workbook workbook = WorkbookFactory.create(file);
            //获取sheet对象
            Sheet sheet = workbook.getSheet(sheetName);
            //获取行
            for (int i = startRow; i <= endRow; i++) {
                Row row = sheet.getRow(i - 1);
                //获取列
                for (int j = startCell; j <= endCell; j++) {
                    Cell cell = row.getCell(j - 1, Row.MissingCellPolicy.CREATE_NULL_AS_BLANK);
                    //把值转换成为字符串
                    cell.setCellType(CellType.STRING);
                    //获取单元格的值
                    String cellValue = cell.getStringCellValue();
                    dataS[i - startRow][j - startCell] = cellValue;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return dataS;
    }

    public static void main(String[] args) {
        Object[][] dataS = dataS("src/main/resources/TestCaseData/v1.xlsx", "Sheet1", 3,
                5, 4, 5);
        for (Object[] objects : dataS) {
            for (Object object : objects) {
                System.out.print("{" + object + "}");
            }
            System.out.println();
        }
    }

}
