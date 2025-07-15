/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author pc
 */
public class ArticuloTransaccion {

    private String idTransaccion;
    private String idObjeto;

    public ArticuloTransaccion() {
    }

    public ArticuloTransaccion(String idTransaccion, String idObjeto) {
        this.idTransaccion = idTransaccion;
        this.idObjeto = idObjeto;
    }

    public String getIdTransaccion() {
        return idTransaccion;
    }

    public void setIdTransaccion(String idTransaccion) {
        this.idTransaccion = idTransaccion;
    }

    public String getIdObjeto() {
        return idObjeto;
    }

    public void setIdObjeto(String idObjeto) {
        this.idObjeto = idObjeto;
    }
    
}
