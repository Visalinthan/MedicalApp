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
@RequestMapping("/api/equipment")
public class EquipmentController {
    @Autowired
    EquipmentService  equipmentService;

    @GetMapping("/list")
    public List<Equipment> listOfAllEquipments() {
        return equipmentService.list();
    }

    @GetMapping("/get/{id}")
    public Equipment getEquipmentById(@PathVariable Long id) {
        Optional<Equipment> appointement = equipmentService.findById(id);
        return appointement.orElseThrow(()-> new NotFound("Le equipement avec l'id " + id + " est INTROUVABLE. "));
    }

    @PostMapping("/add")
    public ResponseEntity<Equipment> addEquipments(@RequestBody Equipment equipment) {

        Equipment newEquipment = equipmentService.saveEquipment(equipment);

        if(newEquipment == null) throw new AddException("Impossible d'ajouter le equipement");

        return new ResponseEntity<Equipment>(equipment, HttpStatus.CREATED);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteEquipment(@PathVariable Long id) {

        equipmentService.deleteEquipment(id);

         return ResponseEntity.noContent().build();
    }
}