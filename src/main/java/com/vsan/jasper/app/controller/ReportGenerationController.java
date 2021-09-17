package com.vsan.jasper.app.controller;

import java.io.FileNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vsan.jasper.app.service.ReportGenerationService;

import net.sf.jasperreports.engine.JRException;

@RestController
@RequestMapping("jasper")
public class ReportGenerationController {
	
	@Autowired
	private ReportGenerationService service;
	
	@GetMapping("/report")
	public String generatePdfReport() {
		try {
			return service.generateReport();
		} catch (FileNotFoundException | JRException e) {
			return e.getMessage();
		}
		
	}

}
