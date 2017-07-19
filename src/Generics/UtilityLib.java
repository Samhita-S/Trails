package Generics;

import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

import javax.imageio.ImageIO;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Rectangle;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class UtilityLib {
	public static void getScreenshot(WebDriver driver,String path){
		try{
			TakesScreenshot t =(TakesScreenshot)driver;
			File scrfile=t.getScreenshotAs(OutputType.FILE);
			File destfile= new File(path);
			FileUtils.copyFile(scrfile, destfile);
		}
		catch(Exception e){
			
		}
	}
	public static void getScreenshot(String path){
		try{
			Robot r=new Robot();
			java.awt.Dimension d=Toolkit.getDefaultToolkit().getScreenSize();
			java.awt.Rectangle rect = new java.awt.Rectangle(d);
			BufferedImage f=r.createScreenCapture(rect);
			ImageIO.write(f,"png", new File(path));
		}
		catch(Exception e){
			
		}
	}
	public static String now(){
		SimpleDateFormat s = new SimpleDateFormat("dd-MM-yy-hh-mm-ss");
		return s.format(new Date());
		
	}
	public static String getCellValue(String path,String sheet, int r, int c){
		String v="";
		try{
			Workbook wb=WorkbookFactory.create(new FileInputStream(path));
			v=wb.getSheet(sheet).getRow(r).getCell(c).toString();
		}
		catch(Exception e){
			
		}
		return v;
	}
	public static int getRowCount(String path,String sheet){
		int r=0;
		try{
			Workbook wb=WorkbookFactory.create(new FileInputStream(path));
			r=wb.getSheet(sheet).getLastRowNum();
		}
		catch(Exception e){
			
		}
		return r;
	}
	public static String getPropertyValue(String path,String key){
	  String v="";
	  try{
		  Properties p = new Properties();
		  p.load(new FileInputStream(path));
		  v=p.getProperty(key);
	  }
	  catch(Exception e){
		  
	  }
		return v;
		
	}

}
