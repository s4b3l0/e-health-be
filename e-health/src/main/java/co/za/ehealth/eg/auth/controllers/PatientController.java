package co.za.ehealth.eg.auth.controllers;


import co.za.ehealth.eg.auth.entity.Patient;
import co.za.ehealth.eg.auth.controllers.impl.GenericController;
import co.za.ehealth.eg.auth.service.PatientService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.NoSuchAlgorithmException;

@RestController
@CrossOrigin("*")
@RequestMapping("patient")
public class PatientController extends GenericController<PatientService, Patient, Long> {

    PatientService patientService;

    public PatientController(PatientService patientService) {
        super(patientService);
        this.patientService = patientService;
    }
    @PostMapping("/createUser/{password}")
    public ResponseEntity<Patient> createUser(@PathVariable String password, @RequestBody Patient patient) throws NoSuchAlgorithmException {
        return ResponseEntity.ok((Patient) this.patientService.createUser(password, patient));
    }
}
