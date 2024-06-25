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
public class agregar_profesor {
    public static void main(String[] args) {
        //CONEXION
        conexion con = new conexion();
        Connection cn;
        Statement st;
        ResultSet rs;

        //DATOS A AGREGAR
        String nombre = "Dora";
        String apell = "Perez";
        String num_doc = "4657548";
        String fech_nac = "1997/07/03";
        String ciud_nac = "Medellin";
        String barr_res = "Rosal";
        String direc_res = "Trasv 85 #4B-7";
        String edad = "35";
        String genero = "Femenino";
        String rh = "A+";
        String eps = "Compensar";
        String telefono = "6456314";
        String correo = "correoDora@gmail.com";
        String num_lic = "6754175";
        String usuario = "profe_1";
        String contras = "854ghj8";

        //INSTRUCCION SQL
        String sql = "INSERT INTO profesores(nombre, apell, num_doc, fech_nac, ciud_nac, barr_res, direc_res, edad, genero, rh, eps, telefono, correo, num_lic, usuario, contras) values('" + nombre + "','" + apell + "','" + num_doc + "','" + fech_nac + "','" + ciud_nac + "','" + barr_res + "','" + direc_res + "','" + edad + "','" + genero + "','" + rh + "','" + eps + "','" + telefono + "','" + correo + "','" + num_lic + "','" + usuario + "','" + contras + "');";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(agregar_profesor.class.getName()).log(Level.SEVERE, null, ex);
        }

        try {
            cn = con.getConection();
            st = cn.createStatement();
            st.executeUpdate(sql); // AGREGAR DATOS
            rs = st.executeQuery("SELECT * FROM profesores"); // TRAER DATOS DE LA TABLA PROFESORES
            rs.next();

            // IMPRIMIR EN CONSOLA LOS DATOS DE LA TABLA PROFESORES
            do {
                System.out.println(rs.getInt("id")+": "+rs.getString("nombre")+" - "+rs.getString("apell")+" - "+rs.getString("num_doc")+" - "+rs.getDate("fech_nac")+" - "+rs.getString("ciud_nac")+" - "+rs.getString("barr_res")+" - "+rs.getString("direc_res")+" - "+rs.getString("edad")+" - "+rs.getString("genero")+" - "+rs.getString("rh")+" - "+rs.getString("eps")+" - "+rs.getString("telefono")+" - "+rs.getString("correo")+" - "+rs.getString("num_lic")+" - "+rs.getString("usuario")+" - "+rs.getString("contras"));
            } while (rs.next());

        } catch (SQLException ex) {
            Logger.getLogger(agregar_profesor.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
