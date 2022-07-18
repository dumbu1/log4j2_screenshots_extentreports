package utility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbookFactory;

public class ExcelReader {


	private static Properties getPropertiesFromPropertyReader;

	private static FileInputStream excelPath;
	private static XSSFWorkbook obj_XSSFWorkbook;
	//private static XSSFSheet sheet;

	


	public static XSSFSheet getSheetByName() {

		//creating the object of PropertyReader by passing the property file name
		PropertyReader obj_PropertyReader=new PropertyReader("excel");
		//to get the property values
		getPropertiesFromPropertyReader=obj_PropertyReader.propertyReader();

		try {
			excelPath= new FileInputStream(System.getProperty("user.dir")+"/src/test/resources/excelSheets/"+getPropertiesFromPropertyReader.getProperty("filename")+".xlsx");
		} catch (FileNotFoundException e) {
			System.out.println(e);
		}

		try {
			obj_XSSFWorkbook=new XSSFWorkbook(excelPath);

		} catch (IOException e) {
			System.out.println(e);
		}
		return obj_XSSFWorkbook.getSheet(getPropertiesFromPropertyReader.getProperty("sheetname"));
		
	}

	public static  XSSFSheet getSheetById() {

		//creating the object of PropertyReader by passing the property file name
		PropertyReader obj_PropertyReader=new PropertyReader("excel");
		//to get the property values
		getPropertiesFromPropertyReader=obj_PropertyReader.propertyReader();

		try {
			excelPath= new FileInputStream(System.getProperty("user.dir")+"/src/test/resources/excelSheets/"+getPropertiesFromPropertyReader.getProperty("filename")+".xlsx");
		} catch (FileNotFoundException e) {
			System.out.println(e);
		}

		try {
			obj_XSSFWorkbook=new XSSFWorkbook(excelPath);

		} catch (IOException e) {
			System.out.println(e);
		}
		return obj_XSSFWorkbook.getSheetAt(Integer.parseInt(getPropertiesFromPropertyReader.getProperty("sheetid")));
		
	}


	//get total number of columns

	public static int getColumnCount( XSSFSheet sheet) {


		return sheet.getRow(0).getLastCellNum();
	}


	//get total number of rows

	public static int getRowCount( XSSFSheet sheet) {
		return sheet.getLastRowNum();
	}



	//get single row data

	public static HashMap<String,String> getRowData( XSSFSheet sheet,int rowNumber){


		HashMap<String,String> rowData=new HashMap<String,String>();

		for(int i=0;i<getColumnCount(sheet);i++) {
			
			try {
			rowData.put(sheet.getRow(0).getCell(i).toString(), sheet.getRow(rowNumber).getCell(i).toString());
			}
			catch(NullPointerException e) {
				System.out.println("data not available in excel sheet for the row "+rowNumber);
			}
			
			}


		return rowData;
	}



	//get all data

	public static List<HashMap<String, String>> getExcelData( XSSFSheet sheet){

		List<HashMap<String, String>> data=new ArrayList<HashMap<String,String>>();

		for(int i=1;i<=getRowCount(sheet);i++) {
			data.add(getRowData(sheet,i));
		}
		return data;

	}










	//get key data
	public static ArrayList<String> getHashKeys( XSSFSheet sheet) {
		ArrayList<String> keys = new ArrayList<String>();
		for(int i=0; i < getColumnCount(sheet); i++) {
			keys.add(sheet.getRow(0).getCell(i).toString());
		}
		return keys;
	}






}
