package com.app.medical.services;


import com.app.medical.controller.exceptions.NotFound;
import com.app.medical.model.Specialities;
import com.app.medical.repository.SpecialitiesRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SpecialitiesService {
    private SpecialitiesRepo specialitiesRepo;

    @Autowired
    public SpecialitiesService(SpecialitiesRepo specialitiesRepo) {
        this.specialitiesRepo = specialitiesRepo;
    }

    /**
     * Retrieve a list of all medical services.
     *
     * @return List of medical services
     */
    public List<Specialities> getAllMedicalServices() {
        return this.specialitiesRepo.findAll();
    }

    /**
     * Retrieve a medical service by its ID.
     *
     * @param id Medical service ID
     * @return Optional containing medical service if found, otherwise empty
     */
    public Optional<Specialities> findMedicalServiceById(Long id) {
        return this.specialitiesRepo.findById(id);
    }

    /**
     * Save (create or update) a medical service.
     *
     * @param specialities Medical service to be saved
     * @return Saved medical service
     */
    public Specialities saveMedicalServices(Specialities specialities) {
        if (specialities == null) {
            throw new IllegalArgumentException("Medical service cannot be null");
        }

        return this.specialitiesRepo.save(specialities);
    }

    /**
     * Delete a medical service by its ID.
     *
     * @param id Medical service ID to be deleted
     */
    public void deleteMedicalServices(Long id) {
        if (id == null) {
            throw new IllegalArgumentException("Medical service ID cannot be null");
        }

        try {
            this.specialitiesRepo.deleteById(id);
        } catch (Exception e) {
            throw new RuntimeException("Error deleting medical service with ID: " + id, e);
        }
    }
}
