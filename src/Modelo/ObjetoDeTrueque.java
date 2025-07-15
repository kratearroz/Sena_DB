/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

public class ObjetoDeTrueque {
    private String idObjeto;
    private String nombre;
    private String descripcion;
    private int valorEstimado;
    private String idTransaccion;

    public ObjetoDeTrueque() {}

    public ObjetoDeTrueque(String idObjeto, String nombre, String descripcion, int valorEstimado, String idTransaccion) {
        this.idObjeto = idObjeto;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.valorEstimado = valorEstimado;
        this.idTransaccion = idTransaccion;
    }

    // Getters y Setters
    public String getIdObjeto() { return idObjeto; }
    public void setIdObjeto(String idObjeto) { this.idObjeto = idObjeto; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getDescripcion() { return descripcion; }
    public void setDescripcion(String descripcion) { this.descripcion = descripcion; }

    public int getValorEstimado() { return valorEstimado; }
    public void setValorEstimado(int valorEstimado) { this.valorEstimado = valorEstimado; }

    public String getIdTransaccion() { return idTransaccion; }
    public void setIdTransaccion(String idTransaccion) { this.idTransaccion = idTransaccion; }
}

