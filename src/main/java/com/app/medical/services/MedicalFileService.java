package com.app.medical.services;


import com.app.medical.model.MedicalFile;
import com.app.medical.repository.MedicalFileRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class MedicalFileService {

    private MedicalFileRepo medicalFileRepo;

    @Autowired
    public MedicalFileService(MedicalFileRepo medicalFileRepo) {
        this.medicalFileRepo = medicalFileRepo;
    }

    /**
     * Retrieve a list of all medical files.
     *
     * @return List of medical files
     */
    public List<MedicalFile> getAllMedicalFiles() {
        return this.medicalFileRepo.findAll();
    }

    /**
     * Retrieve a medical file by its ID.
     *
     * @param id Medical file ID
     * @return Optional containing medical file if found, otherwise empty
     */
    public Optional<MedicalFile> findMedicalFileById(Long id) {
        return this.medicalFileRepo.findById(id);
    }

    /**
     * Save (create or update) a medical file.
     *
     * @param medicalFile Medical file to be saved
     * @return Saved medical file
     */
    public MedicalFile saveMedicalFile(MedicalFile medicalFile) {
        if (medicalFile == null) {
            throw new IllegalArgumentException("Medical file cannot be null");
        }

        return this.medicalFileRepo.save(medicalFile);
    }

    /**
     * Delete a medical file by its ID.
     *
     * @param id Medical file ID to be deleted
     */
    public void deleteMedicalFile(Long id) {
        if (id == null) {
            throw new IllegalArgumentException("Medical file ID cannot be null");
        }

        try {
            this.medicalFileRepo.deleteById(id);
        } catch (Exception e) {
            throw new RuntimeException("Error deleting medical file with ID: " + id, e);
        }
    }

}
