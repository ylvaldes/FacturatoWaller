package com.ylvaldes.leerPDF.DAO;

import java.util.Date;

public class ElementosEstadoCuenta {
	Date fecha;
	String tarjeta;
	String descripcion;
	String moneda;
	double importe;

	public ElementosEstadoCuenta(Date fecha, String tarjeta, String descripcion, String moneda, double importe) {
		super();
		this.fecha = fecha;
		this.tarjeta = tarjeta;
		this.descripcion = descripcion;
		this.moneda = moneda;
		this.importe = importe;
	}

	public ElementosEstadoCuenta(String descripcion, String moneda, double importe) {
		super();
		this.descripcion = descripcion;
		this.moneda = moneda;
		this.importe = importe;
	}

	public ElementosEstadoCuenta(Date fecha, String descripcion, String moneda, double importe) {
		super();
		this.fecha = fecha;
		this.descripcion = descripcion;
		this.moneda = moneda;
		this.importe = importe;
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
	 * @return the tarjeta
	 */
	public String getTarjeta() {
		return tarjeta;
	}

	/**
	 * @param tarjeta the tarjeta to set
	 */
	public void setTarjeta(String tarjeta) {
		this.tarjeta = tarjeta;
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
	 * @return the importe
	 */
	public double getImporte() {
		return importe;
	}

	/**
	 * @param importe the importe to set
	 */
	public void setImporte(double importe) {
		this.importe = importe;
	}

	@Override
	public String toString() {
		return "ElementosEstadoCuenta [fecha=" + fecha + ", tarjeta=" + tarjeta + ", descripcion=" + descripcion
				+ ", moneda=" + moneda + ", importe=" + importe + "]";
	}

}
