package com.ylvaldes.leerpdf.estadocuentas;

import java.util.List;

public interface IEstadosCuenta {
	public void leerDatos(String filename, String output);

	public void procesarCompra(List<String> compras);
}
