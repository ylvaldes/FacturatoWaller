package com.ylvaldes.leerpdf.obtenerpdf;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class DevotoTest extends ObtenerPDF {
	
	@Override
	public void getPDF(String rut, String serie, String numero, String total, String cdSegu) {
		setUp();
		// Test name: Devoto
		// Step # | name | target | value | comment
		// 1 | open | https://www.devoto.com.uy/consulte-su-ticket | |
		driver.get("https://www.devoto.com.uy/consulte-su-ticket");
		// 3 | select | name=RUT | label=Devoto Express |
		String tipo = (rut.equals("210650500016") ? "Devoto Express" : (rut.equals("210297450018") ? "Devoto" : ""));
		
		WebElement dropdown = driver.findElement(By.name("RUT"));
		dropdown.findElement(By.xpath("//option[. = '"+tipo+"']")).click();
		
			// 4 | select | name=TipoCFE | label=101 Ticket |
		
		WebElement dropdown1 = driver.findElement(By.name("TipoCFE"));
		dropdown1.findElement(By.xpath("//option[. = '101 Ticket']")).click();
		
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

	@Override
	public void getPDF(String rut, String serie, String numero, String total, String fecha, String cdSegu) {
		
		
	}
}
