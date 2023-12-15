package com.app.medical.controller;

import com.app.medical.controller.exceptions.AddException;
import com.app.medical.controller.exceptions.NotFound;
import com.app.medical.model.Appointement;
import com.app.medical.model.Consultation;
import com.app.medical.model.MedicalFile;
import com.app.medical.model.Patient;
import com.app.medical.repository.PatientRepo;
import com.app.medical.services.AppointementService;
import com.app.medical.services.ConsultationService;
import com.app.medical.services.MedicalFileService;
import com.app.medical.services.PrescriptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/medicalfile")
public class MedicalFileController {
    @Autowired
    MedicalFileService medicalFileService;

    @Autowired
    PatientRepo patientRepo;

    @Autowired
    AppointementService appointementservice;

    @Autowired
    ConsultationService consultationService;

    @Autowired
    PrescriptionService prescriptionService;

    @GetMapping("/list")
    public List<MedicalFile> listOfAllMedicalFiles() {
        return medicalFileService.list();
    }

    @GetMapping("/get/{id}")
    public MedicalFile getMedicalFileById(@PathVariable Long id) {
        Optional<MedicalFile> medicalfile = medicalFileService.findById(id);
        return medicalfile.orElseThrow(() -> new NotFound("Le medicalFile avec l'id " + id + " est INTROUVABLE. "));
    }

    @PostMapping("/add")
    public ResponseEntity<MedicalFile> addMedicalFiles(@RequestBody MedicalFile medicalfile) {

        MedicalFile newMedicalFile = medicalFileService.saveMedicalFile(medicalfile);

        if (newMedicalFile == null) throw new AddException("Impossible d'ajouter le MedicalFile");

        return new ResponseEntity<MedicalFile>(medicalfile, HttpStatus.CREATED);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteMedicalFile(@PathVariable Long id) {

        medicalFileService.deleteMedicalFile(id);

        return ResponseEntity.noContent().build();
    }

    @GetMapping("/listStatApppointement/{id}")
    public HashMap<String, String> getStatistiquesAppointById(@PathVariable Long id) {
        HashMap<String, String> statistiques = new HashMap<>();

        // Retrieve the patient

        // Count appointments
        int nbAppointments = appointementservice.getAppointmentsById(id).size();

        statistiques.put("appointments", String.valueOf(nbAppointments));
        return statistiques;
    }


    @GetMapping("/listStatConsultations/{id}")
    public HashMap<String, String> getStatistiquesConsultById(@PathVariable Long id) {
        HashMap<String, String> statistiques = new HashMap<>();

        // Retrieve the patient

        // Count appointments
        int nbConsultations = consultationService.getConsultationById(id).size();
        statistiques.put("Consultations", String.valueOf(nbConsultations));
        return statistiques;
    }


    @GetMapping("/listStatPrescriptions/{id}")
    public HashMap<String, String> getStatistiquesPrescriptionsById(@PathVariable  Long id) {
        HashMap<String, String> statistiques = new HashMap<>();

        // Retrieve the patient

        // Count appointments
        int nbPrescriptions = prescriptionService.getPrescriptionById(id).size();
        statistiques.put("Prescriptions", String.valueOf(nbPrescriptions));
        return statistiques;
    }

    //Pour claculer le total de tous
    @GetMapping("/Totaltarif")
    public HashMap<String, String> calculerTotalTarif(Long id) {
        HashMap<String, String> statistiques = new HashMap<>();

        // Retrieve the patient
        Patient patient = patientRepo.findById(id).orElse(null);

        if (patient != null) {
            // Use your service to get appointments for the patient
            List<Appointement> appointments = appointementservice.getAppointmentsById(id);

            List<Consultation> consult = consultationService.getConsultationById(id);

            // Calculate total tariff
            double totalTarif = appointments.stream()
                    .flatMap(consults -> consultationService.getConsultationById(id).stream()).
                    mapToDouble(consultation -> {
                        // Use your service to get the price of the consultation
                        return consultationService.getConsultationPriceById(id);
                    })
                    .sum();

            // statistiques.put("totalTarif", String.valueOf(totalTarif));
            return statistiques;
        } else {
            statistiques.put("error", "Patient not found");
            return statistiques;
        }
        //}*/


    }


}