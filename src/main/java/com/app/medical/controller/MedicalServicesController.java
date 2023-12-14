package com.app.medical.controller;

import com.app.medical.controller.exceptions.AddException;
import com.app.medical.controller.exceptions.NotFound;
import com.app.medical.model.MedicalServices;
import com.app.medical.services.MedicalServices_Service;
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
    MedicalServices_Service medicalservices;

    @GetMapping("/list")
    public List<MedicalServices> listOfAllMedicalServices() {
        return medicalservices.list();
    }

    @GetMapping("/get/{id}")
    public MedicalServices getMedicalServiceById(@PathVariable Long id) {
        Optional<MedicalServices> medicalfile = medicalservices.findById(id);
        return medicalfile.orElseThrow(()-> new NotFound("Le medicalService avec l'id " + id + " est INTROUVABLE. "));
    }

    @PostMapping("/add")
    public ResponseEntity<MedicalServices> addMedicalService(@RequestBody MedicalServices medicalServices) {

        MedicalServices newMedicalServices = medicalservices.saveMedicalServices(medicalServices) ;

        if(newMedicalServices == null) throw new AddException("Impossible d'ajouter le MedicalService");

        return new ResponseEntity<MedicalServices>(medicalServices, HttpStatus.CREATED);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteMedicalFile(@PathVariable Long id) {

        medicalservices.deleteMedicalServices(id);

        return ResponseEntity.noContent().build();
    }
}
