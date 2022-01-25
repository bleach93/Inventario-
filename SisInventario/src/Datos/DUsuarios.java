/*
 Clase de Datos de los usuarios
 En esta clase se obtiene los Id de los usuarios, nombre, el usuario, la clave y el perfil.
 */
package Datos;

/**
 *
 * @author Eduardo
 */
public class DUsuarios {

    int idUsuario;
    String nombre;
    String usuario;
    String clave;
    String perfil;

    // Método vacío

    public DUsuarios() {

    }

    // Método para obtener los datos: Id de los usuarios, nombre, el usuario, la clave y el perfil.

    public DUsuarios(int idUsuario, String nombre, String usuario, String clave, String perfil) {
        this.idUsuario = idUsuario;
        this.nombre = nombre;
        this.usuario = usuario;
        this.clave = clave;
        this.perfil = perfil;
    }

    // Métodos setter-getter

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public String getPerfil() {
        return perfil;
    }

    public void setPerfil(String perfil) {
        this.perfil = perfil;
    }

}
