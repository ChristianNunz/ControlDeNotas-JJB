/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Reportes;

import Acceso_Datos.ConectionDB;
import java.io.File;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JOptionPane;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author chris
 */
public class GenerarReportes {
    public GenerarReportes(){
    
    }
    
    public void ReporteTrimestralAdmin( String dSec, String nAlum){
        try {              
            JasperReport reporte = (JasperReport) JRLoader.loadObject("C:\\Users\\chris\\Documents\\NetBeansProjects\\ControlDeNotas-JJB\\src\\ReporteTrimestral.jasper");                                 
           Map<String, String> parametros = new HashMap<>();                             
            parametros.put("dSec", dSec);
            parametros.put("nAlum", nAlum);
            ConectionDB con = new ConectionDB();
               JasperPrint rpt = JasperFillManager.fillReport(reporte,parametros,con.getconnection());
               JasperViewer jv = new JasperViewer(rpt,false);
               jv.setTitle("Reporte de Notas Trimestral");
               jv.setVisible(true);          
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"error al realizar el reporte"+ e);
        } 
        
        
    }
    
    public void MiPrimeroReporte(String periodo, String grado, String seccion){
        try {
            File miDir = new File (".");
            String ruta = miDir.getCanonicalPath();
            JasperReport report = (JasperReport) JRLoader.loadObject(ruta+"\\src\\Reportes\\ReportePorTrimestre.jasper");
            
            ConectionDB con = new ConectionDB();
            Map parametros = new HashMap<>();
            parametros.put("per", periodo);
            parametros.put("gra", grado);
            parametros.put("sec", seccion);            
            JasperPrint print = JasperFillManager.fillReport(report,parametros,con.getconnection());
            
            JasperViewer view = new JasperViewer(print,false);
            view.setTitle("Reporte");
            view.setVisible(true);
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"Error: "+e);
        }
    }
}
