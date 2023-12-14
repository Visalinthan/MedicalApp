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
@RequestMapping("/appointement")
public class AppointementController {
    @Autowired
    AppointementService  appointementService;

    @GetMapping("/list")
    public List<Appointement> listOfAllAppointements() {
        return appointementService.list();
    }

    @GetMapping("/get/{id}")
    public Appointement getAppointmentById(@PathVariable Long id) {
        Optional<Appointement> appointement = appointementService.findById(id);
        return appointement.orElseThrow(()-> new NotFound("Le appointement avec l'id " + id + " est INTROUVABLE. "));
    }

    @PostMapping("/add")
    public ResponseEntity<Appointement> addAppointements(@RequestBody Appointement appointement) {

        Appointement newAppointement = appointementService.saveAppointement(appointement);

        if(newAppointement == null) throw new AddException("Impossible d'ajouter le rendez-vous");

        return new ResponseEntity<Appointement>(appointement, HttpStatus.CREATED);
    }


    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteAppointement(@PathVariable Long id) {

        appointementService.deleteAppointement(id);

         return ResponseEntity.noContent().build();
    }
}