package com.javamedical.medicalapp.controllers;

import com.itextpdf.html2pdf.ConverterProperties;
import com.itextpdf.html2pdf.HtmlConverter;
import com.javamedical.medicalapp.domain.Patient;
import com.javamedical.medicalapp.domain.Prescriptions;
import com.javamedical.medicalapp.repos.PatientRepository;
import com.javamedical.medicalapp.services.PatientService;
import com.javamedical.medicalapp.services.PrescriptionService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.thymeleaf.context.WebContext;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.List;

@Controller
public class PatientController {
    @Autowired
    PatientService patientService;

    @Autowired
    PrescriptionService prescriptionService;

    @Autowired
    private PatientRepository patientRepository;

    @GetMapping("/patient")
    public String viewPrescriptionsForCurrentPatient(Model model){
        model.addAttribute("listActivePrescriptions", prescriptionService.getAllActivePrescriptionsPerPatient());
        model.addAttribute("listNonActivePrescriptions", prescriptionService.getAllNonActivePrescriptionsPerPatient());
        return "patient";
    }
    @GetMapping("/register")
    public String showRegistrationForm(Model model) {
        model.addAttribute("patient", new Patient());
        return "registration";
    }

    @PostMapping("/register")
    public String processRegister(Patient patient) {

        System.out.println(patient.getId());
        System.out.println(patient.getName());
        System.out.println(patient.getPassword());
        patient.setRole("ROLE_CLIENT");
        System.out.println(patient.getRole());

        patientRepository.save(patient);

        return "redirect:/login";
    }

    @GetMapping("/prescription/export")
    public void exportToPDF(HttpServletResponse response) throws IOException{
        response.setContentType("application/pdf");
        String headerKey = "Content-Disposition";
        String headerValue = "attachment; filename=prescription.pdf";

        response.setHeader(headerKey,headerValue);
        List<Prescriptions> prescriptionsList = prescriptionService.getAllPrescriptions();

        PDFExporter exporter = new PDFExporter(prescriptionsList);
        exporter.export(response);
    }
}
