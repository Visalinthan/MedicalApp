package com.app.medical.services;

import com.app.medical.model.Medecin;
import com.app.medical.model.Patient;
import com.app.medical.repository.MedecinRepo;
import com.app.medical.repository.PatientRepo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MedecinService {
    private MedecinRepo medecinRepo;


    public MedecinService(MedecinRepo medecinRepo) {
        this.medecinRepo = medecinRepo;
    }

    public List<Medecin> list(){return this.medecinRepo.findAll();}

    public Optional<Medecin> findById(Long id){return this.medecinRepo.findById(id);}

    public Medecin saveMedecin(Medecin medecin){
        return this.medecinRepo.save(medecin);
    }

    //méthode de suppression médecin
    public  void  deleteMedecin(Long id) {

        /*if(id != null) {
            this.teamRepository.deleteById(id);
        }  else   {
            throw new TeamInvalidException("Suppression échoué :");
        }*/
        this.medecinRepo.deleteById(id);

    }




}
