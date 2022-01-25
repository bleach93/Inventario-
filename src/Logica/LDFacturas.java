/*
    Clase lógica de detalle de facturas
 */
package Logica;

import Datos.DDFacturas;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Eduardo
 */
public class LDFacturas {
    //Llamada a la de base de datos.
    Connection cn = LConexion.getConnection();
    
    // Método para registrar los detalles de las facturas.

    public String registrarDetalleFactura(DDFacturas miDetalle) {
        String msg = null;
        try {
            CallableStatement cst = cn.prepareCall("{ call sp_insertar_detallefacturas (?,?,?,?) }");
            cst.setInt(1, miDetalle.getFacturasId());
            cst.setString(2, miDetalle.getProductosId());
            cst.setInt(3, miDetalle.getCantidad());
            cst.setDouble(4, miDetalle.getTotal());
            cst.executeUpdate();
            msg = "si";

        } catch (Exception ex) {
            ex.printStackTrace();
            msg = "no";
        }
        return msg;
    }

    // método para mostrar facturas.

    public DefaultTableModel mostrarFacturas(DDFacturas miDetalle) {
        DefaultTableModel miModelo = null;
        try {
            String titulos[] = {"CODIGO", "DESCRIPCION", "STOCK", "UMEDIDA", "PUNITARIO", "TOTAL"};
            String dts[] = new String[6];
            miModelo = new DefaultTableModel(null, titulos);
            CallableStatement cst = cn.prepareCall("{ call sp_mostrardetalleFacturas(?) }");
            cst.setInt(1, miDetalle.getFacturasId());
            ResultSet rs = cst.executeQuery();
            while (rs.next()) {
                dts[0] = rs.getString("d.Materialesid");
                dts[1] = rs.getString("p.descripcion");
                dts[2] = rs.getString("d.cantidad");
                dts[3] = rs.getString("p.umedida");
                dts[4] = rs.getString("p.punitario");
                dts[5] = rs.getString("d.total");
                miModelo.addRow(dts);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return miModelo;
    }
}

