package com.app.medical.services;

import com.app.medical.controller.exceptions.NotFound;
import com.app.medical.model.Medecin;
import com.app.medical.model.Patient;
import com.app.medical.repository.MedecinRepo;
import com.app.medical.repository.PatientRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MedecinService {

    private MedecinRepo medecinRepo;

    @Autowired
    public MedecinService(MedecinRepo medecinRepo) {
        this.medecinRepo = medecinRepo;
    }

    /**
     * Retrieve a list of all doctors.
     *
     * @return List of doctors
     */
    public List<Medecin> getAllDoctors() {
        return this.medecinRepo.findAll();
    }

    /**
     * Retrieve a doctor by their ID.
     *
     * @param id Doctor ID
     * @return Optional containing doctor if found, otherwise empty
     */
    public Optional<Medecin> findDoctorById(Long id) {
        return this.medecinRepo.findById(id);
    }

    /**
     * Retrieve a doctor by their email.
     *
     * @param email Doctor email
     * @return Doctor with the specified email
     */
    public Medecin findDoctorByEmail(String email) {
        return this.medecinRepo.findByEmail(email);
    }

    /**
     * Save (create or update) a doctor.
     *
     * @param medecin Doctor to be saved
     * @return Saved doctor
     */
    public Medecin saveDoctor(Medecin medecin) {
        if (medecin == null) {
            throw new IllegalArgumentException("Doctor cannot be null");
        }

        return this.medecinRepo.save(medecin);
    }

    /**
     * Delete a doctor by their ID.
     *
     * @param id Doctor ID to be deleted
     */
    public void deleteDoctor(Long id) {
        if (id == null) {
            throw new IllegalArgumentException("Doctor ID cannot be null");
        }

        try {
            this.medecinRepo.deleteById(id);
        } catch (Exception e) {
            throw new RuntimeException("Error deleting doctor with ID: " + id, e);
        }
    }
}
