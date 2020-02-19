package com.ylvaldes.leerPDF.ObtenerPDF;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.ylvaldes.leerPDF.leerPDF;
import com.ylvaldes.leerPDF.Utiles.LoadResourceConfLeerPDF;

public abstract class ObtenerPDF implements IObtenerPDF {
	private final static Logger log = LoggerFactory.getLogger(leerPDF.class);
	WebDriver driver;
	Map<String, Object> vars;
	JavascriptExecutor js;

	public void setUp() {

		try {
			LoadResourceConfLeerPDF recurso = new LoadResourceConfLeerPDF();
			recurso.loadResourceConf();
			String rutaProyecto = System.getProperty("user.dir");
			rutaProyecto += "\\" + recurso.getResourse();

			System.setProperty("webdriver.chrome.driver", recurso.getResourse()+"\\WebDriver\\chromedriver.exe");
			ChromeOptions options = new ChromeOptions();
			Map<String, Object> prefs = new HashMap<String, Object>();
			prefs.put("download.default_directory", rutaProyecto);
			prefs.put("download.prompt_for_download", false);
			prefs.put("download.directory_upgrade", true);
			prefs.put("plugins.always_open_pdf_externally", true);
			options.addArguments("start-maximized");
			options.addArguments("disable-infobars");
			options.setExperimentalOption("prefs", prefs);
			driver = new ChromeDriver(options);
			// driver.manage().window().maximize();
			driver.manage().window().setPosition(new Point(0, -1000));
			js = (JavascriptExecutor) driver;
			vars = new HashMap<String, Object>();
		} catch (FileNotFoundException e) {
			log.error(e.getMessage());
		} catch (IOException e) {
			log.error(e.getMessage());
		}

	}

	public void tearDown() {
		driver.quit();
	}

	public String waitForWindow(int timeout) {
		try {
			Thread.sleep(timeout);
		} catch (InterruptedException e) {
			log.error(e.getMessage());
		}
		Set<String> whNow = driver.getWindowHandles();
		@SuppressWarnings("unchecked")
		Set<String> whThen = (Set<String>) vars.get("window_handles");
		if (whNow.size() > whThen.size()) {
			whNow.removeAll(whThen);
		}
		return whNow.iterator().next();
	}

	public abstract void getPDF(String rut, String serie, String numero, String total, String cdSegu);

	public abstract void getPDF(String rut, String serie, String numero, String total, String fecha, String cdSegu);

}
