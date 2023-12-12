package com.app.medical.services;


import com.app.medical.model.Equipment;
import com.app.medical.repository.EquipmentRepo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EquipmentService {
    private EquipmentRepo  equipmentRepo;


    public EquipmentService(EquipmentRepo equipmentRepo) {
        this.equipmentRepo =equipmentRepo ;
    }

    public List<Equipment> list(){return this.equipmentRepo.findAll();}

    public Optional<Equipment> findById(Long id){return this.equipmentRepo.findById(id);}

    public  Equipment saveEquipment(Equipment equipment){
        return this.equipmentRepo.save(equipment);
    }

    //méthode de suppression Rendez-vous
    public  void  deleteEquipment(Long id) {

        /*if(id != null) {
            this.teamRepository.deleteById(id);
        }  else   {
            throw new TeamInvalidException("Suppression échoué :");
        }*/
        this.equipmentRepo.deleteById(id);

    }




}
