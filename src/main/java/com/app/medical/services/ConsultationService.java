package com.app.medical.services;

import com.app.medical.model.Appointement;
import com.app.medical.model.Consultation;
import com.app.medical.model.Prescription;
import com.app.medical.repository.AppointementRepo;
import com.app.medical.repository.ConsultationRepo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ConsultationService {
    private ConsultationRepo consultationRepo;


    public ConsultationService(ConsultationRepo consultationRepo) {
        this.consultationRepo =consultationRepo ;
    }

    public List<Consultation> list(){return this.consultationRepo.findAll();}

    public Optional<Consultation> findById(Long id){return this.consultationRepo.findById(id);}

    public  Consultation saveConsultation(Consultation consultation){
        return this.consultationRepo.save(consultation);
    }

    //méthode de suppression Rendez-vous
    public  void  deleteConsultation(Long id) {

        /*if(id != null) {
            this.teamRepository.deleteById(id);
        }  else   {
            throw new TeamInvalidException("Suppression échoué :");
        }*/
        this.consultationRepo.deleteById(id);

    }









}
