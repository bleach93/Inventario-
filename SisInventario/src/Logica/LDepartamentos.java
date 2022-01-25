/*
    Clase lógica de departamentos
 */
package Logica;

import Datos.DDepartamentos;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Eduardo
 */
public class LDepartamentos {
    //Llamada a la de base de datos.
    Connection cn = LConexion.getConnection();

    // Método para mostrar departamentos

    public DefaultTableModel mostrarDepartamentos(DDepartamentos misDepartamentos) {
        DefaultTableModel miModelo = null;
        try {
            String titulos[] = {"id", "nombre"};
            String dts[] = new String[5];
            miModelo = new DefaultTableModel(null, titulos);
            CallableStatement cst = cn.prepareCall("{ call sp_mostrarbuscar_departamentos(?) }");
            cst.setString(1, misDepartamentos.getNombre());
            ResultSet rs = cst.executeQuery();
            while (rs.next()) {
                dts[0] = rs.getString("idDepartamento");
                dts[1] = rs.getString("nombre");
                miModelo.addRow(dts);
            }
        } catch (Exception ex) {

        }
        return miModelo;
    }

    // Método para insertar departamentos

    public String insertarDepartamentos(DDepartamentos misDepartamentos) {
        String msg = null;
        try {
            CallableStatement cst = cn.prepareCall("{ call sp_insertar_departamentos(?) }");
            cst.setString(1, misDepartamentos.getNombre());

            cst.executeUpdate();

            msg = ("si");
        } catch (Exception ex) {
            ex.printStackTrace();
            msg = "no";
        }
        return msg;
    }

    //Método para editar departamentos

    public String editarDepartamentos(DDepartamentos misDepartamentos) {
        String msg = null;
        try {
            CallableStatement cst = cn.prepareCall("{ call sp_editar_departamentos(?,?) }");
            cst.setInt(1, misDepartamentos.getId());
            cst.setString(2, misDepartamentos.getNombre());

            cst.executeUpdate();

            msg = ("si");
        } catch (Exception ex) {
            ex.printStackTrace();
            msg = "no";
        }
        return msg;
    }

    // Método para eliminar departamentos

    public String eliminarDepartamentos(DDepartamentos misDepartamentos) {
        String msg = null;
        try {
            CallableStatement cst = cn.prepareCall("{ call sp_eliminar_departamentos(?) }");
            cst.setInt(1, misDepartamentos.getId());
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

