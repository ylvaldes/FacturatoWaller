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
public class DevotoTest {
	private WebDriver driver;
	private Map<String, Object> vars;
	JavascriptExecutor js;

	public void setUp() {
		System.setProperty("webdriver.chrome.driver", "./src/main/resources/WebDriver/chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		Map<String, Object> prefs = new HashMap<String, Object>();
		prefs.put("download.default_directory", "D:\\Yasmani\\Proyectos\\Git_Hub\\FacturatoWaller\\src\\main\\resources\\");
		prefs.put("download.prompt_for_download", false);
		prefs.put("download.directory_upgrade", true);
		prefs.put("plugins.always_open_pdf_externally", true);
		options.addArguments("start-maximized");
		options.addArguments("disable-infobars");
		options.setExperimentalOption("prefs", prefs);
		driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		// driver.manage().window().setPosition(new Point(0, -1000));
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

	public void devoto(String rut, String serie, String numero, String total, String cdSegu) {
		setUp();
		// Test name: Devoto
		// Step # | name | target | value | comment
		// 1 | open | https://www.devoto.com.uy/consulte-su-ticket | |
		driver.get("https://www.devoto.com.uy/consulte-su-ticket");
		// 3 | select | name=RUT | label=Devoto Express |
		String tipo = (rut.equals("210650500016") ? "Devoto Express" : (rut.equals("210297450018") ? "Devoto" : ""));
		{
			WebElement dropdown = driver.findElement(By.name("RUT"));
			dropdown.findElement(By.xpath("//option[. = '"+tipo+"']")).click();
		}
		// 4 | select | name=TipoCFE | label=101 Ticket |
		{
			WebElement dropdown = driver.findElement(By.name("TipoCFE"));
			dropdown.findElement(By.xpath("//option[. = '101 Ticket']")).click();
		}
		// 5 | type | name=Serie | J |
		driver.findElement(By.name("Serie")).sendKeys(serie);
		// 6 | type | name=Numero | 5800306 |
		driver.findElement(By.name("Numero")).sendKeys(numero);
		// 7 | type | name=Total | 307.63 |
		driver.findElement(By.name("Total")).sendKeys(total);
		// 8 | type | name=Hash6 | TxCQNv |
		driver.findElement(By.name("Hash6")).sendKeys(cdSegu);
		// 9 | click | name=Enviar | |
		vars.put("window_handles", driver.getWindowHandles());
		// 10 | selectWindow | handle=${win8505} | |
		driver.findElement(By.name("Enviar")).click();
		vars.put("win8505", waitForWindow(2000));
		driver.switchTo().window(vars.get("win8505").toString());

		tearDown();
	}
}
