package com.app.medical.repository;


import com.app.medical.model.Medecin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MedecinRepo extends JpaRepository<Medecin, Long> {
    public Medecin findByEmail(String email);
}