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
public class editar_curso {
    public static void main(String[] args) {
        // CONEXION
        conexion con = new conexion();
        Connection cn;
        Statement st;
        ResultSet rs;

        // DATOS A EDITAR
        int id_editar = 3;
        String new_codigo = "504";

        // INSTRUCCION SQL
        String sql = "UPDATE cursos set codigo='"+new_codigo+"' where id="+id_editar;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(editar_curso.class.getName()).log(Level.SEVERE, null, ex);
        }

        try {
            cn = con.getConection();
            st = cn.createStatement();
            st.executeUpdate(sql); // EDITAR DATOS
            rs = st.executeQuery("SELECT * FROM cursos"); // TRAER DATOS DE LA TABLA CURSOS
            rs.next();

            // IMPRIMIR EN CONSOLA LOS DATOS DE LA TABLA CURSOS
            do {
                System.out.println(rs.getInt("id") + ": " + rs.getString("codigo"));
            } while (rs.next());

        } catch (SQLException ex) {
            Logger.getLogger(editar_curso.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
