package com.app.medical.controller;

import com.app.medical.controller.exceptions.AddException;
import com.app.medical.controller.exceptions.NotFound;
import com.app.medical.model.Specialities;
import com.app.medical.services.SpecialitiesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/medicalservices")
public class MedicalServicesController {
    @Autowired
    SpecialitiesService medicalservices;

    @GetMapping("/list")
    public List<Specialities> listOfAllMedicalServices() {
        return medicalservices.list();
    }

    @GetMapping("/get/{id}")
    public Specialities getMedicalServiceById(@PathVariable Long id) {
        Optional<Specialities> medicalfile = medicalservices.findById(id);
        return medicalfile.orElseThrow(()-> new NotFound("Le medicalService avec l'id " + id + " est INTROUVABLE. "));
    }

    @PostMapping("/add")
    public ResponseEntity<Specialities> addMedicalService(@RequestBody Specialities specialities) {

        Specialities newSpecialities = medicalservices.saveMedicalServices(specialities) ;

        if(newSpecialities == null) throw new AddException("Impossible d'ajouter le MedicalService");

        return new ResponseEntity<Specialities>(specialities, HttpStatus.CREATED);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteMedicalFile(@PathVariable Long id) {

        medicalservices.deleteMedicalServices(id);

        return ResponseEntity.noContent().build();
    }
}