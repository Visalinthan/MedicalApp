package com.app.medical.services;


import com.app.medical.model.MedicalServices;
import com.app.medical.repository.MedicalServicesRepo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MedicalServices_Service {
    private MedicalServicesRepo  medicalServicesRepo;


    public MedicalServices_Service(MedicalServicesRepo medicalServicesRepo) {
        this.medicalServicesRepo =medicalServicesRepo ;
    }

    public List<MedicalServices> list(){return this.medicalServicesRepo.findAll();}

    public Optional<MedicalServices> findById(Long id){return this.medicalServicesRepo.findById(id);}

    public  MedicalServices saveAppointement(MedicalServices medicalServices){
        return this.medicalServicesRepo.save(medicalServices);
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
