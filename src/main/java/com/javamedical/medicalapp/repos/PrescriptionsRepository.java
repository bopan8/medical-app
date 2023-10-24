package com.javamedical.medicalapp.repos;

import com.javamedical.medicalapp.domain.Prescriptions;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PrescriptionsRepository extends JpaRepository<Prescriptions,Integer>{
}
