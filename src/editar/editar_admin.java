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
public class editar_admin {
    public static void main(String[] args) {
        //CONEXION
        conexion con = new conexion();
        Connection cn;
        Statement st;
        ResultSet rs;

        //DATOS A EDITAR
        int id_editar = 1;
        String new_nombre = "Ximena";
        String new_apell = "Jimenez";
        String new_num_doc = "4957455";
        String new_fech_nac = "1989/09/07";
        String new_ciud_nac = "Bogota";
        String new_barr_res = "Cabaña";
        String new_direc_res = "Carrera 87 #45-4";
        String new_edad = "44";
        String new_genero = "Femenino";
        String new_rh = "O+";
        String new_eps = "Compensar";
        String new_telefono = "34762417";
        String new_correo = "correoRectoria@gmail.com";
        String new_cargo = "Rector";
        String new_usuario = "rectoria";
        String new_contras = "65sd4f55";

        //INSTRUCCION SQL
        String sql = "UPDATE administradores set nombre='" + new_nombre + "', apell='" + new_apell + "', num_doc='" + new_num_doc + "', fech_nac='" + new_fech_nac + "', ciud_nac='" + new_ciud_nac + "', barr_res='" + new_barr_res + "', direc_res='" + new_direc_res + "', edad='" + new_edad + "', genero='" + new_genero + "', rh='" + new_rh + "', eps='" + new_eps + "', telefono='" + new_telefono + "', correo='" + new_correo + "', cargo='" + new_cargo + "', usuario='" + new_usuario + "', contras='" + new_contras +"' where id=" + id_editar;
        
        try {
            // TODO code application logic here
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(editar_admin.class.getName()).log(Level.SEVERE, null, ex);
        }

        try {
            cn = con.getConection();
            st = cn.createStatement();
            st.executeUpdate(sql); // EDITAR DATOS
            rs = st.executeQuery("SELECT * FROM administradores"); // TRAER DATOS DE LA TABLA ADMINISTRADORES
            rs.next();

            // IMPRIMIR EN CONSOLA LOS DATOS DE LA TABLA ADMINISTRADORES
            do {
                System.out.println(rs.getInt("id")+": "+rs.getString("nombre")+" - "+rs.getString("apell")+" - "+rs.getString("num_doc")+" - "+rs.getDate("fech_nac")+" - "+rs.getString("ciud_nac")+" - "+rs.getString("barr_res")+" - "+rs.getString("direc_res")+" - "+rs.getString("edad")+" - "+rs.getString("genero")+" - "+rs.getString("rh")+" - "+rs.getString("eps")+" - "+rs.getString("telefono")+" - "+rs.getString("correo")+" - "+rs.getString("cargo")+" - "+rs.getString("usuario")+" - "+rs.getString("contras"));
            } while (rs.next());

        } catch (SQLException ex) {
            Logger.getLogger(editar_admin.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
