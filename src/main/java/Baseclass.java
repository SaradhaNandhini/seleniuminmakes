import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import com.google.common.collect.Table.Cell;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Baseclass {
	public static WebDriver driver;
	public static void lauchbrowser() {
		WebDriverManager.chromedriver().setup();
		driver= new ChromeDriver();
		}
   public static void windowMaximize() {
	   driver.manage().window().maximize();
   }
   public static void launchUrl(String Url) {
	   driver.get(Url);
   }
   public static void pageTitle() {
	   String Title = driver.getTitle();
	   System.out.println(Title);
   }
   public static void pageUrl() {
	   String Url = driver.getCurrentUrl();
	   System.out.println(Url);
   }
   public static void passText(String txt, WebElement ele) {
	   ele.sendKeys(txt);
	    }
   public static void closeEntireBrowser() {
	   driver.quit();
   }
   public static void clickBtn(WebElement ele) {
	   ele.click();
   }
   public static void screenshot(String imgName) throws IOException {
	   TakesScreenshot ts = (TakesScreenshot)driver;
	   File image = ts.getScreenshotAs(OutputType.FILE);
	   File f = new File("location+imgname.png");
	   FileUtils.copyFile(image,f);
   }   
   public static Actions a;
   
   public static void moveTheCursor(WebElement targetWebElement) {
	    a= new Actions(driver);
	    a.moveToElement(targetWebElement).perform();
   }
   public static void dragDrop(WebElement dragWebElement, WebElement dropElement) {
	    a= new Actions(driver);
	    a.dragAndDrop(dragWebElement, dropElement).perform();
	    }
   public static JavascriptExecutor js;
   
   public static void scrollThePage(WebElement tarWebEle) {
	   js= (JavascriptExecutor)driver;
	   js.executeScript("arguments[0].scrollInroView(true)", tarWebEle);
   }
   public static void scroll(WebElement element) {
	   js= (JavascriptExecutor)driver;
	   js.executeScript("arguments[0].scrollInroView(true)", element);
   }
   public static void excelRead(String sheetName, int rowNum, int cellNum ) throws IOException {
	   File f = new File ("excellocation.xlsx");
	   FileInputStream fis = new FileInputStream(f);
	   Workbook wb = new XSSFWorkbook(fis);
	   Sheet mysheet = wb.getSheet("sheet1");
	   Row r = mysheet.getRow(rowNum);
       Cell c = (Cell) r.getCell(cellNum);  
       int cellType = ((org.apache.poi.ss.usermodel.Cell) c).getCellType();
   }
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
}
