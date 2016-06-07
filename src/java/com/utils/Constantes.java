/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.utils;

/**
 *
 * @author fredylaverde
 */
public class Constantes {
    
    public static final String INSERTAR_ESTADO = "INSERT INTO estados (nombre) values (?)";
    public static final String LISTA_ESTADOS = "SELECT * FROM estados";
    public static final String ELIMINAR_ESTADO = "DELETE FROM estados WHERE estado_id=?";
    public static final String ACTUALIZAR_ESTADO = "UPDATE estados set estado_id=?,nombre=? WHERE estado_id=?";
}
