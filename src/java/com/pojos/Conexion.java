/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pojos;

import com.proyecto.Clases.Cuentas;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Cristian
 */
public class Conexion {

    Connection con = null;
    Statement stmt = null;
    ResultSet rs = null;

    public Conexion() throws ClassNotFoundException, SQLException {
        if (con == null) {
            ConexionURL();
        }
    }

    public void conexion() {

        // Declaramos los sioguientes objetos
//        Statement stmt = null;
//        ResultSet rs = null;
        try {
            //Establecemos la conexión
            String SQL = "SELECT * FROM usuarios";
            stmt = con.createStatement();
            rs = stmt.executeQuery(SQL);
            System.out.print("\nAntes");
            muestraData(rs);
            System.out.print("\nDespues");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (rs != null) {
                try {
                    rs.close();
                } catch (Exception e) {
                }
            }
            if (stmt != null) {
                try {
                    stmt.close();
                } catch (Exception e) {
                }
            }
            if (con != null) {
                try {
                    con.close();
                } catch (Exception e) {
                }
            }
        }

    }

    public void ConexionURL() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");
        con = DriverManager.getConnection("jdbc:mysql://localhost/invugpp", "prueba", "Academiait123");
        // Create and execute an SQL statement that returns some data.

    }

    public void muestraData(ResultSet r) throws Exception {
        ResultSetMetaData rmeta = r.getMetaData();
        int numColumnas = rmeta.getColumnCount();//Cuántas columnas       

        for (int i = 1; i <= numColumnas; ++i) //obtiene nombre de columna
        {
            while (r.next()) {    // hasta fin de archivo           
                System.out.print("\n DAtos " + r.getString(i) + "\t");
            }
        }
    }

    public List<Object[]> getTipologias() throws SQLException {

        List<Object[]> nombre = new ArrayList<Object[]>();
        stmt = con.createStatement();
        rs = stmt.executeQuery("SELECT*FROM tipologias");

        while (rs.next()) {    // hasta fin de archivo           
            nombre.add(new Object[]{rs.getString(1), rs.getString(2)});
        }
        return nombre;
    }

    public List<Object[]> getListaSedes() throws SQLException {

        List<Object[]> nombre = new ArrayList<Object[]>();
        stmt = con.createStatement();
        rs = stmt.executeQuery("SELECT*FROM sedes");

        while (rs.next()) {    // hasta fin de archivo           
            nombre.add(new Object[]{rs.getString(1), rs.getString(2)});
        }
        return nombre;
    }

    public List<Object[]> getDestinatarios() throws SQLException {

        List<Object[]> nombre = new ArrayList<Object[]>();
        stmt = con.createStatement();
        rs = stmt.executeQuery("SELECT*FROM destinatarios");

        while (rs.next()) {    // hasta fin de archivo           
            nombre.add(new Object[]{rs.getString(1), rs.getString(2)});
        }
        return nombre;
    }

    public List<Object[]> getDepreciacion() throws SQLException {

        List<Object[]> nombre = new ArrayList<Object[]>();
        stmt = con.createStatement();
        rs = stmt.executeQuery("SELECT*FROM depreciacion");

        while (rs.next()) {    // hasta fin de archivo           
            nombre.add(new Object[]{rs.getString(1), rs.getString(4)});
        }
        return nombre;
    }

    public List<Object[]> getConsecutivos() throws SQLException {

        List<Object[]> nombre = new ArrayList<Object[]>();
        stmt = con.createStatement();
        rs = stmt.executeQuery("SELECT*FROM consecutivos");

        while (rs.next()) {    // hasta fin de archivo           
            nombre.add(new Object[]{rs.getString(1), rs.getString(2)});
        }
        return nombre;
    }

    public List<Object[]> getFuncionarios() throws SQLException {

        List<Object[]> nombre = new ArrayList<Object[]>();
        stmt = con.createStatement();
        rs = stmt.executeQuery("SELECT*FROM funcionarios");

        while (rs.next()) {    // hasta fin de archivo 

            nombre.add(new Object[]{rs.getString(1), rs.getString(2)});
        }
        return nombre;
    }

    public List<Object[]> getProveedores() throws SQLException {

        List<Object[]> nombre = new ArrayList<Object[]>();
        stmt = con.createStatement();
        rs = stmt.executeQuery("SELECT*FROM proveedores");

        while (rs.next()) {    // hasta fin de archivo 

            nombre.add(new Object[]{rs.getString(1), rs.getString(2)});
        }
        return nombre;
    }

    public boolean login(String usuario, String contrasenia) throws SQLException {
        stmt = con.createStatement();
        rs = stmt.executeQuery("SELECT*FROM usuarios where usuario='" + usuario + "' and contrasenia='" + contrasenia + "'");

        if (rs.next()) {
            return true;
        } else {
            return false;
        }
    }

    public boolean insertBienes(String codigo, String placa, String tipologia, String consecutivo, String nombre, String sede, String placaexterna, String entrega, String llave, String descripcion, String descripciondetallada, String cantidad, String valor, String factura, Date fechas, String vidautil, String serial, String marca, String modelo, String destinatarios, String cuentaactivo, String cuentadepreciacion, String bie_acumulado, String saldo, String estado, String aplicdep, String funcionario) {
        boolean respuesta = true;
        try {
            String sql = "INSERT INTO BIENES (bie_id,bie_placa,bie_tipologia, bie_consecutivo, bie_nombre,bie_sede,bie_placa_externa,bie_entrega,bie_llave,bie_detallada,bie_descripcion, bie_cantidad, bie_valor, bie_factura, bie_fecha, bie_vida_util,bie_serial, bie_marca, bie_modelo, bie_destinatario, bie_cuenta_activo, bie_cuenta_dep,bie_acumulado, bie_saldo, bie_estado, bie_aplica,bie_proveedor) "
                    + "VALUES('" + codigo + "','" + placa + "','" + tipologia + "','" + consecutivo + "','" + "NOMBRE" + "'," + sede + ",'" + placaexterna + "','" + "ENTREGA" + "','" + llave + "','" + descripciondetallada + "','" + descripcion + "','" + cantidad + "','" + valor + "','" + factura + "','20160505','" + vidautil + "','" + serial + "','" + marca + "','" + modelo + "','" + destinatarios + "','" + cuentaactivo + "','" + cuentadepreciacion + "','" + "BIE_ACUMULADO" + "','" + saldo + "','" + estado + "','" + aplicdep + "','" + funcionario + "')";
            System.out.println("Insercion "+sql);
            stmt = con.createStatement();
            stmt.executeUpdate(sql);            
        } catch (SQLException e) {
            System.out.println("Una excepcion a ocurrido " + e.getMessage());
            respuesta = false;
        }
        return respuesta;
    }

    public boolean updateBienes(String codigo, String placa, String tipologia, String consecutivo, String sede, String placaexterna, String llave, String descripcion, String descripciondetallada, String cantidad, String valor, String factura, Date fechas, String vidautil, String serial, String marca, String modelo, String destinatarios, String uentaactivo, String cuentadepreciacion, String saldo, String estado, String aplicdep, String funcionario) {
        try {
            stmt = con.createStatement();
            stmt.executeUpdate("UPDATE  BIENES SET bie_id,bie_placa,bie_tipologia,bie_consecutivo,bie_sede,bie_placa_externa,bie_llave,bie_descripcion,bie_detallada, bie_cantidad, bie_valor, bie_factura, bie_fecha, bie_vidautil,bie_serial, bie_marca, bie_modelo, bie_destinatario, bie_cuentaactivo, bie_cuentaDep, bie_saldo, bie_estado, bie_aplica) "
                    + "VALUES('" + codigo + "','" + placa + "','" + tipologia + "','" + consecutivo + "'," + Integer.parseInt(sede) + ",'" + placaexterna + "','" + llave + "','" + descripcion + "','" + descripciondetallada + "','" + cantidad + "','" + valor + "','" + factura + "','16-05-05','" + vidautil + "','" + serial + "','" + marca + "','" + modelo + "','" + destinatarios + "','" + uentaactivo + "','" + cuentadepreciacion + "','" + saldo + "','" + estado + "','" + aplicdep + "')");
            return true;
        } catch (Exception e) {
            System.out.println("Excepcion " + e);
        }
        return false;
    }
    
    /*
    
    
    ESTOS SON LOS DOS METODOS QUE INCLUI
    
    */
    
    public int insertarCuenta(Cuentas cuentas){
        int registro = 1;
        try{
            stmt = con.createStatement();
            String sql = "insert into contables (cue_num_cuenta,cue_nombre_cuenta,cue_cuenta_depreciacion,cue_anios_vida_util) values "
                    + "("+cuentas.getNumCuenta()+",'"+cuentas.getNombreCuenta()+"',"+cuentas.getDepreciacion()+","+cuentas.getVidaUtil()+")";
            stmt.execute(sql);
        }
        catch(SQLException ex){
            System.out.println("Ha ocurrido un error "+ex.getMessage());
            registro = -1;
        }
        return registro;
    }
    
    public List<Cuentas> obtenerCuentas() throws SQLException{
        List<Cuentas> lista = new ArrayList<>();
        stmt = con.createStatement();
        String sql = "select * from contables";
        rs = stmt.executeQuery(sql);
        while(rs.next()){
            Cuentas cuenta = new Cuentas();
            cuenta.setNumCuenta(rs.getInt(1));
            cuenta.setNombreCuenta(rs.getString(2));
            cuenta.setDepreciacion(rs.getInt(3));
            cuenta.setVidaUtil(rs.getInt(4));
            lista.add(cuenta);
        }
        return lista;
    }
    
     public int eliminarCuentas(Cuentas cuentas) {
        int borrado = 1;
        try {
            stmt = con.createStatement();
            stmt.executeUpdate("delete from contables where cue_num_cuenta='" + cuentas.getNumCuenta() + "'");
        } catch (SQLException e) {
            System.out.println("Un error ha ocurrido al eliminar los datos "+e.getMessage());
            borrado = -1;
        }
        return borrado;
    }

    /*
    
    */
    

    public List<Object[]> consultaBienes() throws SQLException {
        List<Object[]> nombre = new ArrayList<Object[]>();
        stmt = con.createStatement();
        String sql = "SELECT bie_id,bie_placa,bie_tipologia,bie_consecutivo,bie_sede,bie_placa_externa,bie_llave,bie_descripcion,bie_detallada, bie_cantidad, bie_valor, bie_factura, bie_fecha, bie_vida_util,bie_serial, bie_marca, bie_modelo, bie_destinatario, bie_cuenta_activo, bie_cuenta_dep, bie_saldo, bie_estado, bie_aplica FROM bienes";
        System.out.println(""+sql);
        rs = stmt.executeQuery(sql);
        while (rs.next()) {
            nombre.add(new Object[]{rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9), rs.getString(10), rs.getString(11), rs.getString(12), rs.getString(13), rs.getString(14), rs.getString(15), rs.getString(16), rs.getString(17), rs.getString(18), rs.getString(19), rs.getString(20), rs.getString(21), rs.getString(22), rs.getString(23)});
        }
        return nombre;
    }

    public void eliminarBien(String codigo) {
        try {
            stmt = con.createStatement();
            stmt.executeUpdate("delete from bienes where bie_id='" + codigo + "'");
        } catch (Exception e) {
        }
    }

//    public boolean insertGeneral(String tabla,List<String> valores,List<String> campos){
//    try{
//    stmt = con.createStatement();
//      stmt.executeUpdate("INSERT INTO "+tabla+" ("+campos.toString().replaceAll("\\[", "").replaceAll("\\]", "")+") "
//              + "VALUES('"+codigo+"','"+placa+"','"+tipologia+"','"+consecutivo+"',"+Integer.parseInt(sede)+",'"+placaexterna+"','"+llave+"','"+descripcion+"','"+descripciondetallada+"','"+cantidad+"','"+valor+"','"+factura+"','16-05-05','"+vidautil+"','"+serial+"','"+marca+"','"+modelo+"','"+destinatarios+"','"+uentaactivo+"','"+cuentadepreciacion+"','"+saldo+"','"+estado+"','"+aplicdep+"')");
//      return true;
//    }catch(SQLException e){
//    }
//    }
}
