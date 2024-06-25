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
public class editar_estudiante {
    public static void main(String[] args) {
        // CONEXION
        conexion con = new conexion();
        Connection cn;
        Statement st;
        ResultSet rs;

        // DATOS A AGREGAR
        int id_editar = 3;
        String new_nombre = "Sofia";
        String new_apell = "Sanchez";
        String new_num_doc = "6375285";
        String new_fech_nac = "2008/03/31";
        String new_ciud_nac = "Bucaramanga";
        String new_barr_res = "Alamos";
        String new_direc_res = "Trasv 14 #34-5C";
        String new_edad = "14";
        String new_genero = "Femenino";
        String new_rh = "AB-";
        String new_eps = "SURA";
        String new_telefono = "163274724";
        String new_correo = "correothoms@hotmail.com";
        String new_nomb_acud = "Dario";
        String new_apell_acu = "Lopez";
        String new_usuario = "thomlop05";
        String new_contras = "56s4df56";
        int new_id_curso = 2;

        //INSTRUCCION SQL
        String sql = "UPDATE estudiantes set nombre='"+new_nombre+"', apell='"+new_apell+"', num_doc='"+new_num_doc+"', fech_nac='"+new_fech_nac+"', ciud_nac='"+new_ciud_nac+"', barr_res='"+new_barr_res+"', direc_res='"+new_direc_res+"', edad='"+new_edad+"', genero='"+new_genero+"', rh='"+new_rh+"', eps='"+new_eps+"', telefono='"+new_telefono+"', correo='"+new_correo+"', nomb_acud='"+new_nomb_acud+"', apell_acu='"+new_apell_acu+"', usuario='"+new_usuario+"', contras='"+new_contras+"', id_curso='"+new_id_curso+"' where id="+id_editar;

        try {
            // TODO code application logic here
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(editar_estudiante.class.getName()).log(Level.SEVERE, null, ex);
        }

        try {
            cn = con.getConection();
            st = cn.createStatement();
            st.executeUpdate(sql); // EDITAR DATOS
            rs = st.executeQuery("SELECT * FROM estudiantes"); // TRAER DATOS DE LA TABLA ESTUDIANTES
            rs.next();

            // IMPRIMIR EN CONSOLA LOS DATOS DE LA TABLA ESTUDIANTES
            do {
                System.out.println(rs.getInt("id")+": "+rs.getString("nombre")+" - "+rs.getString("apell")+" - "+rs.getString("num_doc")+" - "+rs.getDate("fech_nac")+" - "+rs.getString("ciud_nac")+" - "+rs.getString("barr_res")+" - "+rs.getString("direc_res")+" - "+rs.getString("edad")+" - "+rs.getString("genero")+" - "+rs.getString("rh")+" - "+rs.getString("eps")+" - "+rs.getString("telefono")+" - "+rs.getString("correo")+" - "+rs.getString("nomb_acud")+" - "+rs.getString("apell_acu")+" - "+rs.getString("usuario")+" - "+rs.getString("contras")+" - "+rs.getInt("id_curso"));
            } while (rs.next());

        } catch (SQLException ex) {
            Logger.getLogger(editar_estudiante.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
