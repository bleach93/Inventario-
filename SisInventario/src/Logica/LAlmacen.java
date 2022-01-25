/*
    Clase lógica de almacén 
 */
package Logica;

import Datos.DAlmacen;
import Principal.Facturas;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Types;
import java.lang.String;
import java.sql.ResultSet;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Eduardo
 */
public class LAlmacen {
    //Llamada a la de base de datos.
    Connection cn = LConexion.getConnection();

    // Método para mostrar almacén

    public DefaultTableModel mostrarAlmacen(DAlmacen misProductos) {
        DefaultTableModel miModelo = null;
        try {
            String titulos[] = {"ID", "DESCRIPCION", "STOCK", "U/MEDIDA", "P/UNITARIO", "TOTAL", "DEPARTAMENTO"};
            String dts[] = new String[7];
            miModelo = new DefaultTableModel(null, titulos);
            CallableStatement cst = cn.prepareCall("{ call sp_mostrar_almacen(?) }");
            cst.setString(1, misProductos.getIdAlmacen());
            ResultSet rs = cst.executeQuery();
            while (rs.next()) {
                dts[0] = rs.getString("a.IdAlmacen");
                dts[1] = rs.getString("a.descripcion");
                dts[2] = rs.getString("a.stock");
                dts[3] = rs.getString("a.umedida");
                dts[4] = rs.getString("a.punitario");
                dts[5] = rs.getString("Total");
                dts[6] = rs.getString("l.nombre");
                miModelo.addRow(dts);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return miModelo;
    }

    // mètodo para mostrar almacén
    public String[] mostrarbuscarAlmacenRec(DAlmacen misProductos) {
        String dts[] = null;
        try {
            dts = new String[7];
            CallableStatement cst = cn.prepareCall("{ call sp_mostrarbuscar_productosrecibos(?) }");
            cst.setString(1, misProductos.getIdAlmacen());
            cst.executeUpdate();
            ResultSet rs = cst.executeQuery();
            while (rs.next()) {
                dts[0] = rs.getString("a.idAlmacen");
                dts[1] = rs.getString("a.descripcion");
                dts[2] = "1";
                dts[3] = rs.getString("a.punitario");
                dts[4] = rs.getString("a.umedida");
                dts[5] = rs.getString("1.nombre");
                dts[6] = rs.getString("a.punitario");

            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return dts;
    }

    // mètodo insertar productos

    public String insertarProductos(DAlmacen misProductos) {
        String msg = null;
        try {
            CallableStatement cst = cn.prepareCall("{ call sp_insertar_productos (?,?,?,?,?,?) }");
            cst.setString(1, misProductos.getIdAlmacen());
            cst.setInt(2, misProductos.getDepartamentoid());
            cst.setString(3, misProductos.getDescripcion());
            cst.setInt(4, misProductos.getStock());
            cst.setDouble(5, misProductos.getPunitario());
            cst.setString(6, misProductos.getUmedida());
            cst.executeUpdate();

            msg = ("si");
        } catch (Exception ex) {
            ex.printStackTrace();
            msg = "no";
        }
        return msg;
    }

    // método mostrar buscar

    public String[] mostrarbuscarAlmacen(DAlmacen misProductos) {
        String dts[] = null;
        try {
            dts = new String[6];
            CallableStatement cst = cn.prepareCall("{ call sp_mostrarbuscar_productos(?) }");
            cst.setString(1, misProductos.getIdAlmacen());
            cst.executeUpdate();
            ResultSet rs = cst.executeQuery();
            while (rs.next()) {
                dts[0] = rs.getString("IdAlmacen");
                dts[1] = rs.getString("Descripcion");
                dts[2] = "1";
                dts[3] = rs.getString("Umedida");
                dts[4] = rs.getString("PUnitario");
                dts[5] = rs.getString("PUnitario");
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return dts;
    }

    // método disminuir stock

    public String disminuirStock(DAlmacen misProductos) {
        String msg = null;
        try {
            CallableStatement cst = cn.prepareCall("{ call sp_disminuir_stock(?,?) }");
            cst.setString(1, misProductos.getIdAlmacen());
            cst.setInt(2, misProductos.getStock());
            cst.executeUpdate();

            msg = ("Se registró de forma correcta");
        } catch (Exception ex) {
            ex.printStackTrace();
            msg = "no";
        }
        return msg;
    }

}
