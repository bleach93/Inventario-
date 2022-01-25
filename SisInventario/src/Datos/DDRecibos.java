/*
 Clase de Datos de Detalle de Recibos
 En esta clase se obtiene el Id de detalle de recibos, Id de los recibos, id de los productos, 
 la cantidad, el total y el id del departamento. 
 */
package Datos;

/**
 *
 * @author Eduardo
 */
public class DDRecibos {

    int IdDetalleRecib;
    int RecibosId;
    String Materialesid;
    int Departamentoid;
    int Cantidad;
    double total;

    // Método vacío

    public DDRecibos() {
    }

    // Método para obtener los datos: el Id de detalle de recibos, Id de los recibos,, id de los productos, 
    // la cantidad, el total y el id del departamento. 

    public DDRecibos(int IdDetalleRecib, int RecibosId, String Materialesid, int Departamentoid, int Cantidad, double total) {
        this.IdDetalleRecib = IdDetalleRecib;
        this.RecibosId = RecibosId;
        this.Materialesid = Materialesid;
        this.Departamentoid = Departamentoid;
        this.Cantidad = Cantidad;
        this.total = total;
    }

    // Métodos setter-getter

    public int getIdDetalleRecib() {
        return IdDetalleRecib;
    }

    public void setIdDetalleRecib(int IdDetalleRecib) {
        this.IdDetalleRecib = IdDetalleRecib;
    }

    public int getRecibosId() {
        return RecibosId;
    }

    public void setRecibosId(int RecibosId) {
        this.RecibosId = RecibosId;
    }

    public String getMaterialesid() {
        return Materialesid;
    }

    public void setMaterialesid(String Materialesid) {
        this.Materialesid = Materialesid;
    }

    public int getDepartamentoid() {
        return Departamentoid;
    }

    public void setDepartamentoid(int Departamentoid) {
        this.Departamentoid = Departamentoid;
    }

    public int getCantidad() {
        return Cantidad;
    }

    public void setCantidad(int Cantidad) {
        this.Cantidad = Cantidad;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

}
