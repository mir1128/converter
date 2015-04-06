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
        deleteSqlFiles(".sql");

        if (args.length != 2) {
            System.out.println("usage: java -jar converter-1.0.jar [file directory] table_definition.properties");
        }

        for (String tableKey : tableKeys) {
            ConfigureParser configureParser = new ConfigureParser(tableKey, args[1]);
            int sheets = configureParser.getSheets();
            List<List<String>> columns = configureParser.getColumns();
            List<Map.Entry<Integer, Integer>> rowRange = configureParser.getRowRange();
            List<Map.Entry<Integer, Integer>> columnRange = configureParser.getColumnRange();

            if (!args[0].endsWith("/")) {
                args[0] += "/";
            }
            String filePath = args[0] + tableKey + ".xls";

            for (int i = 0; i < sheets; ++i) {
                List<String> sqlList = generateSql(tableKey, filePath, i, columns.get(i), rowRange.get(i), columnRange.get(i));
                dumpSqls(tableKey, sqlList);
            }
        }

        deleteSqlFiles(".xls");
    }

    private static void deleteSqlFiles(String extName) {
        for (String tableKey : tableKeys) {
            String fileName = "./" + tableKey + extName;
            File file = new File(fileName);
            if (file.exists()) {
                file.delete();
            }
        }
    }

    private static List<String> generateSql(String tableKey,
                                            String filePath,
                                            int sheetIndex,
                                            List<String> columns,
                                            Map.Entry<Integer, Integer> rowRange,
                                            Map.Entry<Integer, Integer> columnRanges) {
        logger.info("filePath : " + filePath + " sheetIndex : " + sheetIndex
                + " columns : " + columns + " rowRange : " + rowRange
                + " columnRanges" + columnRanges);

        String tempFile = "./" + filePath.substring(filePath.lastIndexOf("/"));

        Copy(filePath, tempFile);

        List<String> values = new ArrayList<>();
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

            for (int i = rowRange.getKey(); i < rowRange.getValue(); ++i) {
                String result = "";
                for (int j = columnRanges.getKey(); j < columnRanges.getValue(); ++j) {
                    result += "\"" + sheet.getCell(j, i).getContents() + "\""
                            + ((j == columnRanges.getValue() - 1) ? "" : ",");
                }
                values.add(result);
            }
        } catch (IOException e) {
            logger.error(tempFile + "does not exist.");
        } catch (BiffException e) {
        }

        return values;
    }

    private static void dumpSqls(String tableKey, List<String> values) {
        String sqlPath = "./" + tableKey + ".sql";
        File file = new File(sqlPath);

        try {
            file.createNewFile();
        } catch (IOException e) {
            logger.info(e.fillInStackTrace());
        }

        try {
            FileWriter fileWriter = new FileWriter(file.getAbsoluteFile(), true);
            BufferedWriter bufferWriter = new BufferedWriter(fileWriter);

            for (String content : values) {
                bufferWriter.write("insert into " + tableKey + " values (" + content + " )\n");
            }

            bufferWriter.close();
        } catch (IOException e) {
            logger.info(e.fillInStackTrace());
        }
    }

    private static void Copy(String oldPath, String newPath) {
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
