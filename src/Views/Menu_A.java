/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Views;

import Views.Administrador.Asignar_Materia;
import Views.Administrador.Crear_Alumno;
import Views.Administrador.Crear_Maestro;

import Views.Administrador.Crear_Materia;
import Views.Administrador.Crear_Nota;
import Views.Administrador.Crear_Seccion;

import Views.Administrador.Editar_Alumno;
import Views.Administrador.Editar_Encargado;
import Views.Administrador.Editar_Maestro;
import Views.Administrador.Editar_Materia;
import Views.Administrador.Editar_Nota;
import java.awt.Dimension;
import java.beans.PropertyVetoException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JInternalFrame;
import javax.swing.plaf.DesktopPaneUI;
import javax.swing.plaf.basic.BasicDesktopPaneUI;

/**
 *
 * @author Jorge Villanueva
 */
public class Menu_A extends javax.swing.JFrame {

    /**
     * Creates new form Menu
     */
    public Menu_A() {  
       
        
        this.setExtendedState(Menu_A.MAXIMIZED_BOTH);
        
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
        Btn_Alumnos = new javax.swing.JMenu();
        Btn_Registrar_alumno = new javax.swing.JMenuItem();
        Btn_Editar_alumno = new javax.swing.JMenuItem();
        Btn_Editar_Encargado = new javax.swing.JMenuItem();
        jMenu7 = new javax.swing.JMenu();
        Btn_Asignar_Materias = new javax.swing.JMenu();
        Btn_Registrar_maestros = new javax.swing.JMenuItem();
        Btn_Editar_maestros = new javax.swing.JMenuItem();
        Btn_Editar_maestros1 = new javax.swing.JMenuItem();
        jMenu6 = new javax.swing.JMenu();
        Btn_Notas = new javax.swing.JMenu();
        Btn_Registrar_Notas = new javax.swing.JMenuItem();
        Btn_Editar_notas = new javax.swing.JMenuItem();
        jMenu5 = new javax.swing.JMenu();
        Btn_Materias = new javax.swing.JMenu();
        Btn_Registrar_materia = new javax.swing.JMenuItem();
        Btn_Editar_materias = new javax.swing.JMenuItem();
        Btn_Registrar_seccion = new javax.swing.JMenuItem();
        jMenu4 = new javax.swing.JMenu();
        Btn_Reportes = new javax.swing.JMenu();
        Btn_rpt_notas = new javax.swing.JMenuItem();
        Btn_rpt_alumnos = new javax.swing.JMenuItem();
        Btn_rpt_maestros = new javax.swing.JMenuItem();
        Btn_rpt_materias = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        Btn_Backup = new javax.swing.JMenu();
        Btn_importar_bkup = new javax.swing.JMenuItem();
        Btn_exportar_bkup = new javax.swing.JMenuItem();
        jMenu8 = new javax.swing.JMenu();
        jMenu11 = new javax.swing.JMenu();
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

        Btn_Alumnos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/student.png"))); // NOI18N
        Btn_Alumnos.setText("Alumnos");
        Btn_Alumnos.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N

        Btn_Registrar_alumno.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_A, java.awt.event.InputEvent.CTRL_MASK));
        Btn_Registrar_alumno.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/add.png"))); // NOI18N
        Btn_Registrar_alumno.setText("Registrar");
        Btn_Registrar_alumno.setToolTipText("Registrar Alumno");
        Btn_Registrar_alumno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn_Registrar_alumnoActionPerformed(evt);
            }
        });
        Btn_Alumnos.add(Btn_Registrar_alumno);

        Btn_Editar_alumno.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/edit.png"))); // NOI18N
        Btn_Editar_alumno.setText("Editar");
        Btn_Editar_alumno.setToolTipText("Editar Alumno");
        Btn_Editar_alumno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn_Editar_alumnoActionPerformed(evt);
            }
        });
        Btn_Alumnos.add(Btn_Editar_alumno);

        Btn_Editar_Encargado.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/edit.png"))); // NOI18N
        Btn_Editar_Encargado.setText("Editar Encargado");
        Btn_Editar_Encargado.setToolTipText("Editar Alumno");
        Btn_Editar_Encargado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn_Editar_EncargadoActionPerformed(evt);
            }
        });
        Btn_Alumnos.add(Btn_Editar_Encargado);

        jMenuBar1.add(Btn_Alumnos);
        Btn_Alumnos.getAccessibleContext().setAccessibleDescription("");

        jMenu7.setText("                ");
        jMenu7.setEnabled(false);
        jMenuBar1.add(jMenu7);

        Btn_Asignar_Materias.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/teacher.png"))); // NOI18N
        Btn_Asignar_Materias.setText("Maestros");
        Btn_Asignar_Materias.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N

        Btn_Registrar_maestros.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_M, java.awt.event.InputEvent.CTRL_MASK));
        Btn_Registrar_maestros.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/add.png"))); // NOI18N
        Btn_Registrar_maestros.setText("Registrar");
        Btn_Registrar_maestros.setToolTipText("Registrar Maestro");
        Btn_Registrar_maestros.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn_Registrar_maestrosActionPerformed(evt);
            }
        });
        Btn_Asignar_Materias.add(Btn_Registrar_maestros);

        Btn_Editar_maestros.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/edit.png"))); // NOI18N
        Btn_Editar_maestros.setText("Editar");
        Btn_Editar_maestros.setToolTipText("Editar Maestro");
        Btn_Editar_maestros.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn_Editar_maestrosActionPerformed(evt);
            }
        });
        Btn_Asignar_Materias.add(Btn_Editar_maestros);

        Btn_Editar_maestros1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/add.png"))); // NOI18N
        Btn_Editar_maestros1.setText("Asignar Materias");
        Btn_Editar_maestros1.setToolTipText("Editar Maestro");
        Btn_Editar_maestros1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn_Editar_maestros1ActionPerformed(evt);
            }
        });
        Btn_Asignar_Materias.add(Btn_Editar_maestros1);

        jMenuBar1.add(Btn_Asignar_Materias);
        Btn_Asignar_Materias.getAccessibleContext().setAccessibleDescription("");

        jMenu6.setText("                ");
        jMenu6.setEnabled(false);
        jMenuBar1.add(jMenu6);

        Btn_Notas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/grade.png"))); // NOI18N
        Btn_Notas.setText("Notas");
        Btn_Notas.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N

        Btn_Registrar_Notas.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_N, java.awt.event.InputEvent.CTRL_MASK));
        Btn_Registrar_Notas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/add.png"))); // NOI18N
        Btn_Registrar_Notas.setText("Registrar");
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

        Btn_Materias.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/subject.png"))); // NOI18N
        Btn_Materias.setText("Materias");
        Btn_Materias.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N

        Btn_Registrar_materia.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_M, java.awt.event.InputEvent.SHIFT_MASK | java.awt.event.InputEvent.CTRL_MASK));
        Btn_Registrar_materia.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/add.png"))); // NOI18N
        Btn_Registrar_materia.setText("Registrar");
        Btn_Registrar_materia.setToolTipText("Registrar Materia");
        Btn_Registrar_materia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn_Registrar_materiaActionPerformed(evt);
            }
        });
        Btn_Materias.add(Btn_Registrar_materia);

        Btn_Editar_materias.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/edit.png"))); // NOI18N
        Btn_Editar_materias.setText("Editar");
        Btn_Editar_materias.setToolTipText("Editar Materia");
        Btn_Editar_materias.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn_Editar_materiasActionPerformed(evt);
            }
        });
        Btn_Materias.add(Btn_Editar_materias);

        Btn_Registrar_seccion.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/add.png"))); // NOI18N
        Btn_Registrar_seccion.setText("Registrar Sección");
        Btn_Registrar_seccion.setToolTipText("Registrar Sección");
        Btn_Registrar_seccion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn_Registrar_seccionActionPerformed(evt);
            }
        });
        Btn_Materias.add(Btn_Registrar_seccion);

        jMenuBar1.add(Btn_Materias);

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

        Btn_rpt_maestros.setText("Maestros");
        Btn_rpt_maestros.setToolTipText("Generar reporte de maestros");
        Btn_rpt_maestros.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn_rpt_maestrosActionPerformed(evt);
            }
        });
        Btn_Reportes.add(Btn_rpt_maestros);

        Btn_rpt_materias.setText("Materias");
        Btn_rpt_materias.setToolTipText("Generar reporte de materias");
        Btn_rpt_materias.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn_rpt_materiasActionPerformed(evt);
            }
        });
        Btn_Reportes.add(Btn_rpt_materias);

        jMenuBar1.add(Btn_Reportes);

        jMenu3.setText("                ");
        jMenu3.setEnabled(false);
        jMenuBar1.add(jMenu3);

        Btn_Backup.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/backup.png"))); // NOI18N
        Btn_Backup.setText("Respaldo");
        Btn_Backup.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        Btn_Backup.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        Btn_Backup.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);

        Btn_importar_bkup.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_I, java.awt.event.InputEvent.CTRL_MASK));
        Btn_importar_bkup.setText("Importar");
        Btn_importar_bkup.setToolTipText("Restaurar datos");
        Btn_Backup.add(Btn_importar_bkup);

        Btn_exportar_bkup.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_E, java.awt.event.InputEvent.CTRL_MASK));
        Btn_exportar_bkup.setText("Exportar");
        Btn_exportar_bkup.setToolTipText("Generar respaldo de datos");
        Btn_exportar_bkup.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn_exportar_bkupActionPerformed(evt);
            }
        });
        Btn_Backup.add(Btn_exportar_bkup);

        jMenuBar1.add(Btn_Backup);

        jMenu8.setText("                ");
        jMenu8.setEnabled(false);
        jMenuBar1.add(jMenu8);

        jMenu11.setText("                ");
        jMenu11.setEnabled(false);
        jMenuBar1.add(jMenu11);

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

    private void Btn_Editar_materiasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_Editar_materiasActionPerformed
        // TODO add your handling code here:
        CerrarHijos();
        Editar_Materia materia = new Editar_Materia();     
         materia.setSize(sisze());
        DesktopPanel.add(materia);
    }//GEN-LAST:event_Btn_Editar_materiasActionPerformed
    public void CerrarHijos(){
       DesktopPanel.removeAll();
       DesktopPanel.updateUI();
    }
    public Dimension sisze(){
        Dimension size = this.getSize();        
        return size;        
    }
    private void Btn_exportar_bkupActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_exportar_bkupActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Btn_exportar_bkupActionPerformed

    private void Btn_rpt_notasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_rpt_notasActionPerformed
        // TODO add your handling code here:
  
    }//GEN-LAST:event_Btn_rpt_notasActionPerformed

    private void Btn_rpt_alumnosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_rpt_alumnosActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Btn_rpt_alumnosActionPerformed

    private void Btn_rpt_maestrosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_rpt_maestrosActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Btn_rpt_maestrosActionPerformed

    private void Btn_rpt_materiasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_rpt_materiasActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Btn_rpt_materiasActionPerformed

    private void Btn_Registrar_maestrosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_Registrar_maestrosActionPerformed
        // TODO add your handling code here:
        CerrarHijos();
       Crear_Maestro m = new Crear_Maestro();       
       DesktopPanel.add(m);
       Dimension desktopSize = DesktopPanel.getSize();
        Dimension FrameSize = m.getSize();
        m.setLocation((desktopSize.width - FrameSize.width)/2, (desktopSize.height- FrameSize.height)/2);
        m.show();
        
    }//GEN-LAST:event_Btn_Registrar_maestrosActionPerformed

    
    private void Btn_Registrar_materiaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_Registrar_materiaActionPerformed
         CerrarHijos();
        Crear_Materia m = new Crear_Materia();
        DesktopPanel.add(m);
       
        
        Dimension desktopSize = DesktopPanel.getSize();
        Dimension FrameSize = m.getSize();
        m.setLocation((desktopSize.width - FrameSize.width)/2, (desktopSize.height- FrameSize.height)/2);
        m.show();
    }//GEN-LAST:event_Btn_Registrar_materiaActionPerformed

    private void Btn_Registrar_alumnoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_Registrar_alumnoActionPerformed
        // TODO add your handling code here:
         CerrarHijos();
        Crear_Alumno alumno = new Crear_Alumno();
         alumno.setSize(sisze());

        DesktopPanel.add(alumno);
    }//GEN-LAST:event_Btn_Registrar_alumnoActionPerformed

    private void Btn_Registrar_NotasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_Registrar_NotasActionPerformed
        // TODO add your handling code here:
         CerrarHijos();
        Crear_Nota nota = new Crear_Nota();
         nota.setSize(sisze());
        DesktopPanel.add(nota);
    }//GEN-LAST:event_Btn_Registrar_NotasActionPerformed

    private void Btn_LogoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_LogoutActionPerformed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_Btn_LogoutActionPerformed

    private void Btn_SalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_SalirActionPerformed
        // TODO add your handling code here:
        Login login = new Login();
        this.dispose();
        login.show();
    }//GEN-LAST:event_Btn_SalirActionPerformed

    private void Btn_Editar_alumnoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_Editar_alumnoActionPerformed
        // TODO add your handling code here:
         CerrarHijos();
        Editar_Alumno alumn = new Editar_Alumno();
         alumn.setSize(sisze());
        DesktopPanel.add(alumn);
    }//GEN-LAST:event_Btn_Editar_alumnoActionPerformed

    private void Btn_Editar_maestrosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_Editar_maestrosActionPerformed
        // TODO add your handling code here:
         CerrarHijos();
        Editar_Maestro em= new Editar_Maestro();
         em.setSize(sisze());
        DesktopPanel.add(em);
    }//GEN-LAST:event_Btn_Editar_maestrosActionPerformed

    private void Btn_Registrar_seccionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_Registrar_seccionActionPerformed
        // TODO add your handling code here:
         CerrarHijos();
        Crear_Seccion sec = new Crear_Seccion();
        DesktopPanel.add(sec);
        Dimension desktopSize = DesktopPanel.getSize();
        Dimension FrameSize = sec.getSize();
        sec.setLocation((desktopSize.width - FrameSize.width)/2, (desktopSize.height- FrameSize.height)/2);
        sec.show();
    }//GEN-LAST:event_Btn_Registrar_seccionActionPerformed

    private void Btn_Editar_notasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_Editar_notasActionPerformed
        // TODO add your handling code here:
         CerrarHijos();
        Editar_Nota nota = new Editar_Nota();
         nota.setSize(sisze());
        DesktopPanel.add(nota);
    }//GEN-LAST:event_Btn_Editar_notasActionPerformed

    private void Btn_Editar_maestros1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_Editar_maestros1ActionPerformed
        // TODO add your handling code here:
         CerrarHijos();
        Asignar_Materia materia = new Asignar_Materia();
         materia.setSize(sisze());
        DesktopPanel.add(materia);
    }//GEN-LAST:event_Btn_Editar_maestros1ActionPerformed

    private void Btn_Editar_EncargadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_Editar_EncargadoActionPerformed
        // TODO add your handling code here:
         CerrarHijos();
        Editar_Encargado encargado = new  Editar_Encargado();
         encargado.setSize(sisze());
         DesktopPanel.add(encargado);
    }//GEN-LAST:event_Btn_Editar_EncargadoActionPerformed

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
            java.util.logging.Logger.getLogger(Menu_A.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Menu_A.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Menu_A.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Menu_A.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Menu_A().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu Btn_Alumnos;
    private javax.swing.JMenu Btn_Asignar_Materias;
    private javax.swing.JMenu Btn_Backup;
    private javax.swing.JMenuItem Btn_Editar_Encargado;
    private javax.swing.JMenuItem Btn_Editar_alumno;
    private javax.swing.JMenuItem Btn_Editar_maestros;
    private javax.swing.JMenuItem Btn_Editar_maestros1;
    private javax.swing.JMenuItem Btn_Editar_materias;
    private javax.swing.JMenuItem Btn_Editar_notas;
    private javax.swing.JMenu Btn_Logout;
    private javax.swing.JMenu Btn_Materias;
    private javax.swing.JMenu Btn_Notas;
    private javax.swing.JMenuItem Btn_Registrar_Notas;
    private javax.swing.JMenuItem Btn_Registrar_alumno;
    private javax.swing.JMenuItem Btn_Registrar_maestros;
    private javax.swing.JMenuItem Btn_Registrar_materia;
    private javax.swing.JMenuItem Btn_Registrar_seccion;
    private javax.swing.JMenu Btn_Reportes;
    private javax.swing.JMenuItem Btn_Salir;
    private javax.swing.JMenuItem Btn_exportar_bkup;
    private javax.swing.JMenuItem Btn_importar_bkup;
    private javax.swing.JMenuItem Btn_rpt_alumnos;
    private javax.swing.JMenuItem Btn_rpt_maestros;
    private javax.swing.JMenuItem Btn_rpt_materias;
    private javax.swing.JMenuItem Btn_rpt_notas;
    private javax.swing.JDesktopPane DesktopPanel;
    private javax.swing.JMenu jMenu10;
    private javax.swing.JMenu jMenu11;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenu jMenu5;
    private javax.swing.JMenu jMenu6;
    private javax.swing.JMenu jMenu7;
    private javax.swing.JMenu jMenu8;
    private javax.swing.JMenuBar jMenuBar1;
    // End of variables declaration//GEN-END:variables
}
