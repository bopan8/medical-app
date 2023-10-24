package com.javamedical.medicalapp.services;

import com.javamedical.medicalapp.domain.Prescriptions;
import com.javamedical.medicalapp.repos.PrescriptionsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;

@Service
public class PrescriptionServiceImpl implements PrescriptionService{
    @Autowired
    PrescriptionsRepository prescriptionsRepository;
    @Override
    public List<Prescriptions> getAllPrescriptions() {return prescriptionsRepository.findAll();}

    @Override
    public List<Prescriptions> getAllPrescriptionsPerPatient() {
        List<Prescriptions> all = prescriptionsRepository.findAll();
        List<Prescriptions> filtered = new ArrayList<>();

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String currentPrincipalName = authentication.getName();
        System.out.println("USER: " + currentPrincipalName);

        for (Prescriptions prescription:all){
            if (prescription.getPatient().getName().equals(currentPrincipalName)){
                filtered.add(prescription);
            }
        }

        System.out.println("PRESCRIPTION OF USER: "+currentPrincipalName + " ARE: ");
        for (Prescriptions prescription : filtered) {
            System.out.println(prescription.getMedsName());
        }
        return filtered;
    }

    @Override
    public List<Prescriptions> getAllActivePrescriptionsPerPatient() {
        List<Prescriptions> prescriptionsPerPatient = getAllPrescriptionsPerPatient();
        List<Prescriptions> activePrescriptions = new ArrayList<>();

        for (Prescriptions prescription : prescriptionsPerPatient){
            LocalDateTime currentTime = LocalDateTime.now();
            LocalDateTime prescriptionDate = prescription.getDateOfIssue();

            Period period = Period.between(prescriptionDate.toLocalDate(), currentTime.toLocalDate());
            System.out.println("THE MEDICINE " + prescription.getMedsName()+ "Period is "+ period);
            if (period.getMonths() < 3){
                activePrescriptions.add(prescription);
            }
        }

        return activePrescriptions;
    }

    @Override
    public List<Prescriptions> getAllNonActivePrescriptionsPerPatient() {
        List<Prescriptions> prescriptionsPerPatient = getAllPrescriptionsPerPatient();
        List<Prescriptions> nonActivePrescriptions = new ArrayList<>();

        for (Prescriptions prescription : prescriptionsPerPatient){
            LocalDateTime currentTime = LocalDateTime.now();
            LocalDateTime prescriptionDate = prescription.getDateOfIssue();

            Period period = Period.between(prescriptionDate.toLocalDate(), currentTime.toLocalDate());
            System.out.println("THE MEDICINE " + prescription.getMedsName()+ "Period is "+ period);
            if (period.getMonths() >= 3){
                nonActivePrescriptions.add(prescription);
            }
        }

        return nonActivePrescriptions;
    }
}
