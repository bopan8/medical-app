package com.javamedical.medicalapp.services;

import com.javamedical.medicalapp.domain.Patient;

import java.util.List;

public interface PatientService {

    List<Patient> getAllPatients();
    void savePatient(Patient patient);
    Patient getPatientById(Integer patientId);
    void deletePatientById(Integer patientId);
    Patient getPatientByUsernameAndPassword(String name, String password);
}
