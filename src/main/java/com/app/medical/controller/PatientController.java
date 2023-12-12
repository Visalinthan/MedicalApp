package com.app.medical.controller;

import com.app.medical.controller.exceptions.AddException;
import com.app.medical.controller.exceptions.NotFound;
import com.app.medical.dto.UserDto;
import com.app.medical.model.Patient;
import com.app.medical.services.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/patient")
public class PatientController {
    @Autowired
    PatientService patientService;

    @PostMapping("/login")
    public ResponseEntity<?> loginPatient(@RequestBody UserDto user){
        Patient patient = patientService.findByEmail(user.getEmail());
        if(patient.getPassword().equals(user.getPassword())){
            return ResponseEntity.ok(patient);
        }
        return (ResponseEntity<?>) ResponseEntity.internalServerError();
    }

    @GetMapping("/list")
    public List<Patient> listOfAllPatient() {
        return patientService.list();
    }

    @GetMapping("/get/{id}")
    public Patient getPatientById(@PathVariable Long id) {
        Optional<Patient> patient = patientService.findById(id);
        return patient.orElseThrow(()-> new NotFound("Le patient avec l'id " + id + " est INTROUVABLE. "));
    }

    @PostMapping("/add")
    public ResponseEntity<Patient> addPatient(@RequestBody Patient patient) {
        patient.setRole("patient");
        Patient newPatient = patientService.savePatient(patient);

        if(newPatient == null) throw new AddException("Impossible d'ajouter le patient");

        return new ResponseEntity<Patient>(patient, HttpStatus.CREATED);
    }
}
