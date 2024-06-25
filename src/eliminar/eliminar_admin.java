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
public class eliminar_admin {
    public static void main(String[] args) {
        // CONEXION
        conexion con = new conexion();
        Connection cn;
        Statement st;
        ResultSet rs;

        // DATOS A EDITAR
        int id_eliminar = 1;

        // INSTRUCCION SQL
        String sql = "DELETE FROM administradores where id="+id_eliminar;
        
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(eliminar_admin.class.getName()).log(Level.SEVERE, null, ex);
        }

        try {
            cn = con.getConection();
            st = cn.createStatement();
            st.executeUpdate(sql); // ELIMINAR DATOS
            rs = st.executeQuery("SELECT * FROM administradores"); // TRAER DATOS DE LA TABLA ADMINISTRADORES
            rs.next();

            // IMPRIMIR EN CONSOLA LOS DATOS DE LA TABLA ADMINISTRADORES
            do {
                System.out.println(rs.getInt("id")+": "+rs.getString("nombre")+" - "+rs.getString("apell")+" - "+rs.getString("num_doc")+" - "+rs.getDate("fech_nac")+" - "+rs.getString("ciud_nac")+" - "+rs.getString("barr_res")+" - "+rs.getString("direc_res")+" - "+rs.getString("edad")+" - "+rs.getString("genero")+" - "+rs.getString("rh")+" - "+rs.getString("eps")+" - "+rs.getString("telefono")+" - "+rs.getString("correo")+" - "+rs.getString("cargo")+" - "+rs.getString("usuario")+" - "+rs.getString("contras"));
            } while (rs.next());

        } catch (SQLException ex) {
            Logger.getLogger(eliminar_admin.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
