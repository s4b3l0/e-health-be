package co.za.ehealth.eg.auth.rest;


import co.za.ehealth.eg.auth.entity.Patient;
import co.za.ehealth.eg.auth.rest.impl.GenericController;
import co.za.ehealth.eg.auth.service.PatientService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin("*")
@RequestMapping("patient")
public class PatientController extends GenericController<PatientService, Patient> {

    PatientService patientService;

    public PatientController(PatientService patientService) {
        super(patientService);
        this.patientService = patientService;
    }
}
