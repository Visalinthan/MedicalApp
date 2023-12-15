package com.app.medical.repository;



import com.app.medical.model.Appointement;
import com.app.medical.model.Prescription;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PrescriptionRepo extends JpaRepository<Prescription, Long> {
    List<Prescription> findAllById(Long id);


    //public List<Prescription> findByPrescriptionId(Long id);




    }

