/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author USUARIO
 */
public class conexion {
        Connection con;
        
    public conexion(){
        try{
            Class.forName("com.mysql.jdbc.Driver");            
            con=DriverManager.getConnection("jdbc:mysql://localhost:3306/bd_sca","root","mrc92109");
        }catch(ClassNotFoundException | SQLException e){
            System.out.println("No conectado");
        }
    }
    
    public Connection getConection(){
        return con;
    }
}


