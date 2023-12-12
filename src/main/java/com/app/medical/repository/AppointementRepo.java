package com.app.medical.repository;


import com.app.medical.model.Medecin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AppointementRepo extends JpaRepository<Medecin, Long> {
}