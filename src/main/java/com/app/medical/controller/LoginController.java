package com.app.medical.controller;

import com.app.medical.controller.exceptions.AddException;
import com.app.medical.dto.UserDto;
import com.app.medical.model.Medecin;
import com.app.medical.model.Patient;
import com.app.medical.model.User;
import com.app.medical.services.MedecinService;
import com.app.medical.services.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class LoginController {

    @Autowired
    PatientService patientService;

    @Autowired
    MedecinService medecinService;


    @PostMapping("/login")
    public ResponseEntity<?> loginUser(@RequestBody UserDto userDto){

        if(patientService.findByEmail(userDto.getEmail()) != null){
           Patient patient = patientService.findByEmail(userDto.getEmail());
            if(patient.getPassword().equals(userDto.getPassword())){
                return ResponseEntity.ok(patient);
            }
        }
        else if(medecinService.findByEmail(userDto.getEmail()) != null){
            Medecin medecin = medecinService.findByEmail(userDto.getEmail());
            if(medecin.getPassword().equals(userDto.getPassword())){
                return ResponseEntity.ok(medecin);
            }
        }

        return (ResponseEntity<?>) ResponseEntity.internalServerError();

    }
}
