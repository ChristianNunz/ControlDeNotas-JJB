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
import com.sun.org.apache.bcel.internal.generic.AALOAD;
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
public class Asignar_SeccionesM extends javax.swing.JInternalFrame {

    MateriaGradoJpaController materiaGradoJpaController = new MateriaGradoJpaController(entityMain.getInstance());
    MateriaJpaController materiaJpaController = new MateriaJpaController(entityMain.getInstance());
    GradoJpaController gjc = new GradoJpaController(entityMain.getInstance());
    SeccionJpaController sjc = new SeccionJpaController(entityMain.getInstance());
    TurnoJpaController tjc = new TurnoJpaController(entityMain.getInstance());
   DocenteJpaController djc = new DocenteJpaController(entityMain.getInstance());
     ConectionDB con = new ConectionDB(); 
 
    
    public Asignar_SeccionesM() {
        
        
        initComponents();
        
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy");
        Date fech = new Date();
        
        txt_anho.setText(formatter.format(fech));
        LLenarComboM(); 
        LLenarComboS(); 
        LLenarComboG(); 
        LLenarComboT(); 
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

        lblUsuario = new javax.swing.JLabel();
        txt_anho = new javax.swing.JTextField();
        Btn_Guardar = new javax.swing.JButton();
        cmb_mat = new javax.swing.JComboBox();
        cmb_grado = new javax.swing.JComboBox();
        lblUsuario2 = new javax.swing.JLabel();
        cmb_secc = new javax.swing.JComboBox();
        lblUsuario3 = new javax.swing.JLabel();
        cmb_turno = new javax.swing.JComboBox();
        lblUsuario4 = new javax.swing.JLabel();
        lblUsuario5 = new javax.swing.JLabel();
        cmb_docente = new javax.swing.JComboBox();
        lblUsuario6 = new javax.swing.JLabel();

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

        lblUsuario.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        lblUsuario.setText("Año:");
        getContentPane().add(lblUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 30, -1, 20));

        txt_anho.setEditable(false);
        txt_anho.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        getContentPane().add(txt_anho, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 20, 180, 30));

        Btn_Guardar.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        Btn_Guardar.setText("Guardar");
        Btn_Guardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn_GuardarActionPerformed(evt);
            }
        });
        getContentPane().add(Btn_Guardar, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 230, 100, -1));

        getContentPane().add(cmb_mat, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 60, 180, -1));

        getContentPane().add(cmb_grado, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 90, 180, -1));

        lblUsuario2.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        lblUsuario2.setText("Grado:");
        getContentPane().add(lblUsuario2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 90, -1, 20));

        getContentPane().add(cmb_secc, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 130, 180, -1));

        lblUsuario3.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        lblUsuario3.setText("Seccion:");
        getContentPane().add(lblUsuario3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 130, -1, 20));

        getContentPane().add(cmb_turno, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 170, 180, -1));

        lblUsuario4.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        lblUsuario4.setText("Turno:");
        getContentPane().add(lblUsuario4, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 170, -1, 20));

        lblUsuario5.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        lblUsuario5.setText("Materia:");
        getContentPane().add(lblUsuario5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 60, -1, 20));

        getContentPane().add(cmb_docente, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 200, 180, -1));

        lblUsuario6.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        lblUsuario6.setText("Docente:");
        getContentPane().add(lblUsuario6, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 200, -1, 20));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void Btn_GuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_GuardarActionPerformed
        //String anho = txtNombre.getText();
        Calendar cal= Calendar.getInstance();
        int year = cal.get(Calendar.YEAR);
      
        String NombreM = cmb_mat.getSelectedItem().toString();
        String Grado = cmb_grado.getSelectedItem().toString();  
        String seccion = cmb_secc.getSelectedItem().toString();  
        String turno = cmb_turno.getSelectedItem().toString(); 
        String docente = cmb_docente.getSelectedItem().toString();
        
        //obtiene id seleccionado 
         BigDecimal id = IdMateria(NombreM);
         BigDecimal idg = IdGrado(Grado);
         BigDecimal ids = IdSeccion(seccion);
         BigDecimal idt = IdTurno(turno);
         
        try {
          BigDecimal idd = con.GetIdDocnete(docente);
           int idv = con.GetIdValidar(id,idg,ids,idt,idd);
           if (idv ==0) {
           MateriaGrado materiaGrado = new MateriaGrado(con.GetIdToInsert("MATERIA_GRADO", "ID_MATERIA_GRADO"));
           materiaGrado.setAnho(new BigInteger(txt_anho.getText()));
           materiaGrado.setIdMateria(new Materia(id, NombreM));
           materiaGrado.setIdDocente(new Docente(idd));
           materiaGrado.setIdGrado(new Grado(idg, Grado));
           materiaGrado.setIdSeccion(new Seccion(ids, seccion,new BigInteger("1")));
           materiaGrado.setIdTurno(new Turno(idt, turno));
           materiaGradoJpaController.create(materiaGrado);
               
           JOptionPane.showMessageDialog(rootPane,"Se inserto con exito.." );
        } else {
            JOptionPane.showMessageDialog(rootPane,"Los datos ya se encuentran registrados." );
        }
          
        } catch (Exception e) {
             JOptionPane.showMessageDialog(rootPane,"Ha ocurrido un error.." + e);
        }
   
    }//GEN-LAST:event_Btn_GuardarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Btn_Guardar;
    private javax.swing.JComboBox cmb_docente;
    private javax.swing.JComboBox cmb_grado;
    private javax.swing.JComboBox cmb_mat;
    private javax.swing.JComboBox cmb_secc;
    private javax.swing.JComboBox cmb_turno;
    private javax.swing.JLabel lblUsuario;
    private javax.swing.JLabel lblUsuario2;
    private javax.swing.JLabel lblUsuario3;
    private javax.swing.JLabel lblUsuario4;
    private javax.swing.JLabel lblUsuario5;
    private javax.swing.JLabel lblUsuario6;
    private javax.swing.JTextField txt_anho;
    // End of variables declaration//GEN-END:variables

    private void LLenarComboM() {
        List<Materia> Materias = materiaJpaController.findMateriaEntities();
        for (Materia Materia1 : Materias) {
            cmb_mat.addItem(Materia1.getMateriaNombre());
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
    private void LLenarComboT() {
        List<Turno> turnos = tjc.findTurnoEntities();
        for (Turno turno : turnos) {
            cmb_turno.addItem(turno.getTurnoNombre());
        }
    }
     private void LLenarComboD() {
        List<Docente> docentes = djc.findDocenteEntities();
        for (Docente docente : docentes) {
            cmb_docente.addItem(docente.getDocenteNombre());
        }
    }
   
    private BigDecimal IdMateria(String materia){
     BigDecimal id = null;
      if(materia.equals("Lenguaje")){
      id = new BigDecimal("1");
      }
      else if(materia.equals("Matemáticas")){
          id = new BigDecimal("2");
    }
      else if(materia.equals("Ciencia, Salud y Medio Ambiente")){
          id = new BigDecimal("3");
      }
      else if(materia.equals("Estudios Sociales")){
          id = new BigDecimal("4");
      }
      else if(materia.equals("Educación Fisica")){
          id = new BigDecimal("5");
      }
      else if(materia.equals("Educación Artistica")){
          id = new BigDecimal("6");
      }
      else if(materia.equals("Ingles")){
          id = new BigDecimal("7");
      }
      return id;
    }
    
     private BigDecimal IdGrado(String materia){
     BigDecimal id = null;
      if(materia.equals("4")){
      id = new BigDecimal("1");
      }
      else if(materia.equals("5")){
          id = new BigDecimal("2");
    }
      else if(materia.equals("6")){
          id = new BigDecimal("3");
      }
      else if(materia.equals("7")){
          id = new BigDecimal("4");
      }
      else if(materia.equals("8")){
          id = new BigDecimal("5");
      }
      else if(materia.equals("9")){
          id = new BigDecimal("6");
      }
      return id;
    }

    private BigDecimal IdSeccion(String seccion) {
         BigDecimal id = null;
      if(seccion.equals("A")){
      id = new BigDecimal("1");
      }
      else if(seccion.equals("B")){
          id = new BigDecimal("2");
    }
      else if(seccion.equals("C")){
          id = new BigDecimal("3");
      }
      return id;
    }

    private BigDecimal IdTurno(String turno) {
           BigDecimal id = null;
      if(turno.equals("Matutino")){
      id = new BigDecimal("1");
      }
      else if(turno.equals("vespertino")){
          id = new BigDecimal("2");
    }
      else if(turno.equals("C")){
          id = new BigDecimal("3");
      }
      return id;
    }
    
}