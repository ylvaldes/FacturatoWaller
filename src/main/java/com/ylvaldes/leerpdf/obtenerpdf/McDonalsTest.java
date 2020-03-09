package com.ylvaldes.leerpdf.obtenerpdf;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
public class McDonalsTest extends ObtenerPDF {
	@Override
	public void getPDF(String rut, String serie, String numero, String total, String cdSegu) {
		setUp();
		// Test name: McDonals
		// Step # | name | target | value | comment
		// 1 | open | https://cfe.rondanet.com/cgi-bin/Publicacion.cgi/consulta | |
		driver.get("https://cfe.rondanet.com/cgi-bin/Publicacion.cgi/consulta");
		// 2 | setWindowSize | 1936x1066 | |
		driver.manage().window().maximize();
		// 3 | selectFrame | index=0 | |
		//driver.switchTo().frame(0);
		// 4 | type | name=RUT | 211319220018 |
		driver.findElement(By.name("RUT")).sendKeys(rut);
		// 5 | select | name=TipoCFE | label=101 e-Ticket |
		{
			WebElement dropdown = driver.findElement(By.name("TipoCFE"));
			dropdown.findElement(By.xpath("//option[. = '101 e-Ticket']")).click();
		}
		// 6 | type | name=Serie | GI |
		driver.findElement(By.name("Serie")).sendKeys(serie);
		// 7 | type | name=Numero | 0184564 |
		driver.findElement(By.name("Numero")).sendKeys(numero);
		// 8 | type | name=Total | 811 |
		driver.findElement(By.name("Total")).sendKeys(total);
		// 9 | type | name=Hash6 | PWGBg4 |
		driver.findElement(By.name("Hash6")).sendKeys(cdSegu);
		// 10 | click | name=Enviar | |
		vars.put("window_handles", driver.getWindowHandles());
		// 11 | selectWindow | handle=${win276} | |
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

	@Override
	public void getPDF(String rut, String serie, String numero, String total, String fecha, String cdSegu) {
	}
}
