package com.javamedical.medicalapp.controllers;

import com.javamedical.medicalapp.services.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DoctorController {
    @Autowired
    private DoctorService doctorService;

    @GetMapping("/doctor")
    public String viewDoctors(){ return "/doctor";}
}
