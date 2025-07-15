/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Dao.UsuarioDAO;
import Modelo.Usuario;
import Modelo.Validaciones;
import Vista.UsuarioAdmin;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author pc
 */
public class ControladorVistaUsuarioAdminConsultar implements ActionListener {

    UsuarioAdmin vis;
    UsuarioDAO mod1;
    Usuario mod;

    public ControladorVistaUsuarioAdminConsultar() {
        vis = UsuarioAdmin.getInstancia();
        vis.setVisible(true);
        vis.getBotonConsulta().addActionListener(this);
    }

    public DefaultTableModel convertirATableModel(List<Usuario> lista, String campo, String operador, String criterio) {
        String[] columnas = {"Cedula", "Nombre", "Correo", "Contraseña"};
        DefaultTableModel modelo = new DefaultTableModel(columnas, 0);
        for (int i = 0; i < lista.size(); i++) {
            switch (campo) {
                case "CC": {
                    if (operador.equals("Contenga")) {
                        if (Validaciones.contieneaTexto(lista.get(i).getId_cc(), criterio)) {
                            Object listaTemp[] = new Object[4];
                            listaTemp[0] = lista.get(i).getId_cc();
                            listaTemp[1] = lista.get(i).getNombre();
                            listaTemp[2] = lista.get(i).getCorreo();
                            listaTemp[3] = lista.get(i).getContraseña();
                            modelo.addRow(listaTemp);
                        }
                    }

                    if (operador.equals("Igual")) {
                        if (lista.get(i).getId_cc().equals(criterio)) {
                            Object listaTemp[] = new Object[4];
                            listaTemp[0] = lista.get(i).getId_cc();
                            listaTemp[1] = lista.get(i).getNombre();
                            listaTemp[2] = lista.get(i).getCorreo();
                            listaTemp[3] = lista.get(i).getContraseña();
                            modelo.addRow(listaTemp);
                        }
                    }

                    break;
                }
                case "Contraseña": {
                    if (operador.equals("Contenga")) {
                        if (Validaciones.contieneaTexto(lista.get(i).getContraseña(), criterio)) {
                            Object listaTemp[] = new Object[4];
                            listaTemp[0] = lista.get(i).getId_cc();
                            listaTemp[1] = lista.get(i).getNombre();
                            listaTemp[2] = lista.get(i).getCorreo();
                            listaTemp[3] = lista.get(i).getContraseña();
                            modelo.addRow(listaTemp);
                        }
                    }

                    if (operador.equals("Igual")) {
                        if (lista.get(i).getContraseña().equals(criterio)) {
                            Object listaTemp[] = new Object[4];
                            listaTemp[0] = lista.get(i).getId_cc();
                            listaTemp[1] = lista.get(i).getNombre();
                            listaTemp[2] = lista.get(i).getCorreo();
                            listaTemp[3] = lista.get(i).getContraseña();
                            modelo.addRow(listaTemp);
                        }
                    }
                    break;
                }
                case "Correo": {
                    if (operador.equals("Contenga")) {
                        if (Validaciones.contieneaTexto(lista.get(i).getCorreo(), criterio)) {
                            Object listaTemp[] = new Object[4];
                            listaTemp[0] = lista.get(i).getId_cc();
                            listaTemp[1] = lista.get(i).getNombre();
                            listaTemp[2] = lista.get(i).getCorreo();
                            listaTemp[3] = lista.get(i).getContraseña();
                            modelo.addRow(listaTemp);
                        }
                    }

                    if (operador.equals("Igual")) {
                        if (lista.get(i).getCorreo().equals(criterio)) {
                            Object listaTemp[] = new Object[4];
                            listaTemp[0] = lista.get(i).getId_cc();
                            listaTemp[1] = lista.get(i).getNombre();
                            listaTemp[2] = lista.get(i).getCorreo();
                            listaTemp[3] = lista.get(i).getContraseña();
                            modelo.addRow(listaTemp);
                        }
                    }
                    break;
                }
                case "Nombre": {
                    if (operador.equals("Contenga")) {
                        if (Validaciones.contieneaTexto(lista.get(i).getNombre(), criterio)) {
                            Object listaTemp[] = new Object[4];
                            listaTemp[0] = lista.get(i).getId_cc();
                            listaTemp[1] = lista.get(i).getNombre();
                            listaTemp[2] = lista.get(i).getCorreo();
                            listaTemp[3] = lista.get(i).getContraseña();
                            modelo.addRow(listaTemp);
                        }
                    }
                    
                    if (operador.equals("Igual")) {
                        if (lista.get(i).getNombre().equals(criterio)) {
                            Object listaTemp[] = new Object[4];
                            listaTemp[0] = lista.get(i).getId_cc();
                            listaTemp[1] = lista.get(i).getNombre();
                            listaTemp[2] = lista.get(i).getCorreo();
                            listaTemp[3] = lista.get(i).getContraseña();
                            modelo.addRow(listaTemp);
                        }
                    }
                    break;
                }

            }

        }

        return modelo;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == vis.getBotonConsulta()) {
            String campo = vis.getComboxCampoConsulta().getSelectedItem().toString();
            String operador = vis.getComboxOperadorConsulta().getSelectedItem().toString();
            String criterio = vis.getTxtCriterioConsulta().getText();
            mod1 = new UsuarioDAO();
            DefaultTableModel modelo = this.convertirATableModel(mod1.listarUsuarios(), campo, operador, criterio);
            vis.getTablaConsulta().setModel(modelo);
        }

    }

}
