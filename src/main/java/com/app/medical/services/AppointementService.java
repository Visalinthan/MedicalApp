package com.app.medical.services;

import com.app.medical.model.Appointement;

import com.app.medical.repository.AppointementRepo;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AppointementService {
    private AppointementRepo  appointementRepo;


    public AppointementService(AppointementRepo appointementRepo) {
        this.appointementRepo =appointementRepo ;
    }

    public List<Appointement> list(){return this.appointementRepo.findAll();}

    public Optional<Appointement> findById(Long id){return this.appointementRepo.findById(id);}

    public  Appointement saveAppointement(Appointement appointement){
        return this.appointementRepo.save(appointement);
    }

    //méthode de suppression Rendez-vous
    public  void  deleteAppointement(Long id) {

        /*if(id != null) {
            this.teamRepository.deleteById(id);
        }  else   {
            throw new TeamInvalidException("Suppression échoué :");
        }*/
        this.appointementRepo.deleteById(id);

    }




}
