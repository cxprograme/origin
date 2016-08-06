package com.codecrane.core.util;

import org.apache.commons.io.FilenameUtils;
import org.apache.commons.lang3.time.DateFormatUtils;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * Excel工具之读取
 * Created by crane on 16/3/20.
 */
public class ExcelReader {

    protected static final String dateFmtPattern = "yyyy-MM-dd HH:mm:ss";


    /**
     * 读取excel文件（同时支持2003和2007格式）
     *
     * @param fileName 文件名，绝对路径
     * @return list中的map的key是列的序号
     * @throws Exception io异常等
     */
    public static List<Map<String, String>> readExcel(String fileName) throws Exception {
        FileInputStream fis = null;
        Workbook wb = null;
        List<Map<String, String>> list = null;
        try {
            String extension = FilenameUtils.getExtension(fileName);

            fis = new FileInputStream(fileName);
            list = read(fis, extension);

            return list;

        } finally {
            if (null != wb) {
                wb.close();
            }

            if (null != fis) {
                fis.close();
            }
        }

    }

    /**
     * 读取excel文件（同时支持2003和2007格式）
     *
     * @param fis       文件输入流
     * @param extension 文件名扩展名: xls 或 xlsx 不区分大小写
     * @return list中的map的key是列的序号
     * @throws Exception io异常等
     */
    public static List<Map<String, String>> read(FileInputStream fis, String extension) throws Exception {

        Workbook wb = null;
        List<Map<String, String>> list = null;
        try {

            if ("xls".equalsIgnoreCase(extension)) {
                wb = new HSSFWorkbook(fis);
            } else if ("xlsx".equalsIgnoreCase(extension)) {
                wb = new XSSFWorkbook(fis);
            } else {
                throw new Exception("file is not office excel");
            }

            list = readWorkbook(wb);

            return list;

        } finally {
            if (null != wb) {
                wb.close();
            }
        }

    }

    protected static List<Map<String, String>> readWorkbook(Workbook wb) throws Exception {
        List<Map<String, String>> list = new LinkedList<Map<String, String>>();

        for (int k = 0; k < wb.getNumberOfSheets(); k++) {
            Sheet sheet = wb.getSheetAt(k);
            int rows = sheet.getPhysicalNumberOfRows();

            for (int r = 0; r < rows; r++) {
                Row row = sheet.getRow(r);
                if (row == null) {
                    continue;
                }
                Map<String, String> map = new HashMap<String, String>();
                int cells = row.getPhysicalNumberOfCells();

                for (int c = 0; c < cells; c++) {
                    Cell cell = row.getCell(c);
                    if (cell == null) {
                        continue;
                    }
                    String value = getCellStringValue(cell);
                    map.put(String.valueOf(cell.getColumnIndex() + 1), value);
                }
                list.add(map);
            }

        }

        return list;
    }

    /**
     * 以String类型返回单元格数据
     *
     * @param cell
     * @return
     */
    protected static String getCellStringValue(Cell cell) {
        String value = null;

        switch (cell.getCellType()) {
            case Cell.CELL_TYPE_FORMULA: // 公式
            case Cell.CELL_TYPE_NUMERIC: // 数字

                double doubleVal = cell.getNumericCellValue();
                if (DateUtil.isCellDateFormatted(cell)) {
                    value = DateFormatUtils.format(DateUtil.getJavaDate(doubleVal), dateFmtPattern);
                } else {
                    //判断小数点位数
                    String valueStr = String.valueOf(doubleVal);
                    valueStr = valueStr.substring(valueStr.indexOf(".") + 1);
                    if (valueStr.length() == 1 && valueStr.equals("0")) {
                        value = String.valueOf((int) doubleVal);
                    } else {
                        value = String.valueOf(doubleVal);
                    }
                }

                break;
            case Cell.CELL_TYPE_STRING: // 字符串
                value = cell.getStringCellValue();
                break;
            case Cell.CELL_TYPE_BLANK: // 空白
                value = "";
                break;
            case Cell.CELL_TYPE_BOOLEAN: // Boolean
                value = String.valueOf(cell.getBooleanCellValue());
                break;
            case Cell.CELL_TYPE_ERROR: // Error，返回错误码
                value = String.valueOf(cell.getErrorCellValue());
                break;
            default:
                value = "";
                break;
        }

        return value;
    }

    /**
     * 以Object类型返回单元格数据
     *
     * @param cell
     * @return
     */
    protected static Object getCellObjectValue(Cell cell) {
        Object value = null;

        switch (cell.getCellType()) {
            case Cell.CELL_TYPE_FORMULA: // 公式
            case Cell.CELL_TYPE_NUMERIC: // 数字

                if (DateUtil.isCellDateFormatted(cell)) {
                    value = cell.getDateCellValue();
                } else {
                    value = cell.getNumericCellValue();
                }
                break;

            case Cell.CELL_TYPE_STRING: // 字符串
                value = cell.getStringCellValue();
                break;
            case Cell.CELL_TYPE_BLANK: // 空白
                value = null;
                break;
            case Cell.CELL_TYPE_BOOLEAN: // Boolean
                value = cell.getBooleanCellValue();
                break;
            case Cell.CELL_TYPE_ERROR: // Error，返回错误码
                value = cell.getErrorCellValue();
                break;
            default:
                value = null;
                break;
        }

        return value;
    }
}
