package com.ylvaldes.leerPDF.Utiles;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LoadResourceConfLeerPDF {
	private static final Logger log = LoggerFactory.getLogger(LoadResourceConfLeerPDF.class);

	String mercado;
	String output;
	String patternFormatH;
	String patternFormatS;

	/**
	 * @return the mercado
	 */
	public String getMercado() {
		return mercado;
	}

	/**
	 * @param mercado the mercado to set
	 */
	public void setMercado(String mercado) {
		this.mercado = mercado;
	}

	/**
	 * @return the output
	 */
	public String getOutput() {
		return output;
	}

	/**
	 * @param output the output to set
	 */
	public void setOutput(String output) {
		this.output = output;
	}

	/**
	 * @return the patternFormatH
	 */
	public String getPatternFormatH() {
		return patternFormatH;
	}

	/**
	 * @param patternFormatH the patternFormatH to set
	 */
	public void setPatternFormatH(String patternFormatH) {
		this.patternFormatH = patternFormatH;
	}

	/**
	 * @return the patternFormatS
	 */
	public String getPatternFormatS() {
		return patternFormatS;
	}

	/**
	 * @param patternFormatS the patternFormatS to set
	 */
	public void setPatternFormatS(String patternFormatS) {
		this.patternFormatS = patternFormatS;
	}

	public void loadResourceConf() throws FileNotFoundException, IOException {
		Properties properties = new Properties();
		ClassLoader classLoader = getClass().getClassLoader();

		/*
		 * URL resource = classLoader.getResource("leerPDF.properties"); properties.load(new
		 * FileReader(new File(resource.getFile())));
		 * 
		 * log.info("Mercardo-: " + properties.getProperty("mercado"));
		 */
		InputStream is = classLoader.getResourceAsStream("leerPDF.properties");
		properties.load(is);
		mercado = (String) properties.get("mercado");
		output = (String) properties.get("output");
		patternFormatH = (String) properties.get("patternFormatH");
		patternFormatS = (String) properties.get("patternFormatS");

	}
}
