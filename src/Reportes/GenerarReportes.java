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
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author chris
 */
public class GenerarReportes {
    public GenerarReportes(){
    
    }
    
    public void RF(String grado, String seccion){
        try {
            File miDir = new File (".");
            String ruta = miDir.getCanonicalPath();
            JasperReport report = JasperCompileManager.compileReport(ruta+"\\src\\Reportes\\RF.jrxml");

            ConectionDB con = new ConectionDB();
            Map parametros = new HashMap<>();
            parametros.put("Grado", grado);
            parametros.put("Sec", seccion);    
            JasperPrint jp = JasperFillManager.fillReport(report,parametros,con.getconnection());
            JasperViewer.viewReport(jp,false);
//            JasperPrint print = JasperFillManager.fillReport(report,parametros,con.getconnection());
//            
//            JasperViewer view = new JasperViewer(print,false);
//            view.setTitle("Reporte");
//            view.setVisible(true);
            
        } catch (IOException | JRException e) {
            JOptionPane.showMessageDialog(null,"Error: "+e);
        }
    }
//    public void ReporteTrimestralAdmin( String dSec, String nAlum){
//        try {              
//            JasperReport reporte = JasperCompileManager.compileReport("C:\\Users\\chris\\Documents\\NetBeansProjects\\ControlDeNotas-JJB\\src\\ReporteTrimestral.jasper");                                 
//            ConectionDB con = new ConectionDB();
//            Map<String, String> parametros = new HashMap<>();                             
//            parametros.put("dSec", dSec);
//            parametros.put("nAlum", nAlum);
//            
//            JasperPrint jp = JasperFillManager.fillReport(reporte,parametros,con.getconnection());
//               JasperPrint rpt = JasperFillManager.fillReport(reporte,parametros,con.getconnection());
//               JasperViewer jv = new JasperViewer(rpt,false);
//               jv.setTitle("Reporte de Notas Trimestral");
//               jv.setVisible(true);          
//        } catch (Exception e) {
//            JOptionPane.showMessageDialog(null,"error al realizar el reporte"+ e);
//        } 
//        
//        
//    }
//    
//    public void ReporteTrimestral(String periodo, String grado, String seccion){
//        try {
//            File miDir = new File (".");
//            String ruta = miDir.getCanonicalPath();
//            JasperReport report = (JasperReport) JRLoader.loadObject(ruta+"\\src\\Reportes\\ReportePorTrimestre.jasper");
//
//            ConectionDB con = new ConectionDB();
//            Map parametros = new HashMap<>();
//            parametros.put("per", periodo);
//            parametros.put("grad", grado);
//            parametros.put("sec", seccion);            
//            JasperPrint print = JasperFillManager.fillReport(report,parametros,con.getconnection());
//            
//            JasperViewer view = new JasperViewer(print,false);
//            view.setTitle("Reporte");
//            view.setVisible(true);
//            
//        } catch (Exception e) {
//            JOptionPane.showMessageDialog(null,"Error: "+e);
//        }
//    }
//    
//    public void ReporteMateria(String Nombrem){
//        try {
//            File miDir = new File(".");
//            String Ruta = miDir.getCanonicalPath();
//            JasperReport report = (JasperReport) JRLoader.loadObject(Ruta+"\\src\\Reportes\\ReporteMaterias.jasper");
//            ConectionDB con = new ConectionDB();
//            
//            Map parametro = new HashMap();
//            parametro.put("Nombrem", Nombrem);
//            JasperPrint print = JasperFillManager.fillReport(report, parametro,con.getconnection());
//            
//            JasperViewer view = new JasperViewer(print,false);
//            view.setTitle("ReporteMaterias");
//            view.setVisible(true);
//        } catch (Exception e) {
//            JOptionPane.showMessageDialog(null,"Error: "+e);
//        }
//    }
//    public void ReporteReprobados(String Nombresec, String per, String Nombred,String Grado){
//        try {
//            File miDir = new File(".");
//            String Ruta =miDir.getCanonicalPath();
//            JasperReport repor = (JasperReport) JRLoader.loadObject(Ruta+"\\src\\Reportes\\ReporteReprobados.jasper");
//            ConectionDB con = new ConectionDB();
//            
//            Map parametros = new HashMap<>();
//            parametros.put("Nombresec", Nombresec);
//            parametros.put("per", per);
//            parametros.put("Nombred", Nombred);
//            parametros.put("Grado", Grado);
//            JasperPrint print = JasperFillManager.fillReport(repor, parametros,con.getconnection());
//            
//            JasperViewer view = new JasperViewer(print,false);
//            view.setTitle("Reprobados");
//            view.setVisible(true);
//         
//        } catch (Exception e) {
//            JOptionPane.showMessageDialog(null,"Error: "+e);
//        }
//    }
//    
//    public void ReporteReprobadosM(String Nombresec, String per, String Nombred,String Grado){
//        try {
//            File miDir = new File(".");
//            String Ruta =miDir.getCanonicalPath();
//            JasperReport repor = (JasperReport) JRLoader.loadObject(Ruta+"\\src\\Reportes\\ReporteReprobados.jasper");
//            ConectionDB con = new ConectionDB();
//            
//            Map parametros = new HashMap<>();
//            parametros.put("Nombresec", Nombresec);
//            parametros.put("per", per);
//            parametros.put("Nombred", Nombred);
//            parametros.put("Grado", Grado);
//            JasperPrint print = JasperFillManager.fillReport(repor, parametros,con.getconnection());
//            
//            JasperViewer view = new JasperViewer(print,false);
//            view.setTitle("Reprobados");
//            view.setVisible(true);
//         
//        } catch (Exception e) {
//            JOptionPane.showMessageDialog(null,"Error: "+e);
//        }
//    }
//    
//    public void ReporteAlumnos(String sec, String grado, String nombred, String nombremat){
//        try {
//            File miDir = new File(".");
//            String Ruta =miDir.getCanonicalPath();
//            JasperReport repor = (JasperReport) JRLoader.loadObject(Ruta+"\\src\\Reportes\\ReporteAlumnos.jasper");
//            ConectionDB con = new ConectionDB();
//            
//            Map parametros = new HashMap<>();
//            parametros.put("sec", sec);
//             parametros.put("grado",grado );
//            parametros.put("nombred", nombred);
//            parametros.put("nombremat", nombremat);
//            JasperPrint print = JasperFillManager.fillReport(repor, parametros,con.getconnection());
//            
//            JasperViewer view = new JasperViewer(print,false);
//            view.setTitle("Alumnos");
//            view.setVisible(true);
//         
//        } catch (Exception e) {
//            JOptionPane.showMessageDialog(null,"Error: "+e);
//        }
//    }
}
