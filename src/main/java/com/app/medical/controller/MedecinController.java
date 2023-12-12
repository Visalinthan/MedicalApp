package com.app.medical.controller;

import com.app.medical.controller.exceptions.AddException;
import com.app.medical.controller.exceptions.NotFound;
import com.app.medical.model.Medecin;
import com.app.medical.services.MedecinService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/medecin")
public class MedecinController {
    @Autowired
    MedecinService medecinService;

    @GetMapping("/list")
    public List<Medecin> listOfAllMedecin() {
        return medecinService.list();
    }

    @GetMapping("/get/{id}")
    public Medecin getMedecinById(@PathVariable Long id) {
        Optional<Medecin> medecin = medecinService.findById(id);
        return medecin.orElseThrow(()-> new NotFound("Le medecin avec l'id " + id + " est INTROUVABLE. "));
    }

    @PostMapping("/add")
    public ResponseEntity<Medecin> addMedecin(@RequestBody Medecin medecin) {

        Medecin newMedecin = medecinService.saveMedecin(medecin);

        if(newMedecin == null) throw new AddException("Impossible d'ajouter le medecin");

        return new ResponseEntity<Medecin>(medecin, HttpStatus.CREATED);
    }
}