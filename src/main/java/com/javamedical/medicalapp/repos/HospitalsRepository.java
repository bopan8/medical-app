package com.javamedical.medicalapp.repos;

import com.javamedical.medicalapp.domain.Hospitals;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HospitalsRepository extends JpaRepository<Hospitals, Integer> {
}
