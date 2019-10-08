/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Views;


import Views.Maestro.Editar_Nota_M;
import Views.Maestro.Subir_Nota;
import Views.Maestro.Ver_Materias;
import java.awt.Dimension;

/**
 *
 * @author Jorge Villanueva
 */
public class Menu_M extends javax.swing.JFrame {

    /**
     * Creates new form Menu
     */
    public String idLog;
    public Menu_M() {  
       
        
        this.setExtendedState(Menu_M.MAXIMIZED_BOTH);
        
        initComponents();
      
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        DesktopPanel = new javax.swing.JDesktopPane();
        jMenuBar1 = new javax.swing.JMenuBar();
        Btn_Notas = new javax.swing.JMenu();
        Btn_Registrar_Notas = new javax.swing.JMenuItem();
        Btn_Editar_notas = new javax.swing.JMenuItem();
        jMenu5 = new javax.swing.JMenu();
        Btn_Ver_Materias = new javax.swing.JMenu();
        Btn_Registrar_materia = new javax.swing.JMenuItem();
        jMenu4 = new javax.swing.JMenu();
        Btn_Reportes = new javax.swing.JMenu();
        Btn_rpt_notas = new javax.swing.JMenuItem();
        Btn_rpt_alumnos = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        jMenu8 = new javax.swing.JMenu();
        jMenu11 = new javax.swing.JMenu();
        jMenu13 = new javax.swing.JMenu();
        jMenu14 = new javax.swing.JMenu();
        jMenu9 = new javax.swing.JMenu();
        jMenu15 = new javax.swing.JMenu();
        jMenu12 = new javax.swing.JMenu();
        jMenu16 = new javax.swing.JMenu();
        jMenu17 = new javax.swing.JMenu();
        jMenu18 = new javax.swing.JMenu();
        jMenu19 = new javax.swing.JMenu();
        jMenu10 = new javax.swing.JMenu();
        Btn_Logout = new javax.swing.JMenu();
        Btn_Salir = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        javax.swing.GroupLayout DesktopPanelLayout = new javax.swing.GroupLayout(DesktopPanel);
        DesktopPanel.setLayout(DesktopPanelLayout);
        DesktopPanelLayout.setHorizontalGroup(
            DesktopPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1269, Short.MAX_VALUE)
        );
        DesktopPanelLayout.setVerticalGroup(
            DesktopPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 623, Short.MAX_VALUE)
        );

        Btn_Notas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/grade.png"))); // NOI18N
        Btn_Notas.setText("Notas");
        Btn_Notas.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N

        Btn_Registrar_Notas.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_N, java.awt.event.InputEvent.CTRL_MASK));
        Btn_Registrar_Notas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/add.png"))); // NOI18N
        Btn_Registrar_Notas.setText("Subir");
        Btn_Registrar_Notas.setToolTipText("Registrar Nota");
        Btn_Registrar_Notas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn_Registrar_NotasActionPerformed(evt);
            }
        });
        Btn_Notas.add(Btn_Registrar_Notas);

        Btn_Editar_notas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/edit.png"))); // NOI18N
        Btn_Editar_notas.setText("Editar");
        Btn_Editar_notas.setToolTipText("Editar Nota");
        Btn_Editar_notas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn_Editar_notasActionPerformed(evt);
            }
        });
        Btn_Notas.add(Btn_Editar_notas);

        jMenuBar1.add(Btn_Notas);
        Btn_Notas.getAccessibleContext().setAccessibleDescription("");

        jMenu5.setText("                ");
        jMenu5.setEnabled(false);
        jMenuBar1.add(jMenu5);

        Btn_Ver_Materias.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/subject.png"))); // NOI18N
        Btn_Ver_Materias.setText("Materias");
        Btn_Ver_Materias.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N

        Btn_Registrar_materia.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_M, java.awt.event.InputEvent.SHIFT_MASK | java.awt.event.InputEvent.CTRL_MASK));
        Btn_Registrar_materia.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/add.png"))); // NOI18N
        Btn_Registrar_materia.setText("Ver materias");
        Btn_Registrar_materia.setToolTipText("Registrar Materia");
        Btn_Registrar_materia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn_Registrar_materiaActionPerformed(evt);
            }
        });
        Btn_Ver_Materias.add(Btn_Registrar_materia);

        jMenuBar1.add(Btn_Ver_Materias);

        jMenu4.setText("                ");
        jMenu4.setEnabled(false);
        jMenuBar1.add(jMenu4);

        Btn_Reportes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/report.png"))); // NOI18N
        Btn_Reportes.setText("Reportes");
        Btn_Reportes.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N

        Btn_rpt_notas.setText("Notas");
        Btn_rpt_notas.setToolTipText("Generar reporte de notas");
        Btn_rpt_notas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn_rpt_notasActionPerformed(evt);
            }
        });
        Btn_Reportes.add(Btn_rpt_notas);

        Btn_rpt_alumnos.setText("Alumnos");
        Btn_rpt_alumnos.setToolTipText("Generar reporte de alumnos");
        Btn_rpt_alumnos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn_rpt_alumnosActionPerformed(evt);
            }
        });
        Btn_Reportes.add(Btn_rpt_alumnos);

        jMenuBar1.add(Btn_Reportes);

        jMenu3.setText("                ");
        jMenu3.setEnabled(false);
        jMenuBar1.add(jMenu3);

        jMenu8.setText("                ");
        jMenu8.setEnabled(false);
        jMenuBar1.add(jMenu8);

        jMenu11.setText("                ");
        jMenu11.setEnabled(false);
        jMenuBar1.add(jMenu11);

        jMenu13.setText("                 ");
        jMenu13.setEnabled(false);
        jMenuBar1.add(jMenu13);

        jMenu14.setText("                ");
        jMenu14.setEnabled(false);
        jMenuBar1.add(jMenu14);

        jMenu9.setText("                ");
        jMenu9.setEnabled(false);
        jMenuBar1.add(jMenu9);

        jMenu15.setText("                ");
        jMenu15.setEnabled(false);
        jMenuBar1.add(jMenu15);

        jMenu12.setText("                ");
        jMenu12.setEnabled(false);
        jMenuBar1.add(jMenu12);

        jMenu16.setText("                ");
        jMenu16.setEnabled(false);
        jMenuBar1.add(jMenu16);

        jMenu17.setText("                ");
        jMenu17.setEnabled(false);
        jMenuBar1.add(jMenu17);

        jMenu18.setText("                ");
        jMenu18.setEnabled(false);

        jMenu19.setText("                ");
        jMenu19.setEnabled(false);
        jMenu18.add(jMenu19);

        jMenuBar1.add(jMenu18);

        jMenu10.setText("                ");
        jMenu10.setEnabled(false);
        jMenuBar1.add(jMenu10);

        Btn_Logout.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/logout.png"))); // NOI18N
        Btn_Logout.setText("Cerrar Sesion");
        Btn_Logout.setToolTipText("");
        Btn_Logout.setDelay(0);
        Btn_Logout.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        Btn_Logout.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        Btn_Logout.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        Btn_Logout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn_LogoutActionPerformed(evt);
            }
        });

        Btn_Salir.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_L, java.awt.event.InputEvent.SHIFT_MASK | java.awt.event.InputEvent.CTRL_MASK));
        Btn_Salir.setText("Salir");
        Btn_Salir.setToolTipText("Cerrar Sesion");
        Btn_Salir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn_SalirActionPerformed(evt);
            }
        });
        Btn_Logout.add(Btn_Salir);

        jMenuBar1.add(Btn_Logout);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(DesktopPanel)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(DesktopPanel)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void Btn_rpt_notasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_rpt_notasActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Btn_rpt_notasActionPerformed

    private void Btn_rpt_alumnosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_rpt_alumnosActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Btn_rpt_alumnosActionPerformed

    private void Btn_Registrar_materiaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_Registrar_materiaActionPerformed
        CerrarHijos();
        Ver_Materias m = new Ver_Materias();
        m.setIdLog(idLog);
        m.setSize(sisze());
        DesktopPanel.add(m);
        
    }//GEN-LAST:event_Btn_Registrar_materiaActionPerformed

    private void Btn_LogoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_LogoutActionPerformed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_Btn_LogoutActionPerformed

    private void Btn_SalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_SalirActionPerformed
        // TODO add your handling code here:
        Login login = new Login();
        this.dispose();
        login.show();
    }//GEN-LAST:event_Btn_SalirActionPerformed

    private void Btn_Editar_notasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_Editar_notasActionPerformed
        // TODO add your handling code here:
        CerrarHijos();
        Editar_Nota_M nota = new Editar_Nota_M();    
        nota.setIdLog(idLog);
        nota.setSize(sisze());
        DesktopPanel.add(nota);
    }//GEN-LAST:event_Btn_Editar_notasActionPerformed
    public Dimension sisze(){
        Dimension size = this.getSize();        
        return size;        
    }
    public void CerrarHijos(){
       DesktopPanel.removeAll();
       DesktopPanel.updateUI();
    }
    private void Btn_Registrar_NotasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_Registrar_NotasActionPerformed
        // TODO add your handling code here:
        CerrarHijos(); 
        Subir_Nota nota = new Subir_Nota();
        nota.setIdLog(idLog);
        nota.setSize(sisze());
        DesktopPanel.add(nota);
        
    }//GEN-LAST:event_Btn_Registrar_NotasActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Menu_M.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Menu_M.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Menu_M.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Menu_M.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Menu_M().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem Btn_Editar_notas;
    private javax.swing.JMenu Btn_Logout;
    private javax.swing.JMenu Btn_Notas;
    private javax.swing.JMenuItem Btn_Registrar_Notas;
    private javax.swing.JMenuItem Btn_Registrar_materia;
    private javax.swing.JMenu Btn_Reportes;
    private javax.swing.JMenuItem Btn_Salir;
    private javax.swing.JMenu Btn_Ver_Materias;
    private javax.swing.JMenuItem Btn_rpt_alumnos;
    private javax.swing.JMenuItem Btn_rpt_notas;
    private javax.swing.JDesktopPane DesktopPanel;
    private javax.swing.JMenu jMenu10;
    private javax.swing.JMenu jMenu11;
    private javax.swing.JMenu jMenu12;
    private javax.swing.JMenu jMenu13;
    private javax.swing.JMenu jMenu14;
    private javax.swing.JMenu jMenu15;
    private javax.swing.JMenu jMenu16;
    private javax.swing.JMenu jMenu17;
    private javax.swing.JMenu jMenu18;
    private javax.swing.JMenu jMenu19;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenu jMenu5;
    private javax.swing.JMenu jMenu8;
    private javax.swing.JMenu jMenu9;
    private javax.swing.JMenuBar jMenuBar1;
    // End of variables declaration//GEN-END:variables
}
