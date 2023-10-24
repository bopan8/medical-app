package com.javamedical.medicalapp.services;

import com.javamedical.medicalapp.domain.Prescriptions;

import java.util.List;

public interface PrescriptionService {
    List<Prescriptions> getAllPrescriptions();
    List<Prescriptions> getAllPrescriptionsPerPatient();
    List<Prescriptions> getAllActivePrescriptionsPerPatient();
    List<Prescriptions> getAllNonActivePrescriptionsPerPatient();
}
