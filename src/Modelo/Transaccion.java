/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;
import java.sql.Date;
/**
 *
 * @author pc
 */
public class Transaccion {
    private String id_transaccion;
    private String tipo_transaccion;
    private Date fecha;
    private String cc_ciudadania;
    private String id_pago;

    public Transaccion() {
    }

    public Transaccion(String id_transaccion, String tipo_transaccion, Date fecha, String cc_ciudadania, String id_pago) {
        this.id_transaccion = id_transaccion;
        this.tipo_transaccion = tipo_transaccion;
        this.fecha = fecha;
        this.cc_ciudadania = cc_ciudadania;
        this.id_pago = id_pago;
    }

    public String getId_transaccion() {
        return id_transaccion;
    }

    public void setId_transaccion(String id_transaccion) {
        this.id_transaccion = id_transaccion;
    }

    public String getTipo_transaccion() {
        return tipo_transaccion;
    }

    public void setTipo_transaccion(String tipo_transaccion) {
        this.tipo_transaccion = tipo_transaccion;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getCc_ciudadania() {
        return cc_ciudadania;
    }

    public void setCc_ciudadania(String cc_ciudadania) {
        this.cc_ciudadania = cc_ciudadania;
    }

    public String getId_pago() {
        return id_pago;
    }

    public void setId_pago(String id_pago) {
        this.id_pago = id_pago;
    }
    
    
}
