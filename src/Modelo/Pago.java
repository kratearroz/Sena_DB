/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author pc
 */
public class Pago {
    private String idPago;
    private int valor_pagado;

    public Pago(String idPago, int valor_pagado) {
        this.idPago = idPago;
        this.valor_pagado = valor_pagado;
    }

    public Pago() {
    }
    
    public String getIdPago() {
        return idPago;
    }

    public void setIdPago(String idPago) {
        this.idPago = idPago;
    }

    public int getValor_pagado() {
        return valor_pagado;
    }

    public void setValor_pagado(int valor_pagado) {
        this.valor_pagado = valor_pagado;
    }
    
}
