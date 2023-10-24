package com.javamedical.medicalapp.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.time.LocalDateTime;

@Entity
@Table(name = "prescriptions")
public class Prescriptions {

    @Id
    @Column(name = "prescription_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer prescriptionId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "patient_id")
    private Patient patient;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "doctor_id")
    private Doctor doctor;

    @NotNull
    @NotEmpty
    @Size(max = 15, message = "Name of medicament too long")
    @Column(name = "medicine_name")
    private String medsName;

    @NotNull
    @NotEmpty
    @Size(max = 25, message = "Too much description of the dosage")
    @Column(name = "dosage")
    private String dosage;

    @NotNull
    @NotEmpty
    @Column(name = "date_of_issue")
    private LocalDateTime dateOfIssue;

    public Prescriptions(){

    }

    public Prescriptions(Integer prescriptionId, Patient patient, Doctor doctor, String medsName, String dosage, LocalDateTime dateOfIssue) {
        this.prescriptionId = prescriptionId;
        this.patient = patient;
        this.doctor = doctor;
        this.medsName = medsName;
        this.dosage = dosage;
        this.dateOfIssue = dateOfIssue;
    }

    public Integer getPrescriptionId() {
        return prescriptionId;
    }

    public void setPrescriptionId(Integer prescriptionId) {
        this.prescriptionId = prescriptionId;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public Doctor getDoctors() {
        return doctor;
    }

    public void setDoctors(Doctor doctor) {
        this.doctor = doctor;
    }

    public String getMedsName() {
        return medsName;
    }

    public void setMedsName(String medsName) {
        this.medsName = medsName;
    }

    public String getDosage() {
        return dosage;
    }

    public void setDosage(String dosage) {
        this.dosage = dosage;
    }

    public LocalDateTime getDateOfIssue() {
        return dateOfIssue;
    }

    public void setDateOfIssue(LocalDateTime dateOfIssue) {
        this.dateOfIssue = dateOfIssue;
    }
}
