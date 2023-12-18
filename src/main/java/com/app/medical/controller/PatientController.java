package com.app.medical.controller;

import com.app.medical.controller.exceptions.NotFound;
import com.app.medical.model.Patient;
import com.app.medical.services.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/patient")
public class PatientController {
    private final PatientService patientService;

    @Autowired
    public PatientController(PatientService patientService) {
        this.patientService = patientService;
    }

    // Get all patients
    @GetMapping
    public ResponseEntity<List<Patient>> getAllPatients() {
        List<Patient> patientList = patientService.getAllPatients();
        return new ResponseEntity<>(patientList, HttpStatus.OK);
    }

    // Get patient by ID
    @GetMapping("/{id}")
    public ResponseEntity<Object> getPatientById(@PathVariable Long id) {
        try {
            Patient patient = patientService.findPatientById(id)
                    .orElseThrow(() -> new NotFound("Patient not found with ID: " + id));
            return new ResponseEntity<>(patient, HttpStatus.OK);
        } catch (NotFound e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    // Get patient by email
    @GetMapping("/email/{email}")
    public ResponseEntity<Object> getPatientByEmail(@PathVariable String email) {
        try {
            Patient patient = patientService.findPatientByEmail(email);
            return new ResponseEntity<>(patient, HttpStatus.OK);
        } catch (NotFound e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    // Create or update patient
    @PostMapping
    public ResponseEntity<Object> createOrUpdatePatient(@RequestBody Patient patient) {
        try {
            Patient savedPatient = patientService.savePatient(patient);
            return new ResponseEntity<>(savedPatient, HttpStatus.CREATED);
        } catch (IllegalArgumentException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    // Delete patient by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deletePatient(@PathVariable Long id) {
        try {
            patientService.deletePatient(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (NotFound e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

}