package co.za.ehealth.eg.auth.service;

import co.za.ehealth.eg.auth.entity.Patient;
import co.za.ehealth.eg.auth.repo.PatientRepository;
import co.za.ehealth.eg.auth.service.impl.GenericService;
import org.springframework.stereotype.Service;

@Service
public class PatientService extends GenericService<PatientRepository ,Patient> {
    PatientRepository patientRepository;

    public PatientService(PatientRepository repository) {
        super(repository);
        this.patientRepository = repository;
    }

}
