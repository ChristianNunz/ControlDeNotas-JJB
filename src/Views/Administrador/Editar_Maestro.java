/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Views.Administrador;

import java.beans.PropertyVetoException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Jorge Villanueva
 */
public class Editar_Maestro extends javax.swing.JInternalFrame {

    /**
     * Creates new form Agregar_Alumno
     */
    public Editar_Maestro() {
        
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
        lblcontra1 = new javax.swing.JLabel();
        lblUsuario1 = new javax.swing.JLabel();
        lblUsuario2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        txtTelefono = new javax.swing.JTextField();
        txtDireccion = new javax.swing.JTextField();
        lblcontra = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        txtApellido = new javax.swing.JTextField();
        Btn_Actualizar = new javax.swing.JButton();
        lblcontra2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        lblcontra3 = new javax.swing.JLabel();
        txtDireccion1 = new javax.swing.JTextField();
        dcc_fechaNac = new datechooser.beans.DateChooserCombo();
        lblcontra4 = new javax.swing.JLabel();
        txt_sex = new javax.swing.JTextField();
        btn_cmb_sex = new javax.swing.JButton();
        txt_activ = new javax.swing.JTextField();
        btn_cmb_estado = new javax.swing.JButton();
        Btn_Limpiar = new javax.swing.JButton();
        lblUsuario3 = new javax.swing.JLabel();
        txt_Id = new javax.swing.JTextField();

        setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Editar Maestro");
        setToolTipText("Editar Maestro");
        setAlignmentX(0.0F);
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setPreferredSize(new java.awt.Dimension(890, 408));
        try {
            setSelected(true);
        } catch (java.beans.PropertyVetoException e1) {
            e1.printStackTrace();
        }
        setVisible(true);

        lblUsuario.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        lblUsuario.setText("Nombre:");

        lblcontra1.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        lblcontra1.setText("Direccion:");

        lblUsuario1.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        lblUsuario1.setText("Telefono:");

        lblUsuario2.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        lblUsuario2.setText("Fecha Nacimiento:");

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nombre", "Apellido", "Telefono", "Direccion", "Fecha Nac.", "Genero"
            }
        ));
        jTable1.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_ALL_COLUMNS);
        jTable1.setAutoscrolls(false);
        jTable1.setFocusTraversalPolicyProvider(true);
        jTable1.setFocusable(false);
        jScrollPane1.setViewportView(jTable1);

        txtTelefono.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N

        txtDireccion.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N

        lblcontra.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        lblcontra.setText("Apellido:");

        txtNombre.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N

        txtApellido.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N

        Btn_Actualizar.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        Btn_Actualizar.setText("Actualizar");
        Btn_Actualizar.setEnabled(false);
        Btn_Actualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn_ActualizarActionPerformed(evt);
            }
        });

        lblcontra2.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        lblcontra2.setText("Genero:");

        jLabel1.setFont(new java.awt.Font("Arial", 0, 36)); // NOI18N
        jLabel1.setText("Editar Maestro");

        lblcontra3.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        lblcontra3.setText("Dui:");

        txtDireccion1.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N

        dcc_fechaNac.setCurrentView(new datechooser.view.appearance.AppearancesList("Swing",
            new datechooser.view.appearance.ViewAppearance("custom",
                new datechooser.view.appearance.swing.SwingCellAppearance(new java.awt.Font("Tahoma", java.awt.Font.PLAIN, 11),
                    new java.awt.Color(0, 0, 0),
                    new java.awt.Color(0, 0, 255),
                    false,
                    true,
                    new datechooser.view.appearance.swing.ButtonPainter()),
                new datechooser.view.appearance.swing.SwingCellAppearance(new java.awt.Font("Tahoma", java.awt.Font.PLAIN, 11),
                    new java.awt.Color(0, 0, 0),
                    new java.awt.Color(0, 0, 255),
                    true,
                    true,
                    new datechooser.view.appearance.swing.ButtonPainter()),
                new datechooser.view.appearance.swing.SwingCellAppearance(new java.awt.Font("Tahoma", java.awt.Font.PLAIN, 11),
                    new java.awt.Color(0, 0, 255),
                    new java.awt.Color(0, 0, 255),
                    false,
                    true,
                    new datechooser.view.appearance.swing.ButtonPainter()),
                new datechooser.view.appearance.swing.SwingCellAppearance(new java.awt.Font("Tahoma", java.awt.Font.PLAIN, 11),
                    new java.awt.Color(128, 128, 128),
                    new java.awt.Color(0, 0, 255),
                    false,
                    true,
                    new datechooser.view.appearance.swing.LabelPainter()),
                new datechooser.view.appearance.swing.SwingCellAppearance(new java.awt.Font("Tahoma", java.awt.Font.PLAIN, 11),
                    new java.awt.Color(0, 0, 0),
                    new java.awt.Color(0, 0, 255),
                    false,
                    true,
                    new datechooser.view.appearance.swing.LabelPainter()),
                new datechooser.view.appearance.swing.SwingCellAppearance(new java.awt.Font("Tahoma", java.awt.Font.PLAIN, 11),
                    new java.awt.Color(0, 0, 0),
                    new java.awt.Color(255, 0, 0),
                    false,
                    false,
                    new datechooser.view.appearance.swing.ButtonPainter()),
                (datechooser.view.BackRenderer)null,
                false,
                true)));
    dcc_fechaNac.setNothingAllowed(false);
    dcc_fechaNac.setFormat(2);
    dcc_fechaNac.setFieldFont(new java.awt.Font("Tahoma", java.awt.Font.BOLD, 12));
    try {
        dcc_fechaNac.setForbiddenPeriods(new datechooser.model.multiple.PeriodSet());
    } catch (datechooser.model.exeptions.IncompatibleDataExeption e1) {
        e1.printStackTrace();
    }
    dcc_fechaNac.setNavigateFont(new java.awt.Font("Serif", java.awt.Font.BOLD, 18));
    dcc_fechaNac.setCurrentNavigateIndex(0);
    dcc_fechaNac.setShowOneMonth(true);

    lblcontra4.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
    lblcontra4.setText("Estado:");

    txt_sex.setEditable(false);
    txt_sex.setText("Masculino");
    txt_sex.setAlignmentX(0.0F);
    txt_sex.setFocusable(false);
    txt_sex.setMargin(new java.awt.Insets(0, 0, 0, 0));

    btn_cmb_sex.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/change.png"))); // NOI18N
    btn_cmb_sex.setMargin(new java.awt.Insets(0, 0, 0, 0));
    btn_cmb_sex.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            btn_cmb_sexActionPerformed(evt);
        }
    });

    txt_activ.setEditable(false);
    txt_activ.setText("Activo");
    txt_activ.setFocusable(false);

    btn_cmb_estado.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/change.png"))); // NOI18N
    btn_cmb_estado.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            btn_cmb_estadoActionPerformed(evt);
        }
    });

    Btn_Limpiar.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
    Btn_Limpiar.setText("Limpiar");
    Btn_Limpiar.setEnabled(false);
    Btn_Limpiar.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            Btn_LimpiarActionPerformed(evt);
        }
    });

    lblUsuario3.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
    lblUsuario3.setText("Id:");

    txt_Id.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
    txt_Id.setEnabled(false);

    javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
    getContentPane().setLayout(layout);
    layout.setHorizontalGroup(
        layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(layout.createSequentialGroup()
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(480, 480, 480)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 320, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createSequentialGroup()
                    .addGap(5, 5, 5)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(lblUsuario2, javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(lblcontra, javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(lblcontra2, javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(lblUsuario3, javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(lblUsuario, javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(lblcontra1, javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(lblUsuario1, javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(lblcontra3, javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(lblcontra4, javax.swing.GroupLayout.Alignment.TRAILING))
                    .addGap(18, 18, 18)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(txtTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtApellido, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txt_Id, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtDireccion1, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(dcc_fechaNac, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(txt_sex, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txt_activ, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(btn_cmb_sex, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(btn_cmb_estado, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGap(45, 45, 45)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 910, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createSequentialGroup()
                    .addGap(90, 90, 90)
                    .addComponent(Btn_Limpiar, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createSequentialGroup()
                    .addGap(90, 90, 90)
                    .addComponent(Btn_Actualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)))
            .addGap(9, 9, 9))
    );
    layout.setVerticalGroup(
        layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(layout.createSequentialGroup()
            .addGap(10, 10, 10)
            .addComponent(jLabel1)
            .addGap(17, 17, 17)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(lblUsuario3)
                        .addComponent(txt_Id, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(17, 17, 17)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(lblUsuario)
                        .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(17, 17, 17)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(lblcontra)
                        .addComponent(txtApellido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(7, 7, 7)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(lblUsuario1)
                        .addComponent(txtTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(7, 7, 7)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(lblcontra1)
                        .addComponent(txtDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(7, 7, 7)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(lblcontra3)
                        .addComponent(txtDireccion1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(7, 7, 7)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(lblUsuario2)
                        .addComponent(dcc_fechaNac, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(10, 10, 10)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(lblcontra2)
                        .addComponent(txt_sex, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btn_cmb_sex, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(7, 7, 7)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addGap(10, 10, 10)
                            .addComponent(lblcontra4))
                        .addComponent(txt_activ, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btn_cmb_estado))
                    .addGap(193, 193, 193)
                    .addComponent(Btn_Actualizar)
                    .addGap(5, 5, 5)
                    .addComponent(Btn_Limpiar))
                .addGroup(layout.createSequentialGroup()
                    .addGap(2, 2, 2)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 630, javax.swing.GroupLayout.PREFERRED_SIZE))))
    );

    pack();
    }// </editor-fold>//GEN-END:initComponents

    private void Btn_ActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_ActualizarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Btn_ActualizarActionPerformed

    private void btn_cmb_sexActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_cmb_sexActionPerformed
        // TODO add your handling code here:
        String sex=txt_sex.getText();
        if (sex.equals("Masculino")) {
            txt_sex.setText("Femenino");
        }
        if (sex.equals("Femenino")) {
            txt_sex.setText("Masculino");
        }
    }//GEN-LAST:event_btn_cmb_sexActionPerformed

    private void btn_cmb_estadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_cmb_estadoActionPerformed
        // TODO add your handling code here:
        String estado=txt_activ.getText();
        if (estado.equals("Activo")) {
            txt_activ.setText("Inactivo");
        }
        if (estado.equals("Inactivo")) {
            txt_activ.setText("Activo");
        }
    }//GEN-LAST:event_btn_cmb_estadoActionPerformed

    private void Btn_LimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_LimpiarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Btn_LimpiarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Btn_Actualizar;
    private javax.swing.JButton Btn_Limpiar;
    private javax.swing.JButton btn_cmb_estado;
    private javax.swing.JButton btn_cmb_sex;
    private datechooser.beans.DateChooserCombo dcc_fechaNac;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel lblUsuario;
    private javax.swing.JLabel lblUsuario1;
    private javax.swing.JLabel lblUsuario2;
    private javax.swing.JLabel lblUsuario3;
    private javax.swing.JLabel lblcontra;
    private javax.swing.JLabel lblcontra1;
    private javax.swing.JLabel lblcontra2;
    private javax.swing.JLabel lblcontra3;
    private javax.swing.JLabel lblcontra4;
    private javax.swing.JTextField txtApellido;
    private javax.swing.JTextField txtDireccion;
    private javax.swing.JTextField txtDireccion1;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtTelefono;
    private javax.swing.JTextField txt_Id;
    private javax.swing.JTextField txt_activ;
    private javax.swing.JTextField txt_sex;
    // End of variables declaration//GEN-END:variables
}
