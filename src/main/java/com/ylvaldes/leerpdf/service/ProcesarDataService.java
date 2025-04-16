package com.ylvaldes.leerpdf.service;

import com.ylvaldes.leerpdf.estadocuentas.Itau;
import com.ylvaldes.leerpdf.mercados.*;
import com.ylvaldes.leerpdf.obtenerpdf.*;
import com.ylvaldes.leerpdf.utiles.LoadResourceConfLeerPDF;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * @author YasmaniLedesmaValdez
 * @project FacturaToWaller
 * @package com.ylvaldes.leerpdf.service
 * @created 22/4/2023
 * @implNote
 */
public class ProcesarDataService {

    private static final Logger log = LogManager.getLogger(ProcesarDataService.class);
    // Obtiene las configuraciones Basicas de LoggerFactory

    String directorioRaiz = System.getProperty("user.dir");
    static final String MSG_MERCADO = "Mercado: {}";
    static final String MSG_RENOMBRAR_ARCH = "Renombrando fichero {} por {}";
    static final String FILE_SEPARATOR = System.getProperty("file.separator");


    SimpleDateFormat format2 = new SimpleDateFormat("yyyyMMdd");
    SimpleDateFormat format3 = new SimpleDateFormat("ddMMyyyy");
    String mercado = "";
    String pdf = "";

    public boolean procesarData(List<String> result, LoadResourceConfLeerPDF recurso) throws IOException {
        boolean respond = false;
        SimpleDateFormat format = new SimpleDateFormat(recurso.getPatternFormatS());
        Integer num = 0;
        log.info("Dtos Obtenido de la URL: ");
        log.info(result.toString());

        switch (result.get(0)) {

            // McDonals
            // 211319220018
            case "211319220018":
                mercado = "McDonals";
                log.info(MSG_MERCADO, mercado);
                num = Integer.parseInt(result.get(3));
                try {
                    if (!new File(recurso.getResourse() + FILE_SEPARATOR + result.get(1) + result.get(2) + num.toString()
                            + ".pdf").exists()) {
                        ObtenerPDF obtenerPDF = new McDonalsTest();
                        obtenerPDF.getPDF(result.get(0), result.get(2), num.toString(), result.get(4),
                                result.get(6).substring(0, 6));
                    }
                } catch (Exception e) {
                    log.error(e.getMessage());
                }
                pdf = recurso.getResourse() + result.get(1) + result.get(2) + num.toString() + ".pdf";
                McDonals mcDonals = new McDonals();
                mcDonals.leerDatos(pdf, recurso.getOutput() + mercado + ".txt");
                respond = true;
                break;

            // Frog
            // 214214350013
            case "214214350013":
                mercado = "Frog";
                log.info(MSG_MERCADO, mercado);
                num = Integer.parseInt(result.get(3));
                try {
                    if (!new File(recurso.getResourse() + FILE_SEPARATOR + result.get(1) + result.get(2) + num.toString()
                            + ".pdf").exists()) {
                        ObtenerPDF obtenerPDF = new TataTest();
                        obtenerPDF.getPDF(result.get(0), result.get(2), num.toString(), result.get(4),
                                result.get(6).substring(0, 6));
                    }
                } catch (Exception e) {
                    log.error(e.getMessage());
                }
                pdf = recurso.getResourse() + result.get(1) + result.get(2) + num.toString() + ".pdf";
                Frog frog = new Frog();
                frog.leerDatos(pdf, recurso.getOutput() + mercado + ".txt");
                respond = true;
                break;

            // Sluckis
            // 210301960011
            case "210301960011":
                mercado = "Sluckis";
                log.info(MSG_MERCADO, mercado);
                num = Integer.parseInt(result.get(3));
                try {
                    if (!new File(recurso.getResourse() + FILE_SEPARATOR + result.get(0) + "-" + result.get(3) + ".pdf")
                            .exists()) {
                        ObtenerPDF obtenerPDF = new SluckisTest();
                        obtenerPDF.getPDF(result.get(0), result.get(2), num.toString(), result.get(4),
                                result.get(6).substring(0, 6));
                    }
                } catch (Exception e) {
                    log.error(e.getMessage());
                }
                pdf = recurso.getResourse() + result.get(0) + "-" + result.get(3) + ".pdf";
                Sluckis sluckis = new Sluckis();
                sluckis.leerDatos(pdf, recurso.getOutput() + mercado + ".txt");
                respond = true;
                break;
            // TATA
            // 210003270017
            case "210003270017":
                mercado = "Tata";
                log.info(MSG_MERCADO, mercado);
                num = Integer.parseInt(result.get(3));
                try {
                    if (!new File(recurso.getResourse() + FILE_SEPARATOR + result.get(1) + result.get(2) + num.toString()
                            + ".pdf").exists()) {
                        ObtenerPDF obtenerPDF = new TataTest();
                        obtenerPDF.getPDF(result.get(0), result.get(2), num.toString(), result.get(4),
                                result.get(6).substring(0, 6));
                    }
                    pdf = recurso.getResourse() + result.get(1) + result.get(2) + num.toString() + ".pdf";
                    Tata tata = new Tata();
                    tata.leerDatos(pdf, recurso.getOutput() + mercado + ".txt");
                } catch (Exception e) {
                    respond = false;
                    log.error(e.getMessage());
                }
                respond = true;
                break;

            // Disco
            // 210274130017
            case "210274130017":
                mercado = "Disco";
                log.info(MSG_MERCADO, mercado);
                num = Integer.parseInt(result.get(3));
                try {
                    if (!new File(recurso.getResourse() + FILE_SEPARATOR + result.get(1) + result.get(2) + num.toString()
                            + ".pdf").exists()) {
                        ObtenerPDF obtenerPDF = new DiscoTest();
                        obtenerPDF.getPDF(result.get(0), result.get(2), result.get(3), result.get(4),
                                result.get(6).substring(0, 6));
                    }
                } catch (Exception e) {
                    log.error(e.getMessage());
                }

                pdf = recurso.getResourse() + result.get(1) + result.get(2) + result.get(3) + ".pdf";

                Disco disco = new Disco();
                disco.leerDatos(pdf, recurso.getOutput() + mercado + ".txt");
                respond = true;
                break;

            // Devoto Express
            // 210650500016
            case "210650500016":
                mercado = "DevotoE";
                log.info(MSG_MERCADO, mercado);
                num = Integer.parseInt(result.get(3));
                try {
                    if (!new File(recurso.getResourse() + FILE_SEPARATOR + result.get(1) + result.get(2) + num.toString()
                            + ".pdf").exists()) {
                        ObtenerPDF obtenerPDF = new DevotoTest();
                        obtenerPDF.getPDF(result.get(0), result.get(2), result.get(3), result.get(4),
                                result.get(6).substring(0, 6));
                    }
                } catch (Exception e) {
                    log.error(e.getMessage());
                }

                pdf = recurso.getResourse() + result.get(1) + result.get(2) + result.get(3) + ".pdf";

                DevotoE devotoExpres = new DevotoE();
                devotoExpres.leerDatos(pdf, recurso.getOutput() + mercado + ".txt");
                respond = true;
                break;

            // Devoto
            // 210297450018
            case "210297450018":
                mercado = "Devoto";
                log.info(MSG_MERCADO, mercado);
                num = Integer.parseInt(result.get(3));
                try {
                    if (!new File(recurso.getResourse() + FILE_SEPARATOR + result.get(1) + result.get(2) + num.toString()
                            + ".pdf").exists()) {
                        ObtenerPDF obtenerPDF = new DevotoTest();
                        obtenerPDF.getPDF(result.get(0), result.get(2), result.get(3), result.get(4),
                                result.get(6).substring(0, 6));
                    }
                } catch (Exception e) {
                    log.error(e.getMessage());
                }

                pdf = recurso.getResourse() + result.get(1) + result.get(2) + result.get(3) + ".pdf";

                Devoto devoto = new Devoto();
                devoto.leerDatos(pdf, recurso.getOutput() + mercado + ".txt");
                respond = true;
                break;

            // ElNaranjo
            // 214634020016
            case "214634020016":
                mercado = "ElNaranjo";
                log.info(MSG_MERCADO, mercado);

                try {
                    // Descarga el Fichero

                    Date d;
                    d = format3.parse(result.get(5).replace("%2F", ""));
                    String fecha = format.format(d);

                    num = Integer.parseInt(result.get(3));
                    if (!new File(recurso.getResourse() + FILE_SEPARATOR + result.get(1) + result.get(2) + num.toString()
                            + ".pdf").exists()) {
                        ObtenerPDF obtenerPDF = new ScantechTest();
                        obtenerPDF.getPDF(result.get(0), result.get(2), result.get(3), result.get(4), fecha,
                                result.get(6).substring(0, 6));
                    }
                    // Renombrar el Fichero
                    File file = new File(
                            directorioRaiz + FILE_SEPARATOR + recurso.getResourse() + FILE_SEPARATOR + "cfe.pdf");
                    File file2 = new File(directorioRaiz + FILE_SEPARATOR + recurso.getResourse() + FILE_SEPARATOR
                            + result.get(1) + result.get(2) + result.get(3) + ".pdf");
                    if (file.renameTo(file2)) {
                        log.info(MSG_RENOMBRAR_ARCH, file.getName(), file2.getName());
                    }

                    pdf = recurso.getResourse() + result.get(1) + result.get(2) + result.get(3) + ".pdf";

                    Scanntech elNaranjo = new Scanntech();
                    elNaranjo.leerDatos(pdf, recurso.getOutput() + mercado + ".txt");
                } catch (ParseException e) {
                    log.error(e.getMessage());
                }
                respond = true;
                break;

            // ElNaranjo
            // 214634020016
            case "218845760012":
                mercado = "ElNaranjo";
                log.info(MSG_MERCADO, mercado);

                try {
                    // Descarga el Fichero

                    Date d;
                    d = format3.parse(result.get(5).replace("%2F", ""));
                    String fecha = format.format(d);

                    num = Integer.parseInt(result.get(3));
                    if (!new File(recurso.getResourse() + FILE_SEPARATOR + result.get(1) + result.get(2) + num.toString()
                            + ".pdf").exists()) {
                        ObtenerPDF obtenerPDF = new ScantechTest();
                        obtenerPDF.getPDF(result.get(0), result.get(2), result.get(3), result.get(4), fecha,
                                result.get(6).substring(0, 6));
                    }
                    // Renombrar el Fichero
                    File file = new File(
                            directorioRaiz + FILE_SEPARATOR + recurso.getResourse() + FILE_SEPARATOR + "cfe.pdf");
                    File file2 = new File(directorioRaiz + FILE_SEPARATOR + recurso.getResourse() + FILE_SEPARATOR
                            + result.get(1) + result.get(2) + result.get(3) + ".pdf");
                    if (file.renameTo(file2)) {
                        log.info(MSG_RENOMBRAR_ARCH, file.getName(), file2.getName());
                    }

                    pdf = recurso.getResourse() + result.get(1) + result.get(2) + result.get(3) + ".pdf";

                    Scanntech elNaranjo = new Scanntech();
                    elNaranjo.leerDatos(pdf, recurso.getOutput() + mercado + ".txt");
                } catch (ParseException e) {
                    log.error(e.getMessage());
                }
                respond = true;
                break;

            // Supermercado de la Villa
            // 200013970014
            case "200013970014":
                mercado = "SupermercadoDeLaVilla";
                log.info(MSG_MERCADO, mercado);

                try {
                    // Descarga el Fichero

                    num = Integer.parseInt(result.get(3));
                    if (!new File(recurso.getResourse() + FILE_SEPARATOR + result.get(1) + result.get(2) + num.toString()
                            + ".pdf").exists()) {
                        ObtenerPDF obtenerPDF = new ScantechTest();
                        obtenerPDF.getPDF(result.get(0), result.get(2), result.get(3), result.get(4), result.get(5),
                                result.get(6).substring(0, 6));
                    }
                    // Renombrar el Fichero
                    File file = new File(
                            directorioRaiz + FILE_SEPARATOR + recurso.getResourse() + FILE_SEPARATOR + "cfe.pdf");
                    File file2 = new File(directorioRaiz + FILE_SEPARATOR + recurso.getResourse() + FILE_SEPARATOR
                            + result.get(1) + result.get(2) + result.get(3) + ".pdf");
                    if (file.renameTo(file2)) {
                        log.info(MSG_RENOMBRAR_ARCH, file.getName(), file2.getName());
                    }

                    pdf = recurso.getResourse() + result.get(1) + result.get(2) + result.get(3) + ".pdf";

                    Scanntech elNaranjo = new Scanntech();
                    elNaranjo.leerDatos(pdf, recurso.getOutput() + mercado + ".txt");
                } catch (Exception e) {
                    log.error(e.getMessage());
                }
                respond = true;
                break;
            //La Parrilla
            case "200171150018":
                mercado = "LaParrilla33";
                log.info(MSG_MERCADO, mercado);

                try {
                    // Descarga el Fichero

                    Date d;
                    d = format3.parse(result.get(5).replace("%2F", ""));
                    String fecha = format.format(d);
                    num = Integer.parseInt(result.get(3));
                    if (!new File(recurso.getResourse() + FILE_SEPARATOR + result.get(1) + result.get(2) + num.toString()
                            + ".pdf").exists()) {
                        ObtenerPDF obtenerPDF = new ScantechTest();
                        obtenerPDF.getPDF(result.get(0), result.get(2), result.get(3), result.get(4), fecha,
                                result.get(6).substring(0, 6));
                    }
                    // Renombrar el Fichero
                    File file = new File(
                            directorioRaiz + FILE_SEPARATOR + recurso.getResourse() + FILE_SEPARATOR + "cfe.pdf");
                    File file2 = new File(directorioRaiz + FILE_SEPARATOR + recurso.getResourse() + FILE_SEPARATOR
                            + result.get(1) + result.get(2) + result.get(3) + ".pdf");
                    if (file.renameTo(file2)) {
                        log.info(MSG_RENOMBRAR_ARCH, file.getName(), file2.getName());
                    }

                    pdf = recurso.getResourse() + result.get(1) + result.get(2) + result.get(3) + ".pdf";

                    Scanntech elNaranjo = new Scanntech();
                    elNaranjo.leerDatos(pdf, recurso.getOutput() + mercado + ".txt");
                } catch (ParseException e) {
                    log.error(e.getMessage());
                }
                respond = true;
                break;
            // Bianco Perez
            // 212125040012
            case "212125040012":
                mercado = "BiancoPerez";
                log.info(MSG_MERCADO, mercado);

                try {
                    // Descarga el Fichero

                    Date d;
                    d = format3.parse(result.get(5).replace("%2F", ""));
                    String fecha = format.format(d);
                    num = Integer.parseInt(result.get(3));
                    if (!new File(recurso.getResourse() + FILE_SEPARATOR + result.get(1) + result.get(2) + num.toString()
                            + ".pdf").exists()) {
                        ObtenerPDF obtenerPDF = new ScantechTest();
                        obtenerPDF.getPDF(result.get(0), result.get(2), result.get(3), result.get(4), fecha,
                                result.get(6).replace("%2B", "+").substring(0, 6));
                    }
                    // Renombrar el Fichero
                    File file = new File(
                            directorioRaiz + FILE_SEPARATOR + recurso.getResourse() + FILE_SEPARATOR + "cfe.pdf");
                    File file2 = new File(directorioRaiz + FILE_SEPARATOR + recurso.getResourse() + FILE_SEPARATOR
                            + result.get(1) + result.get(2) + result.get(3) + ".pdf");
                    if (file.renameTo(file2)) {
                        log.info(MSG_RENOMBRAR_ARCH, file.getName(), file2.getName());
                    }

                    pdf = recurso.getResourse() + result.get(1) + result.get(2) + result.get(3) + ".pdf";

                    Scanntech elNaranjo = new Scanntech();
                    elNaranjo.leerDatos(pdf, recurso.getOutput() + mercado + ".txt");
                } catch (ParseException e) {
                    log.error(e.getMessage());
                }
                respond = true;
                break;

            // Natal 10
            // 217154870010
            case "215528930010":
                mercado = "Natal";
                log.info(MSG_MERCADO, mercado);
                try {
                    Date d;
                    d = format3.parse(result.get(5).replace("%2F", ""));
                    String fecha = format.format(d);
                    num = Integer.parseInt(result.get(3));
                    if (!new File(recurso.getResourse() + FILE_SEPARATOR + result.get(1) + result.get(2) + num.toString()
                            + ".pdf").exists()) {
                        ObtenerPDF obtenerPDF = new ScantechTest();
                        obtenerPDF.getPDF(result.get(0), result.get(2), result.get(3), result.get(4), fecha,
                                result.get(6).substring(0, 6));
                    }
                    // Renombrar el Fichero
                    File file = new File(
                            directorioRaiz + FILE_SEPARATOR + recurso.getResourse() + FILE_SEPARATOR + "cfe.pdf");
                    File file2 = new File(directorioRaiz + FILE_SEPARATOR + recurso.getResourse() + FILE_SEPARATOR
                            + result.get(1) + result.get(2) + result.get(3) + ".pdf");
                    if (file.renameTo(file2)) {
                        log.info(MSG_RENOMBRAR_ARCH, file.getName(), file2.getName());
                    }

                    pdf = recurso.getResourse() + result.get(1) + result.get(2) + result.get(3) + ".pdf";

                    Scanntech carnelandia = new Scanntech();
                    carnelandia.leerDatos(pdf, recurso.getOutput() + mercado + ".txt");
                } catch (ParseException e) {
                    log.error(e.getMessage());
                }
                respond = true;
                break;

            // Natal 4
            // 215913850013
            case "215913850013":
                mercado = "Natal";
                log.info(MSG_MERCADO, mercado);
                try {
                    Date d;
                    d = format3.parse(result.get(5).replace("%2F", ""));
                    String fecha = format.format(d);
                    num = Integer.parseInt(result.get(3));
                    if (!new File(recurso.getResourse() + FILE_SEPARATOR + result.get(1) + result.get(2) + num.toString()
                            + ".pdf").exists()) {
                        ObtenerPDF obtenerPDF = new ScantechTest();
                        obtenerPDF.getPDF(result.get(0), result.get(2), result.get(3), result.get(4), fecha,
                                result.get(6).substring(0, 6));
                    }
                    // Renombrar el Fichero
                    File file = new File(
                            directorioRaiz + FILE_SEPARATOR + recurso.getResourse() + FILE_SEPARATOR + "cfe.pdf");
                    File file2 = new File(directorioRaiz + FILE_SEPARATOR + recurso.getResourse() + FILE_SEPARATOR
                            + result.get(1) + result.get(2) + result.get(3) + ".pdf");
                    if (file.renameTo(file2)) {
                        log.info(MSG_RENOMBRAR_ARCH, file.getName(), file2.getName());
                    }

                    pdf = recurso.getResourse() + result.get(1) + result.get(2) + result.get(3) + ".pdf";

                    Scanntech carnelandia = new Scanntech();
                    carnelandia.leerDatos(pdf, recurso.getOutput() + mercado + ".txt");
                } catch (ParseException e) {
                    log.error(e.getMessage());
                }
                respond = true;
                break;
            // Natal
            // 217154870010
            case "217154870010":
                mercado = "Natal";
                log.info(MSG_MERCADO, mercado);
                try {
                    Date d;
                    d = format3.parse(result.get(5).replace("%2F", ""));
                    String fecha = format.format(d);
                    num = Integer.parseInt(result.get(3));
                    if (!new File(recurso.getResourse() + FILE_SEPARATOR + result.get(1) + result.get(2) + num.toString()
                            + ".pdf").exists()) {
                        ObtenerPDF obtenerPDF = new ScantechTest();
                        obtenerPDF.getPDF(result.get(0), result.get(2), result.get(3), result.get(4), fecha,
                                result.get(6).substring(0, 6));
                    }
                    // Renombrar el Fichero
                    File file = new File(
                            directorioRaiz + FILE_SEPARATOR + recurso.getResourse() + FILE_SEPARATOR + "cfe.pdf");
                    File file2 = new File(directorioRaiz + FILE_SEPARATOR + recurso.getResourse() + FILE_SEPARATOR
                            + result.get(1) + result.get(2) + result.get(3) + ".pdf");
                    if (file.renameTo(file2)) {
                        log.info(MSG_RENOMBRAR_ARCH, file.getName(), file2.getName());
                    }

                    pdf = recurso.getResourse() + result.get(1) + result.get(2) + result.get(3) + ".pdf";

                    Scanntech carnelandia = new Scanntech();
                    carnelandia.leerDatos(pdf, recurso.getOutput() + mercado + ".txt");
                } catch (ParseException e) {
                    log.error(e.getMessage());
                }
                respond = true;
                break;

            // Carnelandia
            // 211229400017
            case "211229400017":
                mercado = "Carnelandia";
                log.info(MSG_MERCADO, mercado);
                try {
                    Date d;
                    d = format3.parse(result.get(5).replace("%2F", ""));
                    String fecha = format.format(d);
                    num = Integer.parseInt(result.get(3));
                    if (!new File(recurso.getResourse() + FILE_SEPARATOR + result.get(1) + result.get(2) + num.toString()
                            + ".pdf").exists()) {
                        ObtenerPDF obtenerPDF = new ScantechTest();
                        obtenerPDF.getPDF(result.get(0), result.get(2), result.get(3), result.get(4), fecha,
                                result.get(6).substring(0, 6));
                    }
                    // Renombrar el Fichero
                    File file = new File(
                            directorioRaiz + FILE_SEPARATOR + recurso.getResourse() + FILE_SEPARATOR + "cfe.pdf");
                    File file2 = new File(directorioRaiz + FILE_SEPARATOR + recurso.getResourse() + FILE_SEPARATOR
                            + result.get(1) + result.get(2) + result.get(3) + ".pdf");
                    if (file.renameTo(file2)) {
                        log.info(MSG_RENOMBRAR_ARCH, file.getName(), file2.getName());
                    }

                    pdf = recurso.getResourse() + result.get(1) + result.get(2) + result.get(3) + ".pdf";

                    Scanntech carnelandia = new Scanntech();
                    carnelandia.leerDatos(pdf, recurso.getOutput() + mercado + ".txt");
                } catch (ParseException e) {
                    log.error(e.getMessage());
                }
                respond = true;
                break;

            // SuperUSAColonia
            // 216270160018
            case "216270160018":
                mercado = "SuperUSAColonia";
                log.info(MSG_MERCADO, mercado);
                try {
                    Date d;
                    d = format3.parse(result.get(5).replace("%2F", ""));
                    String fecha = format.format(d);
                    num = Integer.parseInt(result.get(3));
                    if (!new File(recurso.getResourse() + FILE_SEPARATOR + result.get(1) + result.get(2) + num.toString()
                            + ".pdf").exists()) {
                        ObtenerPDF obtenerPDF = new ScantechTest();
                        obtenerPDF.getPDF(result.get(0), result.get(2), result.get(3), result.get(4), fecha,
                                result.get(6).substring(0, 6));
                    }
                    // Renombrar el Fichero
                    File file = new File(
                            directorioRaiz + FILE_SEPARATOR + recurso.getResourse() + FILE_SEPARATOR + "cfe.pdf");
                    File file2 = new File(directorioRaiz + FILE_SEPARATOR + recurso.getResourse() + FILE_SEPARATOR
                            + result.get(1) + result.get(2) + result.get(3) + ".pdf");
                    if (file.renameTo(file2)) {
                        log.info(MSG_RENOMBRAR_ARCH, file.getName(), file2.getName());
                    }

                    pdf = recurso.getResourse() + result.get(1) + result.get(2) + result.get(3) + ".pdf";

                    Scanntech carnelandia = new Scanntech();
                    carnelandia.leerDatos(pdf, recurso.getOutput() + mercado + ".txt");
                } catch (ParseException e) {
                    log.error(e.getMessage());
                }
                respond = true;
                break;

            // SuperMercadoEconomico
            // 213938880017
            case "213938880017":
                mercado = "SuperMercadoEconomico";
                log.info(MSG_MERCADO, mercado);

                try {
                    // Descarga el Fichero

                    Date d;
                    d = format3.parse(result.get(5).replace("%2F", ""));
                    String fecha = format.format(d);
                    num = Integer.parseInt(result.get(3));
                    if (!new File(recurso.getResourse() + FILE_SEPARATOR + result.get(1) + result.get(2) + num.toString()
                            + ".pdf").exists()) {
                        ObtenerPDF obtenerPDF = new ScantechTest();
                        obtenerPDF.getPDF(result.get(0), result.get(2), result.get(3), result.get(4), fecha,
                                result.get(6).substring(0, 6));
                    }
                    // Renombrar el Fichero
                    File file = new File(
                            directorioRaiz + FILE_SEPARATOR + recurso.getResourse() + FILE_SEPARATOR + "cfe.pdf");
                    File file2 = new File(directorioRaiz + FILE_SEPARATOR + recurso.getResourse() + FILE_SEPARATOR
                            + result.get(1) + result.get(2) + result.get(3) + ".pdf");
                    if (file.renameTo(file2)) {
                        log.info(MSG_RENOMBRAR_ARCH, file.getName(), file2.getName());
                    }

                    pdf = recurso.getResourse() + result.get(1) + result.get(2) + result.get(3) + ".pdf";

                    Scanntech elNaranjo = new Scanntech();
                    elNaranjo.leerDatos(pdf, recurso.getOutput() + mercado + ".txt");
                } catch (ParseException e) {
                    log.error(e.getMessage());
                }
                respond = true;
                break;

            // SuperAriel
            // 213304860012
            case "213304860012":
                mercado = "SuperAriel";
                log.info(MSG_MERCADO, mercado);
                try {

                    Date d;
                    d = format3.parse(result.get(5).replace("%2F", ""));
                    String fecha = format.format(d);
                    num = Integer.parseInt(result.get(3));
                    if (!new File(recurso.getResourse() + FILE_SEPARATOR + result.get(1) + result.get(2) + num.toString()
                            + ".pdf").exists()) {
                        ObtenerPDF obtenerPDF = new ScantechTest();
                        obtenerPDF.getPDF(result.get(0), result.get(2), result.get(3), result.get(4), fecha,
                                result.get(6).substring(0, 6));
                    }
                    // Renombrar el Fichero
                    File file = new File(
                            directorioRaiz + FILE_SEPARATOR + recurso.getResourse() + FILE_SEPARATOR + "cfe.pdf");
                    File file2 = new File(directorioRaiz + FILE_SEPARATOR + recurso.getResourse() + FILE_SEPARATOR
                            + result.get(1) + result.get(2) + result.get(3) + ".pdf");
                    if (file.renameTo(file2)) {
                        log.info(MSG_RENOMBRAR_ARCH, file.getName(), file2.getName());
                    }

                    pdf = recurso.getResourse() + result.get(1) + result.get(2) + result.get(3) + ".pdf";

                    Scanntech superAriel = new Scanntech();
                    superAriel.leerDatos(pdf, recurso.getOutput() + mercado + ".txt");
                } catch (ParseException e) {
                    log.error(e.getMessage());
                }
                respond = true;
                break;

            // Montserrat Panaderia
            // 214783760011
            case "214783760011":
                mercado = "PanaderiaMontserrat";
                log.info(MSG_MERCADO, mercado);
                try {

                    Date d;
                    d = format3.parse(result.get(5).replace("%2F", ""));
                    String fecha = format.format(d);
                    num = Integer.parseInt(result.get(3));
                    if (!new File(recurso.getResourse() + FILE_SEPARATOR + result.get(1) + result.get(2) + num.toString()
                            + ".pdf").exists()) {
                        ObtenerPDF obtenerPDF = new ScantechTest();
                        obtenerPDF.getPDF(result.get(0), result.get(2), result.get(3), result.get(4), fecha,
                                result.get(6).substring(0, 6));
                    }
                    // Renombrar el Fichero
                    File file = new File(
                            directorioRaiz + FILE_SEPARATOR + recurso.getResourse() + FILE_SEPARATOR + "cfe.pdf");
                    File file2 = new File(directorioRaiz + FILE_SEPARATOR + recurso.getResourse() + FILE_SEPARATOR
                            + result.get(1) + result.get(2) + result.get(3) + ".pdf");
                    if (file.renameTo(file2)) {
                        log.info(MSG_RENOMBRAR_ARCH, file.getName(), file2.getName());
                    }

                    pdf = recurso.getResourse() + result.get(1) + result.get(2) + result.get(3) + ".pdf";

                    Scanntech montserrat = new Scanntech();
                    montserrat.leerDatos(pdf, recurso.getOutput() + mercado + ".txt");
                } catch (ParseException e) {
                    log.error(e.getMessage());
                }
                respond = true;
                break;

            // Mercado Natural
            // 215058860011
            case "215058860011":
                mercado = "MercadoNatural";
                log.info(MSG_MERCADO, mercado);
                try {
                    Date d;
                    d = format3.parse(result.get(5).replace("%2F", ""));
                    String fecha = format.format(d);
                    num = Integer.parseInt(result.get(3));
                    if (!new File(recurso.getResourse() + FILE_SEPARATOR + result.get(1) + result.get(2) + num.toString()
                            + ".pdf").exists()) {
                        ObtenerPDF obtenerPDF = new ScantechTest();
                        obtenerPDF.getPDF(result.get(0), result.get(2), result.get(3), result.get(4), fecha,
                                result.get(6).substring(0, 6));
                    }

                    // Renombrar el Fichero
                    File file = new File(
                            directorioRaiz + FILE_SEPARATOR + recurso.getResourse() + FILE_SEPARATOR + "cfe.pdf");
                    File file2 = new File(directorioRaiz + FILE_SEPARATOR + recurso.getResourse() + FILE_SEPARATOR
                            + result.get(1) + result.get(2) + result.get(3) + ".pdf");
                    if (file.renameTo(file2)) {
                        log.info(MSG_RENOMBRAR_ARCH, file.getName(), file2.getName());
                    }

                    pdf = recurso.getResourse() + result.get(1) + result.get(2) + result.get(3) + ".pdf";

                    Scanntech mercadoNatural = new Scanntech();
                    mercadoNatural.leerDatos(pdf, recurso.getOutput() + mercado + ".txt");
                } catch (Exception e) {
                    log.error(e.getMessage());
                }
                respond = true;
                break;
            // DonPaulino
            // 211412910010
            case "211412910010":
                mercado = "DonPaulino";
                log.info(MSG_MERCADO, mercado);
                try {
                    Date d;
                    d = format3.parse(result.get(5).replace("%2F", ""));
                    String fecha = format.format(d);
                    num = Integer.parseInt(result.get(3));
                    if (!new File(recurso.getResourse() + FILE_SEPARATOR + result.get(1) + result.get(2) + num.toString()
                            + ".pdf").exists()) {
                        ObtenerPDF obtenerPDF = new ScantechTest();
                        obtenerPDF.getPDF(result.get(0), result.get(2), result.get(3), result.get(4), fecha,
                                result.get(6).substring(0, 6));
                    }

                    // Renombrar el Fichero
                    File file = new File(
                            directorioRaiz + FILE_SEPARATOR + recurso.getResourse() + FILE_SEPARATOR + "cfe.pdf");
                    File file2 = new File(directorioRaiz + FILE_SEPARATOR + recurso.getResourse() + FILE_SEPARATOR
                            + result.get(1) + result.get(2) + result.get(3) + ".pdf");
                    if (file.renameTo(file2)) {
                        log.info(MSG_RENOMBRAR_ARCH, file.getName(), file2.getName());
                    }

                    pdf = recurso.getResourse() + result.get(1) + result.get(2) + result.get(3) + ".pdf";

                    Scanntech donPaulino = new Scanntech();
                    donPaulino.leerDatos(pdf, recurso.getOutput() + mercado + ".txt");
                } catch (Exception e) {
                    log.error(e.getMessage());
                }
                respond = true;
                break;

            // Distravi
            // 211223740010
            case "211223740010":
                mercado = "Distravi";
                log.info(MSG_MERCADO, mercado);
                try {
                    Date d;
                    d = format3.parse(result.get(5).replace("%2F", ""));
                    String fecha = format.format(d);
                    num = Integer.parseInt(result.get(3));
                    if (!new File(recurso.getResourse() + FILE_SEPARATOR + result.get(1) + result.get(2) + num.toString()
                            + ".pdf").exists()) {
                        ObtenerPDF obtenerPDF = new ScantechTest();
                        obtenerPDF.getPDF(result.get(0), result.get(2), result.get(3), result.get(4), fecha,
                                result.get(6).substring(0, 6));
                    }

                    // Renombrar el Fichero
                    File file = new File(
                            directorioRaiz + FILE_SEPARATOR + recurso.getResourse() + FILE_SEPARATOR + "cfe.pdf");
                    File file2 = new File(directorioRaiz + FILE_SEPARATOR + recurso.getResourse() + FILE_SEPARATOR
                            + result.get(1) + result.get(2) + result.get(3) + ".pdf");
                    if (file.renameTo(file2)) {
                        log.info(MSG_RENOMBRAR_ARCH, file.getName(), file2.getName());
                    }

                    pdf = recurso.getResourse() + result.get(1) + result.get(2) + result.get(3) + ".pdf";

                    Scanntech ditravis = new Scanntech();
                    ditravis.leerDatos(pdf, recurso.getOutput() + mercado + ".txt");
                } catch (Exception e) {
                    log.error(e.getMessage());
                }
                respond = true;
                break;

            // Super Al Costo
            // 200103660014
            case "200103660014":
                mercado = "Super Al Costo";
                log.info(MSG_MERCADO, mercado);
                try {
                    num = Integer.parseInt(result.get(3));
                    if (!new File(recurso.getResourse() + FILE_SEPARATOR + result.get(1) + result.get(2) + num.toString()
                            + ".pdf").exists()) {
                        ObtenerPDF obtenerPDF = new ScantechTest();
                        obtenerPDF.getPDF(result.get(0), result.get(2), result.get(3), result.get(4), result.get(5),
                                result.get(6).substring(0, 6));
                    }

                    // Renombrar el Fichero
                    File file = new File(
                            directorioRaiz + FILE_SEPARATOR + recurso.getResourse() + FILE_SEPARATOR + "cfe.pdf");
                    File file2 = new File(directorioRaiz + FILE_SEPARATOR + recurso.getResourse() + FILE_SEPARATOR
                            + result.get(1) + result.get(2) + result.get(3) + ".pdf");
                    if (file.renameTo(file2)) {
                        log.info(MSG_RENOMBRAR_ARCH, file.getName(), file2.getName());
                    }

                    pdf = recurso.getResourse() + result.get(1) + result.get(2) + result.get(3) + ".pdf";

                    Scanntech ditravis = new Scanntech();
                    ditravis.leerDatos(pdf, recurso.getOutput() + mercado + ".txt");
                } catch (Exception e) {
                    log.error(e.getMessage());
                }
                respond = true;
                break;
            // Polleria Luana
            // 200184060012
            case "200184060012":
                mercado = "Polleria Luana";
                log.info(MSG_MERCADO, mercado);
                try {
                    num = Integer.parseInt(result.get(3));
                    if (!new File(recurso.getResourse() + FILE_SEPARATOR + result.get(1) + result.get(2) + num.toString()
                            + ".pdf").exists()) {
                        ObtenerPDF obtenerPDF = new ScantechTest();
                        obtenerPDF.getPDF(result.get(0), result.get(2), result.get(3), result.get(4), result.get(5),
                                result.get(6).substring(0, 6));
                    }

                    // Renombrar el Fichero
                    File file = new File(
                            directorioRaiz + FILE_SEPARATOR + recurso.getResourse() + FILE_SEPARATOR + "cfe.pdf");
                    File file2 = new File(directorioRaiz + FILE_SEPARATOR + recurso.getResourse() + FILE_SEPARATOR
                            + result.get(1) + result.get(2) + result.get(3) + ".pdf");
                    if (file.renameTo(file2)) {
                        log.info(MSG_RENOMBRAR_ARCH, file.getName(), file2.getName());
                    }

                    pdf = recurso.getResourse() + result.get(1) + result.get(2) + result.get(3) + ".pdf";

                    Scanntech ditravis = new Scanntech();
                    ditravis.leerDatos(pdf, recurso.getOutput() + mercado + ".txt");
                } catch (Exception e) {
                    log.error(e.getMessage());
                }
                respond = true;
                break;
            // ElDorado
            // 100004430014
            case "100004430014":
                mercado = "El_Dorado";
                log.info(MSG_MERCADO, mercado);
                try {
                    num = Integer.parseInt(result.get(3));
                    if (!new File(recurso.getResourse() + FILE_SEPARATOR + result.get(1) + result.get(2) + num.toString()
                            + ".pdf").exists()) {
                        ObtenerPDF obtenerPDF = new ScantechTest();
                        obtenerPDF.getPDF(result.get(0), result.get(2), result.get(3), result.get(4), result.get(5),
                                result.get(6).substring(0, 6));
                    }

                    // Renombrar el Fichero
                    File file = new File(
                            directorioRaiz + FILE_SEPARATOR + recurso.getResourse() + FILE_SEPARATOR + "cfe.pdf");
                    File file2 = new File(directorioRaiz + FILE_SEPARATOR + recurso.getResourse() + FILE_SEPARATOR
                            + result.get(1) + result.get(2) + result.get(3) + ".pdf");
                    if (file.renameTo(file2)) {
                        log.info(MSG_RENOMBRAR_ARCH, file.getName(), file2.getName());
                    }

                    pdf = recurso.getResourse() + result.get(1) + result.get(2) + result.get(3) + ".pdf";

                    Scanntech ditravis = new Scanntech();
                    ditravis.leerDatos(pdf, recurso.getOutput() + mercado + ".txt");
                } catch (Exception e) {
                    log.error(e.getMessage());
                }
                respond = true;
                break;
            // 25Agosto
            // 200186660017
            case "200186660017":
                mercado = "Service_25_Agosto";
                log.info(MSG_MERCADO, mercado);
                try {
                    num = Integer.parseInt(result.get(3));
                    if (!new File(recurso.getResourse() + FILE_SEPARATOR + result.get(1) + result.get(2) + num.toString()
                            + ".pdf").exists()) {
                        ObtenerPDF obtenerPDF = new ScantechTest();
                        obtenerPDF.getPDF(result.get(0), result.get(2), result.get(3), result.get(4), result.get(5),
                                result.get(6).substring(0, 6));
                    }

                    // Renombrar el Fichero
                    File file = new File(
                            directorioRaiz + FILE_SEPARATOR + recurso.getResourse() + FILE_SEPARATOR + "cfe.pdf");
                    File file2 = new File(directorioRaiz + FILE_SEPARATOR + recurso.getResourse() + FILE_SEPARATOR
                            + result.get(1) + result.get(2) + result.get(3) + ".pdf");
                    if (file.renameTo(file2)) {
                        log.info(MSG_RENOMBRAR_ARCH, file.getName(), file2.getName());
                    }

                    pdf = recurso.getResourse() + result.get(1) + result.get(2) + result.get(3) + ".pdf";

                    Scanntech ditravis = new Scanntech();
                    ditravis.leerDatos(pdf, recurso.getOutput() + mercado + ".txt");
                } catch (Exception e) {
                    log.error(e.getMessage());
                }
                respond = true;
                break;
            // Tienda Montevideo
            // 210165660015
            case "210165660015":
                mercado = "Tienda_MOntevideo";
                log.info(MSG_MERCADO, mercado);
                try {
                    num = Integer.parseInt(result.get(3));
                    if (!new File(recurso.getResourse() + FILE_SEPARATOR + result.get(1) + result.get(2) + num.toString()
                            + ".pdf").exists()) {
                        ObtenerPDF obtenerPDF = new ScantechTest();
                        obtenerPDF.getPDF(result.get(0), result.get(2), result.get(3), result.get(4), result.get(5),
                                result.get(6).substring(0, 6));
                    }

                    // Renombrar el Fichero
                    File file = new File(
                            directorioRaiz + FILE_SEPARATOR + recurso.getResourse() + FILE_SEPARATOR + "cfe.pdf");
                    File file2 = new File(directorioRaiz + FILE_SEPARATOR + recurso.getResourse() + FILE_SEPARATOR
                            + result.get(1) + result.get(2) + result.get(3) + ".pdf");
                    if (file.renameTo(file2)) {
                        log.info(MSG_RENOMBRAR_ARCH, file.getName(), file2.getName());
                    }

                    pdf = recurso.getResourse() + result.get(1) + result.get(2) + result.get(3) + ".pdf";

                    Scanntech ditravis = new Scanntech();
                    ditravis.leerDatos(pdf, recurso.getOutput() + mercado + ".txt");
                } catch (Exception e) {
                    log.error(e.getMessage());
                }
                respond = true;
                break;
            // Free_Shop_Mario
            // 030098540019
            case "030098540019":
                mercado = "Free_Shop_Mario";
                log.info(MSG_MERCADO, mercado);
                try {
                    num = Integer.parseInt(result.get(3));
                    if (!new File(recurso.getResourse() + FILE_SEPARATOR + result.get(1) + result.get(2) + num.toString()
                            + ".pdf").exists()) {
                        ObtenerPDF obtenerPDF = new ScantechTest();
                        obtenerPDF.getPDF(result.get(0), result.get(2), result.get(3), result.get(4), result.get(5),
                                result.get(6).substring(0, 6));
                    }

                    // Renombrar el Fichero
                    File file = new File(
                            directorioRaiz + FILE_SEPARATOR + recurso.getResourse() + FILE_SEPARATOR + "cfe.pdf");
                    File file2 = new File(directorioRaiz + FILE_SEPARATOR + recurso.getResourse() + FILE_SEPARATOR
                            + result.get(1) + result.get(2) + result.get(3) + ".pdf");
                    if (file.renameTo(file2)) {
                        log.info(MSG_RENOMBRAR_ARCH, file.getName(), file2.getName());
                    }

                    pdf = recurso.getResourse() + result.get(1) + result.get(2) + result.get(3) + ".pdf";

                    Scanntech ditravis = new Scanntech();
                    ditravis.leerDatos(pdf, recurso.getOutput() + mercado + ".txt");
                } catch (Exception e) {
                    log.error(e.getMessage());
                }
                respond = true;
                break;
            case "AlmaNatural":
                mercado = "AlmaNatural";
                log.info(MSG_MERCADO, mercado);
                AlmaNatural almaNatural = new AlmaNatural();
                almaNatural.leerDatos(pdf, recurso.getOutput() + mercado + ".txt");
                respond = true;
                break;

            case "Itau":
                mercado = "Banco Itau";
                log.info(MSG_MERCADO, mercado);
                Itau itau = new Itau();
                itau.leerDatos(pdf, recurso.getOutput() + mercado + ".txt");
                respond = true;
                break;

            default:
                respond = false;
                break;
        }
        return respond;
    }
}
