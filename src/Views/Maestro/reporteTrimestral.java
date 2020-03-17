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
import Logica_Negocios.EditarNota;
import Logica_Negocios.Materia;
import Reportes.GenerarReportes;
//import Reportes.GenerarReportes;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Jorge Villanueva
 */
public class reporteTrimestral extends javax.swing.JInternalFrame {

    /**
     * Creates new form Agregar_Alumno
     */
    public String idLog;
    MateriaJpaController mjc = new MateriaJpaController(entityMain.getInstance());
    SeccionJpaController sjc = new SeccionJpaController(entityMain.getInstance());
    AlumnoJpaController ajc = new AlumnoJpaController(entityMain.getInstance());
    GradoJpaController gjc = new GradoJpaController(entityMain.getInstance());
    ConectionDB con;
    public reporteTrimestral() {
        
        initComponents();
       con = new ConectionDB();
    }
    public void setIdLog(String id){                  
         try {            
            DocenteJpaController djc = new DocenteJpaController(entityMain.getInstance());
            String idDocente=djc.GetIdDocneteByLoginId(id,con.conn);
            this.idLog=idDocente; 
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy");
            Date fech = new Date();        
            txtAnho.setText(formatter.format(fech));
            LlenarSecciones();
            LlenarGrados();
         } catch (Exception e) {
         }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLayeredPane2 = new javax.swing.JLayeredPane();
        cmb_grado_p = new javax.swing.JComboBox();
        lblcontra8 = new javax.swing.JLabel();
        lblcontra9 = new javax.swing.JLabel();
        cmb_secc_p = new javax.swing.JComboBox();
        btn_buscar_p = new javax.swing.JButton();
        cmb_periodo_p = new javax.swing.JComboBox();
        lblcontra10 = new javax.swing.JLabel();
        jLayeredPane1 = new javax.swing.JLayeredPane();
        cmb_gradoRF = new javax.swing.JComboBox();
        lblcontra11 = new javax.swing.JLabel();
        lblcontra12 = new javax.swing.JLabel();
        cmb_seccRF = new javax.swing.JComboBox();
        btn_buscar = new javax.swing.JButton();
        txtAnho = new javax.swing.JTextField();
        jCheckBox1 = new javax.swing.JCheckBox();

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

        jLayeredPane2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Reporte por periodo", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 1, 14))); // NOI18N
        jLayeredPane2.setDebugGraphicsOptions(javax.swing.DebugGraphics.BUFFERED_OPTION);
        jLayeredPane2.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N

        cmb_grado_p.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLayeredPane2.add(cmb_grado_p);
        cmb_grado_p.setBounds(100, 30, 200, 30);

        lblcontra8.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lblcontra8.setText("Grado:");
        jLayeredPane2.add(lblcontra8);
        lblcontra8.setBounds(24, 30, 60, 17);

        lblcontra9.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lblcontra9.setText("Sección:");
        jLayeredPane2.add(lblcontra9);
        lblcontra9.setBounds(14, 60, 70, 17);

        cmb_secc_p.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLayeredPane2.add(cmb_secc_p);
        cmb_secc_p.setBounds(100, 60, 200, 30);

        btn_buscar_p.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        btn_buscar_p.setText("Generar Reporte");
        btn_buscar_p.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_buscar_pActionPerformed(evt);
            }
        });
        jLayeredPane2.add(btn_buscar_p);
        btn_buscar_p.setBounds(100, 120, 200, 40);

        cmb_periodo_p.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        cmb_periodo_p.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "1", "2", "3" }));
        jLayeredPane2.add(cmb_periodo_p);
        cmb_periodo_p.setBounds(100, 90, 200, 30);

        lblcontra10.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        lblcontra10.setText("Periodo:");
        jLayeredPane2.add(lblcontra10);
        lblcontra10.setBounds(29, 100, 50, 17);

        getContentPane().add(jLayeredPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, 330, 180));

        jLayeredPane1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Reporte Final", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 1, 14))); // NOI18N
        jLayeredPane1.setDebugGraphicsOptions(javax.swing.DebugGraphics.BUFFERED_OPTION);
        jLayeredPane1.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N

        cmb_gradoRF.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLayeredPane1.add(cmb_gradoRF);
        cmb_gradoRF.setBounds(100, 30, 200, 30);

        lblcontra11.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lblcontra11.setText("Grado:");
        jLayeredPane1.add(lblcontra11);
        lblcontra11.setBounds(24, 30, 60, 17);

        lblcontra12.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lblcontra12.setText("Sección:");
        jLayeredPane1.add(lblcontra12);
        lblcontra12.setBounds(14, 60, 70, 17);

        cmb_seccRF.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLayeredPane1.add(cmb_seccRF);
        cmb_seccRF.setBounds(100, 60, 200, 30);

        btn_buscar.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        btn_buscar.setText("Generar Reporte");
        btn_buscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_buscarActionPerformed(evt);
            }
        });
        jLayeredPane1.add(btn_buscar);
        btn_buscar.setBounds(100, 120, 200, 40);

        txtAnho.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        txtAnho.setEnabled(false);
        jLayeredPane1.add(txtAnho);
        txtAnho.setBounds(100, 90, 170, 30);

        jCheckBox1.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jCheckBox1.setBorder(javax.swing.BorderFactory.createCompoundBorder());
        jCheckBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox1ActionPerformed(evt);
            }
        });
        jLayeredPane1.add(jCheckBox1);
        jCheckBox1.setBounds(270, 90, 30, 30);

        getContentPane().add(jLayeredPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 20, 330, 180));

        pack();
    }// </editor-fold>//GEN-END:initComponents
      List<EditarNota> Alumnos;
    private void btn_buscar_pActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_buscar_pActionPerformed
        // TODO add your handling code here:
        String periodo= (String)cmb_periodo_p.getSelectedItem();
        String grado= (String) cmb_grado_p.getSelectedItem();
        String seccion= (String) cmb_seccRF.getSelectedItem();

        GenerarReportes reporte = new GenerarReportes();
        reporte.RP1(grado, seccion, periodo);
        
        
    }//GEN-LAST:event_btn_buscar_pActionPerformed

    private void btn_buscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_buscarActionPerformed
        // TODO add your handling code here:
        String anho= txtAnho.getText();
        String grado= (String) cmb_gradoRF.getSelectedItem();
        String seccion= (String) cmb_seccRF.getSelectedItem();

        GenerarReportes reporte = new GenerarReportes();
        reporte.RF(grado,seccion,anho);

        //JOptionPane.showMessageDialog(rootPane,"G "+grado+" M "+materia+" S "+seccion);
    }//GEN-LAST:event_btn_buscarActionPerformed

    private void jCheckBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox1ActionPerformed
        // TODO add your handling code here:
        if (txtAnho.isEnabled()) {
            txtAnho.setEnabled(false);
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy");
            Date fech = new Date();
            txtAnho.setText(formatter.format(fech));
        }else{
            txtAnho.setEnabled(true);

        }
    }//GEN-LAST:event_jCheckBox1ActionPerformed
    
    
    /* FILTRADO DE MATERIAS, SECCIONES Y GRADOS ASIGNADOS AL MAESTRO*/
    
    private void LlenarSecciones(){
       
        List<String> secciones = sjc.GetSecciones(idLog,con.conn);
         for (String seccion : secciones) {
            cmb_secc_p.addItem(seccion);
            cmb_seccRF.addItem(seccion);
        }
        
    }
     private void LlenarGrados(){
        
        List<String> grados = gjc.GetGrados(idLog,con.conn);
         for (String grado : grados) {
            cmb_grado_p.addItem(grado);
            cmb_gradoRF.addItem(grado);
        }
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_buscar;
    private javax.swing.JButton btn_buscar_p;
    private javax.swing.JComboBox cmb_gradoRF;
    private javax.swing.JComboBox cmb_grado_p;
    private javax.swing.JComboBox cmb_periodo_p;
    private javax.swing.JComboBox cmb_seccRF;
    private javax.swing.JComboBox cmb_secc_p;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JLayeredPane jLayeredPane1;
    private javax.swing.JLayeredPane jLayeredPane2;
    private javax.swing.JLabel lblcontra10;
    private javax.swing.JLabel lblcontra11;
    private javax.swing.JLabel lblcontra12;
    private javax.swing.JLabel lblcontra8;
    private javax.swing.JLabel lblcontra9;
    private javax.swing.JTextField txtAnho;
    // End of variables declaration//GEN-END:variables
}
