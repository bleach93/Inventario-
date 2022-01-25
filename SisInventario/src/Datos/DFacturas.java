/*
 Clase de Datos de las Facturas
 En esta clase se obtiene el Id del departamento, el id de los proveedores y la fecha.
 */
package Datos;

import java.sql.Date;

/**
 *
 * @author Eduardo
 */
public class DFacturas {

    int idDepartamento;
    int idProveedores;
    Date fecha;

    // Método vacío

    public DFacturas() {

    }

    // Método para obtener los datos: el Id del departamento, el id de los proveedores y la fecha.

    public DFacturas(int idDepartamento, int idProveedores, Date fecha) {
        this.idDepartamento = idDepartamento;
        this.idProveedores = idProveedores;
        this.fecha = fecha;
    }

    // Métodos setter-getter

    public int getIdDepartamento() {
        return idDepartamento;
    }

    public void setIdDepartamento(int idDepartamento) {
        this.idDepartamento = idDepartamento;
    }

    public int getIdProveedores() {
        return idProveedores;
    }

    public void setIdProveedores(int idProveedores) {
        this.idProveedores = idProveedores;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

}
