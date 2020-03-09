package com.ylvaldes.leerpdf.obtenerpdf;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
public class DiscoTest extends ObtenerPDF {

	@Override
	public void getPDF(String rut, String serie, String numero, String total, String cdSegu) {
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
			
			e.printStackTrace();
		}
		driver.switchTo().window(vars.get("win6744").toString());

		tearDown();
	}

	@Override
	public void getPDF(String rut, String serie, String numero, String total, String fecha, String cdSegu) {
	
	}
}
