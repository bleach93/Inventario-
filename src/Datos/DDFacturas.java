/*
 Clase de Datos de Detalle de Facturas
 En esta clase se obtiene el Id de detalle de factuas, Id de la factura, id de los productos, 
 la cantidad, el total y el id del departamento. 
 */
package Datos;

import Logica.LDFacturas;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Eduardo
 */
public class DDFacturas {

    int IdDetalleFacturas;
    int FacturasId;
    String ProductosId;
    int Cantidad;
    double Total;

    // Método vacío

    public DDFacturas() {
    }

    // Método para obtener los datos: el Id de detalle de factuas, Id de la factura, id de los productos, 
    // la cantidad, el total y el id del departamento. 
    
     public DDFacturas(int IdDetalleFacturas, int FacturasId, String ProductosId, int Cantidad, double Total) {
        this.IdDetalleFacturas = IdDetalleFacturas;
        this.FacturasId = FacturasId;
        this.ProductosId = ProductosId;
        this.Cantidad = Cantidad;
        this.Total = Total;
    }

    // Métodos setter-getter

    public int getIdDetalleFacturas() {
        return IdDetalleFacturas;
    }

    public void setIdDetalleFacturas(int IdDetalleFacturas) {
        this.IdDetalleFacturas = IdDetalleFacturas;
    }

    public int getFacturasId() {
        return FacturasId;
    }

    public void setFacturasId(int FacturasId) {
        this.FacturasId = FacturasId;
    }

    public String getProductosId() {
        return ProductosId;
    }

    public void setProductosId(String ProductosId) {
        this.ProductosId = ProductosId;
    }

    public int getCantidad() {
        return Cantidad;
    }

    public void setCantidad(int Cantidad) {
        this.Cantidad = Cantidad;
    }

    public double getTotal() {
        return Total;
    }

    public void setTotal(double Total) {
        this.Total = Total;
    }
}
