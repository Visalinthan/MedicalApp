package com.app.medical.controller;

import com.app.medical.controller.exceptions.NotFound;
import com.app.medical.model.Ilness;
import com.app.medical.services.IllnessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/illness")
public class IllnessController {

    @Autowired
    IllnessService ilnessService;

    @GetMapping("/list")
    public List<Ilness> getAllIllnesses() {
        return ilnessService.getAllIllnesses();
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<Object> getIlnessById(@PathVariable Long id) {
        try {
            Ilness ilness = ilnessService.findIlnessById(id)
                    .orElseThrow(() -> new NotFound("Illness not found with ID: " + id));
            return new ResponseEntity<>(ilness, HttpStatus.OK);
        } catch (NotFound e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/add")
    public ResponseEntity<Object> addIlness(@RequestBody Ilness ilness) {
        try {
            Ilness newIlness = ilnessService.saveIlness(ilness);
            return new ResponseEntity<>(newIlness, HttpStatus.CREATED);
        } catch (IllegalArgumentException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Object> deleteIlness(@PathVariable Long id) {
        try {
            ilnessService.deleteIlness(id);
            return ResponseEntity.noContent().build();
        } catch (NotFound e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }
}
