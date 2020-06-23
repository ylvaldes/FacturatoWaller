package com.ylvaldes.leerpdf;

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

import com.ylvaldes.leerpdf.estadocuentas.Itau;
import com.ylvaldes.leerpdf.mercados.AlmaNatural;
import com.ylvaldes.leerpdf.mercados.Devoto;
import com.ylvaldes.leerpdf.mercados.DevotoE;
import com.ylvaldes.leerpdf.mercados.Disco;
import com.ylvaldes.leerpdf.mercados.Frog;
import com.ylvaldes.leerpdf.mercados.McDonals;
import com.ylvaldes.leerpdf.mercados.Scanntech;
import com.ylvaldes.leerpdf.mercados.Sluckis;
import com.ylvaldes.leerpdf.mercados.Tata;
import com.ylvaldes.leerpdf.obtenerpdf.DevotoTest;
import com.ylvaldes.leerpdf.obtenerpdf.DiscoTest;
import com.ylvaldes.leerpdf.obtenerpdf.McDonalsTest;
import com.ylvaldes.leerpdf.obtenerpdf.ObtenerPDF;
import com.ylvaldes.leerpdf.obtenerpdf.ScantechTest;
import com.ylvaldes.leerpdf.obtenerpdf.SluckisTest;
import com.ylvaldes.leerpdf.obtenerpdf.TataTest;
import com.ylvaldes.leerpdf.utiles.LoadResourceConfLeerPDF;

public class LeerPDF {

	private static final Logger log = LoggerFactory.getLogger(LeerPDF.class);
	static final String MSG_MERCADO = "Mercado: {}";
	static final String MSG_RENOMBRAR_ARCH = "Renombrando fichero {} por {}";
	static final String FILE_SEPARATOR = System.getProperty("file.separator");

	public static void main(String[] args) throws FileNotFoundException, IOException, ParserConfigurationException {
		// Obtiene las configuraciones Basicas de LoggerFactory
		BasicConfigurator.configure();

		String directorioRaiz = System.getProperty("user.dir");

		// Carga los recursos osososos
		LoadResourceConfLeerPDF recurso = new LoadResourceConfLeerPDF();
		recurso.loadResourceConf();
		SimpleDateFormat format = new SimpleDateFormat(recurso.getPatternFormatS());
		SimpleDateFormat format2 = new SimpleDateFormat("yyyyMMdd");
		SimpleDateFormat format3 = new SimpleDateFormat("ddMMyyyy");
		String mercado = "";
		String pdf = "";
		Scanner teclado = new Scanner(System.in);
		log.info("URL Scaneada: ");
		String url = teclado.nextLine();

		url = url.substring(47, url.length());
		List<String> result = Arrays.asList(url.split("\\s*,\\s*"));
		Integer num = 0;
		log.info("Dtos Obtenido de la URL: ");
		log.info(result.toString());

		switch (result.get(0)) {

			// McDonals
			// 211319220018
			case "211319220018" :
				mercado = "McDonals";
				log.info(MSG_MERCADO, mercado);
				num = Integer.parseInt(result.get(3));
				try {
					if (!new File(recurso.getResourse() + FILE_SEPARATOR + result.get(1) + result.get(2) + num.toString() + ".pdf").exists()) {
						ObtenerPDF obtenerPDF = new McDonalsTest();
						obtenerPDF.getPDF(result.get(0), result.get(2), num.toString(), result.get(4), result.get(6).substring(0, 6));
					}
				} catch (Exception e) {
					log.error(e.getMessage());
				}
				pdf = recurso.getResourse() + result.get(1) + result.get(2) + num.toString() + ".pdf";
				McDonals mcDonals = new McDonals();
				mcDonals.leerDatos(pdf, recurso.getOutput() + mercado + ".txt");
				break;

			// Frog
			// 214214350013
			case "214214350013" :
				mercado = "Frog";
				log.info(MSG_MERCADO, mercado);
				num = Integer.parseInt(result.get(3));
				try {
					if (!new File(recurso.getResourse() + FILE_SEPARATOR + result.get(1) + result.get(2) + num.toString() + ".pdf").exists()) {
						ObtenerPDF obtenerPDF = new TataTest();
						obtenerPDF.getPDF(result.get(0), result.get(2), num.toString(), result.get(4), result.get(6).substring(0, 6));
					}
				} catch (Exception e) {
					log.error(e.getMessage());
				}
				pdf = recurso.getResourse() + result.get(1) + result.get(2) + num.toString() + ".pdf";
				Frog frog = new Frog();
				frog.leerDatos(pdf, recurso.getOutput() + mercado + ".txt");
				break;

			// Sluckis
			// 210301960011
			case "210301960011" :
				mercado = "Sluckis";
				log.info(MSG_MERCADO, mercado);
				num = Integer.parseInt(result.get(3));
				try {
					if (!new File(recurso.getResourse() + FILE_SEPARATOR + result.get(0) + "-" + result.get(3) + ".pdf").exists()) {
						ObtenerPDF obtenerPDF = new SluckisTest();
						obtenerPDF.getPDF(result.get(0), result.get(2), num.toString(), result.get(4), result.get(6).substring(0, 6));
					}
				} catch (Exception e) {
					log.error(e.getMessage());
				}
				pdf = recurso.getResourse() + result.get(0) + "-" + result.get(3) + ".pdf";
				Sluckis sluckis = new Sluckis();
				sluckis.leerDatos(pdf, recurso.getOutput() + mercado + ".txt");
				break;
			// TATA
			// 210003270017
			case "210003270017" :
				mercado = "Tata";
				log.info(MSG_MERCADO, mercado);
				num = Integer.parseInt(result.get(3));
				try {
					if (!new File(recurso.getResourse() + FILE_SEPARATOR + result.get(1) + result.get(2) + num.toString() + ".pdf").exists()) {
						ObtenerPDF obtenerPDF = new TataTest();
						obtenerPDF.getPDF(result.get(0), result.get(2), num.toString(), result.get(4), result.get(6).substring(0, 6));
					}
				} catch (Exception e) {
					log.error(e.getMessage());
				}
				pdf = recurso.getResourse() + result.get(1) + result.get(2) + num.toString() + ".pdf";
				Tata tata = new Tata();
				tata.leerDatos(pdf, recurso.getOutput() + mercado + ".txt");
				break;

			// Disco
			// 210274130017
			case "210274130017" :
				mercado = "Disco";
				log.info(MSG_MERCADO, mercado);
				num = Integer.parseInt(result.get(3));
				try {
					if (!new File(recurso.getResourse() + FILE_SEPARATOR + result.get(1) + result.get(2) + num.toString() + ".pdf").exists()) {
						ObtenerPDF obtenerPDF = new DiscoTest();
						obtenerPDF.getPDF(result.get(0), result.get(2), result.get(3), result.get(4), result.get(6).substring(0, 6));
					}
				} catch (Exception e) {
					log.error(e.getMessage());
				}

				pdf = recurso.getResourse() + result.get(1) + result.get(2) + result.get(3) + ".pdf";

				Disco disco = new Disco();
				disco.leerDatos(pdf, recurso.getOutput() + mercado + ".txt");
				break;

			// Devoto Express
			// 210650500016
			case "210650500016" :
				mercado = "DevotoE";
				log.info(MSG_MERCADO, mercado);
				num = Integer.parseInt(result.get(3));
				try {
					if (!new File(recurso.getResourse() + FILE_SEPARATOR + result.get(1) + result.get(2) + num.toString() + ".pdf").exists()) {
						ObtenerPDF obtenerPDF = new DevotoTest();
						obtenerPDF.getPDF(result.get(0), result.get(2), result.get(3), result.get(4), result.get(6).substring(0, 6));
					}
				} catch (Exception e) {
					log.error(e.getMessage());
				}

				pdf = recurso.getResourse() + result.get(1) + result.get(2) + result.get(3) + ".pdf";

				DevotoE devotoExpres = new DevotoE();
				devotoExpres.leerDatos(pdf, recurso.getOutput() + mercado + ".txt");
				break;

			// Devoto
			// 210297450018
			case "210297450018" :
				mercado = "Devoto";
				log.info(MSG_MERCADO, mercado);
				num = Integer.parseInt(result.get(3));
				try {
					if (!new File(recurso.getResourse() + FILE_SEPARATOR + result.get(1) + result.get(2) + num.toString() + ".pdf").exists()) {
						ObtenerPDF obtenerPDF = new DevotoTest();
						obtenerPDF.getPDF(result.get(0), result.get(2), result.get(3), result.get(4), result.get(6).substring(0, 6));
					}
				} catch (Exception e) {
					log.error(e.getMessage());
				}

				pdf = recurso.getResourse() + result.get(1) + result.get(2) + result.get(3) + ".pdf";

				Devoto devoto = new Devoto();
				devoto.leerDatos(pdf, recurso.getOutput() + mercado + ".txt");
				break;

			// ElNaranjo
			// 214634020016
			case "214634020016" :
				mercado = "ElNaranjo";
				log.info(MSG_MERCADO, mercado);

				try {
					// Descarga el Fichero

					Date d;
					d = format2.parse(result.get(5));
					String fecha = format.format(d);
					num = Integer.parseInt(result.get(3));
					if (!new File(recurso.getResourse() + FILE_SEPARATOR + result.get(1) + result.get(2) + num.toString() + ".pdf").exists()) {
						ObtenerPDF obtenerPDF = new ScantechTest();
						obtenerPDF.getPDF(result.get(0), result.get(2), result.get(3), result.get(4), fecha, result.get(6).substring(0, 6));
					}
					// Renombrar el Fichero
					File file = new File(directorioRaiz + FILE_SEPARATOR + recurso.getResourse() + FILE_SEPARATOR + "cfe.pdf");
					File file2 = new File(directorioRaiz + FILE_SEPARATOR + recurso.getResourse() + FILE_SEPARATOR + result.get(1) + result.get(2) + result.get(3) + ".pdf");
					if (file.renameTo(file2)) {
						log.info(MSG_RENOMBRAR_ARCH, file.getName(), file2.getName());
					}

					pdf = recurso.getResourse() + result.get(1) + result.get(2) + result.get(3) + ".pdf";

					Scanntech elNaranjo = new Scanntech();
					elNaranjo.leerDatos(pdf, recurso.getOutput() + mercado + ".txt");
				} catch (ParseException e) {
					log.error(e.getMessage());
				}

				break;
				
				// Supermercado de la Villa
				// 200013970014
				case "200013970014" :
					mercado = "SupermercadoDeLaVilla";
					log.info(MSG_MERCADO, mercado);

					try {
						// Descarga el Fichero

						Date d;
						d = format3.parse(result.get(5).replace("%2F", ""));
						String fecha = format.format(d);
						num = Integer.parseInt(result.get(3));
						if (!new File(recurso.getResourse() + FILE_SEPARATOR + result.get(1) + result.get(2) + num.toString() + ".pdf").exists()) {
							ObtenerPDF obtenerPDF = new ScantechTest();
							obtenerPDF.getPDF(result.get(0), result.get(2), result.get(3), result.get(4), fecha, result.get(6).substring(0, 6));
						}
						// Renombrar el Fichero
						File file = new File(directorioRaiz + FILE_SEPARATOR + recurso.getResourse() + FILE_SEPARATOR + "cfe.pdf");
						File file2 = new File(directorioRaiz + FILE_SEPARATOR + recurso.getResourse() + FILE_SEPARATOR + result.get(1) + result.get(2) + result.get(3) + ".pdf");
						if (file.renameTo(file2)) {
							log.info(MSG_RENOMBRAR_ARCH, file.getName(), file2.getName());
						}

						pdf = recurso.getResourse() + result.get(1) + result.get(2) + result.get(3) + ".pdf";

						Scanntech elNaranjo = new Scanntech();
						elNaranjo.leerDatos(pdf, recurso.getOutput() + mercado + ".txt");
					} catch (ParseException e) {
						log.error(e.getMessage());
					}

					break;
					// Bianco Perez
					// 212125040012
					case "212125040012" :
						mercado = "BiancoPerez";
						log.info(MSG_MERCADO, mercado);

						try {
							// Descarga el Fichero

							Date d;
							d = format3.parse(result.get(5).replace("%2F", ""));
							String fecha = format.format(d);
							num = Integer.parseInt(result.get(3));
							if (!new File(recurso.getResourse() + FILE_SEPARATOR + result.get(1) + result.get(2) + num.toString() + ".pdf").exists()) {
								ObtenerPDF obtenerPDF = new ScantechTest();
								obtenerPDF.getPDF(result.get(0), result.get(2), result.get(3), result.get(4), fecha, result.get(6).replace("%2B", "+").substring(0, 6));
							}
							// Renombrar el Fichero
							File file = new File(directorioRaiz + FILE_SEPARATOR + recurso.getResourse() + FILE_SEPARATOR + "cfe.pdf");
							File file2 = new File(directorioRaiz + FILE_SEPARATOR + recurso.getResourse() + FILE_SEPARATOR + result.get(1) + result.get(2) + result.get(3) + ".pdf");
							if (file.renameTo(file2)) {
								log.info(MSG_RENOMBRAR_ARCH, file.getName(), file2.getName());
							}

							pdf = recurso.getResourse() + result.get(1) + result.get(2) + result.get(3) + ".pdf";

							Scanntech elNaranjo = new Scanntech();
							elNaranjo.leerDatos(pdf, recurso.getOutput() + mercado + ".txt");
						} catch (ParseException e) {
							log.error(e.getMessage());
						}

						break;

			// Natal
			// 217154870010
			case "217154870010" :
				mercado = "Natal";
				log.info(MSG_MERCADO, mercado);
				try {
					Date d;
					d = format3.parse(result.get(5).replace("%2F", ""));
					String fecha = format.format(d);
					num = Integer.parseInt(result.get(3));
					if (!new File(recurso.getResourse() + FILE_SEPARATOR + result.get(1) + result.get(2) + num.toString() + ".pdf").exists()) {
						ObtenerPDF obtenerPDF = new ScantechTest();
						obtenerPDF.getPDF(result.get(0), result.get(2), result.get(3), result.get(4), fecha, result.get(6).substring(0, 6));
					}
					// Renombrar el Fichero
					File file = new File(directorioRaiz + FILE_SEPARATOR + recurso.getResourse() + FILE_SEPARATOR + "cfe.pdf");
					File file2 = new File(directorioRaiz + FILE_SEPARATOR + recurso.getResourse() + FILE_SEPARATOR + result.get(1) + result.get(2) + result.get(3) + ".pdf");
					if (file.renameTo(file2)) {
						log.info(MSG_RENOMBRAR_ARCH, file.getName(), file2.getName());
					}

					pdf = recurso.getResourse() + result.get(1) + result.get(2) + result.get(3) + ".pdf";

					Scanntech carnelandia = new Scanntech();
					carnelandia.leerDatos(pdf, recurso.getOutput() + mercado + ".txt");
				} catch (ParseException e) {
					log.error(e.getMessage());
				}

				break;

			// Carnelandia
			// 211229400017
			case "211229400017" :
				mercado = "Carnelandia";
				log.info(MSG_MERCADO, mercado);
				try {
					Date d;
					d = format3.parse(result.get(5).replace("%2F", ""));
					String fecha = format.format(d);
					num = Integer.parseInt(result.get(3));
					if (!new File(recurso.getResourse() + FILE_SEPARATOR + result.get(1) + result.get(2) + num.toString() + ".pdf").exists()) {
						ObtenerPDF obtenerPDF = new ScantechTest();
						obtenerPDF.getPDF(result.get(0), result.get(2), result.get(3), result.get(4), fecha, result.get(6).substring(0, 6));
					}
					// Renombrar el Fichero
					File file = new File(directorioRaiz + FILE_SEPARATOR + recurso.getResourse() + FILE_SEPARATOR + "cfe.pdf");
					File file2 = new File(directorioRaiz + FILE_SEPARATOR + recurso.getResourse() + FILE_SEPARATOR + result.get(1) + result.get(2) + result.get(3) + ".pdf");
					if (file.renameTo(file2)) {
						log.info(MSG_RENOMBRAR_ARCH, file.getName(), file2.getName());
					}

					pdf = recurso.getResourse() + result.get(1) + result.get(2) + result.get(3) + ".pdf";

					Scanntech carnelandia = new Scanntech();
					carnelandia.leerDatos(pdf, recurso.getOutput() + mercado + ".txt");
				} catch (ParseException e) {
					log.error(e.getMessage());
				}

				break;

			// SuperUSAColonia
			// 216270160018
			case "216270160018" :
				mercado = "SuperUSAColonia";
				log.info(MSG_MERCADO, mercado);
				try {
					Date d;
					d = format3.parse(result.get(5).replace("%2F", ""));
					String fecha = format.format(d);
					num = Integer.parseInt(result.get(3));
					if (!new File(recurso.getResourse() + FILE_SEPARATOR + result.get(1) + result.get(2) + num.toString() + ".pdf").exists()) {
						ObtenerPDF obtenerPDF = new ScantechTest();
						obtenerPDF.getPDF(result.get(0), result.get(2), result.get(3), result.get(4), fecha, result.get(6).substring(0, 6));
					}
					// Renombrar el Fichero
					File file = new File(directorioRaiz + FILE_SEPARATOR + recurso.getResourse() + FILE_SEPARATOR + "cfe.pdf");
					File file2 = new File(directorioRaiz + FILE_SEPARATOR + recurso.getResourse() + FILE_SEPARATOR + result.get(1) + result.get(2) + result.get(3) + ".pdf");
					if (file.renameTo(file2)) {
						log.info(MSG_RENOMBRAR_ARCH, file.getName(), file2.getName());
					}

					pdf = recurso.getResourse() + result.get(1) + result.get(2) + result.get(3) + ".pdf";

					Scanntech carnelandia = new Scanntech();
					carnelandia.leerDatos(pdf, recurso.getOutput() + mercado + ".txt");
				} catch (ParseException e) {
					log.error(e.getMessage());
				}

				break;

			// SuperMercadoEconomico
			// 213938880017
			case "213938880017" :
				mercado = "SuperMercadoEconomico";
				log.info(MSG_MERCADO, mercado);

				try {
					// Descarga el Fichero

					Date d;
					d = format3.parse(result.get(5).replace("%2F", ""));
					String fecha = format.format(d);
					num = Integer.parseInt(result.get(3));
					if (!new File(recurso.getResourse() + FILE_SEPARATOR + result.get(1) + result.get(2) + num.toString() + ".pdf").exists()) {
						ObtenerPDF obtenerPDF = new ScantechTest();
						obtenerPDF.getPDF(result.get(0), result.get(2), result.get(3), result.get(4), fecha, result.get(6).substring(0, 6));
					}
					// Renombrar el Fichero
					File file = new File(directorioRaiz + FILE_SEPARATOR + recurso.getResourse() + FILE_SEPARATOR + "cfe.pdf");
					File file2 = new File(directorioRaiz + FILE_SEPARATOR + recurso.getResourse() + FILE_SEPARATOR + result.get(1) + result.get(2) + result.get(3) + ".pdf");
					if (file.renameTo(file2)) {
						log.info(MSG_RENOMBRAR_ARCH, file.getName(), file2.getName());
					}

					pdf = recurso.getResourse() + result.get(1) + result.get(2) + result.get(3) + ".pdf";

					Scanntech elNaranjo = new Scanntech();
					elNaranjo.leerDatos(pdf, recurso.getOutput() + mercado + ".txt");
				} catch (ParseException e) {
					log.error(e.getMessage());
				}

				break;

			// SuperAriel
			// 213304860012
			case "213304860012" :
				mercado = "SuperAriel";
				log.info(MSG_MERCADO, mercado);
				try {

					Date d;
					d = format3.parse(result.get(5).replace("%2F", ""));
					String fecha = format.format(d);
					num = Integer.parseInt(result.get(3));
					if (!new File(recurso.getResourse() + FILE_SEPARATOR + result.get(1) + result.get(2) + num.toString() + ".pdf").exists()) {
						ObtenerPDF obtenerPDF = new ScantechTest();
						obtenerPDF.getPDF(result.get(0), result.get(2), result.get(3), result.get(4), fecha, result.get(6).substring(0, 6));
					}
					// Renombrar el Fichero
					File file = new File(directorioRaiz + FILE_SEPARATOR + recurso.getResourse() + FILE_SEPARATOR + "cfe.pdf");
					File file2 = new File(directorioRaiz + FILE_SEPARATOR + recurso.getResourse() + FILE_SEPARATOR + result.get(1) + result.get(2) + result.get(3) + ".pdf");
					if (file.renameTo(file2)) {
						log.info(MSG_RENOMBRAR_ARCH, file.getName(), file2.getName());
					}

					pdf = recurso.getResourse() + result.get(1) + result.get(2) + result.get(3) + ".pdf";

					Scanntech superAriel = new Scanntech();
					superAriel.leerDatos(pdf, recurso.getOutput() + mercado + ".txt");
				} catch (ParseException e) {
					log.error(e.getMessage());
				}
				break;

			// Montserrat Panaderia
			// 214783760011
			case "214783760011" :
				mercado = "PanaderiaMontserrat";
				log.info(MSG_MERCADO, mercado);
				try {

					Date d;
					d = format2.parse(result.get(5));
					String fecha = format.format(d);
					num = Integer.parseInt(result.get(3));
					if (!new File(recurso.getResourse() + FILE_SEPARATOR + result.get(1) + result.get(2) + num.toString() + ".pdf").exists()) {
						ObtenerPDF obtenerPDF = new ScantechTest();
						obtenerPDF.getPDF(result.get(0), result.get(2), result.get(3), result.get(4), fecha, result.get(6).substring(0, 6));
					}
					// Renombrar el Fichero
					File file = new File(directorioRaiz + FILE_SEPARATOR + recurso.getResourse() + FILE_SEPARATOR + "cfe.pdf");
					File file2 = new File(directorioRaiz + FILE_SEPARATOR + recurso.getResourse() + FILE_SEPARATOR + result.get(1) + result.get(2) + result.get(3) + ".pdf");
					if (file.renameTo(file2)) {
						log.info(MSG_RENOMBRAR_ARCH, file.getName(), file2.getName());
					}

					pdf = recurso.getResourse() + result.get(1) + result.get(2) + result.get(3) + ".pdf";

					Scanntech montserrat = new Scanntech();
					montserrat.leerDatos(pdf, recurso.getOutput() + mercado + ".txt");
				} catch (ParseException e) {
					log.error(e.getMessage());
				}

				break;

			// Mercado Natural
			// 215058860011
			case "215058860011" :
				mercado = "MercadoNatural";
				log.info(MSG_MERCADO, mercado);
				try {
					Date d;
					d = format3.parse(result.get(5).replace("%2F", ""));
					String fecha = format.format(d);
					num = Integer.parseInt(result.get(3));
					if (!new File(recurso.getResourse() + FILE_SEPARATOR + result.get(1) + result.get(2) + num.toString() + ".pdf").exists()) {
						ObtenerPDF obtenerPDF = new ScantechTest();
						obtenerPDF.getPDF(result.get(0), result.get(2), result.get(3), result.get(4), fecha, result.get(6).substring(0, 6));
					}

					// Renombrar el Fichero
					File file = new File(directorioRaiz + FILE_SEPARATOR + recurso.getResourse() + FILE_SEPARATOR + "cfe.pdf");
					File file2 = new File(directorioRaiz + FILE_SEPARATOR + recurso.getResourse() + FILE_SEPARATOR + result.get(1) + result.get(2) + result.get(3) + ".pdf");
					if (file.renameTo(file2)) {
						log.info(MSG_RENOMBRAR_ARCH, file.getName(), file2.getName());
					}

					pdf = recurso.getResourse() + result.get(1) + result.get(2) + result.get(3) + ".pdf";

					Scanntech mercadoNatural = new Scanntech();
					mercadoNatural.leerDatos(pdf, recurso.getOutput() + mercado + ".txt");
				} catch (Exception e) {
					log.error(e.getMessage());
				}

				break;
			// DonPaulino
			// 211412910010
			case "211412910010" :
				mercado = "DonPaulino";
				log.info(MSG_MERCADO, mercado);
				try {
					Date d;
					d = format2.parse(result.get(5));
					String fecha = format.format(d);
					num = Integer.parseInt(result.get(3));
					if (!new File(recurso.getResourse() + FILE_SEPARATOR + result.get(1) + result.get(2) + num.toString() + ".pdf").exists()) {
						ObtenerPDF obtenerPDF = new ScantechTest();
						obtenerPDF.getPDF(result.get(0), result.get(2), result.get(3), result.get(4), fecha, result.get(6).substring(0, 6));
					}

					// Renombrar el Fichero
					File file = new File(directorioRaiz + FILE_SEPARATOR + recurso.getResourse() + FILE_SEPARATOR + "cfe.pdf");
					File file2 = new File(directorioRaiz + FILE_SEPARATOR + recurso.getResourse() + FILE_SEPARATOR + result.get(1) + result.get(2) + result.get(3) + ".pdf");
					if (file.renameTo(file2)) {
						log.info(MSG_RENOMBRAR_ARCH, file.getName(), file2.getName());
					}

					pdf = recurso.getResourse() + result.get(1) + result.get(2) + result.get(3) + ".pdf";

					Scanntech donPaulino = new Scanntech();
					donPaulino.leerDatos(pdf, recurso.getOutput() + mercado + ".txt");
				} catch (Exception e) {
					log.error(e.getMessage());
				}
				break;

			// Distravi
			// 211223740010
			case "211223740010" :
				mercado = "Distravi";
				log.info(MSG_MERCADO, mercado);
				try {
					Date d;
					d = format3.parse(result.get(5).replace("%2F", ""));
					String fecha = format.format(d);
					num = Integer.parseInt(result.get(3));
					if (!new File(recurso.getResourse() + FILE_SEPARATOR + result.get(1) + result.get(2) + num.toString() + ".pdf").exists()) {
						ObtenerPDF obtenerPDF = new ScantechTest();
						obtenerPDF.getPDF(result.get(0), result.get(2), result.get(3), result.get(4), fecha, result.get(6).substring(0, 6));
					}

					// Renombrar el Fichero
					File file = new File(directorioRaiz + FILE_SEPARATOR + recurso.getResourse() + FILE_SEPARATOR + "cfe.pdf");
					File file2 = new File(directorioRaiz + FILE_SEPARATOR + recurso.getResourse() + FILE_SEPARATOR + result.get(1) + result.get(2) + result.get(3) + ".pdf");
					if (file.renameTo(file2)) {
						log.info(MSG_RENOMBRAR_ARCH, file.getName(), file2.getName());
					}

					pdf = recurso.getResourse() + result.get(1) + result.get(2) + result.get(3) + ".pdf";

					Scanntech ditravis = new Scanntech();
					ditravis.leerDatos(pdf, recurso.getOutput() + mercado + ".txt");
				} catch (Exception e) {
					log.error(e.getMessage());
				}
				break;

			case "AlmaNatural" :
				mercado = "AlmaNatural";
				log.info(MSG_MERCADO, mercado);
				AlmaNatural almaNatural = new AlmaNatural();
				almaNatural.leerDatos(pdf, recurso.getOutput() + mercado + ".txt");
				break;

			case "Itau" :
				mercado = "Banco Itau";
				log.info(MSG_MERCADO, mercado);
				Itau itau = new Itau();
				itau.leerDatos(pdf, recurso.getOutput() + mercado + ".txt");
				break;

			default :
				break;
		}

	}

}
