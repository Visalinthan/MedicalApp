package com.app.medical.services;


import com.app.medical.model.MedicalFile;
import com.app.medical.repository.MedicalFileRepo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MedicalFileService {
    private MedicalFileRepo medicalfileRepo;


    public MedicalFileService(MedicalFileRepo medicalfileRepo) {
        this.medicalfileRepo =medicalfileRepo ;
    }

    public List<MedicalFile> list(){return this.medicalfileRepo.findAll();}

    public Optional<MedicalFile> findById(Long id){return this.medicalfileRepo.findById(id);}

    public  MedicalFile saveMedicalFile(MedicalFile medicalfile){
        return this.medicalfileRepo.save(medicalfile);
    }

    //méthode de suppression Rendez-vous
    public  void  deleteMedicalFile(Long id) {

        /*if(id != null) {
            this.teamRepository.deleteById(id);
        }  else   {
            throw new TeamInvalidException("Suppression échoué :");
        }*/
        this.medicalfileRepo.deleteById(id);

    }






}
