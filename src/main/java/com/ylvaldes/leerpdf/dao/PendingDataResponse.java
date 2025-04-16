package com.ylvaldes.leerpdf.dao;

/**
 * @author YasmaniLedesmaValdez
 * @project telegram-reader
 * @package com.ylvaldes.telegram_reader.model
 * @created 1/5/2023
 * @implNote
 */

public class PendingDataResponse {

    private String nombre;


    private Long rut;


    private String urlGetTiket;

    private String statusUrl;

    private Long idUrl;


    private String tipoCFE;


    private String serie;


    private String numero;


    private String fecha;


    private String codigoSeguridad;

    private Double montoTotal;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Long getRut() {
        return rut;
    }

    public void setRut(Long rut) {
        this.rut = rut;
    }

    public String getUrlGetTiket() {
        return urlGetTiket;
    }

    public void setUrlGetTiket(String urlGetTiket) {
        this.urlGetTiket = urlGetTiket;
    }

    public String getStatusUrl() {
        return statusUrl;
    }

    public void setStatusUrl(String statusUrl) {
        this.statusUrl = statusUrl;
    }

    public Long getIdUrl() {
        return idUrl;
    }

    public void setIdUrl(Long idUrl) {
        this.idUrl = idUrl;
    }

    public String getTipoCFE() {
        return tipoCFE;
    }

    public void setTipoCFE(String tipoCFE) {
        this.tipoCFE = tipoCFE;
    }

    public String getSerie() {
        return serie;
    }

    public void setSerie(String serie) {
        this.serie = serie;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getCodigoSeguridad() {
        return codigoSeguridad;
    }

    public void setCodigoSeguridad(String codigoSeguridad) {
        this.codigoSeguridad = codigoSeguridad;
    }

    public Double getMontoTotal() {
        return montoTotal;
    }

    public void setMontoTotal(Double montoTotal) {
        this.montoTotal = montoTotal;
    }
}
