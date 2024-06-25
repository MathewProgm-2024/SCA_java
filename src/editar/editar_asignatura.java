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
 * @author USUARIO
 */
public class editar_asignatura {
    public static void main(String[] args) {
        //CONEXION
        conexion con = new conexion();
        Connection cn;
        Statement st;
        ResultSet rs;

        //DATOS A EDITAR
        int id_editar = 1;
        String new_nombre = "Matematicas";
        String new_grado = "Cuarto";
        int new_id_prof = 2;

        //INSTRUCCION SQL
        String sql = "UPDATE asignaturas set nombre='"+new_nombre+"', grado='"+new_grado+"', id_prof='"+new_id_prof+"' where id="+id_editar;

        try {
            // TODO code application logic here
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(editar_asignatura.class.getName()).log(Level.SEVERE, null, ex);
        }

        try {
            cn = con.getConection();
            st = cn.createStatement();
            st.executeUpdate(sql); //EDITAR DATOS
            rs = st.executeQuery("SELECT * FROM asignaturas"); //TRAER DATOS DE LA TABLA ASIGNATURAS
            rs.next();

            // IMPRIMIR EN CONSOLA LOS DATOS DE LA TABLA CURSOS
            do {
                System.out.println(rs.getInt("id")+": "+rs.getString("nombre")+" - "+rs.getString("grado")+" - "+rs.getInt("id_prof"));
            } while (rs.next());

        } catch (SQLException ex) {
            Logger.getLogger(editar_asignatura.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
