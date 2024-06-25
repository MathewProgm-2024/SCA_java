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
public class agregar_estud_asign {
    public static void main(String[] args) {
        // CONEXION
        conexion con = new conexion();
        Connection cn;
        Statement st;
        ResultSet rs;

        // DATOS A AGREGAR
        int id_estud = 1;
        int id_asign = 3;
        double nota1 = 3.2;
        double nota2 = 3.2;
        double nota3 = 3.2;
        double nota4 = 3.2;
        double nota5 = 3.2;
        double nota_parc = (nota1+nota2+nota3+nota4+nota5)/5;
        double coev = 3.2;
        double autoev = 3.2;
        double nota_fin = (nota_parc*0.80)+(coev*0.10)+(autoev*0.10);

        // INSTRUCCION SQL
        String sql = "INSERT INTO estud_asign(id_estud, id_asign, nota1, nota2, nota3, nota4, nota5, nota_parc, coev, autoev, nota_fin) values('" + id_estud + "','" + id_asign + "','" + nota1 + "','" + nota2 + "','" + nota3 + "','" + nota4 + "','" + nota5 + "','" + nota_parc + "','" + coev + "','" + autoev + "','" + nota_fin + "')";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(agregar_estud_asign.class.getName()).log(Level.SEVERE, null, ex);
        }

        try {
            cn = con.getConection();
            st = cn.createStatement();
            st.executeUpdate(sql); // AGREGAR DATOS
            rs = st.executeQuery("SELECT * FROM estud_asign"); // TRAER DATOS DE LA TABLA ESTUD_ASIGN
            rs.next();

            // IMPRIMIR EN CONSOLA LOS DATOS DE LA TABLA ESTUD_ASIGN
            do {
                System.out.println(rs.getInt("id")+": "+rs.getInt("id_estud")+" - "+rs.getInt("id_asign")+" - "+rs.getFloat("nota1")+" - "+rs.getFloat("nota2")+" - "+rs.getFloat("nota3")+" - "+rs.getFloat("nota4")+" - "+rs.getFloat("nota5")+" - "+rs.getFloat("nota_parc")+" - "+rs.getFloat("coev")+" - "+rs.getFloat("autoev")+" - "+rs.getFloat("nota_fin"));
            } while (rs.next());

        } catch (SQLException ex) {
            Logger.getLogger(agregar_estud_asign.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
