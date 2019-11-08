package com.ylvaldes.leerPDF.Mercados;

import java.util.List;

public interface IMercados {
	public void leerDatos(String filename, String output);

	public void procesarCompra(List<String> compras, String datosExtra);
}
