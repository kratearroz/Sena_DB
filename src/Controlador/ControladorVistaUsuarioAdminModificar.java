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
import javax.swing.JOptionPane;

/**
 *
 * @author pc
 */
public class ControladorVistaUsuarioAdminModificar implements ActionListener{
    UsuarioAdmin vis;
    UsuarioDAO mod1;
    Usuario mod;

    public ControladorVistaUsuarioAdminModificar() {
        vis=UsuarioAdmin.getInstancia();
        vis.setVisible(true);
        vis.getBotonBuscarMod().addActionListener(this);
        vis.getBotonModificar().addActionListener(this);
        vis.getBotonEliminar().addActionListener(this);
    }
    public Usuario buscarUserCC(List<Usuario> usuarios,String criterio){
        Usuario user=new Usuario();
        for(int i=0;i<usuarios.size();i++){
            if(usuarios.get(i).getId_cc().equals(criterio)){
                user=usuarios.get(i);
                return user;
            }
        }
        return user;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==vis.getBotonBuscarMod()){
            String cc=vis.getTxtCCModificar().getText();
            mod1=new UsuarioDAO();
            List<Usuario> usuarios=mod1.listarUsuarios();
            Usuario user=this.buscarUserCC(usuarios, cc);
            vis.getTxtNombreModificar().setText(user.getNombre());
            vis.getTxtCorreoModificar().setText(user.getCorreo());
            vis.getTxtContraseñaModificar().setText(user.getContraseña());
        }
        if(e.getSource()==vis.getBotonModificar()){
            boolean bandera=false;
            String texto="";
            String cc=vis.getTxtCCModificar().getText();
            String nombre=vis.getTxtNombreModificar().getText();
            String correo=vis.getTxtCorreoModificar().getText();
            if (!Validaciones.soloCorreo(correo)) {
                bandera = true;
                texto += " Error: Correo no es valido ";
            }
            String contraseña=vis.getTxtContraseñaModificar().getText();
            if(bandera==false){
                Usuario user=new Usuario(cc,contraseña,correo,nombre);
                mod1=new UsuarioDAO();
                mod1.actualizarUsuario(user);
            }
            else{
                JOptionPane.showMessageDialog(null, texto,"Erro",0);
            }
        }
        if(e.getSource()==vis.getBotonEliminar()){
            mod1=new UsuarioDAO();
            String cc=vis.getTxtCCModificar().getText();
            mod1.eliminarUsuario(cc);
        }
    }
    
    
}
