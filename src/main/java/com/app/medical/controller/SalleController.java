package com.app.medical.controller;

import com.app.medical.controller.exceptions.NotFound;
import com.app.medical.model.Salle;
import com.app.medical.services.SalleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/salle")
public class SalleController {

    @Autowired
    SalleService salleService;

    @GetMapping("/list")
    public List<Salle> getAllRooms() {
        return salleService.getAllRooms();
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<Object> getRoomById(@PathVariable Long id) {
        try {
            Salle salle = salleService.findRoomById(id)
                    .orElseThrow(() -> new NotFound("Room not found with ID: " + id));
            return new ResponseEntity<>(salle, HttpStatus.OK);
        } catch (NotFound e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/add")
    public ResponseEntity<Object> addRoom(@RequestBody Salle salle) {
        try {
            Salle newSalle = salleService.saveRoom(salle);
            return new ResponseEntity<>(newSalle, HttpStatus.CREATED);
        } catch (IllegalArgumentException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Object> deleteRoom(@PathVariable Long id) {
        try {
            salleService.deleteRoom(id);
            return ResponseEntity.noContent().build();
        } catch (NotFound e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }
}
