package com.app.medical.controller;

import com.app.medical.controller.exceptions.NotFound;
import com.app.medical.model.Specialities;
import com.app.medical.services.SpecialitiesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/medicalservices")
public class SpecialitiesController {

    @Autowired
    SpecialitiesService specialitiesService;

    @GetMapping("/list")
    public List<Specialities> listOfAllMedicalServices() {
        return specialitiesService.getAllMedicalServices();
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<Object> getMedicalServiceById(@PathVariable Long id) {
        try {
            Specialities specialities = specialitiesService.findMedicalServiceById(id)
                    .orElseThrow(() -> new NotFound("Medical service not found with ID: " + id));
            return new ResponseEntity<>(specialities, HttpStatus.OK);
        } catch (NotFound e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/add")
    public ResponseEntity<Object> addMedicalService(@RequestBody Specialities specialities) {
        try {
            Specialities newSpecialities = specialitiesService.saveMedicalServices(specialities);
            return new ResponseEntity<>(newSpecialities, HttpStatus.CREATED);
        } catch (IllegalArgumentException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Object> deleteMedicalService(@PathVariable Long id) {
        try {
            specialitiesService.deleteMedicalServices(id);
            return ResponseEntity.noContent().build();
        } catch (NotFound e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }
}