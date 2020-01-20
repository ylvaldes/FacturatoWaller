package com.ylvaldes.leerPDF;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import javax.xml.parsers.ParserConfigurationException;

import org.apache.log4j.BasicConfigurator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.ylvaldes.leerPDF.Mercados.AlmaNatural;
import com.ylvaldes.leerPDF.Mercados.Devoto;
import com.ylvaldes.leerPDF.Mercados.DevotoE;
import com.ylvaldes.leerPDF.Mercados.Disco;
import com.ylvaldes.leerPDF.Mercados.Distravi;
import com.ylvaldes.leerPDF.Mercados.Frog;
import com.ylvaldes.leerPDF.Mercados.Scanntech;
import com.ylvaldes.leerPDF.Mercados.Sluckis;
import com.ylvaldes.leerPDF.Mercados.Tata;
import com.ylvaldes.leerPDF.ObtenerPDF.DevotoTest;
import com.ylvaldes.leerPDF.ObtenerPDF.DiscoTest;
import com.ylvaldes.leerPDF.ObtenerPDF.ScantechTest;
import com.ylvaldes.leerPDF.ObtenerPDF.SluckisTest;
import com.ylvaldes.leerPDF.ObtenerPDF.TataTest;
import com.ylvaldes.leerPDF.Utiles.LoadResourceConfLeerPDF;
import com.ylvaldes.leerPDF.estadoCuentas.Itau;

public class leerPDF {

	private final static Logger log = LoggerFactory.getLogger(leerPDF.class);

	private static String PDF = "";

	public static void main(String[] args) throws FileNotFoundException, IOException, ParserConfigurationException {
		// Obtiene las configuraciones Basicas de LoggerFactory
		BasicConfigurator.configure();

		String directorioRaiz = System.getProperty("user.dir");

		// Carga los recursos
		LoadResourceConfLeerPDF recurso = new LoadResourceConfLeerPDF();
		recurso.loadResourceConf();
		SimpleDateFormat format = new SimpleDateFormat(recurso.getPatternFormatS());
		SimpleDateFormat format2 = new SimpleDateFormat("yyyyMMdd");
		SimpleDateFormat format3 = new SimpleDateFormat("ddMMyyyy");
		String mercado = "";
		Scanner teclado = new Scanner(System.in);
		log.info("URL Scaneada: ");
		// String url = teclado.nextLine();
		String url = "https://www.efactura.dgi.gub.uy/consultaQR/cfe?210301960011,101,A,466242,138,16/11/2019,i6GjRpxxOCYe4rY76ce2JsT2xtM%3d";
		url = url.substring(47, url.length());
		List<String> result = Arrays.asList(url.split("\\s*,\\s*"));
		Integer num = 0;
		log.info("Dtos Obtenido de la URL: ");
		log.info(result.toString());

		switch (result.get(0)) {
			// Frog
			// 214214350013
			case "214214350013" :
				mercado = "Frog";
				log.info("Mercado: " + mercado);
				num = Integer.parseInt(result.get(3));
				try {
					if (!new File(recurso.getResourse() + "/" + result.get(1) + result.get(2) + num.toString() + ".pdf").exists()) {
						TataTest frogTest = new TataTest();
						frogTest.tata(result.get(0), result.get(2), num.toString(), result.get(4), result.get(6).substring(0, 6));
					}
				} catch (Exception e) {
					log.error(e.getMessage());
				}
				PDF = recurso.getResourse() + result.get(1) + result.get(2) + num.toString() + ".pdf";
				Frog frog = new Frog();
				frog.leerDatos(PDF, recurso.getOutput() + mercado + ".txt");
				break;

			// Sluckis
			// 210301960011
			case "210301960011" :
				mercado = "Sluckis";
				log.info("Mercado: " + mercado);
				num = Integer.parseInt(result.get(3));
				try {
					if (!new File(recurso.getResourse() + "/" + result.get(0) + "-" + result.get(3) + ".pdf").exists()) {
						SluckisTest sluckisTest = new SluckisTest();
						sluckisTest.sluckis(result.get(0), result.get(2), num.toString(), result.get(4), result.get(6).substring(0, 6));
					}
				} catch (Exception e) {
					log.error(e.getMessage());
				}
				PDF = recurso.getResourse() + result.get(0) + "-" + result.get(3) + ".pdf";
				Sluckis sluckis = new Sluckis();
				sluckis.leerDatos(PDF, recurso.getOutput() + mercado + ".txt");
				break;
			// TATA
			// 210003270017
			case "210003270017" :
				mercado = "Tata";
				log.info("Mercado: " + mercado);
				num = Integer.parseInt(result.get(3));
				try {
					if (!new File(recurso.getResourse() + "/" + result.get(1) + result.get(2) + num.toString() + ".pdf").exists()) {
						TataTest tataTest = new TataTest();
						tataTest.tata(result.get(0), result.get(2), num.toString(), result.get(4), result.get(6).substring(0, 6));
					}
				} catch (Exception e) {
					log.error(e.getMessage());
				}
				PDF = recurso.getResourse() + result.get(1) + result.get(2) + num.toString() + ".pdf";
				Tata tata = new Tata();
				tata.leerDatos(PDF, recurso.getOutput() + mercado + ".txt");
				break;

			// Disco
			// 210274130017
			case "210274130017" :
				mercado = "Disco";
				log.info("Mercado: " + mercado);
				num = Integer.parseInt(result.get(3));
				try {
					if (!new File(recurso.getResourse() + "/" + result.get(1) + result.get(2) + num.toString() + ".pdf").exists()) {
						DiscoTest discoTest = new DiscoTest();
						discoTest.disco(result.get(0), result.get(2), result.get(3), result.get(4), result.get(6).substring(0, 6));
					}
				} catch (Exception e) {
					log.error(e.getMessage());
				}

				PDF = recurso.getResourse() + result.get(1) + result.get(2) + result.get(3) + ".pdf";

				Disco disco = new Disco();
				disco.leerDatos(PDF, recurso.getOutput() + mercado + ".txt");
				break;

			// Devoto Express
			// 210650500016
			case "210650500016" :
				mercado = "DevotoE";
				log.info("Mercado: " + mercado);
				num = Integer.parseInt(result.get(3));
				try {
					if (!new File(recurso.getResourse() + "/" + result.get(1) + result.get(2) + num.toString() + ".pdf").exists()) {
						DevotoTest devotoExpresTest = new DevotoTest();
						devotoExpresTest.devoto(result.get(0), result.get(2), result.get(3), result.get(4), result.get(6).substring(0, 6));
					}
				} catch (Exception e) {
					log.error(e.getMessage());
				}

				PDF = recurso.getResourse() + result.get(1) + result.get(2) + result.get(3) + ".pdf";

				DevotoE devotoExpres = new DevotoE();
				devotoExpres.leerDatos(PDF, recurso.getOutput() + mercado + ".txt");
				break;

			// Devoto
			// 210297450018
			case "210297450018" :
				mercado = "Devoto";
				log.info("Mercado: " + mercado);
				num = Integer.parseInt(result.get(3));
				try {
					if (!new File(recurso.getResourse() + "/" + result.get(1) + result.get(2) + num.toString() + ".pdf").exists()) {
						DevotoTest devotoTest = new DevotoTest();
						devotoTest.devoto(result.get(0), result.get(2), result.get(3), result.get(4), result.get(6).substring(0, 6));
					}
				} catch (Exception e) {
					log.error(e.getMessage());
				}

				PDF = recurso.getResourse() + result.get(1) + result.get(2) + result.get(3) + ".pdf";

				Devoto devoto = new Devoto();
				devoto.leerDatos(PDF, recurso.getOutput() + mercado + ".txt");
				break;

			// ElNaranjo
			// 214634020016
			case "214634020016" :
				mercado = "ElNaranjo";
				log.info("Mercado: " + mercado);

				try {
					// Descarga el Fichero

					Date d;
					d = format2.parse(result.get(5));
					String fecha = format.format(d);
					num = Integer.parseInt(result.get(3));
					if (!new File(recurso.getResourse() + "/" + result.get(1) + result.get(2) + num.toString() + ".pdf").exists()) {
						ScantechTest elNaranjoTest = new ScantechTest();
						elNaranjoTest.scantech(result.get(0), result.get(2), result.get(3), result.get(4), fecha, result.get(6).substring(0, 6));
					}
					// Renombrar el Fichero
					File file = new File(directorioRaiz + "/" + recurso.getResourse() + "/cfe.pdf");
					File file2 = new File(directorioRaiz + "/" + recurso.getResourse() + "/" + result.get(1) + result.get(2) + result.get(3) + ".pdf");
					file.renameTo(file2);

					PDF = recurso.getResourse() + result.get(1) + result.get(2) + result.get(3) + ".pdf";

					Scanntech elNaranjo = new Scanntech();
					elNaranjo.leerDatos(PDF, recurso.getOutput() + mercado + ".txt");
				} catch (ParseException e) {
					log.error(e.getMessage());
				}

				break;

			// Carnelandia
			// 211229400017
			case "211229400017" :
				mercado = "Carnelandia";
				log.info("Mercado: " + mercado);
				try {

					Date d;
					d = format2.parse(result.get(5));
					String fecha = format.format(d);
					num = Integer.parseInt(result.get(3));
					if (!new File(recurso.getResourse() + "/" + result.get(1) + result.get(2) + num.toString() + ".pdf").exists()) {
						ScantechTest carnelandiaTest = new ScantechTest();
						carnelandiaTest.scantech(result.get(0), result.get(2), result.get(3), result.get(4), fecha, result.get(6).substring(0, 6));
					}
					// Renombrar el Fichero
					File file = new File(directorioRaiz + "/" + recurso.getResourse() + "/cfe.pdf");
					File file2 = new File(directorioRaiz + "/" + recurso.getResourse() + "/" + result.get(1) + result.get(2) + result.get(3) + ".pdf");
					file.renameTo(file2);

					PDF = recurso.getResourse() + result.get(1) + result.get(2) + result.get(3) + ".pdf";

					Scanntech carnelandia = new Scanntech();
					carnelandia.leerDatos(PDF, recurso.getOutput() + mercado + ".txt");
				} catch (ParseException e) {
					log.error(e.getMessage());
				}

				break;

			// SuperAriel
			// 213304860012
			case "213304860012" :
				mercado = "SuperAriel";
				log.info("Mercado: " + mercado);
				try {

					Date d;
					d = format3.parse(result.get(5).replace("%2F", ""));
					String fecha = format.format(d);
					num = Integer.parseInt(result.get(3));
					if (!new File(recurso.getResourse() + "/" + result.get(1) + result.get(2) + num.toString() + ".pdf").exists()) {
						ScantechTest superArielTest = new ScantechTest();
						superArielTest.scantech(result.get(0), result.get(2), result.get(3), result.get(4), fecha, result.get(6).substring(0, 6));
					}
					// Renombrar el Fichero
					File file = new File(directorioRaiz + "/" + recurso.getResourse() + "/cfe.pdf");
					File file2 = new File(directorioRaiz + "/" + recurso.getResourse() + "/" + result.get(1) + result.get(2) + result.get(3) + ".pdf");
					file.renameTo(file2);

					PDF = recurso.getResourse() + result.get(1) + result.get(2) + result.get(3) + ".pdf";

					Scanntech superAriel = new Scanntech();
					superAriel.leerDatos(PDF, recurso.getOutput() + mercado + ".txt");
				} catch (ParseException e) {
					log.error(e.getMessage());
				}

				break;
			// Montserrat Panaderia
			// 214783760011
			case "214783760011" :
				mercado = "PanaderiaMontserrat";
				log.info("Mercado: " + mercado);
				try {

					Date d;
					d = format2.parse(result.get(5));
					String fecha = format.format(d);
					num = Integer.parseInt(result.get(3));
					if (!new File(recurso.getResourse() + "/" + result.get(1) + result.get(2) + num.toString() + ".pdf").exists()) {
						ScantechTest montserratTest = new ScantechTest();
						montserratTest.scantech(result.get(0), result.get(2), result.get(3), result.get(4), fecha, result.get(6).substring(0, 6));
					}
					// Renombrar el Fichero
					File file = new File(directorioRaiz + "/" + recurso.getResourse() + "/cfe.pdf");
					File file2 = new File(directorioRaiz + "/" + recurso.getResourse() + "/" + result.get(1) + result.get(2) + result.get(3) + ".pdf");
					file.renameTo(file2);

					PDF = recurso.getResourse() + result.get(1) + result.get(2) + result.get(3) + ".pdf";

					Scanntech montserrat = new Scanntech();
					montserrat.leerDatos(PDF, recurso.getOutput() + mercado + ".txt");
				} catch (ParseException e) {
					log.error(e.getMessage());
				}

				break;

			// Mercado Natural
			// 215058860011
			case "215058860011" :
				mercado = "MercadoNatural";
				log.info("Mercado: " + mercado);
				try {
					Date d;
					d = format3.parse(result.get(5).replace("%2F", ""));
					String fecha = format.format(d);
					num = Integer.parseInt(result.get(3));
					if (!new File(recurso.getResourse() + "/" + result.get(1) + result.get(2) + num.toString() + ".pdf").exists()) {
						ScantechTest mercadoNaturalTest = new ScantechTest();
						mercadoNaturalTest.scantech(result.get(0), result.get(2), result.get(3), result.get(4), fecha, result.get(6).substring(0, 6));
					}

					// Renombrar el Fichero
					File file = new File(directorioRaiz + "/" + recurso.getResourse() + "/cfe.pdf");
					File file2 = new File(directorioRaiz + "/" + recurso.getResourse() + "/" + result.get(1) + result.get(2) + result.get(3) + ".pdf");
					file.renameTo(file2);

					PDF = recurso.getResourse() + result.get(1) + result.get(2) + result.get(3) + ".pdf";

					Scanntech mercadoNatural = new Scanntech();
					mercadoNatural.leerDatos(PDF, recurso.getOutput() + mercado + ".txt");
				} catch (ParseException e) {
					log.error(e.getMessage());
				} catch (Exception e) {
					log.error(e.getMessage());
				}

				break;
			// DonPaulino
			// 211412910010
			case "211412910010" :
				mercado = "DonPaulino";
				log.info("Mercado: " + mercado);
				try {
					Date d;
					d = format2.parse(result.get(5));
					String fecha = format.format(d);
					num = Integer.parseInt(result.get(3));
					if (!new File(recurso.getResourse() + "/" + result.get(1) + result.get(2) + num.toString() + ".pdf").exists()) {
						ScantechTest mercadoNaturalTest = new ScantechTest();
						mercadoNaturalTest.scantech(result.get(0), result.get(2), result.get(3), result.get(4), fecha, result.get(6).substring(0, 6));
					}

					// Renombrar el Fichero
					File file = new File(directorioRaiz + "/" + recurso.getResourse() + "/cfe.pdf");
					File file2 = new File(directorioRaiz + "/" + recurso.getResourse() + "/" + result.get(1) + result.get(2) + result.get(3) + ".pdf");
					file.renameTo(file2);

					PDF = recurso.getResourse() + result.get(1) + result.get(2) + result.get(3) + ".pdf";

					Scanntech donPaulino = new Scanntech();
					donPaulino.leerDatos(PDF, recurso.getOutput() + mercado + ".txt");
				} catch (ParseException e) {
					log.error(e.getMessage());
				} catch (Exception e) {
					log.error(e.getMessage());
				}
				break;

			// Distravi
			// 211223740010
			case "211223740010" :
				mercado = "Distravi";
				log.info("Mercado Distravi");
				Distravi distravi = new Distravi();
				distravi.leerDatos(PDF, recurso.getOutput() + mercado + ".txt");
				break;

			case "AlmaNatural" :
				mercado = "AlmaNatural";
				AlmaNatural almaNatural = new AlmaNatural();
				almaNatural.leerDatos(PDF, recurso.getOutput() + mercado + ".txt");
				break;

			case "Itau" :
				mercado = "Itau";
				Itau itau = new Itau();
				itau.leerDatos(PDF, recurso.getOutput() + mercado + ".txt");
				break;

			default :
				break;
		}

	}

}
