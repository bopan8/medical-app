package com.javamedical.medicalapp.services;

import com.javamedical.medicalapp.domain.Patient;
import com.javamedical.medicalapp.repos.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PatientServiceImpl implements PatientService{
    @Autowired
    PatientRepository patientRepository;

    @Override
    public List<Patient> getAllPatients() {
        return patientRepository.findAll();
    }

    @Override
    public void savePatient(Patient patient) {
        this.patientRepository.save(patient);
    }

    @Override
    public Patient getPatientById(Integer patientId) {
        Optional<Patient> optional = patientRepository.findById(patientId);
        Patient patient = null;

        if (optional.isPresent()){
            patient = optional.get();
        }
        else {
            throw new RuntimeException("Patient with id: " +patient +" not found ");
        }

        return patient;
    }

    @Override
    public void deletePatientById(Integer patientId) {
        this.patientRepository.deleteById(patientId);
    }

    @Override
    public Patient getPatientByUsernameAndPassword(String name, String password) {
        List<Patient> optional = patientRepository.findAll();
        for (Patient patient:optional){
            if (patient.getName().equals(name) && patient.getPassword().equals(password)){
                return patient;
            }
        }
        throw new RuntimeException("Client with username: " + name + " and password: " + password +" not found ");
    }
}
