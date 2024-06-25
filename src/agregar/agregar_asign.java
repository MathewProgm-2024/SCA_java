/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package agregar;

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
public class agregar_asign {
    public static void main(String[] args) {
        //CONEXION
        conexion con = new conexion();
        Connection cn;
        Statement st;
        ResultSet rs;

        //DATOS A AGREGAR
        String nombre = "Ciencias Sociales";
        String grado = "Quinto";
        int id_prof = 1;

        //INSTRUCCION SQL
        String sql = "INSERT INTO asignaturas(nombre, grado, id_prof) values('" + nombre + "','" + grado + "','" + id_prof + "')";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(agregar_asign.class.getName()).log(Level.SEVERE, null, ex);
        }

        try {
            cn = con.getConection();
            st = cn.createStatement();
            st.executeUpdate(sql); //AGREGAR DATOS
            rs = st.executeQuery("SELECT * FROM asignaturas"); //TRAER DATOS DE LA TABLA ASIGNATURAS
            rs.next();

            //IMPRIMIR EN CONSOLA LOS DATOS DE LA TABLA ASIGNATURAS
            do {
                System.out.println(rs.getInt("id")+": "+rs.getString("nombre")+" - "+rs.getString("grado")+" - "+rs.getInt("id_prof"));
            } while (rs.next());

        } catch (SQLException ex) {
            Logger.getLogger(agregar_asign.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
