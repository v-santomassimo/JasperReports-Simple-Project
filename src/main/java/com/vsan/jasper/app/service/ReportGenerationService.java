package com.vsan.jasper.app.service;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;

import com.vsan.jasper.app.model.AnagraficaBean;
import com.vsan.jasper.app.repository.AnagraficaRepository;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.view.JasperViewer;

@Service
public class ReportGenerationService {
	
	private final String PATH = "C:\\Users\\User\\Desktop\\";
	
	@Autowired
	private AnagraficaRepository repository;
	
	
	public String generateReport() throws FileNotFoundException, JRException {
		//Fetch all anagrafica from DB:
		List<AnagraficaBean> allAnagrafica = repository.findAll();
		
		//load data and compile it
		File file = ResourceUtils.getFile("classpath:report/anagrafica.jrxml");
		JasperReport jsReport = JasperCompileManager.compileReport(file.getAbsolutePath());
		JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(allAnagrafica);
		Map<String, Object> parameters = new HashMap<>();
		parameters.put("createdBy", "User");
		
		JasperPrint print = JasperFillManager.fillReport(jsReport, parameters, dataSource);
		
		JasperViewer.viewReport (print);
		
		JasperExportManager.exportReportToPdfFile(print, PATH+"anagraficaReport.pdf");
		return "Report generato : "+PATH;
	}

}
