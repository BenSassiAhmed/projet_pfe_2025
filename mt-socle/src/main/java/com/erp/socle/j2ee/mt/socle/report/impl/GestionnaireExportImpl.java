package com.erp.socle.j2ee.mt.socle.report.impl;

import java.io.ByteArrayOutputStream;

import javax.servlet.http.HttpServletResponse;

import com.erp.socle.j2ee.mt.socle.report.GestionnaireExport;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRExporterParameter;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.export.JRPdfExporter;
import net.sf.jasperreports.engine.export.JRXlsAbstractExporterParameter;
import net.sf.jasperreports.engine.export.JRXlsExporter;



/**
 * Classe permettant d'exporter le report en format choisi
 * @author rkhaskho
 *
 */
public class GestionnaireExportImpl 
//implements GestionnaireExport
{

	public static final String MEDIA_TYPE_EXCEL = "application/vnd.ms-excel";
	public static final String MEDIA_TYPE_PDF = "application/pdf";
	public static final String EXTENSION_TYPE_EXCEL = "xls";
	public static final String EXTENSION_TYPE_PDF = "pdf";
	
	/**
	 * Methode d'export
	 * @param type
	 * @param jp
	 * @param response
	 * @param baos
	 * @return
	 */
	public static HttpServletResponse export(String type, 
			JasperPrint jp, 
			HttpServletResponse response,
			ByteArrayOutputStream baos,String fileName) {
		
		if (type.equalsIgnoreCase(EXTENSION_TYPE_EXCEL)) {
			// Export to output stream
			exportXls(jp, baos);
			 
			// Set our response properties
			// Here you can declare a custom filename
			response.setHeader("Content-Disposition", "inline; filename=" + fileName+"."+type);
			
			// Set content type
			response.setContentType(MEDIA_TYPE_EXCEL);
			response.setContentLength(baos.size());
			
			return response;
		}
		
		if (type.equalsIgnoreCase(EXTENSION_TYPE_PDF)) {
			// Export to output stream
			exportPdf(jp, baos);
			 
			// Set our response properties
	
			response.setHeader("Content-Disposition", "inline; filename=" + fileName+"."+type);
			
			// Set content type
			response.setContentType(MEDIA_TYPE_PDF);
			response.setContentLength(baos.size());
			
			return response;
			
		} 
		
		throw new RuntimeException("No type set for type " + type);
	}
	
	/**
	 * Format XLS
	 * 
	 * @param jp
	 * @param baos
	 */
	public static void exportXls(JasperPrint jp, ByteArrayOutputStream baos) {
		// Create a JRXlsExporter instance
		JRXlsExporter exporter = new JRXlsExporter();
		 
		// Here we assign the parameters jp and baos to the exporter
		exporter.setParameter(JRExporterParameter.JASPER_PRINT, jp);
		exporter.setParameter(JRExporterParameter.OUTPUT_STREAM, baos);
		 
		// Excel specific parameters
		exporter.setParameter(JRXlsAbstractExporterParameter.IS_ONE_PAGE_PER_SHEET, Boolean.FALSE);
		exporter.setParameter(JRXlsAbstractExporterParameter.IS_REMOVE_EMPTY_SPACE_BETWEEN_ROWS, Boolean.TRUE);
		exporter.setParameter(JRXlsAbstractExporterParameter.IS_WHITE_PAGE_BACKGROUND, Boolean.FALSE);
		 
		try {
			exporter.exportReport();
			
		} catch (JRException e) {
			throw new RuntimeException(e);
		}
	}
	
	/**
	 * Format PDF
	 * 
	 * @param jp
	 * @param baos
	 */
	public static void exportPdf(JasperPrint jp, ByteArrayOutputStream baos) {
		// Create a JRXlsExporter instance
		JRPdfExporter exporter = new JRPdfExporter();
		 
		// Here we assign the parameters jp and baos to the exporter
		exporter.setParameter(JRExporterParameter.JASPER_PRINT, jp);
		exporter.setParameter(JRExporterParameter.OUTPUT_STREAM, baos);
		 
		try {
			exporter.exportReport();
			
		} catch (JRException e) {
			throw new RuntimeException(e);
		}
	}
	
}
