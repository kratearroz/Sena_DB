/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author pc
 */
public class Usuario {
    private String id_cc;
    private String contraseña;
    private String correo;
    private String nombre;

    public Usuario() {
    }

    public Usuario(String id_cc, String contraseña, String correo, String nombre) {
        this.id_cc = id_cc;
        this.contraseña = contraseña;
        this.correo = correo;
        this.nombre = nombre;
    }

    public String getId_cc() {
        return id_cc;
    }

    public void setId_cc(String id_cc) {
        this.id_cc = id_cc;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
}
