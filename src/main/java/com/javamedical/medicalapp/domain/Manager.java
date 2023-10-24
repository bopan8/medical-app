package com.javamedical.medicalapp.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
@Entity
@Table(name = "managers")
public class Manager implements User{

    @Id
    @Column(name = "manager_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer managerId;

    @NotNull
    @NotEmpty
    @Size(max = 30, message = "Name too long")
    @Column(name = "manager_name")
    private String managerName;

    @NotNull
    @NotEmpty
    @Size(min = 6, message = "Password too weak")
    @Column(name = "password")
    private String password;

    @NotNull
    @Column(name = "ROLE")
    private  String role;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "managed_hospital")
    private Hospitals hospital;

    public Manager(){

    }

    public Manager(Integer managerId, String managerName, String password, String role, Hospitals hospital) {
        this.managerId = managerId;
        this.managerName = managerName;
        this.password = password;
        this.role = role;
        this.hospital = hospital;
    }

    @Override
    public Integer getId() {
        return managerId;
    }

    @Override
    public void setId(Integer managerId) {
        this.managerId = managerId;
    }

    @Override
    public String getName() {
        return managerName;
    }

    @Override
    public void setName(String managerName) {
        this.managerName = managerName;
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

    public Hospitals getHospital() {
        return hospital;
    }

    public void setHospital(Hospitals hospital) {
        this.hospital = hospital;
    }
}
