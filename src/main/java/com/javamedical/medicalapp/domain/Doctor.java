package com.javamedical.medicalapp.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "doctors")
public class Doctor implements User{

    @Id
    @Column(name = "doctor_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer doctorId;

    @NotNull
    @NotEmpty
    @Size(max = 45, message = "Name too long")
    @Column(name = "doctor_name")
    private String doctorName;

    @NotNull
    @NotEmpty
    @Size(min = 6, message = "Password too weak")
    @Column(name = "password")
    private String password;

    @NotNull
    @Column(name = "ROLE")
    private  String role;

    @Column(name = "doctor_phone")
    private String doctorPhone;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "hospital_id")
    private Hospitals hospital;
    public Doctor(){

    }

    public Doctor(Integer doctorId, String doctorName, String password, String role, String doctorPhone, Hospitals hospital) {
        this.doctorId = doctorId;
        this.doctorName = doctorName;
        this.password = password;
        this.role = role;
        this.doctorPhone = doctorPhone;
        this.hospital = hospital;
    }

    @Override
    public Integer getId() {
        return doctorId;
    }

    @Override
    public void setId(Integer doctorId) {
        this.doctorId = doctorId;
    }

    @Override
    public String getName() {
        return doctorName;
    }

    @Override
    public void setName(String doctorName) {
        this.doctorName = doctorName;
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

    public String getDoctorPhone() {
        return doctorPhone;
    }

    public void setDoctorPhone(String doctorPhone) {
        this.doctorPhone = doctorPhone;
    }

    public Hospitals getHospital() {
        return hospital;
    }

    public void setHospital(Hospitals hospital) {
        this.hospital = hospital;
    }
}
