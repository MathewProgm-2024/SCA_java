/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package consultar;

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
public class ver_profesores {

    public static void main(String[] args) {
        // CONEXION
        conexion con = new conexion();
        Connection cn;
        Statement st;
        ResultSet rs;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ver_profesores.class.getName()).log(Level.SEVERE, null, ex);
        }

        try {
            cn = con.getConection();
            st = cn.createStatement();
            rs = st.executeQuery("SELECT * FROM profesores"); // TRAER DATOS DE LA TABLA PROFESORES
            rs.next();

            // IMPRIMIR EN CONSOLA LOS DATOS DE LA TABLA PROFESORES
            do {
                System.out.println(rs.getInt("id") + ": " + rs.getString("nombre") + " - " + rs.getString("apell") + " - " + rs.getString("num_doc") + " - " + rs.getDate("fech_nac") + " - " + rs.getString("ciud_nac") + " - " + rs.getString("barr_res") + " - " + rs.getString("direc_res") + " - " + rs.getString("edad") + " - " + rs.getString("genero") + " - " + rs.getString("rh") + " - " + rs.getString("eps") + " - " + rs.getString("telefono") + " - " + rs.getString("correo") + " - " + rs.getString("num_lic") + " - " + rs.getString("usuario") + " - " + rs.getString("contras"));
            } while (rs.next());

        } catch (SQLException ex) {
            Logger.getLogger(ver_profesores.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
