package com.ylvaldes.leerpdf.obtenerpdf;

public interface IObtenerPDF {
	public void setUp();
	public void tearDown();
	public String waitForWindow(int timeout);
	public abstract void getPDF(String rut, String serie, String numero, String total, String cdSegu);
	public abstract void getPDF(String rut, String serie, String numero, String total, String fecha, String cdSegu);
}
