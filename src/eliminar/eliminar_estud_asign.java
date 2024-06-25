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
public class eliminar_estud_asign {
    public static void main(String[] args) {
        // CONEXION
        conexion con = new conexion();
        Connection cn;
        Statement st;
        ResultSet rs;

        // DATOS A ELIMINAR
        int id_eliminar = 4;

        // INSTRUCCION SQL
        String sql = "DELETE FROM estud_asign where id="+id_eliminar;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(eliminar_estud_asign.class.getName()).log(Level.SEVERE, null, ex);
        }

        try {
            cn = con.getConection();
            st = cn.createStatement();
            st.executeUpdate(sql); // ELIMINAR DATOS
            rs = st.executeQuery("SELECT * FROM estud_asign"); // TRAER DATOS DE LA TABLA ESTUD_ASIGN
            rs.next();

            // IMPRIMIR EN CONSOLA LOS DATOS DE LA TABLA ESTUD_ASIGN
            do {
                System.out.println(rs.getInt("id")+": "+rs.getInt("id_estud")+" - "+rs.getInt("id_asign")+" - "+rs.getFloat("nota1")+" - "+rs.getFloat("nota2")+" - "+rs.getFloat("nota3")+" - "+rs.getFloat("nota4")+" - "+rs.getFloat("nota5")+" - "+rs.getFloat("nota_parc")+" - "+rs.getFloat("coev")+" - "+rs.getFloat("autoev")+" - "+rs.getFloat("nota_fin"));
            } while (rs.next());

        } catch (SQLException ex) {
            Logger.getLogger(eliminar_estud_asign.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
