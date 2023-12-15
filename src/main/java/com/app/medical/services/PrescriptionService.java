package com.app.medical.services;


import com.app.medical.model.Prescription;

import com.app.medical.repository.PrescriptionRepo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PrescriptionService {
    private PrescriptionRepo prescriptionRepo;


    public PrescriptionService(PrescriptionRepo prescriptionRepo) {
        this.prescriptionRepo =prescriptionRepo ;
    }

    public List<Prescription> list(){return this.prescriptionRepo.findAll();}

    public Optional<Prescription> findById(Long id){return this.prescriptionRepo.findById(id);}

    public  Prescription savePrescription(Prescription prescription){
        return this.prescriptionRepo.save(prescription);
    }

    //méthode de suppression Rendez-vous
    public  void  deletePrescription(Long id) {

        /*if(id != null) {
            this.teamRepository.deleteById(id);
        }  else   {
            throw new TeamInvalidException("Suppression échoué :");
        }*/
        this.prescriptionRepo.deleteById(id);

    }




    public List<Prescription>  getPrescriptionById(Long id) {
        return this.prescriptionRepo.findAllById(id);
    }






}
