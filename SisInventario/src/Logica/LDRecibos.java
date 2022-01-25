/*
    Clase lógica de los detalles de recibos
 */
package Logica;

import Datos.DDRecibos;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Eduardo
 */
public class LDRecibos {
    //Llamada a la de base de datos.
    Connection cn = LConexion.getConnection();

    // Método para registrar un detalle en los recibos

    public String registrarDetalleRecibos(DDRecibos miRecibo) {
        String msg = null;
        try {
            CallableStatement cst = cn.prepareCall("{ call sp_insertar_detallerecibo (?,?,?,?,?) }");
            cst.setInt(1, miRecibo.getRecibosId());
            cst.setString(2, miRecibo.getMaterialesid());
            cst.setInt(3, miRecibo.getDepartamentoid());
            cst.setInt(4, miRecibo.getCantidad());
            cst.setDouble(5, miRecibo.getTotal());
            
            cst.executeUpdate();
            msg = "si";

        } catch (Exception ex) {
            ex.printStackTrace();
            msg = "no";
        }
        return msg;
    }

    // Método para mostrar los detalles de los recibos

    public DefaultTableModel mostrarDetalleRecibos(DDRecibos miDetalle) {
        DefaultTableModel miModelo = null;
        try {
            String titulos[] = {"CODIGO", "DESCRIPCION", "CANTIDAD", "UMEDIDA", "PUNITARIO", "LINEA", "TOTAL"};
            String dts[] = new String[7];
            miModelo = new DefaultTableModel(null, titulos);
            CallableStatement cst = cn.prepareCall("{call sp_mostrardetallerecibos(?)}");
            cst.setInt(1, miDetalle.getRecibosId());

            ResultSet rs = cst.executeQuery();
            while (rs.next()) {
                dts[0] = rs.getString("d.Materialesid");
                dts[1] = rs.getString("p.descripcion");
                dts[2] = rs.getString("d.cantidad");
                dts[3] = rs.getString("p.umedida");
                dts[4] = rs.getString("p.punitario");
                dts[5] = rs.getString("l.Nombre");
                dts[6] = rs.getString("d.Total");
                miModelo.addRow(dts);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return miModelo;
    }
}
