package com.app.medical.repository;



import com.app.medical.model.Appointement;
import com.app.medical.model.Consultation;
import com.app.medical.model.Prescription;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;

@Repository
public interface AppointementRepo extends JpaRepository<Appointement, Long> {
    /*@Query(value = "SELECT * FROM appointement WHERE patient_id = :id", nativeQuery = true)
    public List<Appointement> getAppoinementByPatientId(@Param("id") Long id);*/


        public List<Appointement> findByPatientId(Long id);
        public List<Appointement> findByMedecinId(Long id);

   }

