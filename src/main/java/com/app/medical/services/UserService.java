package com.app.medical.services;

import com.app.medical.repository.MedecinRepo;
import com.app.medical.repository.PatientRepo;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private PatientRepo patientRepo;
    private MedecinRepo medecinRepo;

    public UserService(PatientRepo patientRepo, MedecinRepo medecinRepo) {
        this.patientRepo = patientRepo;
        this.medecinRepo = medecinRepo;
    }


}
