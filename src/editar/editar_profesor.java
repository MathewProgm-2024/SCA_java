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
public class editar_profesor {

    public static void main(String[] args) {
        //CONEXION
        conexion con = new conexion();
        Connection cn;
        Statement st;
        ResultSet rs;

        //DATOS A EDITAR
        int id_editar = 2;
        String new_nombre = "Mario";
        String new_apell = "Garcia";
        String new_num_doc = "675264";
        String new_fech_nac = "1991/01/02";
        String new_ciud_nac = "Bogota";
        String new_barr_res = "Calios";
        String new_direc_res = "Calle 85A #65-4";
        String new_edad = "42";
        String new_genero = "Masculino";
        String new_rh = "AB+";
        String new_eps = "Compensar";
        String new_telefono = "7954975";
        String new_correo = "correoMario@gmail.com";
        String new_num_lic = "76456574";
        String new_usuario = "profe_2";
        String new_contras = "x1v5x465";

        //INSTRUCCION SQL
        String sql = "UPDATE profesores set nombre='" + new_nombre + "', apell='" + new_apell + "', num_doc='" + new_num_doc + "', fech_nac='" + new_fech_nac + "', ciud_nac='" + new_ciud_nac + "', barr_res='" + new_barr_res + "', direc_res='" + new_direc_res + "', edad='" + new_edad + "', genero='" + new_genero + "', rh='" + new_rh + "', eps='" + new_eps + "', telefono='" + new_telefono + "', correo='" + new_correo + "', num_lic='" + new_num_lic + "', usuario='" + new_usuario + "', contras='" + new_contras +"' where id=" + id_editar;
        
        try {
            // TODO code application logic here
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(editar_profesor.class.getName()).log(Level.SEVERE, null, ex);
        }

        try {
            cn = con.getConection();
            st = cn.createStatement();
            st.executeUpdate(sql); // EDITAR DATOS
            rs = st.executeQuery("SELECT * FROM profesores"); // TRAER DATOS DE LA TABLA PROFESORES
            rs.next();

            // IMPRIMIR EN CONSOLA LOS DATOS DE LA TABLA PROFESORES
            do {
                System.out.println(rs.getInt("id")+": "+rs.getString("nombre")+" - "+rs.getString("apell")+" - "+rs.getString("num_doc")+" - "+rs.getDate("fech_nac")+" - "+rs.getString("ciud_nac")+" - "+rs.getString("barr_res")+" - "+rs.getString("direc_res")+" - "+rs.getString("edad")+" - "+rs.getString("genero")+" - "+rs.getString("rh")+" - "+rs.getString("eps")+" - "+rs.getString("telefono")+" - "+rs.getString("correo")+" - "+rs.getString("num_lic")+" - "+rs.getString("usuario")+" - "+rs.getString("contras"));
            } while (rs.next());

        } catch (SQLException ex) {
            Logger.getLogger(editar_profesor.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
