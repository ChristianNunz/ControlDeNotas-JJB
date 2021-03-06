/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Views.Administrador;

import Acceso_Datos.ConectionDB;
import Acceso_Datos.entityMain;
import Excel.Excel;
import Excel.ModeloAlumnoNota;
import java.beans.PropertyVetoException;
import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.ParameterMode;
import javax.persistence.StoredProcedureQuery;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Jorge Villanueva
 */
public class Crear_Nota extends javax.swing.JInternalFrame {

    /**
     * Creates new form Agregar_Alumno
     */
    List<ModeloAlumnoNota> alumnoNotas;
    List<String> Materias;
    int i=0;
    DefaultTableModel modM;    
    File src=null;
    public Crear_Nota() {
        
        initComponents();
        modM = (DefaultTableModel) tablaNotas.getModel();
       
        
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

        Btn_Cargar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaNotas = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        Btn_Guardar = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        txtDocente = new javax.swing.JTextField();
        txtGrado = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtSeccion = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtMateria = new javax.swing.JTextField();
        cmbx_Periodo = new javax.swing.JComboBox();
        jLabel6 = new javax.swing.JLabel();
        Btn_ReCargar = new javax.swing.JButton();
        Btn_Limpiar = new javax.swing.JButton();
        Btn_Limpiar1 = new javax.swing.JButton();

        setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setTitle("Registrar Nota");
        setToolTipText("Registrar Nota");
        setAlignmentX(0.0F);
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setPreferredSize(new java.awt.Dimension(890, 408));
        try {
            setSelected(true);
        } catch (java.beans.PropertyVetoException e1) {
            e1.printStackTrace();
        }
        setVisible(true);

        Btn_Cargar.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        Btn_Cargar.setText("Cargar");
        Btn_Cargar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn_CargarActionPerformed(evt);
            }
        });

        tablaNotas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nombre", "Apellido", "Nota 1", "Nota 2", "Nota 3"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tablaNotas.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_ALL_COLUMNS);
        tablaNotas.setAutoscrolls(false);
        tablaNotas.setFocusTraversalPolicyProvider(true);
        tablaNotas.setFocusable(false);
        jScrollPane1.setViewportView(tablaNotas);

        jLabel1.setFont(new java.awt.Font("Arial", 0, 36)); // NOI18N
        jLabel1.setText("Registrar Nota");
        jLabel1.setToolTipText("Registrar Nota");

        Btn_Guardar.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        Btn_Guardar.setText("Guardar");
        Btn_Guardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn_GuardarActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setText("Docente");

        txtDocente.setEditable(false);
        txtDocente.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtDocente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDocenteActionPerformed(evt);
            }
        });

        txtGrado.setEditable(false);
        txtGrado.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setText("Grado");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setText("Periodo");

        txtSeccion.setEditable(false);
        txtSeccion.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel5.setText("Materia");

        txtMateria.setEditable(false);
        txtMateria.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        cmbx_Periodo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "-", "1", "2", "3" }));

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel6.setText("Sección");

        Btn_ReCargar.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        Btn_ReCargar.setText("Re-Cargar Documento");
        Btn_ReCargar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn_ReCargarActionPerformed(evt);
            }
        });

        Btn_Limpiar.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        Btn_Limpiar.setText("Limpiar");
        Btn_Limpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn_LimpiarActionPerformed(evt);
            }
        });

        Btn_Limpiar1.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        Btn_Limpiar1.setText("Siguiente materia");
        Btn_Limpiar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn_Limpiar1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtDocente, javax.swing.GroupLayout.PREFERRED_SIZE, 388, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtGrado, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(28, 28, 28)
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtMateria, javax.swing.GroupLayout.DEFAULT_SIZE, 304, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cmbx_Periodo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtSeccion, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel1))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(Btn_Cargar, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(Btn_ReCargar, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(Btn_Limpiar1, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 59, Short.MAX_VALUE)
                        .addComponent(Btn_Limpiar, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(Btn_Guardar, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(62, Short.MAX_VALUE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1280, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jLabel1)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtDocente, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(txtGrado, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGap(2, 2, 2))
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 2, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(txtMateria, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(cmbx_Periodo, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txtSeccion, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(16, 16, 16)))
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 525, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Btn_Guardar, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Btn_Cargar)
                    .addComponent(Btn_ReCargar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Btn_Limpiar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Btn_Limpiar1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtDocenteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDocenteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDocenteActionPerformed

    
    private void Btn_CargarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_CargarActionPerformed
        // TODO add your handling code here:
        modM.setRowCount(0);
        JFileChooser chooser = new JFileChooser();
        chooser.setFileFilter( new FileNameExtensionFilter("Excel", "xlsx"));
        chooser.setCurrentDirectory(new File(chooser.getCurrentDirectory().getPath().replace(chooser.getCurrentDirectory().getName(),"Desktop")));
        chooser.showOpenDialog(rootPane);
        src = chooser.getSelectedFile();
        if (src!=null) {
            LeerExcel(src);
           
        }
    }//GEN-LAST:event_Btn_CargarActionPerformed

    private void Btn_ReCargarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_ReCargarActionPerformed
        // TODO add your handling code here:
        if (src!=null) {
            LeerExcel(src);
            CargarTabla();
        }else{
            JOptionPane.showMessageDialog(rootPane, "No ha seleccionado un archivo.");
        }
    }//GEN-LAST:event_Btn_ReCargarActionPerformed

      
    private void Btn_LimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_LimpiarActionPerformed
        // TODO add your handling code here:
        modM.setRowCount(0);
        src=null;
    }//GEN-LAST:event_Btn_LimpiarActionPerformed

    private void Btn_GuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_GuardarActionPerformed
        String Mensaje="Algo salio mal.";
        try {
            for (ModeloAlumnoNota alumnoNota : alumnoNotas) {
                EntityManager em = entityMain.GetEntityManager();
                em.getTransaction().begin();
                StoredProcedureQuery spq = em.createStoredProcedureQuery("registrar_nota_Admin");
            
                spq.registerStoredProcedureParameter("dNombre", String.class, ParameterMode.IN);        
                spq.registerStoredProcedureParameter("dGrado", String.class, ParameterMode.IN);
                spq.registerStoredProcedureParameter("dMate", String.class, ParameterMode.IN);
                spq.registerStoredProcedureParameter("dPeri", Integer.class, ParameterMode.IN);
                spq.registerStoredProcedureParameter("dSec", String.class, ParameterMode.IN);
                spq.registerStoredProcedureParameter("ANom", String.class, ParameterMode.IN);        
                spq.registerStoredProcedureParameter("aApe", String.class, ParameterMode.IN);        
                spq.registerStoredProcedureParameter("aNotaA", Integer.class, ParameterMode.IN);
                spq.registerStoredProcedureParameter("aNotaB", Integer.class, ParameterMode.IN);
                spq.registerStoredProcedureParameter("aNotaC", Integer.class, ParameterMode.IN);        
                spq.registerStoredProcedureParameter("msj", String.class, ParameterMode.OUT);
                
                spq.setParameter("dNombre", txtDocente.getText());      
                spq.setParameter("dGrado", Integer.toString(Integer.parseInt(txtGrado.getText())));
                spq.setParameter("dMate", txtMateria.getText());
                spq.setParameter("dPeri", Double.parseDouble(cmbx_Periodo.getSelectedItem().toString()));
                spq.setParameter("dSec",txtSeccion.getText());
                spq.setParameter("ANom", alumnoNota.getNombre());        
                spq.setParameter("aApe", alumnoNota.getApellido());        
                spq.setParameter("aNotaA", alumnoNota.getNota1());
                spq.setParameter("aNotaB", alumnoNota.getNota2());
                spq.setParameter("aNotaC",alumnoNota.getNota3());
                
                
                spq.execute();
                
                Mensaje=spq.getOutputParameterValue("msj").toString();
                em.getTransaction().commit();
                em.close();
            }
            JOptionPane.showMessageDialog(rootPane,Mensaje);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(rootPane,"Algo salio mal.");
        }
    }//GEN-LAST:event_Btn_GuardarActionPerformed

    private void Btn_Limpiar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_Limpiar1ActionPerformed
        // TODO add your handling code here:
        i++;
        Mostrar(i);
    }//GEN-LAST:event_Btn_Limpiar1ActionPerformed
    private void CargarTabla() {        
        List<ModeloAlumnoNota> lm = alumnoNotas;         
        
        modM.setRowCount(0);                
        for (ModeloAlumnoNota lm1 : lm) {
            String[] registroC = {lm1.getNombre(), lm1.getApellido(), String.valueOf(lm1.getNota1()), String.valueOf(lm1.getNota2()), String.valueOf(lm1.getNota3())};
            modM.addRow(registroC);
        }          
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Btn_Cargar;
    private javax.swing.JButton Btn_Guardar;
    private javax.swing.JButton Btn_Limpiar;
    private javax.swing.JButton Btn_Limpiar1;
    private javax.swing.JButton Btn_ReCargar;
    private javax.swing.JComboBox cmbx_Periodo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tablaNotas;
    private javax.swing.JTextField txtDocente;
    private javax.swing.JTextField txtGrado;
    private javax.swing.JTextField txtMateria;
    private javax.swing.JTextField txtSeccion;
    // End of variables declaration//GEN-END:variables

    private void LeerExcel(File src) {
        alumnoNotas = new ArrayList<>();
        Materias = new ArrayList<>();
        
        Excel excel = new Excel();
        Materias=excel.ReadAllFileExcel(src);
        i=0;
//        String result = excel.ReadFileExcel(src);
        Mostrar(i);
    }

    private void Mostrar(int iterador) {
        alumnoNotas = new ArrayList<>();
        String result = Materias.get(iterador);
        String Fila[] = result.split("\n");        
        String turno="";        
        try {
            for (int i = 0; i < Fila.length; i++) {
            String[] Colum = Fila[i].split("&");
            if (i==1) {
                txtDocente.setText(Colum[1]);
                
                String grade =Colum[3].replace(".","");
                grade=grade.replace("0", "");
                txtGrado.setText(grade);
                txtSeccion.setText(Colum[5]);
                turno=Colum[7];                    
            }else if (i==2){
                txtMateria.setText(Colum[1]);                
            }else if (i>=4) {                
                ModeloAlumnoNota alumnoNota = new ModeloAlumnoNota(Colum[1],Colum[2],Double.parseDouble(Colum[3]),Double.parseDouble(Colum[4]),Double.parseDouble(Colum[5]));
                alumnoNotas.add(alumnoNota);                  
            }           
        }
        } catch (Exception e) {
            String a=e+"";
        }
         CargarTabla();
    }
}
