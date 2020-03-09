package com.ylvaldes.leerpdf.obtenerpdf;
import org.openqa.selenium.By;
public class SluckisTest extends ObtenerPDF {

	@Override
	public void getPDF(String rut, String serie, String numero, String total, String cdSegu) {
		setUp();
		// Test name: Sluckis
		// Step # | name | target | value | comment
		// 1 | open | http://www.etickets.com.uy/Sluckis | |
		driver.get("http://www.etickets.com.uy/Sluckis");
		// 2 | type | id=serie | A |
		driver.findElement(By.id("serie")).sendKeys(serie);
		// 3 | type | id=num | 466242 |
		driver.findElement(By.id("num")).sendKeys(numero);
		// 4 | type | id=ammount | 138 |
		driver.findElement(By.id("ammount")).sendKeys(total);
		// 5 | type | id=code | i6GjRp |
		driver.findElement(By.id("code")).sendKeys(cdSegu);
		// 6 | click | id=type | |
		driver.findElement(By.id("type")).click();
		// 7 | click | id=type | |
		driver.findElement(By.id("type")).click();
		// 8 | click | id=sub | |
		driver.findElement(By.id("sub")).click();
		// 9 | click | css=li:nth-child(1) > span:nth-child(2) | |
		driver.findElement(By.cssSelector("li:nth-child(1) > span:nth-child(2)")).click();
		tearDown();
	}

	@Override
	public void getPDF(String rut, String serie, String numero, String total, String fecha, String cdSegu) {
		// TODO Auto-generated method stub
		
	}
}
