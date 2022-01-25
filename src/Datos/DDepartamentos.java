/*
 Clase de Datos de los Departamentos
 En esta clase se obtiene el Id del departamento y el nombre
 */
package Datos;

/**
 *
 * @author Eduardo
 */
public class DDepartamentos {

    int Id;
    String nombre;

    // Método vacío

    public DDepartamentos() {

    }

    // Método para obtener los datos: el Id de departamento y el nombre

    public DDepartamentos(int Id, String nombre) {
        this.Id = Id;
        this.nombre = nombre;
    }

    // Métodos setter-getter

    public int getId() {
        return Id;
    }

    public void setId(int Id) {
        this.Id = Id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

}
