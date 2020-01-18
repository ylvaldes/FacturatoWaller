package com.ylvaldes.leerPDF.ObtenerPDF;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
public class ScantechTest {
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
		options.addArguments("start-maximized");
		options.addArguments("disable-infobars");
		options.setExperimentalOption("prefs", prefs);
		driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		//driver.manage().window().setPosition(new Point(0, -1000));
		js = (JavascriptExecutor) driver;
		vars = new HashMap<String, Object>();
		
	}

  public void tearDown() {
    driver.quit();
  }
  public String waitForWindow(int timeout) {
    try {
      Thread.sleep(timeout);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    Set<String> whNow = driver.getWindowHandles();
    Set<String> whThen = (Set<String>) vars.get("window_handles");
    if (whNow.size() > whThen.size()) {
      whNow.removeAll(whThen);
    }
    return whNow.iterator().next();
  }

  public void scantech(String rut, String serie, String numero, String total,String fecha, String cdSegu) {
	  setUp();
    // Test name: Scantech
    // Step # | name | target | value | comment
    // 1 | open | http://efactura1.scanntech.com/products.eticket.consultaQR/ |  | 
    driver.get("http://efactura1.scanntech.com/products.eticket.consultaQR/");
    // 2 | type | id=rut | 211229400017 | 
    driver.findElement(By.id("rut")).sendKeys(rut);
    // 3 | select | id=tipoCfe | label=e-Ticket | 
    {
      WebElement dropdown = driver.findElement(By.id("tipoCfe"));
      dropdown.findElement(By.xpath("//option[. = 'e-Ticket']")).click();
    }
    // 4 | type | id=serie | A | 
    driver.findElement(By.id("serie")).sendKeys(serie);
    // 5 | type | id=nroCFE | 542977 | 
    driver.findElement(By.id("nroCFE")).sendKeys(numero);
    // 6 | type | id=monto | 1749.96 | 
    driver.findElement(By.id("monto")).sendKeys(total);
    // 7 | type | id=fecha | 18/12/2019 | 
    driver.findElement(By.id("fecha")).sendKeys(fecha);
    // 8 | type | id=hash | HagY3E | 
    driver.findElement(By.id("hash")).sendKeys(cdSegu);
    // 9 | click | css=.btn |  | 
    driver.findElement(By.cssSelector(".btn")).click();
    // 10 | click | name=pdf |  | 
    try {
		Thread.sleep(2000);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
    vars.put("window_handles", driver.getWindowHandles());
    // 11 | selectWindow | handle=${win6107} |  | 
    driver.findElement(By.name("pdf")).click();
    vars.put("win6107", waitForWindow(2000));
    driver.switchTo().window(vars.get("win6107").toString());
	tearDown();
  }
}
