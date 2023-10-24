package com.javamedical.medicalapp;

import com.itextpdf.html2pdf.HtmlConverter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

import java.io.File;

@SpringBootApplication(exclude ={SecurityAutoConfiguration.class})
public class MedicalAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(MedicalAppApplication.class, args);
	}

}