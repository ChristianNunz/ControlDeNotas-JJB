/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Views.Maestro;

import Acceso_Datos.AlumnoJpaController;
import Acceso_Datos.ConectionDB;
import Acceso_Datos.DocenteJpaController;
import Acceso_Datos.GradoJpaController;
import Acceso_Datos.MateriaJpaController;
import Acceso_Datos.SeccionJpaController;
import Acceso_Datos.entityMain;
import Logica_Negocios.Docente;
import Logica_Negocios.Materia;
import Reportes.GenerarReportes;
//import Reportes.GenerarReportes;
import java.math.BigDecimal;
import java.util.List;

/**
 *
 * @author Jorge Villanueva
 */
public class ReporteAlumnos extends javax.swing.JInternalFrame {

    /**
     * Creates new form Agregar_Alumno
     */
    String idLog;
    MateriaJpaController mjc = new MateriaJpaController(entityMain.getInstance());
    SeccionJpaController sjc = new SeccionJpaController(entityMain.getInstance());
    AlumnoJpaController ajc = new AlumnoJpaController(entityMain.getInstance());
    GradoJpaController gjc = new GradoJpaController(entityMain.getInstance());
    ConectionDB con;
    public ReporteAlumnos() {
        
        initComponents();
       con = new ConectionDB();
       
    }
  public void setIdlog(String id){
         try {            
         DocenteJpaController djc = new DocenteJpaController(entityMain.getInstance());
         String idDocente=djc.GetIdDocneteByLoginId(id,con.conn);
         this.idLog=idDocente;
         LlenarComboM();
         LlenarGrados();
         LlenarSecciones();
         Docente docente=djc.findDocente(new BigDecimal(idDocente));
         cmb_docente.addItem(docente.getDocenteNombre()+" "+docente.getDocenteApellido());
         } catch (Exception e) {
         }
    }
 
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        cmb_grado = new javax.swing.JComboBox();
        lblcontra5 = new javax.swing.JLabel();
        cmb_materia = new javax.swing.JComboBox();
        lblcontra6 = new javax.swing.JLabel();
        lblcontra7 = new javax.swing.JLabel();
        cmb_docente = new javax.swing.JComboBox();
        btn_mostrar = new javax.swing.JButton();
        lblcontra8 = new javax.swing.JLabel();
        cmb_seccion = new javax.swing.JComboBox();

        setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Materias");
        setToolTipText("Materias");
        setAlignmentX(0.0F);
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setPreferredSize(new java.awt.Dimension(890, 408));
        try {
            setSelected(true);
        } catch (java.beans.PropertyVetoException e1) {
            e1.printStackTrace();
        }
        setVisible(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        cmb_grado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmb_gradoActionPerformed(evt);
            }
        });
        getContentPane().add(cmb_grado, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 70, 200, -1));

        lblcontra5.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        lblcontra5.setText("Grado:");
        getContentPane().add(lblcontra5, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 70, -1, -1));

        cmb_materia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmb_materiaActionPerformed(evt);
            }
        });
        getContentPane().add(cmb_materia, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 100, 200, -1));

        lblcontra6.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        lblcontra6.setText("Materia:");
        getContentPane().add(lblcontra6, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 100, -1, -1));

        lblcontra7.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        lblcontra7.setText("Maestro:");
        getContentPane().add(lblcontra7, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 160, -1, -1));

        getContentPane().add(cmb_docente, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 160, 200, -1));

        btn_mostrar.setText("Ver");
        btn_mostrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_mostrarActionPerformed(evt);
            }
        });
        getContentPane().add(btn_mostrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 200, 210, -1));

        lblcontra8.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        lblcontra8.setText("Sección:");
        getContentPane().add(lblcontra8, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 130, -1, -1));

        getContentPane().add(cmb_seccion, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 130, 200, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cmb_gradoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmb_gradoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmb_gradoActionPerformed

    private void btn_mostrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_mostrarActionPerformed
         GenerarReportes gr = new GenerarReportes();
         String materia = cmb_materia.getSelectedItem().toString();
         String docente = cmb_docente.getSelectedItem().toString();        
         String sec=cmb_seccion.getSelectedItem().toString();
         String grado = cmb_grado.getSelectedItem().toString();
         gr.ALumnos(grado, sec, docente, materia);
    }//GEN-LAST:event_btn_mostrarActionPerformed

    private void cmb_materiaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmb_materiaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmb_materiaActionPerformed

   
    /* FILTRADO DE MATERIAS, SECCIONES Y GRADOS ASIGNADOS AL MAESTRO*/
     private void  LlenarComboM(){
        List<Materia> materia = mjc.GetMaterias(idLog,con.conn);
               
         for (Materia Materia1 : materia) {
            cmb_materia.addItem(Materia1.getMateriaNombre());
        }
    }
    private void LlenarSecciones(){
        List<String> secciones = sjc.GetSecciones(idLog,con.conn);
         for (String seccion : secciones) {
            cmb_seccion.addItem(seccion);
        }
    }
     private void LlenarGrados(){
        List<String> grados = gjc.GetGrados(idLog,con.conn);
         for (String grado : grados) {
            cmb_grado.addItem(grado);
        }
    }
     
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_mostrar;
    private javax.swing.JComboBox cmb_docente;
    private javax.swing.JComboBox cmb_grado;
    private javax.swing.JComboBox cmb_materia;
    private javax.swing.JComboBox cmb_seccion;
    private javax.swing.JLabel lblcontra5;
    private javax.swing.JLabel lblcontra6;
    private javax.swing.JLabel lblcontra7;
    private javax.swing.JLabel lblcontra8;
    // End of variables declaration//GEN-END:variables

}
