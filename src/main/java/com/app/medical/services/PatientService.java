package com.app.medical.services;

import com.app.medical.model.Medecin;
import com.app.medical.model.Patient;
import com.app.medical.repository.PatientRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PatientService {
    private PatientRepo patientRepo;

    @Autowired
    public PatientService(PatientRepo patientRepo) {
        this.patientRepo = patientRepo;
    }

    /**
     * Retrieve a list of all patients.
     *
     * @return List of patients
     */
    public List<Patient> getAllPatients() {
        return this.patientRepo.findAll();
    }

    /**
     * Retrieve a patient by their ID.
     *
     * @param id Patient ID
     * @return Optional containing patient if found, otherwise empty
     */
    public Optional<Patient> findPatientById(Long id) {
        return this.patientRepo.findById(id);
    }

    /**
     * Retrieve a patient by their email.
     *
     * @param email Patient email
     * @return Patient with the specified email
     */
    public Patient findPatientByEmail(String email) {
        return this.patientRepo.findByEmail(email);
    }

    /**
     * Save (create or update) a patient.
     *
     * @param patient Patient to be saved
     * @return Saved patient
     */
    public Patient savePatient(Patient patient) {
        if (patient == null) {
            throw new IllegalArgumentException("Patient cannot be null");
        }

        return this.patientRepo.save(patient);
    }

    /**
     * Delete a patient by their ID.
     *
     * @param id Patient ID to be deleted
     */
    public void deletePatient(Long id) {
        if (id == null) {
            throw new IllegalArgumentException("Patient ID cannot be null");
        }

        try {
            this.patientRepo.deleteById(id);
        } catch (Exception e) {
            throw new RuntimeException("Error deleting patient with ID: " + id, e);
        }
    }
}
