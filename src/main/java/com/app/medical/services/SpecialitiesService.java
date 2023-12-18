package com.app.medical.services;


import com.app.medical.model.Specialities;
import com.app.medical.repository.MedicalServicesRepo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MedicalServices_Service {
    private MedicalServicesRepo  medicalServicesRepo;


    public MedicalServices_Service(MedicalServicesRepo medicalServicesRepo) {
        this.medicalServicesRepo = medicalServicesRepo ;
    }

    public List<Specialities> list(){return this.medicalServicesRepo.findAll();}

    public Optional<Specialities> findById(Long id){return this.medicalServicesRepo.findById(id);}

    public Specialities saveMedicalServices(Specialities specialities){
        return this.medicalServicesRepo.save(specialities);
    }

    //méthode de suppression Rendez-vous
    public  void  deleteMedicalServices(Long id) {

        /*if(id != null) {
            this.teamRepository.deleteById(id);
        }  else   {
            throw new TeamInvalidException("Suppression échoué :");
        }*/
        this.medicalServicesRepo.deleteById(id);

    }




}
