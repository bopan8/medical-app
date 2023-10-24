package com.javamedical.medicalapp.detailService;

import com.javamedical.medicalapp.domain.Doctor;
import com.javamedical.medicalapp.domain.Patient;
import com.javamedical.medicalapp.repos.DoctorRepository;
import com.javamedical.medicalapp.repos.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class MyUserDetailsService implements UserDetailsService {

    @Autowired
    private PatientRepository patientRepository;

    @Autowired
    DoctorRepository doctorRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        Optional<Patient> patient = patientRepository.findByPatientName(username);

        if (patient.isPresent()){
            System.out.println("returning PatientUserDetails instance");
            return patient.map(PatientUserDetails::new).get();
        }

        Optional<Doctor> doctor = doctorRepository.findByDoctorName(username);

        if (doctor.isPresent()) {
            System.out.println("returning DoctorUserDetails instance");
            return doctor.map(DoctorUserDetails::new).get();
        }
        else {
            throw new UsernameNotFoundException(username + " - Not Found!");
        }

    }
}
