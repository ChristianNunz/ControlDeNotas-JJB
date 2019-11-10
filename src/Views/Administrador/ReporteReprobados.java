/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Views.Administrador;

import Acceso_Datos.ConectionDB;
import Acceso_Datos.DocenteJpaController;
import Acceso_Datos.GradoJpaController;
import Acceso_Datos.MateriaGradoJpaController;
import Acceso_Datos.MateriaJpaController;
import Acceso_Datos.SeccionJpaController;
import Acceso_Datos.TurnoJpaController;
import Acceso_Datos.entityMain;
import Logica_Negocios.Docente;
import Logica_Negocios.Grado;
import Logica_Negocios.Materia;
import Logica_Negocios.MateriaGrado;
import Logica_Negocios.Seccion;
import Logica_Negocios.Turno;
import Reportes.GenerarReportes;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Jorge Villanueva
 */
public class ReporteReprobados extends javax.swing.JInternalFrame {

    MateriaGradoJpaController materiaGradoJpaController = new MateriaGradoJpaController(entityMain.getInstance());
    MateriaJpaController materiaJpaController = new MateriaJpaController(entityMain.getInstance());
    GradoJpaController gjc = new GradoJpaController(entityMain.getInstance());
    SeccionJpaController sjc = new SeccionJpaController(entityMain.getInstance());
    TurnoJpaController tjc = new TurnoJpaController(entityMain.getInstance());
    DocenteJpaController djc = new DocenteJpaController(entityMain.getInstance());
    MateriaJpaController mjc = new MateriaJpaController(entityMain.getInstance());

     ConectionDB con = new ConectionDB(); 
 
    
    public ReporteReprobados() {
        
        
        initComponents();
        
        LLenarComboM(); 
        LLenarComboS(); 
        LLenarComboG(); 
        LLenarComboD();
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        GenerarReporte = new javax.swing.JButton();
        cmb_grado = new javax.swing.JComboBox();
        lblUsuario2 = new javax.swing.JLabel();
        cmb_secc = new javax.swing.JComboBox();
        lblUsuario3 = new javax.swing.JLabel();
        cmb_docente = new javax.swing.JComboBox();
        lblUsuario6 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        cmb_mat1 = new javax.swing.JComboBox();
        lblUsuario7 = new javax.swing.JLabel();
        cmb_periodo = new javax.swing.JComboBox();
        lblUsuario8 = new javax.swing.JLabel();

        setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        setClosable(true);
        setIconifiable(true);
        setResizable(true);
        setTitle("Registrar Materia");
        setToolTipText("Registrar Materia");
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setMinimumSize(new java.awt.Dimension(300, 300));
        setName(""); // NOI18N
        setPreferredSize(new java.awt.Dimension(300, 300));
        setRequestFocusEnabled(false);
        try {
            setSelected(true);
        } catch (java.beans.PropertyVetoException e1) {
            e1.printStackTrace();
        }
        setVisible(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        GenerarReporte.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        GenerarReporte.setText("Generar Reporte ");
        GenerarReporte.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                GenerarReporteActionPerformed(evt);
            }
        });
        getContentPane().add(GenerarReporte, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 230, 180, -1));

        getContentPane().add(cmb_grado, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 130, 180, -1));

        lblUsuario2.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        lblUsuario2.setText("Grado:");
        getContentPane().add(lblUsuario2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 130, -1, 20));

        getContentPane().add(cmb_secc, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 170, 180, -1));

        lblUsuario3.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        lblUsuario3.setText("Seccion:");
        getContentPane().add(lblUsuario3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 170, -1, 20));

        getContentPane().add(cmb_docente, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 200, 180, -1));

        lblUsuario6.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        lblUsuario6.setText("Docente:");
        getContentPane().add(lblUsuario6, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 200, -1, 20));

        jLabel1.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel1.setText("REPORTE DE REPROBADOS  ");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 20, 270, 30));

        getContentPane().add(cmb_mat1, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 100, 180, -1));

        lblUsuario7.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        lblUsuario7.setText("Materia:");
        getContentPane().add(lblUsuario7, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 100, -1, 20));

        cmb_periodo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "1", "2", "3" }));
        getContentPane().add(cmb_periodo, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 70, 180, -1));

        lblUsuario8.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        lblUsuario8.setText("Periodo:");
        getContentPane().add(lblUsuario8, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 70, -1, 20));

        getAccessibleContext().setAccessibleName("Reprobados");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void GenerarReporteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_GenerarReporteActionPerformed
        GenerarReportes gr = new GenerarReportes();
        String Nombremat = cmb_mat1.getSelectedItem().toString();
        String Nombred = cmb_docente.getSelectedItem().toString();
        String per = cmb_periodo.getSelectedItem().toString();
        String Nobresec= cmb_secc.getSelectedItem().toString();
        String Grado = cmb_grado.getSelectedItem().toString();
        gr.ReporteReprobados(Nobresec, per, Nombremat, Nombred, Grado);
    }//GEN-LAST:event_GenerarReporteActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton GenerarReporte;
    private javax.swing.JComboBox cmb_docente;
    private javax.swing.JComboBox cmb_grado;
    private javax.swing.JComboBox cmb_mat1;
    private javax.swing.JComboBox cmb_periodo;
    private javax.swing.JComboBox cmb_secc;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel lblUsuario2;
    private javax.swing.JLabel lblUsuario3;
    private javax.swing.JLabel lblUsuario6;
    private javax.swing.JLabel lblUsuario7;
    private javax.swing.JLabel lblUsuario8;
    // End of variables declaration//GEN-END:variables

    private void LLenarComboM() {
        List<Materia> Materias = materiaJpaController.findMateriaEntities();
        for (Materia Materia1 : Materias) {
            cmb_mat1.addItem(Materia1.getMateriaNombre());
        }
    }
    private void LLenarComboS() {
        List<Seccion> seccions = sjc.findSeccionEntities();
      
        for (Seccion seccion : seccions) {
            cmb_secc.addItem(seccion.getNombreSeccion());
        }
    }
    private void LLenarComboG() {
        List<Grado> grados = gjc.findGradoEntities();
        for (Grado grado : grados) {
            cmb_grado.addItem(grado.getGrado());
        }
    }
    
     private void LLenarComboD() {
        List<Docente> docentes = djc.findDocenteEntities();
        for (Docente docente : docentes) {
            if (docente.getDocenteEstado().equals("Activo")) {
              cmb_docente.addItem(docente.getDocenteNombre() +" " + docente.getDocenteApellido());   
            }            
        }
    }
}
