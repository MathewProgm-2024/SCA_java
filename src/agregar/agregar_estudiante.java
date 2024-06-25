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
public class agregar_estudiante {
    public static void main(String[] args) {
        // CONEXION
        conexion con = new conexion();
        Connection cn;
        Statement st;
        ResultSet rs;

        // DATOS A AGREGAR
        String nombre = "Thomas";
        String apell = "Lopez";
        String num_doc = "41564654";
        String fech_nac = "2010/10/01";
        String ciud_nac = "Cali";
        String barr_res = "La Estrada";
        String direc_res = "Calle 58C #25-45D";
        String edad = "13";
        String genero = "Masculino";
        String rh = "AB-";
        String eps = "SURA";
        String telefono = "163274724";
        String correo = "correothoms@hotmail.com";
        String nomb_acud = "Dario";
        String apell_acu = "Lopez";
        String usuario = "thomlop05";
        String contras = "56s4df56";
        int id_curso = 2;

        //INSTRUCCION SQL
        String sql = "INSERT INTO estudiantes(nombre, apell, num_doc, fech_nac, ciud_nac, barr_res, direc_res, edad, genero, rh, eps, telefono, correo, nomb_acud, apell_acu, usuario, contras, id_curso) values('" + nombre + "','" + apell + "','" + num_doc + "','" + fech_nac + "','" + ciud_nac + "','" + barr_res + "','" + direc_res + "','" + edad + "','" + genero + "','" + rh + "','" + eps + "','" + telefono + "','" + correo + "','" + nomb_acud + "','" + apell_acu + "','" + usuario + "','" + contras + "','" + id_curso + "');";

        try {
            // TODO code application logic here
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(agregar_estudiante.class.getName()).log(Level.SEVERE, null, ex);
        }

        try {
            cn = con.getConection();
            st = cn.createStatement();
            st.executeUpdate(sql); // AGREGAR DATOS
            rs = st.executeQuery("SELECT * FROM estudiantes"); // TRAER DATOS DE LA TABLA ESTUDIANTES
            rs.next();

            // IMPRIMIR EN CONSOLA LOS DATOS DE LA TABLA ESTUDIANTES
            do {
                System.out.println(rs.getInt("id")+": "+rs.getString("nombre")+" - "+rs.getString("apell")+" - "+rs.getString("num_doc")+" - "+rs.getDate("fech_nac")+" - "+rs.getString("ciud_nac")+" - "+rs.getString("barr_res")+" - "+rs.getString("direc_res")+" - "+rs.getString("edad")+" - "+rs.getString("genero")+" - "+rs.getString("rh")+" - "+rs.getString("eps")+" - "+rs.getString("telefono")+" - "+rs.getString("correo")+" - "+rs.getString("nomb_acud")+" - "+rs.getString("apell_acu")+" - "+rs.getString("usuario")+" - "+rs.getString("contras")+" - "+rs.getInt("id_curso"));
            } while (rs.next());

        } catch (SQLException ex) {
            Logger.getLogger(agregar_estudiante.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
