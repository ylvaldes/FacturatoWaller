package com.ylvaldes.leerpdf.utiles;

import java.util.List;
import java.util.regex.Pattern;

public class UtilesString {

	public UtilesString() {
	}

	public int buscarString(String st, List<String> lista) {
		String stABuscar = lista.stream().filter(strin -> strin.contains(st)).findAny().orElse(null);
		return lista.indexOf(stABuscar);
	}
	public int buscarFechaHora(List<String> lista) {
		Pattern patternFechaHora = Pattern.compile("^\\s*([0-2][0-9]|3[0-1])(\\/|-)(0[1-9]|1[0-2])\\2(\\d{4})(\\s)([0-1][0-9]|2[0-3])(:)([0-5][0-9])(:)([0-5][0-9])$", Pattern.CASE_INSENSITIVE);
		String m ="^([0-2][0-9]|3[0-1])(\\/|-)(0[1-9]|1[0-2])\\2(\\d{4})(\\s)([0-1][0-9]|2[0-3])(:)([0-5][0-9])(:)([0-5][0-9])$";
		String stABuscar="";
		for (String string : lista) {
			if(patternFechaHora.matcher(string.trim()).find()) {
				stABuscar=string;
			}
		}
		
		//String stABuscar = lista.stream().filter(strin -> strin.matches(m)).findAny().orElse(null);
		
		return lista.indexOf(stABuscar);
	}
	public String datosExtra(String rut, String eTicket, String serie, String codSeguridad, Double totalPagarPDF) {

		String datosExtra = String.format(
				"\n [RUT: %1$s \n e-Ticket: %2$s \n Serie: %3$s \n Cod. Seguridad: %4$s \n Total: %5$s]", rut, eTicket,
				serie, codSeguridad, totalPagarPDF);
		return datosExtra;
	}
}
