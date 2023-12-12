package com.app.medical.repository;




import com.app.medical.model.MedicalServices;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MedicalServicesRepo extends JpaRepository<MedicalServices, Long> {
}