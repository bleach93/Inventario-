/*
 Clase lógica de facturas
 */
package Logica;

import Datos.DFacturas;
import Principal.Facturas;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Eduardo
 */
public class LFacturas {

    //Llamada a la de base de datos.

    Connection cn = LConexion.getConnection();

    // Método para insertar facturas
    
    public int insertarFacturas(DFacturas misFacturas) {
        int idres = 0;
        Facturas miFactura = new Facturas();
        try {
            CallableStatement cst = cn.prepareCall("{ call sp_insertar_facturas(?,?,?,?) }");
            cst.setInt(1, misFacturas.getIdDepartamento());
            cst.setInt(2, misFacturas.getIdProveedores());
            cst.setDate(3, misFacturas.getFecha());
            cst.registerOutParameter(4, Types.INTEGER);
            cst.executeUpdate();
            idres = cst.getInt(4);

        } catch(SQLException e){
            e.printStackTrace();
        }
            catch (Exception ex) {
            ex.printStackTrace();
            idres = 0;
        }
        return idres;
    }

    // Método para mostrar facturas

    public DefaultTableModel mostrarFacturas() {
        DefaultTableModel miModelo = null;
        try {
            String titulos[] = {"CODIGO", "PROVEEDOR", "LINEA", "FECHA"};
            String dts[] = new String[4];
            miModelo = new DefaultTableModel(null, titulos);
            CallableStatement cst = cn.prepareCall("{ call sp_mostrar_facturas }");
            ResultSet rs = cst.executeQuery();
            while (rs.next()) {
                dts[0] = rs.getString("f.IdFacturas");
                dts[1] = rs.getString("p.nombre");
                dts[2] = rs.getString("l.nombre");
                dts[3] = rs.getString("f.fecha");
                miModelo.addRow(dts);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return miModelo;
    }

}
