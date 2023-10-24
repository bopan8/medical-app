package com.javamedical.medicalapp.services;

import com.javamedical.medicalapp.domain.Hospitals;
import com.javamedical.medicalapp.repos.HospitalsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class HospitalsServiceImpl implements HospitalsService{
    @Autowired
    private HospitalsRepository hospitalsRepository;

    @Override
    public List<Hospitals> getAllHospitals() {
        return hospitalsRepository.findAll();
    }
}
