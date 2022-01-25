/*
    Clase lógica de principal
 */
package Logica;

import Principal.Login;
import java.sql.Connection;

/**
 *
 * @author Eduardo
 */
public class LPrincipal {

    public static void main(String[] args) {
        // Conexion con la base de datos
        Connection cn = LConexion.getConnection();
    }
}
