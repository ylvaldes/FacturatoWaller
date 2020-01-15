package com.ylvaldes.leerPDF;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import javax.xml.parsers.ParserConfigurationException;

import org.apache.log4j.BasicConfigurator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.ylvaldes.leerPDF.Mercados.AlmaNatural;
import com.ylvaldes.leerPDF.Mercados.Devoto;
import com.ylvaldes.leerPDF.Mercados.Disco;
import com.ylvaldes.leerPDF.Mercados.Distravi;
import com.ylvaldes.leerPDF.Mercados.Scanntech;
import com.ylvaldes.leerPDF.Mercados.Tata;
import com.ylvaldes.leerPDF.ObtenerPDF.DiscoTest;
import com.ylvaldes.leerPDF.ObtenerPDF.TataTest;
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

		Scanner teclado = new Scanner(System.in);
		System.out.print("URL Scaneada: ");
		// String url = teclado.nextLine();
		String url = "https://www.efactura.dgi.gub.uy/consultaQR/cfe?210274130017,101,AQ,6452191,400.00,20200106,VjIERniOkN6AJ5ggq0iSQff5ekE=";
		url = url.substring(47, url.length());
		List<String> result = Arrays.asList(url.split("\\s*,\\s*"));
		System.out.println();
		System.out.print("Dtos Obtenido de la URL: ");
		System.out.println(result.toString());

		switch (result.get(0)) {
			// TATA
			// 210003270017
			case "210003270017" :
				System.out.println();
				System.out.println("Mercado TATA");
				TataTest tataTest = new TataTest();
				tataTest.tata(result.get(0), result.get(2), result.get(3), result.get(4), result.get(6).substring(0, 6));

				Tata tata = new Tata();
				tata.leerDatos(PDF, recurso.getOutput() + recurso.getMercado() + ".txt");
				break;

			// Disco
			// 210274130017
			case "210274130017" :
				System.out.println();
				System.out.println("Mercado DISCO");
				DiscoTest discoTest = new DiscoTest();
				discoTest.disco(result.get(0), result.get(2), result.get(3), result.get(4), result.get(6).substring(0, 6));
				
				Disco disco = new Disco();
				disco.leerDatos(PDF, recurso.getOutput() + recurso.getMercado() + ".txt");
				break;

			// Distravi
			// 211223740010
			case "211223740010" :
				System.out.println();
				System.out.println("Mercado Distravi");
				Distravi distravi = new Distravi();
				distravi.leerDatos(PDF, recurso.getOutput() + recurso.getMercado() + ".txt");
				break;
			
			case "AlmaNatural" :
				AlmaNatural almaNatural = new AlmaNatural();
				almaNatural.leerDatos(PDF, recurso.getOutput() + recurso.getMercado() + ".txt");
				break;

			// ElNaranjo
			// 210650500016
			case "210650500016" :
				Devoto devoto = new Devoto();
				devoto.leerDatos(PDF, recurso.getOutput() + recurso.getMercado() + ".txt");
				break;
			case "Itau" :
				Itau itau = new Itau();
				itau.leerDatos(PDF, recurso.getOutput() + recurso.getMercado() + ".txt");
				break;

			// ElNaranjo
			// 214634020016
			case "214634020016" :
				Scanntech elNaranjo = new Scanntech();
				elNaranjo.leerDatos(PDF, recurso.getOutput() + recurso.getMercado() + ".txt");
				break;

			// Carnelandia
			// 211229400017
			case "211229400017" :
				Scanntech carnelandia = new Scanntech();
				carnelandia.leerDatos(PDF, recurso.getOutput() + recurso.getMercado() + ".txt");
				break;

			// Montserrat Panaderia
			// 214783760011
			case "214783760011" :
				Scanntech montserrat = new Scanntech();
				montserrat.leerDatos(PDF, recurso.getOutput() + recurso.getMercado() + ".txt");
				break;

			// DonPaulino
			// 211412910010
			case "211412910010" :
				Scanntech donPaulino = new Scanntech();
				donPaulino.leerDatos(PDF, recurso.getOutput() + recurso.getMercado() + ".txt");
				break;
			default :
				break;
		}

	}

}
