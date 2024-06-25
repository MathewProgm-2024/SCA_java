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
public class eliminar_asignatura {
    public static void main(String[] args) {
        // CONEXION
        conexion con = new conexion();
        Connection cn;
        Statement st;
        ResultSet rs;

        // DATOS A EDITAR
        int id_eliminar = 4;

        // INSTRUCCION SQL
        String sql = "DELETE FROM asignaturas where id="+id_eliminar;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(eliminar_asignatura.class.getName()).log(Level.SEVERE, null, ex);
        }

        try {
            cn = con.getConection();
            st = cn.createStatement();
            st.executeUpdate(sql); // ELIMINAR DATOS
            rs = st.executeQuery("SELECT * FROM asignaturas"); // TRAER DATOS DE LA TABLA ASIGNATURAS
            rs.next();

            // IMPRIMIR EN CONSOLA LOS DATOS DE LA TABLA CURSOS
            do {
                System.out.println(rs.getInt("id")+": "+rs.getString("nombre")+" - "+rs.getString("grado")+" - "+rs.getInt("id_prof"));
            } while (rs.next());

        } catch (SQLException ex) {
            Logger.getLogger(eliminar_asignatura.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
