/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Views.Administrador;

import Acceso_Datos.AnhoJpaController;
import Acceso_Datos.ConectionDB;
import Acceso_Datos.DocenteJpaController;
import Acceso_Datos.GradoJpaController;
import Acceso_Datos.MateriaGradoJpaController;
import Acceso_Datos.MateriaJpaController;
import Acceso_Datos.SeccionJpaController;
import Acceso_Datos.TurnoJpaController;
import Acceso_Datos.entityMain;
import Logica_Negocios.Anho;
import Logica_Negocios.Docente;
import Logica_Negocios.Grado;
import Logica_Negocios.Materia;
import Logica_Negocios.MateriaGrado;
import Logica_Negocios.Seccion;
import Logica_Negocios.Turno;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Jorge Villanueva
 */
public class Editar_Materia extends javax.swing.JInternalFrame {

    String id="null";
    AnhoJpaController Anhoo = new AnhoJpaController(entityMain.getInstance());
    MateriaGradoJpaController MateriaGradoJpaController = new MateriaGradoJpaController(entityMain.getInstance());
    MateriaGradoJpaController materiaGradoJpaController = new MateriaGradoJpaController(entityMain.getInstance());
    MateriaJpaController materiaJpaController = new MateriaJpaController(entityMain.getInstance());
    GradoJpaController gjc = new GradoJpaController(entityMain.getInstance());
    SeccionJpaController sjc = new SeccionJpaController(entityMain.getInstance());
    TurnoJpaController tjc = new TurnoJpaController(entityMain.getInstance());
    DocenteJpaController djc = new DocenteJpaController(entityMain.getInstance());
    ConectionDB con = new ConectionDB(); 
    public Editar_Materia() {
        
        initComponents();
        cargartabla();
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

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        Btn_Actualizar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        Btn_Limpiar = new javax.swing.JButton();
        lblUsuario = new javax.swing.JLabel();
        txtbho = new javax.swing.JTextField();
        cmb_mat = new javax.swing.JComboBox();
        cmb_grado = new javax.swing.JComboBox();
        lblUsuario2 = new javax.swing.JLabel();
        cmb_secc = new javax.swing.JComboBox();
        lblUsuario3 = new javax.swing.JLabel();
        cmb_turno = new javax.swing.JComboBox();
        lblUsuario4 = new javax.swing.JLabel();
        lblUsuario5 = new javax.swing.JLabel();
        lblUsuario1 = new javax.swing.JLabel();
        txt_id = new javax.swing.JTextField();
        cmb_docente = new javax.swing.JComboBox();
        lblUsuario6 = new javax.swing.JLabel();

        setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Editar Materia");
        setToolTipText("Editar Materia");
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

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Materia", "Grado", "Seccion", "Turno", "Año", "Docente"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable1.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_ALL_COLUMNS);
        jTable1.setAutoscrolls(false);
        jTable1.setFocusTraversalPolicyProvider(true);
        jTable1.setFocusable(false);
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(349, 72, 910, 630));

        Btn_Actualizar.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        Btn_Actualizar.setText("Actualizar");
        Btn_Actualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn_ActualizarActionPerformed(evt);
            }
        });
        getContentPane().add(Btn_Actualizar, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 330, 200, -1));

        jLabel1.setFont(new java.awt.Font("Arial", 0, 36)); // NOI18N
        jLabel1.setText("Editar Materia");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 10, 320, -1));

        Btn_Limpiar.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        Btn_Limpiar.setText("Limpiar");
        Btn_Limpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn_LimpiarActionPerformed(evt);
            }
        });
        getContentPane().add(Btn_Limpiar, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 360, 200, -1));

        lblUsuario.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        lblUsuario.setText("Año:");
        getContentPane().add(lblUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 110, -1, 20));

        txtbho.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        getContentPane().add(txtbho, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 100, 180, 30));

        getContentPane().add(cmb_mat, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 140, 180, -1));

        getContentPane().add(cmb_grado, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 170, 180, -1));

        lblUsuario2.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        lblUsuario2.setText("Grado:");
        getContentPane().add(lblUsuario2, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 170, -1, 20));

        getContentPane().add(cmb_secc, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 210, 180, -1));

        lblUsuario3.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        lblUsuario3.setText("Seccion:");
        getContentPane().add(lblUsuario3, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 210, -1, 20));

        getContentPane().add(cmb_turno, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 250, 180, -1));

        lblUsuario4.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        lblUsuario4.setText("Turno:");
        getContentPane().add(lblUsuario4, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 250, -1, 20));

        lblUsuario5.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        lblUsuario5.setText("Materia:");
        getContentPane().add(lblUsuario5, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 140, -1, 20));

        lblUsuario1.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        lblUsuario1.setText("Id:");
        getContentPane().add(lblUsuario1, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 70, -1, 20));

        txt_id.setEditable(false);
        txt_id.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        txt_id.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_idActionPerformed(evt);
            }
        });
        getContentPane().add(txt_id, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 70, 180, -1));

        getContentPane().add(cmb_docente, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 290, 180, -1));

        lblUsuario6.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        lblUsuario6.setText("Docente:");
        getContentPane().add(lblUsuario6, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 290, -1, 20));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void Btn_LimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_LimpiarActionPerformed
       id="null";
//        txt_Id1.setText("");
//        txt_materia.setText("");
//        txt_sec.setText("");
//        txt_grado.setText("");
//        txt_anho.setText("");
    }//GEN-LAST:event_Btn_LimpiarActionPerformed

    private void Btn_ActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_ActualizarActionPerformed
      
        
      String NombreM = cmb_mat.getSelectedItem().toString();
      String Grado = cmb_grado.getSelectedItem().toString();
      String seccion = cmb_secc.getSelectedItem().toString();
      String turno = cmb_turno.getSelectedItem().toString();
      String docente = cmb_docente.getSelectedItem().toString();
      String anho = txtbho.getText();
    
        
         BigDecimal idm = IdMateria(NombreM);
         BigDecimal idg = IdGrado(Grado);
         BigDecimal ids = IdSeccion(seccion);
         BigDecimal idt = IdTurno(turno);
         
       try {
           BigDecimal idd = djc.GetIdDocnete(docente);
           MateriaGrado materiaGrado = new MateriaGrado(new BigDecimal(txt_id.getText()));
           materiaGrado.setAnho(new BigInteger(anho));
           materiaGrado.setIdMateria(new Materia(idm, NombreM));
           materiaGrado.setIdGrado(new Grado(idg, Grado));
           materiaGrado.setIdSeccion(new Seccion(ids, seccion,new BigInteger("1")));
           materiaGrado.setIdTurno(new Turno(idt, turno));
           materiaGrado.setIdDocente(new Docente(idd));
           MateriaGradoJpaController.edit(materiaGrado);
           cargartabla();
               
           JOptionPane.showMessageDialog(rootPane,"Se actualizocon exito.." );
        } 
          
         catch (Exception e) {
              JOptionPane.showMessageDialog(rootPane,"ha ocurrido un error" + e );
        }
    }//GEN-LAST:event_Btn_ActualizarActionPerformed

     
    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        // TODO add your handling code here:
        id=jTable1.getValueAt(jTable1.getSelectedRow(), 0).toString();
        txt_id.setText(jTable1.getValueAt(jTable1.getSelectedRow(), 0).toString());
        String materia=jTable1.getValueAt(jTable1.getSelectedRow(), 1).toString();
        String grado=jTable1.getValueAt(jTable1.getSelectedRow(), 2).toString();
        String seccion=jTable1.getValueAt(jTable1.getSelectedRow(), 3).toString();
        String turno=jTable1.getValueAt(jTable1.getSelectedRow(), 4).toString();
        String anho=jTable1.getValueAt(jTable1.getSelectedRow(), 5).toString();
        String docente=jTable1.getValueAt(jTable1.getSelectedRow(), 6).toString();
        
        cmb_grado.setSelectedItem(grado);
        cmb_mat.setSelectedItem(materia);
        cmb_secc.setSelectedItem(seccion);
        cmb_turno.setSelectedItem(turno);
        cmb_docente.setSelectedItem(docente);
        txtbho.setText(anho);
  
    }//GEN-LAST:event_jTable1MouseClicked

    private void txt_idActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_idActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_idActionPerformed
    
    private void cargartabla(){
    
    List<MateriaGrado>lmm =  MateriaGradoJpaController.findMateriaGradoEntities();
    DefaultTableModel modM = (DefaultTableModel) jTable1.getModel(); 
    modM.setRowCount(0);
    for(int i=0; i<lmm.size(); i++)
        {
            String[] registroC = {lmm.get(i).getIdMateriaGrado().toString(),
                                  lmm.get(i).getIdMateria().getMateriaNombre(),
                                  lmm.get(i).getIdGrado().getGrado(),
                                  lmm.get(i).getIdSeccion().getNombreSeccion(),
                                  lmm.get(i).getIdTurno().getTurnoNombre(),
                                  lmm.get(i).getAnho().toString(),
                                  lmm.get(i).getIdDocente().getDocenteNombre()};
              modM.addRow(registroC);
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
           if (docente.getDocenteEstado().equals("Activo")) {
              cmb_docente.addItem(docente.getDocenteNombre() +" " + docente.getDocenteApellido());   
            } 
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Btn_Actualizar;
    private javax.swing.JButton Btn_Limpiar;
    private javax.swing.JComboBox cmb_docente;
    private javax.swing.JComboBox cmb_grado;
    private javax.swing.JComboBox cmb_mat;
    private javax.swing.JComboBox cmb_secc;
    private javax.swing.JComboBox cmb_turno;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel lblUsuario;
    private javax.swing.JLabel lblUsuario1;
    private javax.swing.JLabel lblUsuario2;
    private javax.swing.JLabel lblUsuario3;
    private javax.swing.JLabel lblUsuario4;
    private javax.swing.JLabel lblUsuario5;
    private javax.swing.JLabel lblUsuario6;
    private javax.swing.JTextField txt_id;
    private javax.swing.JTextField txtbho;
    // End of variables declaration//GEN-END:variables

}
