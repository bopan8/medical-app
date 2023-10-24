package com.javamedical.medicalapp.domain;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;


@Entity
@Table(name = "hospitals")
public class Hospitals {
    @Id
    @Column(name = "hospital_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer hospitalId;
    @Size(max = 45, message = "Hospital name too long")
    @NotNull
    @Column(name = "hospital_name")
    private String hospitalName;
    @Size(max = 45, message = "Hospital adress too long")
    @Column(name = "hospital_adress")
    private String hospitalAdress;

    @Column(name = "receptionPhone")
    private String receptionPhone;

    public Hospitals() {
    }

    public Hospitals(Integer hospitalId, String hospitalName, String hospitalAdress, String receptionPhone) {
        this.hospitalId = hospitalId;
        this.hospitalName = hospitalName;
        this.hospitalAdress = hospitalAdress;
        this.receptionPhone = receptionPhone;
    }

    public Integer getHospitalId() {
        return hospitalId;
    }

    public void setHospitalId(Integer hospitalId) {
        this.hospitalId = hospitalId;
    }

    public String getHospitalName() {
        return hospitalName;
    }

    public void setHospitalName(String hospitalName) {
        this.hospitalName = hospitalName;
    }

    public String getHospitalAdress() {
        return hospitalAdress;
    }

    public void setHospitalAdress(String hospitalAdress) {
        this.hospitalAdress = hospitalAdress;
    }

    public String getReceptionPhone() {
        return receptionPhone;
    }

    public void setReceptionPhone(String receptionPhone) {
        this.receptionPhone = receptionPhone;
    }
}
