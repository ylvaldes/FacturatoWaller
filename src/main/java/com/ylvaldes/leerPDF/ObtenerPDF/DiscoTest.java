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
import org.openqa.selenium.interactions.Actions;
public class DiscoTest {
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

	public void disco(String rut, String serie, String numero, String total, String cdSegu) {
		setUp();
		// Test name: Disco
		// Step # | name | target | value | comment
		// 1 | open | https://institucional.disco.com.uy/index.php/consulta-cfe | |
		driver.get("https://institucional.disco.com.uy/index.php/consulta-cfe");
		// 3 | selectFrame | index=0 | |
		driver.switchTo().frame(0);
		// 4 | doubleClick | id=rut | |
		{
			WebElement element = driver.findElement(By.id("rut"));
			Actions builder = new Actions(driver);
			builder.doubleClick(element).perform();
		}
		// 5 | type | name=rut | 210274130017 |
		driver.findElement(By.name("rut")).sendKeys(rut);
		// 6 | select | name=TipoCFE | label=101 Ticket |
		{
			WebElement dropdown = driver.findElement(By.name("TipoCFE"));
			dropdown.findElement(By.xpath("//option[. = '101 Ticket']")).click();
		}
		// 7 | type | name=Serie | AQ |
		driver.findElement(By.name("Serie")).sendKeys(serie);
		// 8 | type | name=Numero | 6452191 |
		driver.findElement(By.name("Numero")).sendKeys(numero);
		// 9 | type | name=Total | 400.00 |
		driver.findElement(By.name("Total")).sendKeys(total);
		// 10 | type | name=Hash6 | VjIERn |
		driver.findElement(By.name("Hash6")).sendKeys(cdSegu);
		// 11 | click | id=Consultar | |
		vars.put("window_handles", driver.getWindowHandles());
		// 12 | selectWindow | handle=${win6744} | |
		driver.findElement(By.id("Consultar")).click();
		vars.put("win6744", waitForWindow(2000));
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.switchTo().window(vars.get("win6744").toString());
		
		tearDown();
	}
}
