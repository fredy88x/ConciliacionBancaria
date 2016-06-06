/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.trabajo;

import com.pojos.Conexion;
import com.proyecto.Clases.Cuentas;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.sql.SQLException;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

/**
 *
 * @author Cristian
 * ESTA CLASE LA CAMBIE POR COMPLETO
 */
@Named(value = "contables")
@SessionScoped
public class Contables implements Serializable {

    /**
     * Creates a new instance of Contables
     */
    private Conexion conexion;
    
    public Contables() throws ClassNotFoundException, SQLException {
        conexion = new Conexion();
    }
    
    private int numCuenta;
    private int depreciacion;
    private String nombreCuenta;
    private int vidaUtil;
    private List<Cuentas> listaCuentas;
    
    
    public void insertarRegistro(ActionEvent event){
        Cuentas cuentas = new Cuentas();
        cuentas.setNumCuenta(this.getNumCuenta());
        cuentas.setNombreCuenta(this.getNombreCuenta());
        cuentas.setDepreciacion(this.getDepreciacion());
        cuentas.setVidaUtil(this.getVidaUtil());
        int codigo = conexion.insertarCuenta(cuentas);
        if(codigo == 1){
            addMessage("El registro ha sido exitoso");
        }
        else{
            addMessage("El registro no ha sido exitoso");
        }
    }
    
    public void eliminarRegistro(ActionEvent event){
       Cuentas cuentas = new Cuentas();
        cuentas.setNumCuenta(this.getNumCuenta());
        int codigo = conexion.eliminarCuentas(cuentas);
        if (codigo == 1) {
            addMessage("El registro ha sido exitoso");
        } else {
            addMessage("El registro no ha sido exitoso");
        }
        /*
         * int codigo = conexion.eliminarCuentas(cuentas); if(codigo == 1){
         * addMessage("El registro ha sido exitoso"); } else{ addMessage("El
         * registro no ha sido exitoso"); } /* Cuentas cuentas = new Cuentas();
         * cuentas.setNumCuenta(this.getNumCuenta());
         * cuentas.setNombreCuenta(this.getNombreCuenta());
         * cuentas.setDepreciacion(this.getDepreciacion());
         * cuentas.setVidaUtil(this.getVidaUtil()); int codigo =
         * conexion.insertarCuenta(cuentas); if(codigo == 1){ addMessage("El
         * registro ha sido exitoso"); } else{ addMessage("El registro no ha
         * sido exitoso");
        }
         */
        System.out.println("Esta entrando a eliminar");
    }

    
    public void addMessage(String summary) {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, summary,  null);
        FacesContext.getCurrentInstance().addMessage(null, message);         
    }
    
    public void conexion() throws ClassNotFoundException, SQLException{
                    
    Conexion obj=new Conexion();
    obj.conexion();
    }

    public int getNumCuenta() {
        return numCuenta;
    }

    public void setNumCuenta(int numCuenta) {
        this.numCuenta = numCuenta;
    }

    public int getDepreciacion() {
        return depreciacion;
    }

    public void setDepreciacion(int depreciacion) {
        this.depreciacion = depreciacion;
    }

    public String getNombreCuenta() {
        return nombreCuenta;
    }

    public void setNombreCuenta(String nombreCuenta) {
        this.nombreCuenta = nombreCuenta;
    }

    public int getVidaUtil() {
        return vidaUtil;
    }

    public void setVidaUtil(int vidaUtil) {
        this.vidaUtil = vidaUtil;
    }

    public List<Cuentas> getListaCuentas() throws SQLException {
        listaCuentas = conexion.obtenerCuentas();
        return listaCuentas;
    }
    
    
    
}
