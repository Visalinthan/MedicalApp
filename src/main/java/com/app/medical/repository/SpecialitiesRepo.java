package com.app.medical.repository;




import com.app.medical.model.Specialities;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MedicalServicesRepo extends JpaRepository<Specialities, Long> {
}