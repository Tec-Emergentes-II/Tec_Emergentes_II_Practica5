/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.emergentes.utiles;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Eva Carmen Huaylliri Ajata
 */
public class ConexionDB {
    
    static String driver = "com.mysql.jdbc.Driver";
    static String url = "jdbc:mysql://localhost:3306/bd_almacen";
    static String usuario = "root";
    static String password = "12345";
    
    protected Connection conn = null;
    
     public ConexionDB(){
        
        try {
            Class.forName(driver);
            conn = DriverManager.getConnection(url,usuario,password);
            if(conn != null){
                System.out.println("conexion exitosa" + conn);
            }
                
         
        }    catch (ClassNotFoundException ex){
             System.out.println("falta driver" + ex.getMessage());
        } catch (SQLException ex) {
             System.out.println("error de sql" + ex.getMessage()); 
             
        }
    
     }
    public Connection conectar()
            
    {
        return conn;
    }
        
    public void desconectar()
    {
     try {
            //System.out.println("cerrando la BD" + conn);
            conn.close();
        } catch (SQLException ex) {
            System.out.println("error de sql al cerrar" + ex.getMessage());
        }
    
    }
    
}

