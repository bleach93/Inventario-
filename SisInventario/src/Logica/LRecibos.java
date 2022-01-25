/*
 Clase lógica de recibos
 */
package Logica;

import Datos.DRecibos;
import Principal.Recibos;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Types;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Eduardo
 */
public class LRecibos {
    // Llamada a la de base de datos.
    Connection cn = LConexion.getConnection();
    // Método para insertar recibos
    public int insertarRecibos(DRecibos misRecibos) {
        int idres = 0;
        Recibos misRecibo = new Recibos();
        try {
            CallableStatement cst = cn.prepareCall("{ call sp_insertar_recibos(?,?,?,?) }");
            cst.setDate(1, misRecibos.getFechaRecibo());
            cst.setString(2, misRecibos.getPersonaEntrega());
            cst.setString(3, misRecibos.getPersonaRecibe());
            cst.registerOutParameter(4, Types.INTEGER);
            cst.executeUpdate();
            idres = cst.getInt(4);
        } catch (Exception ex) {
            ex.printStackTrace();
            idres = 0;
        }
        return idres;
    }
    // Método para mostrar recibos.
    public DefaultTableModel mostrarRecibos(DRecibos miId) {
        DefaultTableModel miModelo = null;
        try {
            String titulos[] = {"CODIGO", "FECHA", "PERSONA ENTREGA", "PERSONA RECIBE"};
            String dts[] = new String[4];
            miModelo = new DefaultTableModel(null, titulos);
            CallableStatement cst = cn.prepareCall("{call sp_mostrar_recibos()}");
            ResultSet rs = cst.executeQuery();
            while (rs.next()) {
                dts[0] = rs.getString("idRecibos");
                dts[1] = rs.getString("FechaSalida");
                dts[2] = rs.getString("PersonaEntrega");
                dts[3] = rs.getString("PersonaRecibe");
                miModelo.addRow(dts);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return miModelo;
    }

    public DefaultTableModel buscarRecibos(DRecibos miId) {
        DefaultTableModel miModelo = null;
        try {
            String titulos[] = {"CODIGO", "FECHA", "PERSONA ENTREGA", "PERSONA RECIBE"};
            String dts[] = new String[4];
            miModelo = new DefaultTableModel(null, titulos);
            CallableStatement cst = cn.prepareCall("{call sp_buscar_recibos(?)}");
            cst.setInt(1, miId.getIdRecibo());
            ResultSet rs = cst.executeQuery();
            while (rs.next()) {
                dts[0] = rs.getString("idRecibos");
                dts[1] = rs.getString("FechaSalida");
                dts[2] = rs.getString("PersonaEntrega");
                dts[3] = rs.getString("PersonaRecibe");
                miModelo.addRow(dts);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return miModelo;
    }
}
