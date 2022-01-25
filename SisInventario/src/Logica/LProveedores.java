/*
    Clase lógica de proveedores
 */
package Logica;

import Datos.DProveedores;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Eduardo
 */
public class LProveedores {

    Connection cn = LConexion.getConnection();

    // Método para mostrar proveedores

    public DefaultTableModel mostrarProveedores(DProveedores misProveedores) {
        DefaultTableModel miModelo = null;
        try {
            String titulos[] = {"Id", "Nombre", "Telefono", "Domicilio"};
            String dts[] = new String[4];
            miModelo = new DefaultTableModel(null, titulos);
            CallableStatement cst = cn.prepareCall("{ call sp_mostrarbuscar_proveedores(?) }");
            cst.setString(1, misProveedores.getNombre());
            ResultSet rs = cst.executeQuery();
            while (rs.next()) {
                dts[0] = rs.getString("idProveedores");
                dts[1] = rs.getString("nombre");
                dts[2] = rs.getString("telefono");
                dts[3] = rs.getString("domicilio");
                miModelo.addRow(dts);
            }
        } catch (Exception ex) {

        }
        return miModelo;
    }

    // Método para insertar proveedores

    public String insertarProveedores(DProveedores misProveedores) {
        String msg = null;
        try {
            CallableStatement cst = cn.prepareCall("{ call sp_insert_proveedores(?,?,?) }");
            cst.setString(1, misProveedores.getNombre());
            cst.setString(2, misProveedores.getTelefono());
            cst.setString(3, misProveedores.getDomicilio());

            cst.executeUpdate();

            msg = ("si");
        } catch (Exception ex) {
            ex.printStackTrace();
            msg = "no";
        }
        return msg;
    }

    // Método para editar proveedores

    public String editarProveedores(DProveedores misProveedores) {
        String msg = null;
        try {
            CallableStatement cst = cn.prepareCall("{ call sp_editar_proveedores(?,?,?,?) }");
            cst.setInt(1, misProveedores.getId());
            cst.setString(2, misProveedores.getNombre());
            cst.setString(3, misProveedores.getTelefono());
            cst.setString(4, misProveedores.getDomicilio());
            cst.executeUpdate();

            msg = ("si");
        } catch (Exception ex) {
            ex.printStackTrace();
            msg = "no";
        }
        return msg;
    }

    // Método para eliminar proveedores

    public String eliminarProveedores(DProveedores misProveedores) {
        String msg = null;
        try {
            CallableStatement cst = cn.prepareCall("{ call sp_eliminar_proveedores(?) }");
            cst.setInt(1, misProveedores.getId());
            cst.executeUpdate();
            msg = "Se elimino de forma correcta";

            msg = ("si");
        } catch (Exception ex) {
            ex.printStackTrace();
            msg = "no";
        }
        return msg;
    }
}
