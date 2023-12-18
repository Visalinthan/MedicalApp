package com.app.medical.services;


import com.app.medical.controller.exceptions.NotFound;
import com.app.medical.model.Equipment;
import com.app.medical.repository.EquipmentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EquipmentService {

    private EquipmentRepo equipmentRepo;

    @Autowired
    public EquipmentService(EquipmentRepo equipmentRepo) {
        this.equipmentRepo = equipmentRepo;
    }

    /**
     * Retrieve a list of all equipment.
     *
     * @return List of equipment
     */
    public List<Equipment> getAllEquipment() {
        return this.equipmentRepo.findAll();
    }

    /**
     * Retrieve equipment by its ID.
     *
     * @param id Equipment ID
     * @return Optional containing equipment if found, otherwise empty
     */
    public Optional<Equipment> findEquipmentById(Long id) {
        return this.equipmentRepo.findById(id);
    }

    /**
     * Save (create or update) equipment.
     *
     * @param equipment Equipment to be saved
     * @return Saved equipment
     */
    public Equipment saveEquipment(Equipment equipment) {
        if (equipment == null) {
            throw new IllegalArgumentException("Equipment cannot be null");
        }

        return this.equipmentRepo.save(equipment);
    }

    /**
     * Delete equipment by its ID.
     *
     * @param id Equipment ID to be deleted
     */
    public void deleteEquipment(Long id) {
        if (id == null) {
            throw new IllegalArgumentException("Equipment ID cannot be null");
        }

        try {
            this.equipmentRepo.deleteById(id);
        } catch (Exception e) {
            throw new RuntimeException("Error deleting equipment with ID: " + id, e);
        }
    }
}
