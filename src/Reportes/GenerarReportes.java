/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Reportes;

import Acceso_Datos.ConectionDB;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JOptionPane;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author Jorge Villanueva
 */
public class GenerarReportes {
    public GenerarReportes(){

    }

    //RF = Reporte Final
    public void RF(String grado, String seccion, String anho){
        try {
            File miDir = new File (".");
            String ruta = miDir.getCanonicalPath();
            JasperReport report = JasperCompileManager.compileReport(ruta+"\\src\\Reportes\\ReporteFinal.jrxml");

            ConectionDB con = new ConectionDB();
            Map parametros = new HashMap<>();
            parametros.put("grado", grado);
            parametros.put("seccion", seccion);
            parametros.put("anho", anho);
            JasperPrint jp = JasperFillManager.fillReport(report,parametros,con.getconnection());            
            JasperViewer.viewReport(jp,false);            
            JasperPrint print = JasperFillManager.fillReport(report,parametros,con.getconnection());
            
            
//            JasperViewer view = new JasperViewer(print,false);
//            view.setTitle("Reporte");
//            view.setVisible(true);

        } catch (IOException | JRException e) {
            JOptionPane.showMessageDialog(null,"Error: "+e);
        }
    }
    //RP1= Reporte Periodo 1
    public void RP1(String grado, String seccion, String periodo){
        try {
            File miDir = new File (".");
            String ruta = miDir.getCanonicalPath();
            
            JasperReport report = JasperCompileManager.compileReport(ruta+"\\src\\Reportes\\ReporteNotaPeriodo"+periodo+".jrxml");

            ConectionDB con = new ConectionDB();
            Map parametros = new HashMap<>();
            parametros.put("grado", grado);
            parametros.put("seccion", seccion);
            JasperPrint jp = JasperFillManager.fillReport(report,parametros,con.getconnection());            
            JasperViewer.viewReport(jp,false);            
            JasperPrint print = JasperFillManager.fillReport(report,parametros,con.getconnection());
            
            
//            JasperViewer view = new JasperViewer(print,false);
//            view.setTitle("Reporte");
//            view.setVisible(true);

        } catch (IOException | JRException e) {
            JOptionPane.showMessageDialog(null,"Intentelo nuevamente.");
        }
    }
    public void REPROBADOS1(String grado, String seccion, String nombre){
        try {
            File miDir = new File (".");
            String ruta = miDir.getCanonicalPath();
            JasperReport report = JasperCompileManager.compileReport(ruta+"\\src\\Reportes\\Gr_1.jrxml");
            
            ConectionDB con = new ConectionDB();
            Map parametros = new HashMap<>();
            parametros.put("grado", grado);
            parametros.put("seccion", seccion);
            parametros.put("Nombred", nombre);
            
            JasperPrint jp = JasperFillManager.fillReport(report,parametros,con.getconnection());            
            JasperViewer.viewReport(jp,false);
            JasperPrint print = JasperFillManager.fillReport(report,parametros,con.getconnection());
            
        } catch (IOException | JRException e) {
             JOptionPane.showMessageDialog(null,"Error: "+e);
        }
    }
    public void REPROBADOS2(String grado, String seccion, String nombre){
        try {
            File miDir = new File (".");
            String ruta = miDir.getCanonicalPath();
            JasperReport report = JasperCompileManager.compileReport(ruta+"\\src\\Reportes\\Gr_2.jrxml");
            
            ConectionDB con = new ConectionDB();
            Map parametros = new HashMap<>();
            parametros.put("grado", grado);
            parametros.put("seccion", seccion);
            parametros.put("Nombred", nombre);
            
            JasperPrint jp = JasperFillManager.fillReport(report,parametros,con.getconnection());            
            JasperViewer.viewReport(jp,false);
            JasperPrint print = JasperFillManager.fillReport(report,parametros,con.getconnection());
            
        } catch (IOException | JRException e) {
             JOptionPane.showMessageDialog(null,"Error: "+e);
        }
    }
    public void REPROBADOS3(String grado, String seccion, String nombre){
        try {
            File miDir = new File (".");
            String ruta = miDir.getCanonicalPath();
            JasperReport report = JasperCompileManager.compileReport(ruta+"\\src\\Reportes\\Gr_3.jrxml");
            
            ConectionDB con = new ConectionDB();
            Map parametros = new HashMap<>();
            parametros.put("grado", grado);
            parametros.put("seccion", seccion);
            parametros.put("Nombred", nombre);
            
            JasperPrint jp = JasperFillManager.fillReport(report,parametros,con.getconnection());            
            JasperViewer.viewReport(jp,false);
            JasperPrint print = JasperFillManager.fillReport(report,parametros,con.getconnection());
            
        } catch (IOException | JRException e) {
             JOptionPane.showMessageDialog(null,"Error: "+e);
        }
    }
    
    // Reporte Alumnos por asignatura
    
    public void ALumnos(String grado, String seccion, String docente, String materia){
        try {
            File miDir = new File (".");
            String ruta = miDir.getCanonicalPath();
            JasperReport report = JasperCompileManager.compileReport(ruta+"\\src\\Reportes\\ReporteAlumnos.jrxml");
            
            ConectionDB con = new ConectionDB();
            Map parametros = new HashMap<>();
            parametros.put("docente", docente);
            parametros.put("grado", grado);
            parametros.put("materia", materia);
            parametros.put("seccion", seccion);
       
            JasperPrint jp = JasperFillManager.fillReport(report,parametros,con.getconnection());            
            JasperViewer.viewReport(jp,false);
            JasperPrint print = JasperFillManager.fillReport(report,parametros,con.getconnection());
            
        } catch (IOException | JRException e) {
             JOptionPane.showMessageDialog(null,"Error: "+e);
        }
    }
    }
