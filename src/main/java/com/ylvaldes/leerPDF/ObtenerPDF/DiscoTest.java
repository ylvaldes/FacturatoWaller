package com.ylvaldes.leerPDF.ObtenerPDF;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
public class DiscoTest {
	private WebDriver driver;
	private Map<String, Object> vars;
	JavascriptExecutor js;

	public void setUp() {
		System.setProperty("webdriver.chrome.driver", "./src/main/resources/WebDriver/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
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
		// 2 | setWindowSize | 1900x1030 | |
		driver.manage().window().setSize(new Dimension(1900, 1030));
		// 3 | selectFrame | index=0 | |
		driver.switchTo().frame(0);
		// 4 | doubleClick | id=rut | |
		{
			WebElement element = driver.findElement(By.id("rut"));
			Actions builder = new Actions(driver);
			builder.doubleClick(element).perform();
		}
		// 5 | type | name=rut | 210274130017 |
		driver.findElement(By.name("rut")).sendKeys("210274130017");
		// 6 | select | name=TipoCFE | label=101 Ticket |
		{
			WebElement dropdown = driver.findElement(By.name("TipoCFE"));
			dropdown.findElement(By.xpath("//option[. = '101 Ticket']")).click();
		}
		// 7 | type | name=Serie | AQ |
		driver.findElement(By.name("Serie")).sendKeys("AQ");
		// 8 | type | name=Numero | 6452191 |
		driver.findElement(By.name("Numero")).sendKeys("6452191");
		// 9 | type | name=Total | 400.00 |
		driver.findElement(By.name("Total")).sendKeys("400.00");
		// 10 | type | name=Hash6 | VjIERn |
		driver.findElement(By.name("Hash6")).sendKeys("VjIERn");
		// 11 | click | id=Consultar | |
		vars.put("window_handles", driver.getWindowHandles());
		// 12 | selectWindow | handle=${win6744} | |
		driver.findElement(By.id("Consultar")).click();
		vars.put("win6744", waitForWindow(2000));
		driver.switchTo().window(vars.get("win6744").toString());
	}
}
