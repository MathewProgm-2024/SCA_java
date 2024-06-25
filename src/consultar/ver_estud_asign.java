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
public class ver_estud_asign {

    public static void main(String[] args) {
        // CONEXION
        conexion con = new conexion();
        Connection cn;
        Statement st;
        ResultSet rs;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ver_estud_asign.class.getName()).log(Level.SEVERE, null, ex);
        }

        try {
            cn = con.getConection();
            st = cn.createStatement();
            rs = st.executeQuery("SELECT * FROM estud_asign"); // TRAER DATOS DE LA TABLA ESTUD_ASIGN
            rs.next();

            // IMPRIMIR EN CONSOLA LOS DATOS DE LA TABLA ESTUD_ASIGN
            do {
                System.out.println(rs.getInt("id") + ": " + rs.getInt("id_estud") + " - " + rs.getInt("id_asign") + " - " + rs.getFloat("nota1") + " - " + rs.getFloat("nota2") + " - " + rs.getFloat("nota3") + " - " + rs.getFloat("nota4") + " - " + rs.getFloat("nota5") + " - " + rs.getFloat("nota_parc") + " - " + rs.getFloat("coev") + " - " + rs.getFloat("autoev") + " - " + rs.getFloat("nota_fin"));
            } while (rs.next());

        } catch (SQLException ex) {
            Logger.getLogger(ver_estud_asign.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
