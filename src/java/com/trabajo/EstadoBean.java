/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.trabajo;

import com.pojos.Conexion;
import com.proyecto.Clases.Estado;
import java.io.Serializable;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.inject.Named;
import org.primefaces.event.RowEditEvent;

/**
 *
 * @author fredylaverde
 */
@Named(value = "EstadoBean")
@SessionScoped
public class EstadoBean implements Serializable {
    
    private String nombre;
    private Conexion conexion;
    private List<Estado> estados;

    @PostConstruct
    public void init(){
        try {
            conexion = new Conexion();
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(EstadoBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<Estado> getEstados() {
        try {
            estados = conexion.listarEstados();
        } catch (SQLException ex) {
            Logger.getLogger(EstadoBean.class.getName()).log(Level.SEVERE, null, ex);
        }
        return estados;
    }

    public void setEstados(List<Estado> estados) {
        this.estados = estados;
    }
    
    
    
    public void insertarRegistro(ActionEvent evento){
        try {
            Estado estado = new Estado();
            estado.setNombre(this.getNombre());
            conexion.insertarEstados(estado);
            addMessage("El registro ha sido exitoso");
        } catch (Exception ex) {
            Logger.getLogger(EstadoBean.class.getName()).log(Level.SEVERE, null, ex);
            addMessage("El registro no ha sido exitoso");
        }finally{
            this.nombre = "";
        }
    }
    
    public void onRowEdit(RowEditEvent evento){
        try {
            Estado estado = (Estado)evento.getObject();
            conexion.actualizarEstado(estado);
            addMessage("Actualizacion de registro exitosa");
        } catch (Exception ex) {
            Logger.getLogger(EstadoBean.class.getName()).log(Level.SEVERE, null, ex);
            addMessage("La Actualizacion de registro no ha sido exitosa");
        }
    }
    
    public void onRowCancel(RowEditEvent event) {
        FacesMessage msg = new FacesMessage("Edit Cancelled");
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }
    
    
    public void eliminarEstado(ActionEvent evento){
        try {
            Map<String, String> params = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
            int id = Integer.parseInt(params.get("estadoid"));
            conexion.eliminarEstado(id);
            addMessage("Eliminacion de registro exitosa");
        } catch (SQLException ex) {
            Logger.getLogger(EstadoBean.class.getName()).log(Level.SEVERE, null, ex);
            addMessage("La eliminacion de registro no ha sido exitosa");
        }
    }
    
    
    
     public void addMessage(String summary) {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, summary,  null);
        FacesContext.getCurrentInstance().addMessage(null, message);         
    }
}
