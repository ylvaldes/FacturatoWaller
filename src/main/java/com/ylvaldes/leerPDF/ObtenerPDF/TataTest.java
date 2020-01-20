package com.ylvaldes.leerPDF.ObtenerPDF;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
public class TataTest {
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
		//driver.manage().window().maximize();
		driver.manage().window().setPosition(new Point(0, -1000));
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
  
  public void tata(String rut,String serie, String numero,String total, String cdSegu ) {
	  setUp();
    // Test name: Tata
    // Step # | name | target | value | comment
	// 1 | open | http://www.institucional.tata.com.uy/consulta-e-ticket |  | 
	driver.get("http://www.institucional.tata.com.uy/consulta-e-ticket");
    // 2 | setWindowSize | 1936x1066 |  | 
    driver.manage().window().maximize();
    // 3 | selectFrame | index=0 |  | 
    driver.switchTo().frame(0);
    // 4 | type | name=RUT | 210003270017 | 
    driver.findElement(By.name("RUT")).sendKeys(rut);
    // 5 | select | name=TipoCFE | label=101 Ticket | 
    {
      WebElement dropdown = driver.findElement(By.name("TipoCFE"));
      dropdown.findElement(By.xpath("//option[. = '101 Ticket']")).click();
    }
    // 6 | type | name=Serie | QO | 
    driver.findElement(By.name("Serie")).sendKeys(serie);
    // 7 | type | name=Numero | 750203 | 
    driver.findElement(By.name("Numero")).sendKeys(numero);
    // 8 | type | name=Total | 562 | 
    driver.findElement(By.name("Total")).sendKeys(total);
    // 9 | type | name=Hash6 | UCSjof | 
    driver.findElement(By.name("Hash6")).sendKeys(cdSegu);
    // 10 | click | name=Enviar |  | 
    vars.put("window_handles", driver.getWindowHandles());
    // 11 | selectWindow | handle=${win276} |  | 
    driver.findElement(By.name("Enviar")).click();
    vars.put("win276", waitForWindow(2000));
    try {
		Thread.sleep(2000);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
    driver.switchTo().window(vars.get("win276").toString());
    
    tearDown();
  }
}
