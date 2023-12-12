package com.app.medical.repository;



import com.app.medical.model.Appointement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AppointementRepo extends JpaRepository<Appointement, Long> {
}