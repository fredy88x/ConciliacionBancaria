/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.trabajo;

import com.pojos.Conexion;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.sql.SQLException;

/**
 *
 * @author Cristian
 */
@Named(value = "login")
@SessionScoped
public class Login implements Serializable {

    /**
     * Creates a new instance of Login
     */
    private String usuario;
    private String contrasenia;
    private String operador;
    public Login() {
    }

    public String getOperador() {
        return operador;
    }

    public void setOperador(String operador) {
        this.operador = operador;
    }

   

    
    
    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getContrasenia() {
        return contrasenia;
    }

    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }
    
    public String login() throws ClassNotFoundException, SQLException{
        System.out.println("Datos "+usuario+contrasenia);
        Conexion obj=new Conexion();
        System.out.println("\nCANTIDAD "+obj.login(usuario, contrasenia)+usuario+" "+contrasenia);
    if(obj.login(usuario, contrasenia)){
        if(usuario.equals("operadora")){
        operador="false";}else{
        operador="true";}
    return "menu.xhtml?faces-redirect=true";
    }else{        
    return "index.xhtml?faces-redirect=true";
    }
    }
}
