/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Reportes;

import Acceso_Datos.ConectionDB;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.swing.JOptionPane;
import net.sf.jasperreports.engine.JREmptyDataSource;
import net.sf.jasperreports.engine.JRExporterParameter;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.export.JRPdfExporter;
import net.sf.jasperreports.engine.export.JRPdfExporterParameter;
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
               JasperPrint rpt = JasperFillManager.fillReport(reporte,parametros,ConectionDB.getconnection());
               JasperViewer jv = new JasperViewer(rpt,false);
               jv.setTitle("Reporte de Notas Trimestral");
               jv.setVisible(true);          
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"error al realizar el reporte"+ e);
        }        
    }
}
