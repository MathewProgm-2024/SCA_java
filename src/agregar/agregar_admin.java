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
public class agregar_admin {
    public static void main(String[] args) {
        // CONEXION
        conexion con = new conexion();
        Connection cn;
        Statement st;
        ResultSet rs;

        // DATOS A AGREGAR
        String nombre = "Helena";
        String apell = "Casallas";
        String num_doc = "265275";
        String fech_nac = "1987/02/14";
        String ciud_nac = "Bogota";
        String barr_res = "Floresta";
        String direc_res = "Avenida 79 #15-8F";
        String edad = "45";
        String genero = "Femenino";
        String rh = "O-";
        String eps = "Compensar";
        String telefono = "3276547";
        String correo = "correohelena@gmail.com";
        String cargo = "Rector";
        String usuario = "rectoria";
        String contras = "5s4dfa65";

        // INSTRUCCION SQL
        String sql = "INSERT INTO administradores(nombre, apell, num_doc, fech_nac, ciud_nac, barr_res, direc_res, edad, genero, rh, eps, telefono, correo, cargo, usuario, contras) values('" + nombre + "','" + apell + "','" + num_doc + "','" + fech_nac + "','" + ciud_nac + "','" + barr_res + "','" + direc_res + "','" + edad + "','" + genero + "','" + rh + "','" + eps + "','" + telefono + "','" + correo + "','" + cargo + "','" + usuario + "','" + contras + "');";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(agregar_admin.class.getName()).log(Level.SEVERE, null, ex);
        }

        try {
            cn = con.getConection();
            st = cn.createStatement();
            st.executeUpdate(sql); // AGREGAR DATOS
            rs = st.executeQuery("SELECT * FROM administradores"); // TRAER DATOS DE LA TABLA ADMINISTRADORES
            rs.next();

            // IMPRIMIR EN CONSOLA LOS DATOS DE LA TABLA ADMINISTRADORES
            do {
                System.out.println(rs.getInt("id")+": "+rs.getString("nombre")+" - "+rs.getString("apell")+" - "+rs.getString("num_doc")+" - "+rs.getDate("fech_nac")+" - "+rs.getString("ciud_nac")+" - "+rs.getString("barr_res")+" - "+rs.getString("direc_res")+" - "+rs.getString("edad")+" - "+rs.getString("genero")+" - "+rs.getString("rh")+" - "+rs.getString("eps")+" - "+rs.getString("telefono")+" - "+rs.getString("correo")+" - "+rs.getString("cargo")+" - "+rs.getString("usuario")+" - "+rs.getString("contras"));
            } while (rs.next());

        } catch (SQLException ex) {
            Logger.getLogger(agregar_admin.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
