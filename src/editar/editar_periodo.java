/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package editar;

import conexion.conexion;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Mateo Rodriguez C - 2721519
 */
public class editar_periodo {
    public static void main(String[] args) {
        // CONEXION
        conexion con = new conexion();
        Connection cn;
        Statement st;
        ResultSet rs;

        // DATOS A EDITAR
        int id_editar = 2;
        String new_num_per = "3";

        // INSTRUCCION SQL
        String sql = "UPDATE periodos set num_per='"+new_num_per+"' where id="+id_editar;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(editar_periodo.class.getName()).log(Level.SEVERE, null, ex);
        }

        try {
            cn = con.getConection();
            st = cn.createStatement();
            st.executeUpdate(sql); // EDITAR DATOS
            rs = st.executeQuery("SELECT * FROM periodos"); // TRAER DATOS DE LA TABLA PERIODOS
            rs.next();

            // IMPRIMIR EN CONSOLA LOS DATOS DE LA TABLA PERIODOS
            do {
                System.out.println(rs.getInt("id") + ": " + rs.getString("num_per"));
            } while (rs.next());

        } catch (SQLException ex) {
            Logger.getLogger(editar_periodo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
