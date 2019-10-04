/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Views.Administrador;

import Acceso_Datos.ConectionDB;
import Acceso_Datos.SeccionJpaController;
import Acceso_Datos.entityMain;
import Logica_Negocios.Seccion;
import java.beans.PropertyVetoException;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Jorge Villanueva
 */
public class Crear_Seccion extends javax.swing.JInternalFrame {

    /**
     * Creates new form Agregar_Alumno
     */
    public Crear_Seccion() {
        
        initComponents();
       
        
           // this.setMaximum(true);
        

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblUsuario = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        Btn_Guardar = new javax.swing.JButton();

        setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        setClosable(true);
        setIconifiable(true);
        setTitle("Registrar Sección");
        setToolTipText("Registrar Sección");
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setMaximumSize(new java.awt.Dimension(343, 146));
        setMinimumSize(new java.awt.Dimension(343, 146));
        setPreferredSize(new java.awt.Dimension(343, 146));
        try {
            setSelected(true);
        } catch (java.beans.PropertyVetoException e1) {
            e1.printStackTrace();
        }
        setVisible(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblUsuario.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        lblUsuario.setText("Sección:");
        getContentPane().add(lblUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, -1, 30));

        txtNombre.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        getContentPane().add(txtNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 10, 120, 30));

        Btn_Guardar.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        Btn_Guardar.setText("Registrar");
        Btn_Guardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn_GuardarActionPerformed(evt);
            }
        });
        getContentPane().add(Btn_Guardar, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 60, 110, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void Btn_GuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_GuardarActionPerformed
        // TODO add your handling code here:
        ConectionDB con = new ConectionDB();
        SeccionJpaController sjc = new SeccionJpaController(entityMain.getInstance());
        Seccion seccion = new Seccion(con.GetIdToInsert("SECCION","ID_SECCION"), txtNombre.getText(), BigInteger.ONE);
        
        try {
            sjc.create(seccion);
            JOptionPane.showMessageDialog(rootPane, "Registrada con exito.");
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(rootPane, "Algo salio mal.");
        }
    }//GEN-LAST:event_Btn_GuardarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Btn_Guardar;
    private javax.swing.JLabel lblUsuario;
    private javax.swing.JTextField txtNombre;
    // End of variables declaration//GEN-END:variables
}
