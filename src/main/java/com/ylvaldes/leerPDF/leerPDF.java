package com.ylvaldes.leerPDF;

import java.io.FileNotFoundException;
import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;

import org.apache.log4j.BasicConfigurator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.ylvaldes.leerPDF.Mercados.AlmaNatural;
import com.ylvaldes.leerPDF.Mercados.Devoto;
import com.ylvaldes.leerPDF.Mercados.Disco;
import com.ylvaldes.leerPDF.Mercados.Distravi;
import com.ylvaldes.leerPDF.Mercados.Tata;
import com.ylvaldes.leerPDF.Utiles.LoadResourceConfLeerPDF;
import com.ylvaldes.leerPDF.estadoCuentas.Itau;

public class leerPDF {

	private final static Logger log = LoggerFactory.getLogger(leerPDF.class);

	private static String PDF = "";

	

	public static void main(String[] args) throws FileNotFoundException, IOException, ParserConfigurationException {
		// Obtiene las configuraciones Basicas de LoggerFactory
		BasicConfigurator.configure();

		// Carga los recursos
		LoadResourceConfLeerPDF recurso = new LoadResourceConfLeerPDF();
		recurso.loadResourceConf();
		PDF = "src/main/resources/" + recurso.getMercado() + ".pdf";
		

		switch (recurso.getMercado()) {
		case "Tata":
			Tata tata = new Tata();
			tata.leerDatos(PDF, recurso.getOutput() + recurso.getMercado() + ".txt");
			break;
		case "Disco":
			Disco disco = new Disco();
			disco.leerDatos(PDF, recurso.getOutput() + recurso.getMercado() + ".txt");
			break;
		case "Distravi":
			Distravi distravi = new Distravi();
			distravi.leerDatos(PDF, recurso.getOutput() + recurso.getMercado() + ".txt");
			break;
		case "AlmaNatural":
			AlmaNatural almaNatural = new AlmaNatural();
			almaNatural.leerDatos(PDF, recurso.getOutput() + recurso.getMercado() + ".txt");
			break;
		case "Devoto":
			Devoto devoto = new Devoto();
			devoto.leerDatos(PDF, recurso.getOutput() + recurso.getMercado() + ".txt");
			break;
		case "Itau":
			Itau itau = new Itau();
			itau.leerDatos(PDF, recurso.getOutput() + recurso.getMercado() + ".txt");
			break;
		default:
			break;
		}



	}

}
