package com.ylvaldes.leerPDF.ObtenerPDF;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
public class SluckisTest {
  private WebDriver driver;
  private Map<String, Object> vars;
  JavascriptExecutor js;
  
  public void setUp() {
		System.setProperty("webdriver.chrome.driver", "./src/main/resources/WebDriver/chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		Map<String, Object> prefs = new HashMap<String, Object>(); 
		prefs.put("download.default_directory","D:\\Yasmani\\Proyectos\\Git_Hub\\FacturatoWaller\\src\\main\\resources\\");
		prefs.put("download.prompt_for_download",false);
		prefs.put("download.directory_upgrade",true);
		prefs.put("plugins.always_open_pdf_externally",true);
		//options.addArguments("start-maximized");
		options.addArguments("disable-infobars");
		options.setExperimentalOption("prefs", prefs);
		driver = new ChromeDriver(options);
		//driver.manage().window().maximize();
		driver.manage().window().setPosition(new Point(0, -1000));
		js = (JavascriptExecutor) driver;
		vars = new HashMap<String, Object>();
  }
  
  public void tearDown() {
    driver.quit();
  }
  
  public void sluckis(String rut,String serie, String numero,String total, String cdSegu ) {
	  setUp();
    // Test name: Sluckis
    // Step # | name | target | value | comment
    // 1 | open | http://www.etickets.com.uy/Sluckis |  | 
    driver.get("http://www.etickets.com.uy/Sluckis");
    // 2 | type | id=serie | A | 
    driver.findElement(By.id("serie")).sendKeys(serie);
    // 3 | type | id=num | 466242 | 
    driver.findElement(By.id("num")).sendKeys(numero);
    // 4 | type | id=ammount | 138 | 
    driver.findElement(By.id("ammount")).sendKeys(total);
    // 5 | type | id=code | i6GjRp | 
    driver.findElement(By.id("code")).sendKeys(cdSegu);
    // 6 | click | id=type |  | 
    driver.findElement(By.id("type")).click();
    // 7 | click | id=type |  | 
    driver.findElement(By.id("type")).click();
    // 8 | click | id=sub |  | 
    driver.findElement(By.id("sub")).click();
    // 9 | click | css=li:nth-child(1) > span:nth-child(2) |  | 
    driver.findElement(By.cssSelector("li:nth-child(1) > span:nth-child(2)")).click();
    tearDown();
  }
}
