package com.cefafa.jasper;

import java.sql.Connection;
import java.util.Map;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletResponse;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.export.JRPdfExporter;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.export.SimpleExporterInput;
import net.sf.jasperreports.export.SimpleOutputStreamExporterOutput;

public abstract class AbstractJasper {
    //propiedades
    private static JasperReport report;
    private static JasperPrint reportfilled;
    
    //Metodo para creacion de reporte de Factura con parametros
      public static void createReport(Connection conn, String path,Map parameters){
          try{
             report =  (JasperReport)JRLoader.loadObjectFromFile(path);
             //llenado del reporte
             reportfilled = JasperFillManager.fillReport(report, parameters, conn);
          }catch(Exception e){
              e.printStackTrace();
          }
          
      }
      
      
      //Metodo para exportar en formato PDF y mostrarlo en el navegador
      public static void exportToPdfWeb(){
          try{
              HttpServletResponse httpServletResponse  = (HttpServletResponse)FacesContext.getCurrentInstance().getExternalContext().getResponse();
              httpServletResponse.setContentType("application/pdf");
              JRPdfExporter jrPdfExporter = new JRPdfExporter();
              
              jrPdfExporter.setExporterInput(new SimpleExporterInput(reportfilled));
              
              //indicamos como salida del exporter el flujo de salida
              jrPdfExporter.setExporterOutput(new SimpleOutputStreamExporterOutput(httpServletResponse.getOutputStream()));
              jrPdfExporter.exportReport();
          }catch(Exception e){
              e.printStackTrace();
          }
      }
      
       public static void exportToPdfWeb2(){
          try{
              HttpServletResponse httpServletResponse  = (HttpServletResponse)FacesContext.getCurrentInstance().getExternalContext().getResponse();
              httpServletResponse.setContentType("application/pdf");
              JasperExportManager.exportReportToPdfStream(reportfilled, httpServletResponse.getOutputStream());
          }catch(Exception e){
              e.printStackTrace();
          }
      }
    
}
