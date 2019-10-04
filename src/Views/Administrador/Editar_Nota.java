/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Views.Administrador;

import Acceso_Datos.AlumnoJpaController;
import Acceso_Datos.ConectionDB;
import Acceso_Datos.DocenteJpaController;
import Acceso_Datos.GradoJpaController;
import Acceso_Datos.MateriaJpaController;
import Acceso_Datos.PeriodoJpaController;
import Acceso_Datos.SeccionJpaController;
import Acceso_Datos.entityMain;
import Logica_Negocios.Alumno;
import Logica_Negocios.Docente;
import Logica_Negocios.EditarNota;
import Logica_Negocios.Grado;
import Logica_Negocios.Materia;
import Logica_Negocios.Periodo;
import Logica_Negocios.Seccion;
import java.beans.PropertyVetoException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Jorge Villanueva
 */
public class Editar_Nota extends javax.swing.JInternalFrame {
    String id="null";
    AlumnoJpaController CAlumno = new AlumnoJpaController(entityMain.getInstance());
    MateriaJpaController materiaJpaController = new MateriaJpaController(entityMain.getInstance());
    GradoJpaController gjc = new GradoJpaController(entityMain.getInstance());
    SeccionJpaController sjc = new SeccionJpaController(entityMain.getInstance());
    DocenteJpaController djc = new DocenteJpaController(entityMain.getInstance());
    PeriodoJpaController ConPeriodo = new PeriodoJpaController(entityMain.getInstance());
    ConectionDB con = new ConectionDB(); 
    /**
     * Creates new form Agregar_Alumno
     */
    DefaultTableModel modM;
    public Editar_Nota() {
        
        initComponents();
        LLenarComboM(); 
        LLenarComboS(); 
        LLenarComboG();
        LLenarComboD();
        //cargartabla();
        
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
        lblcontra1 = new javax.swing.JLabel();
        lblUsuario1 = new javax.swing.JLabel();
        lblcontra = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        txtApellido = new javax.swing.JTextField();
        Btn_Actualizar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        lblcontra3 = new javax.swing.JLabel();
        Btn_Limpiar = new javax.swing.JButton();
        cmb_grado = new javax.swing.JComboBox();
        lblcontra5 = new javax.swing.JLabel();
        lblUsuario3 = new javax.swing.JLabel();
        txt_Id = new javax.swing.JTextField();
        cmb_mat = new javax.swing.JComboBox();
        lblcontra6 = new javax.swing.JLabel();
        lblcontra7 = new javax.swing.JLabel();
        cmb_secc = new javax.swing.JComboBox();
        jScrollPane1 = new javax.swing.JScrollPane();
        Tabla_Edit_Notas = new javax.swing.JTable();
        btn_buscar = new javax.swing.JButton();
        lblcontra8 = new javax.swing.JLabel();
        cmb_docente = new javax.swing.JComboBox();
        cmb_periodo = new javax.swing.JComboBox();
        lblcontra9 = new javax.swing.JLabel();
        txtnotaDos = new javax.swing.JFormattedTextField();
        txtnotaTres = new javax.swing.JFormattedTextField();
        txtnotaUno = new javax.swing.JFormattedTextField();

        setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Editar Nota");
        setToolTipText("Editar Nota");
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

        lblUsuario.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        lblUsuario.setText("Nombre:");
        getContentPane().add(lblUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 280, -1, -1));

        lblcontra1.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        lblcontra1.setText("Nota 2:");
        getContentPane().add(lblcontra1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 380, -1, -1));

        lblUsuario1.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        lblUsuario1.setText("Nota1:");
        getContentPane().add(lblUsuario1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 350, -1, -1));

        lblcontra.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        lblcontra.setText("Apellido:");
        getContentPane().add(lblcontra, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 320, -1, -1));

        txtNombre.setEditable(false);
        txtNombre.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        getContentPane().add(txtNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 280, 180, -1));

        txtApellido.setEditable(false);
        txtApellido.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        getContentPane().add(txtApellido, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 320, 180, -1));

        Btn_Actualizar.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        Btn_Actualizar.setText("Actualizar");
        Btn_Actualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn_ActualizarActionPerformed(evt);
            }
        });
        getContentPane().add(Btn_Actualizar, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 540, 250, -1));

        jLabel1.setFont(new java.awt.Font("Arial", 0, 36)); // NOI18N
        jLabel1.setText("Editar Nota");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 10, 320, -1));

        lblcontra3.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        lblcontra3.setText("Nota 3:");
        getContentPane().add(lblcontra3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 410, -1, -1));

        Btn_Limpiar.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        Btn_Limpiar.setText("Limpiar");
        Btn_Limpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn_LimpiarActionPerformed(evt);
            }
        });
        getContentPane().add(Btn_Limpiar, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 570, 250, -1));

        getContentPane().add(cmb_grado, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 70, 170, -1));

        lblcontra5.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        lblcontra5.setText("Grado:");
        getContentPane().add(lblcontra5, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 70, -1, -1));

        lblUsuario3.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        lblUsuario3.setText("Id:");
        getContentPane().add(lblUsuario3, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 240, -1, -1));

        txt_Id.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        txt_Id.setEnabled(false);
        getContentPane().add(txt_Id, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 240, 180, -1));

        cmb_mat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmb_matActionPerformed(evt);
            }
        });
        getContentPane().add(cmb_mat, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 100, 170, -1));

        lblcontra6.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        lblcontra6.setText("Materia:");
        getContentPane().add(lblcontra6, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 100, -1, -1));

        lblcontra7.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        lblcontra7.setText("Sección:");
        getContentPane().add(lblcontra7, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 130, -1, -1));

        getContentPane().add(cmb_secc, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 130, 170, -1));

        Tabla_Edit_Notas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Nombre", "Apellido", "Nota 1 (35%)", "Nota 2 (35%)", "Nota 3 (30%)"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        Tabla_Edit_Notas.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_ALL_COLUMNS);
        Tabla_Edit_Notas.setAutoscrolls(false);
        Tabla_Edit_Notas.setFocusTraversalPolicyProvider(true);
        Tabla_Edit_Notas.setFocusable(false);
        Tabla_Edit_Notas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Tabla_Edit_NotasMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(Tabla_Edit_Notas);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 50, 910, 630));

        btn_buscar.setText("Buscar");
        btn_buscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_buscarActionPerformed(evt);
            }
        });
        getContentPane().add(btn_buscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 190, 170, -1));

        lblcontra8.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        lblcontra8.setText("Docente");
        getContentPane().add(lblcontra8, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 160, -1, -1));

        getContentPane().add(cmb_docente, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 160, 170, -1));

        cmb_periodo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "1", "2", "3" }));
        getContentPane().add(cmb_periodo, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 40, 170, -1));

        lblcontra9.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        lblcontra9.setText("Periodo");
        getContentPane().add(lblcontra9, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 40, -1, -1));

        txtnotaDos.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0.00"))));
        getContentPane().add(txtnotaDos, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 380, 180, -1));

        txtnotaTres.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0.00"))));
        getContentPane().add(txtnotaTres, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 410, 180, -1));

        txtnotaUno.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0.00"))));
        getContentPane().add(txtnotaUno, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 350, 180, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void Btn_ActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_ActualizarActionPerformed
        // TODO add your handling code here:   
        try {
            if (!id.equals("null")) {

              
                 
                 String NotaUno=txtnotaUno.getText().replace(",", ".");
                 String NotaDos=txtnotaDos.getText().replace(",", ".");
                 String NotaTres=txtnotaTres.getText().replace(",", ".");
                
                 ConectionDB con = new ConectionDB();
                 con.UpdateNota(id, NotaUno, NotaDos, NotaTres);
                cargartabla();
                
                JOptionPane.showMessageDialog(rootPane, "Notas Editadas Correctamente");
            }            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(rootPane, "Algo salio mal.");
        }
        
        
    }//GEN-LAST:event_Btn_ActualizarActionPerformed

    private void Btn_LimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_LimpiarActionPerformed
        // TODO add your handling code here:
         
         txt_Id.setText("");
         txtNombre.setText("");
         txtApellido.setText("");
         txtnotaUno.setText("");
         txtnotaDos.setText("");
         txtnotaTres.setText("");
         id="null";
    }//GEN-LAST:event_Btn_LimpiarActionPerformed

    private void Tabla_Edit_NotasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Tabla_Edit_NotasMouseClicked
        // TODO add your handling code here:
         id=Tabla_Edit_Notas.getValueAt(Tabla_Edit_Notas.getSelectedRow(), 0).toString();
        String nom=Tabla_Edit_Notas.getValueAt(Tabla_Edit_Notas.getSelectedRow(), 1).toString();
        String ape=Tabla_Edit_Notas.getValueAt(Tabla_Edit_Notas.getSelectedRow(), 2).toString();
        String not1=Tabla_Edit_Notas.getValueAt(Tabla_Edit_Notas.getSelectedRow(), 3).toString();
        String not2=Tabla_Edit_Notas.getValueAt(Tabla_Edit_Notas.getSelectedRow(), 4).toString();
        String not3=Tabla_Edit_Notas.getValueAt(Tabla_Edit_Notas.getSelectedRow(), 5).toString();
       
        txt_Id.setText(id);
        txtNombre.setText(nom);
        txtApellido.setText(ape);
        txtnotaUno.setText(not1);
        txtnotaDos.setText(not2);
        txtnotaTres.setText(not3);
  
    }//GEN-LAST:event_Tabla_Edit_NotasMouseClicked
    List<EditarNota> editarNotas;
    private void btn_buscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_buscarActionPerformed
        // TODO add your handling code here:
        
       
        cargartabla();
        //JOptionPane.showMessageDialog(rootPane,"G "+grado+" M "+materia+" S "+seccion);
    }//GEN-LAST:event_btn_buscarActionPerformed

    private void cmb_matActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmb_matActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmb_matActionPerformed

     private void cargartabla(){
    
        String periodo= cmb_periodo.getSelectedItem().toString();
        String grado=cmb_grado.getSelectedItem().toString();
        String materia=cmb_mat.getSelectedItem().toString();
        String seccion=cmb_secc.getSelectedItem().toString();
        String[] docent =cmb_docente.getSelectedItem().toString().split(",");
        String docente =docent[0];
        ConectionDB con = new ConectionDB();
        editarNotas =  con.GetListaNotas(periodo, grado, materia, seccion, docente);
    
    modM = (DefaultTableModel) Tabla_Edit_Notas.getModel(); 
    modM.setRowCount(0);
    for(int i=0; i<editarNotas.size(); i++)
        {
            String[] registroC = {editarNotas.get(i).getId().toString(),
                                  editarNotas.get(i).getNombre(),
                                  editarNotas.get(i).getApellido(),
                                  Double.toString(editarNotas.get(i).getNota1()).replace(".", ","),
                                   Double.toString(editarNotas.get(i).getNota2()).replace(".", ","),
                                   Double.toString(editarNotas.get(i).getNota3()).replace(".", ",")
                                  };
              modM.addRow(registroC);
           }
          
        }
    
   

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Btn_Actualizar;
    private javax.swing.JButton Btn_Limpiar;
    private javax.swing.JTable Tabla_Edit_Notas;
    private javax.swing.JButton btn_buscar;
    private javax.swing.JComboBox cmb_docente;
    private javax.swing.JComboBox cmb_grado;
    private javax.swing.JComboBox cmb_mat;
    private javax.swing.JComboBox cmb_periodo;
    private javax.swing.JComboBox cmb_secc;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblUsuario;
    private javax.swing.JLabel lblUsuario1;
    private javax.swing.JLabel lblUsuario3;
    private javax.swing.JLabel lblcontra;
    private javax.swing.JLabel lblcontra1;
    private javax.swing.JLabel lblcontra3;
    private javax.swing.JLabel lblcontra5;
    private javax.swing.JLabel lblcontra6;
    private javax.swing.JLabel lblcontra7;
    private javax.swing.JLabel lblcontra8;
    private javax.swing.JLabel lblcontra9;
    private javax.swing.JTextField txtApellido;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txt_Id;
    private javax.swing.JFormattedTextField txtnotaDos;
    private javax.swing.JFormattedTextField txtnotaTres;
    private javax.swing.JFormattedTextField txtnotaUno;
    // End of variables declaration//GEN-END:variables


private void LLenarComboM() {
        List<Materia> Materias = materiaJpaController.findMateriaEntities();
        for (Materia Materia1 : Materias) {
            cmb_mat.addItem(Materia1.getMateriaNombre());
        }
    }
     private void LLenarComboD() {
        List<Docente> docentes = djc.findDocenteEntities();
        for (Docente docente : docentes) {
            cmb_docente.addItem(docente.getIdDocente()+","+ docente.getDocenteNombre()+" " + docente.getDocenteApellido());
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
}
