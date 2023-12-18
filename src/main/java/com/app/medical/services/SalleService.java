package com.app.medical.services;

import com.app.medical.controller.exceptions.NotFound;
import com.app.medical.model.Salle;
import com.app.medical.repository.SalleRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SalleService {

    private SalleRepo salleRepo;

    @Autowired
    public SalleService(SalleRepo salleRepo) {
        this.salleRepo = salleRepo;
    }

    /**
     * Retrieve a list of all rooms.
     *
     * @return List of rooms
     */
    public List<Salle> getAllRooms() {
        return salleRepo.findAll();
    }

    /**
     * Retrieve a room by its ID.
     *
     * @param id Room ID
     * @return Optional containing room if found, otherwise empty
     */
    public Optional<Salle> findRoomById(Long id) {
        return salleRepo.findById(id);
    }

    /**
     * Save (create or update) a room.
     *
     * @param salle Room to be saved
     * @return Saved room
     */
    public Salle saveRoom(Salle salle) {
        if (salle == null) {
            throw new IllegalArgumentException("Room cannot be null");
        }

        return salleRepo.save(salle);
    }

    /**
     * Delete a room by its ID.
     *
     * @param id Room ID to be deleted
     */
    public void deleteRoom(Long id) {
        if (id == null) {
            throw new IllegalArgumentException("Room ID cannot be null");
        }

        try {
            salleRepo.deleteById(id);
        } catch (Exception e) {
            throw new RuntimeException("Error deleting room with ID: " + id, e);
        }
    }
}

