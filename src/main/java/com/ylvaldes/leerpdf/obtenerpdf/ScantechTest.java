package com.ylvaldes.leerpdf.obtenerpdf;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
public class ScantechTest extends ObtenerPDF {
	@Override
	public void getPDF(String rut, String serie, String numero, String total, String fecha, String cdSegu) {
		setUp();
		// Test name: Scantech
		// Step # | name | target | value | comment
		// 1 | open | http://efactura1.scanntech.com/products.eticket.consultaQR/ | |
		driver.get("http://efactura.scanntech.com/products.eticket.consultaQR/");
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
		// 9 | click | css=.btn | |
		driver.findElement(By.cssSelector(".btn")).click();
		// 10 | click | name=pdf | |
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}
		vars.put("window_handles", driver.getWindowHandles());
		// 11 | selectWindow | handle=${win6107} | |
		driver.findElement(By.name("pdf")).click();
		vars.put("win6107", waitForWindow(2000));
		driver.switchTo().window(vars.get("win6107").toString());
		tearDown();
	}

	@Override
	public void getPDF(String rut, String serie, String numero, String total, String cdSegu) {
		
	}
}
