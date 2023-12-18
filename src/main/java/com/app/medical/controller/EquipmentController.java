package com.app.medical.controller;


import com.app.medical.controller.exceptions.AddException;
import com.app.medical.controller.exceptions.NotFound;
import com.app.medical.model.Equipment;
import com.app.medical.services.EquipmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/equipment")

public class EquipmentController {

    private final EquipmentService equipmentService;

    @Autowired
    public EquipmentController(EquipmentService equipmentService) {
        this.equipmentService = equipmentService;
    }

    // Get all equipment
    @GetMapping
    public ResponseEntity<List<Equipment>> getAllEquipment() {
        List<Equipment> equipmentList = equipmentService.getAllEquipment();
        return new ResponseEntity<>(equipmentList, HttpStatus.OK);
    }

    // Get equipment by ID
    @GetMapping("/{id}")
    public ResponseEntity<Equipment> getEquipmentById(@PathVariable Long id) {
        try {
            Equipment equipment = equipmentService.findEquipmentById(id)
                    .orElseThrow(() -> new NotFound("Equipment not found with ID: " + id));
            return new ResponseEntity<>(equipment, HttpStatus.OK);
        } catch (NotFound e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Create or update equipment
    @PostMapping
    public ResponseEntity<Equipment> createOrUpdateEquipment(@RequestBody Equipment equipment) {
        try {
            Equipment savedEquipment = equipmentService.saveEquipment(equipment);
            return new ResponseEntity<>(savedEquipment, HttpStatus.CREATED);
        } catch (IllegalArgumentException e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    // Delete equipment by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEquipment(@PathVariable Long id) {
        try {
            equipmentService.deleteEquipment(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (NotFound e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}