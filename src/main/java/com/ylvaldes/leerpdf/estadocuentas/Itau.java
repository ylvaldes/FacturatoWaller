package com.ylvaldes.leerpdf.estadocuentas;

import java.io.IOException;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.ylvaldes.leerpdf.archivos.Excel;
import com.ylvaldes.leerpdf.archivos.Txt;
import com.ylvaldes.leerpdf.dao.ElementosEstadoCuenta;
import com.ylvaldes.leerpdf.utiles.LoadResourceConfLeerPDF;
import com.ylvaldes.leerpdf.utiles.UtilesString;

public class Itau implements IEstadosCuenta {
	private static final Logger log = LoggerFactory.getLogger(Itau.class);
	private static final LoadResourceConfLeerPDF recurso = new LoadResourceConfLeerPDF();
	private static DecimalFormat df2 = new DecimalFormat("#.##");
	// Objetos
	Excel excel;
	UtilesString utilString;
	Txt txt;

	// Listas
	List<String> lineasPDF;
	List<ElementosEstadoCuenta> elementos;

	// Variables
	String nombre;
	Date fechaEmision;
	Date fecha;
	double ley;

	public Itau() {
		try {
			// Inicializando Listas
			lineasPDF = new ArrayList<>();
			elementos = new ArrayList<>();

			// Inicializando Variables
			nombre = "";
			ley = 0.0;
			fecha = new Date();
			fechaEmision = new Date();

			// Inicializando Objetos de Clases
			excel = new Excel();
			utilString = new UtilesString();

			// Carga de Recursos
			recurso.loadResourceConf();

		} catch (IOException e) {
			log.error(e.getMessage());
		}

	}

	public void leerDatos(String filename, String output) {
		log.debug("Entrada: " + filename);
		txt = new Txt(filename, output);

		lineasPDF = Arrays.asList(txt.crearTxt().split("\r\n"));
		log.debug("Nombre: " + lineasPDF.get(2));
		nombre = lineasPDF.get(2);
		log.debug("Fecha de Emisión: " + lineasPDF.get(1).split(" ")[1]);

		try {
			fechaEmision = new SimpleDateFormat("dd/MM/yy").parse(lineasPDF.get(1).split(" ")[1]);
		} catch (ParseException e1) {
			log.error(e1.getMessage());
		}

		int posInicio = utilString.buscarString("SALDO ANTERIOR", lineasPDF);
		int postFin = utilString.buscarString("UD. HA GENERADO", lineasPDF);

		procesarCompra(lineasPDF.subList(posInicio + 2, postFin - 1));

	}

	public void procesarCompra(List<String> compras) {
		Pattern patternCantP = Pattern.compile("[0-9]{1,2}(\\,[0-9]{3})", Pattern.CASE_INSENSITIVE);

		for (String string : compras) {
			Date fechaCompra = new Date();
			String tarjeta = "";
			String descripcion = "";
			String moneda = "";
			String impor = "";

			// Sobre el String entrado por parametro hacer un Split por espacio
			// se obtiene el total del producto (Si hay algun descuento Precio* Cant no aplica el
			// descuento)
			log.info("Compra: " + string.trim());
			String[] a = string.trim().split("        ");
			descripcion = a[0].substring(14, a[0].length()).trim();
			log.info("Descripción: " + descripcion);

			impor = a[a.length - 1].trim();
			impor = impor.replace(",", ".");
			log.info("Precio: " + impor);

			if (a[a.length - 1].trim().equals(a[a.length - 3].trim())) {
				moneda = "USD";
			} else {
				moneda = "UYU";
			}

			log.info("Moneda: " + moneda);

			try {
				fechaCompra = new SimpleDateFormat("dd MM yy").parse(a[0]);
			} catch (ParseException e) {
				log.error(e.getMessage());
			}

			// Obtiene el precio Original del producto
			patternCantP = Pattern.compile("[0-9]{1,2}(\\.[0-9]{3})(\\,[0-9]{2})", Pattern.CASE_INSENSITIVE);
			Matcher matcherCantP = patternCantP.matcher(string);
			if (matcherCantP.find()) {
				// Coincidió => obtener el valor del grupo 1
				impor = matcherCantP.group(0).replace(".", "");
				impor = impor.replace(",", ".");
				log.info("Precio: " + impor);
			}
		}

	}

}
