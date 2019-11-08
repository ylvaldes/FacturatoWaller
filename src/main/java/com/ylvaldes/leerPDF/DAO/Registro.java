package com.ylvaldes.leerPDF.DAO;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.ylvaldes.leerPDF.Utiles.LoadResourceConfLeerPDF;

public class Registro {
	private final static LoadResourceConfLeerPDF recurso = new LoadResourceConfLeerPDF();
	private static final Logger log = LoggerFactory.getLogger(Registro.class);

	Double importe;
	String moneda;
	String categoria;
	Date fecha;
	String descripcion;
	String beneficiario;
	String direccion;

	public Registro(Double importe, String moneda, String categoria, Date fecha, String descripcion,
			String beneficiario, String direccion) {
		super();
		this.importe = importe;
		this.moneda = moneda;
		this.categoria = categoria;
		this.fecha = fecha;
		this.descripcion = descripcion;
		this.beneficiario = beneficiario;
		this.direccion = direccion;

		try {
			recurso.loadResourceConf();
		} catch (IOException e) {
			log.error(e.getMessage());
		}
	}

	/**
	 * @return the importe
	 */
	public Double getImporte() {
		return importe;
	}

	/**
	 * @param importe the importe to set
	 */
	public void setImporte(Double importe) {
		this.importe = importe;
	}

	/**
	 * @return the moneda
	 */
	public String getMoneda() {
		return moneda;
	}

	/**
	 * @param moneda the moneda to set
	 */
	public void setMoneda(String moneda) {
		this.moneda = moneda;
	}

	/**
	 * @return the categoria
	 */
	public String getCategoria() {
		return categoria;
	}

	/**
	 * @param categoria the categoria to set
	 */
	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	/**
	 * @return the fecha
	 */
	public Date getFecha() {
		return fecha;
	}

	/**
	 * @param fecha the fecha to set
	 */
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	/**
	 * @return the descripcion
	 */
	public String getDescripcion() {
		return descripcion;
	}

	/**
	 * @param descripcion the descripcion to set
	 */
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	/**
	 * @return the beneficiario
	 */
	public String getBeneficiario() {
		return beneficiario;
	}

	/**
	 * @param beneficiario the beneficiario to set
	 */
	public void setBeneficiario(String beneficiario) {
		this.beneficiario = beneficiario;
	}

	/**
	 * @return the direccion
	 */
	public String getDireccion() {
		return direccion;
	}

	/**
	 * @param direccion the direccion to set
	 */
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	@Override
	public String toString() {
		SimpleDateFormat format = new SimpleDateFormat(recurso.getPatternFormatS());

		return "Registro fecha " + format.format(fecha) + " moneda " + moneda + "  direccion " + direccion
				+ " categoria " + categoria
				+ " descripcion " + descripcion + " importe " + importe + " beneficiario " + beneficiario;
	}

}
