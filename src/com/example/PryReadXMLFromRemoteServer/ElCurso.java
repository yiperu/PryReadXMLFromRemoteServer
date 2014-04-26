package com.example.PryReadXMLFromRemoteServer;

import java.io.Serializable;

/**
 * Created with IntelliJ IDEA.
 * User: Henry AT
 * Date: 26-04-14
 * Time: 02:29 PM
 * To change this template use File | Settings | File Templates.
 */
public class ElCurso implements Serializable {
    private String titulo;
    private String detalle;
    private String imagen;
    private String precio;

    public ElCurso(String titulo, String detalle, String imagen, String precio){
        this.titulo = titulo;
        this.detalle = detalle;
        this.imagen = imagen;
        this.precio = precio;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDetalle() {
        return detalle;
    }

    public void setDetalle(String detalle) {
        this.detalle = detalle;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public String getPrecio() {
        return precio;
    }

    public void setPrecio(String precio) {
        this.precio = precio;
    }
}
