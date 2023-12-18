package com.app.medical.controller;

import com.app.medical.controller.exceptions.NotFound;
import com.app.medical.model.MedicalFile;
import com.app.medical.services.MedicalFileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("api/medicalfile")
public class MedicalFileController {
    private final MedicalFileService medicalFileService;

    @Autowired
    public MedicalFileController(MedicalFileService medicalFileService) {
        this.medicalFileService = medicalFileService;
    }

    // Get all medical files
    @GetMapping
    public ResponseEntity<List<MedicalFile>> getAllMedicalFiles() {
        List<MedicalFile> medicalFileList = medicalFileService.getAllMedicalFiles();
        return new ResponseEntity<>(medicalFileList, HttpStatus.OK);
    }

    // Get medical file by ID
    @GetMapping("/{id}")
    public ResponseEntity<Object> getMedicalFileById(@PathVariable Long id) {
        try {
            MedicalFile medicalFile = medicalFileService.findMedicalFileById(id)
                    .orElseThrow(() -> new NotFound("Medical file not found with ID: " + id));
            return new ResponseEntity<>(medicalFile, HttpStatus.OK);
        } catch (NotFound e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    // Create or update medical file
    @PostMapping
    public ResponseEntity<Object> createOrUpdateMedicalFile(@RequestBody MedicalFile medicalFile) {
        try {
            MedicalFile savedMedicalFile = medicalFileService.saveMedicalFile(medicalFile);
            return new ResponseEntity<>(savedMedicalFile, HttpStatus.CREATED);
        } catch (IllegalArgumentException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    // Delete medical file by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteMedicalFile(@PathVariable Long id) {
        try {
            medicalFileService.deleteMedicalFile(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (NotFound e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

}