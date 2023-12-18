package com.app.medical.services;

import com.app.medical.model.Ilness;
import com.app.medical.repository.IllnessRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class IllnessService {

    private IllnessRepo ilnessRepo;

    @Autowired
    public IllnessService(IllnessRepo ilnessRepo) {
        this.ilnessRepo = ilnessRepo;
    }

    /**
     * Retrieve a list of all illnesses.
     *
     * @return List of illnesses
     */
    public List<Ilness> getAllIllnesses() {
        return ilnessRepo.findAll();
    }

    /**
     * Retrieve an illness by its ID.
     *
     * @param id Illness ID
     * @return Optional containing illness if found, otherwise empty
     */
    public Optional<Ilness> findIlnessById(Long id) {
        return ilnessRepo.findById(id);
    }

    /**
     * Save (create or update) an illness.
     *
     * @param ilness Illness to be saved
     * @return Saved illness
     */
    public Ilness saveIlness(Ilness ilness) {
        if (ilness == null) {
            throw new IllegalArgumentException("Illness cannot be null");
        }

        return ilnessRepo.save(ilness);
    }

    /**
     * Delete an illness by its ID.
     *
     * @param id Illness ID to be deleted
     */
    public void deleteIlness(Long id) {
        if (id == null) {
            throw new IllegalArgumentException("Illness ID cannot be null");
        }

        try {
            ilnessRepo.deleteById(id);
        } catch (Exception e) {
            throw new RuntimeException("Error deleting illness with ID: " + id, e);
        }
    }
}
