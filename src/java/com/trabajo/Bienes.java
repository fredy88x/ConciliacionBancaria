/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.trabajo;

import com.pojos.Conexion;
import java.io.Serializable;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

/**
 *
 * @author Cristian
 */
@Named(value = "bienes")
@SessionScoped
public class Bienes implements Serializable {

    /**
     * Creates a new instance of Bienes
     */
    private String codigo;
    private String placa;
    private String tipologia;
    private String consecutivo;
    private String sede;
    private String placaexterna;
    private String llave;
    private String descripcion;
    private String descripciondetallada;
    private String cantidad;
    private String valor;
    private String factura;
    private Date fechas;
    private String vidautil;
    private String serial;
    private String marca;
    private String modelo;
    private String destinatarios;
    private String cuentaactivo;
    private String cuentadepreciacion;
    private String saldo;
    private String estado;
    private String aplicdep;
    private String funcionario;
    private Conexion conexion;
    private List<Object[]> nombreTipologias = new ArrayList<Object[]>();
    private List<Object[]> listaconsecutivos = new ArrayList<Object[]>();
    private List<Object[]> listasedes = new ArrayList<Object[]>();
    private List<Object[]> listadestinatarios = new ArrayList<Object[]>();
    private List<Object[]> listadepreciacion = new ArrayList<Object[]>();
    private List<Object[]> listafuncionarios = new ArrayList<Object[]>();
    private List<Object[]> listabienes = new ArrayList<Object[]>();
    private List<Object[]> listaproveedores = new ArrayList<Object[]>();

    public Bienes() throws ClassNotFoundException, SQLException {
        conexion = new Conexion();
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getTipologia() {
        return tipologia;
    }

    public void setTipologia(String tipologia) {
        this.tipologia = tipologia;
    }

    public String getConsecutivo() {
        return consecutivo;
    }

    public void setConsecutivo(String consecutivo) {
        this.consecutivo = consecutivo;
    }

    public String getSede() {
        return sede;
    }

    public void setSede(String sede) {
        this.sede = sede;
    }

    public String getPlacaexterna() {
        return placaexterna;
    }

    public void setPlacaexterna(String placaexterna) {
        this.placaexterna = placaexterna;
    }

    public String getLlave() {
        return llave;
    }

    public void setLlave(String llave) {
        this.llave = llave;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getDescripciondetallada() {
        return descripciondetallada;
    }

    public void setDescripciondetallada(String descripciondetallada) {
        this.descripciondetallada = descripciondetallada;
    }

    public String getCantidad() {
        return cantidad;
    }

    public void setCantidad(String cantidad) {
        this.cantidad = cantidad;
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

    public String getFactura() {
        return factura;
    }

    public void setFactura(String factura) {
        this.factura = factura;
    }

    public Date getFechas() {
        return fechas;
    }

    public void setFechas(Date fechas) {
        this.fechas = fechas;
    }

    public String getVidautil() {
        return vidautil;
    }

    public void setVidautil(String vidautil) {
        this.vidautil = vidautil;
    }

    public String getSerial() {
        return serial;
    }

    public void setSerial(String serial) {
        this.serial = serial;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getDestinatarios() {
        return destinatarios;
    }

    public void setDestinatarios(String destinatarios) {
        this.destinatarios = destinatarios;
    }

    public String getCuentaactivo() {
        return cuentaactivo;
    }

    public void setCuentaactivo(String cuentaactivo) {
        this.cuentaactivo = cuentaactivo;
    }

    public String getCuentadepreciacion() {
        return cuentadepreciacion;
    }

    public void setCuentadepreciacion(String cuentadepreciacion) {
        this.cuentadepreciacion = cuentadepreciacion;
    }

    public String getSaldo() {
        return saldo;
    }

    public void setSaldo(String saldo) {
        this.saldo = saldo;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getAplicdep() {
        return aplicdep;
    }

    public void setAplicdep(String aplicdep) {
        this.aplicdep = aplicdep;
    }

    public String getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(String funcionario) {
        this.funcionario = funcionario;
    }

    public List<Object[]> getNombreTipologias() throws SQLException {

        return conexion.getTipologias();
    }

    public void setNombreTipologias(List<Object[]> nombreTipologias) {
        this.nombreTipologias = nombreTipologias;
    }

    public List<Object[]> getListaconsecutivos() throws SQLException {
        return conexion.getConsecutivos();
    }

    public void setListaconsecutivos(List<Object[]> listaconsecutivos) {
        this.listaconsecutivos = listaconsecutivos;
    }

    public List<Object[]> getListasedes() throws SQLException {
        return conexion.getListaSedes();
    }

    public void setListasedes(List<Object[]> listasedes) {
        this.listasedes = listasedes;
    }

    public List<Object[]> getListadestinatarios() throws SQLException {
        return conexion.getDestinatarios();
    }

    public void setListadestinatarios(List<Object[]> listadestinatarios) {
        this.listadestinatarios = listadestinatarios;
    }

    public List<Object[]> getListadepreciacion() throws SQLException {
        return conexion.getDepreciacion();
    }

    public void setListadepreciacion(List<Object[]> listadepreciacion) {
        this.listadepreciacion = listadepreciacion;
    }

    public List<Object[]> getListafuncionarios() throws SQLException {
        return conexion.getFuncionarios();
    }

    public void setListafuncionarios(List<Object[]> listafuncionarios) {
        this.listafuncionarios = listafuncionarios;
    }

    public List<Object[]> getListabienes() throws SQLException {
        return conexion.consultaBienes();
    }

    public void setListabienes(List<Object[]> listabienes) {
        this.listabienes = listabienes;
    }

    public List<Object[]> getListaproveedores() throws SQLException {
        return conexion.getProveedores();
    }

    public void setListaproveedores(List<Object[]> listaproveedores) {
        this.listaproveedores = listaproveedores;
    }
    
    public void buttonAction(ActionEvent actionEvent) {
        addMessage("Mensaje exitoso");
    }
     
    public void addMessage(String summary) {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, summary,  null);
        FacesContext.getCurrentInstance().addMessage(null, message);
    }

    public void crearBienes() {
        try {
            System.out.println("\nEntro");
            System.out.println("Bienes{" + "codigo=" + codigo + ", placa=" + placa + ", tipologia=" + tipologia + ", consecutivo=" + consecutivo + ", sede=" + sede + ", placaexterna=" + placaexterna + ", llave=" + llave + ", descripcion=" + descripcion + ", descripciondetallada=" + descripciondetallada + ", cantidad=" + cantidad + ", valor=" + valor + ", factura=" + factura + ", fechas=" + fechas + ", vidautil=" + vidautil + ", serial=" + serial + ", marca=" + marca + ", modelo=" + modelo + ", destinatarios=" + destinatarios + ", cuentaactivo=" + cuentaactivo + ", cuentadepreciacion=" + cuentadepreciacion + ", saldo=" + saldo + ", estado=" + estado + ", aplicdep=" + aplicdep + ", funcionario=" + funcionario + ", conexion=" + conexion + ", nombreTipologias=" + nombreTipologias + ", listaconsecutivos=" + listaconsecutivos + ", listasedes=" + listasedes + ", listadestinatarios=" + listadestinatarios + ", listadepreciacion=" + listadepreciacion + ", listafuncionarios=" + listafuncionarios + ", listabienes=" + listabienes + '}');
            conexion.insertBienes(codigo, placa, tipologia, consecutivo, "nombre", sede, placaexterna, "", llave, descripcion, descripciondetallada, cantidad, valor, factura, fechas, vidautil, serial, marca, modelo, destinatarios, cuentaactivo, cuentadepreciacion, "", saldo, estado, aplicdep, funcionario);
            System.out.println("\nSalio");
        } catch (Exception e) {
            System.out.println("No se pudo persitir la informacion");
        }
    }

    public void eliminarBienes() {
        try {

            conexion.eliminarBien(codigo);
        } catch (Exception e) {
        }
    }

}
