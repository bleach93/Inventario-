/*
 Clase de Datos de Almacen
 En esta clase se obtiene el Id del almacén, Id del Departamento, la descripción, El stock, el precio unitario y la unidad de medida
 */
package Datos;

/**
 *
 * @author Eduardo
 */
public class DAlmacen {

    String idAlmacen;
    int Departamentoid;
    String descripcion;
    int stock;
    double punitario;
    String umedida;

    // Método vacío

    public DAlmacen() {

    }

    // Método para obtener los datos: Id del almacén, Id del Departamento, la descripción, El stock, el precio unitario y la unidad de medida

    public DAlmacen(String idAlmacen, int Departamentoid, String descripcion, int stock, double punitario, String umedida) {
        this.idAlmacen = idAlmacen;
        this.Departamentoid = Departamentoid;
        this.descripcion = descripcion;
        this.stock = stock;
        this.punitario = punitario;
        this.umedida = umedida;
    }

    // Métodos setter-getter

    public String getIdAlmacen() {
        return idAlmacen;
    }

    public void setIdAlmacen(String idAlmacen) {
        this.idAlmacen = idAlmacen;
    }

    public int getDepartamentoid() {
        return Departamentoid;
    }

    public void setDepartamentoid(int Departamentoid) {
        this.Departamentoid = Departamentoid;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public double getPunitario() {
        return punitario;
    }

    public void setPunitario(double punitario) {
        this.punitario = punitario;
    }

    public String getUmedida() {
        return umedida;
    }

    public void setUmedida(String umedida) {
        this.umedida = umedida;
    }

}
