/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Views.Maestro;

import Acceso_Datos.ConectionDB;
import Acceso_Datos.MateriaJpaController;
import Acceso_Datos.SeccionJpaController;
import Acceso_Datos.entityMain;
import Logica_Negocios.EditarNota;
import Logica_Negocios.Materia;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Jorge Villanueva
 */
public class Editar_Nota_M extends javax.swing.JInternalFrame {

    /**
     * Creates new form Agregar_Alumno
     */
      DefaultTableModel modM;
       public String idLog;
       String id="null";
       MateriaJpaController mjc = new MateriaJpaController(entityMain.getInstance());
       SeccionJpaController sjc = new SeccionJpaController(entityMain.getInstance());
    public Editar_Nota_M() {
        
        initComponents();
       
        
           // this.setMaximum(true);
        

    }
       public void setIdLog(String id){
        this.idLog=id;
        LlenarComboM();
        LlenarGrados();
        LlenarSecciones();
         
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
        txtnota1 = new javax.swing.JTextField();
        txtnota2 = new javax.swing.JTextField();
        lblcontra = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        txtApellido = new javax.swing.JTextField();
        Btn_Actualizar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        lblcontra3 = new javax.swing.JLabel();
        txtnota3 = new javax.swing.JTextField();
        Btn_Limpiar = new javax.swing.JButton();
        cmb_grado = new javax.swing.JComboBox();
        lblgrado = new javax.swing.JLabel();
        lblUsuario3 = new javax.swing.JLabel();
        txt_Id = new javax.swing.JTextField();
        cmb_materia = new javax.swing.JComboBox();
        lblcontra6 = new javax.swing.JLabel();
        lblcontra7 = new javax.swing.JLabel();
        cmb_seccion = new javax.swing.JComboBox();
        cmb_periodo = new javax.swing.JComboBox();
        lblcontra8 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        Tabla_Edit_Notas = new javax.swing.JTable();
        lblcontra4 = new javax.swing.JLabel();
        txtpromedio = new javax.swing.JTextField();
        btn_buscar = new javax.swing.JButton();

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
        getContentPane().add(lblUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 280, -1, -1));

        lblcontra1.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        lblcontra1.setText("Nota 2:");
        getContentPane().add(lblcontra1, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 380, -1, -1));

        lblUsuario1.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        lblUsuario1.setText("Nota1:");
        getContentPane().add(lblUsuario1, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 350, -1, -1));

        txtnota1.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        getContentPane().add(txtnota1, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 350, 200, -1));

        txtnota2.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        getContentPane().add(txtnota2, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 380, 200, -1));

        lblcontra.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        lblcontra.setText("Apellido:");
        getContentPane().add(lblcontra, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 320, -1, -1));

        txtNombre.setEditable(false);
        txtNombre.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        getContentPane().add(txtNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 280, 200, -1));

        txtApellido.setEditable(false);
        txtApellido.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        getContentPane().add(txtApellido, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 320, 200, -1));

        Btn_Actualizar.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        Btn_Actualizar.setText("Actualizar");
        Btn_Actualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn_ActualizarActionPerformed(evt);
            }
        });
        getContentPane().add(Btn_Actualizar, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 550, 250, -1));

        jLabel1.setFont(new java.awt.Font("Arial", 0, 36)); // NOI18N
        jLabel1.setText("Editar Nota");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 10, 320, -1));

        lblcontra3.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        lblcontra3.setText("Nota 3:");
        getContentPane().add(lblcontra3, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 410, -1, -1));

        txtnota3.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        txtnota3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtnota3ActionPerformed(evt);
            }
        });
        getContentPane().add(txtnota3, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 410, 200, -1));

        Btn_Limpiar.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        Btn_Limpiar.setText("Limpiar");
        Btn_Limpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn_LimpiarActionPerformed(evt);
            }
        });
        getContentPane().add(Btn_Limpiar, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 580, 250, -1));

        getContentPane().add(cmb_grado, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 70, 200, -1));

        lblgrado.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        lblgrado.setText("Grado:");
        getContentPane().add(lblgrado, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 70, -1, -1));

        lblUsuario3.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        lblUsuario3.setText("Id:");
        getContentPane().add(lblUsuario3, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 240, -1, -1));

        txt_Id.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        txt_Id.setEnabled(false);
        getContentPane().add(txt_Id, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 240, 200, -1));

        getContentPane().add(cmb_materia, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 100, 200, -1));

        lblcontra6.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        lblcontra6.setText("Materia:");
        getContentPane().add(lblcontra6, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 100, -1, -1));

        lblcontra7.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        lblcontra7.setText("Sección:");
        getContentPane().add(lblcontra7, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 130, -1, -1));

        getContentPane().add(cmb_seccion, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 130, 200, -1));

        cmb_periodo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "1", "2", "3" }));
        getContentPane().add(cmb_periodo, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 160, 200, -1));

        lblcontra8.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        lblcontra8.setText("Periodo:");
        getContentPane().add(lblcontra8, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 160, -1, -1));

        Tabla_Edit_Notas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Nombre", "Apellido", "Nota 1 (35%)", "Nota 2 (35%)", "Nota 3 (30%)", "Promedio"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
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

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(349, 72, 910, 630));

        lblcontra4.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        lblcontra4.setText("Promedio:");
        getContentPane().add(lblcontra4, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 440, -1, 20));

        txtpromedio.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        txtpromedio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtpromedioActionPerformed(evt);
            }
        });
        getContentPane().add(txtpromedio, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 440, 200, -1));

        btn_buscar.setText("Buscar");
        btn_buscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_buscarActionPerformed(evt);
            }
        });
        getContentPane().add(btn_buscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 190, 200, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void Btn_ActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_ActualizarActionPerformed
      try {
            if (!id.equals("null")) {

              
                 
                 String NotaUno=txtnota1.getText().replace(",", ".");
                 String NotaDos=txtnota2.getText().replace(",", ".");
                 String NotaTres=txtnota3.getText().replace(",", ".");
                
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
          txt_Id.setText("");
         txtNombre.setText("");
         txtApellido.setText("");
         txtnota1.setText("");
         txtnota2.setText("");
         txtnota3.setText("");
         txtpromedio.setText("");
         id="null";
    }//GEN-LAST:event_Btn_LimpiarActionPerformed

    private void txtnota3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtnota3ActionPerformed
        
    }//GEN-LAST:event_txtnota3ActionPerformed

    private void Tabla_Edit_NotasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Tabla_Edit_NotasMouseClicked
         id=Tabla_Edit_Notas.getValueAt(Tabla_Edit_Notas.getSelectedRow(), 0).toString();
        String nom=Tabla_Edit_Notas.getValueAt(Tabla_Edit_Notas.getSelectedRow(), 1).toString();
        String ape=Tabla_Edit_Notas.getValueAt(Tabla_Edit_Notas.getSelectedRow(), 2).toString();
        String not1=Tabla_Edit_Notas.getValueAt(Tabla_Edit_Notas.getSelectedRow(), 3).toString();
        String not2=Tabla_Edit_Notas.getValueAt(Tabla_Edit_Notas.getSelectedRow(), 4).toString();
        String not3=Tabla_Edit_Notas.getValueAt(Tabla_Edit_Notas.getSelectedRow(), 5).toString();
        String proM=Tabla_Edit_Notas.getValueAt(Tabla_Edit_Notas.getSelectedRow(), 6).toString();
       
        txt_Id.setText(id);
        txtNombre.setText(nom);
        txtApellido.setText(ape);
        txtnota1.setText(not1);
        txtnota2.setText(not2);
        txtnota3.setText(not3);
        txtpromedio.setText(proM);
    }//GEN-LAST:event_Tabla_Edit_NotasMouseClicked
    List<EditarNota> editarNotas;
    
       private void cargartabla(){
    
        String periodo= cmb_periodo.getSelectedItem().toString();
        String grado=cmb_grado.getSelectedItem().toString();
        String materia=cmb_materia.getSelectedItem().toString();
        String seccion=cmb_seccion.getSelectedItem().toString();
       // String[] docent =cmb_docente.getSelectedItem().toString().split(",");
       //String docente =docent[0];
        ConectionDB con = new ConectionDB();
        editarNotas =  con.GetListaNotas(periodo, grado, materia, seccion, idLog);
    
    modM = (DefaultTableModel) Tabla_Edit_Notas.getModel(); 
    modM.setRowCount(0);
    for(int i=0; i<editarNotas.size(); i++)
        {
            String[] registroC = {editarNotas.get(i).getId(),
                                  editarNotas.get(i).getNombre(),
                                  editarNotas.get(i).getApellido(),
                                  Double.toString(editarNotas.get(i).getNota1()).replace(".", ","),
                                   Double.toString(editarNotas.get(i).getNota2()).replace(".", ","),
                                   Double.toString(editarNotas.get(i).getNota3()).replace(".", ","),
                                   Double.toString(Math.round((editarNotas.get(i).getNota1()*0.35+editarNotas.get(i).getNota2()*0.35+editarNotas.get(i).getNota3()*0.30)*100d)/100d).replace(".", ",")
                                  };
              modM.addRow(registroC);
           }
          
        }
       private void  LlenarComboM(){
        ConectionDB con = new ConectionDB();
        
        List<Materia> materia =mjc.GetMaterias(idLog);
         for (Materia Materia1 : materia) {
            cmb_materia.addItem(Materia1.getMateriaNombre());
        }
    }
    private void LlenarSecciones(){
        
        List<String> secciones = sjc.GetSecciones(idLog);
         for (String seccion : secciones) {
            cmb_seccion.addItem(seccion);
        }
        
    }
     private void LlenarGrados(){
        ConectionDB con = new ConectionDB();
        List<String> grados = con.GetGrados(idLog);
         for (String grado : grados) {
            cmb_grado.addItem(grado);
        }
    }
    private void txtpromedioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtpromedioActionPerformed
    
    }//GEN-LAST:event_txtpromedioActionPerformed

    private void btn_buscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_buscarActionPerformed
      cargartabla(); 
    }//GEN-LAST:event_btn_buscarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Btn_Actualizar;
    private javax.swing.JButton Btn_Limpiar;
    private javax.swing.JTable Tabla_Edit_Notas;
    private javax.swing.JButton btn_buscar;
    private javax.swing.JComboBox cmb_grado;
    private javax.swing.JComboBox cmb_materia;
    private javax.swing.JComboBox cmb_periodo;
    private javax.swing.JComboBox cmb_seccion;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblUsuario;
    private javax.swing.JLabel lblUsuario1;
    private javax.swing.JLabel lblUsuario3;
    private javax.swing.JLabel lblcontra;
    private javax.swing.JLabel lblcontra1;
    private javax.swing.JLabel lblcontra3;
    private javax.swing.JLabel lblcontra4;
    private javax.swing.JLabel lblcontra6;
    private javax.swing.JLabel lblcontra7;
    private javax.swing.JLabel lblcontra8;
    private javax.swing.JLabel lblgrado;
    private javax.swing.JTextField txtApellido;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txt_Id;
    private javax.swing.JTextField txtnota1;
    private javax.swing.JTextField txtnota2;
    private javax.swing.JTextField txtnota3;
    private javax.swing.JTextField txtpromedio;
    // End of variables declaration//GEN-END:variables
}
