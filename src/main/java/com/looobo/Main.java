package com.looobo;

import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;
import org.apache.log4j.Logger;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Main {
    private static Logger logger = Logger.getLogger(ConfigureParser.class);

    private static List<String> tableKeys = new ArrayList<String>();

    static {
        tableKeys.add("temp_support_applying");
        tableKeys.add("village_allowance_bak");
        tableKeys.add("village_5allowance_register");
        tableKeys.add("medical_assistance_register");
        tableKeys.add("city_allowance_register");
        tableKeys.add("special_care_register");
        tableKeys.add("orphan_register");
    }

    public static void main(String[] args) {
        for (String tableKey : tableKeys) {
            ConfigureParser configureParser = new ConfigureParser(tableKey);
            int sheets = configureParser.getSheets();
            List<List<String>> columns = configureParser.getColumns();
            List<Map.Entry<Integer, Integer>> rowRange = configureParser.getRowRange();
            List<Map.Entry<Integer, Integer>> columnRange = configureParser.getColumnRange();

            String filePath = "/Users/jieliu/Downloads/xlses/" + tableKey + ".xls";
            for (int i = 0; i < sheets; ++i) {
                List<String> sqlList = generateSql(filePath, i, columns.get(i), rowRange.get(i), columnRange.get(i));
                System.out.println(sqlList);
            }

        }
    }

    public static List<String> generateSql(String filePath,
                                           int sheetIndex,
                                           List<String> columns,
                                           Map.Entry<Integer, Integer> rowRange,
                                           Map.Entry<Integer, Integer> columnRanges) {

        System.out.println(filePath);
        System.out.println(columns);
        System.out.println(rowRange);
        System.out.println(columnRanges);
        System.out.println("---------------------");

        String tempFile = "/tmp" + filePath.substring(filePath.lastIndexOf("/"));

        Copy(filePath, tempFile);

        try {
            Workbook workbook = Workbook.getWorkbook(new File(tempFile));
            Sheet sheet = workbook.getSheet(sheetIndex);

            if (sheet.getRows() < rowRange.getValue() || sheet.getColumns() < columnRanges.getValue()) {
                logger.info("file: " + filePath + "sheet rows :" + sheet.getRows()
                        + "sheet columns: " + sheet.getColumns()
                        + "configure rows" + rowRange.getValue()
                        + "configure columns" + columnRanges.getValue());
                return null;
            }

            List<String> values = new ArrayList<>();
            for (int i = rowRange.getKey(); i < rowRange.getValue(); ++i) {
                String result = "";
                for (int j = columnRanges.getKey(); j < columnRanges.getValue(); ++j) {
                    result += sheet.getCell(j, i).getContents() + ",";
                }
                values.add(result);
            }

            for (String s : values) {
                System.out.println(s);
            }
        } catch (IOException e) {
            logger.error(tempFile + "does not exist.");
            logger.error(e.fillInStackTrace());
        } catch (BiffException e) {
        }

        return null;
    }

    public static void Copy(String oldPath, String newPath) {
        try {
            int bytesum = 0;
            int byteread = 0;
            File oldfile = new File(oldPath);
            if (oldfile.exists()) {
                InputStream inStream = new FileInputStream(oldPath);
                FileOutputStream fs = new FileOutputStream(newPath);
                byte[] buffer = new byte[1444];
                int length;
                while ((byteread = inStream.read(buffer)) != -1) {
                    bytesum += byteread;
                    fs.write(buffer, 0, byteread);
                }
                inStream.close();
            }
        } catch (Exception e) {
            logger.error("oldPath" + oldPath);
            logger.error("newPath" + newPath);
            logger.error(e.fillInStackTrace());
        }
    }

}
