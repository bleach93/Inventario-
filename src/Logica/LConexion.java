/*
    Clase que se encarga de la comunicación entre la app y la base de datos.
 */
package Logica;

import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;

/**
 *
 * @author Eduardo
 */
public class LConexion {
    //Llamada a la de base de datos.
    static Connection con = null;

    // Método para llamar la conexión a la base de datos.

    public static Connection getConnection() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3308/inventario", "root", "");

        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return con;
    }
}
