/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author pc
 */
public class Validaciones {

    public static boolean soloNumero(String dato) {
        for (int i = 0; i < dato.length(); i++) {
            if (!Character.isDigit(dato.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    public static boolean soloCorreo(String dato) {
        for (int i = 0; i < dato.length(); i++) {
            if (dato.charAt(i) == '@') {
                return true;
            }
        }
        return false;
    }

    public static boolean contieneaTexto(String texto, String contiene) {
        return texto.contains(contiene);
    }

    public static boolean IntMenor(String dato, String comparado) {
        int datoint = Integer.parseInt(dato);
        int datoComp = Integer.parseInt(comparado);
        if (datoint < datoComp) {
            return true;
        }
        return false;
    }

    public static boolean IntMayor(String dato, String comparado) {
        int datoint = Integer.parseInt(dato);
        int datoComp = Integer.parseInt(comparado);
        if (datoint > datoComp) {
            return true;
        }
        return false;
    }
}
