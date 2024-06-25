/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eliminar;

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
public class eliminar_asign_estud_per {
    public static void main(String[] args) {
        // CONEXION
        conexion con = new conexion();
        Connection cn;
        Statement st;
        ResultSet rs;

        // DATOS A EDITAR
        int id_eliminar = 3;

        // NSTRUCCION SQL
        String sql = "DELETE FROM asign_estud_per where id="+id_eliminar;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(eliminar_asign_estud_per.class.getName()).log(Level.SEVERE, null, ex);
        }

        try {
            cn = con.getConection();
            st = cn.createStatement();
            st.executeUpdate(sql); // ELIMINAR DATOS
            rs = st.executeQuery("SELECT * FROM asign_estud_per"); // TRAER DATOS DE LA TABLA ASIGN_ESTUD_PER
            rs.next();

            // IMPRIMIR EN CONSOLA LOS DATOS DE LA TABLA ASIGN_ESTUD_PER
            do {
                System.out.println(rs.getInt("id")+": "+rs.getInt("id_per")+" - "+rs.getInt("id_estudasign"));
            } while (rs.next());

        } catch (SQLException ex) {
            Logger.getLogger(eliminar_asign_estud_per.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
