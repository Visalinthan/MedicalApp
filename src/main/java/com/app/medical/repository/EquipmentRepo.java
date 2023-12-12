package com.app.medical.repository;


import com.app.medical.model.Equipment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EquipmentRepo extends JpaRepository<Equipment, Long> {
}