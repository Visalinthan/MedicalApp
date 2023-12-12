package com.app.medical.controller;

import com.app.medical.controller.exceptions.AddException;
import com.app.medical.controller.exceptions.NotFound;
import com.app.medical.model.MedicalFile;
import com.app.medical.services.MedicalFileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/medicalfile")
public class MedicalFileController {
    @Autowired
    MedicalFileService medicalFileService;

    @GetMapping("/list")
    public List<MedicalFile> listOfAllMedicalFiles() {
        return medicalFileService.list();
    }

    @GetMapping("/get/{id}")
    public MedicalFile getMedicalFileById(@PathVariable Long id) {
        Optional<MedicalFile> medicalfile = medicalFileService.findById(id);
        return medicalfile.orElseThrow(()-> new NotFound("Le medicalFile avec l'id " + id + " est INTROUVABLE. "));
    }

    @PostMapping("/add")
    public ResponseEntity<MedicalFile> addMedicalFiles(@RequestBody MedicalFile medicalfile) {

        MedicalFile newMedicalFile = medicalFileService.saveMedicalFile(medicalfile);

        if(newMedicalFile == null) throw new AddException("Impossible d'ajouter le MedicalFile");

        return new ResponseEntity<MedicalFile>(medicalfile, HttpStatus.CREATED);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteMedicalFile(@PathVariable Long id) {

         medicalFileService.deleteMedicalFile(id);

         return ResponseEntity.noContent().build();
    }
}