package com.ylvaldes.leerpdf.dao;

import java.text.DecimalFormat;

import com.ylvaldes.leerpdf.utiles.LoadResourceConfLeerPDF;

public class Compra {
	private final static LoadResourceConfLeerPDF recurso = new LoadResourceConfLeerPDF();
	private static DecimalFormat df2 = new DecimalFormat("#.##");

	double cantidad;
	double precioCDescuento;
	double precioSDescuento;
	String producto;
	String mercado;

	public Compra(double cantidad, double precioSDescuento, double precioCDescuento, String producto,String mercado) {
		super();
		this.cantidad = cantidad;
		this.precioCDescuento = precioCDescuento;
		this.precioSDescuento = precioSDescuento;
		this.producto = producto;
		this.mercado=mercado;

	}

	public String toString() {
		// Operador Ternario
		return (precioCDescuento == precioSDescuento)
				// true
				? (cantidad % 1 == 0)
						// true
						? mercado + "\n" + "Compra " + cantidad + " " + producto + " precio U "
								+ df2.format(precioSDescuento / cantidad) + " precio Total "
								+ df2.format(precioSDescuento)
						// false
						: mercado + "\n" + "Compra " + cantidad + " Kg " + producto + " precio U "
								+ df2.format(precioSDescuento / cantidad) + " precio Total "
								+ df2.format(precioSDescuento)
				// false
				: (cantidad % 1 == 0)
						// true
						? mercado + "\n" + "Compra " + cantidad + " " + producto + " precio U "
								+ df2.format(precioCDescuento / cantidad) + " precio Total " + precioCDescuento
								+ " Descuento de " + df2.format(((precioSDescuento) - precioCDescuento))
						// false
						: mercado + "\n" + "Compra " + cantidad + " Kg " + producto + " precio U "
								+ df2.format(precioCDescuento / cantidad) + " precio Total " + precioCDescuento
								+ " Descuento de " + df2.format(((precioSDescuento) - precioCDescuento));
	}

	/**
	 * @return the cantidad
	 */
	public double getCantidad() {
		return cantidad;
	}

	/**
	 * @param cantidad the cantidad to set
	 */
	public void setCantidad(double cantidad) {
		this.cantidad = cantidad;
	}

	/**
	 * @return the precioCDescuento
	 */
	public double getPrecioCDescuento() {
		return precioCDescuento;
	}

	/**
	 * @param precioCDescuento the precioCDescuento to set
	 */
	public void setPrecioCDescuento(double precioCDescuento) {
		this.precioCDescuento = precioCDescuento;
	}

	/**
	 * @return the precioSDescuento
	 */
	public double getPrecioSDescuento() {
		return precioSDescuento;
	}

	/**
	 * @param precioSDescuento the precioSDescuento to set
	 */
	public void setPrecioSDescuento(double precioSDescuento) {
		this.precioSDescuento = precioSDescuento;
	}

	/**
	 * @return the producto
	 */
	public String getProducto() {
		return producto;
	}

	/**
	 * @param producto the producto to set
	 */
	public void setProducto(String producto) {
		this.producto = producto;
	}

}
