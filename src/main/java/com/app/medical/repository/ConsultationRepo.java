package com.app.medical.repository;




import com.app.medical.model.Consultation;
import com.app.medical.model.Prescription;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ConsultationRepo extends JpaRepository<Consultation, Long> {


    List<Consultation> findAllById(Long id);
}

