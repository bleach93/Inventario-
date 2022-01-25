/*
 Clase de Datos de los Proveedores
 En esta clase se obtiene el Id del proveedor, el nombre, el telefono y el domicilio.
 */
package Datos;

/**
 *
 * @author Eduardo
 */
public class DProveedores {

    int Id;
    String Nombre;
    String telefono;
    String domicilio;

    // Método vacío

    public DProveedores() {

    }

    // Método para obtener los datos: el Id del proveedor, el nombre, el telefono y el domicilio.

    public DProveedores(int Id, String Nombre, String telefono, String domicilio) {
        this.Id = Id;
        this.Nombre = Nombre;
        this.telefono = telefono;
        this.domicilio = domicilio;
    }

    // Métodos setter-getter

    public int getId() {
        return Id;
    }

    public void setId(int Id) {
        this.Id = Id;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getDomicilio() {
        return domicilio;
    }

    public void setDomicilio(String domicilio) {
        this.domicilio = domicilio;
    }

}
