/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Views.Maestro;

import Acceso_Datos.ConectionDB;
import Acceso_Datos.DocenteJpaController;
import Acceso_Datos.entityMain;
import Excel.Excel;
import Excel.ModeloAlumnoNota;
import Logica_Negocios.Docente;
import java.beans.PropertyVetoException;
import java.io.File;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.FlushModeType;
import javax.persistence.LockModeType;
import javax.persistence.Parameter;
import javax.persistence.ParameterMode;
import javax.persistence.Query;
import javax.persistence.StoredProcedureQuery;
import javax.persistence.TemporalType;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Jorge Villanueva
 */
public class Subir_Nota extends javax.swing.JInternalFrame {
    List<ModeloAlumnoNota> alumnoNotas;
    DefaultTableModel modM;    
    File src=null;
    String IdLog;
    public Subir_Nota() {
        
        initComponents();
       
       
        modM = (DefaultTableModel) jTable1.getModel();
        

    }
     public void setIdLog(String id){
        this.IdLog=id;
         DocenteJpaController djc = new DocenteJpaController(entityMain.getInstance());
         Docente docente=djc.findDocente(new BigDecimal(id));
         txtDocente.setText(docente.getDocenteNombre()+" "+docente.getDocenteApellido());
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
        jTable1 = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        Btn_Guardar = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        txtDocente = new javax.swing.JTextField();
        txtgrado = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtseccion = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtmateria = new javax.swing.JTextField();
        cmbperiodo = new javax.swing.JComboBox();
        jLabel6 = new javax.swing.JLabel();
        Btn_ReCargar = new javax.swing.JButton();
        Btn_Limpiar = new javax.swing.JButton();

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

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nombre", "Apellido", "Nota 1", "Nota 2", "Nota 3"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jTable1.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_ALL_COLUMNS);
        jTable1.setAutoscrolls(false);
        jTable1.setFocusTraversalPolicyProvider(true);
        jTable1.setFocusable(false);
        jScrollPane1.setViewportView(jTable1);

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

        txtgrado.setEditable(false);
        txtgrado.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setText("Grado");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setText("Periodo");

        txtseccion.setEditable(false);
        txtseccion.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel5.setText("Materia");

        txtmateria.setEditable(false);
        txtmateria.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        cmbperiodo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "-", "1", "2", "3" }));

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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(79, 79, 79)
                .addComponent(Btn_Cargar, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(14, 14, 14)
                .addComponent(Btn_ReCargar, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(Btn_Limpiar, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(Btn_Guardar, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(199, 199, 199))
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
                        .addComponent(txtgrado, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(28, 28, 28)
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtmateria)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cmbperiodo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtseccion, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                        .addComponent(jLabel1)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1280, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
                            .addComponent(txtDocente, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(8, 8, 8))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(txtgrado, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGap(2, 2, 2))
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 2, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(txtmateria, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(cmbperiodo, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txtseccion, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 525, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(Btn_ReCargar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(Btn_Limpiar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(Btn_Guardar, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(Btn_Cargar))
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
            CargarTabla();
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
          ConectionDB cdb = new ConectionDB();
        try {
            
            StoredProcedureQuery spq = new StoredProcedureQuery() {

                @Override
                public StoredProcedureQuery setHint(String hintName, Object value) {
                    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                }

                @Override
                public <T> StoredProcedureQuery setParameter(Parameter<T> param, T value) {
                    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                }

                @Override
                public StoredProcedureQuery setParameter(Parameter<Calendar> param, Calendar value, TemporalType temporalType) {
                    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                }

                @Override
                public StoredProcedureQuery setParameter(Parameter<Date> param, Date value, TemporalType temporalType) {
                    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                }

                @Override
                public StoredProcedureQuery setParameter(String name, Object value) {
                    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                }

                @Override
                public StoredProcedureQuery setParameter(String name, Calendar value, TemporalType temporalType) {
                    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                }

                @Override
                public StoredProcedureQuery setParameter(String name, Date value, TemporalType temporalType) {
                    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                }

                @Override
                public StoredProcedureQuery setParameter(int position, Object value) {
                    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                }

                @Override
                public StoredProcedureQuery setParameter(int position, Calendar value, TemporalType temporalType) {
                    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                }

                @Override
                public StoredProcedureQuery setParameter(int position, Date value, TemporalType temporalType) {
                    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                }

                @Override
                public StoredProcedureQuery setFlushMode(FlushModeType flushMode) {
                    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                }

                @Override
                public StoredProcedureQuery registerStoredProcedureParameter(int position, Class type, ParameterMode mode) {
                    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                }

                @Override
                public StoredProcedureQuery registerStoredProcedureParameter(String parameterName, Class type, ParameterMode mode) {
                    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                }

                @Override
                public Object getOutputParameterValue(int position) {
                    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                }

                @Override
                public Object getOutputParameterValue(String parameterName) {
                    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                }

                @Override
                public boolean execute() {
                    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                }

                @Override
                public int executeUpdate() {
                    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                }

                @Override
                public List getResultList() {
                    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                }

                @Override
                public Object getSingleResult() {
                    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                }

                @Override
                public boolean hasMoreResults() {
                    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                }

                @Override
                public int getUpdateCount() {
                    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                }

                @Override
                public Query setMaxResults(int maxResult) {
                    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                }

                @Override
                public int getMaxResults() {
                    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                }

                @Override
                public Query setFirstResult(int startPosition) {
                    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                }

                @Override
                public int getFirstResult() {
                    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                }

                @Override
                public Map<String, Object> getHints() {
                    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                }

                @Override
                public Set<Parameter<?>> getParameters() {
                    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                }

                @Override
                public Parameter<?> getParameter(String name) {
                    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                }

                @Override
                public <T> Parameter<T> getParameter(String name, Class<T> type) {
                    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                }

                @Override
                public Parameter<?> getParameter(int position) {
                    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                }

                @Override
                public <T> Parameter<T> getParameter(int position, Class<T> type) {
                    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                }

                @Override
                public boolean isBound(Parameter<?> param) {
                    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                }

                @Override
                public <T> T getParameterValue(Parameter<T> param) {
                    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                }

                @Override
                public Object getParameterValue(String name) {
                    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                }

                @Override
                public Object getParameterValue(int position) {
                    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                }

                @Override
                public FlushModeType getFlushMode() {
                    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                }

                @Override
                public Query setLockMode(LockModeType lockMode) {
                    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                }

                @Override
                public LockModeType getLockMode() {
                    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                }

                @Override
                public <T> T unwrap(Class<T> cls) {
                    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                }
            } ;
            ConectionDB con = new ConectionDB();
            for (ModeloAlumnoNota alumnoNota : alumnoNotas) {
                spq = entityMain.getInstance().createEntityManager().createStoredProcedureQuery("REGISTRAR_NOTA_DOCENTE");
            
                spq.registerStoredProcedureParameter("dId",Integer.class, ParameterMode.IN);
                spq.registerStoredProcedureParameter("dGrado", String.class, ParameterMode.IN);
                spq.registerStoredProcedureParameter("dMate", String.class, ParameterMode.IN);
               // spq.registerStoredProcedureParameter("dMate", String.class, ParameterMode.IN);
                spq.registerStoredProcedureParameter("dPeri", Integer.class, ParameterMode.IN);
                spq.registerStoredProcedureParameter("dSec", String.class, ParameterMode.IN);
                spq.registerStoredProcedureParameter("ANom", String.class, ParameterMode.IN);
                spq.registerStoredProcedureParameter("aApe", String.class, ParameterMode.IN);
                spq.registerStoredProcedureParameter("aNotaA", Double.class, ParameterMode.IN);
                spq.registerStoredProcedureParameter("aNotaB", Double.class, ParameterMode.IN);
                spq.registerStoredProcedureParameter("aNotaC", Double.class, ParameterMode.IN);
                spq.registerStoredProcedureParameter("msj", String.class, ParameterMode.OUT);
                
                spq.setParameter("dId", Integer.parseInt(IdLog));
                //spq.setParameter("dNombre",txtDocente.getText());
                spq.setParameter("dGrado",txtgrado.getText());
                spq.setParameter("dMate",txtmateria.getText());
                spq.setParameter("dPeri",Double.parseDouble(cmbperiodo.getSelectedItem().toString()));
                spq.setParameter("dSec",txtseccion.getText());
                spq.setParameter("ANom", alumnoNota.getNombre());
                spq.setParameter("aApe", alumnoNota.getApellido());
                spq.setParameter("aNotaA",alumnoNota.getNota1());
                spq.setParameter("aNotaB", alumnoNota.getNota2());
                spq.setParameter("aNotaC", alumnoNota.getNota3());
                
                spq.execute();
                
               
            }
             String Mensaje=spq.getOutputParameterValue("msj").toString();
             JOptionPane.showMessageDialog(rootPane,Mensaje);
  
        } catch (Exception e) {
            JOptionPane.showMessageDialog(rootPane,"ERROR: " + e);
        }
    }//GEN-LAST:event_Btn_GuardarActionPerformed
    
       private void CargarTabla() {        
        List<ModeloAlumnoNota> lm = alumnoNotas;         
        
        modM.setRowCount(0);                
        for (ModeloAlumnoNota lm1 : lm) {
            String[] registroC = {lm1.getNombre(), lm1.getApellido(), String.valueOf(lm1.getNota1()), String.valueOf(lm1.getNota2()), String.valueOf(lm1.getNota3())};
            modM.addRow(registroC);
        }          
    }
     private void LeerExcel(File src) {
        alumnoNotas = new ArrayList<>();
        Excel excel = new Excel();
        String result = excel.ReadFileExcel(src);
        String Fila[] = result.split("\n");        
        String turno="";        
        try {
            for (int i = 0; i < Fila.length; i++) {
            String[] Colum = Fila[i].split(",");
            if (i==1) {
                //txtDocente.setText(Colum[1]);
                txtgrado.setText(Colum[3]);
                txtseccion.setText(Colum[5]);
                turno=Colum[7];                    
            }else if (i==2){
                txtmateria.setText(Colum[1]);                
            }else if (i>=4) {                
                ModeloAlumnoNota alumnoNota = new ModeloAlumnoNota(Colum[1],Colum[2],Double.parseDouble(Colum[3]),Double.parseDouble(Colum[4]),Double.parseDouble(Colum[5]));
                alumnoNotas.add(alumnoNota);                  
            }           
        }
        } catch (Exception e) {
            
        }
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Btn_Cargar;
    private javax.swing.JButton Btn_Guardar;
    private javax.swing.JButton Btn_Limpiar;
    private javax.swing.JButton Btn_ReCargar;
    private javax.swing.JComboBox cmbperiodo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField txtDocente;
    private javax.swing.JTextField txtgrado;
    private javax.swing.JTextField txtmateria;
    private javax.swing.JTextField txtseccion;
    // End of variables declaration//GEN-END:variables
}
