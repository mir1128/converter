package com.looobo;

import jxl.Cell;
import jxl.Range;
import jxl.Sheet;
import jxl.Workbook;
import org.apache.log4j.Logger;

import java.io.File;

public class Main {
    private static Logger logger = Logger.getLogger(Main.class);

    public   static   void  main(String args[])  {
        try   {
            Workbook book  =  Workbook.getWorkbook( new File( "/Users/jieliu/Downloads/xlses/city_allowance_register.XLS"));
            //  获得第一个工作表对象
            Sheet sheet  =  book.getSheet( 0 );
            //  得到第一列第一行的单元格

            Range[] mergedCells = sheet.getMergedCells();


            Cell cell1  =  sheet.getCell( 0 ,  1);
            String result  =  cell1.getContents();
            System.out.println(result);
            book.close();
        }   catch  (Exception e)  {
            System.out.println(e);
        }
    }
}
