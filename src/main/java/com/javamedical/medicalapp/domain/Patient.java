package com.javamedical.medicalapp.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "patients")
public class Patient implements User{

    @Id
    @Column(name = "patient_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer patientId;

    @NotNull
    @NotEmpty
    @Size(max = 30, message = "Name too long")
    @Column(name = "patient_name")
    private String patientName;

    @NotNull
    @NotEmpty
    @Size(min = 4, max = 16,message = "Password too weak")
    @Column(name = "password")
    private String password;

    @NotNull
    @Column(name = "ROLE")
    private  String role;

    @Column(name = "patient_email")
    private String patientMail;

    public Patient(){

    }

    public Patient(Integer patientId, String patientName, String password, String role, String patientMail) {
        this.patientId = patientId;
        this.patientName = patientName;
        this.password = password;
        this.role = role;
        this.patientMail = patientMail;
    }

    @Override
    public Integer getId() {
        return patientId;
    }

    @Override
    public void setId(Integer patientId) {
        this.patientId = patientId;
    }

    @Override
    public String getName() {
        return patientName;
    }

    @Override
    public void setName(String patientName) {
        this.patientName = patientName;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getPatientMail() {
        return patientMail;
    }

    public void setPatientMail(String patientMail) {
        this.patientMail = patientMail;
    }
}
