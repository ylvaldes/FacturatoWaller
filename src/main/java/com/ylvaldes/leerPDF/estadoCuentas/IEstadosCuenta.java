package com.ylvaldes.leerPDF.estadoCuentas;

import java.util.List;

public interface IEstadosCuenta {
	public void leerDatos(String filename, String output);

	public void procesarCompra(List<String> compras);
}
