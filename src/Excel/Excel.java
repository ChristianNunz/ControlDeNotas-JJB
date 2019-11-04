/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Excel;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Iterator;
import org.apache.poi.hssf.usermodel.HSSFDateUtil;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 *
 * @author Jorge Villanueva
 */
public class Excel {

    public Excel() {
    }
    
    public void WriteFileExcel(){
        XSSFWorkbook workbook = null;

		//Excel Sheet
		XSSFSheet sheet = null;
						
		try {
			
			// Input file name
			String excelFileName = "C:\\Users\\Jorge Villanueva\\Desktop\\MD.xlsx";
			File excelFile = new File(excelFileName);
			
			// Output File name
			FileOutputStream out = new FileOutputStream(excelFile);
			
			workbook = new XSSFWorkbook();
			sheet = workbook
					.createSheet("FirstSheet");
			
			int rowNum = 0; //row number
			int cellNum = 0; //cell number
			
			//Set Column width
			sheet.setColumnWidth(0, 5000);
			sheet.setColumnWidth(1, 5000);
			
			//Bold
			XSSFFont headerCellFont = workbook.createFont();
			headerCellFont.setBold(true);
			
			XSSFCellStyle cs = null;
			cs = workbook.createCellStyle();
			cs.setFont(headerCellFont);
			
						
			Row rowOne = sheet.createRow(rowNum);
			Cell cellOneRowOne = rowOne.createCell(cellNum);
			cellOneRowOne.setCellStyle(cs);
			cellOneRowOne.setCellValue("My First Row, First Cell Value");
			
			cellNum++;
			Cell cellTwoRowOne = rowOne.createCell(cellNum);
			cellTwoRowOne.setCellStyle(cs);
			cellTwoRowOne.setCellValue("My First Row, Second Cell Value");
		
			
			//reset cell no.
			cellNum = 0;
			rowNum++;//Second row
						
			Row rowTwo = sheet.createRow(rowNum);
			Cell cellOneRowTwo = rowTwo.createCell(cellNum);
			cellOneRowTwo.setCellValue("My Second Row, First Cell Value");
			
			cellNum++;
			Cell cellTwoRowTwo = rowTwo.createCell(cellNum);
			cellTwoRowTwo.setCellValue("My Second Row, Second Cell Value");		
			
			workbook.write(out);
			out.close();
			workbook.close();
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    
    public String ReadFileExcel(File src){
        String result="";
        try {                    
        FileInputStream fin = new FileInputStream(src);        
        XSSFWorkbook workbook = new XSSFWorkbook(fin);
        XSSFSheet sheet = workbook.getSheetAt(0);
        
        Iterator<Row> Rowiterator = sheet.iterator();
        int rowcount = sheet.getLastRowNum(); 
        
        Row row;
            while (Rowiterator.hasNext()) {
                row = Rowiterator.next();
                Iterator<Cell> Celliterator = row.cellIterator();
                Cell celda;                
                while (Celliterator.hasNext()) {
                    celda= Celliterator.next();
                    CellType tipoCelda = celda.getCellType();
                    if (celda.getCellType().NUMERIC==tipoCelda) {
                        if( HSSFDateUtil.isCellDateFormatted(celda) ){
                            result += celda.getDateCellValue()+"&";
                           
                        }else{
                            result +=celda.getNumericCellValue()+"&";
                        }
                    } else if(celda.getCellType().STRING==tipoCelda) {
                        result +=celda.getStringCellValue()+"&";
                    } else if(celda.getCellType().BOOLEAN==tipoCelda) {
                       result +=celda.getBooleanCellValue()+"&";
                    }else if(celda.getCellType().ERROR==tipoCelda) {
                       result +=celda.getErrorCellValue()+"&";
                    }
                }
                result +="\n";
               
            }
            workbook.close();
        } catch (IOException e) {
            e.printStackTrace();
        }     
        return result;
    }
}
