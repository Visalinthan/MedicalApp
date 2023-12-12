package com.app.medical.services;

import com.app.medical.model.Patient;
import com.app.medical.repository.PatientRepo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PatientService {
    private PatientRepo patientRepo;


    public PatientService(PatientRepo patientRepo) {
        this.patientRepo = patientRepo;
    }

    public List<Patient> list(){return this.patientRepo.findAll();}

    public Optional<Patient> findById(Long id){return this.patientRepo.findById(id);}

    public Patient savePatient(Patient patient){
        return this.patientRepo.save(patient);
    }

    public  void  deletePatient(Long id) {

        /*if(id != null) {
            this.teamRepository.deleteById(id);
        }  else   {
            throw new TeamInvalidException("Suppression échoué :");
        }*/
        this.patientRepo.deleteById(id);

    }
}
