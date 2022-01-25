/*
 Clase de Datos de los recibos
 En esta clase se obtiene los Id de los recibos, la fecha de recibio, la persona que entrega y la persona que recibe.
 */
package Datos;

import java.sql.Date;

/**
 *
 * @author Eduardo
 */
public class DRecibos {

    int idRecibo;
    Date fechaRecibo;
    String personaEntrega;
    String personaRecibe;

    // Método vacío

    public DRecibos() {
    }

    // Método para obtener los datos: Id de los recibos, la fecha de recibio, la persona que entrega y la persona que recibe.

    public DRecibos(int idRecibo, Date fechaRecibo, String personaEntrega, String personaRecibe) {
        this.idRecibo = idRecibo;
        this.fechaRecibo = fechaRecibo;
        this.personaEntrega = personaEntrega;
        this.personaRecibe = personaRecibe;
    }

    // Métodos setter-getter

    public int getIdRecibo() {
        return idRecibo;
    }

    public void setIdRecibo(int idRecibo) {
        this.idRecibo = idRecibo;
    }

    public Date getFechaRecibo() {
        return fechaRecibo;
    }

    public void setFechaRecibo(Date fechaRecibo) {
        this.fechaRecibo = fechaRecibo;
    }

    public String getPersonaEntrega() {
        return personaEntrega;
    }

    public void setPersonaEntrega(String personaEntrega) {
        this.personaEntrega = personaEntrega;
    }

    public String getPersonaRecibe() {
        return personaRecibe;
    }

    public void setPersonaRecibe(String personaRecibe) {
        this.personaRecibe = personaRecibe;
    }

}
