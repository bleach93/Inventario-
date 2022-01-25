/*
 Clase lógica de usuarios.
 */
package Logica;

import Datos.DUsuarios;
import java.sql.Connection;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Eduardo
 */
public class LUsuarios {

    //Llamada a la de base de datos.

    Connection cn = LConexion.getConnection();

    // Método mostrar Usuarios

    public DefaultTableModel mostrarUsuarios(DUsuarios misUsuarios) {
        DefaultTableModel miModelo = null;
        try {
            String titulos[] = {"id", "nombre", "usuario", "clave", "perfil"};
            String dts[] = new String[5];
            miModelo = new DefaultTableModel(null, titulos);
            CallableStatement cst = cn.prepareCall("{ call sp_s_usuarios(?) }");
            cst.setString(1, misUsuarios.getUsuario());
            ResultSet rs = cst.executeQuery();
            while (rs.next()) {
                dts[0] = rs.getString("idUsuarios");
                dts[1] = rs.getString("nombre");
                dts[2] = rs.getString("usuario");
                dts[3] = rs.getString("clave");
                dts[4] = rs.getString("perfil");
                miModelo.addRow(dts);
            }
        } catch (Exception ex) {

        }
        return miModelo;
    }

    // Método insertar usuarios

    public String insertarUsuarios(DUsuarios misUsuarios) {
        String msg = null;
        try {
            CallableStatement cst = cn.prepareCall("{ call sp_insertar_usuarios(?,?,?,?) }");
            cst.setString(1, misUsuarios.getNombre());
            cst.setString(2, misUsuarios.getUsuario());
            cst.setString(3, misUsuarios.getClave());
            cst.setString(4, misUsuarios.getPerfil());

            cst.executeUpdate();

            msg = ("si");
        } catch (Exception ex) {
            ex.printStackTrace();
            msg = "no";
        }
        return msg;
    }

    // Método editar usuarios

    public String editarUsuarios(DUsuarios misUsuarios) {
        String msg = null;
        try {
            CallableStatement cst = cn.prepareCall("{ call sp_editar_usuarios(?,?,?,?,?) }");
            cst.setInt(1, misUsuarios.getIdUsuario());
            cst.setString(2, misUsuarios.getNombre());
            cst.setString(3, misUsuarios.getUsuario());
            cst.setString(4, misUsuarios.getClave());
            cst.setString(5, misUsuarios.getPerfil());

            cst.executeUpdate();

            msg = ("si");
        } catch (Exception ex) {
            ex.printStackTrace();
            msg = "no";
        }
        return msg;
    }

    // Método eliminar usuarios

    public String eliminarUsuarios(DUsuarios misUsuarios) {
        String msg = null;
        try {
            CallableStatement cst = cn.prepareCall("{ call sp_eliminar_usuarios(?) }");
            cst.setInt(1, misUsuarios.getIdUsuario());
            cst.executeUpdate();
            msg = "Se elimino de forma correcta";

            msg = ("si");
        } catch (Exception ex) {
            ex.printStackTrace();
            msg = "no";
        }
        return msg;
    }

    // Método para validar el login

    public String ValidarLogin(DUsuarios misUsuarios) {
        String perfil = "";
        try {
            CallableStatement cst = cn.prepareCall("{ call sp_validar_usuario(?,?) }");
            cst.setString(1, misUsuarios.getUsuario());
            cst.setString(2, misUsuarios.getClave());
            ResultSet rs = cst.executeQuery();
            if (rs.first()) {
                perfil = rs.getString("Perfil");
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return perfil;
    }

}
