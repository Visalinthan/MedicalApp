package com.app.medical.repository;



import com.app.medical.model.Appointement;
import com.app.medical.model.Medecin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AppointementRepo extends JpaRepository<Appointement, Long> {
    public List<Appointement> findByPatientId(Long id);
    public List<Appointement> findByMedecinId(Long id);
}