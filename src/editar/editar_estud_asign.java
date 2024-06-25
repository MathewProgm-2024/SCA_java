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
public class editar_estud_asign {
    public static void main(String[] args) {
        //CONEXION
        conexion con = new conexion();
        Connection cn;
        Statement st;
        ResultSet rs;

        //DATOS A AGREGAR
        int id_editar = 1;
        int new_id_estud = 1;
        int new_id_asign = 1;
        double new_nota1 = 3.5;
        double new_nota2 = 3.3;
        double new_nota3 = 3.8;
        double new_nota4 = 3.9;
        double new_nota5 = 3.0;
        double new_nota_parc = (new_nota1+new_nota2+new_nota3+new_nota4+new_nota5)/5;
        double new_coev = 4;
        double new_autoev = 3.5;
        double new_nota_fin = (new_nota_parc*0.80)+(new_coev*0.10)+(new_autoev*0.10);

        //INSTRUCCION SQL
        String sql = "UPDATE estud_asign set id_estud='"+new_id_estud+"', id_asign='"+new_id_asign+"', nota1='"+new_nota1+"', nota2='"+new_nota2+"', nota3='"+new_nota3+"', nota4='"+new_nota4+"', nota5='"+new_nota5+"', nota_parc='"+new_nota_parc+"', coev='"+new_coev+"', autoev='"+new_autoev+"', nota_fin='"+new_nota_fin+"' where id="+id_editar;

        try {
            // TODO code application logic here
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(editar_estud_asign.class.getName()).log(Level.SEVERE, null, ex);
        }

        try {
            cn = con.getConection();
            st = cn.createStatement();
            st.executeUpdate(sql); // EDITAR DATOS
            rs = st.executeQuery("SELECT * FROM estud_asign"); // TRAER DATOS DE LA TABLA ESTUD_ASIGN
            rs.next();

            // IMPRIMIR EN CONSOLA LOS DATOS DE LA TABLA ESTUD_ASIGN
            do {
                System.out.println(rs.getInt("id")+": "+rs.getInt("id_estud")+" - "+rs.getInt("id_asign")+" - "+rs.getFloat("nota1")+" - "+rs.getFloat("nota2")+" - "+rs.getFloat("nota3")+" - "+rs.getFloat("nota4")+" - "+rs.getFloat("nota5")+" - "+rs.getFloat("nota_parc")+" - "+rs.getFloat("coev")+" - "+rs.getFloat("autoev")+" - "+rs.getFloat("nota_fin"));
            } while (rs.next());

        } catch (SQLException ex) {
            Logger.getLogger(editar_estud_asign.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
