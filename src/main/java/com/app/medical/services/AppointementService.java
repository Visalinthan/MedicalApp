package com.app.medical.services;

import com.app.medical.model.Appointement;

import com.app.medical.repository.AppointementRepo;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AppointementService {

    private AppointementRepo appointementRepo;

    public AppointementService(AppointementRepo appointementRepo) {
        this.appointementRepo = appointementRepo;
    }

    // Get a list of all appointments
    public List<Appointement> getAllAppointments() {
        return this.appointementRepo.findAll();
    }

    // Find an appointment by its ID
    public Optional<Appointement> findAppointmentById(Long id) {
        return this.appointementRepo.findById(id);
    }

    // Find appointments by patient ID
    public List<Appointement> findAppointmentsByPatientId(Long patientId) {
        return this.appointementRepo.findByPatientId(patientId);
    }

    // Find appointments by doctor ID
    public List<Appointement> findAppointmentsByMedecinId(Long medecinId) {
        return this.appointementRepo.findByMedecinId(medecinId);
    }

    // Save (create or update) an appointment
    public Appointement saveAppointment(Appointement appointment) {
        if (appointment == null) {
            throw new IllegalArgumentException("Appointment cannot be null");
        }

        return this.appointementRepo.save(appointment);
    }

    // Delete an appointment by its ID
    public void deleteAppointment(Long id) {
        if (id == null) {
            throw new IllegalArgumentException("Appointment ID cannot be null");
        }

        try {
            this.appointementRepo.deleteById(id);
        } catch (Exception e) {
            throw new RuntimeException("Error deleting appointment with ID: " + id, e);
        }
    }

    // Get appointments for a specific patient by their ID
    public List<Appointement> getAppointmentsByPatientId(Long patientId) {
        if (patientId == null) {
            throw new IllegalArgumentException("Patient ID cannot be null");
        }

        return this.appointementRepo.findByPatientId(patientId);
    }

}
