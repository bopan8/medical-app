package com.javamedical.medicalapp.services;

import com.javamedical.medicalapp.domain.Doctor;
import com.javamedical.medicalapp.repos.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DoctorServiceImpl implements DoctorService{
    @Autowired
    DoctorRepository doctorRepository;
    @Override
    public List<Doctor> getAllDoctors() {return doctorRepository.findAll();}

    @Override
    public void saveDoctor(Doctor doctor) {this.doctorRepository.save(doctor);}

    @Override
    public Doctor getDoctorById(Integer doctorId) {
        Optional<Doctor> optional = doctorRepository.findById(doctorId);
        Doctor doctor = null;

        if (optional.isPresent()){
            doctor = optional.get();
        }else{
            throw new RuntimeException("Doctor with id: " +doctor +" not found ");
        }
        return doctor;
    }

    @Override
    public void deleteDoctorById(Integer doctorId) {this.doctorRepository.deleteById(doctorId);}

    @Override
    public Doctor getDoctorByUsernameAndPassword(String name, String password) {
       List<Doctor> optional = doctorRepository.findAll();
       for (Doctor doctor:optional){
           if (doctor.getName().equals(name) && doctor.getPassword().equals(password)){
               return doctor;
           }
       }
        throw new RuntimeException("Doctor with username: " + name + " and password: " + password +" not found ");
    }
}
