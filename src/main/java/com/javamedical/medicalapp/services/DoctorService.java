package com.javamedical.medicalapp.services;

import com.javamedical.medicalapp.domain.Doctor;
import com.javamedical.medicalapp.domain.Patient;

import javax.print.Doc;
import java.util.List;

public interface DoctorService {
    List<Doctor> getAllDoctors();
    void saveDoctor(Doctor doctor);
    Doctor getDoctorById(Integer doctorId);
    void deleteDoctorById(Integer doctorId);
    Doctor getDoctorByUsernameAndPassword(String name, String password);
}
