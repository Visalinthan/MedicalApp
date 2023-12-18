package com.app.medical.controller;

import com.app.medical.controller.exceptions.AddException;
import com.app.medical.controller.exceptions.NotFound;
import com.app.medical.model.Appointement;
import com.app.medical.model.Medecin;
import com.app.medical.services.AppointementService;
import com.app.medical.services.MedecinService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/appointement")
public class AppointementController {
    private final AppointementService appointementService;

    @Autowired
    public AppointementController(AppointementService appointementService) {
        this.appointementService = appointementService;
    }

    // Get all appointments
    @GetMapping
    public ResponseEntity<List<Appointement>> getAllAppointments() {
        List<Appointement> appointments = appointementService.getAllAppointments();
        return new ResponseEntity<>(appointments, HttpStatus.OK);
    }

    // Get appointment by ID
    @GetMapping("/{id}")
    public ResponseEntity<Appointement> getAppointmentById(@PathVariable Long id) {
        try {
            Appointement appointment = appointementService.findAppointmentById(id).get();
            return new ResponseEntity<>(appointment, HttpStatus.OK);
        } catch (NotFound e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Get appointments by patient ID
    @GetMapping("/patient/{patientId}")
    public ResponseEntity<List<Appointement>> getAppointmentsByPatientId(@PathVariable Long patientId) {
        List<Appointement> appointments = appointementService.findAppointmentsByPatientId(patientId);
        return new ResponseEntity<>(appointments, HttpStatus.OK);
    }

    // Get appointments by doctor ID
    @GetMapping("/medecin/{medecinId}")
    public ResponseEntity<List<Appointement>> getAppointmentsByDoctorId(@PathVariable Long medecinId) {
        List<Appointement> appointments = appointementService.findAppointmentsByMedecinId(medecinId);
        return new ResponseEntity<>(appointments, HttpStatus.OK);
    }

    // Create or update an appointment
    @PostMapping
    public ResponseEntity<Appointement> createOrUpdateAppointment(@RequestBody Appointement appointment) {
        try {
            Appointement savedAppointment = appointementService.saveAppointment(appointment);
            return new ResponseEntity<>(savedAppointment, HttpStatus.CREATED);
        } catch (IllegalArgumentException e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    // Delete an appointment by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAppointment(@PathVariable Long id) {
        try {
            appointementService.deleteAppointment(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (NotFound e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}