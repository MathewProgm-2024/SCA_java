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
public class ver_asign_estud_per {

    public static void main(String[] args) {
        // CONEXION
        conexion con = new conexion();
        Connection cn;
        Statement st;
        ResultSet rs;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ver_asign_estud_per.class.getName()).log(Level.SEVERE, null, ex);
        }

        try {
            cn = con.getConection();
            st = cn.createStatement();
            rs = st.executeQuery("SELECT * FROM asign_estud_per"); // TRAER DATOS DE LA TABLA ASIGN_ESTUD_PER
            rs.next();

            // IMPRIMIR EN CONSOLA LOS DATOS DE LA TABLA ASIGN_ESTUD_PER
            do {
                System.out.println(rs.getInt("id") + ": " + rs.getInt("id_per") + " - " + rs.getInt("id_estudasign"));
            } while (rs.next());

        } catch (SQLException ex) {
            Logger.getLogger(ver_asign_estud_per.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
