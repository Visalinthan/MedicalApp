package com.app.medical.controller;

import com.app.medical.controller.exceptions.NotFound;
import com.app.medical.model.Medecin;
import com.app.medical.services.MedecinService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/medecin")
public class MedecinController {

    private final MedecinService medecinService;

    @Autowired
    public MedecinController(MedecinService medecinService) {
        this.medecinService = medecinService;
    }

    // Get all doctors
    @GetMapping
    public ResponseEntity<List<Medecin>> getAllDoctors() {
        List<Medecin> doctorList = medecinService.getAllDoctors();
        return new ResponseEntity<>(doctorList, HttpStatus.OK);
    }

    // Get doctor by ID
    @GetMapping("/{id}")
    public ResponseEntity<Object> getDoctorById(@PathVariable Long id) {
        try {
            Medecin doctor = medecinService.findDoctorById(id)
                    .orElseThrow(() -> new NotFound("Doctor not found with ID: " + id));
            return new ResponseEntity<>(doctor, HttpStatus.OK);
        } catch (NotFound e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    // Get doctor by email
    @GetMapping("/email/{email}")
    public ResponseEntity<Object> getDoctorByEmail(@PathVariable String email) {
        try {
            Medecin doctor = medecinService.findDoctorByEmail(email);
            return new ResponseEntity<>(doctor, HttpStatus.OK);
        } catch (NotFound e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    // Create or update doctor
    @PostMapping
    public ResponseEntity<Object> createOrUpdateDoctor(@RequestBody Medecin doctor) {
        try {
            Medecin savedDoctor = medecinService.saveDoctor(doctor);
            return new ResponseEntity<>(savedDoctor, HttpStatus.CREATED);
        } catch (IllegalArgumentException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    // Delete doctor by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteDoctor(@PathVariable Long id) {
        try {
            medecinService.deleteDoctor(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (NotFound e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }
}